package br.com.tonsoft.modelagemwebservice.error;

import org.springframework.http.HttpStatus;

import java.io.Serializable;

public class StandardError implements Serializable {
    private static final Long serialVersionUID = 1L;

    private Integer status;
    private String message;
    private Long timestamp;

    public StandardError(Integer status, String message, Long timestamp) {
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}
