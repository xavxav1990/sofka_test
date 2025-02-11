package com.sofka.demo.controllers;


import com.sofka.demo.models.Cuenta;
import com.sofka.demo.services.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cuentas")
public class CuentaController {

    @Autowired
    private CuentaService cuentaService;

    @GetMapping
    public List<Cuenta> getAllCuentas() {
        return cuentaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cuenta> getCuentaById(@PathVariable Long id) {
        Optional<Cuenta> cuenta = cuentaService.findById(id);
        return cuenta.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Cuenta createCuenta(@RequestBody Cuenta cuenta) {
        return cuentaService.save(cuenta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cuenta> updateCuenta(@PathVariable Long id, @RequestBody Cuenta cuentaDetails) {
        Optional<Cuenta> cuenta = cuentaService.findById(id);
        if (cuenta.isPresent()) {
            Cuenta updatedCuenta = cuenta.get();
            updatedCuenta.setTipoCuenta(cuentaDetails.getTipoCuenta());
            updatedCuenta.setSaldoInicial(cuentaDetails.getSaldoInicial());
            updatedCuenta.setEstado(cuentaDetails.getEstado());
            cuentaService.save(updatedCuenta);
            return ResponseEntity.ok(updatedCuenta);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCuenta(@PathVariable Long id) {
        if (cuentaService.findById(id).isPresent()) {
            cuentaService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}