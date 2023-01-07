package de.vsy.shared_transmission.dto.builder;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import de.vsy.shared_transmission.dto.authentication.AuthenticationDTO;

@JsonPOJOBuilder
public class PersonalDataBuilder {

    private String firstName;
    private String lastName;

    public AuthenticationDTO build() {
        return AuthenticationDTO.valueOf(this.firstName, this.lastName);
    }

    public PersonalDataBuilder withFirstName(String firstName) {
        if (firstName == null) {
            throw new IllegalArgumentException("No first name specified.");
        }
        this.firstName = firstName;
        return this;
    }

    public PersonalDataBuilder withLastName(String lastName) {
        if (lastName == null) {
            throw new IllegalArgumentException("No last name specified.");
        }
        this.lastName = lastName;
        return this;
    }
}
