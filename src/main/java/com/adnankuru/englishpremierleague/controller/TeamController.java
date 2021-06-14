    package com.adnankuru.englishpremierleague.controller;

    import com.adnankuru.englishpremierleague.model.Team;
    import com.adnankuru.englishpremierleague.repository.MatchRepository;
    import com.adnankuru.englishpremierleague.repository.TeamRepository;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.data.domain.PageRequest;
    import org.springframework.data.domain.Pageable;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.PathVariable;
    import org.springframework.web.bind.annotation.RestController;


    @RestController
    public class TeamController {

        private TeamRepository teamRepository;
        private MatchRepository matchRepository;

        @Autowired
        public TeamController(TeamRepository teamRepository,MatchRepository matchRepository){
            this.teamRepository = teamRepository;
            this.matchRepository = matchRepository;
        }

        @GetMapping("/team/{teamName}")
        public Team getTeam(@PathVariable String teamName){
            Team team = this.teamRepository.findByTeamName(teamName);
            team.setMatches(matchRepository.findLatestMatchesbyTeam(teamName,4));


            return team;

        }

    }
