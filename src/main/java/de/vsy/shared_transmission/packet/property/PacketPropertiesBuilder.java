package de.vsy.shared_transmission.packet.property;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import de.vsy.shared_transmission.packet.property.communicator.CommunicationEndpoint;
import de.vsy.shared_transmission.packet.property.packet_identifier.ContentIdentifier;

@JsonPOJOBuilder
public class PacketPropertiesBuilder {

  private ContentIdentifier identifier;
  private CommunicationEndpoint sender;
  private CommunicationEndpoint recipient;

  public PacketProperties build() {
    return new PacketPropertiesImpl(sender, recipient, identifier);
  }

  public PacketPropertiesBuilder withSender(CommunicationEndpoint sender) {
    this.sender = sender;
    return this;
  }

  public PacketPropertiesBuilder withRecipient(CommunicationEndpoint recipient) {
    this.recipient = recipient;
    return this;
  }

  public PacketPropertiesBuilder withIdentifier(ContentIdentifier identifier) {
    this.identifier = identifier;
    return this;
  }
}
