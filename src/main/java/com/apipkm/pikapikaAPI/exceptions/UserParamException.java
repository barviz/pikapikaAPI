package com.apipkm.pikapikaAPI.exceptions;

import lombok.Builder;
import lombok.Data;
import org.springframework.core.MethodParameter;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;

@Data
@Builder
public class UserParamException extends MethodArgumentNotValidException {
    public UserParamException(MethodParameter methodParameter, BindingResult bindingResult){
        super(methodParameter, bindingResult);
    }
}
