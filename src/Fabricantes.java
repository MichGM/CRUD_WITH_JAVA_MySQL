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
public class Fabricantes {
    public static void ingresarFabricantes() throws SQLException {
        String sqlFab = "INSERT INTO fabricantes VALUES(?)";
        PreparedStatement senFab = Principal.getConnection().prepareStatement(sqlFab);

        System.out.print("Nombre Fabricante: ");
        String nombre = Principal.sc.nextLine();
        senFab.setString(1, nombre);

        int filasIns = senFab.executeUpdate();
        if (filasIns > 0) {
            System.out.println("!Insercion Exitosa! ");
            System.out.println("........................");
        }
    }
}
