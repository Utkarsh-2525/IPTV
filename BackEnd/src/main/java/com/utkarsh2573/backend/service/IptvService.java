package com.utkarsh2573.backend.service;

import com.utkarsh2573.backend.model.Channel;
import com.utkarsh2573.backend.util.M3UParser;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class IptvService {

    private final Map<String, List<Channel>> cache = new ConcurrentHashMap<>();

    public List<Channel> getChannelsByCountry(String code) throws Exception {

        if (cache.containsKey(code)) {
            return cache.get(code);
        }

        String url =
                "https://iptv-org.github.io/iptv/countries/" + code + ".m3u";

        String content = new String(
                new URL(url).openStream().readAllBytes()
        );

        List<Channel> channels = M3UParser.parse(content);

        cache.put(code, channels);
        return channels;
    }
}
