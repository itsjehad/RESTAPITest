package com.itsjehad.practice.apis;

import java.util.Map;


public interface RequestInteface {
    String getUrl();
    String getContentType();
    String getPath();
    Map<String, String> getHeaders();
    Map<String, String> getQueryParams();

}
