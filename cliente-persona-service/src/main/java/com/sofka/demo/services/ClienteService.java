package com.sofka.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sofka.demo.models.Cliente;
import com.sofka.demo.repositories.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private MessageProducer messageProducer;

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> findById(Long id) {
        return clienteRepository.findById(id);
    }

    public Cliente save(Cliente cliente) {
        Cliente nuevoCliente = clienteRepository.save(cliente);
        messageProducer.sendMessage("Cliente creado: " + nuevoCliente.getId());
        return nuevoCliente;
    }

    public void deleteById(Long id) {
        clienteRepository.deleteById(id);
    }
}