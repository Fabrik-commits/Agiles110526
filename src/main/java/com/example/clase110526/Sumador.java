package com.example.clase110526;

import java.util.regex.Pattern;

public class Sumador {

  public int sumar(String numeros) {

    if (numeros.isEmpty()) {
      return 0;
    }

    // String delimitador = "[,\n]";
    String contenido = numeros;
    String[] partes;

    // delimitador personalizado
    if (numeros.startsWith("//")) {

      String delimitador = numeros.substring(2, 3);

      contenido = numeros.substring(4);

      partes = contenido.split(Pattern.quote(delimitador));
    } else {

      // Delimitadores por defecto: coma o salto de línea
      partes = contenido.split("[,\n]");
    }

    // String[] partes = contenido.split(delimitador);
    // String[] partes = contenido.split(Pattern.quote(delimitador));

    int suma = 0;

    for (String numeroTexto : partes) {

      int numero = Integer.parseInt(numeroTexto);

      if (numero < 0) {
        throw new IllegalArgumentException(
            "no se permiten negativos: " + numero);
      }

      suma += numero;
    }

    return suma;
  }
}
