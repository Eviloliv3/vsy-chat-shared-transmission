/*
 *
 */
package de.vsy.shared_transmission.packet.content.relation;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import de.vsy.shared_transmission.dto.CommunicatorDTO;
import de.vsy.shared_transmission.packet.content.HumanInteractionRequest;
import de.vsy.shared_transmission.packet.content.PacketContent;

import java.io.Serial;
import java.util.Objects;

/**
 * The Class ContactRelationRequestDTO.
 */
@JsonTypeName("ContactRelationRequestDTO")
public class ContactRelationRequestDTO implements PacketContent, HumanInteractionRequest {

    @Serial
    private static final long serialVersionUID = 2505840980945728682L;
    private final EligibleContactEntity contactType;
    private final boolean desiredState;
    private final int originatorId;
    private final int recipientId;
    private final CommunicatorDTO requestingClient;

    /**
     * Instantiates a new request dataManagement.
     *
     * @param contactType      the contact type
     * @param originatorId     the originator id
     * @param recipientId      the recipient id
     * @param requestingClient the requesting clients' data
     * @param desiredState     the desired state
     */
    @JsonCreator
    public ContactRelationRequestDTO(
            @JsonProperty("contactType") final EligibleContactEntity contactType,
            @JsonProperty("originatorId") final int originatorId,
            @JsonProperty("recipientId") final int recipientId,
            @JsonProperty("contactCommunicatorData") final CommunicatorDTO requestingClient,
            @JsonProperty("desiredState") final boolean desiredState) {
        this.contactType = contactType;
        this.originatorId = originatorId;
        this.recipientId = recipientId;
        this.requestingClient = requestingClient;
        this.desiredState = desiredState;
    }

    @Override
    public int hashCode() {
        var hash = 53 * Boolean.hashCode(this.desiredState);
        hash = 53 * hash + Objects.hashCode(this.contactType);
        hash = 53 * hash + Objects.hashCode(this.requestingClient);
        hash = 53 * hash * Integer.hashCode(this.originatorId);
        return 53 * hash + Integer.hashCode(this.recipientId);
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (!(otherObject instanceof ContactRelationRequestDTO that)) {
            return false;
        }
        return this.contactType == that.getContactType() && this.desiredState == that.getDesiredState()
                && this.originatorId == that.originatorId && this.recipientId == that.recipientId
                && Objects.equals(this.requestingClient, that.getRequestingClient());
    }

    /**
     * Returns the contact type.
     *
     * @return the contact type
     */
    public EligibleContactEntity getContactType() {
        return this.contactType;
    }

    /**
     * Returns the desired state.
     *
     * @return the desired state
     */
    @Override
    public boolean getDesiredState() {
        return this.desiredState;
    }

    /**
     * Returns the contact dataManagement.
     *
     * @return the contact dataManagement
     */
    public CommunicatorDTO getRequestingClient() {
        return this.requestingClient;
    }

    /**
     * Returns the originator id
     *
     * @return the originator id
     */
    @Override
    public int getOriginatorId() {
        return this.originatorId;
    }

    /**
     * Returns the recipient id
     *
     * @return the recipient id
     */
    @Override
    public int getRecipientId() {
        return this.recipientId;
    }

    @Override
    public PacketContent setDecision(CommunicatorDTO respondingClient, boolean decision) {
        return new ContactRelationResponseDTO(respondingClient, decision, this);
    }

    @Override
    public String toString() {
        final var sb = new StringBuilder();

        final var requestingClientDataString =
                (this.requestingClient != null) ? this.requestingClient.toString()
                        : null;
        sb.append("\"contactRelationRequest\": { ").append(", \"originatorId\": ")
                .append(this.originatorId)
                .append(", \"recipientId\": ").append(this.recipientId).append(", \"desiredState\": ")
                .append(this.desiredState).append(", \"contactCommunicatorData\": {")
                .append(requestingClientDataString)
                .append(" } }");
        return sb.toString();
    }
}
