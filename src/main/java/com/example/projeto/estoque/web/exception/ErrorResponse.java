package com.example.projeto.estoque.web.exception;

import java.time.LocalDateTime;
import java.util.Map;

public class ErrorResponse {

    private int status;
    private String mensagem;
    private LocalDateTime timestamp;
    private Map<String, String> erros;

    public ErrorResponse(int status, String mensagem, Map<String, String> erros) {
        this.status = status;
        this.mensagem = mensagem;
        this.timestamp = LocalDateTime.now();
        this.erros = erros;
    }

    public int getStatus() {
        return status;
    }

    public String getMensagem() {
        return mensagem;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public Map<String, String> getErros() {
        return erros;
    }
}