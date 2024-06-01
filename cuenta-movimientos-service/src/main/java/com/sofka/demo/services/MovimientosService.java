package com.sofka.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sofka.demo.models.Movimientos;
import com.sofka.demo.repositories.MovimientosRepository;

@Service
public class MovimientosService {

    @Autowired
    private MovimientosRepository movimientosRepository;

    public List<Movimientos> findAll() {
        return movimientosRepository.findAll();
    }

    public Optional<Movimientos> findById(Long id) {
        return movimientosRepository.findById(id);
    }

    public Movimientos save(Movimientos movimientos) {
        return movimientosRepository.save(movimientos);
    }

    public void deleteById(Long id) {
        movimientosRepository.deleteById(id);
    }
}