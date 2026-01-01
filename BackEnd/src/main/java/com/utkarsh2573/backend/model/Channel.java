package com.utkarsh2573.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Channel {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String logo;
    private String streamUrl;

    // getters & setters
}