/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal;

/**
 *
 * @author User
 */
import java.util.ArrayList;
import java.util.List;

public class Profesor extends Persona {
    private final List<Curso> cursos;

    public Profesor(String nombre, String apellido, String id) {
        super(nombre, apellido, id);
        this.cursos = new ArrayList<>();
    }

    public void agregarCurso(Curso curso) {
        cursos.add(curso);
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Profesor: " + getNombre() + " " + getApellido());
        System.out.println("ID: " + getId());
        System.out.println("Cursos: " + cursos);
    }
}
