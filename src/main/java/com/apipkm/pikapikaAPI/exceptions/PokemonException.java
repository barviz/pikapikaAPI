package com.apipkm.pikapikaAPI.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PokemonException extends RuntimeException{
    private HttpStatus status;
    public PokemonException(HttpStatus status, String message){
        super(message);
        this.status = status;
    }

}
