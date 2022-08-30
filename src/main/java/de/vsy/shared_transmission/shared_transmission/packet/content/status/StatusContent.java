package de.vsy.shared_transmission.shared_transmission.packet.content.status;

import de.vsy.shared_transmission.shared_transmission.packet.content.ContentEnum;

public
enum StatusContent implements ContentEnum {
    ContactMessengerStatusDTO,
    ClientStatusChangeDTO,
    MessengerSetupDTO,
    MessengerTearDownDTO
}
