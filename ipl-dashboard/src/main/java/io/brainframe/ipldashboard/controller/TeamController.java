package io.brainframe.ipldashboard.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.brainframe.ipldashboard.model.Team;
import io.brainframe.ipldashboard.repository.MatchRepository;
import io.brainframe.ipldashboard.repository.TeamRepository;

@RestController
public class TeamController {


    private TeamRepository teamRepo;
    private MatchRepository matchRepo;

    
    
    public TeamController(TeamRepository teamRepo, MatchRepository matchRepo) {
        this.teamRepo = teamRepo;
        this.matchRepo = matchRepo;
    }



    @GetMapping("/team/{teamName}")
    public Team getTeam(@PathVariable String teamName) {

        Team team = teamRepo.findByTeamName(teamName); 
        team.setMatches(matchRepo.getLatestMatchesByTeam(teamName, 4)); 
        return team;      
    }
    
}
