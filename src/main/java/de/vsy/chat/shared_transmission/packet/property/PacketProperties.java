package de.vsy.chat.shared_transmission.packet.property;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import de.vsy.chat.shared_transmission.packet.property.communicator.CommunicationEndpoint;
import de.vsy.chat.shared_transmission.packet.property.packet_identifier.ContentIdentifier;

import java.io.Serializable;

/**
 * Wird als Header des Paketes verwendet. Es sind mindestens der Sender, der
 * Empfänger, der Erstellungszeitpunkt und Informationen zum Paketinhalt anzugeben.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
              property = "type")
public
interface PacketProperties extends Serializable {

    /**
     * Gibt ein representatives Objekt für den Sender aus.
     *
     * @return das Senderobjekt (CommunicationEndpoint)
     */
    CommunicationEndpoint getSenderEntity ();

    /**
     * Gibt ein representatives Objekt für den Empfänger aus.
     *
     * @return das Empfängerobjekt (CommunicationEndpoint)
     */
    CommunicationEndpoint getRecipientEntity ();

    /**
     * Gibt ein, den Paketinhalt, spezifizierendes Objekt aus.
     *
     * @return der Inhaltsidentifizierer (ContentIdentifier)
     */
    ContentIdentifier getContentIdentifier ();

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
