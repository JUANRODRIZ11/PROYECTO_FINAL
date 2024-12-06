/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class Estudiante extends Persona {

    private final List<Curso> cursos;

    public Estudiante(String nombre, String apellido, String id) {
        super(nombre, apellido, id);
        this.cursos = new ArrayList<>();
    }

    
    public void agregarCurso(Curso curso) {
        cursos.add(curso);
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Estudiante: " + getNombre() + " " + getApellido());
        System.out.println("ID: " + getId());
        System.out.println("Cursos: " + cursos);
    }
}
