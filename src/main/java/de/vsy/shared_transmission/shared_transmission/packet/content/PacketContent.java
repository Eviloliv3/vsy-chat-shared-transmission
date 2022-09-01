package de.vsy.shared_transmission.shared_transmission.packet.content;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import de.vsy.shared_transmission.shared_transmission.packet.property.PacketPropertiesImpl;

import java.io.Serializable;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS,
              property = "@class")
public
interface PacketContent extends Serializable {

    /*
     *  Die nachfolgenden Standardmethoden müssen implementiert werden, damit
     *  Pakete sinnvoll in Collections organisiert und notfalls geloggt werden
     *  können.
     */
    @Override
    int hashCode ();

    @Override
    boolean equals (Object otherObject);

    @Override
    String toString ();
}
