package fi.experis.mefit.service;

import fi.experis.mefit.models.Goal;

import java.util.List;

public interface GoalService {
    Goal addGoal(Goal goal);
    Goal getGoalById(Long goalId);
    void updateGoal(Long goalId, Goal goal);
    void deleteGoalById(Long goal);
    List<Goal> getAllGoals();

}
