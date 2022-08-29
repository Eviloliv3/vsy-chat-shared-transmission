package de.vsy.chat.shared_transmission.packet.content.authentication;

import de.vsy.chat.shared_transmission.packet.content.ContentEnum;

public
enum AuthenticationContent implements ContentEnum {
    LoginRequestDTO,
    LoginResponseDTO,
    LogoutRequestDTO,
    LogoutResponseDTO,
    NewAccountRequestDTO,
    ReconnectRequestDTO,
    ReconnectResponseDTO
}
