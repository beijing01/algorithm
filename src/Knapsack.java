
public class Knapsack {
	public static void main(String[] args)
	{
		
		int w[] = {2,2,6,5,4};
		int v[] = {6,3,5,4,6};
		int num = 5;
		int C=10;
		//V[i][j]表示将前i个物品装入容量为j的午评所获得的最大价值
		int V[][] = FindMax(num,C,w,v);
		
		//输出结果
		for (int i = 1; i <=num; i++)
		{
			for (int j = 1; j <=C; j++)
			{
				System.out.print(V[i][j]+"\t");
	            	if(j==C)
	            	{
	                    System.out.println();
	                }
	         }
	      }
			FindWhat(5,10,V,w,v);
	}
	
		
	
	
	public static int[][] FindMax(int num,int C,int[] w,int[] v)
	{
		int V[][] = new int[num+1][C+1];
		for (int i = 0; i < num + 1; i++)
            V[i][0] = 0;
        for (int j = 0; j < C + 1; j++)
            V[0][j] = 0;
        
		int i,j;
		for(i=1;i<=num;i++)
		{
			for(j=1;j<=C;j++)
			{
				if(j<w[i-1])//此时包无法装入
				{
					V[i][j]=V[i-1][j];
				}
				else
				{
					if(V[i-1][j]>V[i-1][j-w[i-1]]+v[i-1])//不装价值大
					{
						V[i][j] = V[i-1][j];
					}else//装价值大
					{
						V[i][j] = V[i-1][j-w[i-1]]+v[i-1];
					}
				}
			}
		}
		return V;
	}
	
	public static void FindWhat(int i,int j,int[][] V,int w[],int v[])
	{
		int item[] = new int [5];
		
		if(i>=1)
		{
			if(V[i][j]==V[i-1][j])//未被选中
			{
				item[i-1] =0;
				System.out.println("第"+i+"未被选中"+item[i-1]);
				FindWhat(i-1,j,V,w,v);
				
			}
			else if(j>w[i-1]&&V[i][j]==V[i-1][j-w[i-1]]+v[i-1])
			{
				item[i-1] = 1;//标记已经装
				System.out.println("第"+i+"被选中"+item[i-1]);
				FindWhat(i-1,j-w[i-1],V,w,v);
				
			}
		}
		
		
	}
}
