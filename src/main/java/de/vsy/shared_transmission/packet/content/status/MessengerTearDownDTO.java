/*
 *
 */
package de.vsy.shared_transmission.packet.content.status;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import de.vsy.shared_transmission.packet.content.PacketContent;

import java.io.Serial;

import static java.util.Objects.hash;

/**
 * The Class MessengerSetupRequestDTO.
 */
@JsonTypeName("messengerTearDown")
public class MessengerTearDownDTO implements PacketContent {

    @Serial
    private static final long serialVersionUID = -5003195486762559758L;
    private final boolean newMessengerState;

    /**
     * Instantiates a new messenger setup request dataManagement.
     *
     * @param messengerState the messenger state
     */
    @JsonCreator
    public MessengerTearDownDTO(@JsonProperty("newMessengerState") final boolean messengerState) {
        this.newMessengerState = messengerState;
    }

    @Override
    public int hashCode() {
        return hash(this.newMessengerState);
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (!(otherObject instanceof MessengerTearDownDTO that)) {
            return false;
        }
        return this.newMessengerState == that.getNewMessengerState();
    }

    /**
     * Returns the new messenger state.
     *
     * @return the new messenger state
     */
    public boolean getNewMessengerState() {
        return this.newMessengerState;
    }

    @Override
    public String toString() {
        return super.toString() + ", \"messengerTearDownDTO\": { " + "\"messengerState\": "
                + this.newMessengerState
                + " }";
    }
}
