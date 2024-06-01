package com.sofka.demo.controllers;

import com.sofka.demo.models.Persona;
import com.sofka.demo.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping
    public List<Persona> getAllPersonas() {
        return personaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Persona> getPersonaById(@PathVariable Long id) {
        Optional<Persona> persona = personaService.findById(id);
        return persona.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Persona createPersona(@RequestBody Persona persona) {
        return personaService.save(persona);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Persona> updatePersona(@PathVariable Long id, @RequestBody Persona personaDetails) {
        Optional<Persona> persona = personaService.findById(id);
        if (persona.isPresent()) {
            Persona updatedPersona = persona.get();
            updatedPersona.setNombre(personaDetails.getNombre());
            updatedPersona.setGenero(personaDetails.getGenero());
            updatedPersona.setEdad(personaDetails.getEdad());
            updatedPersona.setIdentificacion(personaDetails.getIdentificacion());
            updatedPersona.setDireccion(personaDetails.getDireccion());
            updatedPersona.setTelefono(personaDetails.getTelefono());
            personaService.save(updatedPersona);
            return ResponseEntity.ok(updatedPersona);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePersona(@PathVariable Long id) {
        if (personaService.findById(id).isPresent()) {
            personaService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
