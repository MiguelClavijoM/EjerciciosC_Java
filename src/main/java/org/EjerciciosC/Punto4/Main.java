package org.EjerciciosC.Punto4;

public class Main {
  public static void main(String[] args) throws MontoNegativoException {
    Cuenta ahorro = new Ahorro("126556", "Miguel Clavijo");
    System.out.println("Cuenta de ahorro creada:");
    System.out.println("La cuenta de ahorros es: "+ahorro.numeroCuenta);
    System.out.println();


    ahorro.depositar(1000);
    System.out.println("Depósito exitoso de 1000.");
    System.out.println("Tu saldo es: "+ahorro.saldo);
    System.out.println();

    ahorro.depositar(2000);
    System.out.println("Depósito exitoso de 2000.");
    System.out.println("Tu saldo es: "+ahorro.saldo);
    System.out.println();

    ahorro.depositar(3000);
    System.out.println("Depósito exitoso de 3000.");
    System.out.println("Tu saldo es: "+ahorro.saldo);
    System.out.println();

    try {
      ahorro.retirar(500);
      System.out.println("Retiro 500 exitoso: ");
      System.out.println("Se han retirado: "+ahorro.saldo);
      System.out.println();

      ahorro.retirar(1000);
      System.out.println("Retiro 1000 exitoso");
      System.out.println("Se han retirado: "+ahorro.saldo);
      System.out.println();

      ahorro.retirar(2000);
      System.out.println("Retiro 2000 exitoso");
      System.out.println("Se han retirado: "+ahorro.saldo);
      System.out.println();

      ahorro.retirar(500);
      System.out.println("Retiro 500 exitoso");
      System.out.println("Se han retirado: "+ahorro.saldo);
      System.out.println();

      ahorro.retirar(1000);
      System.out.println("Retiro de 1000 exitoso");
      System.out.println("Se han retirado: "+ahorro.saldo);
      System.out.println();
    } catch (MontoNegativoException e) {
      System.out.println(e.getMessage());
    } catch (SaldoInsuficienteException e) {
      System.out.println(e.getMessage());
    }


    Cuenta corriente = new Corriente("654321", "Andres Escobar");
    System.out.println("Cuenta corriente creada");
    System.out.println("La cuenta corriente es: "+corriente.numeroCuenta);
    System.out.println();

    corriente.depositar(5000);
    System.out.println("Depósito exitoso");
    System.out.println("Tu saldo es: "+corriente.saldo);
    System.out.println();

    corriente.depositar(10000);
    System.out.println("Depósito exitoso");
    System.out.println("Tu saldo es: "+corriente.saldo);
    System.out.println();

    try {
      corriente.retirar(2000);
      System.out.println("Retiro exitoso");
      System.out.println("Tu saldo es: "+corriente.saldo);
      System.out.println();

      corriente.retirar(3000);
      System.out.println("Retiro exitoso");

      System.out.println("Tu saldo es: "+corriente.saldo);
      System.out.println();
    } catch (MontoNegativoException e) {
      System.out.println(e.getMessage());
    } catch (SaldoInsuficienteException e) {

      System.out.println(e.getMessage());
    }
  CuentaBaseDatos basededatos = new CuentaBaseDatos();
      basededatos.createAccount("12345667870", "ahorros");

  }


}

