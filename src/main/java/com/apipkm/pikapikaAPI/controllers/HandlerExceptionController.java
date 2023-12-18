package com.apipkm.pikapikaAPI.controllers;

import com.apipkm.pikapikaAPI.dtos.APIMessageError;
import com.apipkm.pikapikaAPI.dtos.ValidationErrorDTO;
import com.apipkm.pikapikaAPI.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.List;
import java.util.stream.Collectors;
@RestControllerAdvice
public class HandlerExceptionController {
    @ExceptionHandler(PokemonException.class)
    public ResponseEntity<APIMessageError> pokemonExceptionHandle(PokemonException ex){

        return ResponseEntity.status(ex.getStatus()).body(APIMessageError.builder()
                        .httpStatus(ex.getStatus())
                        .message(ex.getMessage())
                .build());

    }
    @ExceptionHandler(RoleException.class)
    public ResponseEntity<APIMessageError> roleExceptionHandle(RoleException ex){

        return ResponseEntity.status(ex.getStatus()).body(APIMessageError.builder()
                .httpStatus(ex.getStatus())
                .message(ex.getMessage())
                .build());

    }
    @ExceptionHandler(UserException.class)
    public ResponseEntity<APIMessageError> userExceptionHandle(UserException ex){

        return ResponseEntity.status(ex.getStatus()).body(APIMessageError.builder()
                .httpStatus(ex.getStatus())
                .message(ex.getMessage())
                .build());

    }
    @ExceptionHandler(PokemonParamException.class)
    public ResponseEntity<APIMessageError> pokemonParamExceptionHandle(PokemonParamException ex){

        List<ValidationErrorDTO> fieldErrors = this.transformToFieldErrors(ex.getBindingResult().getAllErrors());

        APIMessageError apiMessageError = APIMessageError.builder()
                .httpStatus(HttpStatus.BAD_REQUEST)
                .fieldErrors(fieldErrors)
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(apiMessageError);

    }
    @ExceptionHandler(RoleParamException.class)
    public ResponseEntity<APIMessageError> roleParamExceptionHandle(RoleParamException ex){

        List<ValidationErrorDTO> fieldErrors = this.transformToFieldErrors(ex.getBindingResult().getAllErrors());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(APIMessageError.builder()
                .fieldErrors(fieldErrors)
                .httpStatus(HttpStatus.BAD_REQUEST)
                .build());
    }
    @ExceptionHandler(UserParamException.class)
    public ResponseEntity<APIMessageError> userParamExceptionHandle(UserParamException ex){

        List<ValidationErrorDTO> fieldErrors = this.transformToFieldErrors(ex.getBindingResult().getAllErrors());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(APIMessageError.builder()
                        .fieldErrors(fieldErrors)
                        .httpStatus(HttpStatus.BAD_REQUEST)
                .build());

    }

    /*
    * Método que realiza la transformación de una lista de tipo ObjectError
    * proveniente del objeto BindingResult que está presente en la clase de excepción MethodArgumentNotValidException
    * y de la cual están heredando las excepciones personalizadas como: 'UserParamException',
    * que almacena todos los tipos de errores, pero solo se extraen los errores del tipo FieldError
    * y se crea una lista de tipo ValidatinErrorDTO como resultado
    *
    * @param errors - Se obtiene una lista de ObjectError con todos los errores de la clase
    * @return lista ValidationErrorDTO con los errores del tipo FieldError y los mensajes
    * definidos para esos errores, que se obtienen tiene de las anotaciones de validacion
    * aplicados en los atributos de la entidad
    * */
    private List<ValidationErrorDTO> transformToFieldErrors(List<ObjectError> errors){
        return errors.stream()
                .map(error -> {
                    /*Sí el error es una instancia de FieldError, se castea a ese tipo y se obtiene
                    el nombre del campo correspondiente y el mensaje de la excepción*/
                    if(error instanceof FieldError){
                        return ValidationErrorDTO.builder()
                                .field(((FieldError) error).getField())
                                .message(error.getDefaultMessage())
                                .build();
                    }else{
                        /*Sí el error no es una instancia de FieldError, obtenemos el nombre del objeto
                        y el mensaje de la excepción*/
                        return ValidationErrorDTO.builder()
                                .field(error.getObjectName())
                                .message(error.getDefaultMessage())
                                .build();
                    }
                })
                .collect(Collectors.toList());
    }

}