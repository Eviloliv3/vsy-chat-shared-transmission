package de.vsy.shared_transmission.packet;

import static java.nio.charset.StandardCharsets.UTF_8;
import static java.security.MessageDigest.getInstance;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/***/
public class PacketHashCalculator {

  private PacketHashCalculator() {
  }

  /**
   * @param packetToHash the packet to hash
   * @return unique hash for argument
   * @throws NullPointerException     if parameter is null
   * @throws HashCalculationException if field value cannot be accessed
   */
  public static String hash(final Packet packetToHash) throws HashCalculationException {
    byte[] hashBytes;
    final var packetHasher = createMessageDigester();
    final var packetHash = new StringBuilder();
    final var objectFields = packetToHash.getClass().getDeclaredFields();

    for (final var currentField : objectFields) {

      if (currentField.trySetAccessible()) {
        final Object currentFieldValue;
        try {
          currentFieldValue = currentField.get(packetToHash);
        } catch (IllegalArgumentException | IllegalAccessException e) {
          throw new HashCalculationException(e);
        }
        final var currentValueBytes = getByteValueOf(currentFieldValue);
        packetHasher.update(currentValueBytes);
      }
    }
    hashBytes = packetHasher.digest();

    for (var digestPart : hashBytes) {
      char[] hexDigits = new char[2];

      hexDigits[0] = Character.forDigit((digestPart >> 4) & 0xF, 16);
      hexDigits[1] = Character.forDigit((digestPart & 0xF), 16);
      packetHash.append(hexDigits);
    }
    return packetHash.toString();
  }

  /**
   * @return the new message digester
   * @throws IllegalStateException if no messageDigest could be created
   */
  private static MessageDigest createMessageDigester() {
    final MessageDigest packetHasher;
    try {
      packetHasher = getInstance("SHA-1");
    } catch (NoSuchAlgorithmException nae) {
      throw new IllegalStateException("SHA-1 MessageDigest could not be created.",
          nae);
    }
    return packetHasher;
  }

  private static byte[] getByteValueOf(Object value) {
    final var byteProvider = (value != null) ? value : "null";
    return byteProvider.toString().getBytes(UTF_8);
  }
}
