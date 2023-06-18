package de.vsy.shared_transmission.packet.content.status;

import de.vsy.shared_transmission.packet.content.ContentEnum;

public enum StatusContent implements ContentEnum {
  ContactStatusChangeDTO, ClientStatusChangeDTO, MessengerSetupDTO, MessengerTearDownDTO
}
