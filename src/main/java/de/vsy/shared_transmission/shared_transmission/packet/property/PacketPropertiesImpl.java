/*
 *
 */
package de.vsy.shared_transmission.shared_transmission.packet.property;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import de.vsy.shared_transmission.shared_transmission.packet.property.communicator.CommunicationEndpoint;
import de.vsy.shared_transmission.shared_transmission.packet.property.packet_identifier.ContentIdentifier;
import java.io.Serial;

/**
 * Basic PacketProperties containing an identifier indicating the PacketContent, a
 * CommunicationEndpoint identifying the sender and a CommunicationEndpoint used to identify the
 * recipient.
 */
public class PacketPropertiesImpl implements PacketProperties {

  /**
   * The Constant serialVersionUID.
   */
  @Serial
  private static final long serialVersionUID = -4869253504191133523L;
  private final ContentIdentifier identifier;
  private final CommunicationEndpoint sender;
  private final CommunicationEndpoint recipient;

  /**
   * Instantiates a new PacketProperties.
   *
   * @param senderEntity    the sender entity
   * @param recipientEntity the recipient entity
   * @param identifier      the identifier
   */
  @JsonCreator
  public PacketPropertiesImpl(@JsonProperty("sender") final CommunicationEndpoint senderEntity,
      @JsonProperty("recipient") final CommunicationEndpoint recipientEntity,
      @JsonProperty("packetIdentificationProvider") final ContentIdentifier identifier) {
    this.sender = senderEntity;
    this.recipient = recipientEntity;
    this.identifier = identifier;
  }

  /**
   * Checks for identical content.
   *
   * @param otherProperties the other properties
   * @return true, if successful
   */
  public boolean hasIdenticalContent(final PacketProperties otherProperties) {

    if (otherProperties != null) {
      return this.identifier.equals(otherProperties.getPacketIdentificationProvider())
          && this.sender.equals(otherProperties.getSender())
          && this.recipient.equals(otherProperties.getRecipient());
    }
    return false;
  }

  /**
   * Gets the sender.
   *
   * @return the sender
   */
  @Override
  public CommunicationEndpoint getSender() {
    return this.sender;
  }

  /**
   * Gets the recipient.
   *
   * @return the recipient
   */
  @Override
  public CommunicationEndpoint getRecipient() {
    return this.recipient;
  }

  /**
   * Gets the PacketIdentifier.
   *
   * @return the PacketIdentifier
   */
  @Override
  public ContentIdentifier getPacketIdentificationProvider() {
    return this.identifier;
  }

  @Override
  public String toString() {
    final var sb = new StringBuilder();
    final var senderIdString = (this.sender != null) ? this.sender.toString() : null;
    final var recipientIdString = (this.recipient != null) ? this.recipient.toString() : null;
    final var identifierString = (this.identifier != null) ? this.identifier.toString() : null;
    sb.append("{ \"senderEntity\": {").append(senderIdString).append("}, \"recipientEntity\": {")
        .append(recipientIdString).append("}, \"PacketIdentifier\": {").append(identifierString)
        .append("} }");
    return sb.toString();
  }
}
