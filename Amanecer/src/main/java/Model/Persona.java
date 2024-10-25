/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author USUARIO
 */
public class Persona {
    
    private String nombre;
    private String tipoDocumento;
    private String numeroDocumento;
    private String edad;
    private String email;
    private String telefono;
    private String propiedad;
    private String ocupacion;
   

    public Persona() {
    }

    public Persona(String nombre, String tipoDocumento, String numeroDocumento, String edad, String email, String telefono, String propiedad, String ocupacion) {
        this.nombre = nombre;
        this.edad = edad;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.email = email;
        this.telefono = telefono;
        this.propiedad = propiedad;
        this.ocupacion= ocupacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public String getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(String propiedad) {
        this.propiedad = propiedad;
    }
    
    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", edad=" + edad + ", tipoDocumento=" + tipoDocumento + ", numeroDocumento=" + numeroDocumento + 
                ", email=" + email + ", telefono=" + telefono + ", propiedad=" + propiedad + ",ocuupacion=" + ocupacion + '}';
    }

}
