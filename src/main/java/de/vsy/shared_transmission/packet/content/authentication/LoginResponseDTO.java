/*
 *
 */
package de.vsy.shared_transmission.packet.content.authentication;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import de.vsy.shared_transmission.dto.CommunicatorDTO;
import de.vsy.shared_transmission.packet.content.PacketContent;
import java.io.Serial;
import java.util.Objects;

/**
 * The Class LoginResponseDTO.
 */
@JsonTypeName("loginResponse")
public class LoginResponseDTO implements PacketContent {

  @Serial
  private static final long serialVersionUID = 697983373949759504L;
  private final CommunicatorDTO clientCommunicatorData;

  @JsonCreator
  public LoginResponseDTO(@JsonProperty("clientData") final CommunicatorDTO clientData) {
    this.clientCommunicatorData = clientData;
  }

  @Override
  public int hashCode() {
    return 53 * Objects.hashCode(this.clientCommunicatorData);
  }

  @Override
  public boolean equals(Object otherObject) {
    if (this == otherObject) {
      return true;
    }
    if (!(otherObject instanceof LoginResponseDTO that)) {
      return false;
    }
    return Objects.equals(this.clientCommunicatorData, that.getClientData());
  }

  public CommunicatorDTO getClientData() {
    return this.clientCommunicatorData;
  }

  @Override
  public String toString() {
    var clientDataString =
        (this.clientCommunicatorData != null) ? this.clientCommunicatorData.toString() : "null";

    return "\"LoginResponseDTO\": { \"clientData\": " + clientDataString + "}";
  }
}
