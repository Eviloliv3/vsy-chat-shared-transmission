/*
 *
 */
package de.vsy.shared_transmission.packet.property.packet_identifier;

import de.vsy.shared_transmission.packet.property.packet_category.PacketCategory;
import de.vsy.shared_transmission.packet.property.packet_type.PacketType;
import java.io.Serial;

/**
 * The Class AuthenticationIdentifier.
 */
public class AuthenticationIdentifier extends ContentIdentifierImpl {

  private static final PacketCategory CATEGORY = PacketCategory.AUTHENTICATION;
  @Serial
  private static final long serialVersionUID = -657085643790868961L;

  /**
   * Instantiates a new authentication identifier.
   *
   * @param type the type
   */
  public AuthenticationIdentifier(final PacketType type) {
    super(CATEGORY, type);
  }
}
