package com.restapi.apiemployee.response;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ErrorResponse {
    private LocalDateTime time;
    private Integer status;
    private String error;
}
