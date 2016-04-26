package atm;

public class CashManager {
		
		private static final int[] notes = {200, 100, 50, 20, 10};	
		private static final int[] initialCount = {0, 5, 30, 50, 10};
		private int[] currentCount = {0, 0, 0, 0, 0};
        private int[] tempCount = {0,0, 0, 0, 0};
		
		CashManager()
		{
			for(int i = 0; i < notes.length; i++)
			{
				currentCount[i] = initialCount[i];
			}
		}
		
		public boolean isCashAvailable(int amount)
		{	
            int totalCash = (currentCount[3] * 10) + (currentCount[2] * 20) + (currentCount[1] * 50) + (currentCount[0] * 100);
			
			if(amount <= totalCash)
			{
				int currentAmount = amount;
				
				for(int i = 0; i < notes.length; i++)
				{
					tempCount[i] = currentAmount / notes[i];
					
					if(currentCount[i] >= tempCount[i])
					{
						currentAmount -= notes[i] * tempCount[i];
					}		
				}
	
				if(currentAmount == 0)
				{
					return true;
				}
				else return false;
			}
			else return false;
		}
		
		public void decrementCounters(int amount)
		{	
			for(int i = 0; i < notes.length; i++)
			{
				currentCount[i] -= amount / notes[i];
			}	
		}
		
		public boolean ensureAmountPermitted(int amount)
		{
			for(int i = 0; i < notes.length; i++)
			{
				if(amount == notes[i] || amount == 200)
				{
					return true;
				}
			}			
			return false;			
		}
}
