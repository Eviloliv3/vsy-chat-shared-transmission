package de.vsy.chat.shared_transmission.packet.property.packet_type;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.io.Serializable;

/**
 * Ausschliesslich Enumerationen, die einen bestimmten Paketinhaltstyp
 * identifizieren, dürfen diese Schnittstelle anbieten.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS,
              property = "class")
public
interface PacketType extends Serializable {}
