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

    @Column(name = "medical_conditions")
    private String medicalConditions;

    @Column
    private String disabilities;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "profile_workout",
            joinColumns = { @JoinColumn(name = "profile_id")},
            inverseJoinColumns = {@JoinColumn(name = "workout_id")})
    private List<Workout> workouts;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "goal",
            joinColumns = { @JoinColumn(name = "profile_id")},
            inverseJoinColumns = {@JoinColumn(name = "program_id")})
    private List<Program> programs;

    @JsonGetter("workouts")
    public List<String> workoutsGetter() {
        if (workouts != null) {
            return workouts.stream()
                    .map(workout -> "/api/v1/workouts/" + workout.getWorkoutId()).collect(Collectors.toList());
        }
        return null;
    }

    @JsonGetter("programs")
    public List<String> programsGetter() {
        if (programs != null) {
            return programs.stream()
                    .map(program -> "/api/v1/programs/" + program.getProgramId()).collect(Collectors.toList());
        }
        return null;
    }

    public Profile() {
        super();
    }

    public Profile(String profileId, double weight, double height, String medicalConditions, String disabilities, User user, Address address, List<Goal> goals, List<Workout> workouts, List<Program> programs) {
        this.profileId = profileId;
        this.weight = weight;
        this.height = height;
        this.medicalConditions = medicalConditions;
        this.disabilities = disabilities;
        this.user = user;
        this.address = address;
        this.workouts = workouts;
        this.programs = programs;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Workout> getWorkouts() {
        return workouts;
    }

    public void setWorkouts(List<Workout> workouts) {
        this.workouts = workouts;
    }

    public List<Program> getPrograms() {
        return programs;
    }

    public void setPrograms(List<Program> programs) {
        this.programs = programs;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "profileId=" + profileId +
                ", weight=" + weight +
                ", height=" + height +
                ", medicalConditions='" + medicalConditions + '\'' +
                ", disabilities='" + disabilities + '\'' +
                ", user=" + user +
                ", address=" + address +
                ", workouts=" + workouts +
                ", programs=" + programs +
                '}';
    }
}
