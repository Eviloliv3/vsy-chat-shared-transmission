/*
 *
 */
package de.vsy.chat.shared_transmission.packet.property.packet_type;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

/** The Class ChatType. */
@JsonTypeName("chatEnum")
public
enum ChatType implements PacketType {
    @JsonProperty("GROUP_MESSAGE") GROUP_MESSAGE,
    @JsonProperty("GROUP_REGISTER") GROUP_REGISTRATION,
    @JsonProperty("TEXT_MESSAGE") TEXT_MESSAGE
}
