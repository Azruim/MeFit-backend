package fi.experis.mefit.models.dtos.goalDto;

import java.util.Date;
import java.util.List;

public class GetGoalDTO {

    private Long goalId;
    private Date endDate;
    private Date startDate;
    private Boolean achieved;
    private ProgramIdDTO program;
    private List<GoalWorkoutDTO> workouts;
    private List<GoalExerciseDTO> exercises;

    public Long getGoalId() {
        return goalId;
    }

    public void setGoalId(Long goalId) {
        this.goalId = goalId;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Boolean getAchieved() {
        return achieved;
    }

    public void setAchieved(Boolean achieved) {
        this.achieved = achieved;
    }

    public ProgramIdDTO getProgram() {
        return program;
    }

    public void setProgram(ProgramIdDTO program) {
        this.program = program;
    }

    public List<GoalWorkoutDTO> getWorkouts() {
        return workouts;
    }

    public void setWorkouts(List<GoalWorkoutDTO> workouts) {
        this.workouts = workouts;
    }

    public List<GoalExerciseDTO> getExercises() {
        return exercises;
    }

    public void setExercises(List<GoalExerciseDTO> exercises) {
        this.exercises = exercises;
    }

    public static class GoalExerciseDTO {

        private boolean completed;
        private ExerciseIdDTO exercise;

        public GoalExerciseDTO() {
        }

        public boolean isCompleted() {
            return completed;
        }

        public void setCompleted(boolean completed) {
            this.completed = completed;
        }

        public ExerciseIdDTO getExercise() {
            return exercise;
        }

        public void setExercise(ExerciseIdDTO exercise) {
            this.exercise = exercise;
        }
    }

    public static class GoalWorkoutDTO {

        private boolean completed;
        private WorkoutIdDTO workout;

        public GoalWorkoutDTO() {
        }

        public boolean isCompleted() {
            return completed;
        }

        public void setCompleted(boolean completed) {
            this.completed = completed;
        }

        public WorkoutIdDTO getWorkout() {
            return workout;
        }

        public void setWorkout(WorkoutIdDTO workout) {
            this.workout = workout;
        }
    }

    public static class ExerciseIdDTO {

        private Long exerciseId;

        public ExerciseIdDTO() {
        }

        public ExerciseIdDTO(Long exerciseId) {
            this.exerciseId = exerciseId;
        }

        public Long getExerciseId() {
            return exerciseId;
        }

        public void setExerciseId(Long exerciseId) {
            this.exerciseId = exerciseId;
        }
    }

    public static class ProgramIdDTO {

        private Long programId;

        public ProgramIdDTO() {
        }

        public Long getProgramId() {
            return programId;
        }

        public void setProgramId(Long programId) {
            this.programId = programId;
        }
    }

    public static class WorkoutIdDTO {

        private Long workoutId;

        public WorkoutIdDTO() {
        }

        public WorkoutIdDTO(Long workoutId) {
            this.workoutId = workoutId;
        }

        public Long getWorkoutId() {
            return workoutId;
        }

        public void setWorkoutId(Long workoutId) {
            this.workoutId = workoutId;
        }
    }
}
