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
    public boolean validarDatosRegistro(String nombre, String tipoDocumento, String edad, String documento, 
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
    
    public boolean validarDatosFactura(String propietario, String numeroDocumento, String numeroFactura, String fechaFactura,
        String propiedad, String valorMetroCuadrado, String valorAdministracion, String fechaMaxPago, String totalPagar) {

        // Verificar si algún campo está vacío
        if (estaVacio(propietario, numeroDocumento, numeroFactura, fechaFactura, 
                      propiedad, valorMetroCuadrado, valorAdministracion, 
                      fechaMaxPago, totalPagar)) {
            mostrarError("Todos los campos son obligatorios.");
            return false;
        }

        // Validar que el propietario solo contenga letras y espacios
        if (!propietario.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) {
            mostrarError("El nombre del propietario solo debe contener letras y espacios.");
            return false;
        }

        // Validar que el número de documento sea numérico y tenga máximo 10 dígitos
        if (!esNumerico(numeroDocumento) || numeroDocumento.length() > 10) {
            mostrarError("El número de documento debe ser numérico y de máximo 10 dígitos.");
            return false;
        }

        // Validar que el número de factura sea numérico
        if (!esNumerico(numeroFactura)) {
            mostrarError("El número de factura debe ser numérico.");
            return false;
        }

        // Validar el formato de la fecha de la factura (dd/MM/yyyy)
        if (!esFechaValida(fechaFactura)) {
            mostrarError("La fecha de la factura no tiene un formato válido (dd/MM/yyyy).");
            return false;
        }

        // Validar que el valor del metro cuadrado sea numérico y positivo
        if (!esDecimalPositivo(valorMetroCuadrado)) {
            mostrarError("El valor por metro cuadrado debe ser un número positivo.");
            return false;
        }

        // Validar que el valor de la administración sea numérico y positivo
        if (!esDecimalPositivo(valorAdministracion)) {
            mostrarError("El valor de la administración debe ser un número positivo.");
            return false;
        }

        // Validar el formato de la fecha máxima de pago (dd/MM/yyyy)
        if (!esFechaValida(fechaMaxPago)) {
            mostrarError("La fecha máxima de pago no tiene un formato válido (dd/MM/yyyy).");
            return false;
        }

        // Validar que el total a pagar sea numérico y positivo
        if (!esDecimalPositivo(totalPagar)) {
            mostrarError("El total a pagar debe ser un número positivo.");
            return false;
        }

        // Si todas las validaciones pasan
        return true;
    }
    
    public boolean validarDatosMulta(String codigoMulta, String persona, String fechaMulta, String propiedad, 
                                  String fechaEventoMulta, String evento, String valorMulta, String fechaMaxPago) {
        // Verificar si los campos están vacíos
        if (codigoMulta.isEmpty() || persona.isEmpty() || fechaMulta.isEmpty() || propiedad.isEmpty() ||
            fechaEventoMulta.isEmpty() || evento.isEmpty() || valorMulta.isEmpty() || fechaMaxPago.isEmpty()) {
            JOptionPane.showMessageDialog(null, 
                "Todos los campos son obligatorios.", 
                "Error de Validación", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Verificar que el código de multa sea numérico
        if (!esNumerico(codigoMulta)) {
            JOptionPane.showMessageDialog(null, 
                "El código de multa debe ser un número válido.", 
                "Error de Validación", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Validar el formato de la fecha (Ejemplo: "dd/MM/yyyy")
        if (!esFechaValida(fechaMulta) || !esFechaValida(fechaEventoMulta) || !esFechaValida(fechaMaxPago)) {
            JOptionPane.showMessageDialog(null, 
                "Las fechas deben tener el formato dd/MM/yyyy.", 
                "Error de Validación", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Verificar que el valor de la multa sea numérico
        if (!esNumerico(valorMulta)) {
            JOptionPane.showMessageDialog(null, 
                "El valor de la multa debe ser un número válido.", 
                "Error de Validación", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Si todas las validaciones pasan
        return true;
    }

    

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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
    
    // Método auxiliar para verificar si una cadena es un número decimal positivo
    private boolean esDecimalPositivo(String cadena) {
        try {
            double valor = Double.parseDouble(cadena);
            return valor > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    // Método auxiliar para verificar el formato de una fecha (dd/MM/yyyy)
    private boolean esFechaValida(String fecha) {
        String regex = "^\\d{2}/\\d{2}/\\d{4}$";  // Expresión regular para fechas en formato dd/MM/yyyy
        return Pattern.matches(regex, fecha);
    }

    // Método para mostrar mensajes de error
    private void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Error de Validación", JOptionPane.ERROR_MESSAGE);
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
