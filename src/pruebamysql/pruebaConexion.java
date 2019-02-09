/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebamysql;

/**
 *
 * @author mauri
 */

import java.sql.*;

public class pruebaConexion {
   
    protected Connection conexion;
    protected Statement consulta;
    protected ResultSet resultado;
    
    protected String user;
    protected String pass;
    
    
    public pruebaConexion() {
        user = "root";
        pass = "1234";
    }
    
    public void Ejecutar() {
        
        // ****************************************************
        // PASOS PARA CONECTAR A MYSQL:
        // ****************************************************
        //
        // 1) AGREGAR AL PROYECTO LA REFERENCIA AL CONECTOR JAVA
        //
        //      - En Biblioteas (o Libraries) del proyecto, opcion Agregar Biblioteca, y seleccionar "MySQL JDBC Driver"
        //
        //      - SOLO si luego de hacer las pruebas da error java.lang.ClassCastException... hacer lo siguiente
        //
        //      - Borrar la referencia "MySQL JDBC Driver" en Bibliotecas
        //
        //      - En Bibliotecas usar la opcion "Agregar JAR":  
        //          Navegar en las carpetas y buscar el archivo JAR del conector que instalo el servidor mysql
        //          Por lo general dentro de la carpeta c:\Program Files (x86)\MySQL\Connector J 8.0\
        //
        // 2) Crear objeto Connection
        //
        // 3) Crear objeto Statement
        //
        // 4) Crear objeto ResultSet
        //
        // 5) Recorrer el ResultSet
        //
        // ****************************************************
        // ****************************************************
        
        try {
            
            //----------------------------------------------------------------------
            // VERIFICAR DRIVER MYSQL (CONECTOR VERSION 5.x)
            
//            try {
//                Class.forName("com.mysql.jdbc.Driver");
//            } 
//            catch (ClassNotFoundException ex) {
//                System.out.println("Error Driver MySQL. " + ex.getMessage());
//            }

            //----------------------------------------------------------------------
            // VERIFICAR DRIVER MYSQL (CONECTOR VERSION 8.x)
//            
//            try {
//                Class.forName("com.mysql.cj.jdbc.Driver");
//            } 
//            catch (ClassNotFoundException ex) {
//                System.out.println("Error Driver MySQL. " + ex.getMessage());
//            }

            //----------------------------------------------------------------------            
            // CADENA DE CONEXION STANDARD
            
            //cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/magazine", user, pass);
            
            //----------------------------------------------------------------------
            // SI DA ERROR DE TIME ZONE, USAR ESTA CADENA DE CONEXION
            
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas?serverTimezone=America/Argentina/Buenos_Aires", user, pass);
            
            consulta = conexion.createStatement();
            
            resultado = consulta.executeQuery("SELECT MAX(precio) FROM productos");

            while (resultado.next()) {
            
                System.out.println(
                        resultado.getString(1)
//                        resultado.getString("CÓDIGOARTÍCULO") + "\t" +
//                        resultado.getString("NOMBREARTÍCULO") + "\t" +
//                        resultado.getString("PRECIO") + "\t" +
//                        resultado.getString("PAÍSDEORIGEN")      
                        );
             }
        }
        catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }

    }

}
