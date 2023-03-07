package com.biraj.cube.test.repository;

import com.biraj.cube.test.entity.Cube;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Transactional
@Service
public class CubeRepositoryService {
    @Autowired
    private CubeRepository repository;

    public void saveCube(Cube cube) {
        repository.save(cube);
    }

    public Optional<Cube> findByUuid(UUID uuid) {
        return Optional.ofNullable(repository.findByUuid(uuid));
    }

    public List<Cube> findByVolume(double volume) {
        return repository.findByVolume(volume);
    }
}
