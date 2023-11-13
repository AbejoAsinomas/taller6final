package com.alejandromarquez.dominioam;

public abstract class Recurso {
    protected boolean prestadoAlejo;
    protected String nombreAlejo;

    public Recurso(String nombreAlejo) {
        this.nombreAlejo = nombreAlejo;
        this.prestadoAlejo = false;
    }

    public boolean estaPrestado() {
        return prestadoAlejo;
    }

    @Override
    public String toString() {
        return getTipo() + ": " + nombreAlejo;
    }

    public abstract String getTipo();
}
