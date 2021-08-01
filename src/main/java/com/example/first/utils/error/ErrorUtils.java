package com.example.first.utils.error;

public class ErrorUtils {
    public ErrorUtils() {
    }

    public static void error(ErrorResult errorResult) {
        throw new ServiceError(errorResult);
    }

    public static void error(boolean logic, ErrorResult errorResult) {
        if (logic) {
            error(errorResult);
        }

    }
}