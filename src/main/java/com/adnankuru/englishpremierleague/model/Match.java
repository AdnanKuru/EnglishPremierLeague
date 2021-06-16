package com.adnankuru.englishpremierleague.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Entity
public class Match {

    @Id
    private int id;
    private LocalDate date;
    private String homeTeam;
    private String awayTeam;
    private String fullTimeHomeGoal;
    private String fullTimeAwayGoal;
    private String fullTimeResult;
    private String homeTeamGoalScored;
    private String awayTeamGoalScored;
    private String homeTeamGoalCount;
    private String awayTeamGoalCount;
    private String homeTeamPoints;
    private String awayTeamPoints;
    private String homeMatch1;
    private String homeMatch2;
    private String homeMatch3;
    private String homeMatch4;
    private String homeMatch5;
    private String awayMatch1;
    private String awayMatch2;
    private String awayMatch3;
    private String awayMatch4;
    private String awayMatch5;
    private String matchWeek;
    private String homeTeamFormPointsString;
    private String awayTeamFormPointsString;
    private String homeTeamFormPoints;
    private String awayTeamFormPoints;
    private String homeTeamWinStreak3;
    private String homeTeamWinStreak5;
    private String homeTeamLossStreak3;
    private String homeTeamLossStreak5;
    private String awayTeamWinStreak3;
    private String awayTeamWinStreak5;
    private String awayTeamLossStreak3;
    private String awayTeamLossStreak5;
    private String homeTeamGoalDifference;
    private String awayTeamGoalDifference;
    private String differenceInPoints;
    private String differenceInFormPoints;
    private String matchWinner;
    private String matchLoser;

}
