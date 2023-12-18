package com.apipkm.pikapikaAPI.dtos;

import lombok.*;
import org.springframework.stereotype.Component;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Component
public class ValidationErrorDTO {

    private String field;
    private String message;

}