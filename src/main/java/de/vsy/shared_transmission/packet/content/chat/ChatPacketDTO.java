/*
 *
 */
package de.vsy.shared_transmission.packet.content.chat;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id.NAME;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import de.vsy.shared_transmission.packet.content.PacketContent;
import de.vsy.shared_transmission.packet.content.relation.EligibleContactEntity;
import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

/**
 * The Class ChatPacketData.
 *
 * @param <T>
 */
@JsonTypeInfo(use = NAME, property = "type")
@JsonSubTypes({@Type(value = TextMessageDTO.class, name = "message")})
@JsonTypeName("chatPacketData")
public abstract class ChatPacketDTO<T extends Serializable> implements PacketContent {

  @Serial
  private static final long serialVersionUID = 282918274110719185L;

  private final EligibleContactEntity contactType;
  private final int recipientId;
  private final T message;
  private final boolean receptionState;
  private final int originatorId;

  /**
   * Instantiates a new chat PacketDataManagement.
   *
   * @param originatorId the originator id
   * @param recipientId  the recipient id
   * @param message      the message
   */
  @JsonCreator
  protected ChatPacketDTO(@JsonProperty("originatorId") final int originatorId,
      @JsonProperty("contactType") final EligibleContactEntity contactType,
      @JsonProperty("recipientId") final int recipientId, @JsonProperty("receptionState") final boolean receptionState,
      @JsonProperty("message") final T message) {
    this.originatorId = originatorId;
    this.contactType = contactType;
    this.recipientId = recipientId;
    this.receptionState = receptionState;
    this.message = message;
  }

  /**
   * Gets the originator id.
   *
   * @return the originator id
   */
  public int getOriginatorId() {
    return this.originatorId;
  }

  public EligibleContactEntity getContactType() {
    return this.contactType;
  }

  /**
   * Gets the recipient id.
   *
   * @return the recipient id
   */
  public int getRecipientId() {
    return this.recipientId;
  }

  /**
   * Gets the reception state
   *
   * @return the reception state
   */
  public boolean getReceptionState() {
    return this.receptionState;
  }

  @Override
  public int hashCode() {
    var hash = 53 * Objects.hashCode(this.message);
    hash = 53 * hash * Boolean.hashCode(this.receptionState);
    return 53 * hash + Integer.hashCode(this.originatorId);
  }

  @Override
  public boolean equals(Object otherObject) {
    if (this == otherObject) {
      return true;
    }

    if (!(otherObject instanceof ChatPacketDTO<?> that)) {
      return false;
    }
    return Objects.equals(this.message, that.getMessage());
  }

  @Override
  public String toString() {
    var messageString = (this.message != null) ? this.message : "null";
    return "\"chatPacketDTO\": { \"message\": \"" + messageString + "\", " + "\"originatorId\": "
        + this.originatorId + ", \"contactType\": " + this.contactType + ", \"recipientId\": "
        + this.recipientId + " }";
  }

  public T getMessage() {
    return this.message;
  }
}
