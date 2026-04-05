package com.example.filmaffinityapi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.filmaffinityapi.entity.Palabra;

public interface PalabraRepository extends CrudRepository<Palabra, Long> {
    List<Palabra> findByPalabraContainingIgnoreCase(String palabra);
    List<Palabra> findByFecha(String fecha); 
}