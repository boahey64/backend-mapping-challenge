package com.mhp.coding.challenges.mapping.exceptions;

public class ArticleNotAvailableException extends RuntimeException {
    public ArticleNotAvailableException(String errorMessage) {
        super(errorMessage);
    }

}
