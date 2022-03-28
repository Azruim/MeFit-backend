package fi.experis.mefit.models.dtos.profileDtos;

import fi.experis.mefit.models.dtos.goalDto.GetGoalDTO;

import java.util.List;

public class GetProfileDTO {
    private String profileId;
    private double weight;
    private double height;
    private String fitnessLevel;
    private String medicalConditions;
    private String disabilities;
    private AddressDTO address;
    private List<GetGoalDTO> goals;
    private List<ProgramIdDTO> programs;
    private List<WorkoutIdDTO> workouts;
    private List<ExerciseIdDTO> exercises;

    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

    public List<ProgramIdDTO> getPrograms() {
        return programs;
    }

    public void setPrograms(List<ProgramIdDTO> programs) {
        this.programs = programs;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getFitnessLevel() {
        return fitnessLevel;
    }

    public void setFitnessLevel(String fitnessLevel) {
        this.fitnessLevel = fitnessLevel;
    }

    public String getMedicalConditions() {
        return medicalConditions;
    }

    public void setMedicalConditions(String medicalConditions) {
        this.medicalConditions = medicalConditions;
    }

    public String getDisabilities() {
        return disabilities;
    }

    public void setDisabilities(String disabilities) {
        this.disabilities = disabilities;
    }

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }

    public List<GetGoalDTO> getGoals() {
        return goals;
    }

    public void setGoals(List<GetGoalDTO> goals) {
        this.goals = goals;
    }

    public List<WorkoutIdDTO> getWorkouts() {
        return workouts;
    }

    public void setWorkouts(List<WorkoutIdDTO> workouts) {
        this.workouts = workouts;
    }

    public List<ExerciseIdDTO> getExercises() {
        return exercises;
    }

    public void setExercises(List<ExerciseIdDTO> exercises) {
        this.exercises = exercises;
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

    public static class AddressDTO {

        private String addressLine_1;
        private String addressLine_2;
        private String addressLine_3;
        private String postalCode;
        private String city;
        private String country;

        public String getAddressLine_1() {
            return addressLine_1;
        }

        public void setAddressLine_1(String addressLine_1) {
            this.addressLine_1 = addressLine_1;
        }

        public String getAddressLine_2() {
            return addressLine_2;
        }

        public void setAddressLine_2(String addressLine_2) {
            this.addressLine_2 = addressLine_2;
        }

        public String getAddressLine_3() {
            return addressLine_3;
        }

        public void setAddressLine_3(String addressLine_3) {
            this.addressLine_3 = addressLine_3;
        }

        public String getPostalCode() {
            return postalCode;
        }

        public void setPostalCode(String postalCode) {
            this.postalCode = postalCode;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
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
}
