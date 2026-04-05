package com.example.filmaffinityapi;

import com.example.filmaffinityapi.entity.Palabra;
import com.example.filmaffinityapi.repository.PalabraRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.core.io.ClassPathResource;

import java.io.InputStream;

@Component
public class DataLoader implements CommandLineRunner {

    private final PalabraRepository palabraRepository;

    public DataLoader(PalabraRepository palabraRepository) {
        this.palabraRepository = palabraRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (palabraRepository.count() > 0) {
            System.out.println("Database already populated, skipping data load.");
            return;
        }

        ObjectMapper mapper = new ObjectMapper();
        ClassPathResource resource = new ClassPathResource("palabras.json");
        InputStream inputStream = resource.getInputStream();
        JsonNode rootNode = mapper.readTree(inputStream);

        long id = 1;
        for (JsonNode node : rootNode) {
            Palabra palabra = new Palabra(
                id++,
                node.get("palabra").asText(),
                node.get("fecha").asText(),
                node.get("url_origen").asText()
            );
            palabraRepository.save(palabra);
        }

        System.out.println("Loaded " + palabraRepository.count() + " palabras into the database.");
    }
}