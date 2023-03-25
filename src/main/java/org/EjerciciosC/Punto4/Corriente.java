package org.EjerciciosC.Punto4;

public class Corriente extends Cuenta {
  private int numRetiros;

  public Corriente(String numeroCuenta, double saldo, String propietario, int numRetiros) {
    super(numeroCuenta, saldo, propietario);
    this.numRetiros = numRetiros;
  }

  public Corriente(int numRetiros) {
    super();
    this.numRetiros = numRetiros;
  }

  public Corriente(String numeroCuenta, String propietario) {
    super(numeroCuenta, propietario);
    this.numRetiros = 0;
  }

  @Override
  public void retirar(double monto) throws MontoNegativoException, SaldoInsuficienteException {
    if (monto < 0) {
      throw new MontoNegativoException("No es posible retirar un monto negativo.");
    }

    if (numRetiros >= 5) {
      throw new SaldoInsuficienteException("No es posible realizar más retiros.");
    }

    if (saldo < monto) {
      throw new SaldoInsuficienteException("No hay suficiente saldo para realizar el retiro.");
    }

    saldo -= monto;
    numRetiros++;
  }

  @Override
  public double calcularInteres(double monto) {
    return 0;
  }

  @Override
  public void depositar(double monto) throws MontoNegativoException {
    if (monto < 0) {
      throw new MontoNegativoException("No es posible depositar un monto negativo.");
    }

    saldo += monto;
  }
}

