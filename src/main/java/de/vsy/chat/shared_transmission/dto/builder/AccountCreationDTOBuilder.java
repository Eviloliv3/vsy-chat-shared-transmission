package de.vsy.chat.shared_transmission.dto.builder;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import de.vsy.chat.shared_transmission.dto.authentication.AccountCreationDTO;
import de.vsy.chat.shared_transmission.dto.authentication.AuthenticationDTO;
import de.vsy.chat.shared_transmission.dto.authentication.PersonalData;

@JsonPOJOBuilder
public
class AccountCreationDTOBuilder {

    private AuthenticationDTO authenticationData;
    private PersonalData personalData;

    public
    AccountCreationDTO build () {
        return new AccountCreationDTO(authenticationData, personalData);
    }

    public
    AccountCreationDTOBuilder withAuthenticationData (AuthenticationDTO authData) {
        if (authData == null) {
            throw new NullPointerException(
                    "Keine Authentifizierungsdaten angegeben.");
        }
        this.authenticationData = authData;
        return this;
    }

    public
    AccountCreationDTOBuilder withPersonalData (PersonalData personalData) {
        if (personalData == null) {
            throw new NullPointerException("Keine Personaldaten angegeben.");
        }
        this.personalData = personalData;
        return this;
    }
}
