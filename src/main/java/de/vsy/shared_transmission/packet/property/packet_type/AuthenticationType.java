/*
 *
 */
package de.vsy.shared_transmission.packet.property.packet_type;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * The Class AuthenticationType.
 */
@JsonTypeName("authenticationEnum")
public enum AuthenticationType implements PacketType {
    @JsonProperty("CLIENT_LOGIN")
    CLIENT_LOGIN, @JsonProperty("CLIENT_LOGOUT")
    CLIENT_LOGOUT, @JsonProperty("CLIENT_ACCOUNT_CREATION")
    CLIENT_ACCOUNT_CREATION, @JsonProperty("CLIENT_RECONNECT")
    CLIENT_RECONNECT, @JsonProperty("CLIENT_ACCOUNT_DELETION")
    CLIENT_ACCOUNT_DELETION
}
