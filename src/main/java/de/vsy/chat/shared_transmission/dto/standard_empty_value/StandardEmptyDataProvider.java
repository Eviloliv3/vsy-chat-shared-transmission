package de.vsy.chat.shared_transmission.dto.standard_empty_value;

import de.vsy.chat.shared_transmission.dto.CommunicatorDTO;
import de.vsy.chat.shared_transmission.dto.authentication.AuthenticationDTO;
import de.vsy.chat.shared_transmission.dto.authentication.PersonalData;

import static de.vsy.chat.shared_utility.standard_value.StandardIdProvider.STANDARD_CLIENT_ID;
import static de.vsy.chat.shared_utility.standard_value.StandardStringProvider.STANDARD_EMPTY_STRING;

public
class StandardEmptyDataProvider {

    public static final AuthenticationDTO EMPTY_AUTHENTICATION = AuthenticationDTO.valueOf(
            STANDARD_EMPTY_STRING, STANDARD_EMPTY_STRING);
    public static final CommunicatorDTO EMPTY_COMMUNICATOR = CommunicatorDTO.valueOf(
            STANDARD_CLIENT_ID, STANDARD_EMPTY_STRING);
    public static final PersonalData EMTPY_PERSONALDATA = PersonalData.valueOf(
            STANDARD_EMPTY_STRING, STANDARD_EMPTY_STRING);
    protected
    StandardEmptyDataProvider () {}
}
