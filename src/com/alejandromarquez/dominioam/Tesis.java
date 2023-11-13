package com.alejandromarquez.dominioam;

public class Tesis extends Recurso implements Prestable {
    public Tesis(String nombre) {
        super(nombre);
    }

    @Override
    public void prestar() {
        if (!prestadoAlejo) {
            prestadoAlejo = true;
            System.out.println("Tesis prestada: " + toString());
        } else {
            System.out.println("La tesis ya está prestada.");
        }
    }

    @Override
    public void devolver() {
        if (prestadoAlejo) {
            prestadoAlejo = false;
            System.out.println("Tesis devuelta: " + toString());
        } else {
            System.out.println("La tesis no está prestada.");
        }
    }

    @Override
    public String getTipo() {
        return "Tesis";
    }
    @Override
    public String getNombre() {
        return nombreAlejo;
    }
}

