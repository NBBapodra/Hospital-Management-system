package com.example.TokenAuthentication.models;


import com.example.TokenAuthentication.exception.Enum.PatientStatus;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "patient_profile")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(name = "first_name", nullable = false)
    private String firstname;


    @Column(name = "last_name", nullable = false)
    private String lastname;

    @Column(name = "email_id", nullable = false)
    private String emailId;

    @Column(name = "dob", nullable = false)
    private Date dob;

    @Column(name = "age")
    private long age;

    @Column(name = "image")
    private String image;

    @Column(name = "blood_group")
    private String blood_group;

    @Column(name = "gender")
    private String gender;

    @Column(name = "admission_date")
    private Date admission_date;

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

    @Column(name = "contact_no", nullable = false)
    private long contact_no;

    @Column(name = "guardian_name")
    private String guardian_name;

    @Column(name = "guardian_contact_no", nullable = false)
    private long guardian_contact_no;

    @Column(name = "rating")
    private long rating;

    @Column(name = "occupation")
    private String occupation;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 20)
    private PatientStatus status;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;


    public Patient() {

    }

    public Patient(long id, String firstname, String lastname, String emailId, Date dob, long age, String image, String blood_group, String gender, Date admission_date, String address, City city, State state, Country country, long contact_no, String guardian_name, long guardian_contact_no, long rating, String occupation, PatientStatus status, Date createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.emailId = emailId;
        this.dob = dob;
        this.age = age;
        this.image = image;
        this.blood_group = blood_group;
        this.gender = gender;
        this.admission_date = admission_date;
        this.address = address;
        this.city = city;
        this.state = state;
        this.country = country;
        this.contact_no = contact_no;
        this.guardian_name = guardian_name;
        this.guardian_contact_no = guardian_contact_no;
        this.rating = rating;
        this.occupation = occupation;
        this.status = status;
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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBlood_group() {
        return blood_group;
    }

    public void setBlood_group(String blood_group) {
        this.blood_group = blood_group;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getAdmission_date() {
        return admission_date;
    }

    public void setAdmission_date(Date admission_date) {
        this.admission_date = admission_date;
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

    public long getContact_no() {
        return contact_no;
    }

    public void setContact_no(long contact_no) {
        this.contact_no = contact_no;
    }

    public String getGuardian_name() {
        return guardian_name;
    }

    public void setGuardian_name(String guardian_name) {
        this.guardian_name = guardian_name;
    }

    public long getGuardian_contact_no() {
        return guardian_contact_no;
    }

    public void setGuardian_contact_no(long guardian_contact_no) {
        this.guardian_contact_no = guardian_contact_no;
    }

    public long getRating() {
        return rating;
    }

    public void setRating(long rating) {
        this.rating = rating;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public PatientStatus getStatus() {
        return status;
    }

    public void setStatus(PatientStatus status) {
        this.status = status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", emailId='" + emailId + '\'' +
                ", dob=" + dob +
                ", age=" + age +
                ", image='" + image + '\'' +
                ", blood_group='" + blood_group + '\'' +
                ", gender='" + gender + '\'' +
                ", admission_date=" + admission_date +
                ", address='" + address + '\'' +
                ", city=" + city +
                ", state=" + state +
                ", country=" + country +
                ", contact_no='" + contact_no + '\'' +
                ", guardian_name='" + guardian_name + '\'' +
                ", guardian_contact_no='" + guardian_contact_no + '\'' +
                ", rating=" + rating +
                ", occupation='" + occupation + '\'' +
                ", status=" + status +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}


