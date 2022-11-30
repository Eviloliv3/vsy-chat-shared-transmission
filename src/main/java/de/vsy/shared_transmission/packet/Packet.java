package de.vsy.shared_transmission.packet;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import de.vsy.shared_transmission.packet.content.PacketContent;
import de.vsy.shared_transmission.packet.property.PacketProperties;
import java.io.Serializable;
import java.time.Instant;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "@class")
public interface Packet extends Serializable {

  /**
   * Returns the Packet's properties.
   *
   * @return PacketProperties
   */
  PacketProperties getPacketProperties();

  /**
   * Returns the PacketContent.
   *
   * @return PacketContent
   */
  PacketContent getPacketContent();

  /**
   * Returns the Instant the Packet was created.
   *
   * @return Instant
   */
  Instant getPacketCreationTimestamp();

  /**
   * Returns the Packet's SHA-1 value.
   *
   * @return String
   */
  String getPacketHash();

  /**
   * Calculates the SHA-1 hash value for the current Packet. Should be called during or right after
   * the Packet's creation, to keep the Packet consistently traceable.
   */
  void calculatePacketHash();

  /**
   * Returns the request Packet's hash value.
   *
   * @return String
   */
  String getRequestPacketHash();

  /*
   * The following methods have to be implemented, to be able to organize Packets in Collections.
   */
  @Override
  int hashCode();

  @Override
  boolean equals(Object otherObject);

  @Override
  String toString();
}
