	import java.util.Random;

	public class RandomNumberFifty {
		
		final int MAX =4;
		final int TOTALQUESTION=4;
		int increment=0;
		
		Random r;
		
		private int getRandom[]=new int[MAX];
		

		public int[] getGetRandom() {
			return getRandom;
		}

		RandomNumberFifty()
		{
			r=new Random();
			while(increment<MAX)
			{
				for(int i=0;i<increment+1;i++)
				{
					for(int j=0;j<increment+1;j++)
					{
						
					int k=r.nextInt(TOTALQUESTION)+1;
					
					if(increment==0)
					{
						
						if(increment<MAX)
						{
							getRandom[increment]=k;
						increment++;
						
						break;
						}
						
					}
					else if(isExist(k) )
					{
						if(increment!=MAX)
						{
						
						if(increment<MAX)
						{
							getRandom[increment]=k;
						increment++;
						
						break;
						
						}
						}
						else
						{
						return;

						}
					}

					}
					}
				}
			
		}
		
		public boolean isExist(int a)
		{
			boolean result=true;
			for(int i=0;i<increment;i++)
			{
				if(getRandom[i]==a)
				{
					result=false;
					break;
				}
			}
			return result;
		}
		public void printArray()
		{
			for(int i=0;i<MAX;i++)
			{
				System.out.println(getRandom[i]);
			}
		}


	}



