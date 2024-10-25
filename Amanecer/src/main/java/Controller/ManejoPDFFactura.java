/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.Factura;
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
public class ManejoPDFFactura {
    
    private final String rutaCarpeta = "C:\\Users\\USUARIO\\Escritorio\\NetBeansProjects\\Amanecer\\";
    private final String archivoJSON = rutaCarpeta + "Factura.json";
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    
    // Método para guardar una nueva factura en JSON
    public void guardarFactura(String propietario, String numeroDocumento, String numeroFactura, String fechaFactura,
                               String propiedad, String valorMetroCuadrado, String valorAdministracion, String fechaMaxPago, String totalPagar) {
                              
        List<Factura> facturas = cargarFacturas();

        // Crear una nueva factura y añadirla a la lista
        Factura nuevaFactura = new Factura(propietario, numeroDocumento, numeroFactura, 
            fechaFactura, propiedad, valorMetroCuadrado, valorAdministracion, fechaMaxPago, totalPagar);
        
        facturas.add(nuevaFactura);

        // Guardar la lista actualizada en el archivo JSON
        try (Writer writer = new FileWriter(archivoJSON)) {
            gson.toJson(facturas, writer);
            
            System.out.println("Factura guardada exitosamente.");
        } catch (IOException e) {
            System.err.println("Error al guardar la factura: " + e.getMessage());
        }
    }

    // Método para cargar todas las facturas desde el archivo JSON
    private List<Factura> cargarFacturas() {
        try (Reader reader = new FileReader(archivoJSON)) {
            Type listType = new TypeToken<ArrayList<Factura>>() {}.getType();
            return gson.fromJson(reader, listType);
        } catch (IOException e) {
            System.err.println("Error al cargar las facturas: " + e.getMessage());
            return new ArrayList<>(); //    q Retorna una lista vacía si no se encuentra el archivo
        }
    }

    // Método para buscar una factura por su número
    public Factura buscarFactura(String numeroFactura) {
        List<Factura> facturas = cargarFacturas();
        for (Factura factura : facturas) {
            if (factura.getNumeroFactura().equals(numeroFactura)) {
                return factura;
            }
        }
        System.out.println("Factura no encontrada.");
        return null;
    }

    // Método para generar un PDF con los datos de una factura
    public void generarPDFFactura(Factura factura) {
        
        if (factura == null) {
            System.out.println("No se pudo generar el PDF. La factura es nula.");
            return;
        }

        String rutaArchivo = rutaCarpeta + "Factura_" + factura.getNumeroFactura() + ".pdf";
        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream(rutaArchivo));
            document.open();

            // Agregar contenido al PDF
            document.add(new Paragraph("Propietario: " + factura.getPropietario()));
            document.add(new Paragraph("Numero Documento: " + factura.getNumeroDocumento()));
            document.add(new Paragraph("Factura Número: " + factura.getNumeroFactura()));
            document.add(new Paragraph("Fecha Factura: " + factura.getFechaFactura()));
            document.add(new Paragraph("Propiedad: " + factura.getPropiedad()));
            document.add(new Paragraph("Valor Metro Cuadrado: " + factura.getValorMetroCuadrado()));
            document.add(new Paragraph("Valor Administracion: " + factura.getValorAdministracion()));
            document.add(new Paragraph("Fecha Maxima de Pago: " + factura.getFechaMaxPago()));
            document.add(new Paragraph("Total a Pagar: $" + factura.getTotalPagar()));
            
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
    
    // Método para encontrar el valor de administración por número de propiedad
    public String buscarValorAdministracionPorPropiedad(String numeroPropiedad) {
        List<Factura> facturas = cargarFacturas(); // Cargar todas las facturas

        for (Factura factura : facturas) {
            // Verificar si la propiedad no es nula y coincide con el número ingresado
            if (factura.getPropiedad() != null && factura.getPropiedad().equals(numeroPropiedad)) {
                return factura.getValorAdministracion(); // Retorna el valor si se encuentra
            }
        }
        return null; // Si no encuentra la propiedad, retorna null
    }
    
    // Método para buscar una factura por el número de propiedad
    public Factura buscarFacturaPorPropiedad(String numeroPropiedad) {
        List<Factura> facturas = cargarFacturas(); // Cargar todas las facturas

        for (Factura factura : facturas) {
            // Verificar si la propiedad no es nula y coincide con el número ingresado
            if (factura.getPropiedad() != null && factura.getPropiedad().equals(numeroPropiedad)) {
                return factura; // Retorna la factura encontrada
            }
        }
        return null; // Retorna null si no encuentra la propiedad
    }
    
    // Método para buscar facturas por número de propiedad
    public List<Factura> buscarFacturasPorPropiedad(String numeroPropiedad) {
        List<Factura> facturas = cargarFacturas(); // Cargar todas las facturas
        List<Factura> facturasEncontradas = new ArrayList<>();

        for (Factura factura : facturas) {
            if (factura.getPropiedad() != null && 
                factura.getPropiedad().equalsIgnoreCase(numeroPropiedad)) {
                facturasEncontradas.add(factura); // Añadir las facturas encontradas a la lista
            }
        }

        return facturasEncontradas; // Retornar todas las facturas de la propiedad
    }
}
