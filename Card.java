public class Card implements Prototype 
{
   private String face; // face da carta ("Ace", "Deuce", ...)
   private String suit; // naipe da carta ("Hearts", "Diamonds", ...)
   private int value;

   // Construtor de três argumentos inicializa face, naipe e valor da carta
   public Card(String cardFace, String cardSuit, int cardValue)
   {
      face = cardFace; // inicializa face da carta
      suit = cardSuit; // inicializa naipe da carta
      value = cardValue; // inicializa valor da carta
   }

   public Card(Card card) {
      this.face = card.face;
      this.suit = card.suit;
      this.value = card.value;
   }

   public Prototype clone() {
      return new Card(this);
   }

   // Retorna uma representação em String da carta
   public String toString()               
   {                                      
      return face + " of " + suit + ", value " + value;        
   }

   // Retorna a face da carta
   public String getFace() {
      return face;
   }

   // Retorna o valor da carta
   public int getValue() {
      return value;
   }

   // Retorna o naipe da carta
   public String getSuit() {
      return suit;
   }

   // Define o valor da carta
   public void setValue(int value) {
      this.value = value;
   }
}
