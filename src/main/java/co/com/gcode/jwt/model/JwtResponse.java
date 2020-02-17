package co.com.gcode.jwt.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor

/**
 * Modelo para crear una respuesta que contiene el token JWT
 */
public class JwtResponse implements Serializable {

   // private static final long serialVersionUID = -8091879091924046844L;

    private final String jwttoken;

}
