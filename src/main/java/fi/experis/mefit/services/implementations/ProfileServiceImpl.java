package fi.experis.mefit.services.implementations;

import fi.experis.mefit.models.dtos.ProfileDTO;
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

    private Profile convertToEntity(ProfileDTO profileDTO) {
        Profile profile = modelMapper.map(profileDTO, Profile.class);
        if (profileDTO.getProfileId() != null) {
            Profile oldProfile = profileRepository.getById(profileDTO.getProfileId());
            Address oldAddress = addressRepository.getById(oldProfile.getAddress().getAddressId());
            Address address = profile.getAddress();
            address.setAddressId(oldAddress.getAddressId());
            profile.setAddress(address);
            profile.setProfileId(oldProfile.getProfileId());
        }
        return profile;
    }

    @Override
    public ResponseEntity<String> addProfile(ProfileDTO newProfile) {
        try {
            Profile profile = convertToEntity(newProfile);
            Address address = addressRepository.save(profile.getAddress());
            profile.setAddress(address);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("/api/v1/profiles/" + profile.getProfileId());
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
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<String> updateProfile(String profileId, ProfileDTO updatedProfile) {
        try {
            updatedProfile.setProfileId(profileId);
            Profile profile = convertToEntity(updatedProfile);
            addressRepository.save(profile.getAddress());
            profileRepository.save(profile);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body("/api/v1/profiles/" + updatedProfile.getProfileId());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<String> deleteProfileById(String profileId) {
        try {
            profileRepository.deleteById(profileId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
