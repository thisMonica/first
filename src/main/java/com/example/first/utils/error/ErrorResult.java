package com.example.first.utils.error;

import java.util.Locale;

/**
 * @author hu
 * @date 2021/7/13 1:27
 * @desc:
 */
public interface ErrorResult {

    String code();

    String message();

    String platform();

    String direct();

    String message(Locale var1);
}
