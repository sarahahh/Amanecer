/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;


import Model.EspacioComun;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author USUARIO
 */
public class ManejoCSV {
   
   private List<EspacioComun> listaDatos;  // Lista para almacenar los datos

    public ManejoCSV() {
        listaDatos = new ArrayList<>();  // Inicialización de la lista
    }

    // Método que agrega datos y los guarda en el archivo CSV
    public void agregarYGuardarDatos(String nombreLugar, String horaInicio, String horaFin, String disponibilidad) {
        // Definir la ruta del archivo
        String rutaArchivo = "RegistroEspaciosComunes.csv"; // Define la ruta del archivo

        // Crear un nuevo objeto EspacioComun
        EspacioComun espacio = new EspacioComun(nombreLugar, horaInicio, horaFin, disponibilidad);
        
        // Agregar los datos a la lista
        listaDatos.add(espacio);
        
        // Guardar los datos en el archivo CSV
        File file = new File(rutaArchivo);
        boolean fileExists = file.exists();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo, true))) { // El modo "true" permite agregar datos sin borrar lo existente
            // Escribir el encabezado solo si el archivo es nuevo
            if (!fileExists) {
                bw.write("Nombre_Lugar;Hora_Inicio;Hora_Fin;Disponibilidad\n"); // Escribir el encabezado
            }
            // Escribir los datos almacenados
            bw.write(String.join(";", espacio.getNombreLugar(), espacio.getHoraInicio(), espacio.getHoraFin(), espacio.getDisponibilidad()) + "\n"); // Guardar el último agregado
            // Mostrar mensaje de éxito al usuario
            JOptionPane.showMessageDialog(null, 
                "Espacio común registrado/actualizado exitosamente.", 
                "Actualización Exitosa", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            e.printStackTrace();
            // Mostrar mensaje de error al usuario
            JOptionPane.showMessageDialog(null, 
                "Error al actualizar el espacio común: " + e.getMessage(), 
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método que carga los datos desde el archivo CSV
    public void cargarDatosDesdeCSV(String rutaArchivo) {
        String linea;
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            br.readLine(); // Saltar el encabezado
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";", -1);
                // Crear un nuevo objeto EspacioComun y agregarlo a la lista
                EspacioComun espacio = new EspacioComun(datos[0], datos[1], datos[2], datos[3]);
                listaDatos.add(espacio);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
   
    
    public List<EspacioComun> getListaDatos() {
        return listaDatos;
    }

    public EspacioComun buscarLugar(String nombreLugar) {
        for (EspacioComun espacioComun : listaDatos) {

            if (espacioComun.getNombreLugar().equals(nombreLugar)) {
                return espacioComun;  // Usuario encontrado
            }
        }
        return null;  // Usuario no encontrado
    }

    public void guardarListaEnCSV(String rutaArchivo) {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo))) {
        // Escribir el encabezado
        bw.write("Nombre_Lugar;Hora_Inicio;Hora_Fin;Disponibilidad\n");

        // Escribir los datos actualizados de cada espacio en la lista
        for (EspacioComun espacio : listaDatos) {
            bw.write(String.join(";", 
                espacio.getNombreLugar(), 
                espacio.getHoraInicio(), 
                espacio.getHoraFin(), 
                espacio.getDisponibilidad()) + "\n");
        }
    } catch (IOException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, 
            "Error al guardar el archivo: " + e.getMessage(), 
            "Error", JOptionPane.ERROR_MESSAGE);
    }
}

}
