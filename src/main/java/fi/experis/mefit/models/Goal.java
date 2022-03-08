package fi.experis.mefit.models;

import com.fasterxml.jackson.annotation.JsonGetter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Goal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "goal_id")
    private Long goalId;

    @Column(name = "end_date")
    private Date endDate;

    @Column
    private boolean achieved;

    @OneToOne
    @JoinColumn(name = "program_id")
    private Program program;

    @JsonGetter("program")
    public String programGetter() {
        if (program != null) {
            return "/api/v1/programs/" + program.getProgramId();
        }
        return null;
    }

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "goal_workout",
            joinColumns = { @JoinColumn(name = "goal_id")},
            inverseJoinColumns = {@JoinColumn(name = "workout_id")})
    private List<Workout> workouts;

    @ManyToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;



    public Goal() {
        super();
    }

    public Goal(Long goalId, Date endDate, boolean achieved, Program program, List<Workout> workouts) {
        this.goalId = goalId;
        this.endDate = endDate;
        this.achieved = achieved;
        this.program = program;
        this.workouts = workouts;
    }

    public Long getGoalId() {
        return goalId;
    }

    public void setGoalId(Long goalId) {
        this.goalId = goalId;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public boolean isAchieved() {
        return achieved;
    }

    public void setAchieved(boolean achieved) {
        this.achieved = achieved;
    }

    public List<Workout> getWorkouts() {
        return workouts;
    }

    public void setWorkouts(List<Workout> workouts) {
        this.workouts = workouts;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    @Override
    public String toString() {
        return "Goal{" +
                "goalId=" + goalId +
                ", endDate=" + endDate +
                ", achieved=" + achieved +
                ", program=" + program +
                ", workouts=" + workouts +
                '}';
    }
}
