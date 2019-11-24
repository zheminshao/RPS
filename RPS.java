import java.util.*;

public class RPS {
   public static void main(String[] args) {
      RPSAI deepZ = new RPSAI();
      int state = 9;
      double userScore = 0.0;
      double comScore = 0.0;
      while (true) {
         int comMove = deepZ.move(state);
         
         int userMove = promptMove();
         deepZ.record(state, userMove);
         
         System.out.print("deepZ plays ");
         if (comMove == 0) {
            System.out.println("r");
         } else if (comMove == 1) {
            System.out.println("p");
         } else {
            System.out.println("s");
         }
         
         //int userMove = promptMove();
         //deepZ.record(state, userMove);
      
         if (userMove == comMove) {
            System.out.println("Draw!");
            userScore += 0.5;
            comScore += 0.5;
         } else if (userMove - comMove == 1 || userMove - comMove == -2) {
            System.out.println("You win!");
            userScore++;
         } else {
            System.out.println("deepZ wins!");
            comScore++;
         }
         System.out.println("You " + userScore + " - " + comScore + " deepZ");
         System.out.println();
         state = userMove * 3 + comMove;
      }
   }
   
   public static int promptMove() {
      Scanner console = new Scanner(System.in);
      System.out.print("What do you play? (r, p, s) ");
      char move = ' ';
      while (move != 112 && move != 114 && move != 115) {
         move = console.next().charAt(0);
      }
      if (move == 112) {
         return 1;
      } else if (move == 114) {
         return 0;
      } else {
         return 2;
      }
   }
}