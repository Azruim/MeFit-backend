package fi.experis.mefit.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exercise_id")
    private Long exerciseId;

    @Column(length = 40)
    private String name;

    @Column
    private String description;

    @Column(length = 40, name = "target_muscle_group")
    private String targetMuscleGroup;

    @Column
    private String image;

    @Column String fitnessLevel;

    @Column(name = "vid_link")
    private String vidLink;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonIgnore
    @JoinTable(
            name = "goal_exercise",
            joinColumns = { @JoinColumn(name = "goal_id")},
            inverseJoinColumns = {@JoinColumn(name = "exercise_id")})
    private List<Goal> goals;

    public Exercise() {
        super();
    }

    public Exercise(Long exerciseId, String name, String description, String targetMuscleGroup, String image, String fitnessLevel, String vidLink, List<Goal> goals) {
        this.exerciseId = exerciseId;
        this.name = name;
        this.description = description;
        this.targetMuscleGroup = targetMuscleGroup;
        this.image = image;
        this.fitnessLevel = fitnessLevel;
        this.vidLink = vidLink;
        this.goals = goals;
    }

    public String getFitnessLevel() {
        return fitnessLevel;
    }

    public void setFitnessLevel(String fitnessLevel) {
        this.fitnessLevel = fitnessLevel;
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "exerciseId=" + exerciseId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", targetMuscleGroup='" + targetMuscleGroup + '\'' +
                ", image='" + image + '\'' +
                ", fitnessLevel='" + fitnessLevel + '\'' +
                ", vidLink='" + vidLink + '\'' +
                ", goals=" + goals +
                '}';
    }

    public Long getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(Long exerciseId) {
        this.exerciseId = exerciseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTargetMuscleGroup() {
        return targetMuscleGroup;
    }

    public void setTargetMuscleGroup(String targetMuscleGroup) {
        this.targetMuscleGroup = targetMuscleGroup;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getVidLink() {
        return vidLink;
    }

    public void setVidLink(String vidLink) {
        this.vidLink = vidLink;
    }

    public List<Goal> getGoals() {
        return goals;
    }

    public void setGoals(List<Goal> goals) {
        this.goals = goals;
    }

}
