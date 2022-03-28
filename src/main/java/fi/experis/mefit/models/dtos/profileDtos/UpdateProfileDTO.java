package fi.experis.mefit.models.dtos.profileDtos;

public class UpdateProfileDTO {

    private double weight;
    private double height;
    private String fitnessLevel;
    private String medicalConditions;
    private String disabilities;
    private AddressDTO address;

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getFitnessLevel() {
        return fitnessLevel;
    }

    public void setFitnessLevel(String fitnessLevel) {
        this.fitnessLevel = fitnessLevel;
    }

    public String getMedicalConditions() {
        return medicalConditions;
    }

    public void setMedicalConditions(String medicalConditions) {
        this.medicalConditions = medicalConditions;
    }

    public String getDisabilities() {
        return disabilities;
    }

    public void setDisabilities(String disabilities) {
        this.disabilities = disabilities;
    }

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }

    public static class AddressDTO {

        private String addressLine_1;
        private String addressLine_2;
        private String addressLine_3;
        private String postalCode;
        private String city;
        private String country;

        public String getAddressLine_1() {
            return addressLine_1;
        }

        public void setAddressLine_1(String addressLine_1) {
            this.addressLine_1 = addressLine_1;
        }

        public String getAddressLine_2() {
            return addressLine_2;
        }

        public void setAddressLine_2(String addressLine_2) {
            this.addressLine_2 = addressLine_2;
        }

        public String getAddressLine_3() {
            return addressLine_3;
        }

        public void setAddressLine_3(String addressLine_3) {
            this.addressLine_3 = addressLine_3;
        }

        public String getPostalCode() {
            return postalCode;
        }

        public void setPostalCode(String postalCode) {
            this.postalCode = postalCode;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }
    }

}
