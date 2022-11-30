package de.vsy.shared_transmission.dto.builder;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import de.vsy.shared_transmission.dto.authentication.AuthenticationDTO;

@JsonPOJOBuilder
public class AuthenticationDTOBuilder {

  private String login;
  private String password;

  public AuthenticationDTO build() {
    return AuthenticationDTO.valueOf(this.login, this.password);
  }

  public AuthenticationDTOBuilder withLogin(String login) {
    if (login == null) {
      throw new IllegalArgumentException("No username specified.");
    }
    this.login = login;
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
