/*
 *
 */
package de.vsy.shared_transmission.packet.property.packet_identifier;

import de.vsy.shared_transmission.packet.property.packet_category.PacketCategory;
import de.vsy.shared_transmission.packet.property.packet_type.PacketType;
import java.io.Serial;

/**
 * The Class ErrorIdentifier.
 */
public class ErrorIdentifier extends ContentIdentifierImpl {

  private static final PacketCategory CATEGORY = PacketCategory.ERROR;
  @Serial
  private static final long serialVersionUID = 8298044570665042103L;

  /**
   * Instantiates a new error identifier.
   *
   * @param type the type
   */
  public ErrorIdentifier(final PacketType type) {
    super(CATEGORY, type);
  }
}
