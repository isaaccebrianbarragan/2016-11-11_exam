package javaapplication7;

/**
 * Main.java
 * Esta clase contiene funciones necesarias para el manejo del juego del ahorcado.
 * @author Isaac Cebrián Barragán
 * @version 1.0
 * @date 2016-11-11
 */
public class GameControlls {
    /**
     * Convierte una palabra dada por parámetros en un array de carácteres con el simbolo '_'.
     * @param palabra palabra a convertir.
     * @return char[] array de carácteres que contiene tantos carácteres como la palabra dada por parámetros y cada carácter contiene '_'.
     */
    public static char[] palabraOculta(String palabra) {
        //Inicializa el array de carácteres (letras acertadas) que le será mostrado al usuario, mediante vaya acertando palabras se irán sustituyendo por estas.
        char palabraOculta[]=new char[palabra.length()];
        for(int i=0;i<palabra.length();i++){
            palabraOculta[i] ='_';

        }
        return palabraOculta;
    }
}
