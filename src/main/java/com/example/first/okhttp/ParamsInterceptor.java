package com.example.first.okhttp;

import okhttp3.*;
import okio.Buffer;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.*;

/**
 * @author hu
 * @date 2020/10/26 1:20
 * @desc:
 */
public class ParamsInterceptor implements Interceptor {


    Map<String, String> queryParamsMap = new HashMap<>();
    Map<String, String> paramsMap = new HashMap<>();
    Map<String, String> headerParamsMap = new HashMap<>();
    List<String> headerLinesList = new ArrayList<>();

    public ParamsInterceptor() {
    }

    @Override
    public Response intercept(Chain chain) throws IOException {

        Request request = chain.request();
        Request.Builder requestBuilder = request.newBuilder();

        // 请求头参数注入
        if (headerParamsMap != null && headerParamsMap.size() > 0) {
            Set<String> keys = headerParamsMap.keySet();
            for (String headerKey : keys) {
                requestBuilder.addHeader(headerKey, headerParamsMap.get(headerKey)).build();
            }
        }
        Headers.Builder headerBuilder = request.headers().newBuilder();
        if (headerLinesList.size() > 0) {
            for (String line : headerLinesList) {
                headerBuilder.add(line);
            }
            requestBuilder.headers(headerBuilder.build());
        }

        // 处理GET或者POST请求
        if (queryParamsMap.size() > 0) {
            request = injectParamsIntoUrl(request.url().newBuilder(), requestBuilder, queryParamsMap);
        }

        // POST请求的body注入
        if (paramsMap.size() > 0) {
            if (canInjectIntoBody(request)) {
                FormBody.Builder formBodyBuilder = new FormBody.Builder();
                for (Map.Entry<String, String> entry : paramsMap.entrySet()) {
                    formBodyBuilder.add((String) entry.getKey(), (String) entry.getValue());
                }

                RequestBody formBody = formBodyBuilder.build();
                String postBodyString = bodyToString(request.body());
                postBodyString += ((postBodyString.length() > 0) ? "&" : "") + bodyToString(formBody);
                requestBuilder.post(RequestBody.create(MediaType.parse("application/x-www-form-urlencoded;charset=UTF-8"), postBodyString));
            }
        }

        request = requestBuilder.build();

        return chain.proceed(request);
    }

    private boolean canInjectIntoBody(Request request) {
        if (request == null) {
            return false;
        }
        if (!"POST".equals(request.method())) {
            return false;
        }
        RequestBody body = request.body();
        if (body == null) {
            return false;
        }
        MediaType mediaType = body.contentType();
        if (mediaType == null) {
            return false;
        }
        if (!"x-www-form-urlencoded".equals(mediaType.subtype())) {
            return false;
        }
        return true;
    }

    // 参数注入到url
    private Request injectParamsIntoUrl(HttpUrl.Builder httpUrlBuilder, Request.Builder requestBuilder, Map<String, String> paramsMap) {
        if (paramsMap.size() > 0) {
            Iterator iterator = paramsMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry entry = (Map.Entry) iterator.next();
                httpUrlBuilder.addQueryParameter((String) entry.getKey(), (String) entry.getValue());
            }
            requestBuilder.url(httpUrlBuilder.build());
            return requestBuilder.build();
        }
        FormBody.Builder bodyBuilder = new FormBody.Builder();
        return null;
    }

    private static String bodyToString(final RequestBody request) {
        try {
            final RequestBody copy = request;
            final Buffer buffer = new Buffer();
            if (copy != null)
                copy.writeTo(buffer);
            else
                return "";
            return buffer.readUtf8();
        } catch (final IOException e) {
            return "did not work";
        }
    }

    public static class Builder {

        ParamsInterceptor interceptor;

        public Builder() {
            interceptor = new ParamsInterceptor();
        }

        public Builder addParam(String key, String value) {
            interceptor.paramsMap.put(key, value);
            return this;
        }

        public Builder addParamsMap(Map<String, String> paramsMap) {
            interceptor.paramsMap.putAll(paramsMap);
            return this;
        }

        public Builder addHeaderParam(String key, String value) {
            interceptor.headerParamsMap.put(key, value);
            return this;
        }

        public Builder addHeaderParamsMap(Map<String, String> headerParamsMap) {
            interceptor.headerParamsMap.putAll(headerParamsMap);
            return this;
        }

        public Builder addHeaderLine(String headerLine) {
            int index = headerLine.indexOf(":");
            if (index == -1) {
                throw new IllegalArgumentException("Unexpected header: " + headerLine);
            }
            interceptor.headerLinesList.add(headerLine);
            return this;
        }

        public Builder addHeaderLinesList(List<String> headerLinesList) {
            for (String headerLine : headerLinesList) {
                int index = headerLine.indexOf(":");
                if (index == -1) {
                    throw new IllegalArgumentException("Unexpected header: " + headerLine);
                }
                interceptor.headerLinesList.add(headerLine);
            }
            return this;
        }

        public Builder addQueryParam(String key, String value) {
            interceptor.queryParamsMap.put(key, value);
            return this;
        }

        public Builder addQueryParamsMap(Map<String, String> queryParamsMap) {
            interceptor.queryParamsMap.putAll(queryParamsMap);
            return this;
        }

        public ParamsInterceptor build() {
            return interceptor;
        }

    }
}



