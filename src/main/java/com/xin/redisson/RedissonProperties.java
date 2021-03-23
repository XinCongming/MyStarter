package com.xin.redisson;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by xinBa.
 * User: 辛聪明
 * Date: 2021/3/23
 */
@ConfigurationProperties(prefix = "xin.redisson")
public class RedissonProperties {
    private String host="localhost";
    private int port = 6379;
    private String password;
    private int timeout; //超时时间
    private boolean ssl; //是否加密传输

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public boolean isSsl() {
        return ssl;
    }

    public void setSsl(boolean ssl) {
        this.ssl = ssl;
    }
}
