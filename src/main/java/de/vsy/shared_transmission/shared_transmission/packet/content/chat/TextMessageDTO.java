/*
 *
 */
package de.vsy.shared_transmission.shared_transmission.packet.content.chat;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import de.vsy.shared_transmission.shared_transmission.packet.content.relation.EligibleContactEntity;

import java.io.Serial;

/** The Class MessageData. Frederic Heath */
@JsonTypeName("textMessage")
public
class TextMessageDTO extends ChatPacketDTO<String> {

    @Serial
    private static final long serialVersionUID = -9063292172152458147L;
    private final boolean receptionState;

    /**
     * Instantiates a new message dataManagement.
     *
     * @param originatorId the originator id
     * @param recipientId the recipient id
     * @param message the message
     */
    public
    TextMessageDTO (final int originatorId, final EligibleContactEntity contactType,
                    final int recipientId, final String message) {
        this(originatorId, contactType, recipientId, message, false);
    }

    /**
     * Instantiates a new message dataManagement.
     *
     * @param originatorId the originator id
     * @param recipientId the recipient id
     * @param message the message
     * @param receptionState the this.receptionState
     */
    @JsonCreator
    public
    TextMessageDTO (@JsonProperty("originatorId") final int originatorId,
                    @JsonProperty("contactType") final EligibleContactEntity contactType,
                    @JsonProperty("recipientId") final int recipientId,
                    @JsonProperty("messageContent") final String message,
                    @JsonProperty("receptionState") final boolean receptionState) {
        super(originatorId, contactType, recipientId, message);
        this.receptionState = receptionState;
    }

    /**
     * Gets the reception state
     *
     * @return the reception state
     */
    public
    boolean getReceptionState () {
        return this.receptionState;
    }

    public
    TextMessageDTO setReceptionState () {
        return new TextMessageDTO(super.getOriginatorId(),
                                  super.getContactType(),
                                  super.getRecipientId(),
                                  super.getMessage(), true);
    }

    @Override
    public
    int hashCode () {
        return 53 * super.hashCode() * Boolean.hashCode(this.receptionState);
    }

    @Override
    public
    boolean equals (Object otherObject) {
        return super.equals(otherObject);
    }

    @Override
    public
    String toString () {
        return "\"textMessageData\": { " + super.toString() +
               ", \"receptionState\": \"" + this.receptionState + "\" }";
    }
}
