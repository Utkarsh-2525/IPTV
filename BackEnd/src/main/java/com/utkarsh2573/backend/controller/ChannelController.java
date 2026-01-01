package com.utkarsh2573.backend.controller;

import com.utkarsh2573.backend.model.Channel;
import com.utkarsh2573.backend.service.IptvService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ChannelController {

    private final IptvService service;

    public ChannelController(IptvService service) {
        this.service = service;
    }

    // Example: /api/channels/in
    @GetMapping("/channels/{country}")
    public List<Channel> channels(@PathVariable String country)
            throws Exception {

        return service.getChannelsByCountry(country);
    }
}
