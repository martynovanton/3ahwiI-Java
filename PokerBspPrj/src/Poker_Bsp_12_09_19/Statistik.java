package Poker_Bsp_12_09_19;


public class Statistik {
	 private double analyticTimes;
	    private double highcardCounter=0;
	    private double pairCounter=0;
	    private double trippleCounter=0;
	    private double squadCounter=0;
	    private double doublePairCounter=0;
	    private double fullHouseCounter=0;
	    private double flushCounter=0;
	    private double straightCounter=0;
	    private double straightflushCounter=0;
	    private double royalflush=0;

		public Statistik(double analyticTimes) {
			this.analyticTimes = analyticTimes;
		}


	    public void analyse()
	    {
	        for(int i=0;i<analyticTimes;i++)
			{
				PokerBsp gg =new PokerBsp(); 
				boolean abbr= true;
				gg.drawHand();
				
				if(gg.royalFlush() && abbr)
				{
					royalflush++;
					abbr=false;
				}
				if(gg.straightFlushCeck() && abbr)
				{
					straightflushCounter++;
					abbr=false;
				}
				if(gg.squad()&& abbr){
					
					squadCounter++;
					abbr=false;
				}
				if(gg.flush() && abbr)
				{
					flushCounter++;
					abbr=false;
				}
				if(gg.straight() && abbr)
				{
					straightCounter++;
					abbr=false;
				}

				if(gg.fullHouse()&& abbr)
				{
					fullHouseCounter++;
					abbr=false;
				}
				if(gg.doublePair()&& abbr)
				{
					doublePairCounter++;
					abbr=false;
				}
				if(gg.tripple()&& abbr)
				{
					trippleCounter++;
					abbr=false;
				}
				if(gg.checkpairs()&& abbr)
				{
					pairCounter++;
					abbr=false;
				}
				if(abbr)
				{
					highcardCounter++;
					abbr= false;
				}
	        }
	    }    
	    public void output()
	    {
	        System.out.print("Anzahl an Versuche:");
			System.out.println(analyticTimes);
			System.out.print("Gesamtanzahl:");
			System.out.println(flushCounter+straightCounter+straightflushCounter+pairCounter+trippleCounter+royalflush+doublePairCounter+highcardCounter+fullHouseCounter+squadCounter);
			System.out.printf("Flush:%f",(flushCounter*100)/analyticTimes);
			System.out.println("%");
			System.out.printf("Straight:%f",(straightCounter*100)/analyticTimes);
			System.out.println("%");
			System.out.printf("Pairs:%f",((highcardCounter*100)/analyticTimes));
			System.out.println("%");
			System.out.printf("Tripple: %f",(trippleCounter*100)/analyticTimes);
			System.out.println("%");
			System.out.printf("RoyalFlush: %f",(royalflush*1000)/analyticTimes);
			System.out.println("%");
			System.out.printf("Doublepair: %f",(doublePairCounter*100)/analyticTimes);
			System.out.println("%");
			System.out.printf("HighCard: %f",(pairCounter*100)/analyticTimes);
			System.out.println("%");
			System.out.printf("Fullhouse: %f",(fullHouseCounter*100)/analyticTimes);
			System.out.println("%");
			System.out.printf("Squad: %f",(squadCounter*100)/analyticTimes);
			System.out.println("%");
			System.out.printf("StraightFlush: %f", ((straightflushCounter+royalflush)*100)/analyticTimes);
			System.out.println("%");
	    }

}
