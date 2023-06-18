package de.vsy.shared_transmission.packet.content;

import de.vsy.shared_transmission.dto.CommunicatorDTO;

/**
 * Provides basic information needed for a request and translation of requests to notifications.
 */
public interface HumanInteractionRequest extends Translatable {

  /**
   * Returns the requesters desired state.
   *
   * @return boolean
   */
  boolean getDesiredState();

  /**
   * Returns the request's originator's id.
   *
   * @return id as int
   */
  int getOriginatorId();

  /**
   * Returns the request's recipient's id.
   *
   * @return id as int
   */
  int getRecipientId();

  /**
   * Creates a response for the current request. Setting the recipient's decision and
   * CommunicatorDTO.
   *
   * @param respondingClient the recipient's CommunicatorDTO
   * @param decision         the recipient's decision
   * @return the recipient's response
   */
  PacketContent setDecision(CommunicatorDTO respondingClient, boolean decision);
}
