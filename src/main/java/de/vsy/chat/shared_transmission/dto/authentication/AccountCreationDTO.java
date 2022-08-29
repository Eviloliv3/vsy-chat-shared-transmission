package de.vsy.chat.shared_transmission.dto.authentication;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@JsonTypeName("accountCreationDTO")
public
class AccountCreationDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 6297248743740045922L;
    private final AuthenticationDTO authenticationData;
    private final PersonalData clientPersonalData;

    @JsonCreator
    public
    AccountCreationDTO (
            @JsonProperty("authenticationData") AuthenticationDTO authData,
            @JsonProperty("clientData") PersonalData clientData) {
        this.authenticationData = authData;
        this.clientPersonalData = clientData;
    }

    public
    AuthenticationDTO getAuthenticationData () {
        return this.authenticationData;
    }

    public
    PersonalData getPersonalData () {
        return this.clientPersonalData;
    }

    @Override
    public
    int hashCode () {
        return 53 * Objects.hashCode(this.authenticationData) +
               Objects.hashCode(this.clientPersonalData);
    }

    @Override
    public
    boolean equals (Object otherObject) {
        if (this == otherObject) {
            return true;
        }

        if (!(otherObject instanceof AccountCreationDTO that)) {
            return false;
        }
        return this.authenticationData.equals(that.authenticationData) &&
               this.clientPersonalData.equals(that.clientPersonalData);
    }

    @Override
    public
    String toString () {
        final var authDataString = (this.authenticationData !=
                                    null) ? this.authenticationData.toString() : "null";
        final var clientDataString = (this.clientPersonalData !=
                                      null) ? this.clientPersonalData.toString() : "null";

        return "\"accountCreationDTO\": { \"authenticationData\": " +
               authDataString + ", \"clientData\": " + clientDataString + " }";
    }
}
