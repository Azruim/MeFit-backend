package fi.experis.mefit.services.interfaces;

import fi.experis.mefit.models.dtos.goalDto.get.GoalGetDTO;
import fi.experis.mefit.models.dtos.goalDto.post.GoalPostDTO;
import org.springframework.http.ResponseEntity;

public interface GoalService {
    ResponseEntity<String> addGoal(GoalPostDTO goal);
    ResponseEntity<GoalGetDTO> getGoalById(Long goalId);
    ResponseEntity<String> updateGoal(Long goalId, GoalPostDTO goal);
    ResponseEntity<String> deleteGoalById(Long goal);
}
