/*
 *
 */
package de.vsy.chat.shared_transmission.packet.property.packet_type;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

/** The Class ErrorType. */
@JsonTypeName("errorEnum")
public
enum ErrorType implements PacketType {
    @JsonProperty("SIMPLE_ERROR") SIMPLE_ERROR
}
