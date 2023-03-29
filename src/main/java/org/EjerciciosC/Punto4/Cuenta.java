package org.EjerciciosC.Punto4;

public abstract class Cuenta {
  protected String numeroCuenta;
  protected double saldo;
  protected String propietario;

  public Cuenta(String numeroCuenta, double saldo, String propietario) {
    this.numeroCuenta = numeroCuenta;
    this.saldo = saldo;
    this.propietario = propietario;
  }

  public Cuenta() {

  }

  public Cuenta(String numeroCuenta, String propietario) {
    this.numeroCuenta = numeroCuenta;
    this.propietario = propietario;
  }

  public abstract void depositar(double monto) throws MontoNegativoException;

  public abstract void retirar(double monto) throws MontoNegativoException, SaldoInsuficienteException;

  public String getNumeroCuenta() {
    return numeroCuenta;
  }

  public double getSaldo() {
    return saldo;
  }

  public String getPropietario() {
    return propietario;
  }

  public abstract double calcularInteres(double monto);
}
