/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;


import Model.Multa;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author USUARIO
 */
public class ManejoPDFMulta {
    
    private final String rutaCarpeta2 = "C:\\Users\\USUARIO\\Escritorio\\Amanecer\\Amanecer\\";
    private final String archivoJSON2 = rutaCarpeta2 + "Multa.json";
    private final Gson gson2 = new GsonBuilder().setPrettyPrinting().create();
    
    // Método para guardar una nueva multa en JSON
    public void guardarMulta(String codigoMulta, String persona, String fechaMulta, String propiedad, String fechaEventoMulta,
                               String evento, String valorMulta, String fechaMaxPago) {
                              
        List<Multa> multas = cargarMultas();

        // Crear una nueva factura y añadirla a la lista
        Multa nuevaMulta = new Multa(codigoMulta, persona, fechaMulta, propiedad, fechaEventoMulta,
                               evento, valorMulta, fechaMaxPago);
        multas.add(nuevaMulta);

        // Guardar la lista actualizada en el archivo JSON
        try (Writer writer = new FileWriter(archivoJSON2)) {
            gson2.toJson(multas, writer);
            System.out.println("Factura guardada exitosamente.");
        } catch (IOException e) {
            System.err.println("Error al guardar la factura: " + e.getMessage());
        }
    }

    // Método para cargar todas las multas desde el archivo JSON
    private List<Multa> cargarMultas() {
        try (Reader reader = new FileReader(archivoJSON2)) {
            Type listType = new TypeToken<ArrayList<Multa>>() {}.getType();
            return gson2.fromJson(reader, listType);
        } catch (IOException e) {
            System.err.println("Error al cargar las facturas: " + e.getMessage());
            return new ArrayList<>(); //    q Retorna una lista vacía si no se encuentra el archivo
        }
    }

    // Método para buscar una multa por su número
    public Multa buscarMulta(String codigoMulta) {
        List<Multa> multas = cargarMultas();
        for (Multa multa : multas) {
            if (multa.getCodigoMulta().equals(codigoMulta)) {
                return multa;
            }
        }
        System.out.println("Multa no encontrada.");
        return null;
    }
    
    // Método para generar un PDF con los datos de una multa
    public void generarPDFMulta(Multa multa) {
        
        if (multa == null) {
            System.out.println("No se pudo generar el PDF. La multa es nula.");
            return;
        }

        String rutaArchivo = rutaCarpeta2 + "Multa_" + multa.getCodigoMulta() + ".pdf";
        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream(rutaArchivo));
            document.open();

            // Agregar contenido al PDF
            document.add(new Paragraph("Codigo Multa: " + multa.getCodigoMulta()));
            document.add(new Paragraph("Persoan: " + multa.getPersona()));
            document.add(new Paragraph("Fecha Multa: " + multa.getFechaMulta()));
            document.add(new Paragraph("Propiedad: " + multa.getPropiedad()));
            document.add(new Paragraph("Fecha Evento Multa: " + multa.getFechaEventoMulta()));
            document.add(new Paragraph("Evento: " + multa.getEvento()));
            document.add(new Paragraph("Valor Multa: " + multa.getValorMulta()));
            document.add(new Paragraph("Fecha Maxima de Pago: " + multa.getFechaMaxPago()));
            
            // Mostrar notificación de éxito
            JOptionPane.showMessageDialog(null, 
                "PDF creado exitosamente en:\n" + rutaArchivo, 
                "PDF Generado", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (DocumentException | IOException e) {
            
            JOptionPane.showMessageDialog(null, 
                "Error al generar el PDF: " + e.getMessage(), 
                "Error", JOptionPane.ERROR_MESSAGE);
            
        } finally {
            if (document.isOpen()) {
                document.close();
            }
        }
    }
    
    // Método para buscar multas por el nombre de la persona
    public List<Multa> buscarMultasPorPersona(String persona) {
        List<Multa> multas = cargarMultas(); // Cargar todas las multas
        List<Multa> multasEncontradas = new ArrayList<>();

        for (Multa multa : multas) {
            if (multa.getPersona() != null && multa.getPersona().equalsIgnoreCase(persona)) {
                multasEncontradas.add(multa); // Añadir las multas encontradas a la lista
            }
        }

        return multasEncontradas; // Retornar todas las multas de la persona
    }
    
}
