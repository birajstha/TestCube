package com.biraj.cube.test.controller;

import com.biraj.cube.test.entity.Cube;
import com.biraj.cube.test.service.CubeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cubes")
public class CubeController {
    @Autowired
    private CubeService cubeService;

    @GetMapping("/{volume}")
    public ResponseEntity<Cube> generateCube(@PathVariable double volume) {
        Cube cube = cubeService.generateCube(volume);
        return new ResponseEntity<>(cube, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Void> saveCube(@RequestBody Cube cube) {
        cubeService.save(cube);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/findByUuid/{uuid}")
    public ResponseEntity<Cube> findCubeByUuid(@PathVariable UUID uuid) {
        Cube cube = cubeService.findByUuid(uuid);
        return new ResponseEntity<>(cube, HttpStatus.OK);
    }

    @GetMapping("/findByVolume/{volume}")
    public List<Cube> findCubeByVolume(@PathVariable double volume) {
        List<Cube> cube = cubeService.findByVolume(volume);
        return cube;
    }

    @GetMapping("/findByCustomDim/{str}")
    public List<Cube> findCubeByCustomDim(@PathVariable String str){
        return cubeService.findCubeByCustomDimension(str);
    }

}
