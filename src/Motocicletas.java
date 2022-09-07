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
public class Motocicletas {
    public static void ingresarMotocicletas() throws SQLException{
        String sql = "INSERT INTO motocicletas values(?,?,?,?,?)";
        PreparedStatement sentencia = Principal.getConnection().prepareStatement(sql);
        System.out.print("ID: ");
        int id = Principal.sc.nextInt();
        sentencia.setInt(1, id);
        Principal.sc.nextLine();

        System.out.print("Fabricante: ");
        String fabricante = Principal.sc.nextLine();
        sentencia.setString(2, fabricante);

        System.out.print("Precio: ");
        int precio = Principal.sc.nextInt();
        sentencia.setInt(3, precio);
        Principal.sc.nextLine();

        System.out.print("Autonomia: ");
        int autonomia = Principal.sc.nextInt();
        sentencia.setInt(4, autonomia);
        Principal.sc.nextLine();

        System.out.print("Id Proveedor: ");
        int idProv = Principal.sc.nextInt();
        sentencia.setInt(5, idProv);
        Principal.sc.nextLine();

        int filasIns = sentencia.executeUpdate();
        if (filasIns > 0) {
            System.out.println("!Insercion Exitosa! ");
            System.out.println("........................");
        }
    }
}
