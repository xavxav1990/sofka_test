package com.sofka.demo.models;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("CLIENTE")
public class Cliente extends Persona {

    @Column(nullable = false)
    private String contrasenia;

    @Column(nullable = false)
    private boolean estado;

    // Getters y setters

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}