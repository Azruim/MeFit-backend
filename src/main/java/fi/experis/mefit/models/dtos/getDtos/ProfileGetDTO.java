package fi.experis.mefit.models.dtos.getDtos;

import fi.experis.mefit.models.dtos.goalDto.ExerciseGoalDTO;
import fi.experis.mefit.models.dtos.goalDto.WorkoutGoalDTO;
import fi.experis.mefit.models.dtos.nestedDtos.AddressDTO;

import java.util.List;

public class ProfileGetDTO {
    private String profileId;
    private double weight;
    private double height;
    private String fitnessLevel;
    private String medicalConditions;
    private String disabilities;
    private AddressDTO address;
    private List<GoalGetDTO> goals;
    private List<WorkoutGoalDTO> workouts;
    private List<ExerciseGoalDTO> exercises;

    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
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

    public List<GoalGetDTO> getGoals() {
        return goals;
    }

    public void setGoals(List<GoalGetDTO> goals) {
        this.goals = goals;
    }

    public List<WorkoutGoalDTO> getWorkouts() {
        return workouts;
    }

    public void setWorkouts(List<WorkoutGoalDTO> workouts) {
        this.workouts = workouts;
    }

    public List<ExerciseGoalDTO> getExercises() {
        return exercises;
    }

    public void setExercises(List<ExerciseGoalDTO> exercises) {
        this.exercises = exercises;
    }
}
