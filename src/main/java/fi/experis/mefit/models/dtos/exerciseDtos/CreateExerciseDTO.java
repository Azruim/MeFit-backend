package fi.experis.mefit.models.dtos.exerciseDtos;

public class CreateExerciseDTO {

    private String name;
    private String description;
    private String targetMuscleGroup;
    private String image;
    private String fitnessLevel;
    private String vidLink;
    private ProfileIdDTO profile;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProfileIdDTO getProfile() {
        return profile;
    }

    public void setProfile(ProfileIdDTO profile) {
        this.profile = profile;
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

    public String getFitnessLevel() {
        return fitnessLevel;
    }

    public void setFitnessLevel(String fitnessLevel) {
        this.fitnessLevel = fitnessLevel;
    }

    public String getVidLink() {
        return vidLink;
    }

    public void setVidLink(String vidLink) {
        this.vidLink = vidLink;
    }

    public static class ProfileIdDTO {

        private String profileId;

        public ProfileIdDTO() {
        }

        public String getProfileId() {
            return profileId;
        }

        public void setProfileId(String profileId) {
            this.profileId = profileId;
        }
    }
}
