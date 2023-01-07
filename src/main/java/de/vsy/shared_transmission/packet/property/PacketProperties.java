package de.vsy.shared_transmission.packet.property;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import de.vsy.shared_transmission.packet.property.communicator.CommunicationEndpoint;
import de.vsy.shared_transmission.packet.property.packet_identifier.ContentIdentifier;

import java.io.Serializable;

/**
 * Will be used as header of a Packet. Contains a sender entity, a recipient entity, the creation
 * timestamp and packet content classification.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "@class")
public interface PacketProperties extends Serializable {

    /**
     * Returns the sender entity.
     *
     * @return CommunicationEndpoint
     */
    CommunicationEndpoint getSender();

    /**
     * Returns the recipient entity.
     *
     * @return CommunicationEndpoint
     */
    CommunicationEndpoint getRecipient();

    /**
     * Returns the Packet's content classification.
     *
     * @return ContentIdentifier
     */
    ContentIdentifier getPacketIdentificationProvider();

    /*
     * The following methods have to be implemented, to be able to organize Packets in Collections.
     */
    @Override
    int hashCode();

    @Override
    boolean equals(Object otherObject);

    @Override
    String toString();
}
