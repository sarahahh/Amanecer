/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.util.regex.*;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author USUARIO
 */
public class Validaciones {
    public boolean validarDatos(String nombre, String tipoDocumento, String edad, String documento, 
        String correo, String telefono, String propiedad, String ocupacion) {

        // Validar que todos los campos estén llenos
        if (estaVacio(nombre, tipoDocumento, edad, documento, correo, telefono, propiedad, ocupacion)) {
            mostrarError("Todos los campos son obligatorios.");
            return false;
        }

        // Validar que el nombre solo contenga letras y espacios
        if (!nombre.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) {
            mostrarError("El nombre solo debe contener letras y espacios.");
            return false;
        }

        // Validar que la edad sea numérica y esté entre 1 y 100 años
        if (!esNumerico(edad)) {
            mostrarError("La edad debe ser un número entero.");
            return false;
        }

        // Validar que el tipo de documento no sea "Seleccionar"
        if (tipoDocumento.equalsIgnoreCase("Seleccionar")) {
            mostrarError("Debe seleccionar un tipo de documento válido.");
            return false;
        }

        // Validar que el documento sea numérico y no exceda 10 dígitos
        if (!esNumerico(documento) || documento.length() > 10) {
            mostrarError("El documento debe ser un número de máximo 10 dígitos.");
            return false;
        }

        // Validar el formato del correo
        if (!esCorreoValido(correo)) {
            mostrarError("El correo electrónico no tiene un formato válido.");
            return false;
        }

        // Validar que el teléfono sea numérico y tenga entre 7 y 15 dígitos
        if (!esNumerico(telefono) || telefono.length() < 7 || telefono.length() > 15) {
            mostrarError("El teléfono debe contener solo números y tener entre 7 y 15 dígitos.");
            return false;
        }

        // Validar que la propiedad no esté vacía
        if (propiedad.trim().isEmpty()) {
            mostrarError("La propiedad no puede estar vacía.");
            return false;
        }

        // Validar que la ocupación solo contenga letras y espacios
        if (!ocupacion.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) {
            mostrarError("La ocupación solo debe contener letras y espacios.");
            return false;
        }

        // Si todas las validaciones pasan
        return true;
    }

    // Método auxiliar para verificar si una cadena es numérica
    private boolean esNumerico(String cadena) {
        try {
            Long.parseLong(cadena);  // Permitir números grandes con Long
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Método auxiliar para validar el formato del correo con expresión regular
    private boolean esCorreoValido(String correo) {
        String regex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        return Pattern.matches(regex, correo);
    }

    // Método auxiliar para verificar si algún campo está vacío
    private boolean estaVacio(String... campos) {
        for (String campo : campos) {
            if (campo == null || campo.trim().isEmpty()) {
                return true;
            }
        }
        return false;
    }

    // Método para mostrar mensajes de error
    private void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Error de Validación", JOptionPane.ERROR_MESSAGE);
    }
}
