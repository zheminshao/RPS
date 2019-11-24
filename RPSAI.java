import java.util.*;

public class RPSAI {
   private int[][] tendencies;
   
   public RPSAI() {
      tendencies = new int[10][3];
      for (int r = 0; r < tendencies.length; r++) {
         for (int c = 0; c < tendencies[r].length; c++) {
            tendencies[r][c] = 1;
         }
      }
   }
   
   public int move(int state) {
      int max = 0;
      ArrayList<Integer> moves = new ArrayList<Integer>();
      for (int c = 0; c < tendencies[state].length; c++) {
         if (tendencies[state][c] > max) {
            max = tendencies[state][c];
            moves = new ArrayList<Integer>();
            moves.add(c);
         } else if (tendencies[state][c] == max) {
            moves.add(c);
         }
      }
      int predictedUserMove = moves.get((int) (Math.random() * moves.size()));
      if (predictedUserMove == 0) {
         return 1;
      } else if (predictedUserMove == 1) {
         return 2;
      } else {
         return 0;
      }
   }
   
   public void record(int state, int userMove) {
      tendencies[state][userMove]++;
   }
}