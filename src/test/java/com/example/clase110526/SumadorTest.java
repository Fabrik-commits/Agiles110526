package com.example.clase110526;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class SumadorTest {

  @Test
  void stringVacioDebeRetornarCero() {
    Sumador sumador = new Sumador();

    int resultado = sumador.sumar("");

    assertEquals(0, resultado);
  }

  @Test
  void unNumeroDebeRetornarEseNumero() {
    Sumador sumador = new Sumador();

    int resultado = sumador.sumar("5");

    assertEquals(5, resultado);
  }

  @Test
  void dosNumerosSeparadosPorComaDebenSumarse() {
    Sumador sumador = new Sumador();

    int resultado = sumador.sumar("1,2");

    assertEquals(3, resultado);
  }

  @Test
  void multiplesNumerosSeparadosPorComaDebenSumarse() {
    Sumador sumador = new Sumador();

    int resultado = sumador.sumar("1,2,3");

    assertEquals(6, resultado);
  }

  @Test
  void muchosNumerosSeparadosPorComaDebenSumarse() {
    Sumador sumador = new Sumador();

    int resultado = sumador.sumar("1,2,3,5,8,13");

    assertEquals(32, resultado);
  }

  @Test
  void numerosConSaltosDeLineaDebenSumarse() {
    Sumador sumador = new Sumador();

    int resultado = sumador.sumar("1,2,4\n5,6");

    assertEquals(18, resultado);
  }

  @Test
  void delimitadorPersonalizadoPuntoYComa() {
    Sumador sumador = new Sumador();

    int resultado = sumador.sumar("//;\n1;3;6;4");

    assertEquals(14, resultado);
  }

  /*
   * @Test
   * void delimitadorPersonalizadoPipe() {
   * Sumador sumador = new Sumador();
   * 
   * assertEquals(14, sumador.sumar("//|\n1|3|6|4"));
   * }
   */

  /*
   * @Test
   * void delimitadorPersonalizadoPipe() {
   * Sumador sumador = new Sumador();
   * 
   * int resultado = sumador.sumar("//|\n1|3|6|4");
   * 
   * assertEquals(14, resultado);
   * }
   */

  @Test
  void numerosNegativosDebenLanzarExcepcion() {

    Sumador sumador = new Sumador();

    Exception exception = assertThrows(
        IllegalArgumentException.class,
        () -> sumador.sumar("1,-3,5"));

    assertEquals(
        "no se permiten negativos: -3",
        exception.getMessage());
  }

}
