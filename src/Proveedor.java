import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Michel Gil
 */
public class Proveedor {
    public static void ingresarProveedor() throws SQLException {
        String sqlProv = "INSERT INTO proveedor VALUES(?, ?, ?, ?)";
        PreparedStatement senProv = Principal.getConnection().prepareStatement(sqlProv);
        System.out.print("ID: ");
        int id = Principal.sc.nextInt();
        senProv.setInt(1, id);
        Principal.sc.nextLine();

        System.out.print("Nombre: ");
        String nombre = Principal.sc.nextLine();
        senProv.setString(2, nombre);
        
        System.out.print("Direccion: ");
        String direccion = Principal.sc.nextLine();
        senProv.setString(3, direccion);
        
        System.out.print("Telefono: ");
        String telefono = Principal.sc.nextLine();
        senProv.setString(4, telefono);

        int filasIns = senProv.executeUpdate();
        if (filasIns > 0) {
            System.out.println("!Insercion Exitosa! ");
            System.out.println("........................");
        }
    }
}
