package fi.experis.mefit.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Set {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "set_id")
    private Long setId;

    @Column(name = "exercise_repetitions")
    private int exerciseRepetitions;

    @OneToOne
    @JoinColumn(name = "exercise_id")
    private Exercise exercise;

    @ManyToMany
    @JoinTable(
            name = "workout_set",
            joinColumns = { @JoinColumn(name = "workout_id")},
            inverseJoinColumns = {@JoinColumn(name = "set_id")})
    @JsonIgnore
    private List<Workout> workout;

    public Set() {
        super();
    }

    public Set(Long setId, int exerciseRepetitions, Exercise exercise) {
        this.setId = setId;
        this.exerciseRepetitions = exerciseRepetitions;
        this.exercise = exercise;
    }

    public Long getSetId() {
        return setId;
    }

    public void setSetId(Long setId) {
        this.setId = setId;
    }

    public int getExerciseRepetitions() {
        return exerciseRepetitions;
    }

    public void setExerciseRepetitions(int exerciseRepetitions) {
        this.exerciseRepetitions = exerciseRepetitions;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public List<Workout> getWorkout() {
        return workout;
    }

    public void setWorkout(List<Workout> workout) {
        this.workout = workout;
    }

    @Override
    public String toString() {
        return "Set{" +
                "setId=" + setId +
                ", exerciseRepetitions=" + exerciseRepetitions +
                ", exercise=" + exercise +
                '}';
    }
}
