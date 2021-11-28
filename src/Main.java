import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {
        /*


Vamos a crear un sistema gestor de reparto de pizzerías en una localidad.

Crea la clase Pizza con los atributos y métodos necesarios. Sobre cada pizza se necesita saber el tamaño en pulgadas, el tipo –
ej. margarita, cuatro quesos o funghi - y su estado en Boolean (entregada o no).

Debemos crear varios constructores:

Un primer constructor que cree una pizza sin ningún dato inicializado por nosotros.
Un segundo constructor que cree una pizza a la que habrá de introducirle el tamaño y tipo.
Ten en cuenta que siempre que se crea una pizza nueva, su estado es “no entregada”.

Acto seguido, crea otra clase, Pizzeria, con un nombre y algunos atributos y métodos que permitan almacenar información sobre el
número total de pizzas que se han pedido y que se han servido en cada pizzería. Crea además un constructor que no reciba parámetros.

Para empezar, crea un método para esta clase Pizzeria que permita servir pizzas preguntando al usuario que pizza quiere: sus pulgadas
entre 10 y 20 y el tipo. Esa pizza debe introducirse en un objeto de la clase Pizza y devolverse ese objeto Pizza cuando se llame al método.

Crea otro método para entregar pizzas y cambiar el estado de un objeto de la clase Pizza que reciba como parámetro.

Por último, debes crear un método getTotalEntregadas() y otro getTotalPedidas() que devuelvan el número de pizzas pedidas y servidas por
 una pizzería en el instante que se invoca el método. Deberás usar acumuladores para cada vez que piden o entregan pizzas
 cambien unos atributos de la clase Pizzeria. Esos atributos acumuladores deben inicializarse a 0 automáticamente al crearse un objeto de Pizzeria.

Puedes crear una clase Main de prueba donde crear una instancia de pizzería e invocar sus métodos.

Evita que la aplicación se quede colgada capturando y tratando los posibles errores que se puedan producir.
         */


        Pizzeria p = new Pizzeria();
        boolean salir=false;
        do{
            //metodo mostrar menu
            mostrarMenu();
            //introducir opcion
            int opcion = introducirOpcion();
            //elegir opcion
            switch (opcion){
                case 0:
                    salir = true;
                    break;
                case 1:
                    p.servirPizza();
                    break;
                case 2:
                    //Crea otro método para entregar pizzas y cambiar el estado de un objeto de la clase Pizza que reciba como parámetro.
                    p.entregarPizzas();
                    break;
                case 3:
                    System.out.println("El numero de pizzas que se han pedido es de: "+p.getPedidas());
                    break;
                case 4:
                    System.out.println("El numero de pizzas que se han servido es de: "+p.getServidas());
                    break;
            }
        }while(!salir);

    }





    public static void mostrarMenu(){
        System.out.println("\n ---Menu---");
        System.out.println("1 - Servir Pizzas");
        System.out.println("2 - Entregar Pizzas");
        System.out.println("3 - Mostrar Total Pizzas Entregadas");
        System.out.println("4 - Mostrar Total Pizzas Pedidas");
        System.out.println("0 - Salir");
    }

    public static int introducirOpcion(){
        int opcion=-1;
        String entrada;
        do {
            System.out.println("Selecciona una opcion del menu: ");
            entrada = sc.nextLine();
            if(!esEntero(entrada)){
                System.err.println("No has introducido un numero entero, vuelve a introducirlo.");
            }else{
                opcion=Integer.parseInt(entrada);
            }
        }while(opcion>4 || opcion<0);
        return opcion;
    }

    private static boolean esEntero(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }


}
