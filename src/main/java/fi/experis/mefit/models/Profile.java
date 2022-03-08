package fi.experis.mefit.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profile_id")
    private Long profileId;

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

    @OneToMany
    @JoinColumn(name = "set_id")
    List<Set> sets;

    @OneToMany
    @JoinColumn(name = "workout_id")
    List<Workout> workouts;

    @OneToMany
    @JoinColumn(name = "program_id")
    List<Program> programs;

    public Profile() {
        super();
    }

    public Profile(Long profileId, double weight, double height, String medicalConditions, String disabilities, User user, Address address, List<Set> sets, List<Workout> workouts, List<Program> programs) {
        this.profileId = profileId;
        this.weight = weight;
        this.height = height;
        this.medicalConditions = medicalConditions;
        this.disabilities = disabilities;
        this.user = user;
        this.address = address;
        this.sets = sets;
        this.workouts = workouts;
        this.programs = programs;
    }

    public Long getProfileId() {
        return profileId;
    }

    public void setProfileId(Long profileId) {
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

    public List<Set> getSets() {
        return sets;
    }

    public void setSets(List<Set> sets) {
        this.sets = sets;
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
                ", sets=" + sets +
                ", workouts=" + workouts +
                ", programs=" + programs +
                '}';
    }
}
