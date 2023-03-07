package com.biraj.cube.test.service;

import com.biraj.cube.test.entity.Cube;
import com.biraj.cube.test.repository.CubeRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@Service
public class CubeService {
    private static final int CACHE_DURATION_MINUTES = 5;

    @Autowired
    private CubeRepositoryService repoService;

    @Cacheable(value = "myCache")
    public Cube generateCube(double volume) {
        double sideLength = Math.cbrt(volume);
        UUID uuid = UUID.randomUUID();
        LocalDateTime createdAt = LocalDateTime.now();
        return new Cube(uuid, volume, createdAt, sideLength);
    }

    public void save(Cube cube) {
        repoService.saveCube(cube);
    }

    public Cube findByUuid(UUID uuid) {
        return repoService.findByUuid(uuid).orElseThrow();
    }

    public List<Cube> findByVolume(double volume) {
        return repoService.findByVolume(volume);
    }

    public List<Cube> findCubeByCustomDimension(String str) {
        String[] arr = str.split("-");
        double volume = Arrays.stream(arr)
                .mapToDouble(Double::parseDouble)
                .reduce(1, (acc, num) -> acc*num);
        List<Cube> cube = repoService.findByVolume(volume);
        return cube;
    }
}
