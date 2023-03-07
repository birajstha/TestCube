package com.biraj.cube.test.service;

import com.biraj.cube.test.entity.Cube;
import com.biraj.cube.test.repository.CubeRepositoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class CubeServiceTest {
    @Mock
    private CubeRepositoryService repository;

    @InjectMocks
    private CubeService service;

    private Cube cube;

    private String str="010e074d-0356-4288-8e88-3097844d26d1";


    @BeforeEach
    void setUp() {
        cube = new Cube(UUID.fromString(str), 64, LocalDateTime.now(), 4);
    }

    @Test
    void testGetCubeByUuid() {
        when(repository.findByUuid(UUID.fromString(str))).thenReturn(Optional.ofNullable(cube));
        Cube result = service.findByUuid(UUID.fromString(str));
        assertEquals(4, result.getSideLength());
    }
}