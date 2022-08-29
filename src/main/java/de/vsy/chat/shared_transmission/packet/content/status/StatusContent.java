package de.vsy.chat.shared_transmission.packet.content.status;

import de.vsy.chat.shared_transmission.packet.content.ContentEnum;

public
enum StatusContent implements ContentEnum {
    ContactMessengerStatusDTO,
    ClientStatusChangeDTO,
    MessengerSetupDTO,
    MessengerTearDownDTO
}
