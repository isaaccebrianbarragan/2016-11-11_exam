
package javaapplication7;

import java.util.Random;
import java.util.Scanner;

/**
 * Main.java
 * Esta aplicación emula el juego del ahorcado, en versión de consola.
 * @author Isaac Cebrián Barragán
 * @version 1.0
 * @date 2016-11-11
 */
public class Main {
    public static void main(String[] args) {
        startGame();
   } 
    /**
     * Inicia el juego.
     */
    private static void startGame() {
        
        //Este array de String contiene todas las posibles palabras que pueden perguntar al usuario en el juego.
        String[] paraules={"ATOM","MOLECULA","BIO", "PERL"};

        //Variables del juego
        String resposta, llegit="";
        int count, encerts, pos;
        char c;

        do{
            //Obtiene la palabra de la partida dado el indice obtenido por el random.
            String paraula=paraules[generateRandom(paraules.length)];

            System.out.println("La paraula que has d'encertar té "+paraula.length()+" lletres");

            //Inicializa el array de carácteres (letras acertadas) que le será mostrado al usuario, mediante vaya acertando palabras se irán sustituyendo por estas.
            char[] lletres = GameControlls.palabraOculta(paraula);
            
             //Inicializa tanto el contador de intentos como el de aciertos a 0 respectivamente.
             count=0;
             encerts=0;
             
             do{
                //Pregunta al usuario por una letra que puede ser "[ABCDEFGHIJKLMNÑOPQRSTUVWXYZ ]" tanto mayusculas como minúsculas, en el caso en que el usuario introduzca otra palabra que no coincida con las anteriormente mencionadas le vuelve a preguntar.
                llegit = dameUnaLetra("Si us plau, Escriu una lletra valida", "[ABCDEFGHIJKLMNÑOPQRSTUVWXYZ ]");

               //Convierte el caracter dado por el usuario en mayúscula.
               c=llegit.toUpperCase().charAt(0);
               
               //Obtiene el índice de la primera coincidencia de la palabra secreta. En caso de no encontrar ninguna coincidencia devuelve -1.
               pos = paraula.indexOf(c);
               
               //Si pos es igual a -1 significa que no ha encontrado ninguna coincidéncia con la palabra secreta, entonces sumará uno a el contador de intentos y informará al usuario que la letra introducida no es correcta. En el caso de que haya encontrado una, se no contará como un intento.
               if (pos == -1) {
                    count++;
                    System.out.println("Aquesta lletra no es troba dins de la paraula. Ara et queden "+ (10-count)+ " intents");
                    //Si los intentos "count" han llegado a 10 informa al usuario que ya ha gastado todos los intentos.
                    if(count == 10) System.out.println("Has esgotat tots els intents");
                } else {
                        //Busca la letra introducida por el usuario en la palabra secreta comprobando uno a uno todos los campos que la componen, cuando la encuentra sustituye la letra correspondiente del array de carácteres (letras acertadas) por el de la letra acertada.
                        for(int i=0;i<lletres.length;i++){
                            if(paraula.charAt(i) == c){

                                lletres[i] =c;

                                encerts +=1;
                            }
                            System.out.print(lletres[i]+" ");

                        }
                   System.out.println("Molt bé!!! Torna a intentar-ho");
                   if(encerts == paraula.length()){
                       System.out.println("Has acabat encertant la paraula. Felicitats!!!!");
                       count =10;
                   }
                }
              }while(count !=10);
            
           }while(pideTexto("Vols continuar?(S/N)").equals("S"));
    }

    /**
     * Pregunta al usuario, espera una letra y la valida usando el criterio pasado por parámetro, obtiene  "[ABCDEFGHIJKLMNÑOPQRSTUVWXYZ ]" tanto mayusculas como minúsculas, en el caso en que el usuario introduzca otra letra que no coincida con las anteriormente mencionadas le vuelve a preguntar.
     * @param pregunta String que contiene una pregunta para el usuario.
     * @param criterio String Criterio de filtrado que es key insensitive con el siguiente formato similar "[ABC]" , en este caso contempla que solo contenga una letra bien sea "A", "B", o "C" sin importar si se trata de letras mayúsculas o minusculas.
     * @return String introducido por el usuario (un valor valido).
     */
    private static String dameUnaLetra(String pregunta, String respuesta) {
        Scanner lector = new Scanner (System.in);
        String llegit = "";
        boolean valid=false;
        
        do{
            System.out.println(pregunta);
            llegit=lector.nextLine().toUpperCase();
            if(llegit.matches(respuesta)) valid=true;
        }while(valid == false || llegit.isEmpty() || llegit==null);
        
        return llegit;
    }
    /**
     * Pregunta al usuario y espera una respuesta de texto.
     * @param texto texto a mostrar al usuario para pedir un texto.
     * @return String texto introducido por el usuario.
     */
    private static String pideTexto(String texto) {
        Scanner lector = new Scanner (System.in);
        String resposta = "";
        System.out.println(texto);
        resposta=lector.nextLine().toUpperCase();
        return resposta;
    }
    /**
     * Genera un numero aleatorio entre 0 y la cantidad de palabras que hay en el array.
     * @param length Numero que determina el máximo número aleatorio que va a retornar menos 1;
     * @return int Numero entre 0 y la cantidad dada por parámetros menos 1.
     */
    private static int generateRandom(int length) {
        Random rnd = new Random();
        int endevina=(int)(rnd.nextDouble()*length);
        return endevina;
    }
    
}
