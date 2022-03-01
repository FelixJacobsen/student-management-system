package se.iths.entity;


import javax.validation.constraints.Size;


public class StudentPhoneNumber {
    @Size(min = 10, max = 14,message = "Number has to be between 10 and 14 numbers")
    private String phoneNumber;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
