package com.utkarsh2573.backend.controller;

import com.utkarsh2573.backend.model.Channel;
import com.utkarsh2573.backend.repo.ChannelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ChannelController {

    private final ChannelRepository repo;

    @GetMapping("/channels")
    public List<Channel> getAll() {
        return repo.findAll();
    }
}