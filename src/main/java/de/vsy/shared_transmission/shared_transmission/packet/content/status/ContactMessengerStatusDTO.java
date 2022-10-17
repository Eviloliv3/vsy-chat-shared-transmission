/*
 *
 */
package de.vsy.shared_transmission.shared_transmission.packet.content.status;

import static java.util.List.copyOf;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import de.vsy.shared_transmission.shared_transmission.dto.CommunicatorDTO;
import de.vsy.shared_transmission.shared_transmission.packet.content.PacketContent;
import de.vsy.shared_transmission.shared_transmission.packet.content.chat.TextMessageDTO;
import de.vsy.shared_transmission.shared_transmission.packet.content.relation.EligibleContactEntity;
import java.io.Serial;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * The Class ContactOnlineStatusData.
 */
@JsonTypeName("contactMessengerStatusDTO")
public class ContactMessengerStatusDTO implements PacketContent {

  @Serial
  private static final long serialVersionUID = 2848603712317947975L;
  private final ClientService serviceType;
  private final EligibleContactEntity contactType;
  private final boolean onlineStatus;
  private final CommunicatorDTO contactData;
  private final List<TextMessageDTO> messageHistory;

  /**
   * Instantiates a new messenger status change dataManagement.
   *
   * @param contactType    the contact type
   * @param onlineStatus   the online status
   * @param contactData    the contact data
   * @param messageHistory the message history
   */
  @JsonCreator
  public ContactMessengerStatusDTO(@JsonProperty("contactType") EligibleContactEntity contactType,
      @JsonProperty("onlineStatus") final boolean onlineStatus,
      @JsonProperty("contactData") final CommunicatorDTO contactData,
      @JsonProperty("messages") final List<TextMessageDTO> messageHistory) {
    this.serviceType = ClientService.MESSENGER;
    this.onlineStatus = onlineStatus;
    this.contactType = contactType;
    this.contactData = contactData;

    if (messageHistory == null) {
      this.messageHistory = Collections.emptyList();
    } else {
      this.messageHistory = new ArrayList<>(messageHistory);
    }
  }

  public static ContactMessengerStatusDTO createFromClientStatusDTO(
      ClientStatusChangeDTO clientStatusData) {
    return new ContactMessengerStatusDTO(EligibleContactEntity.CLIENT,
        clientStatusData.getOnlineStatus(),
        clientStatusData.getContactData(), null);
  }

  public static ContactMessengerStatusDTO addMessageHistory(
      ContactMessengerStatusDTO dataToComplete,
      List<TextMessageDTO> messageHistory) {
    return new ContactMessengerStatusDTO(EligibleContactEntity.CLIENT,
        dataToComplete.getOnlineStatus(),
        dataToComplete.getContactData(), messageHistory);
  }

  public boolean getOnlineStatus() {
    return this.onlineStatus;
  }

  public CommunicatorDTO getContactData() {
    return this.contactData;
  }

  @Override
  public int hashCode() {
    var hash = 53 * Objects.hashCode(this.messageHistory);
    return 53 * hash + super.hashCode();
  }

  @Override
  public boolean equals(Object otherObject) {

    if (this == otherObject) {
      return true;
    }

    if (!(otherObject instanceof ContactMessengerStatusDTO that) || !super.equals(otherObject)) {
      return false;
    }
    return Objects.equals(this.messageHistory, that.getMessages());
  }

  /**
   * Gets the message history.
   *
   * @return the message history
   */
  public List<TextMessageDTO> getMessages() {
    return copyOf(this.messageHistory);
  }

  @Override
  public String toString() {
    final var sb = new StringBuilder();
    sb.append("\"contactMessengerStatusDTO\": { ").append("\"serviceType\": ")
        .append(this.serviceType)
        .append("\"contactType\": ").append(this.contactType).append("\"onlineStatus\": ")
        .append(this.onlineStatus).append("\"contactData\": ").append(this.contactData)
        .append(", \"messageHistory\": [");

    if (this.messageHistory != null && !this.messageHistory.isEmpty()) {
      final var tTextMessageSetString = new StringBuilder();

      this.messageHistory.forEach(
          tTextMessage -> tTextMessageSetString.append(tTextMessage).append(", "));

      if (tTextMessageSetString.length() >= 3) {
        tTextMessageSetString.delete(tTextMessageSetString.length() - 2,
            tTextMessageSetString.length() - 1);
      }

      sb.append(tTextMessageSetString);
    } else {
      sb.append("none");
    }
    sb.append("]").append(" }");

    return sb.toString();
  }

  public ClientService getServiceType() {
    return this.serviceType;
  }

  /**
   * Gets the contact type
   *
   * @return the contact type
   */
  public EligibleContactEntity getContactType() {
    return this.contactType;
  }
}
