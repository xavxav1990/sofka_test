package com.sofka.demo.controllers;


import com.sofka.demo.models.Movimientos;
import com.sofka.demo.services.MovimientosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movimientos")
public class MovimientosController {

    @Autowired
    private MovimientosService movimientosService;

    @GetMapping
    public List<Movimientos> getAllMovimientos() {
        return movimientosService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movimientos> getMovimientosById(@PathVariable Long id) {
        Optional<Movimientos> movimientos = movimientosService.findById(id);
        return movimientos.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> createMovimientos(@RequestBody Movimientos movimientos) {
        try {
            Movimientos nuevoMovimiento = movimientosService.save(movimientos);
            return ResponseEntity.ok(nuevoMovimiento);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movimientos> updateMovimientos(@PathVariable Long id, @RequestBody Movimientos movimientosDetails) {
        Optional<Movimientos> movimientos = movimientosService.findById(id);
        if (movimientos.isPresent()) {
            Movimientos updatedMovimientos = movimientos.get();
            updatedMovimientos.setFecha(movimientosDetails.getFecha());
            updatedMovimientos.setTipomovimiento(movimientosDetails.getTipomovimiento());
            updatedMovimientos.setValor(movimientosDetails.getValor());
            updatedMovimientos.setSaldo(movimientosDetails.getSaldo());
            movimientosService.save(updatedMovimientos);
            return ResponseEntity.ok(updatedMovimientos);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovimientos(@PathVariable Long id) {
        if (movimientosService.findById(id).isPresent()) {
            movimientosService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}