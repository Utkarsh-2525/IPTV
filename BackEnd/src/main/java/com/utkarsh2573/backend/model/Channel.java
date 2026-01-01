package com.utkarsh2573.backend.model;

public class Channel {

    private String name;
    private String logo;
    private String streamUrl;
    private String group;

    public Channel(String name, String logo, String streamUrl, String group) {
        this.name = name;
        this.logo = logo;
        this.streamUrl = streamUrl;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public String getLogo() {
        return logo;
    }

    public String getStreamUrl() {
        return streamUrl;
    }

    public String getGroup() {
        return group;
    }
}
