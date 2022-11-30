package de.vsy.shared_transmission.packet.content.relation;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import de.vsy.shared_transmission.dto.CommunicatorDTO;
import de.vsy.shared_transmission.packet.content.PacketContent;
import de.vsy.shared_transmission.packet.content.Translatable;
import java.io.Serial;
import java.util.Objects;

/**
 * The Class ContactRelationResponseDTO.
 */
@JsonTypeName("contactRelationResponseDTO")
public class ContactRelationResponseDTO implements PacketContent, Translatable {

  @Serial
  private static final long serialVersionUID = 2325284672548469363L;
  private final ContactRelationRequestDTO requestData;
  private final boolean decision;
  private final CommunicatorDTO respondingClient;

  public ContactRelationResponseDTO(CommunicatorDTO respondingClient, boolean decision,
      ContactRelationRequestDTO requestData) {
    this(requestData, respondingClient, decision);
  }

  /**
   * Instantiates a new request dataManagement.
   *
   * @param requestData      the request data
   * @param respondingClient the responding clients' data
   * @param decision         the decision
   */
  private ContactRelationResponseDTO(final ContactRelationRequestDTO requestData,
      final CommunicatorDTO respondingClient, final boolean decision) {
    this.requestData = requestData;
    this.respondingClient = respondingClient;
    this.decision = decision;
  }

  @JsonCreator
  public static ContactRelationResponseDTO valueOf(
      @JsonProperty("requestData") final ContactRelationRequestDTO requestData,
      @JsonProperty("respondingClient") final CommunicatorDTO respondingClient,
      @JsonProperty("decision") final boolean decision) {
    if (requestData == null) {
      throw new IllegalArgumentException("No request specified.");
    }
    if (respondingClient == null) {
      throw new IllegalArgumentException("No contact communicator data specified.");
    }
    return new ContactRelationResponseDTO(requestData, respondingClient, decision);
  }

  @Override
  public int hashCode() {
    var hash = 53 * this.requestData.hashCode();
    hash = 53 * hash + Objects.hashCode(this.respondingClient);
    return 53 * hash + Boolean.hashCode(this.decision);
  }

  @Override
  public boolean equals(Object otherObject) {
    if (this == otherObject) {
      return true;
    }
    if (!(otherObject instanceof ContactRelationResponseDTO that)) {
      return false;
    }
    final var requestData = that.getRequestData();
    return this.requestData.getDesiredState() == requestData.getDesiredState()
        && this.decision == that.getDecision()
        && this.requestData.getContactType() == requestData.getContactType()
        && Objects.equals(this.respondingClient, that.getRespondingClient());
  }

  /**
   * Gets the decision.
   *
   * @return the decision
   */
  public boolean getDecision() {
    return this.decision;
  }

  /**
   * Gets the contact dataManagement.
   *
   * @return the contact dataManagement
   */
  public CommunicatorDTO getRespondingClient() {
    return this.respondingClient;
  }

  public ContactRelationRequestDTO getRequestData() {
    return this.requestData;
  }

  @Override
  public String toString() {
    final var sb = new StringBuilder();
    final var requestDataString = (this.requestData != null) ? this.requestData.toString() : "none";
    final var respondingClientDataString =
        (this.respondingClient != null) ? this.respondingClient.toString()
            : "none";
    sb.append("\"contactRelationResponse\": { ").append("\"requestData\": ")
        .append(requestDataString)
        .append(", \"actualState\": ").append(this.decision)
        .append(", \"contactCommunicatorData\": {")
        .append(respondingClientDataString).append("}}}");
    return sb.toString();
  }
}
