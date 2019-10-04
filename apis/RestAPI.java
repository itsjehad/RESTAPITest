package com.itsjehad.practice.apis;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import java.util.Map;
import java.util.logging.Logger;


public class RestAPI {
    private static final Logger logger = Logger.getLogger(RestAPI.class.toString());

    public String get(RequestInteface requestInteface){
        String rv = null;
        Client client = Client.create();
        if(client != null) {
            WebResource webResource = client
                    .resource(requestInteface.getUrl() + requestInteface.getPath());
            for (Map.Entry<String, String> entry: requestInteface.getQueryParams().entrySet( )) {
                webResource = webResource.queryParam(entry.getKey(), entry.getValue());
            }
            WebResource.Builder webResourceBuilder = webResource.getRequestBuilder();

            for (Map.Entry<String, String> entry: requestInteface.getHeaders().entrySet( )) {
                webResourceBuilder = webResourceBuilder.header(entry.getKey(), entry.getValue());
            }

            ClientResponse clientResponse = webResourceBuilder.accept("application/json").get(ClientResponse.class);

            if (clientResponse.getStatus() != 200) {
                logger.warning("Fail to retrieve data. Error: " + clientResponse.toString());
            }
            else{
                rv = clientResponse.getEntity(String.class);
            }
        }

        return rv;

    }

}
