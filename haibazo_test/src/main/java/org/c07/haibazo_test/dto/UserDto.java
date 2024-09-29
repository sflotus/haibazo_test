package org.c07.haibazo_test.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class UserDto {
    private Long id;
    @NotBlank(message = "please input name")
    // cho phép tên tiếng việt
    @Pattern(regexp = "^[\\p{L} ]{2,}(?: [\\p{L} ]{2,})*$", message = "Name is not contain number, special character")
    private String fullName;
    @NotBlank
    // kiểm tra định dạng email
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Invalid email")
    private String email;
    @NotBlank
    // kiểm tra định dạng username không có ký tự đặc biệt
    @Pattern(regexp = "^[a-zA-Z0-9]+$",message = "Username is not contain special character")
    private String userName;
    private String password;

    public UserDto() {
    }

    public UserDto(String fullName, String email, String userName, String password) {
        this.fullName = fullName;
        this.email = email;
        this.userName = userName;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
