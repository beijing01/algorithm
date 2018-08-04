
public class LCS {
	public static void main(String[] args)
	{
		String x[] ={"","x","y","x","z","y","x","y","z","z","y"};
		String y[] = {"","x","z","y","z","x","y","z","x","y","z","x","y"};
		
		int[][] b = getLength(x,y);
		Display(b,x,x.length-1,y.length-1);
		
	}
	public static int[][] getLength(String[] x,String[] y)
	{
		int [][] m = new int[x.length][y.length];
		int [][] b = new int[x.length][y.length];
		for(int i=1;i<x.length;i++)
		{
			for(int j=1;j<y.length;j++)
			{
				//如果x[i] = y[j]，忘左上一栋一格
				if(x[i]==y[j])
				{
					m[i][j] = m[i-1][j-1]+1;
					b[i][j] = 1;
				}
				//如果往左移动一格
				else if(m[i-1][j]>=m[i][j-1])
				{
					m[i][j] = m[i-1][j];
					b[i][j] = 0;
				}
				//如果往上移动一格
				else
				{
					m[i][j] = m[i][j-1];
					b[i][j] = -1;
				}
			}
		}
		return b;
	}
	public static void Display(int [][]b,String [] x,int i,int j)
	{
		if(i==0||j==0)
		{
			return ;
		}
		if(b[i][j]==1)
		{
			Display(b,x,i-1,j-1);
			System.out.print(x[i]+" ");
		}
		else if(b[i][j]==0)
		{
			Display(b,x,i-1,j-1);
		}else if(b[i][j]==-1)
		{
			Display(b,x,i,j-1);
		}
	}
}
