// importamos las clases necesarias de las bibliotecas estandar de Java
// para trabajar con listas, mezclar elementos y generar numeros aleatorios
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

// Definimos la clase principal
public class Actividad3 {

    // Definimos una clase interna para representar la carta de poker
    // con sus atributos para el palo, color y el valor
    public static class Card {

        // Definimos los atributos de la carta
        private String palo;
        private String color;
        private String valor;

        // Definimos los metodos getters para obtener el palo, color y el valor
        public Card(String palo, String color, String valor) {
            this.palo = palo;
            this.color = color;
            this.valor = valor;
        }

        public String getPalo() {
            return palo;
        }

        public String getColor() {
            return color;
        }

        public String getValor() {
            return valor;
        }

        @Override
        public String toString() {
            return palo + "," + color + "," + valor;
        }
    }
    // Definimos otra clase interna "Deck" para representar el mazo de cartas
    public static class Deck {

        // Creamos una lista "List"de cartas como atributo de la clase "Deck"
        // e inicializamos el mazo en el constructor
        private List<Card> cards;

        public Deck() {

            //Definimos un metodo privado "InitializeDeck" para llenar el mazo con todas las cartas posibles
            // aqui se crean las cartas y se agregan al mazo
            initializeDeck();
        }

        private void initializeDeck() {

            // En el metodo "InitializeDeck" creamos todas las cartas posibles de poker
            // combinando palos, colores y valores y agregamos a la lista "cards"
            cards = new ArrayList<>();
            String[] palos = {"Tréboles", "Corazones", "Picas", "Diamantes"};
            String[] colores = {"Rojo", "Negro"};
            String[] valores = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "A", "J", "Q", "K"};

            for (String palo : palos) {
                for (String color : colores) {
                    for (String valor : valores) {
                        cards.add(new Card(palo, color, valor));
                    }
                }
            }
        }

        // Definimos un metodo "shuffle" para mezclar las cartas en el mazo utilizando "Collections.shuffle"
        public void shuffle() {
            Collections.shuffle(cards);
            System.out.println("Se mezcló el Deck.");
        }

        // Definimos un metodo "head" para tomar la primera carta del mazo
        // la eliminamos de la lista y la mostramos en consola
        public Card head() {
            if (cards.isEmpty()) {
                System.out.println("El Deck está vacío.");
                return null;
            }

            Card card = cards.remove(0);
            System.out.println(card);
            System.out.println("Quedan " + cards.size() + " cartas en el Deck.");
            return card;
        }

        // Definimos un metodo "pick" para tomar una carta al azar del mazo
        // la eliminamos de la lista y mostramos en la consola.
        public Card pick() {
            if (cards.isEmpty()) {
                System.out.println("El Deck está vacío.");
                return null;
            }

            Random random = new Random();
            int index = random.nextInt(cards.size());
            Card card = cards.remove(index);
            System.out.println(card);
            System.out.println("Quedan " + cards.size() + " cartas en el Deck.");
            return card;
        }

        // Definimos un metodo "Hand" para repartir una mano de cinco cartas desde el mazo
        // las eliminamos de la lista y las mostramos en consola
        public List<Card> hand() {
            if (cards.size() < 5) {
                System.out.println("No hay suficientes cartas en el Deck para repartir una mano.");
                return null;
            }

            List<Card> hand = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                Card card = cards.remove(0);
                hand.add(card);
                System.out.println(card);
            }

            System.out.println("Quedan " + cards.size() + " cartas en el Deck.");
            return hand;
            // Los metodos "head", "pick" y "hand" realizan operaciones similares
            // verifican si el mazo está vacío y toman una carta del mazo, la muestran
            // y actualizan el numero de cartas restantes en el mazo
        }
    }
    // Definimos el metodo "main" como punto de entrada
    public static void main(String[] args) {

        // En el metodo main, creamos un mazo de cartas "deck", lo mezclamos
        // tomamos la primera carta, tomamos una carta al azar y repartimos una mano de cinco cartas
        Deck deck = new Deck();

        deck.shuffle();
        deck.head();
        deck.pick();
        deck.hand();
    }
}