package com.agendapro.challenge.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import java.util.List;

public record UserRequest (
    @NotEmpty(message = "Nombre no puede ser vacío")
    String name,
    @NotEmpty(message = "El email no puede ser vacío")
    @Email(message = "Ingrese un email válido")
    String email,
    @NotEmpty(message = "La contraseña no puede ser vacía")
    String password,
    List<PhoneRequest> phones
) { }
