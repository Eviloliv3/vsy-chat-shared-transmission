package de.vsy.shared_transmission.packet.content.notification;

import com.fasterxml.jackson.annotation.JsonProperty;
import de.vsy.shared_transmission.packet.content.PacketContent;
import de.vsy.shared_transmission.packet.content.Translatable;
import java.io.Serial;
import java.util.Objects;

public class SimpleInformationDTO implements Translatable, PacketContent {

  @Serial
  private static final long serialVersionUID = -2309802679312846310L;
  private final String informationString;

  public SimpleInformationDTO(@JsonProperty("informationString") final String info) {
    this.informationString = info;
  }

  public String getInformationString() {
    return this.informationString;
  }

  @Override
  public String toString() {
    var messageString = (this.informationString != null) ? this.informationString : "null";
    return "\"simpleInformationDTO\": { \"informationString\": " + messageString + " }";
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }

    if (!(other instanceof final SimpleInformationDTO otherInformation)) {
      return false;
    }
    return this.informationString.equals(otherInformation.getInformationString());
  }

  @Override
  public int hashCode() {
    return 89 * Objects.hashCode(this.informationString);
  }
}
