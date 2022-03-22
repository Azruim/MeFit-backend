package fi.experis.mefit.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Program {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "program_id")
    private Long programId;

    @Column(columnDefinition = "varchar(40)")
    private String name;

    @Column(columnDefinition = "varchar(40)")
    private String category;

    @OneToMany(mappedBy = "goalId")
    @JsonIgnore
    private List<Goal> goals;

    @ManyToMany
    @JoinTable(name = "program_workout",
            joinColumns = {@JoinColumn(name = "program_id")},
            inverseJoinColumns = {@JoinColumn(name = "workout_id")})
    private List<Workout> workouts;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "profile_id")
    private Profile profile;

    public Program() {
        super();
    }

    public Program(Long programId, String name, String category, List<Goal> goals,
                   List<Workout> workouts, Profile profile) {
        this.programId = programId;
        this.name = name;
        this.category = category;
        this.goals = goals;
        this.workouts = workouts;
        this.profile = profile;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Long getProgramId() {
        return programId;
    }

    public void setProgramId(Long programId) {
        this.programId = programId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Goal> getGoals() {
        return goals;
    }

    public void setGoals(List<Goal> goals) {
        this.goals = goals;
    }

    public List<Workout> getWorkouts() {
        return workouts;
    }

    public void setWorkouts(List<Workout> workouts) {
        this.workouts = workouts;
    }

    @Override
    public String toString() {
        return "Program{" +
                "programId=" + programId +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", goals=" + goals +
                ", workouts=" + workouts +
                ", profile=" + profile +
                '}';
    }
}

