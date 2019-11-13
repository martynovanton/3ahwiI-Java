package Poker_Bsp_12_09_19;
import java.util.Scanner;

public class PokerHaupt {


		public static void main(String[] args) {
			long timeNeed=0;
			Scanner s = new Scanner(System.in);
			System.out.println("Geben Sie die Anzahl der Versuche ein, je höher desto genauer und desto länger braucht das Programm");
			int analytictimes= s.nextInt();
			
			Statistik Game = new Statistik(analytictimes);
			timeNeed=System.currentTimeMillis();
			Game.analyse();
			Game.output();
			timeNeed= System.currentTimeMillis()-timeNeed;
			System.out.printf("%d ms",timeNeed);
			System.out.println();
			s.close();
		}


}
