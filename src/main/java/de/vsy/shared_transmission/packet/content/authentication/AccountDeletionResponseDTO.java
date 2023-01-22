package de.vsy.shared_transmission.packet.content.authentication;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import de.vsy.shared_transmission.packet.content.PacketContent;
import java.io.Serial;
import java.util.Objects;

@JsonTypeName("accountDeletionResponseDTO")
public class AccountDeletionResponseDTO implements PacketContent {

  @Serial
  private static final long serialVersionUID = 8006534314246373728L;
  private final boolean accountDeleted;

  @JsonCreator
  public AccountDeletionResponseDTO(@JsonProperty("accountDeleted") final boolean accountDeleted) {
    this.accountDeleted = accountDeleted;
  }

  public boolean getAccountDeleted() {
    return this.accountDeleted;
  }

  @Override
  public String toString() {
    return "accountDeletionResponse: { accountDeleted: " + accountDeleted + " }";
  }

  @Override
  public int hashCode() {
    return 93 * Objects.hashCode(accountDeleted);
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }

    if (!(other instanceof final AccountDeletionResponseDTO that)) {
      return false;
    }
    return this.accountDeleted == that.getAccountDeleted();
  }
}
