package de.vsy.chat.shared_transmission.packet;

import java.io.Serial;

public
class HashCalculationException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 2365674585070784727L;

    public
    HashCalculationException (final String errorMessage) {
        super(errorMessage);
    }

    public
    HashCalculationException (final Throwable baseException) {
        super(baseException);
    }

    public
    HashCalculationException (final String errorMessage,
                              final Throwable baseException) {
        super(errorMessage, baseException);
    }
}
