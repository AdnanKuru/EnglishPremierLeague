package com.adnankuru.englishpremierleague.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String  teamName;
    private long totalMatches;
    private long totalWins;
    private long totalLosses;

    @Transient
    private List<Match> matches;

    public Team(String teamName, long totalMatches){
        this.teamName  = teamName;
        this.totalMatches = totalMatches;
    }

    @Override
    public String toString() {
        return "Team{" +
                "teamName='" + teamName + '\'' +
                ", totalMatches=" + totalMatches +
                ", totalWins=" + totalWins +
                ", totalWins=" + totalLosses +
                '}';
    }
}
