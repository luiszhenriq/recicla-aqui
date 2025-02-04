package br.com.luis.reclica_aqui.infra.exception;

public record ErrorResponse(Long timestamp, Integer status, String error, String message, String path) {
}
