package de.vsy.shared_transmission.shared_transmission.dto.builder;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import de.vsy.shared_transmission.shared_transmission.dto.authentication.AuthenticationDTO;

@JsonPOJOBuilder
public class PersonalDataBuilder {

  private String forename;
  private String surname;

  public AuthenticationDTO build() {
    return AuthenticationDTO.valueOf(this.forename, this.surname);
  }

  public PersonalDataBuilder withForename(String forename) {
    if (forename == null) {
      throw new IllegalArgumentException("Kein Vorname angegeben.");
    }
    this.forename = forename;
    return this;
  }

  public PersonalDataBuilder withSurname(String surname) {
    if (surname == null) {
      throw new IllegalArgumentException("Kein Nachname angegeben.");
    }
    this.surname = surname;
    return this;
  }
}
