package de.vsy.shared_transmission.packet.content.notification;

import static java.util.Objects.hash;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import de.vsy.shared_transmission.packet.Packet;
import de.vsy.shared_transmission.packet.content.PacketContent;
import de.vsy.shared_transmission.packet.content.Translatable;
import java.io.Serial;
import java.util.Objects;

/**
 * The Class ErrorData.
 */
@JsonTypeName("errorData")
public class ErrorDTO extends SimpleInformationDTO {

  @Serial
  private static final long serialVersionUID = -2309802640212846310L;
  private final Packet originPacket;

  /**
   * Instantiates a new notification dataManagement.
   *
   * @param errorMessage  the notification message
   * @param causingPacket the causing packet
   */
  @JsonCreator
  public ErrorDTO(@JsonProperty("errorMessage") final String errorMessage,
      @JsonProperty("originPacket") final Packet causingPacket) {
    super(errorMessage);
    this.originPacket = causingPacket;
  }

  @Override
  public int hashCode() {
    var hash = super.hashCode();
    return 53 * hash * hash(this.originPacket);
  }

  @Override
  public boolean equals(Object otherObject) {
    if (this == otherObject) {
      return true;
    }
    if (!(otherObject instanceof ErrorDTO that)) {
      return false;
    }
    return super.equals(otherObject) && Objects.equals(this.originPacket, that.getOriginPacket());
  }

  /**
   * Returns the origin.
   *
   * @return the origin
   */
  public Packet getOriginPacket() {
    return this.originPacket;
  }

  @Override
  public String toString() {
    var originPacketString = (this.originPacket != null) ? this.originPacket.toString() : "null";

    return "\"errorDTO\": { " + super.toString() + ", \"originPacket" + "\": "
        + originPacketString + " }";
  }
}
