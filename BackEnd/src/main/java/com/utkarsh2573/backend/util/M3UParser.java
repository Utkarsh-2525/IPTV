package com.utkarsh2573.backend.util;

import com.utkarsh2573.backend.model.Channel;

import java.util.ArrayList;
import java.util.List;

public class M3UParser {

    public static List<Channel> parse(String content) {

        List<Channel> channels = new ArrayList<>();
        String[] lines = content.split("\n");

        String name = null;
        String logo = null;
        String group = null;

        for (String line : lines) {
            line = line.trim();

            if (line.startsWith("#EXTINF")) {

                name = line.substring(line.lastIndexOf(",") + 1).trim();

                logo = extract(line, "tvg-logo");
                group = extract(line, "group-title");

            } else if (line.startsWith("http")) {

                channels.add(
                        new Channel(name, logo, line, group)
                );
            }
        }

        return channels;
    }

    private static String extract(String line, String key) {
        String token = key + "=\"";
        int start = line.indexOf(token);
        if (start == -1) return null;
        start += token.length();
        int end = line.indexOf("\"", start);
        return end > start ? line.substring(start, end) : null;
    }
}
