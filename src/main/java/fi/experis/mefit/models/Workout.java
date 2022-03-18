package fi.experis.mefit.models;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "workout_id")
    private Long workoutId;

    @Column(length = 40)
    private String name;

    @Column(length = 40)
    private String type;

    @Column
    private boolean complete;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonIgnore
    @JoinTable(name = "program_workout",
            joinColumns = {@JoinColumn(name = "workout_id")},
            inverseJoinColumns = {@JoinColumn(name = "program_id")})
    private List<Program> programs;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonIgnore
    @JoinTable(
            name = "goal_workout",
            joinColumns = { @JoinColumn(name = "workout_id")},
            inverseJoinColumns = {@JoinColumn(name = "goal_id")})
    private List<Goal> goals;

    @ManyToMany
    @JoinTable(
            name = "workout_set",
            joinColumns = { @JoinColumn(name = "workout_id")},
            inverseJoinColumns = {@JoinColumn(name = "set_id")})
    private List<Set> sets;


    @ManyToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;

    @JsonGetter(value = "profile")
    public String profileGetter() {
        if (profile != null) {
            return "/api/v1/profiles" + profile.getProfileId();
        }
        return null;
    }

    public Workout() {
        super();
    }

    @Override
    public String toString() {
        return "Workout{" +
                "workoutId=" + workoutId +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", complete=" + complete +
                ", programs=" + programs +
                ", goals=" + goals +
                ", sets=" + sets +
                ", profile=" + profile +
                '}';
    }



    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Workout(Long workoutId, String name, String type, boolean complete, List<Program> programs, List<Goal> goals, List<Set> sets, Profile profile) {
        this.workoutId = workoutId;
        this.name = name;
        this.type = type;
        this.complete = complete;
        this.programs = programs;
        this.goals = goals;
        this.sets = sets;
        this.profile = profile;
    }

    public Long getWorkoutId() {
        return workoutId;
    }

    public void setWorkoutId(Long workoutId) {
        this.workoutId = workoutId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public List<Goal> getGoals() {
        return goals;
    }

    public void setGoals(List<Goal> goals) {
        this.goals = goals;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public List<Program> getPrograms() {
        return programs;
    }

    public void setPrograms(List<Program> programs) {
        this.programs = programs;
    }

    public List<Set> getSets() {
        return sets;
    }

    public void setSets(List<Set> sets) {
        this.sets = sets;
    }


}
