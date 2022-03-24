package fi.experis.mefit.services.interfaces;

import fi.experis.mefit.models.dtos.goalDto.GoalDTO;
import org.springframework.http.ResponseEntity;

public interface GoalService {
    ResponseEntity<String> addGoal(GoalDTO goal);
    ResponseEntity<GoalDTO> getGoalById(Long goalId);
    ResponseEntity<String> updateGoal(Long goalId, GoalDTO goal);
    ResponseEntity<String> deleteGoalById(Long goal);
}
