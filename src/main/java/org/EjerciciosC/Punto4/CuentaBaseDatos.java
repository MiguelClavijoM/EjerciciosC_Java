package org.EjerciciosC.Punto4;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
      + " propietario TEXT NOT NULL,\n"
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

  void crearCuenta(String numeroCuenta, String tipo, String propietario) {
    String sql = "INSERT INTO cuentabasededatos (numero_cuenta, tipo_cuenta, propietario) VALUES ('"+numeroCuenta+"','"+tipo+"','"+propietario+"');";
    try (Connection conn = this.connect();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
      if(tipo != "ahorros" && tipo != "corriente"){
        throw new Exception("El tipo de cuenta es invalido");
      }
      pstmt.executeUpdate();
    } catch (SQLException e) {
      System.err.println("Error de conexión: " + e);
    } catch (Exception e) {
      System.err.println("Error " + e.getMessage());
    }
  }

  public void guardar(Object objeto) {
    try (Connection conexion = DriverManager.getConnection(cadenaConexion)) {
      Cuenta cuenta = (Cuenta) objeto;
      String sentenciaSql = "INSERT INTO personas (propietario, numero_cuenta, saldo) " +
        " VALUES('" + cuenta.getPropietario() + "', '" + cuenta.getNumeroCuenta()
        + "', '" + cuenta.getSaldo() + "');";
      Statement sentencia = conexion.createStatement();
      sentencia.execute(sentenciaSql);
    } catch (SQLException e) {
      System.err.println("Error de conexión: " + e);
    } catch (Exception e) {
      System.err.println("Error " + e.getMessage());
    }

  }

  public void eliminar(String num_cuenta) {
    try (Connection conexion = DriverManager.getConnection(cadenaConexion)) {
      String sentenciaSql = "DELETE FROM personas WHERE numero_cuenta = '" + num_cuenta + "';";
      Statement sentencia = conexion.createStatement();
      sentencia.execute(sentenciaSql);
    } catch (SQLException e) {
      System.err.println("Error de conexión: " + e);
    } catch (Exception e) {
      System.err.println("Error " + e.getMessage());
    }
  }

  public void actualizar(Object objeto) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'actualizar'");
  }

  public Object buscar(String num_cuenta) {
    try (Connection conexion = DriverManager.getConnection(cadenaConexion)) {
      String sentenciaSQL = "SELECT * FROM personas WHERE numero_cuenta = ?";
      PreparedStatement sentencia = conexion.prepareStatement(sentenciaSQL);
      sentencia.setString(1, num_cuenta);
      ResultSet resultadoConsulta = sentencia.executeQuery();
      if (resultadoConsulta != null && resultadoConsulta.next()) {
        Cuenta cuenta = null;
        String propietario = resultadoConsulta.getString("propietario");
        String numero_cuenta = resultadoConsulta.getString("numero_cuenta");
        float saldo = resultadoConsulta.getInt("saldo");
        String retiros = resultadoConsulta.getString("retiros");
        String depositos = resultadoConsulta.getString("depositos");

        cuenta = new Cuenta(propietario, numero_cuenta, saldo, retiros, depositos) {
          @Override
          public void depositar(double monto) throws MontoNegativoException {

          }

          @Override
          public void retirar(double monto) throws MontoNegativoException, SaldoInsuficienteException {

          }

          @Override
          public double calcularInteres(double monto) {
            return 0;
          }
        };
        return cuenta;
      }

    } catch (SQLException e) {
      System.err.println("Error de conexión: " + e);
    }
    return null;
  }

  public List<?> listar() {
    List<Cuenta> cuentas = new ArrayList<Cuenta>();

    try (Connection conexion = DriverManager.getConnection(cadenaConexion)) {
      String sentenciaSql = "SELECT * FROM CuentaBaseDeDatos";
      PreparedStatement sentencia = conexion.prepareStatement(sentenciaSql);
      ResultSet resultadoConsulta = sentencia.executeQuery();

      if (resultadoConsulta != null) {
        while (resultadoConsulta.next()) {
          Cuenta cuenta = null;
          String propietario = resultadoConsulta.getString("propietario");
          String numero_cuenta = resultadoConsulta.getString("numero_cuenta");
          float saldo = resultadoConsulta.getInt("saldo");
          String retiros = resultadoConsulta.getString("retiros");
          String depositos = resultadoConsulta.getString("depositos");

          cuenta = new Cuenta(propietario, numero_cuenta, saldo, retiros, depositos) {
            @Override
            public void depositar(double monto) throws MontoNegativoException {

            }

            @Override
            public void retirar(double monto) throws MontoNegativoException, SaldoInsuficienteException {

            }

            @Override
            public double calcularInteres(double monto) {
              return 0;
            }
          };
          cuentas.add(cuenta);
        }
        return cuentas;
      }
    } catch (SQLException e) {
      System.err.println("Error de conexión: " + e);
    }
    return null;

  }
}
