package de.vsy.chat.shared_transmission.packet.content;

import de.vsy.chat.shared_transmission.dto.CommunicatorDTO;

public
interface HumanInteractionRequest extends PacketContent, Translatable {

    boolean getDesiredState ();

    int getOriginatorId ();

    int getRecipientId ();

    PacketContent setDecision (CommunicatorDTO respondingClient, boolean decision);
}
