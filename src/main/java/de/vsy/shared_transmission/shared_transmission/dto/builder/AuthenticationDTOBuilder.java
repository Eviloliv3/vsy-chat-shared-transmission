package de.vsy.shared_transmission.shared_transmission.dto.builder;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import de.vsy.shared_transmission.shared_transmission.dto.authentication.AuthenticationDTO;

@JsonPOJOBuilder
public class AuthenticationDTOBuilder {

  private String login;
  private String password;

  public AuthenticationDTO build() {
    return AuthenticationDTO.valueOf(this.login, this.password);
  }

  public AuthenticationDTOBuilder withLogin(String login) {
    if (login == null) {
      throw new IllegalArgumentException("Kein Login angegeben.");
    }
    this.login = login;
    return this;
  }

  /**
   * @param password das einfach gehashte Passwort in Hexadezimaldarstellung (String)
   * @return das Erbauer Objekt
   * @throws NullPointerException wenn einer der Parameter nicht vorhanden ist
   */
  public AuthenticationDTOBuilder withPassword(final String password) {
    if (password == null) {
      throw new IllegalArgumentException("Kein Passwort angegeben.");
    }
    this.password = password;
    return this;
  }
}
