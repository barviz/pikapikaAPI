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
public class RoleException extends RuntimeException{
    private HttpStatus status;
    public RoleException(HttpStatus status, String message){
        super(message);
        this.status = status;
    }

}
