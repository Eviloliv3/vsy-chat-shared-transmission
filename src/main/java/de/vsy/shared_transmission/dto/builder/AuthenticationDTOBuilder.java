package de.vsy.shared_transmission.dto.builder;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import de.vsy.shared_transmission.dto.authentication.AuthenticationDTO;

@JsonPOJOBuilder
public class AuthenticationDTOBuilder {

  private String username;
  private String password;

  public AuthenticationDTO build() {
    return AuthenticationDTO.valueOf(this.username, this.password);
  }

  public AuthenticationDTOBuilder withUsername(String username) {
    if (username == null) {
      throw new IllegalArgumentException("No username specified.");
    }
    this.username = username;
    return this;
  }

  /**
   * @param password the hashed password in hex form (String)
   * @return the authentication builder object
   * @throws NullPointerException on missing parameter
   */
  public AuthenticationDTOBuilder withPassword(final String password) {
    if (password == null) {
      throw new IllegalArgumentException("No password specified.");
    }
    this.password = password;
    return this;
  }
}
