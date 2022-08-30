package de.vsy.shared_transmission.shared_transmission.dto.authentication;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@JsonTypeName("authenticationDTO")
public
class AuthenticationDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -8962330230266426192L;
    private final String login;
    private final String password;

    private
    AuthenticationDTO (final String login, final String password) {
        this.login = login;
        this.password = password;
    }

    @JsonCreator
    public static
    AuthenticationDTO valueOf (@JsonProperty("login") final String login,
                               @JsonProperty("password") final String password) {
        if (login == null) {
            throw new NullPointerException("Kein Login angegeben.");
        }
        if (password == null) {
            throw new NullPointerException("Kein Passwort angegeben.");
        }
        return new AuthenticationDTO(login, password);
    }

    @Override
    public
    int hashCode () {
        return 53 * Objects.hashCode(this.login) + Objects.hashCode(this.password);
    }

    @Override
    public
    boolean equals (Object otherObject) {
        if (this == otherObject) {
            return true;
        }

        if (!(otherObject instanceof AuthenticationDTO that)) {
            return false;
        }
        return Objects.equals(this.login, that.getLogin()) &&
               Objects.equals(this.password, that.getPassword());
    }

    public
    String getLogin () {
        return this.login;
    }

    public
    String getPassword () {
        return this.password;
    }

    @Override
    public
    String toString () {
        return "\"authenticationDTO\": { \"login\": \"" + this.login + "\", " +
               "\"password\": \"" + this.password + "\" }";
    }
}
