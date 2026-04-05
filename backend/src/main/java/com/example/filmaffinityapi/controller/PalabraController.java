package com.example.filmaffinityapi.controller;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.filmaffinityapi.entity.Palabra;
import com.example.filmaffinityapi.repository.PalabraRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/palabras")
public class PalabraController {
    private final PalabraRepository palabraRepository;
    public PalabraController(PalabraRepository palabraRepository) {
        this.palabraRepository = palabraRepository;
    }
    @GetMapping
    public Iterable<Palabra> getAllPalabras() {
        return palabraRepository.findAll();
    }
    @GetMapping("/search")
    public List<Palabra> searchByPalabra(@RequestParam String palabra) {
        return palabraRepository.findByPalabraContainingIgnoreCase(palabra);
    }
    @GetMapping("/fecha")
    public List<Palabra> searchByFecha(@RequestParam String fecha) {
        return palabraRepository.findByFecha(fecha);
    }
}