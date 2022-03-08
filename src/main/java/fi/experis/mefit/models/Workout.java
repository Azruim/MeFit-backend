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

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "program_workout",
            joinColumns = { @JoinColumn(name = "workout_id")},
            inverseJoinColumns = {@JoinColumn(name = "program_id")})
    private List<Program> programs;

    @OneToMany(mappedBy = "workout")
    private List<GoalWorkout> goalWorkouts;

    @OneToOne
    @JoinColumn(name = "set_id")
    private Set set;

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

    public List<GoalWorkout> getGoalWorkouts() {
        return goalWorkouts;
    }

    public void setGoalWorkouts(List<GoalWorkout> goalWorkouts) {
        this.goalWorkouts = goalWorkouts;
    }

    public Set getSet() {
        return set;
    }

    public void setSet(Set set) {
        this.set = set;
    }
}
