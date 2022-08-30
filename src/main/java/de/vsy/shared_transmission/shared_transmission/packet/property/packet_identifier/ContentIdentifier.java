/*
 *
 */
package de.vsy.shared_transmission.shared_transmission.packet.property.packet_identifier;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.vsy.shared_transmission.shared_transmission.packet.property.packet_category.PacketCategory;
import de.vsy.shared_transmission.shared_transmission.packet.property.packet_type.PacketType;

import java.io.Serializable;

/**
 * Used to ensure Type of PacketCategory and PacketType are used to identify a
 * Packet
 */
@JsonDeserialize(as = ContentIdentifierImpl.class)
public
interface ContentIdentifier extends Serializable {

    /**
     * Gets the PacketCategory.
     *
     * @return the PacketCategory
     */
    PacketCategory getPacketCategory ();

    /**
     * Gets the PacketType.
     *
     * @return the PacketType
     */
    PacketType getPacketType ();
}
