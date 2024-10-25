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
    // Método para validar los datos del propietario
    public boolean validarDatos(String id, String nombre, String correo, String telefono) {
        // Verificar si los campos están vacíos
        if (id.isEmpty() || nombre.isEmpty() || correo.isEmpty() || telefono.isEmpty()) {
            JOptionPane.showMessageDialog(null, 
                "Todos los campos son obligatorios.", 
                "Error de Validación", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Verificar que el ID sea numérico
        if (!esNumerico(id)) {
            JOptionPane.showMessageDialog(null, 
                "El ID debe ser un número válido.", 
                "Error de Validación", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Validar el formato del correo
        if (!esCorreoValido(correo)) {
            JOptionPane.showMessageDialog(null, 
                "El correo electrónico no tiene un formato válido.", 
                "Error de Validación", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Verificar que el teléfono sea numérico
        if (!esNumerico(telefono)) {
            JOptionPane.showMessageDialog(null, 
                "El teléfono debe contener solo números.", 
                "Error de Validación", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Si todas las validaciones pasan
        return true;
    }
    
    // Método auxiliar para verificar si una cadena es numérica
    private boolean esNumerico(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Método auxiliar para validar el formato del correo con expresión regular
    private boolean esCorreoValido(String correo) {
        String regex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";  // Expresión regular para correos
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(correo);
        return matcher.matches();
    }
}
