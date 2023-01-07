package de.vsy.shared_transmission.packet.property.packet_type;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.io.Serializable;

/**
 * Only enumerations that are used to identify a PacketContent type are allowed to implement this
 * interface.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "class")
public interface PacketType extends Serializable {

}
