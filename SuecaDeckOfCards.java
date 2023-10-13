import java.util.*;

public class SuecaDeckOfCards extends DeckOfCards implements Prototype {

    private String nipeTrump;

    public SuecaDeckOfCards() {
        super();
        createTrump();
    }

    public SuecaDeckOfCards(SuecaDeckOfCards suecaDeckOfCards) {
        super(suecaDeckOfCards);
        this.nipeTrump = suecaDeckOfCards.nipeTrump;
    }

    private void createTrump() {
        if (!this.deck.isEmpty()) {
            int index = randomNumbers.nextInt(number_of_cards);
            this.nipeTrump = this.deck.get(index).getFace();
            Card card = this.deck.get(index);
            this.deck.remove(index);
            this.deck.add(0, card);
        }
    }

    public void editDeck() {
        List<String> cardRemoved = Arrays.asList("Eight", "Nine", "Ten");

        Iterator<Card> iterator = this.deck.iterator();
        while (iterator.hasNext()) {
            Card card = iterator.next();
            if (cardRemoved.contains(card.getFace())) {
                iterator.remove();
                this.number_of_cards--;
            }
        }
    }

    public void editDeckValues() {
        Map<String, Integer> cardValues = new HashMap<>();
        cardValues.put("Ace", 11);
        cardValues.put("Seven", 10);
        cardValues.put("King", 4);
        cardValues.put("Jack", 3);
        cardValues.put("Queen", 2);

        this.deck.forEach(card -> card.setValue(cardValues.getOrDefault(card.getFace(), 0)));
    }

    public Prototype clone() {
        return new SuecaDeckOfCards(this);
    }
}
