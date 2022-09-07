import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Michel Gil
 */
public class Principal {
    
    public static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        menu();
        
    }
    
    public static void menu(){
        try{
            System.out.println(
                    "******************\n"+
                    "*** CRUD MySQL ***\n"+
                    "******************\n"+
                    "************************* Crear Tablas *************************\n"+
                    "1. Crear tablas.\n"+
                    "************************ Ingresar Datos ************************\n"+
                    "2. Ingresar datos a tabla proveedor.\n"+
                    "3. Ingresar datos a tabla clientes.\n"+
                    "4. Ingresar datos a tabla fabricantes.\n"+
                    "5. Ingresar datos a tabla bicicletas.\n"+
                    "6. Ingresar datos a tabla motocicletas.\n"+
                    "7. Ingresar datos a tabla compras.\n"+
                    "********************** Modificar & Borrar **********************\n"+
                    "8.  Modificar año bicicleta.\n"+
                    "9.  Modificar telefono de clientes.\n"+
                    "10. Borrar intencion de compra.\n"+
                    "*************************** Consultas **************************\n"+
                    "11. Listado de fabricantes\n"+
                    "12. Mostrar informacion de fabricantes de bicicleta estrenadas desde 2019.\n"+
                    "13. Mostrar fabricantes de motocicletas con motor Auteco\n"+
                    "14. Mostrar fabricante con intencion de compra del cliente luky\n"+
                    "15. Mostrar clientes que quieren comrar bicicletas\n"+
                    "16. Cantidad de bicicletas fabricadas desde |x| año.\n"+
                    "****************************************************************\n"+
                    "* Digite otro numero/tecla para salir *\n"+
                    "****************************************************************\n");
            System.out.print(">> ");
            
            String input = sc.nextLine();
            byte opcion = Byte.parseByte(input);
            
            switch (opcion){
                case 1:
                    Consultas.crearTablas();
                    break;
                case 2:
                    Proveedor.ingresarProveedor();
                    break;
                case 3:
                    Clientes.ingresarClientes();
                    break;
                case 4:
                    Fabricantes.ingresarFabricantes();
                    break;
                case 5:
                    Bicicletas.ingresarBicicletas();
                    break;
                case 6:
                    Motocicletas.ingresarMotocicletas();
                    break;
                case 7:
                    Compras.ingresarCompras();
                    break;
                case 8:
                    Consultas.modificaYear();
                    break;
                case 9:
                    Consultas.modificaTelCliente();
                    break;
                case 10:
                    Consultas.borraCompra();
                    break;
                case 11:
                    Consultas.consultaFabricantes();
                    break;
                case 12:
                    Consultas.consultaInfoBici();
                    break;
                case 13:
                    Consultas.consultaFabriMoto();
                    break;
                case 14:
                    Consultas.consultaCompBiMo();
                    break;
                case 15:
                    Consultas.consultaCompBiCli();
                    break;
                case 16:
                    Consultas.consultaBiciFab();
                    break;
                default:
                    System.out.println("Digite una de las opciones.");
            }
        }
        catch(Exception e){
            System.out.println("Hasta luego y muchas gracias.");
        }
    }
    
    public static Connection getConnection(){
        Connection conn = null;
        JSONParser parser = new JSONParser();
        
        try{
            String credentialsPath = System.getProperty("user.dir") + "/src/config.json";
            JSONObject credentials = (JSONObject)parser.parse(new FileReader(credentialsPath));
            
            String hots     = (String)credentials.get("db_ip");
            String port     = (String)credentials.get("db_port");
            String username = (String)credentials.get("db_user");
            String password = (String)credentials.get("db_pass");
            
            String urlDB = "jdbc:mysql://" + hots + ":" + port + "/reto5";
            conn = DriverManager.getConnection(urlDB, username, password);
            if(conn != null){
                System.out.println("Conexion realizada");
            }
        }
        catch(IOException | SQLException | ParseException e){
            e.printStackTrace();
        }
        return conn;
    }
    /*
    public static void main(String[] args) {
        Principal.getConnection();
    }*/
}
