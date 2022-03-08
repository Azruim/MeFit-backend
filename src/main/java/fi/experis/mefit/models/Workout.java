package fi.experis.mefit.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "workout_id")
    private Long workoutId;

    @Column
    private String name;

    @Column
    private String type;

    @Column
    private boolean complete;

    @ManyToMany(mappedBy = "workouts",cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<Program> programs;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "goal_workout",
            joinColumns = { @JoinColumn(name = "workout_id")},
            inverseJoinColumns = {@JoinColumn(name = "goal_id")})
    private List<Goal> goals;


    @OneToOne
    @JoinColumn(name = "set_id")
    private Set set;

    public Workout() {
        super();
    }

    public Workout(Long workoutId, String name, String type, boolean complete, List<Program> programs, List<Goal> goals, Set set) {
        this.workoutId = workoutId;
        this.name = name;
        this.type = type;
        this.complete = complete;
        this.programs = programs;
        this.goals = goals;
        this.set = set;
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

    public Set getSet() {
        return set;
    }

    public void setSet(Set set) {
        this.set = set;
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
                ", set=" + set +
                '}';
    }
}
