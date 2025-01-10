package com.eazybytes.eazyschool.eazyschool.model;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class Contact {

    @NotBlank(message = "Name should not be blank")
    @Size(min = 3, message = "Size should be at least 3 characters")
    private String name;

    @NotBlank(message = "Mobile Number should not be blank")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
    private String mobileNum;

    @Email(message = "Enter a valid email address")
    @NotBlank(message = "Email should not be blank")
    private String email;

    @NotBlank(message = "Subject must not be blank")
    @Size(min = 5, message = "Subject must be at least 5 characters long")
    private String subject;

    @NotBlank(message = "Message must not be blank")
    @Size(min = 10, message = "Message must be at least 10 characters long")
    private String message;
}
