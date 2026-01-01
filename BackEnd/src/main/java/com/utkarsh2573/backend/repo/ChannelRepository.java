package com.utkarsh2573.backend.repo;

import com.utkarsh2573.backend.model.Channel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChannelRepository extends JpaRepository<Channel, Long> {
}
