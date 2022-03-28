package fi.experis.mefit.models.dtos.programDtos;

import java.util.List;

public class CreateProgramDTO {

    private String name;
    private String category;
    private ProfileIdDTO profile;
    private List<WorkoutIdDTO> workouts;

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<WorkoutIdDTO> getWorkouts() {
        return workouts;
    }

    public void setWorkouts(List<WorkoutIdDTO> workouts) {
        this.workouts = workouts;
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