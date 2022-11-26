/*
 *
 */
package de.vsy.shared_transmission.packet.content.authentication;

import static de.vsy.shared_transmission.dto.authentication.AuthenticationDTO.valueOf;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import de.vsy.shared_transmission.dto.authentication.AuthenticationDTO;
import de.vsy.shared_transmission.packet.content.PacketContent;
import java.io.Serial;
import java.util.Objects;

/**
 * The Class LoginRequestDTO.
 */
@JsonTypeName("loginRequest")
public class LoginRequestDTO implements PacketContent {

  @Serial
  private static final long serialVersionUID = 8352421415811718387L;
  private final AuthenticationDTO authenticationData;

  /**
   * Instantiates a new login request dataManagement.
   *
   * @param login    the login name
   * @param password the password
   */
  public LoginRequestDTO(final String login, final String password) {
    this(valueOf(login, password));
  }

  @JsonCreator
  public LoginRequestDTO(@JsonProperty("primaryData") final AuthenticationDTO authData) {
    this.authenticationData = authData;
  }

  public AuthenticationDTO getAuthenticationData() {
    return this.authenticationData;
  }

  @Override
  public int hashCode() {
    return 53 * Objects.hashCode(this.authenticationData);
  }

  @Override
  public boolean equals(Object otherObject) {
    if (this == otherObject) {
      return true;
    }
    if (!(otherObject instanceof LoginRequestDTO that)) {
      return false;
    }
    return Objects.equals(this.authenticationData, that.authenticationData);
  }

  @Override
  public String toString() {
    var authDataString =
        (this.authenticationData != null) ? this.authenticationData.toString() : "null";

    return "\"LoginRequestDTO\": { \"authenticationData\": " + authDataString + "}";
  }
}
