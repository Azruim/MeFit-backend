package fi.experis.mefit.models.entities;

import javax.persistence.*;

@Entity(name = "program_workout")
public class ProgramWorkout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name = "program_workout_id")
    private Long goalWorkoutId;

    @ManyToOne
    @JoinColumn(name = "workout_id")
    private Workout workout;

    @ManyToOne
    @JoinColumn(name = "program_id")
    private Program program;

    public Long getGoalWorkoutId() {
        return goalWorkoutId;
    }

    public void setGoalWorkoutId(Long goalWorkoutId) {
        this.goalWorkoutId = goalWorkoutId;
    }

    public Workout getWorkout() {
        return workout;
    }

    public void setWorkout(Workout workout) {
        this.workout = workout;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }
}
