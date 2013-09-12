package com.codexsoft.yormoney.services;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

public class OptimizerService {
    private final Logger log = Logger.getLogger(this.getClass());

    private String path;

    private String env;

    public OptimizerService(){
        env = System.getProperty("yormoney.environment");

    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }
}
