/*
 *
 */
package de.vsy.shared_transmission.packet.content.chat;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import de.vsy.shared_transmission.packet.content.relation.EligibleContactEntity;
import java.io.Serial;

/**
 * The Class MessageData. 
 */
@JsonTypeName("textMessage")
public class TextMessageDTO extends ChatPacketDTO<String> {

  @Serial
  private static final long serialVersionUID = -9063292172152458147L;

  /**
   * Instantiates a new message dataManagement.
   *
   * @param originatorId the originator id
   * @param recipientId  the recipient id
   * @param message      the message
   */
  public TextMessageDTO(final int originatorId, final EligibleContactEntity contactType,
      final int recipientId,
      final String message) {
    this(originatorId, contactType, recipientId, false, message);
  }

  /**
   * Instantiates a new message dataManagement.
   *
   * @param originatorId   the originator id
   * @param recipientId    the recipient id
   * @param message        the message
   * @param receptionState the this.receptionState
   */
  @JsonCreator
  public TextMessageDTO(@JsonProperty("originatorId") final int originatorId,
      @JsonProperty("contactType") final EligibleContactEntity contactType,
      @JsonProperty("recipientId") final int recipientId,
      @JsonProperty("receptionState") final boolean receptionState,
      @JsonProperty("messageContent") final String message) {
    super(originatorId, contactType, recipientId, receptionState, message);
  }

  @Override
  public TextMessageDTO setReceptionState() {
    return new TextMessageDTO(this.getOriginatorId(), this.getContactType(), this.getRecipientId(), true, this.getMessage());
  }

  @Override
  public String toString() {
    return "\"textMessageData\": { " + super.toString() + " }";
  }
}
