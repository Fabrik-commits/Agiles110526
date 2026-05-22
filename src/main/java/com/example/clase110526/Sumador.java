package com.example.clase110526;

public class Sumador {

  public int sumar(String numeros) {

    if (numeros.isEmpty()) {
      return 0;
    }

    String delimitador = "[,\n]";
    String contenido = numeros;

    // delimitador personalizado
    if (numeros.startsWith("//")) {

      delimitador = numeros.substring(2, 3);

      contenido = numeros.substring(4);
    }

    String[] partes = contenido.split(delimitador);

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
