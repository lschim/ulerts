package com.hackton.ulertsregistries.model;

public class Case {

    private final long id;
    private final String content;

    public Case(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}