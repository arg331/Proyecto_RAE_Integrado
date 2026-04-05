package com.example.filmaffinityapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "palabras")
public class Palabra {

    @Id
    private long id; // Usaremos un timestamp o hash como ID si el scraper no da uno

    @NotBlank(message = "La palabra es obligatoria")
    private String palabra;

    @NotBlank(message = "La fecha es obligatoria")
    private String fecha;

    @NotBlank(message = "El enlace es obligatorio")
    private String url_origen;

    public Palabra() {}

    public Palabra(long id, String palabra, String fecha, String url_origen) {
        this.id = id;
        this.palabra = palabra;
        this.fecha = fecha;
        this.url_origen = url_origen;
    }

    // Getters y Setters
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    public String getPalabra() { return palabra; }
    public void setPalabra(String palabra) { this.palabra = palabra; }
    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }
    public String getUrl_origen() { return url_origen; }
    public void setUrl_origen(String url_origen) { this.url_origen = url_origen; }
}