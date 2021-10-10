package io.brainframe.ipldashboard.repository;

import org.springframework.data.repository.CrudRepository;

import io.brainframe.ipldashboard.model.Team;

public interface TeamRepository extends CrudRepository<Team, Long>{

   Team findByTeamName(String teamName);
    
}
