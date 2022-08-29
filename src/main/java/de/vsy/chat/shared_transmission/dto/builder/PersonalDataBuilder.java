package de.vsy.chat.shared_transmission.dto.builder;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import de.vsy.chat.shared_transmission.dto.authentication.AuthenticationDTO;

import static de.vsy.chat.shared_transmission.dto.authentication.AuthenticationDTO.valueOf;

@JsonPOJOBuilder
public
class PersonalDataBuilder {

    private String forename;
    private String surname;

    public
    AuthenticationDTO build () {
        return valueOf(this.forename, this.surname);
    }

    public
    PersonalDataBuilder withForename (String forename) {
        if (forename == null) {
            throw new NullPointerException("Kein Vorname angegeben.");
        }
        this.forename = forename;
        return this;
    }

    public
    PersonalDataBuilder withSurname (String surname) {
        if (surname == null) {
            throw new NullPointerException("Kein Nachname angegeben.");
        }
        this.surname = surname;
        return this;
    }
}
