package fi.experis.mefit.services.implementations;

import fi.experis.mefit.models.entities.Goal;
import fi.experis.mefit.repositories.GoalRepository;
import fi.experis.mefit.services.interfaces.GoalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class GoalServiceImpl implements GoalService {

    private final GoalRepository goalRepository;
    TimeZone utc = TimeZone.getTimeZone("UTC");
    SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");

    public GoalServiceImpl(GoalRepository goalRepository) {
        this.goalRepository = goalRepository;
    }

    @Override
    public ResponseEntity<String> addGoal(Goal goal) {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("/api/v1/goals/" + goalRepository.save(goal).getGoalId());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<Goal> getGoalById(Long goalId) {
        try {
            if (goalRepository.findById(goalId).isPresent()) {
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body(goalRepository.findById(goalId).get());
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<String> updateGoal(Long goalId, Map<Object, Object> fields) {
        try {
            Optional<Goal> goal = goalRepository.findById(goalId);
            if (goal.isPresent()) {
                fields.forEach((Object key, Object value) -> {
                    Field field = ReflectionUtils.findField(Goal.class, (String) key);
                    assert field != null;
                    field.trySetAccessible();
                    if (key == "endDate" || key == "startDate") {
                        try {
                            f.setTimeZone(utc);
                            Date date = f.parse(value.toString());
                            ReflectionUtils.setField(field, goal.get(), date);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    } else {
                        ReflectionUtils.setField(field, goal.get(), value);
                    }

                });
                Goal updatedGoal = goalRepository.save(goal.get());
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body("/api/v1/goals/" + updatedGoal.getGoalId());
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<String> deleteGoalById(Long goalId) {
        try {
            goalRepository.deleteById(goalId);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(RuntimeException e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
