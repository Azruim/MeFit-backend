package fi.experis.mefit.services;

import fi.experis.mefit.models.Goal;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface GoalService {
    ResponseEntity<String> addGoal(Goal goal);
    ResponseEntity<Goal> getGoalById(Long goalId);
    ResponseEntity<String> updateGoal(Long goalId, Goal goal);
    ResponseEntity<String> deleteGoalById(Long goal);
}
