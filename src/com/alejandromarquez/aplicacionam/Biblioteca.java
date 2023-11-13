package com.alejandromarquez.aplicacionam;
import com.alejandromarquez.dominioam.*;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Recurso> recursosDisponiblesAlejo = new ArrayList<>();
    private List<Recurso> recursosPrestadosAlejo = new ArrayList<>();

    public Biblioteca() {
    }

    public void addRecurso(Recurso recurso) {
        recursosDisponiblesAlejo.add(recurso);
    }

    public boolean prestarRecurso(Prestable prestable) {
        if (recursosDisponiblesAlejo.contains(prestable) && !prestable.estaPrestado()) {
            prestable.prestar();
            recursosPrestadosAlejo.add((Recurso) prestable);
            recursosDisponiblesAlejo.remove(prestable);
            return true;
        } else {
            System.out.println("El recurso '" + prestable.getNombre() + "' no está disponible para préstamo.");
            return false;
        }
    }

    public boolean devolverRecurso(Prestable prestable) {
        if (recursosPrestadosAlejo.contains(prestable) && prestable.estaPrestado()) {
            prestable.devolver();
            recursosPrestadosAlejo.remove(prestable);
            recursosDisponiblesAlejo.add((Recurso) prestable);
            return true;
        } else {
            System.out.println("El recurso no está prestado o no es válido para devolución.");
            return false;
        }
    }

    public void listarPrestados() {
        System.out.println("Recursos Prestados:");
        for (Recurso recurso : recursosPrestadosAlejo) {
            System.out.println(recurso);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        Libro libro1 = new Libro("Cien años de soledad");
        Libro libro2 = new Libro("El amor en los tiempos del cólera");
        Libro libro3 = new Libro("La vorágine");
        Tesis tesis1 = new Tesis("Desarrollo sostenible en las áreas rurales de Colombia");
        Tesis tesis2 = new Tesis("Impacto de la minería en el medio ambiente en la región andina");
        Revista revista1 = new Revista("Revista Colombiana de Ciencias Sociales");
        Revista revista2 = new Revista("Revista Colombiana de Medicina");

        biblioteca.addRecurso(libro1);
        biblioteca.addRecurso(libro2);
        biblioteca.addRecurso(libro3);
        biblioteca.addRecurso(tesis1);
        biblioteca.addRecurso(tesis2);
        biblioteca.addRecurso(revista1);
        biblioteca.addRecurso(revista2);

        biblioteca.prestarRecurso(libro1);
        biblioteca.prestarRecurso(libro2);
        biblioteca.prestarRecurso(tesis1);
        biblioteca.prestarRecurso(revista1);

        biblioteca.listarPrestados();

        biblioteca.devolverRecurso(libro1);
        biblioteca.devolverRecurso(tesis1);

        biblioteca.listarPrestados();
    }
}






