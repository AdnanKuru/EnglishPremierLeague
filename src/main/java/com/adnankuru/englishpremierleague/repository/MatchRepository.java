package com.adnankuru.englishpremierleague.repository;

import com.adnankuru.englishpremierleague.model.Match;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;


import java.util.List;

public interface MatchRepository extends CrudRepository<Match, Integer> {
    List<Match> getByHomeTeamOrAwayTeamOrderByDateDesc(String homeTeamName, String awayTeamName, Pageable pageable);

    default List<Match> findLatestMatchesbyTeam(String teamName,int count){
        return getByHomeTeamOrAwayTeamOrderByDateDesc(teamName,teamName, PageRequest.of(0,count));
    }
}
