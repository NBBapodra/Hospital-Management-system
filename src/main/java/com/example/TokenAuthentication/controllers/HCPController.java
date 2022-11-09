package com.example.TokenAuthentication.controllers;


import com.example.TokenAuthentication.dto.HCPDto;
import com.example.TokenAuthentication.models.HCPProfile;
import com.example.TokenAuthentication.services.HCPService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping ("/api/v1")
public class HCPController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private HCPService hcpService;


    @PostMapping("/HCPs")
    public ResponseEntity<HCPDto> createHCP(@RequestBody HCPDto  hcpDto) {

        // convert DTO to entity
        HCPProfile hcpProfileRequest = modelMapper.map(hcpDto, HCPProfile.class);
        HCPProfile hcpProfile= hcpService.createHCP(hcpProfileRequest);
        // convert entity to DTO

        HCPDto hcpResponse = modelMapper.map(hcpProfile,HCPDto.class);
        return new ResponseEntity<HCPDto>(hcpResponse, HttpStatus.CREATED);
    }

    @GetMapping("/HCPs")
    public List<HCPDto> getAllHCPs() {
        return hcpService.getAllHCP().stream().map(post -> modelMapper.map(post, HCPDto.class))
                .collect(Collectors.toList());
    }


    @GetMapping("/HCPs/{id}")
    public ResponseEntity<HCPDto> getHCPsById(@PathVariable(value = "id") Long id)
    {
        HCPProfile hcpProfile=hcpService.getHCPById(id);
        HCPDto hcpResponse = modelMapper.map(hcpProfile,HCPDto.class);
        if(hcpProfile==null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok().body(hcpResponse);
    }


    @PutMapping("/HCPs/{id}")
    public ResponseEntity<HCPDto> updateHCP(@PathVariable(value = "id") Long id,
                                                              @Valid @RequestBody HCPDto hcpDto){
        // convert DTO to entity
        HCPProfile hcpProfileRequest = modelMapper.map(hcpDto, HCPProfile.class);
         HCPProfile hcpProfile=hcpService.updateHCP(id,hcpProfileRequest);
        // convert entity to DTO
        HCPDto hcpResponse = modelMapper.map(hcpProfile,HCPDto.class);
        return ResponseEntity.ok().body(hcpResponse);
    }

    @DeleteMapping("/HCPs/{id}")
    public ResponseEntity deleteHCP(@PathVariable(value = "id") Long id)
    {
        hcpService.deleteHCP(id);
        return ResponseEntity.ok().body("HCPs deleted successFully");
    }


    @GetMapping("/HCPs/firstname/{firstname}")
    public ResponseEntity<List<HCPProfile>> getHCPsByFirstName(@PathVariable(value = "firstname") String firstName)
    {
        return new ResponseEntity<>(hcpService.getHCPByFirstName(firstName),HttpStatus.OK);
    }


    @GetMapping("/HCPs/lastname/{lastname}")
    public ResponseEntity<List<HCPProfile>> getHCPsByLastName(@PathVariable(value = "lastname") String lastName)
    {
        return new ResponseEntity<>(hcpService.getHCPByLastName(lastName),HttpStatus.OK);
    }

    @GetMapping("/HCPs/education/{education}")
    public ResponseEntity<List<HCPProfile>> getHCPsByEducation(@PathVariable(value = "education") String education)
    {
        return new ResponseEntity<>(hcpService.getHCPsByEducation(education),HttpStatus.OK);
    }

}
