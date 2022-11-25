package de.vsy.shared_transmission.packet.content.authentication;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import de.vsy.shared_transmission.packet.content.PacketContent;
import java.io.Serial;

/**
 * The Class ReconnectResponseDTO.
 */
@JsonTypeName("reconnectResponse")
public class ReconnectResponseDTO implements PacketContent {

  @Serial
  private static final long serialVersionUID = 4375598873037626767L;
  private final boolean reconnectionState;

  @JsonCreator
  public ReconnectResponseDTO(@JsonProperty("reconnectionState") boolean reconnectionState) {
    this.reconnectionState = reconnectionState;
  }

  @Override
  public int hashCode() {
    return 53 * Boolean.hashCode(this.reconnectionState);
  }

  @Override
  public boolean equals(Object otherObject) {
    if (this == otherObject) {
      return true;
    }
    if (!(otherObject instanceof ReconnectResponseDTO that)) {
      return false;
    }
    return this.reconnectionState == that.getReconnectionState();
  }

  public boolean getReconnectionState() {
    return this.reconnectionState;
  }

  @Override
  public String toString() {
    return "\"reconnectResponseDTO\": { \"reconnectionState\": " + this.reconnectionState + " }";
  }
}
