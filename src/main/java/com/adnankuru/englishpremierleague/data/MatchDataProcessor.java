package com.adnankuru.englishpremierleague.data;

import com.adnankuru.englishpremierleague.model.Match;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MatchDataProcessor implements ItemProcessor<MatchInput, Match> {

    private static final Logger log = LoggerFactory.getLogger(MatchDataProcessor.class);



    @Override
    public Match process(final MatchInput matchInput) throws Exception{
        Match match = new Match();

        if(matchInput.getDate().length() == 10){
            DateTimeFormatter formatters = DateTimeFormatter.ofPattern("d/MM/uuuu");
            match.setDate(LocalDate.parse(matchInput.getDate(),formatters));
        }else{
            DateTimeFormatter formatters = DateTimeFormatter.ofPattern("d/MM/uu");
            match.setDate(LocalDate.parse(matchInput.getDate(),formatters));
        }

        match.setId(Integer.parseInt(matchInput.getId()));
        match.setHomeTeam(matchInput.getHomeTeam());
        match.setAwayTeam(matchInput.getAwayTeam());
        match.setFullTimeHomeGoal(matchInput.getFTHG());
        match.setFullTimeAwayGoal(matchInput.getFTAG());
        match.setFullTimeResult(matchInput.getFTR());
        match.setHomeTeamGoalScored(matchInput.getHTGS());
        match.setAwayTeamGoalScored(matchInput.getATGS());
        match.setHomeTeamGoalCount(matchInput.getHTGC());
        match.setAwayTeamGoalCount(matchInput.getATGC());
        match.setHomeTeamPoints(matchInput.getHTP());
        match.setAwayTeamPoints(matchInput.getATP());
        match.setHomeMatch1(matchInput.getHM1());
        match.setHomeMatch2(matchInput.getHM2());
        match.setHomeMatch3(matchInput.getHM3());
        match.setHomeMatch4(matchInput.getHM4());
        match.setHomeMatch5(matchInput.getHM5());
        match.setAwayMatch1(matchInput.getAM1());
        match.setAwayMatch2(matchInput.getAM2());
        match.setAwayMatch3(matchInput.getAM3());
        match.setAwayMatch4(matchInput.getAM4());
        match.setAwayMatch5(matchInput.getAM5());
        match.setMatchWeek(matchInput.getMW());
        match.setHomeTeamFormPointsString(matchInput.getHTFormPtsStr());
        match.setAwayTeamFormPointsString(matchInput.getATFormPtsStr());
        match.setHomeTeamFormPoints(matchInput.getHTFormPts());
        match.setAwayTeamFormPoints(matchInput.getATFormPts());
        match.setHomeTeamWinStreak3(matchInput.getHTWinStreak3());
        match.setHomeTeamWinStreak5(matchInput.getHTWinStreak5());
        match.setHomeTeamLossStreak3(matchInput.getHTLossStreak3());
        match.setHomeTeamLossStreak5(matchInput.getHTLossStreak5());
        match.setAwayTeamWinStreak3(matchInput.getATWinStreak3());
        match.setAwayTeamWinStreak5(matchInput.getATWinStreak5());
        match.setAwayTeamLossStreak3(matchInput.getATLossStreak3());
        match.setAwayTeamLossStreak5(matchInput.getATLossStreak5());
        match.setHomeTeamGoalDifference(matchInput.getHTGD());
        match.setAwayTeamGoalDifference(matchInput.getATGD());
        match.setDifferenceInPoints(matchInput.getDiffPts());
        match.setDifferenceInFormPoints(matchInput.getDiffFormPts());


        if(Integer.parseInt(matchInput.getFTHG()) > Integer.parseInt( matchInput.getFTAG())){
            match.setMatchWinner(match.getHomeTeam());
            match.setMatchLoser(match.getAwayTeam());
        }
        else if(Integer.parseInt(matchInput.getFTHG()) < Integer.parseInt( matchInput.getFTAG())){
            match.setMatchWinner(match.getAwayTeam());
            match.setMatchLoser(match.getHomeTeam());
        }

        return match;
    }
}
