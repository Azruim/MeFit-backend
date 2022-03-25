package fi.experis.mefit.services.implementations;

import fi.experis.mefit.models.dtos.getDtos.ProfileGetDTO;
import fi.experis.mefit.models.dtos.postDtos.CreateProfileDTO;
import fi.experis.mefit.models.dtos.postDtos.UpdateProfileDTO;
import fi.experis.mefit.models.dtos.profileDtos.post.CreateProfileDTO;
import fi.experis.mefit.models.dtos.profileDtos.patch.UpdateProfileDTO;
import fi.experis.mefit.models.entities.Address;
import fi.experis.mefit.models.entities.Profile;
import fi.experis.mefit.repositories.AddressRepository;
import fi.experis.mefit.repositories.ProfileRepository;
import fi.experis.mefit.services.interfaces.ProfileService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;
    private final AddressRepository addressRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    public ProfileServiceImpl(ProfileRepository profileRepository, AddressRepository addressRepository) {
        this.profileRepository = profileRepository;
        this.addressRepository = addressRepository;
    }

    private Profile convertToEntity(CreateProfileDTO createProfileDTO) {
        return modelMapper.map(createProfileDTO, Profile.class);
    }

    private Profile convertToEntity(UpdateProfileDTO updateProfileDTO) {
        return modelMapper.map(updateProfileDTO, Profile.class);
    }

    @Override
    public ResponseEntity<String> addProfile(CreateProfileDTO newProfile) {
        try {
            Profile profile = convertToEntity(newProfile);
            Address address = addressRepository.save(profile.getAddress());
            profile.setAddress(address);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("/api/v1/profiles/" + profileRepository.save(profile).getProfileId());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<Profile> getProfileById(String profileId) {
        try {
            if (profileRepository.findById(profileId).isPresent()) {
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body(profileRepository.findById(profileId).get());
            }
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<String> updateProfile(String profileId, UpdateProfileDTO updatedProfile) {
        try {
            Profile profile = convertToEntity(updatedProfile);
            Address oldAddress = addressRepository.getById(profileRepository.getById(profileId).getAddress().getAddressId());
            Address address = profile.getAddress();
            address.setAddressId(oldAddress.getAddressId());
            profile.setAddress(address);
            profile.setProfileId(profileId);
            addressRepository.save(profile.getAddress());
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body("/api/v1/profiles/" + profileRepository.save(profile).getProfileId());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<String> deleteProfileById(String profileId) {
        try {
            profileRepository.deleteById(profileId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
