package fi.experis.mefit.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Program {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "program_id")
    private Long programId;

    @Column
    private String name;

    @Column
    private String category;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "program_workout",
            joinColumns = { @JoinColumn(name = "program_id")},
            inverseJoinColumns = {@JoinColumn(name = "workout_id")})
    private List<Workout> workouts;

    public Program() {
        super();
    }

    public Program(Long programId, String name, String category, List<Workout> workouts) {
        this.programId = programId;
        this.name = name;
        this.category = category;
        this.workouts = workouts;
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
                ", workouts=" + workouts +
                '}';
    }
}
