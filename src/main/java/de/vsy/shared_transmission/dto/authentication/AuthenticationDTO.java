package de.vsy.shared_transmission.dto.authentication;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@JsonTypeName("authenticationDTO")
public class AuthenticationDTO implements Serializable {

  @Serial
  private static final long serialVersionUID = -8962330230266426192L;
  private final String username;
  private final String password;

  private AuthenticationDTO(final String username, final String password) {
    this.username = username;
    this.password = password;
  }

  @JsonCreator
  public static AuthenticationDTO valueOf(@JsonProperty("username") final String username,
      @JsonProperty("password") final String password) {
    if (username == null) {
      throw new IllegalArgumentException("No user name specified.");
    }
    if (password == null) {
      throw new IllegalArgumentException("No password specified.");
    }
    return new AuthenticationDTO(username, password);
  }

  @Override
  public int hashCode() {
    return 53 * Objects.hashCode(this.username) + Objects.hashCode(this.password);
  }

  @Override
  public boolean equals(Object otherObject) {
    if (this == otherObject) {
      return true;
    }

    if (!(otherObject instanceof AuthenticationDTO that)) {
      return false;
    }
    return Objects.equals(this.username, that.getUsername()) && Objects.equals(this.password,
        that.getPassword());
  }

  public String getUsername() {
    return this.username;
  }

  public String getPassword() {
    return this.password;
  }

  @Override
  public String toString() {
    return "\"authenticationDTO\": { \"username\": \"" + this.username + "\", " + "\"password\": \""
        + this.password
        + "\" }";
  }
}
