package com.adnankuru.englishpremierleague.data;

import com.adnankuru.englishpremierleague.model.Team;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {
    private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);

    private final EntityManager entityManager;

    @Autowired
    public JobCompletionNotificationListener(EntityManager entityManager){
        this.entityManager = entityManager;
    }


    @Override
    @Transactional
    public void afterJob(JobExecution jobExecution){
        if(jobExecution.getStatus() == BatchStatus.COMPLETED){
            log.info("!!! JOB FINISHED! Time to verify the results");

            Map<String, Team> teamData = new HashMap<>();

            entityManager.createQuery("select m.homeTeam, count(*) from Match m group by  m.homeTeam",Object[].class)
                    .getResultList()
                    .stream()
                    .map(e -> new Team((String)e[0],(long)e[1]))
                    .forEach(team -> teamData.put(((Team) team).getTeamName(),team));

            entityManager.createQuery("select m.awayTeam, count(*) from Match m group by  m.awayTeam",Object[].class)
                    .getResultList()
                    .stream()
                    .forEach(e -> {
                        Team team = teamData.get((String) e[0]);
                        team.setTotalMatches(team.getTotalMatches() + (long) e[1]);
                    });

            entityManager.createQuery("select m.matchWinner, count(*) from Match m group by m.matchWinner",Object[].class)
                    .getResultList()
                    .stream()
                    .forEach(e -> {
                        Team team = teamData.get((String) e[0]);
                        if(team != null) {team.setTotalWins((long) e[1]);}
                    });

            entityManager.createQuery("select m.matchLoser, count(*) from Match m group by m.matchLoser",Object[].class)
                    .getResultList()
                    .stream()
                    .forEach(e -> {
                        Team team = teamData.get((String) e[0]);
                        if(team != null) {team.setTotalLosses((long) e[1]);}
                    });

            teamData.values().forEach(entityManager::persist);





        }
    }
}
