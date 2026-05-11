package com.greenbite.bff.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class UsuarioDTO {
    private String rut;
    private String nombre;
    private String apellido;
    private String email;
    private String password;
    private LocalDate fechaNacimiento;
    private String direccion;
    private String region;
    private String comuna;
}