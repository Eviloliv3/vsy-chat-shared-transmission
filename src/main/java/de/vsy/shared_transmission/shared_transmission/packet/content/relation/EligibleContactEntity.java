package de.vsy.shared_transmission.shared_transmission.packet.content.relation;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Enum EligibleContactEntity.
 */
public enum EligibleContactEntity {
  @JsonProperty("CLIENT")
  CLIENT, @JsonProperty("GROUP")
  GROUP
}
