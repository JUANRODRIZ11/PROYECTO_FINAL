/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyectofinal;

/**
 *
 * @author User
 */
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ProyectoFinal {
    private static final List<Estudiante> estudiantes = new ArrayList<>();
    private static final List<Profesor> profesores = new ArrayList<>();
    private static final List<Curso> cursos = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("     UNIVERSIDAD TECNOLÓGICA DE HONDURAS     ");
            System.out.println("           SISTEMA DE ESTUDIANTES            ");
            System.out.println("1. INGRESAR ESTUDIANTE");
            System.out.println("2. INGRESAR MAESTRO");
            System.out.println("3. INGRESAR CURSO O ASIGNATURA");
            System.out.println("4. MOSTRARME INFORMACIÓN");
            System.out.println("5. ABANDONAR SISTEMA");

            try {
                int opcion = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea

                switch (opcion) {
                    case 1:
                        agregarEstudiante(scanner);
                        break;
                    case 2:
                        agregarProfesor(scanner);
                        break;
                    case 3:
                        agregarCurso(scanner);
                        break;
                    case 4:
                        mostrarInformacion();
                        break;
                    case 5:
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción no válida");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un valor correcto.");
                scanner.next(); // Limpiar el scanner
            }
        }
        scanner.close();
    }
//Agregar esudiantes a nuestro sistema
    private static void agregarEstudiante(Scanner scanner) {
        System.out.println("Ingrese el nombre del estudiante:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese el apellido del estudiante:");
        String apellido = scanner.nextLine();
        System.out.println("Ingrese el ID del estudiante:");
        String id = scanner.nextLine();
        Estudiante estudiante = new Estudiante(nombre, apellido, id);
        estudiantes.add(estudiante);
        System.out.println("      HAZ AGREGADO AL ESTUDIANTE SATISFACTORIAMENTE...     ");
    }
//Agregar Maestros a nuestro sistema
    private static void agregarProfesor(Scanner scanner) {
        System.out.println("Ingrese el nombre del profesor:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese el apellido del profesor:");
        String apellido = scanner.nextLine();
        System.out.println("Ingrese el ID del profesor:");
        String id = scanner.nextLine();
        Profesor profesor = new Profesor(nombre, apellido, id);
        profesores.add(profesor);
        System.out.println("      HAZ AGREGADO AL MAESTRO SATISFACTORIAMENTE...     ");
    }
//Agregar curso a nuestro sistema
    private static void agregarCurso(Scanner scanner) {
        System.out.println("Ingrese el nombre del curso:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese el código del curso:");
        String codigo = scanner.nextLine();
        System.out.println("Ingrese el ID del profesor:");
        String idProfesor = scanner.nextLine();
        Profesor profesor = buscarProfesorPorId(idProfesor);
        if (profesor != null) {
            Curso curso = new Curso(nombre, codigo, profesor);
            cursos.add(curso);
            profesor.agregarCurso(curso);
            System.out.println("      HAZ AGREGADO LA ASIGNATURA SATISFACTORIAMENTE...     ");
        } else {
            System.out.println("REVISA LA INFORMACIÓN QUE INGRESASTE, NO ENCONTRAMOS TU PROFESOR ");
        }
    }
// Buscar al profesor por su id
    
    private static Profesor buscarProfesorPorId(String id) {
        for (Profesor profesor : profesores) {
            if (profesor.getId().equals(id)) {
                return profesor;
            }
        }
        return null;
    }
//Método para mostrar la información al presionar opción 4
    private static void mostrarInformacion() {
        System.out.println("Estudiantes:");
        for (Estudiante estudiante : estudiantes) {
            estudiante.mostrarInformacion();
        }
        System.out.println("Profesores:");
        for (Profesor profesor : profesores) {
            profesor.mostrarInformacion();
        }
        System.out.println("Cursos:");
        for (Curso curso : cursos) {
            System.out.println("Curso: " + curso.getNombre() + ", Código: " + curso.getCodigo() + ", Profesor: " + curso.getProfesor().getNombre());
        }
    }
}