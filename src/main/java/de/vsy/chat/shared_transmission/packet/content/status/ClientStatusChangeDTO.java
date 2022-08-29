package de.vsy.chat.shared_transmission.packet.content.status;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import de.vsy.chat.shared_transmission.dto.CommunicatorDTO;
import de.vsy.chat.shared_transmission.packet.content.PacketContent;

import java.io.Serial;
import java.util.Objects;

/**
 * The Class ClientStatusDTO.
 *
 * @author Frederic Heath
 */
@JsonTypeName("clientStatusChangeDTO")
public
class ClientStatusChangeDTO implements PacketContent {

    @Serial
    private static final long serialVersionUID = 8006534314246383258L;
    private final ClientService serviceType;
    private final boolean onlineStatus;
    private CommunicatorDTO contactData;

    /**
     * Instantiates a new client status de.vsy.chat.shared_transmission.dto.
     *
     * @param serviceChoice the service choice
     * @param contactData the contact dataManagement
     * @param onlineStatus the online status
     */
    @JsonCreator
    public
    ClientStatusChangeDTO (
            @JsonProperty("serviceChoice") final ClientService serviceChoice,
            @JsonProperty("onlineStatus") final boolean onlineStatus,
            @JsonProperty("contactData") final CommunicatorDTO contactData) {
        this.serviceType = serviceChoice;
        this.onlineStatus = onlineStatus;
        this.contactData = contactData;
    }

    @Override
    public
    int hashCode () {
        var hash = 53 * Objects.hashCode(this.serviceType);
        hash = 53 * hash * Boolean.hashCode(this.onlineStatus);
        return 53 * hash * Objects.hashCode(this.contactData);
    }

    @Override
    public
    boolean equals (Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (!(otherObject instanceof ClientStatusChangeDTO that)) {
            return false;
        }
        return this.onlineStatus == that.getOnlineStatus() &&
               this.serviceType == that.getServiceType() &&
               Objects.equals(this.contactData, that.getContactData());
    }

    /**
     * Gets the online status.
     *
     * @return the online status
     */
    public
    boolean getOnlineStatus () {
        return this.onlineStatus;
    }

    /**
     * Gets the service choice.
     *
     * @return the service choice
     */
    public
    ClientService getServiceType () {
        return this.serviceType;
    }

    /**
     * Gets the contact dataManagement.
     *
     * @return the contact dataManagement
     */
    public
    CommunicatorDTO getContactData () {
        return this.contactData;
    }

    /**
     * Sets the contact dataManagement.
     *
     * @param contactCommunicatorData the new contact dataManagement
     */
    public
    void setContactData (final CommunicatorDTO contactCommunicatorData) {
        this.contactData = contactCommunicatorData;
    }

    @Override
    public
    String toString () {
        final var sb = new StringBuilder();

        final var contactCommunicatorDataString = (this.contactData !=
                                                   null) ? this.contactData.toString() : null;

        sb.append("\"ClientStatusChangeDTO\": { ")
          .append("\"serviceChoice:\": ")
          .append(this.serviceType)
          .append(", \"onlineState\": ")
          .append(this.onlineStatus)
          .append(", \"contactCommunicatorData\": {")
          .append(contactCommunicatorDataString)
          .append("}}");

        return sb.toString();
    }
}
