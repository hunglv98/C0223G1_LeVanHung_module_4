package com.example.ex_1.dto;

import javax.validation.constraints.*;

public class UserDto {
    @NotBlank(message = "Must be filled in this field")
    @Size(min = 5, max = 45)
    private String firstName;
    @NotBlank(message = "Must be filled in this field")
    @Size(min = 5, max = 45)
    private String lastName;
    @Pattern(regexp = "^0[0-9]{9}$", message = "Fill follow pattern 0-XXXXXXXXX with X is number")
    private String phoneNumber;
    @Min(value = 18, message = "Age is greater than 18")
    private int age;
    @Pattern(regexp = "^\\w+@\\w+.\\w+$", message = "Fill in blank with pattern xxx@xxx.xxx")
    private String email;

    public UserDto() {
    }

    public UserDto(String firstName, String lastName, String phoneNumber, int age, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
