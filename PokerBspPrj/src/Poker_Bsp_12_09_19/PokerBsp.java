package Poker_Bsp_12_09_19;
import java.util.Random;
import java.util.Arrays;

public class PokerBsp {

	private static int handrange = 5;
	private int[] cards = new int[52];
	private int[] hand = new int[handrange];

	public void fill() {                           //Teil aus
		for (int i = 0; i <= 51; i++) {
			cards[i] = i;
		}
	}

	public void drawHand()
    {
        fill();
        for(int i = 0; i<handrange;i++)
        {
            int maxidx = cards.length - i -1;
            Random generator = new Random(System.currentTimeMillis());
            int random = generator.nextInt(52-i);
            
            hand[i]= cards[random];
            cards[random]=cards[maxidx];
            
        }
        decode();
    }
    private boolean[][] handMat= new boolean[4][13];
    public void decode()
    {

        for(int i=0;i<=hand.length-1;i++)
        {
           handMat[hand[i]/13][hand[i]%13]= true;       
        }

    }
    
  
    //Section 3 --- Analyze

    public boolean flush()
    {
        boolean i=false;
            int[] flush=new int[handrange];
            for(int j=0;j<handrange;j++)
             {
                flush[j]=hand[j]/13;
             }
             for(int j=0;j<handrange-1;j++)
             {

                 if(flush[j]==flush[j+1])
                 {
                    i=true;
                 }
                 else
                 {
                     i=false;
                     return i;
                 }
                 
            }
            return i;

    }
    public boolean straight()
    {
        boolean a=false;
        int[] sortet = new int [hand.length];
        for(int i=0;i<hand.length;i++)
        {
        sortet[i]=hand[i]%13;
        }
        Arrays.sort(sortet);                       
        for(int i=0;i<sortet.length-1;i++)
        {
            
            if((sortet[i]+1)==sortet[i+1])
            {
                a=true;
            }
            else
            {
                a=false;
                return a;
            }   
        }
        return a;
    }
    public boolean straightFlushCeck()
    {
        return flush()&& straight();
    }
    public boolean royalFlush()
    {
        return flush()&&straight()&&(hand[0]%13==7);
    }
   public boolean onePair()
    { 
        for(int i=0;i<13;i++)
        {
            int counter=0;
            for(int j=0;j<4;j++)
            {
                if(handMat[j][i])
                {
                    counter++;
                }
                if(counter==2)
                {  
                   return true;
                }
            }

        }
        return false;

   }
    public boolean tripple()
    {
       
        for(int i=0;i<13;i++)
        {
            int counter=0;
            for(int j=0;j<4;j++)
             {
                if(handMat[j][i])
                {
                    counter++;
                }
                if(counter==3)
                {  
                   return true;
                }
             }

        }
        return false;

    }
    public boolean squad()
    {
      
        for(int i=0;i<13;i++)
        {
            int counter=0;
            for(int j=0;j<4;j++)
             {
                if(handMat[j][i])
                {
                    counter++;
                }
                if(counter==4)
                {  
                   return true;
                }
             }

        }
        return false;
    }
    public boolean doublePair()
    {
        int pair=0;
       
        for(int i=0;i<13;i++)
        {
            int counter=0;
            for(int j=0;j<4;j++)
             {
                
                if(handMat[j][i])
                {
                    counter++;
                }
             }
             if(counter==2)
             {  
                pair++;
             }

        }
        if(pair==2)
        {
            return true;
        }
        return false;
    }
    public boolean fullHouse()
    {
        int pair=0;
        int tripple=0;
        for(int i=0;i<13;i++)
        {
            int counter=0;
            for(int j=0;j<4;j++)
             {
                
                if(handMat[j][i])
                {
                    counter++;
                }
             }
             if(counter==2)
             {  
                pair++;
             }
             if(counter==3)
             {
                 tripple++;
                 
             }


        }
        if(checkpairs()&&tripple==1)
        {
            return true;
        }
        return false;
    }
    public int pairs()
    {
        int[] amount = new int[13];
        for(int i=0;i<=hand.length-1;i++)
        {
           amount[hand[i]/13]++;       
        }
        int pairs = 0;
		for (int i = 0; i < 13; i++) {
			if (amount[i] >= 2) {
				pairs++;
            }
        }
        return pairs;
    }
    public boolean checkpairs()
    {
        if(pairs()==1)
        {
            return true;
        }
        return false;
    }
    public boolean ceckdoublepair()
    {
        if(pairs()==2)
        {
            return true;
        }
        return false;
    } 
    public int tripples()
    {
        int[] amount = new int[13];
        for(int i=0;i<=hand.length-1;i++)
        {
           amount[hand[i]/13]++;       
        }
        int tripples = 0;
		for (int i = 0; i < 13; i++) {
			if (amount[i] == 3) {
				tripples++;
            }
        }
        return tripples;
    }
    public int squads()
    {
        int[] amount = new int[13];
        for(int i=0;i<=hand.length-1;i++)
        {
           amount[hand[i]/13]++;       
        }
        int tripples = 0;
		for (int i = 0; i < 13; i++) {
			if (amount[i] == 4) {
				tripples++;
            }
        }
        return tripples;
    }
    public boolean checktripple()
    {
        if(tripples()==1)
        {
            return true;
        }
        return false;

    } 
    public boolean cecksquad()
    {
        if(squads()==1)
        {
            return true;
        }
        return false;

    } 
    
    
}   
