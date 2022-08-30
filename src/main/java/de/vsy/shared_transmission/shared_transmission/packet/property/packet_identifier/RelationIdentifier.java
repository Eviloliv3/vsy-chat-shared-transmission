package de.vsy.shared_transmission.shared_transmission.packet.property.packet_identifier;

import de.vsy.shared_transmission.shared_transmission.packet.property.packet_category.PacketCategory;
import de.vsy.shared_transmission.shared_transmission.packet.property.packet_type.PacketType;

import java.io.Serial;

/** The Class RelationIdentifier. */
public
class RelationIdentifier extends ContentIdentifierImpl {

    private static final PacketCategory CATEGORY = PacketCategory.RELATION;
    @Serial
    private static final long serialVersionUID = 2261460137022097322L;

    /**
     * Instantiates a new relation identifier.
     *
     * @param type the type
     */
    public
    RelationIdentifier (final PacketType type) {
        super(CATEGORY, type);
    }
}
