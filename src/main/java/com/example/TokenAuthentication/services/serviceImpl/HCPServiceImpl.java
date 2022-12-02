package com.example.TokenAuthentication.services.serviceImpl;

import com.example.TokenAuthentication.exception.ResourceNotFoundException;
import com.example.TokenAuthentication.models.HCPProfile;
import com.example.TokenAuthentication.repository.HCPRepository;
import com.example.TokenAuthentication.services.HCPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class HCPServiceImpl implements HCPService {

    @Autowired
    private HCPRepository hcpRepository;


    @Override
    public List<HCPProfile> getAllHCP() {
        return hcpRepository.findAll();
    }

    @Override
    public HCPProfile createHCP(HCPProfile hcpProfile) {
        return hcpRepository.save(hcpProfile);
    }

    @Override
    public HCPProfile updateHCP(Long id, HCPProfile hcpProfile) {

        HCPProfile hcpProfile1;

        try {
            hcpProfile1 = hcpRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("HCP not found for this id :: " + id, "id", id));
        } catch (ResourceNotFoundException e) {
            throw new RuntimeException(e);
        }

        hcpProfile1.setId(hcpProfile.getId());
        hcpProfile1.setFirstname(hcpProfile.getFirstname());
        hcpProfile1.setLastname(hcpProfile.getLastname());
        hcpProfile1.setEmailId(hcpProfile.getEmailId());
        hcpProfile1.setImage(hcpProfile.getImage());
        hcpProfile1.setAddress(hcpProfile.getAddress());
        hcpProfile1.setCity(hcpProfile.getCity());
        hcpProfile1.setCountry(hcpProfile.getCountry());
        hcpProfile1.setState(hcpProfile.getState());
        hcpProfile1.setContact_no(hcpProfile.getContact_no());
        hcpProfile1.setGender(hcpProfile.getGender());
        hcpProfile1.setEducation(hcpProfile.getEducation());
        hcpProfile1.setExperience(hcpProfile.getExperience());
        hcpProfile1.setPanNo(hcpProfile.getPanNo());
        hcpProfile1.setAadharCardNo(hcpProfile.getAadharCardNo());
        hcpProfile1.setCreatedAt(hcpProfile.getCreatedAt());
        hcpProfile1.setUpdatedAt(hcpProfile.getUpdatedAt());
        return hcpRepository.save(hcpProfile1);
    }

    @Override
    public List<HCPProfile> getHCPByFirstName(String firstname) {
        return hcpRepository.findByFirstName(firstname);
    }

    @Override
    public List<HCPProfile> getHCPByLastName(String lastname) {
        return hcpRepository.findByLastName(lastname);
    }

    @Override
    public List<HCPProfile> getHCPsByEducation(String education) {
        return hcpRepository.findByEducation(education);
    }

    @Override
    public HCPProfile getHCPById(Long id) {


        Optional<HCPProfile> hcpProfile=hcpRepository.findById(id);

        if(hcpProfile.isPresent()) {
            return hcpProfile.get();
        }else {
            try {
                throw new ResourceNotFoundException("HCP not Found", "id", id);
            } catch (ResourceNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

    }

    @Override
    public void deleteHCP(Long id) {

        try {
            HCPProfile hcpProfile1 = hcpRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("HCP not found for this id :: " + id, "id", id));
        } catch (ResourceNotFoundException e) {
            throw new RuntimeException(e);
        }
        hcpRepository.deleteById(id);

    }
}
