package fi.experis.mefit.services.implementations;

import com.fasterxml.jackson.databind.ObjectMapper;
import fi.experis.mefit.models.dtos.GoalDTO;
import fi.experis.mefit.models.dtos.ProfileDTO;
import fi.experis.mefit.models.entities.*;
import fi.experis.mefit.repositories.*;
import fi.experis.mefit.services.interfaces.GoalService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class GoalServiceImpl implements GoalService {

    private final GoalRepository goalRepository;
    private final ProfileRepository profileRepository;
    private final ProgramRepository programRepository;
    private final WorkoutRepository workoutRepository;
    private final ExerciseRepository exerciseRepository;

    /*TimeZone utc = TimeZone.getTimeZone("UTC");
    SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");*/
    private final ModelMapper modelMapper = new ModelMapper();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public GoalServiceImpl(GoalRepository goalRepository, ProfileRepository profileRepository,
                           ProgramRepository programRepository, WorkoutRepository workoutRepository,
                           ExerciseRepository exerciseRepository) {
        this.goalRepository = goalRepository;
        this.profileRepository = profileRepository;
        this.programRepository = programRepository;
        this.workoutRepository = workoutRepository;
        this.exerciseRepository = exerciseRepository;
    }

    private Goal convertToEntity(GoalDTO goalDTO) {
        Goal goal = modelMapper.map(goalDTO, Goal.class);
        if (goal.getProfile() != null) goal.setProfile(profileRepository.getById(goal.getProfile().getProfileId()));
        if (goal.getProgram() != null) goal.setProgram(programRepository.getById(goal.getProgram().getProgramId()));
        if (goal.getExercises() != null) goal.setExercises(exerciseRepository.findAllById(goal.getExercises().stream()
                .map(Exercise::getExerciseId).collect(Collectors.toList())));
        if (goal.getWorkouts() != null) goal.setWorkouts(workoutRepository.findAllById(goal.getWorkouts().stream()
                .map(Workout::getWorkoutId).collect(Collectors.toList())));
        return goal;
    }

    @Override
    public ResponseEntity<String> addGoal(GoalDTO goalDTO) {
        try {
            Goal goal = convertToEntity(goalDTO);
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
    public ResponseEntity<String> updateGoal(Long goalId, GoalDTO goalDTO) {

        Map<String, Object> map = objectMapper.convertValue(obj, Map.class);
        System.out.println(map);

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
        try {
            Optional<Goal> oldGoal = goalRepository.findById(goalId);
            if (oldGoal.isPresent()) {
                Goal goal = convertToEntity(goalDTO);
                goal.setGoalId(goalId);
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body("/api/v1/goals/" + goalRepository.save(goal).getGoalId());
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
