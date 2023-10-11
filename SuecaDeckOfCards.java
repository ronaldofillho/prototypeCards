import java.util.ArrayList;
import java.util.List;

public class SuecaDeckOfCards {
    private List<Card> deck; // ArrayList usado como uma pilha de objetos
    private final int NUMBER_OF_CARDS = 52; // número constante de cartas

    // Construtor que preenche o baralho de cartas para Sueca
    public SuecaDeckOfCards() {
        String faces[] = { "Ace", "Deuce", "Three", "Four", "Five", "Six",
            "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King" };
        String suits[] = { "Hearts", "Diamonds", "Clubs", "Spades" };

        deck = new ArrayList<Card>(); // cria List de objetos Card

        // Preenche o baralho com objetos Card
        for (int count = 0; count < NUMBER_OF_CARDS; count++) {
            deck.add(new Card(faces[count % 13], suits[count / 13], (count % 13) + 1));
        }

        adjustCardValuesForSueca();
    }

    // Método privado para ajustar os valores das cartas para Sueca
    private void adjustCardValuesForSueca() {
        for (Card card : deck) {
            String face = card.getFace();
            switch (face) {
                case "Ace":
                    card.setValue(11); // Ás vale 11 pontos
                    break;
                case "7":
                    card.setValue(10); // 7 vale 10 pontos
                    break;
                case "King":
                    card.setValue(4);  // Rei vale 4 pontos
                    break;
                case "Jack":
                    card.setValue(3);  // Valete vale 3 pontos
                    break;
                case "Queen":
                    card.setValue(2);  // Dama vale 2 pontos
                    break;
                default:
                    card.setValue(0);  // Restantes valem 0 pontos
            }
        }
    }

    // Verifica se ainda há cartas no baralho
    public boolean hasCard() {
        return !deck.isEmpty();
    }

    // Embaralha as cartas com um algoritmo de uma passagem
    public void shuffle() {
        // ... (seu código de embaralhamento)
    }

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
        // ... (seu código de conversão para String)
        return null;
    }

    // Método para realizar uma cópia profunda do baralho de Sueca
    public SuecaDeckOfCards cloneDeck() {
        SuecaDeckOfCards clonedSuecaDeck = new SuecaDeckOfCards();
        clonedSuecaDeck.deck = new ArrayList<>();
        for (Card card : deck) {
            clonedSuecaDeck.deck.add(new Card(card.getFace(), card.getSuit(), card.getValue()));
        }
        return clonedSuecaDeck;
    }

    public static void main(String[] args) {
        // Exemplo de como criar e embaralhar um baralho de Sueca
        SuecaDeckOfCards suecaDeck = new SuecaDeckOfCards();
        suecaDeck.shuffle();

        // Exemplo de como criar uma cópia profunda do baralho de Sueca
        SuecaDeckOfCards clonedSuecaDeck = suecaDeck.cloneDeck();

        // Agora você pode realizar operações com a cópia, como embaralhar novamente
        clonedSuecaDeck.shuffle();

        // Ou distribuir cartas dela
        Card card = clonedSuecaDeck.dealCard();
        System.out.println("\n" + card);
        System.out.println("Size: " + clonedSuecaDeck.size());
        System.out.println("\n" + clonedSuecaDeck.deck);
    }
}
