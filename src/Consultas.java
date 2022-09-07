import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Michel Gil
 */
public class Consultas {
    public static void crearTablas(){
        try{
            String [] sqls = {
                "CREATE TABLE proveedor (prov_id INT PRIMARY KEY, prov_nombre CHAR(20), prov_direccion CHAR(45), prov_telefono CHAR (20))",
                "CREATE TABLE clientes (alias CHAR(20) PRIMARY KEY, nombre CHAR(20), apellidos CHAR(20), email VARCHAR(45), celular CHAR(20), contraseña INT, f_nacimiento DATE)",
                "CREATE TABLE fabricantes (fabricante CHAR(20) PRIMARY KEY)",
                "CREATE TABLE bicicletas (id INT PRIMARY KEY, fabricante CHAR(20), precio INT, año INT, FOREIGN KEY (fabricante) REFERENCES fabricantes (fabricante))",
                "CREATE TABLE motocicletas (id INT PRIMARY KEY, fabricante CHAR(20), precio INT, autonomia INT, id_prov INT, FOREIGN KEY (fabricante) REFERENCES fabricantes (fabricante), FOREIGN KEY (id_prov) REFERENCES proveedor (prov_id))",
                "CREATE TABLE compras (id INT PRIMARY KEY, alias CHAR(20), fabricante CHAR(20), fecha_hora TIMESTAMP, FOREIGN KEY (alias) REFERENCES clientes (alias), FOREIGN KEY (fabricante) REFERENCES fabricantes (fabricante))"
            };
            for (String i:sqls){
                PreparedStatement sentencia = Principal.getConnection().prepareStatement(i);
                sentencia.executeUpdate();
            }
        }
        catch(Exception e){
            System.out.println("Las tablas ya han sido creadas");
        }
    }
    
    public static void modificaYear() throws SQLException {
        String sql = "UPDATE bicicletas SET año=? WHERE fabricante=? ";
        PreparedStatement sentencia = Principal.getConnection().prepareStatement(sql);
        System.out.println("Ingrese el fabricante de la bicicleta y año a modificar");
        System.out.print("Fabricante: ");
        String nombre = Principal.sc.nextLine();
        sentencia.setString(2, nombre);
        
        System.out.print("Año: ");
        int year = Principal.sc.nextInt();
        sentencia.setInt(1, year);
        Principal.sc.nextLine();
        
        int filasIns = sentencia.executeUpdate();
        if (filasIns > 0){
            System.out.println("Se modificó el año correctamente. ");
        }
    }
    
    public static void modificaTelCliente() throws SQLException {
        String sql = "UPDATE clientes SET celular=? WHERE alias=? ";
        PreparedStatement sentencia = Principal.getConnection().prepareStatement(sql);
        System.out.println("Ingrese el alias del cliente y nuevo numero de celular");
        System.out.print("Alias: ");
        String alias = Principal.sc.nextLine();
        sentencia.setString(2, alias);
        
        System.out.print("Celular: ");
        String cel = Principal.sc.nextLine();
        sentencia.setString(1, cel);
        
        int filasIns = sentencia.executeUpdate();
        if (filasIns > 0){
            System.out.println("Se actualizo el numero correctamente ");
        }
    }
    
    public static void borraCompra() throws SQLException {
        String sql = "DELETE FROM compras WHERE alias=? AND fabricante=? ";
        PreparedStatement sentencia = Principal.getConnection().prepareStatement(sql);
        System.out.println("Ingrese alias del cliente y fabricante ");
        System.out.print("Alias: ");
        String alias = Principal.sc.nextLine();
        sentencia.setString(1, alias);
        
        System.out.print("Fabricante: ");
        String fab = Principal.sc.nextLine();
        sentencia.setString(2, fab);
        
        int filasIns = sentencia.executeUpdate();
        if (filasIns > 0){
            System.out.println("Intencion de compra ha sido Eliminada. ");
        }
    }
    
    public static void consultaFabricantes() throws SQLException {
        String sql = "SELECT fabricante FROM fabricantes ORDER BY fabricante";
        Statement sentencia = Principal.getConnection().createStatement();
        ResultSet consulta = sentencia.executeQuery(sql);
        
        while (consulta.next()){
            String col1 = consulta.getNString(1);
            System.out.println(col1);
        }
    }
    
    public static void consultaInfoBici() throws SQLException {
        String sql = "SELECT fabricante,precio,año FROM bicicletas WHERE año >=2019 ORDER BY fabricante";
        Statement sentencia = Principal.getConnection().createStatement();
        ResultSet consulta = sentencia.executeQuery(sql);
        
        while (consulta.next()){
            String col1 = consulta.getNString(1);
            int col2 = consulta.getInt(2);
            String col3 = consulta.getString(3);
            System.out.println(col1 + " " + col2 + " " + col3);
        }
    }
        
    public static void consultaFabriMoto() throws SQLException {
        String sql = "SELECT fabricante FROM motocicletas WHERE id_prov=101";
        Statement sentencia = Principal.getConnection().createStatement();
        ResultSet consulta = sentencia.executeQuery(sql);
        
        while (consulta.next()){
            String col1 = consulta.getNString(1);
            System.out.println(col1);
        }
    }
    
    public static void consultaCompBiMo() throws SQLException {
        String sql = "SELECT fabricante FROM compras WHERE alias=\"lucky\" ORDER BY fabricante";
        Statement sentencia = Principal.getConnection().createStatement();
        ResultSet consulta = sentencia.executeQuery(sql);
        
        while (consulta.next()){
            String col1 = consulta.getNString(1);
            System.out.println(col1);
        }
    }
    
    public static void consultaCompBiCli() throws SQLException {
        String sql = "SELECT c.alias, c.nombre, c.apellidos FROM clientes c, compras p WHERE p.alias=c.alias AND p.fabricante=\"Yeti\" ORDER BY nombre";
        Statement sentencia = Principal.getConnection().createStatement();
        ResultSet consulta = sentencia.executeQuery(sql);
        
        while (consulta.next()){
            String col1 = consulta.getNString(1);
            String col2 = consulta.getNString(2);
            String col3 = consulta.getNString(3);
            System.out.println(col1 + " " + col2 + " " + col3);
        }
    }
    
    public static void consultaBiciFab() throws SQLException {
        System.out.println("Ingrese el numero de año");
        System.out.print("Año: ");
        int year = Principal.sc.nextInt();
        Principal.sc.nextLine();
        
        String sql = "SELECT count(fabricante) FROM bicicletas WHERE año>=" + year;
        Statement sentencia = Principal.getConnection().createStatement();
        ResultSet consulta = sentencia.executeQuery(sql);
        
        while (consulta.next()){
            int col1 = consulta.getInt(1);
            System.out.println(col1);
        }
    }
}
