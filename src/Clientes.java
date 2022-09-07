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
public class Clientes {
	
    public static void ingresarClientes() throws SQLException {
        String sql = "INSERT INTO clientes VALUES(?,?,?,?,?,?,?)";
        PreparedStatement sentencia = Principal.getConnection().prepareStatement(sql);
        System.out.print("Alias: ");
        String alias = Principal.sc.nextLine();
        sentencia.setString(1, alias);

        System.out.print("Nombre: ");
        String nombre = Principal.sc.nextLine();
        sentencia.setString(2, nombre);

        System.out.print("Apellidos: ");
        String apellidos = Principal.sc.nextLine();
        sentencia.setString(3, apellidos);

        System.out.print("Email: ");
        String email = Principal.sc.nextLine();
        sentencia.setString(4, email);

        System.out.print("Celular: ");
        String celular = Principal.sc.nextLine();
        sentencia.setString(5, celular);

        System.out.print("Contraseña: ");
        int contrasena = Principal.sc.nextInt();
        sentencia.setInt(6, contrasena);
        Principal.sc.nextLine();
        
        System.out.print("F.Nacimiento: ");
        String nacimiento = Principal.sc.nextLine();
        sentencia.setString(7, nacimiento);

        int filasIns = sentencia.executeUpdate();
        if (filasIns > 0) {
            System.out.println("!Insercion Exitosa! ");
            System.out.println("........................");
        }
    }

}
