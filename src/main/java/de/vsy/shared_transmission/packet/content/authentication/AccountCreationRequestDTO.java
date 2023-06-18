package de.vsy.shared_transmission.packet.content.authentication;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import de.vsy.shared_transmission.dto.authentication.AccountCreationDTO;
import de.vsy.shared_transmission.packet.content.PacketContent;
import java.io.Serial;
import java.util.Objects;

/**
 * The Class AccountCreationRequestDTO.
 */
@JsonTypeName("newAccountRequest")
public class AccountCreationRequestDTO implements PacketContent {

  @Serial
  private static final long serialVersionUID = -9178720704765426650L;
  private AccountCreationDTO accountCreationData;

  /**
   * Instantiates a new new account request dataManagement.
   */
  public AccountCreationRequestDTO() {
    this(null);
  }

  @JsonCreator
  public AccountCreationRequestDTO(
      @JsonProperty("accountCreationData") AccountCreationDTO accountCreationData) {
    this.accountCreationData = accountCreationData;
  }

  @Override
  public int hashCode() {
    return 53 * Objects.hashCode(this.accountCreationData);
  }

  @Override
  public boolean equals(Object otherObject) {
    if (this == otherObject) {
      return true;
    }
    if (!(otherObject instanceof AccountCreationRequestDTO that)) {
      return false;
    }
    return Objects.equals(this.accountCreationData, that.getAccountCreationData());
  }

  public AccountCreationDTO getAccountCreationData() {
    return this.accountCreationData;
  }

  public void setAccountCreationData(AccountCreationDTO accountCreationData) {
    this.accountCreationData = accountCreationData;
  }

  @Override
  public String toString() {
    var accCreationString =
        (this.accountCreationData != null) ? this.accountCreationData.toString() : "null";

    return "\"accountCreationDTO\": { \"accountCreationData\": " + accCreationString + "}";
  }
}
