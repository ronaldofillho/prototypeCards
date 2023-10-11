import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DeckOfCards {
    private List<Card> deck; // ArrayList usado como uma pilha de objetos
    private final int NUMBER_OF_CARDS = 52; // número constante de cartas
    private Random randomNumbers; // gerador de números aleatórios

    // Construtor que preenche o baralho de cartas
    public DeckOfCards() {
        String faces[] = { "Ace", "Deuce", "Three", "Four", "Five", "Six",
            "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King" };
        String suits[] = { "Hearts", "Diamonds", "Clubs", "Spades" };

        deck = new ArrayList<Card>(); // cria List de objetos Card
        randomNumbers = new Random(); // cria gerador de números aleatórios

        // Preenche o baralho com objetos Card
        for (int count = 0; count < NUMBER_OF_CARDS; count++) {
            deck.add(new Card(faces[count % 13], suits[count / 13], (count % 13) + 1));
        }
    } // fim do construtor DeckOfCards

    // Verifica se ainda há cartas no baralho
    public boolean hasCard() {
        return !deck.isEmpty();
    }

    // Embaralha as cartas com um algoritmo de uma passagem
    public void shuffle() {
        // Para cada carta, seleciona outra carta aleatória e as compara
        for (int first = 0; first < deck.size(); first++) {
            // Seleciona um número aleatório entre 0 e 51
            int second = randomNumbers.nextInt(NUMBER_OF_CARDS);

            // Compara a carta atual com a carta aleatoriamente selecionada
            Card temp = deck.get(first);
            deck.set(first, deck.get(second));
            deck.set(second, temp);
        }
    } // fim do método shuffle

    // Distribui uma carta do topo do monte
    public Card dealCard() {
        if (hasCard()) {
            return deck.remove(deck.size() - 1); // Retorna a carta do topo do monte
        } else {
            return null; // Não há mais cartas no baralho
        }
    }

    // Retorna o número de cartas restantes no baralho
    public int size() {
        return deck.size();
    }

    // Converte o baralho em uma representação de string
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Card card : deck) {
            sb.append(card.toString()).append("\n");
        }
        return sb.toString();
    }

    // Método protegido para obter o deck (lista de cartas)
    protected List<Card> getDeck() {
        return deck;
    }

    
}
