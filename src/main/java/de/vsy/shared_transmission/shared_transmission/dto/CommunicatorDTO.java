package de.vsy.shared_transmission.shared_transmission.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

/** The Interface CommunicatorDTO. */
@JsonTypeName("communicatorDTO")
public
class CommunicatorDTO implements Comparable<CommunicatorDTO>, Serializable {

    @Serial
    private static final long serialVersionUID = 3076630187455385026L;
    private final int communicatorId;
    private final String displayLabel;

    /**
     * Instantiates a new communication entity.
     *
     * @param communicatorId the comm id
     * @param displayLabel the display label
     */
    private
    CommunicatorDTO (final int communicatorId, final String displayLabel) {
        this.communicatorId = communicatorId;
        this.displayLabel = displayLabel;
    }

    /**
     * @param communicatorId the communicator id
     * @param displayLabel the display label
     *
     * @return the communicator data transfer object
     */
    @JsonCreator
    public static
    CommunicatorDTO valueOf (
            @JsonProperty("communicatorId") final int communicatorId,
            @JsonProperty("displayLabel") final String displayLabel) {
        if (displayLabel == null) {
            throw new NullPointerException("Kein Displaylabel angegeben.");
        }
        return new CommunicatorDTO(communicatorId, displayLabel);
    }

    @Override
    public
    int compareTo (final CommunicatorDTO otherEntity) {
        return this.displayLabel.compareTo(otherEntity.getDisplayLabel());
    }

    /**
     * Gets the entity label.
     *
     * @return the entity label
     */
    public
    String getDisplayLabel () {
        return this.displayLabel;
    }

    @Override
    public
    int hashCode () {
        return 53 * Integer.hashCode(this.communicatorId) +
               Objects.hashCode(this.displayLabel);
    }

    @Override
    public
    boolean equals (Object otherObject) {
        if (this == otherObject) {
            return true;
        }

        if (!(otherObject instanceof CommunicatorDTO that)) {
            return false;
        }
        return this.communicatorId == that.getCommunicatorId() &&
               Objects.equals(this.displayLabel, that.getDisplayLabel());
    }

    /**
     * Gets the entity id.
     *
     * @return the entity id
     */
    public
    int getCommunicatorId () {
        return this.communicatorId;
    }

    @Override
    public
    String toString () {
        return "\"communicatorDTO\": { " + "\"communicatorId\": " +
               this.communicatorId + ", \"communicatorLabel\": " +
               this.displayLabel + " }";
    }
}
