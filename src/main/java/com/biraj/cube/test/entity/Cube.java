package com.biraj.cube.test.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.util.UUID;


@Entity
public class Cube {
    @Id
    private UUID uuid;
    private double volume;
    private LocalDateTime createdAt;
    private double sideLength;


    public Cube() {
    }

    public Cube(UUID uuid, double volume, LocalDateTime createdAt, double sideLength) {
        this.uuid = uuid;
        this.volume = volume;
        this.createdAt = createdAt;
        this.sideLength = sideLength;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public double getSideLength() {
        return sideLength;
    }

    public void setSideLength(double sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    public String toString() {
        return "Cube{" +
                "uuid=" + uuid +
                ", volume=" + volume +
                ", createdAt=" + createdAt +
                ", sideLength=" + sideLength +
                '}';
    }
}
