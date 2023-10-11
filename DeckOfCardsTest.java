public class DeckOfCardsTest
{
   // Executa o aplicativo
   public static void main(String args[])
   {
      DeckOfCards myDeckOfCards = new DeckOfCards();
      //myDeckOfCards.shuffle(); // Coloca as cartas em ordem aleatória

      // Imprime todas as 52 cartas na ordem em que elas são distribuídas
      System.out.println("Size: " + myDeckOfCards.size());
      System.out.println(myDeckOfCards);

      System.out.println("Removendo 26 cartas a partir do topo do baralho:");

      SuecaDeckOfCards suecaDeck = new SuecaDeckOfCards();
      System.out.println("Size: " + suecaDeck.size());

      for (int i = 0; i < 26; i++)
      {
         System.out.printf("%-20s\n", myDeckOfCards.dealCard());
         // Distribui e imprime 4 cartas
         // System.out.printf("%-20s%-20s%-20s%-20s\n",
         //    myDeckOfCards.dealCard(), myDeckOfCards.dealCard(), 
         //    myDeckOfCards.dealCard(), myDeckOfCards.dealCard());
      } // for final
      System.out.println("Size: " + myDeckOfCards.size());
      
   } 
   // Fim do método main
} // Fim da classe DeckOfCardsTest
