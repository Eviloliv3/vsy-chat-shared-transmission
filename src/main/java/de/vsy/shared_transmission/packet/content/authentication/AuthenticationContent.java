package de.vsy.shared_transmission.packet.content.authentication;

import de.vsy.shared_transmission.packet.content.ContentEnum;

public enum AuthenticationContent implements ContentEnum {
    LoginRequestDTO, LoginResponseDTO, LogoutRequestDTO, LogoutResponseDTO, AccountCreationRequestDTO, ReconnectRequestDTO,
    ReconnectResponseDTO, AccountDeletionRequestDTO, AccountDeletionResponseDTO
}
