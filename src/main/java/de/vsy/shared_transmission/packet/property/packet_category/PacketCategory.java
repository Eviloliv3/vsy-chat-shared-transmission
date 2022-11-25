package de.vsy.shared_transmission.packet.property.packet_category;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Enum PacketCategory.
 */
public enum PacketCategory {
  @JsonProperty("AUTHENTICATION")
  AUTHENTICATION(true), @JsonProperty("CHAT")
  CHAT(false), @JsonProperty("ERROR")
  ERROR(false), @JsonProperty("RELATION")
  RELATION(false), @JsonProperty("STATUS")
  STATUS(true);

  private final boolean localOnly;

  PacketCategory(final boolean localOnly) {
    this.localOnly = localOnly;
  }

  public boolean islocalUseOnly() {
    return this.localOnly;
  }
}
