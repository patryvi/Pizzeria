public class Pizza {
        /*Crea la clase Pizza con los atributos y métodos necesarios. Sobre cada pizza se necesita
        saber el tamaño en pulgadas, el tipo – ej. margarita, cuatro quesos o funghi
        - y su estado en Boolean (entregada o no).

        Debemos crear varios constructores:

        Un primer constructor que cree una pizza sin ningún dato inicializado por nosotros.
        Un segundo constructor que cree una pizza a la que habrá de introducirle el tamaño y tipo.
        Ten en cuenta que siempre que se crea una pizza nueva, su estado es “no entregada”.*/
    static int cont=0;
    private int id=cont;
    private int tamanyo;
    private Tipo tipo;
    private boolean entregado=false;

    public Pizza(){

    }

    public Pizza(int tamanyo,Tipo tipo){
        cont++;
        id=cont;
        this.tamanyo = tamanyo;
        this.tipo = tipo;
    }

    public int getTamanyo() {
        return tamanyo;
    }

    public void setTamanyo(int tamaño) {
        this.tamanyo = tamanyo;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public boolean isEntregado() {
        return entregado;
    }

    public void setEntregado(boolean entregado) {
        this.entregado = entregado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Pizza: " +
                "id=" + id +
                ", tamanyo=" + tamanyo +
                ", tipo=" + tipo +
                ", entregado=" + entregado;
    }
}
