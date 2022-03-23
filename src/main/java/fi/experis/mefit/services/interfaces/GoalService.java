package fi.experis.mefit.services.interfaces;

import fi.experis.mefit.models.dtos.GoalDTO;
import fi.experis.mefit.models.entities.Goal;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface GoalService {
    ResponseEntity<String> addGoal(GoalDTO goal);
    ResponseEntity<Goal> getGoalById(Long goalId);
    ResponseEntity<String> updateGoal(Long goalId, Map<Object, Object> fields);
    ResponseEntity<String> deleteGoalById(Long goal);
}
