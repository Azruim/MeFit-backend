package fi.experis.mefit.services.interfaces;

import fi.experis.mefit.models.dtos.goalDto.GetGoalDTO;
import fi.experis.mefit.models.dtos.goalDto.CreateGoalDTO;
import org.springframework.http.ResponseEntity;

public interface GoalService {
    ResponseEntity<String> addGoal(CreateGoalDTO goal);
    ResponseEntity<GetGoalDTO> getGoalById(Long goalId);
    ResponseEntity<String> updateGoal(Long goalId, CreateGoalDTO goal);
    ResponseEntity<String> deleteGoalById(Long goal);
}
