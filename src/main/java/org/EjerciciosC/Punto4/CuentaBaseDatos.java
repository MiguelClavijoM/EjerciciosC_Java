package org.EjerciciosC.Punto4;

import java.sql.*;

public class CuentaBaseDatos {
  private String cadenaConexion;
  private static Connection conexion = null;
  public CuentaBaseDatos() {
    try {
      DriverManager.registerDriver(new org.sqlite.JDBC());
      cadenaConexion = "jdbc:sqlite:pruebas.db";
      crearTabla();
      System.out.println("FUNCIONA");
    } catch (SQLException e) {
      System.err.println("Error de conexión con la base de datos: " + e);
    }

  }

  private Connection connect() {
    Connection conn = null;
    try {
      conn = DriverManager.getConnection(cadenaConexion);
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return conn;
  }


  private void crearTabla() {
    String sql = "CREATE TABLE IF NOT EXISTS CuentaBaseDeDatos (\n"
      + " id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
      + " numero_cuenta TEXT NOT NULL,\n"
      + " tipo_cuenta TEXT NOT NULL,\n"
      + " saldo FLOAT NOT NULL DEFAULT 0.0 ,\n"
      + " retiros INTEGER NOT NULL DEFAULT 0,\n"
      + " depositos INTEGER NOT NULL DEFAULT 0\n"
      + ");";
    try (Connection conn = this.connect();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
          pstmt.executeUpdate();
    } catch (SQLException e) {
      System.out.println("Error de conexión: " + e.getMessage());
    }
  }

  void createAccount(String numeroCuenta, String tipo) {
    String sql = "INSERT INTO cuentabasededatos (numero_cuenta, tipo_cuenta) VALUES ('"+numeroCuenta+"','"+tipo+"');";
    try (Connection conn = this.connect();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
      if(tipo != "ahorros" && tipo != "corriente"){
        throw new Exception("El tipo de cuenta es invalido");
      }
      pstmt.executeUpdate();
      pstmt.close();
    } catch (SQLException e) {
      System.err.println("Error de conexión: " + e);
    } catch (Exception e) {
      System.err.println("Error " + e.getMessage());
    }
  }
}
