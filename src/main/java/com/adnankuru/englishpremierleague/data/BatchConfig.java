package com.adnankuru.englishpremierleague.data;

import com.adnankuru.englishpremierleague.model.Match;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Bean
    public FlatFileItemReader<MatchInput> reader(){
        return new FlatFileItemReaderBuilder<MatchInput>()
                .name("MatchItemReader")
                .resource(new ClassPathResource("final_dataset.csv"))
                .delimited()
                .names(new String[]{"Id","Date","HomeTeam","AwayTeam","FTHG","FTAG","FTR","HTGS","ATGS","HTGC","ATGC","HTP","ATP","HM1","HM2","HM3","HM4","HM5","AM1","AM2","AM3","AM4","AM5","MW","HTFormPtsStr","ATFormPtsStr","HTFormPts","ATFormPts","HTWinStreak3","HTWinStreak5","HTLossStreak3","HTLossStreak5","ATWinStreak3","ATWinStreak5","ATLossStreak3","ATLossStreak5","HTGD","ATGD","DiffPts","DiffFormPts"})
                .fieldSetMapper(new BeanWrapperFieldSetMapper<MatchInput>(){{
                    setTargetType(MatchInput.class);
                }})
                .build();
    }

    @Bean
    public MatchDataProcessor processor(){
        return new MatchDataProcessor();
    }

    @Bean
    public JdbcBatchItemWriter<Match> writer(DataSource dataSource){
        return new JdbcBatchItemWriterBuilder<Match>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO match(id,date,home_team,away_team,full_time_home_goal,full_time_away_goal," +
                        "full_time_result,home_team_goal_scored,away_team_goal_scored,home_team_goal_count," +
                        "away_team_goal_count,home_team_points,away_team_points,home_match1,home_match2,home_match3," +
                        "home_match4,home_match5,away_match1,away_match2,away_match3,away_match4,away_match5,match_week," +
                        "home_team_form_points_string,away_team_form_points_string,home_team_form_points," +
                        "away_team_form_points,home_team_win_streak3,home_team_win_streak5,home_team_loss_streak3," +
                        "home_team_loss_streak5,away_team_win_streak3,away_team_win_streak5,away_team_loss_streak3," +
                        "away_team_loss_streak5,home_team_goal_difference,away_team_goal_difference,difference_in_points," +
                        "difference_in_form_points , match_winner , match_loser) VALUES (:id, :date, :homeTeam, :awayTeam, :fullTimeHomeGoal," +
                        " :fullTimeAwayGoal, :fullTimeResult, :homeTeamGoalScored, :awayTeamGoalScored, " +
                        ":homeTeamGoalCount, :awayTeamGoalCount, :homeTeamPoints, :awayTeamPoints, :homeMatch1," +
                        " :homeMatch2, :homeMatch3, :homeMatch4, :homeMatch5, :awayMatch1, :awayMatch2, :awayMatch3," +
                        " :awayMatch4, :awayMatch5, :matchWeek, :homeTeamFormPointsString, :awayTeamFormPointsString," +
                        " :homeTeamFormPoints, :awayTeamFormPoints, :homeTeamWinStreak3, :homeTeamWinStreak5," +
                        " :homeTeamLossStreak3, :homeTeamLossStreak5, :awayTeamWinStreak3, :awayTeamWinStreak5," +
                        " :awayTeamLossStreak3, :awayTeamLossStreak5, :homeTeamGoalDifference, :awayTeamGoalDifference," +
                        " :differenceInPoints, :differenceInFormPoints , :matchWinner , :matchLoser)")
                .dataSource(dataSource)
                .build();
    }

    @Bean
    public Job importMatchJob(JobCompletionNotificationListener listener, Step step1){
        return jobBuilderFactory.get("importMatchJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step1)
                .end()
                .build();
    }

    @Bean
    public Step step1(JdbcBatchItemWriter<Match> writer){
        return stepBuilderFactory.get("step1")
                .<MatchInput,Match> chunk(10)
                .reader(reader())
                .processor(processor())
                .writer(writer)
                .build();
    }
}
