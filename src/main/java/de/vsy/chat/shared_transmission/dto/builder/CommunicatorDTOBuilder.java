package de.vsy.chat.shared_transmission.dto.builder;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import de.vsy.chat.shared_transmission.dto.CommunicatorDTO;

@JsonPOJOBuilder
public
class CommunicatorDTOBuilder {

    private int communicatorId;
    private String displayLabel;

    public
    CommunicatorDTO build () {
        return CommunicatorDTO.valueOf(this.communicatorId, this.displayLabel);
    }

    public
    CommunicatorDTOBuilder withCommunicatorId (int communicatorId) {
        this.communicatorId = communicatorId;
        return this;
    }

    public
    CommunicatorDTOBuilder withDisplayLabel (String displayLabel) {
        if (displayLabel == null) {
            throw new NullPointerException("Kein Displaylabel angegeben.");
        }
        this.displayLabel = displayLabel;
        return this;
    }
}
