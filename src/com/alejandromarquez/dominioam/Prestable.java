package com.alejandromarquez.dominioam;

public interface Prestable {
    void prestar();
    void devolver();
    boolean estaPrestado();
    String getTipo();
    String getNombre();
}
