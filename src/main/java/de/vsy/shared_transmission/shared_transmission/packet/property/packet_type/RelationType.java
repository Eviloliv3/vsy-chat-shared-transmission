package de.vsy.shared_transmission.shared_transmission.packet.property.packet_type;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

/** The Enum RelationType. */
@JsonTypeName("relationEnum")
public
enum RelationType implements PacketType {
    @JsonProperty("CONTACT_RELATION") CONTACT_RELATION
}
