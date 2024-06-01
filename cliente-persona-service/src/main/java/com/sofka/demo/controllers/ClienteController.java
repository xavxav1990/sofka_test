package com.sofka.demo.controllers;


import com.sofka.demo.models.Cliente;
import com.sofka.demo.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    @PostMapping
    public Cliente createCliente(@RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getClienteById(@PathVariable Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if (cliente.isPresent()) {
            return ResponseEntity.ok(cliente.get());
        } else {
            Map<String, String> response = new HashMap<>();
            response.put("message", "Cliente no encontrado con id: " + id);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCliente(@PathVariable Long id, @RequestBody Cliente clienteDetails) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        if (clienteOptional.isPresent()) {
            Cliente cliente = clienteOptional.get();
            cliente.setNombre(clienteDetails.getNombre());
            cliente.setGenero(clienteDetails.getGenero());
            cliente.setEdad(clienteDetails.getEdad());
            cliente.setIdentificacion(clienteDetails.getIdentificacion());
            cliente.setDireccion(clienteDetails.getDireccion());
            cliente.setTelefono(clienteDetails.getTelefono());
            cliente.setContrasenia(clienteDetails.getContrasenia());
            cliente.setEstado(clienteDetails.isEstado());
            final Cliente updatedCliente = clienteRepository.save(cliente);
            return ResponseEntity.ok(updatedCliente);
        } else {
            Map<String, String> response = new HashMap<>();
            response.put("message", "Cliente no encontrado con id: " + id);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCliente(@PathVariable Long id) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        if (clienteOptional.isPresent()) {
            clienteRepository.delete(clienteOptional.get());
            Map<String, Boolean> response = new HashMap<>();
            response.put("deleted", Boolean.TRUE);
            return ResponseEntity.ok(response);
        } else {
            Map<String, String> response = new HashMap<>();
            response.put("message", "Cliente no encontrado con id: " + id);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
}