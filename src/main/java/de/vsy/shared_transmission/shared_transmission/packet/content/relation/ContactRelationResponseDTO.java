package de.vsy.shared_transmission.shared_transmission.packet.content.relation;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import de.vsy.shared_transmission.shared_transmission.dto.CommunicatorDTO;
import de.vsy.shared_transmission.shared_transmission.packet.content.PacketContent;
import de.vsy.shared_transmission.shared_transmission.packet.content.Translatable;

import java.io.Serial;
import java.util.Objects;

/** The Class ContactRelationResponseDTO. */
@JsonTypeName("contactRelationResponseDTO")
public
class ContactRelationResponseDTO implements PacketContent, Translatable {

    @Serial
    private static final long serialVersionUID = 2325284672548469363L;
    private final ContactRelationRequestDTO requestData;
    private final boolean decision;
    private final CommunicatorDTO respondingClient;

    public
    ContactRelationResponseDTO (CommunicatorDTO respondingClient, boolean decision,
                                ContactRelationRequestDTO requestData) {
        this(requestData, respondingClient, decision);
    }

    /**
     * Instantiates a new request dataManagement.
     *
     * @param requestData the request data
     * @param respondingClient the responding clients' data
     * @param decision the decision
     */
    private
    ContactRelationResponseDTO (
            @JsonProperty("requestData") final ContactRelationRequestDTO requestData,
            @JsonProperty("contactCommunicatorData")
            final CommunicatorDTO respondingClient,
            @JsonProperty("decision") final boolean decision) {
        this.requestData = requestData;
        this.respondingClient = respondingClient;
        this.decision = decision;
    }

    @JsonCreator
    public static
    ContactRelationResponseDTO valueOf (
            @JsonProperty("requestData") final ContactRelationRequestDTO requestData,
            @JsonProperty("contactCommunicatorData")
            final CommunicatorDTO respondingClient,
            @JsonProperty("decision") final boolean decision) {
        if (requestData == null) {
            throw new IllegalArgumentException("Keine Anfrage angegeben.");
        }
        if (respondingClient == null) {
            throw new IllegalArgumentException("Keine Kontaktdaten angegeben.");
        }
        return new ContactRelationResponseDTO(requestData, respondingClient,
                                              decision);
    }

    @Override
    public
    int hashCode () {
        var hash = 53 * this.requestData.hashCode();
        hash = 53 * hash + Objects.hashCode(this.respondingClient);
        return 53 * hash + Boolean.hashCode(this.decision);
    }

    @Override
    public
    boolean equals (Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (!(otherObject instanceof ContactRelationResponseDTO that)) {
            return false;
        }
        return this.requestData.getDesiredState() == that.getDesiredState() &&
               this.decision == that.getDecision() &&
               this.requestData.getContactType() == that.getContactType() &&
               Objects.equals(this.respondingClient, that.getContactData());
    }

    /**
     * Gets the desired state.
     *
     * @return the desired state
     */
    public
    boolean getDesiredState () {
        return this.requestData.getDesiredState();
    }

    /**
     * Gets the decision.
     *
     * @return the decision
     */
    public
    boolean getDecision () {
        return this.decision;
    }

    /**
     * Gets the contact type.
     *
     * @return the contact type
     */
    public
    EligibleContactEntity getContactType () {
        return this.requestData.getContactType();
    }

    /**
     * Gets the contact dataManagement.
     *
     * @return the contact dataManagement
     */
    public
    CommunicatorDTO getContactData () {
        return this.respondingClient;
    }

    @Override
    public
    String toString () {
        final var sb = new StringBuilder();
        final var requestDataString = (this.requestData !=
                                       null) ? this.requestData.toString() : "none";
        final var respondingClientDataString = (this.respondingClient !=
                                                null) ? this.respondingClient.toString() : "none";
        sb.append("\"contactRelationResponse\": { ")
          .append("\"requestData\": ")
          .append(requestDataString)
          .append(", \"actualState\": ")
          .append(this.decision)
          .append(", \"contactCommunicatorData\": {")
          .append(respondingClientDataString)
          .append("}}}");
        return sb.toString();
    }

    /**
     * Gets the originator id
     *
     * @return the originator id
     */
    public
    int getOriginatorId () {
        return this.requestData.getOriginatorId();
    }

    /**
     * Gets the recipient id
     *
     * @return the recipient id
     */
    public
    int getRecipientId () {
        return this.requestData.getRecipientId();
    }
}
