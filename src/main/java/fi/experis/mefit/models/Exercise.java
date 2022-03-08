package fi.experis.mefit.models;

import javax.persistence.*;

@Entity
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exercise_id")
    private Long exerciseId;

    @Column
    private String name;

    @Column
    private String description;

    @Column(name = "target_muscle_group")
    private String targetMuscleGroup;

    @Column
    private String image;

    @Column(name = "vid_link")
    private String vidLink;

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
}
