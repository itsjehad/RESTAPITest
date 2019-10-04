package com.itsjehad.practice;

import com.google.gson.Gson;
import com.itsjehad.practice.apis.GitHubRequest;
import com.itsjehad.practice.apis.RestAPI;
import com.itsjehad.practice.model.GitHubRepository;

import java.util.logging.Logger;


public class GitHubRest {
    private static final Logger logger = Logger.getLogger(GitHubRest.class.toString());

    public static void main(String[] args) {
        //RestAPI restAPI = new RestAPI()
        String json = new RestAPI().get(new GitHubRequest());
        if(json != null){
            GitHubRepository gitHubRepository = new Gson().fromJson(json, GitHubRepository.class);
            if(gitHubRepository != null){
                logger.info("Total item retrieved: " + gitHubRepository.getTotalCount().toString());
            }
        }

    }

}
