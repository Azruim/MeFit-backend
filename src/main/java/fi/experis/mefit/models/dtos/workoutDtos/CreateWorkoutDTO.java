package fi.experis.mefit.models.dtos.workoutDtos;

import java.util.List;

public class CreateWorkoutDTO {

    private String name;
    private String type;
    private ProfileIdDTO profile;
    private List<WorkoutPostSetDTO> sets;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProfileIdDTO getProfile() {
        return profile;
    }

    public void setProfile(ProfileIdDTO profile) {
        this.profile = profile;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<WorkoutPostSetDTO> getSets() {
        return sets;
    }

    public void setSets(List<WorkoutPostSetDTO> sets) {
        this.sets = sets;
    }

    public static class WorkoutPostSetDTO {

        private Long setId;
        private int exerciseRepetitions;
        private ExerciseIdDTO exercise;

        public Long getSetId() {
            return setId;
        }

        public void setSetId(Long setId) {
            this.setId = setId;
        }

        public int getExerciseRepetitions() {
            return exerciseRepetitions;
        }

        public void setExerciseRepetitions(int exerciseRepetitions) {
            this.exerciseRepetitions = exerciseRepetitions;
        }

        public ExerciseIdDTO getExercise() {
            return exercise;
        }

        public void setExercise(ExerciseIdDTO exercise) {
            this.exercise = exercise;
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

    public static class ProfileIdDTO {

        private String profileId;

        public ProfileIdDTO() {
        }

        public String getProfileId() {
            return profileId;
        }

        public void setProfileId(String profileId) {
            this.profileId = profileId;
        }
    }
}
