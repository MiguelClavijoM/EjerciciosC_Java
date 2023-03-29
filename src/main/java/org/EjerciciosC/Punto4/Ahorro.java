package org.EjerciciosC.Punto4;

public class Ahorro extends Cuenta implements Interes {
  private int numRetiros;
  private boolean primerDeposito;

  public Ahorro(String numeroCuenta, String propietario) {
    super(numeroCuenta, propietario);
    this.numRetiros = 0;
    this.primerDeposito = true;
  }

  @Override
  public void retirar(double monto) throws MontoNegativoException, SaldoInsuficienteException {
    if (monto < 0) {
      throw new MontoNegativoException("No es posible retirar un monto negativo.");
    }

    if (numRetiros >= 3) {
      monto += monto * 0.01;
    }

    if (saldo < monto) {
      throw new SaldoInsuficienteException("No hay suficiente saldo para realizar el retiro.");
    }

    saldo -= monto;
    numRetiros++;
  }

  @Override
  public void depositar(double monto) throws MontoNegativoException {
    if (monto < 0) {
      throw new MontoNegativoException("No es posible depositar un monto negativo.");
    }

    if (primerDeposito) {
      saldo += calcularInteres(monto);
      primerDeposito = false;
    } else {
      saldo += monto;
    }
  }

  @Override
  public double calcularInteres(double monto) {
    return monto * 1.005;
  }
}

