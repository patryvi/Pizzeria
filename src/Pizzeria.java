import java.util.ArrayList;
import java.util.Scanner;

public class Pizzeria {
    /*
    Acto seguido, crea otra clase, Pizzeria, con un nombre y algunos atributos y métodos que permitan almacenar información sobre el
número total de pizzas que se han pedido y que se han servido en cada pizzería. Crea además un constructor que no reciba parámetros.

Para empezar, crea un método para esta clase Pizzeria que permita servir pizzas preguntando al usuario que pizza quiere: sus pulgadas
entre 10 y 20 y el tipo. Esa pizza debe introducirse en un objeto de la clase Pizza y devolverse ese objeto Pizza cuando se llame al método.

Crea otro método para entregar pizzas y cambiar el estado de un objeto de la clase Pizza que reciba como parámetro.

Por último, debes crear un método getTotalEntregadas() y otro getTotalPedidas() que devuelvan el número de pizzas pedidas y servidas por
 una pizzería en el instante que se invoca el método. Deberás usar acumuladores para cada vez que piden o entregan pizzas
 cambien unos atributos de la clase Pizzeria. Esos atributos acumuladores deben inicializarse a 0 automáticamente al crearse un objeto de Pizzeria.
     */
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Pizza> pizzas = new ArrayList<>();

    private static int pedidas=0;
    private static int servidas=0;

    public Pizzeria (){
    }

    public static int getPedidas() {
        return pedidas;
    }

    public static void setPedidas(int pedidas) {
        Pizzeria.pedidas = pedidas;
    }

    public static int getServidas() {
        return servidas;
    }

    public static void setServidas(int servidas) {
        Pizzeria.servidas = servidas;
    }



    public static int introducirIdPizza(){
        int opcion=-1;
        String entrada;
        do {
            System.out.println("Selecciona una ID de la lista (0 para cancelar): ");
            entrada = sc.nextLine();
            if(!esEntero(entrada)){
                System.err.println("No has introducido un numero entero, vuelve a introducirlo.");
            }else{
                opcion=Integer.parseInt(entrada);
                if(opcion<0){
                    System.err.println("Has introducido un numero negativo, vuelve a introducir.");
                }
            }
        }while(opcion<0);
        return opcion;
    }

    public static boolean mostrarPizzasSinEntregar(){

        if(pizzas.isEmpty()){
            System.out.println("No hay pizzas para entregar.");
            return false;
        }else {
            System.out.println("\n--Pizzas para entregar--");
            for (Pizza p : pizzas) {
                if (!p.isEntregado()) {
                    System.out.println(p.toString());
                    return true;
                }
            }
            System.out.println("No hay pizzas disponibles.");
            return false;
        }
    }

    public static boolean comprobarIdPizza(int id){

        if(id==0){
            return true;
        }

        for(Pizza pizzas :pizzas){
            if(id == pizzas.getId()){
                return true;
            }
        }
        System.err.println("Has introducido una ID no disponible.");
        return false;
    }

    public static void entregarPizzas(){
        int id=0;
        boolean disponibles;
        do {
            disponibles = mostrarPizzasSinEntregar();
            if(disponibles) {
                id = introducirIdPizza();
            }
        }while(!comprobarIdPizza(id));
        if(id!=0) {
            for (Pizza pizza : pizzas) {
                if (pizza.getId() == id) {
                    entregarPizza(pizza);
                    System.out.println("Se ha entregado la pizza: " + pizza.toString());
                }
            }
        }else{
            return;
        }
    }

    //Este metodo devuelve una pizza.
    public void servirPizza(){

        pizzas.add(crearPizza());
        servidas++;
    }

    private Pizza crearPizza(){
        int tamanyo = introducirPulgadas();
        Tipo tipo = introducirTipo();
        return new Pizza(tamanyo,tipo);
    }

    private static void entregarPizza(Pizza pizza){
        pizza.setEntregado(true);
        pedidas++;
    }


    private int introducirPulgadas(){
        String entrada;
        int pulgadas=-1;

        do {
            System.out.println("¿De que pulgadas quiere su pizza? Disponible (entre 10 y 20)");
            entrada=sc.nextLine();
            if(!esEntero(entrada)){
                System.err.println("Caracter no valido.");
            }else{
                pulgadas=Integer.parseInt(entrada);
            }
        }while(pulgadas>20 || pulgadas<10);
        return pulgadas;
    }

    private static boolean esEntero(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    private static void mostrarValoresEnum(){
        System.out.println("Introduce uno de los siguientes valores: \n----------------------");
        Object[] possibleValues = Tipo.values();
        for (Object o : possibleValues) {
            System.out.println(o.toString());
        }
    }

    private Tipo introducirTipo() {
        /////////////////////////////////////////////////////////////////////////////////////////////////////////
        String tipo;
        do {
            mostrarValoresEnum();
            tipo = sc.nextLine().toUpperCase();
        }while (!comprobarValorEnum(tipo));
        Tipo t = Tipo.valueOf(tipo);
        return t;
    }

    private boolean comprobarValorEnum(String tipo){
        boolean valido = false;
        Object[] possibleValues = Tipo.values();
        for (Object o : possibleValues) {
            if(o.toString().equals(tipo)){
                valido = true;
            }
        }
        return valido;
    }
}
