package fi.experis.mefit.models;

import javax.persistence.*;

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
}
