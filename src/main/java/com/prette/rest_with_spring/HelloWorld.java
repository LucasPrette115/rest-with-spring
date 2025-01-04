package com.prette.rest_with_spring;

public class HelloWorld {

    private final long id;
    private final String content;

    public HelloWorld(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public long getId() {
        return id;
    }
}
