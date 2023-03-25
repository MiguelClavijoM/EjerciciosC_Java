package org.EjerciciosC.Punto3;

public class mp4 implements Formatos {
  private String duracion;
  private int tamano;
  private String creador;
  private String tipoVideo;

  public mp4(String duracion, int tamano, String creador, String tipoVideo) {
    this.duracion = duracion;
    this.tamano = tamano;
    this.creador = creador;
    this.tipoVideo = tipoVideo;
  }

  public String getDuracion() {
    return this.duracion;
  }

  public int getTamano() {
    return this.tamano;
  }

  @Override
  public String getArtista() {
    return null;
  }

  @Override
  public String getCompositor() {
    return null;
  }

  @Override
  public String getGenero() {
    return null;
  }

  public String getCreador() {
    return this.creador;
  }

  public String getTipoVideo() {
    return this.tipoVideo;
  }
}
