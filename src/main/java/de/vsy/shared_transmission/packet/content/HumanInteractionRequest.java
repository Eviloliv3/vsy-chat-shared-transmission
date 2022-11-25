package de.vsy.shared_transmission.packet.content;

import de.vsy.shared_transmission.dto.CommunicatorDTO;

public interface HumanInteractionRequest extends Translatable {

  boolean getDesiredState();

  int getOriginatorId();

  int getRecipientId();

  PacketContent setDecision(CommunicatorDTO respondingClient, boolean decision);
}
