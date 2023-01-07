/*
 *
 */
package de.vsy.shared_transmission.packet;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import de.vsy.shared_transmission.packet.content.PacketContent;
import de.vsy.shared_transmission.packet.property.PacketProperties;

import java.io.Serial;
import java.time.Instant;
import java.util.Objects;

public class PacketImpl implements Packet {

    /**
     * The Constant serialVersionUID.
     */
    @Serial
    private static final long serialVersionUID = 4663843739168496029L;
    private final Instant packetCreationTimestamp;
    private final PacketContent packetContent;
    private final PacketProperties packetProperties;
    private final String requestPacketHash;
    private String packetHash;

    public PacketImpl(final PacketProperties packetProperties, final PacketContent packetContent,
                      final String requestPacketHash) {
        this(Instant.now(), packetProperties, packetContent, null, requestPacketHash);
    }

    @JsonCreator
    public PacketImpl(@JsonProperty("creationTimestamp") final Instant packetCreationTimeStamp,
                      @JsonProperty("packetProperties") final PacketProperties packetProperties,
                      @JsonProperty("packetContent") final PacketContent packetContent,
                      @JsonProperty("packetHash") final String packetHash,
                      @JsonProperty("requestPacketHash") final String requestPacketHash) {
        this.packetCreationTimestamp = packetCreationTimeStamp;
        this.packetProperties = packetProperties;
        this.packetContent = packetContent;
        this.requestPacketHash = requestPacketHash;
        this.packetHash = packetHash;
    }

    /**
     * Returns the PacketProperties.
     *
     * @return the PacketProperties
     */
    @Override
    public PacketProperties getPacketProperties() {
        return this.packetProperties;
    }

    /**
     * Returns the PacketDataManagement.
     *
     * @return the PacketDataManagement
     */
    @Override
    public PacketContent getPacketContent() {
        return this.packetContent;
    }

    @Override
    public final Instant getPacketCreationTimestamp() {
        return this.packetCreationTimestamp;
    }

    @Override
    public final String getPacketHash() {
        return this.packetHash;
    }

    @Override
    public final void calculatePacketHash() {
        if (this.packetHash == null) {
            this.packetHash = PacketHashCalculator.hash(this);
        }
    }

    @Override
    public final String getRequestPacketHash() {
        return this.requestPacketHash;
    }

    @Override
    public int hashCode() {
        var hash = 3;
        hash = 97 * hash + Objects.hashCode(this.packetContent);
        hash = 97 * hash + Objects.hashCode(this.packetProperties);
        return hash;
    }

    /**
     * Equals.
     *
     * @param otherPacket the other packet
     * @return true, if successful
     */
    @Override
    public boolean equals(final Object otherPacket) {
        if (this == otherPacket) {
            return true;
        }

        if (!(otherPacket instanceof Packet that)) {
            return false;
        }
        return Objects.equals(this.packetContent, that.getPacketContent())
                && Objects.equals(this.packetProperties, that.getPacketProperties());
    }

    @Override
    public String toString() {
        final var sb = new StringBuilder();
        final var properties =
                (this.packetProperties != null) ? this.packetProperties.toString() : null;
        final var content = (this.packetContent != null) ? this.packetContent.toString() : null;

        sb.append("{ \"packetProperties\": ").append(properties).append(", \"packetContent\": ")
                .append(content)
                .append(", \"hash\": ").append(this.packetHash).append(", \"requestHash\": ")
                .append(this.requestPacketHash).append(", \"creationStamp\": ")
                .append(this.packetCreationTimestamp)
                .append(" }");
        return sb.toString();
    }
}
