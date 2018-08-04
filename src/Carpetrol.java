
//若在a[i]加油站加油，则b[i]=1,否则为0
public class Carpetrol{
	/**
	 * n:加满油后行驶里程
	 * k:加油站个数，应该比实际个数少1
	 * i:第i个加油站
	 * m:最少加油次数
	 */
	public static void car(int[] a,int k,int n)
	{
		int i=0,count = 0,m=0;
		boolean isSolution = true;
		int[] b = new int[k+1];
		b[0] = 1;
		i=0;
		m=1;//m记录最少的加油次数
		while(i<k)
		{
			if(a[i]>n)
			{
				isSolution = false;
				break;
			}
			count+=a[i];
			if(count>n)
			{
				b[i]=1;//记录最优解
				count=0;
				m++;
			}
			else
			{
				i++;
				b[i]=0;
			}
		}
		System.out.println("加油次数为："+m);
		int num = 1;
		for(int item:b)
		{
			
			if(item==1)
				System.out.println("第"+num+ "个加油站加油");
			else
				System.out.println("第"+num+ "个加油站掠过");
			//System.out.println(item);
			num++;
		}
			
	}
	
	public static void main(String[] args)
	{
		int a[]={3,5,6,7,5};
		
		int k = 5;
		car(a,k,8);
		
	}
	
	
}
