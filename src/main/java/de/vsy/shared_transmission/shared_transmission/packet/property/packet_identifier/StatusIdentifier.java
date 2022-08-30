/*
 *
 */
package de.vsy.shared_transmission.shared_transmission.packet.property.packet_identifier;

import de.vsy.shared_transmission.shared_transmission.packet.property.packet_category.PacketCategory;
import de.vsy.shared_transmission.shared_transmission.packet.property.packet_type.PacketType;

import java.io.Serial;

/** The Class StatusIdentifier. */
public
class StatusIdentifier extends ContentIdentifierImpl {

    private static final PacketCategory CATEGORY = PacketCategory.STATUS;
    @Serial
    private static final long serialVersionUID = -6912925590033317914L;

    /**
     * Instantiates a new status identifier.
     *
     * @param type the type
     */
    public
    StatusIdentifier (final PacketType type) {
        super(CATEGORY, type);
    }
}
