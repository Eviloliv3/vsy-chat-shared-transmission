/*
 *
 */
package de.vsy.chat.shared_transmission.packet.content.status;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import de.vsy.chat.shared_transmission.dto.CommunicatorDTO;
import de.vsy.chat.shared_transmission.packet.content.relation.EligibleContactEntity;
import de.vsy.chat.shared_transmission.packet.content.PacketContent;
import de.vsy.chat.shared_transmission.packet.content.chat.TextMessageDTO;
import de.vsy.chat.shared_utility.string_manipulation.StringShortener;

import java.io.Serial;
import java.util.*;

import static java.util.Map.copyOf;

/** The Class MessengerSetupResponseDTO. */
@JsonTypeName("messengerSetup")
public
class MessengerSetupDTO implements PacketContent {

    @Serial
    private static final long serialVersionUID = 5336801305649826683L;
    private final Map<EligibleContactEntity, Set<CommunicatorDTO>> activeContacts;
    private final Map<Integer, List<TextMessageDTO>> oldMessage;

    /**
     * Instantiates a new messenger setup response dataManagement.
     *
     * @param oldMessage the old messages
     * @param activeContacts the active clients
     */
    @JsonCreator
    public
    MessengerSetupDTO (@JsonProperty("oldMessage")
                       final Map<Integer, List<TextMessageDTO>> oldMessage,
                       @JsonProperty("activeContacts")
                       final Map<EligibleContactEntity, Set<CommunicatorDTO>> activeContacts) {
        this.oldMessage = copyOf(oldMessage);
        this.activeContacts = copyOf(activeContacts);
    }

    /**
     * Gets the active contacts.
     *
     * @return the active contacts
     */
    public
    Map<EligibleContactEntity, Set<CommunicatorDTO>> getActiveContacts () {
        return copyOf(this.activeContacts);
    }

    /**
     * Gets the old messages.
     *
     * @return the old messages
     */
    public
    Map<Integer, List<TextMessageDTO>> getOldMessages () {
        return copyOf(this.oldMessage);
    }

    @Override
    public
    int hashCode () {
        var hash = 53 * Objects.hashCode(this.activeContacts);
        return 53 * hash + Objects.hashCode(this.oldMessage);
    }

    @Override
    public
    boolean equals (Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (!(otherObject instanceof MessengerSetupDTO that)) {
            return false;
        }
        return Objects.equals(this.activeContacts, that.activeContacts) &&
               Objects.equals(this.oldMessage, that.oldMessage);
    }

    @Override
    public
    String toString () {
        final var sb = new StringBuilder();
        sb.append("\"messengerSetupDTO\": {").append("\"activeContactMap\": {");

        if (this.activeContacts == null || this.activeContacts.isEmpty()) {
            sb.append("none");
        } else {
            sb.append(this.stringifyMap(this.activeContacts));
        }
        sb.append("}, \"messageMap\": {");
        if (this.oldMessage == null || this.oldMessage.isEmpty()) {
            sb.append("none");
        } else {
            sb.append(this.stringifyMap(this.oldMessage));
        }
        sb.append("}}");
        return sb.toString();
    }

    private
    String stringifyMap (Map<?, ? extends Collection<?>> toStringify) {
        StringBuilder string = new StringBuilder();

        for (var stringifySet : toStringify.entrySet()) {
            string.append(stringifySet.getKey()).append(": [");

            for (var activeContactId : stringifySet.getValue()) {
                string.append(activeContactId.toString()).append(", ");
            }
            StringShortener.cutTrailingChars(string, 2);

            string.append("], ");
        }
        StringShortener.cutTrailingChars(string, 2);
        return string.toString();
    }
}
