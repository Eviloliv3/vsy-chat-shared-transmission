package de.vsy.shared_transmission.shared_transmission.packet;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import de.vsy.shared_transmission.shared_transmission.packet.content.PacketContent;
import de.vsy.shared_transmission.shared_transmission.packet.property.PacketProperties;

import java.io.Serializable;
import java.time.Instant;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS,
              property = "@class")
public
interface Packet extends Serializable {

    /**
     * Gibt Paketeigenschaften des Paketes aus.
     *
     * @return Paketeigenschaften (PacketProperties)
     */
    PacketProperties getPacketProperties ();

    /**
     * Gibt den Paketinhalt aus.
     *
     * @return Paketinhalt (PacketContent)
     */
    PacketContent getPacketContent ();

    /**
     * Gibt den Erstellungszeitpunkt des Pakets aus.
     *
     * @return der Erstellungszeitpunkt (int)
     */
    Instant getPacketCreationTimestamp ();

    /**
     * Gibt den MD5-Hashwert des aktuellen Pakets aus.
     *
     * @return der Hashwert (String)
     */
    String getPacketHash ();

    /**
     * Gibt den MD5-Hashwert des Anfragepakets aus.
     *
     * @return der Hashwert (String)
     */
    String getRequestPacketHash ();

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
