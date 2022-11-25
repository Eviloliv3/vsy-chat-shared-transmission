/*
 *
 */
package de.vsy.shared_transmission.packet.property.packet_identifier;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import de.vsy.shared_transmission.packet.property.packet_category.PacketCategory;
import de.vsy.shared_transmission.packet.property.packet_type.PacketType;
import java.io.Serial;

/**
 * Identifies a Packets content.
 */
public class ContentIdentifierImpl implements ContentIdentifier {

  @Serial
  private static final long serialVersionUID = -1171305389398320702L;
  private final PacketCategory packetCategory;
  private final PacketType packetType;

  /**
   * Instantiates a new PacketIdentifier.
   *
   * @param packetCategory the packet category
   * @param packetType     the packet category
   */
  @JsonCreator
  public ContentIdentifierImpl(@JsonProperty("packetCategory") final PacketCategory packetCategory,
      @JsonProperty("packetType") final PacketType packetType) {
    this.packetCategory = packetCategory;
    this.packetType = packetType;
  }

  @Override
  public int hashCode() {
    int hashCode = 93 * packetCategory.hashCode();
    return hashCode + (93 * packetType.hashCode());
  }

  @Override
  public boolean equals(final Object otherObject) {
    if (this == otherObject) {
      return true;
    }

    if (!(otherObject instanceof ContentIdentifierImpl otherIdentifier)) {
      return false;
    }
    return packetCategory.equals(otherIdentifier.getPacketCategory())
        && this.packetType.equals(otherIdentifier.getPacketType());
  }

  @Override
  public PacketCategory getPacketCategory() {
    return this.packetCategory;
  }

  @Override
  public PacketType getPacketType() {
    return this.packetType;
  }

  @Override
  public String toString() {
    return "\"packetCategory\": " + this.packetCategory + ", \"packetType\": " + this.packetType;
  }
}
