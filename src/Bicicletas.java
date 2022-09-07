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
public class Bicicletas {
    public static void ingresarBicicletas() throws SQLException{
        String sqlBici = "INSERT INTO bicicletas VALUES (?, ?, ?, ?)";
        PreparedStatement senBici = Principal.getConnection().prepareStatement(sqlBici);
        System.out.print("ID: ");
        int id = Principal.sc.nextInt();
        senBici.setInt(1, id);
        Principal.sc.nextLine();
        
        System.out.print("Fabricante: ");
        String nombre = Principal.sc.nextLine();
        senBici.setString(2, nombre);
        
        System.out.print("Precio: ");
        int precio = Principal.sc.nextInt();
        senBici.setInt(3, precio);
        Principal.sc.nextLine();
        
        System.out.print("Año: ");
        int year = Principal.sc.nextInt();
        senBici.setInt(4, year);
        Principal.sc.nextLine();
        
        int filasIns = senBici.executeUpdate();
        if (filasIns > 0){
            System.out.println("!Insercion Exitosa! ");
            System.out.println("........................");
        }
    }
}
