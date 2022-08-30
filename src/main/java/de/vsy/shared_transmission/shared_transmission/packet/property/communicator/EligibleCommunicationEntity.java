/*
 *
 */
package de.vsy.shared_transmission.shared_transmission.packet.property.communicator;

import com.fasterxml.jackson.annotation.JsonProperty;

/** The Enum EligibleCommunicationEntity. */
public
enum EligibleCommunicationEntity {
    @JsonProperty("CLIENT") CLIENT,
    @JsonProperty("GROUP") GROUP,
    @JsonProperty("SERVER") SERVER
}
