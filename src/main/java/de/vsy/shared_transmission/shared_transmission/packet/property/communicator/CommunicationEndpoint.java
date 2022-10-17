/*
 *
 */
package de.vsy.shared_transmission.shared_transmission.packet.property.communicator;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serial;
import java.io.Serializable;

/**
 * The Class CommunicationEndpoint.
 */
public class CommunicationEndpoint implements Serializable {

  /* The Constant serialVersionUID. */
  @Serial
  private static final long serialVersionUID = 1982632971666990887L;
  private final int entityId;
  private final EligibleCommunicationEntity entityLabel;

  /**
   * Instantiates a new direction entity.
   *
   * @param entityId    the entity id
   * @param entityLabel the entity label
   */
  private CommunicationEndpoint(final int entityId, final EligibleCommunicationEntity entityLabel) {
    this.entityId = entityId;
    this.entityLabel = entityLabel;
  }

  @JsonCreator
  public static CommunicationEndpoint valueOf(@JsonProperty("entityId") final int entityId,
      @JsonProperty("entity") final EligibleCommunicationEntity entityLabel) {
    if (entityLabel == null) {
      throw new IllegalArgumentException("Keine gültige Empfängerentität angegeben.");
    }
    return new CommunicationEndpoint(entityId, entityLabel);
  }

  /**
   * Gets the client entity.
   *
   * @param clientId the client id
   * @return the client entity
   */
  public static CommunicationEndpoint getClientEntity(final int clientId) {
    return new CommunicationEndpoint(clientId, EligibleCommunicationEntity.CLIENT);
  }

  /**
   * Gets the server entity.
   *
   * @param serverId the server id
   * @return the server entity
   */
  public static CommunicationEndpoint getServerEntity(final int serverId) {
    return new CommunicationEndpoint(serverId, EligibleCommunicationEntity.SERVER);
  }

  /**
   * Gets the entity id.
   *
   * @return the entity id
   */
  public int getEntityId() {
    return this.entityId;
  }

  /**
   * Gets the entity.
   *
   * @return the entity
   */
  public EligibleCommunicationEntity getEntity() {
    return this.entityLabel;
  }

  @Override
  public String toString() {
    return "\"entityId\": " + this.entityId + ", \"entityLabel\": " + this.entityLabel;
  }
}
