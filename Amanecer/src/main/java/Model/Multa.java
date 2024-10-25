/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author USUARIO
 */
public class Multa {
    
    private String codigoMulta;
    private String persona;
    private String fechaMulta;
    private String propiedad;
    private String fechaEventoMulta;
    private String evento;
    private String valorMulta;
    private String fechaMaxPago;

    public Multa() {
    }

    public Multa(String codigoMulta, String persona, String fechaMulta, String propiedad, String fechaEventoMulta, 
                 String evento, String valorMulta, String fechaMaxPago) {
        
        this.codigoMulta = codigoMulta;
        this.persona = persona;
        this.fechaMulta = fechaMulta;
        this.propiedad = propiedad;
        this.fechaEventoMulta = fechaEventoMulta;
        this.evento = evento;
        this.valorMulta = valorMulta;
        this.fechaMaxPago = fechaMaxPago;
    }

    public String getCodigoMulta() {
        return codigoMulta;
    }

    public void setCodigoMulta(String codigoMulta) {
        this.codigoMulta = codigoMulta;
    }

    public String getPersona() {
        return persona;
    }

    public void setPersona(String persona) {
        this.persona = persona;
    }

    public String getFechaMulta() {
        return fechaMulta;
    }

    public void setFechaMulta(String fechaMulta) {
        this.fechaMulta = fechaMulta;
    }

    public String getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(String propiedad) {
        this.propiedad = propiedad;
    }
    
    public String getFechaEventoMulta() {
        return fechaEventoMulta;
    }

    public void setFechaEventoMulta(String fechaEventoMulta) {
        this.fechaEventoMulta = fechaEventoMulta;
    }
    
    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }
    
    public String getValorMulta() {
        return valorMulta;
    }

    public void setValorMulta(String valorMulta) {
        this.valorMulta = valorMulta;
    }
    
    public String getFechaMaxPago() {
        return fechaMaxPago;
    }

    public void setFechaMaxPago(String fechaMaxPago) {
        this.fechaMaxPago = fechaMaxPago;
    }

    @Override
    public String toString() {
        return "Multa{" + "codigoMulta=" + codigoMulta + ", persona=" + persona + ", fechaMulta=" + fechaMulta + ", propiedad=" + propiedad + 
                ", fechaEventoMulta=" + fechaEventoMulta + ", evento=" + evento + ", valorMulta=" + valorMulta +  ", fechaMaxPago=" + fechaMaxPago +'}';
    }

}

