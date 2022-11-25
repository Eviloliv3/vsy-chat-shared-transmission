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
 * The Class ReconnectRequestDTO.
 */
@JsonTypeName("reconnectRequest")
public class ReconnectRequestDTO implements PacketContent {

  @Serial
  private static final long serialVersionUID = 3991075740762990986L;
  private CommunicatorDTO clientCommunicatorData;

  /**
   * Instantiates a new reconnect request dataManagement.
   */
  public ReconnectRequestDTO() {
    this(null);
  }

  /**
   * Instantiates a new reconnect request dataManagement.
   *
   * @param clientCommunicatorData the client dataManagement
   */
  @JsonCreator
  public ReconnectRequestDTO(
      @JsonProperty("clientCommunicatorData") final CommunicatorDTO clientCommunicatorData) {
    this.clientCommunicatorData = clientCommunicatorData;
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
    if (!(otherObject instanceof ReconnectRequestDTO that)) {
      return false;
    }
    return Objects.equals(this.clientCommunicatorData, that.getClientData());
  }

  public CommunicatorDTO getClientData() {
    return this.clientCommunicatorData;
  }

  public void setClientData(CommunicatorDTO clientCommunicatorData) {
    this.clientCommunicatorData = clientCommunicatorData;
  }

  @Override
  public String toString() {
    var clientCommunicatorDataString = (this.clientCommunicatorData != null)
        ? this.clientCommunicatorData.toString()
        : "null";
    return "\"reconnectRequestDTO\": { \"clientCommunicatorData\": " + clientCommunicatorDataString
        + "}";
  }
}
