/*
 *
 */
package de.vsy.shared_transmission.packet.property.packet_identifier;

import de.vsy.shared_transmission.packet.property.packet_category.PacketCategory;
import de.vsy.shared_transmission.packet.property.packet_type.PacketType;
import java.io.Serial;

/**
 * The Class ChatIdentifier.
 */
public class ChatIdentifier extends ContentIdentifierImpl {

  private static final PacketCategory CATEGORY = PacketCategory.CHAT;
  @Serial
  private static final long serialVersionUID = 7748429347611012814L;

  /**
   * Instantiates a new chat identifier.
   *
   * @param type the type
   */
  public ChatIdentifier(final PacketType type) {
    super(CATEGORY, type);
  }
}
