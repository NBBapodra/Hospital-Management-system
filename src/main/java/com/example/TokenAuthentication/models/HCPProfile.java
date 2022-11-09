package com.example.TokenAuthentication.models;


import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "HCPProfile")
@Table(name = "hcp_profile")
public class HCPProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(name = "first_name", nullable = false)
    private String firstname;


    @Column(name = "last_name", nullable = false)
    private String lastname;

    @Column(name = "email_id", nullable = false)
    private String emailId;

    @Column(name = "image")
    private String image;

    @Column(name = "education")
    private String education;

    @Column(name = "experience")
    private Long experience;

    @Column(name = "aadharcard_no")
    private Long aadharCardNo;

    @Column(name = "pan_no")
    private String panNo;

    @Column(name = "gender")
    private String gender;

    @Column(name = "contact_no", nullable = false)
    private long contact_no;

    @Column(name = "address")
    private String address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "city_id")
    private City city;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "state_id")
    private State state;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "country_id")
    private Country country;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public HCPProfile() {
    }

    public HCPProfile(long id, String firstname, String lastname, String emailId, String image, String education, Long experience, Long aadharCardNo, String panNo, String gender, long contact_no, String address, City city, State state, Country country, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.emailId = emailId;
        this.image = image;
        this.education = education;
        this.experience = experience;
        this.aadharCardNo = aadharCardNo;
        this.panNo = panNo;
        this.gender = gender;
        this.contact_no = contact_no;
        this.address = address;
        this.city = city;
        this.state = state;
        this.country = country;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public Long getExperience() {
        return experience;
    }

    public void setExperience(Long experience) {
        this.experience = experience;
    }

    public Long getAadharCardNo() {
        return aadharCardNo;
    }

    public void setAadharCardNo(Long aadharCardNo) {
        this.aadharCardNo = aadharCardNo;
    }

    public String getPanNo() {
        return panNo;
    }

    public void setPanNo(String panNo) {
        this.panNo = panNo;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public long getContact_no() {
        return contact_no;
    }

    public void setContact_no(long contact_no) {
        this.contact_no = contact_no;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
