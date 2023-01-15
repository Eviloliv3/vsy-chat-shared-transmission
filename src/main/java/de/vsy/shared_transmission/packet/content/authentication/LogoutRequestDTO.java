
package de.vsy.shared_transmission.packet.content.authentication;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import de.vsy.shared_transmission.dto.CommunicatorDTO;
import de.vsy.shared_transmission.packet.content.PacketContent;

import java.io.Serial;
import java.util.Objects;

/**
 * The Class LogoutRequestDTO.
 */
@JsonTypeName("logoutRequest")
public class LogoutRequestDTO implements PacketContent {

    @Serial
    private static final long serialVersionUID = 5357361773841514796L;
    private final CommunicatorDTO clientCommunicatorData;

    /**
     * Instantiates a new logout request dataManagement.
     *
     * @param clientData the client dataManagement
     */
    @JsonCreator
    public LogoutRequestDTO(@JsonProperty("clientData") final CommunicatorDTO clientData) {
        this.clientCommunicatorData = clientData;
    }

    @Override
    public int hashCode() {
        return 53 * Objects.hashCode(this.clientCommunicatorData);
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (!(otherObject instanceof LogoutRequestDTO that)) {
            return false;
        }
        return Objects.equals(this.clientCommunicatorData, that.getClientData());
    }

    public CommunicatorDTO getClientData() {
        return this.clientCommunicatorData;
    }

    @Override
    public String toString() {
        var clientCommunicatorDataString = (this.clientCommunicatorData != null)
                ? this.clientCommunicatorData.toString()
                : "null";

        return "\"logoutRequestDTO\": { \"clientCommunicatorData\": " + clientCommunicatorDataString
                + "}";
    }
}
