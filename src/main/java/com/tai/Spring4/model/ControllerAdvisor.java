package com.tai.Spring4.model;

import com.tai.Spring4.exx.FieldRequireException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<Object> handleArithmeticException(
            ArithmeticException ex, WebRequest Request){
        ErrorDTO dto = new ErrorDTO();
        dto.setError(ex.getMessage());
        List<String> listdetail = new ArrayList<>();
        listdetail.add("so nguyen ko chia dc cho 0");
        dto.setDetail(listdetail);
        return new ResponseEntity<>(dto, HttpStatus.INTERNAL_SERVER_ERROR); // 500 error
    }
//    @ExceptionHandler(FieldRequireException.class)
//    public ResponseEntity<Object> handleFieldRequireException(
//            FieldRequireException ex, WebRequest Request){
//        ErrorDTO dto = new ErrorDTO();
//        dto.setError(ex.getMessage());
//        List<String> listdetail = new ArrayList<>();
//        listdetail.add("chua nhap name kia");
//        dto.setDetail(listdetail);
//        return new ResponseEntity<>(dto, HttpStatus.BAD_GATEWAY); // 500 error
//    }
@ExceptionHandler(Exceptionname.class)
public ResponseEntity<Object> handleExceptionname(
        Exceptionname ex, WebRequest request) {
    ErrorDTO dto = new ErrorDTO();
    dto.setError(ex.getMessage());
    List<String> listDetail = new ArrayList<>();
    listDetail.add("Tên bị null hoặc rỗng");
    dto.setDetail(listDetail);
    return new ResponseEntity<>(dto, HttpStatus.BAD_GATEWAY);
}
@ExceptionHandler(FieldRequireException.class)
public ResponseEntity<Object> handleFieldRequireException(
        FieldRequireException ex, WebRequest request) {
    ErrorDTO dto = new ErrorDTO();
    dto.setError(ex.getMessage());
    List<String> listDetail = new ArrayList<>();
    listDetail.add("Chưa nhập tên");
    dto.setDetail(listDetail);
    return new ResponseEntity<>(dto, HttpStatus.BAD_GATEWAY);
}
}
