package co.com.gcode.jwt.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;



/**
 * Modelo para crear una respuesta que contiene el token JWT
 */
@Data
@AllArgsConstructor
public class JwtResponse implements Serializable {
    private final String jwttoken;

}
