package org.EjerciciosC.Punto3;

public class Main {
  public static void main(String[] args) {
    mp3 cancionmp3 = new mp3("3:45", 512, "The Beatles", "John Lennon", "Rock");
    mav cancionmav = new mav("10:30", 2048, "Mozart", "Wolfgang Amadeus Mozart", "Clásica");
    mp4 videomp4 = new mp4("4:20", 300, "Miguel", "Informativo");

    System.out.println("FORMATO mp3:");
    System.out.println("Duración: " + cancionmp3.getDuracion());
    System.out.println("Tamaño: " + cancionmp3.getTamano() + " KB");
    System.out.println("Artista: " + cancionmp3.getArtista());
    System.out.println("Compositor: " + cancionmp3.getCompositor());
    System.out.println("Género: " + cancionmp3.getGenero());

    System.out.println("FORMATO mav:");
    System.out.println("Duración: " + cancionmav.getDuracion());
    System.out.println("Tamaño: " + cancionmav.getTamano() + " KB");
    System.out.println("Artista: " + cancionmav.getArtista());
    System.out.println("Compositor: " + cancionmav.getCompositor());
    System.out.println("Género: " + cancionmav.getGenero());

    System.out.println("FORMATO mp4:");
    System.out.println("Duración: " + videomp4.getDuracion());
    System.out.println("Tamaño: " + videomp4.getTamano());
    System.out.println("Creador: " + videomp4.getCreador());
    System.out.println("Tipo de video: " + videomp4.getTipoVideo());
  }
}
