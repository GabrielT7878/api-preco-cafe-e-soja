package com.portifolio.preco_commoditie.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class WebScrapingException extends RuntimeException {

    public WebScrapingException(String message) {
        super(message);
    }
}
