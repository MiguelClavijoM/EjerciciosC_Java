package org.EjerciciosC.Punto3;

public class mp3 implements Formatos {
  private String duracion;
  private int tamano;
  private String artista;
  private String compositor;
  private String genero;

  public mp3(String duracion, int tamano, String artista, String compositor, String genero) {
    this.duracion = duracion;
    this.tamano = tamano;
    this.artista = artista;
    this.compositor = compositor;
    this.genero = genero;
  }

  public String getDuracion() {
    return this.duracion;
  }

  public int getTamano() {
    return this.tamano;
  }

  public String getArtista() {
    return this.artista;
  }

  public String getCompositor() {
    return this.compositor;
  }

  public String getGenero() {
    return this.genero;
  }

  @Override
  public String getCreador() {
    return null;
  }

  @Override
  public String getTipoVideo() {
    return null;
  }
}
