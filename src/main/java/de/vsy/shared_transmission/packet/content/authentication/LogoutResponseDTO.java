/*
 *
 */
package de.vsy.shared_transmission.packet.content.authentication;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import de.vsy.shared_transmission.packet.content.PacketContent;
import java.io.Serial;

/**
 * The Class LogoutResponseDTO.
 */
@JsonTypeName("logoutResponse")
public class LogoutResponseDTO implements PacketContent {

  @Serial
  private static final long serialVersionUID = 2496548900174153502L;
  private boolean logoutState;

  @JsonCreator
  public LogoutResponseDTO(@JsonProperty("primaryData") final boolean logoutState) {
    this.logoutState = logoutState;
  }

  @Override
  public int hashCode() {
    return 53 * Boolean.hashCode(this.logoutState);
  }

  @Override
  public boolean equals(Object otherObject) {
    if (this == otherObject) {
      return true;
    }
    if (!(otherObject instanceof LogoutResponseDTO that)) {
      return false;
    }
    return this.logoutState == that.getLogoutState();
  }

  public boolean getLogoutState() {
    return this.logoutState;
  }

  public void setLogoutState(boolean logoutState) {
    this.logoutState = logoutState;
  }

  @Override
  public String toString() {
    return "\"LogoutResponseDTO\": { \"logoutState\": " + this.logoutState + "}";
  }
}
