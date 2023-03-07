package com.biraj.cube.test.repository;

import com.biraj.cube.test.entity.Cube;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CubeRepository extends JpaRepository<Cube, String> {
    Cube findByUuid(UUID uuid);
    List<Cube> findByVolume(double volume);
}
