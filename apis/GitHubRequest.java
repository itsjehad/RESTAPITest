package com.itsjehad.practice.apis;

import java.util.HashMap;
import java.util.Map;


public class GitHubRequest implements RequestInteface {
    private String url = "https://api.github.com";
    private String path = "/search/repositories";
    private String contentType = "application/json";


    private Map<String, String> headers  = new HashMap<String, String>() {{
        put("Content-type", "Application/Json");
        put("Accept", "Application/Json");
    }};
    private Map<String, String> queryParams  = new HashMap<String, String>() {{
        put("q", "swift");
    }};

    public GitHubRequest() {}

    public GitHubRequest(String url, String path) {
        this.url = url;
        this.path = path;
    }

    public GitHubRequest(String url, String path, Map<String, String> headers) {
        this.url = url;
        this.path = path;
        this.headers = headers;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    @Override
    public Map<String, String> getQueryParams() {
        return queryParams;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }
    public void addHeader(String key, String value){
        headers.put(key, value);
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

}
