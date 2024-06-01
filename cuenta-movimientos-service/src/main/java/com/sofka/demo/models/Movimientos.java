package com.sofka.demo.models;


import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "movimientos")
public class Movimientos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date fecha;
    private String tipomovimiento;
    private double valor;
    private double saldo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "numerocuenta")
    private Cuenta cuenta;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTipomovimiento() {
        return tipomovimiento;
    }

    public void setTipomovimiento(String tipomovimiento) {
        this.tipomovimiento = tipomovimiento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
}