package de.vsy.shared_transmission.packet.content.authentication;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import de.vsy.shared_transmission.packet.content.PacketContent;
import java.io.Serial;

@JsonTypeName("accountDeletionRequestDTO")
public class AccountDeletionRequestDTO implements PacketContent {

  @Serial
  private static final long serialVersionUID = 8006534314246383738L;

  @JsonCreator
  public AccountDeletionRequestDTO() {
    super();
  }

  @Override
  public String toString() {
    return "accountDeletionRequest: { }";
  }

  @Override
  public boolean equals(Object other) {
    return this == other;
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }

}
