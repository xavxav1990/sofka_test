package com.sofka.demo.services;

import com.sofka.demo.repositories.CuentaRepository;
import com.sofka.demo.repositories.MovimientosRepository;
import com.sofka.demo.models.Cuenta;
import com.sofka.demo.models.Movimientos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReporteService {

    @Autowired
    private CuentaRepository cuentaRepository;

    @Autowired
    private MovimientosRepository movimientosRepository;

    public List<Cuenta> getCuentasPorCliente(Long clienteId) {
        return cuentaRepository.findByClienteId(clienteId);
    }

    public List<Movimientos> getMovimientosPorCuentaYFechas(Long cuentaId, Date fechaInicio, Date fechaFin) {
        return movimientosRepository.findByCuentaIdAndFechaBetween(cuentaId, fechaInicio, fechaFin);
    }
}