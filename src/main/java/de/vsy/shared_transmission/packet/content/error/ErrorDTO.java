/*
 *
 */
package de.vsy.shared_transmission.packet.content.error;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import de.vsy.shared_transmission.packet.Packet;
import de.vsy.shared_transmission.packet.content.PacketContent;
import de.vsy.shared_transmission.packet.content.Translatable;

import java.io.Serial;
import java.util.Objects;

import static java.util.Objects.hash;

/**
 * The Class ErrorData.
 */
@JsonTypeName("errorData")
public class ErrorDTO implements PacketContent, Translatable {

    @Serial
    private static final long serialVersionUID = -2309802640212846310L;
    private final String errorMessage;
    private final Packet originPacket;

    /**
     * Instantiates a new error dataManagement.
     *
     * @param errorMessage  the error message
     * @param causingPacket the causing packet
     */
    @JsonCreator
    public ErrorDTO(@JsonProperty("errorMessage") final String errorMessage,
                    @JsonProperty("originPacket") final Packet causingPacket) {
        this.errorMessage = errorMessage;
        this.originPacket = causingPacket;
    }

    @Override
    public int hashCode() {
        var hash = 53 * Objects.hashCode(this.errorMessage);
        return 53 * hash * hash(this.originPacket);
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (!(otherObject instanceof ErrorDTO that)) {
            return false;
        }
        return Objects.equals(this.errorMessage, that.getErrorMessage())
                && Objects.equals(this.originPacket, that.getOriginPacket());
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    /**
     * Returns the origin.
     *
     * @return the origin
     */
    public Packet getOriginPacket() {
        return this.originPacket;
    }

    @Override
    public String toString() {
        var messageString = (this.errorMessage != null) ? this.errorMessage : "null";
        var originPacketString = (this.originPacket != null) ? this.originPacket.toString() : "null";

        return "\"errorDTO\": { \"message\": " + messageString + "\"originPacket" + "\": "
                + originPacketString + " }";
    }
}
