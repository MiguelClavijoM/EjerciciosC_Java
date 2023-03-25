package org.EjerciciosC.Punto4;

public class Main {
  public static void main(String[] args) throws MontoNegativoException {
    // Creamos una cuenta de ahorro y la mostramos
    Cuenta ahorro = new Ahorro("123456", "Miguel Clavijo");
    System.out.println("Cuenta de ahorro creada:");
    System.out.println(ahorro);
    System.out.println();

    // Realizamos algunos depósitos en la cuenta de ahorro
    ahorro.depositar(1000);
    System.out.println("Depósito exitoso de 1000.");
    System.out.println(ahorro);
    System.out.println();

    ahorro.depositar(2000);
    System.out.println("Depósito exitoso de 2000.");
    System.out.println(ahorro);
    System.out.println();

    ahorro.depositar(3000);
    System.out.println("Depósito exitoso de 3000.");
    System.out.println(ahorro);
    System.out.println();

    // Realizamos algunos retiros en la cuenta de ahorro
    try {
      ahorro.retirar(500);
      System.out.println("Retiro exitoso: ");
      System.out.println(ahorro);
      System.out.println();

      ahorro.retirar(1000);
      System.out.println("Retiro exitoso:");
      System.out.println(ahorro);
      System.out.println();

      ahorro.retirar(2000);
      System.out.println("Retiro exitoso: ");
      System.out.println(ahorro);
      System.out.println();

      ahorro.retirar(500);
      System.out.println("Retiro exitoso: ");
      System.out.println(ahorro);
      System.out.println();

      ahorro.retirar(1000);
      System.out.println("Retiro exitoso: ");
      System.out.println(ahorro);
      System.out.println();
    } catch (MontoNegativoException e) {
      System.out.println(e.getMessage());
    } catch (SaldoInsuficienteException e) {
      System.out.println(e.getMessage());
    }


    // Creamos una cuenta corriente y la mostramos
    Cuenta corriente = new Corriente("654321", "Andres Escobar");
    System.out.println("Cuenta corriente creada:");
    System.out.println(corriente);
    System.out.println();

    // Realizamos algunos depósitos en la cuenta corriente
    corriente.depositar(5000);
    System.out.println("Depósito exitoso: ");
    System.out.println(corriente);
    System.out.println();

    corriente.depositar(10000);
    System.out.println("Depósito exitoso de: ");
    System.out.println(corriente);
    System.out.println();

    // Realizamos algunos retiros en la cuenta corriente
    try {
      corriente.retirar(2000);
      System.out.println("Retiro exitoso: ");
      System.out.println(corriente);
      System.out.println();

      corriente.retirar(3000);
      System.out.println("Retiro exitoso: ");
      System.out.println(corriente);
      System.out.println();
    } catch (MontoNegativoException e) {
      System.out.println(e.getMessage());
    } catch (SaldoInsuficienteException e) {
      System.out.println(e.getMessage());
    }
  }

}

