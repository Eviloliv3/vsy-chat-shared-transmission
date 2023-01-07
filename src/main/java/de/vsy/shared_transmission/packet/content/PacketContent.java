package de.vsy.shared_transmission.packet.content;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.io.Serializable;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "@class")
public interface PacketContent extends Serializable {

    /*
     * The following methods have to be implemented, to be able to use PacketContent with Collections.
     */
    @Override
    int hashCode();

    @Override
    boolean equals(Object otherObject);

    @Override
    String toString();
}
