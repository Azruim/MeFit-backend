package fi.experis.mefit.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exercise_id")
    private Long exerciseId;

    @Column(columnDefinition = "varchar(40)")
    private String name;

    @Column(columnDefinition = "varchar(255)")
    private String description;

    @Column(columnDefinition = "varchar(40)")
    private String targetMuscleGroup;

    @Column(columnDefinition = "varchar(255)")
    private String image;

    @Column(columnDefinition = "varchar(40)")
    private String fitnessLevel;

    @Column(columnDefinition = "varchar(255)")
    private String vidLink;

    @OneToMany(mappedBy = "exercise", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<GoalExercise> goalExercises;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "profile_id")
    private Profile profile;

    public Exercise() {
        super();
    }

    public Exercise(Long exerciseId, String name, String description, String targetMuscleGroup,
                    String image, String fitnessLevel, String vidLink, List<Goal> goals, Profile profile) {
        this.exerciseId = exerciseId;
        this.name = name;
        this.description = description;
        this.targetMuscleGroup = targetMuscleGroup;
        this.image = image;
        this.fitnessLevel = fitnessLevel;
        this.vidLink = vidLink;
        this.profile = profile;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
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
                ", profile=" + profile +
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

    public List<GoalExercise> getGoalExercises() {
        return goalExercises;
    }

    public void setGoalExercises(List<GoalExercise> goalExercises) {
        this.goalExercises = goalExercises;
    }
}
