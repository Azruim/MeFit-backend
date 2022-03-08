package fi.experis.mefit.services;

import fi.experis.mefit.models.Goal;
import fi.experis.mefit.repositories.GoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoalServiceImpl implements GoalService {
    @Autowired
    private GoalRepository goalRepository;
    @Override
    public Goal addGoal(Goal goal) {
        return goalRepository.save(goal);
    }
    @Override
    public Goal getGoalById(Long goalId) {
        return goalRepository.findById(goalId).get();
    }
    @Override
    public List<Goal> getAllGoals(){
        return goalRepository.findAll();
    }

    @Override
    public void updateGoal(Long goalId, Goal goal) {
        // check if the user with the passed id exists or not
        if (goalRepository.findById(goalId).isPresent()) {
            // If user exists then updated
            goalRepository.save(goal);
        }
    }

    @Override
    public void deleteGoalById(Long goalId) {
        try {
            goalRepository.deleteById(goalId);
        }catch(DataAccessException e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
