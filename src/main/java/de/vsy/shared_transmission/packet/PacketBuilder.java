package de.vsy.shared_transmission.packet;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import de.vsy.shared_transmission.packet.content.PacketContent;
import de.vsy.shared_transmission.packet.property.PacketProperties;

@JsonPOJOBuilder
public class PacketBuilder {

    private PacketProperties properties;
    private PacketContent content;
    private String requestPacketHash;

    public Packet build() {
        Packet completePacket = new PacketImpl(this.properties, this.content, this.requestPacketHash);
        completePacket.calculatePacketHash();
        return completePacket;
    }

    public PacketBuilder withProperties(PacketProperties properties) {
        this.properties = properties;
        return this;
    }

    public PacketBuilder withContent(PacketContent content) {
        this.content = content;
        return this;
    }

    public PacketBuilder withRequestPacket(final Packet requestPacket) {
        this.requestPacketHash = requestPacket.getPacketHash();
        return this;
    }

    public PacketBuilder withRequestPacket(final String requestHash) {
        this.requestPacketHash = requestHash;
        return this;
    }
}
