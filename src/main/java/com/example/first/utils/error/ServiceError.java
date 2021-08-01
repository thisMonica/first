package com.example.first.utils.error;

import java.util.Locale;

/**
 * @author hu
 * @date 2021/7/13 1:28
 * @desc:
 */
public class ServiceError extends RuntimeException implements ErrorResult {
    ErrorResult errorResult;

    public ServiceError(ErrorResult errorResult) {
        super(errorResult != null ? String.format("code=%s,message=%s,platform=%s,direct=%s", errorResult.code(), errorResult.message(), errorResult.platform(), errorResult.direct()) : "");
        this.errorResult = errorResult;
    }

    public String code() {
        return this.errorResult.code();
    }

    public String message() {
        return this.errorResult.message();
    }

    public String platform() {
        return this.errorResult.platform();
    }

    public String direct() {
        return this.errorResult.direct();
    }

    public String message(Locale lang) {
        return this.errorResult.message(lang);
    }
}
