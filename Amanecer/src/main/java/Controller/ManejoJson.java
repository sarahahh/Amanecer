/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Persona;
import com.google.gson.GsonBuilder;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author USUARIO
 */
public class ManejoJson {

/////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Método para leer el archivo json
    public List<Persona> leerJSON(String rutaArchivo) {
        
        List<Persona> propietarios = new ArrayList<>();
        
        try (FileReader reader = new FileReader("propietarios.json")) {
            // Instanciar Gson y definir el tipo de la lista
            Gson gson = new Gson();
            Type propietariosListType = new TypeToken<ArrayList<Persona>>() {}.getType();
            
            // Deserializar el JSON al tipo esperado
            propietarios = gson.fromJson(reader, propietariosListType);
            
            // Confirmación para verificar que se leyeron los datos
            System.out.println("Datos leídos: " + propietarios);//debug
        } catch (IOException e) {
            System.err.println("Error al leer el archivo JSON: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error inesperado: " + e.getMessage());
        }
        return propietarios;
    }
        
    // Método para cargar personas al archivo JSON
    private List<Persona> cargarPersonas() {
        List<Persona> personas = new ArrayList<>();
        try (FileReader reader = new FileReader("propietarios.json")){
            // Verificar si el archivo existe y cargar los datos
            Gson gson = new Gson();
            Type personaListType = new TypeToken<ArrayList<Persona>>() {}.getType();
            
            personas = gson.fromJson(reader, personaListType);
            
            reader.close();
        } catch (IOException e) {
            // Si el archivo no existe, creamos una nueva lista
            System.out.println("No se encontró el archivo. Se creará uno nuevo.");
        }
        return personas;
    }
        
    // Método para guardar la lista de personas en el archivo JSON
    public void guardarJson(String nombre, String tipoDocumento, String documento, String edad, String correo, String telefono, String propiedad, String ocupacion) {
      


        // Cargar las personas existentes
        List<Persona> personas = cargarPersonas();

        // Crear el nuevo objeto Persona
        Persona nuevaPersona = new Persona(nombre, tipoDocumento, documento, edad, correo, telefono, propiedad, ocupacion);
        
        // Agregar la nueva persona a la lista
        personas.add(nuevaPersona);

        // Convertir la lista de personas a JSON
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(personas);

        // Guardar el JSON en un archivo
        try (FileWriter file = new FileWriter("propietarios.json")) {
            file.write(json);
            file.flush();
        } catch (IOException e) {
            
            e.printStackTrace();
            
            // Mostrar mensaje de error con JOptionPane
            JOptionPane.showMessageDialog(null, 
                "Error al registrar el propietario: " + e.getMessage(), 
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public List<String> mostrarOcupacionesAdyacentes(String propiedadIngresada) {
    List<Persona> personas = cargarPersonas();
    List<String> ocupacionesAdyacentes = new ArrayList<>();

    try {
        // Convertir la propiedad ingresada a entero para comparar
        int propiedad = Integer.parseInt(propiedadIngresada);

        // Inicializar las ocupaciones
        String ocupacionAnterior = "No encontrada";
        String ocupacionActual = "No encontrada";
        String ocupacionSiguiente = "No encontrada";

        // Recorrer la lista y buscar las ocupaciones adyacentes
        for (Persona p : personas) {
            int codigoPropiedad = Integer.parseInt(p.getPropiedad());

            if (codigoPropiedad == propiedad - 1) {
                ocupacionAnterior = p.getOcupacion();
            } else if (codigoPropiedad == propiedad) {
                ocupacionActual = p.getOcupacion();
            } else if (codigoPropiedad == propiedad + 1) {
                ocupacionSiguiente = p.getOcupacion();
            }
        }

        // Agregar las ocupaciones a la lista para retornar
        ocupacionesAdyacentes.add(ocupacionAnterior);
        ocupacionesAdyacentes.add(ocupacionActual);
        ocupacionesAdyacentes.add(ocupacionSiguiente);
    } catch (NumberFormatException e) {
        System.err.println("Error: la propiedad ingresada no es un número válido.");
    }

    return ocupacionesAdyacentes;
    }
    
}
