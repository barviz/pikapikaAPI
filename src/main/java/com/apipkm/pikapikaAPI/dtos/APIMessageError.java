package com.apipkm.pikapikaAPI.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Component
public class APIMessageError {

    private HttpStatus httpStatus;
    private List<ValidationErrorDTO> fieldErrors;
    private String message;

}