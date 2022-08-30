/*
 *
 */
package de.vsy.shared_transmission.shared_transmission.packet.property.packet_type;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

/** The Class StatusType. */
@JsonTypeName("statusEnum")
public
enum StatusType implements PacketType {
    @JsonProperty("CHAT_STATUS") CHAT_STATUS
}
