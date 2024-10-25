/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import View.Administrador;
import View.Empleado;
import View.FuturoComprador;
import View.Propietario;
import javax.swing.JOptionPane;
/**
 *
 * @author USUARIO
 */
public class ManejoIngreso {
    public static String validarUsuario(String usuario, String contraseña) {
        // Datos quemados: usuario y contraseña con roles asociados
        if (usuario.equals("administrador") && contraseña.equals("administrador123")) {
            return "Administrador";
        } else if (usuario.equals("propietario") && contraseña.equals("propietario123")) {
            return "Propietario";
        }else if (usuario.equals("empleado") && contraseña.equals("empleado123")) {
            return "Empleado";
        } else if (usuario.equals("comprador") && contraseña.equals("comprador123")) {
            return "FuturoComprador";
        } else {
            return null; // Usuario no válido
        }
    }
    
    public void iniciarSesion(String usuario, String contraseña) {
        String rol = validarUsuario(usuario, contraseña);

        if (rol != null) {
            abrirVentanaPorRol(rol);
        } else {
            JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void abrirVentanaPorRol(String rol) {
        switch (rol) {
            case "Administrador":
                new Administrador().setVisible(true);
                break;
            case "Propietario":
                new Propietario().setVisible(true);
                break;
            case "FuturoComprador":
                new FuturoComprador().setVisible(true);
                break;
            case "Empleado":
                new Empleado().setVisible(true);
                break;
        }
    }
}
