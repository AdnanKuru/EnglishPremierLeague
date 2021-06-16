    package com.adnankuru.englishpremierleague.controller;

    import com.adnankuru.englishpremierleague.model.Match;
    import com.adnankuru.englishpremierleague.model.Team;
    import com.adnankuru.englishpremierleague.repository.MatchRepository;
    import com.adnankuru.englishpremierleague.repository.TeamRepository;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.data.domain.PageRequest;
    import org.springframework.data.domain.Pageable;
    import org.springframework.web.bind.annotation.*;

    import java.time.LocalDate;
    import java.util.List;


    @RestController
    @CrossOrigin
    public class TeamController {

        private TeamRepository teamRepository;
        private MatchRepository matchRepository;

        @Autowired
        public TeamController(TeamRepository teamRepository,MatchRepository matchRepository){
            this.teamRepository = teamRepository;
            this.matchRepository = matchRepository;
        }

        @GetMapping("/team")
        public Iterable<Team> getAllTeam(){
            return this.teamRepository.findAll();
        }

        @GetMapping("/team/{teamName}")
        public Team getTeam(@PathVariable String teamName){
            Team team = this.teamRepository.findByTeamName(teamName);
            team.setMatches(matchRepository.findLatestMatchesbyTeam(teamName,4));
            return team;
        }

        @GetMapping("/team/{teamName}/matches")
        public List<Match> getMatchesForTeam(@PathVariable String teamName, @RequestParam int year){
            LocalDate startDate = LocalDate.of(year,1,1);
            LocalDate endDate = LocalDate.of(year + 1 ,1,1);

            return this.matchRepository.getMatchesByTeamBetweenDates(teamName, startDate, endDate);
        }
    }
