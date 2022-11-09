package com.example.TokenAuthentication.services;

import com.example.TokenAuthentication.models.HCPProfile;



import java.util.List;

public interface HCPService {

    List<HCPProfile> getAllHCP();

    HCPProfile createHCP(HCPProfile hcpProfile);

    HCPProfile updateHCP(Long id,HCPProfile hcpProfile);

    List<HCPProfile> getHCPByFirstName(String firstname);

    List<HCPProfile> getHCPByLastName(String lastname);

    List<HCPProfile> getHCPsByEducation(String education);

    HCPProfile getHCPById(Long id);

    void deleteHCP(Long id);
}
