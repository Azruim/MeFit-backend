package fi.experis.mefit.models;

import com.fasterxml.jackson.annotation.JsonGetter;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Profile {

    @Id
    @Column(name = "profile_id")
    private String profileId;

    @Column
    private double weight;

    @Column
    private double height;

    @Column
    private String fitnessLevel;

    @Column(name = "medical_conditions")
    private String medicalConditions;

    @Column
    private String disabilities;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany
    @JoinColumn(name = "profile_id")
    private List<Goal> goals;

    @OneToMany
    @JoinColumn(name = "profile_id")
    private List<Workout> workouts;

    @JsonGetter(value = "workouts")
    public List<String> workoutsGetter() {
        if (workouts != null) {
            return workouts.stream()
                    .map(workout -> "/api/v1/workouts/" + workout.getWorkoutId()).collect(Collectors.toList());
        }
        return null;
    }


    public Profile() {
        super();
    }

    public Profile(String profileId, double weight, double height, String fitnessLevel, String medicalConditions, String disabilities, Address address, List<Goal> goals, List<Workout> workouts) {
        this.profileId = profileId;
        this.weight = weight;
        this.height = height;
        this.fitnessLevel = fitnessLevel;
        this.medicalConditions = medicalConditions;
        this.disabilities = disabilities;
        this.address = address;
        this.goals = goals;
        this.workouts = workouts;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "profileId='" + profileId + '\'' +
                ", weight=" + weight +
                ", height=" + height +
                ", fitnessLevel='" + fitnessLevel + '\'' +
                ", medicalConditions='" + medicalConditions + '\'' +
                ", disabilities='" + disabilities + '\'' +
                ", address=" + address +
                ", goals=" + goals +
                ", workouts=" + workouts +
                '}';
    }



    public List<Workout> getWorkouts() {
        return workouts;
    }

    public void setWorkouts(List<Workout> workouts) {
        this.workouts = workouts;
    }

    public String getFitnessLevel() {
        return fitnessLevel;
    }

    public List<Goal> getGoals() {
        return goals;
    }

    public void setGoals(List<Goal> goals) {
        this.goals = goals;
    }

    public void setFitnessLevel(String fitnessLevel) {
        this.fitnessLevel = fitnessLevel;
    }

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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


}
