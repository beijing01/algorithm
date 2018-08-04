
public class Dijkstra {
	/**
	 * 
	 * v
	 * a 边权
	 * dist 最短路径
	 * prev 从源到顶点i的最短路径
	 */
	
	//每次寻找源点到i的相对s的最短路径
	public static void main(String[] args)
	{
		//a：构造二维矩阵表示矩阵边权
		float[][] a = new float[6][6];
		for(int i=0;i<a.length;i++)
			for(int j=0;j<a.length;j++)
				a[i][j] = Float.MAX_VALUE;
		//输入顶点件距离
		a[1][2]=10;
		a[1][4]=30;
		a[1][5]=100;
		a[2][3]=50;
		a[3][5]=10;
		a[4][5]=60;
		a[4][3]=20;
		//源点
		int v = 1;
		//dist 记录源到其它所有顶点之间的最短路径长度
		float [] dist = new float[6];
		//记录的是从源到顶点i的最短路径上i的前一个顶点。
		int [] prev = new int[6];
		
		dijkstra(v,a,dist,prev);
	}
	public static void dijkstra(int v,float [][] a,float [] dist,int [] prev)
	{
		
		int n = dist.length-1;
		if(v<1||v>n) return;
		//记录点是否在s集合
		boolean [] s = new boolean[n+1];
		//初始化数据
		for(int i=1;i<=n;i++)
		{
			dist[i]=a[v][i];
			s[i]=false;
			if(dist[i]==Float.MAX_VALUE) prev[i] = 0;
			
		}
		dist[v]=0;s[v]=true;
		for(int i=1;i<n;i++)
		{
			float temp=Float.MAX_VALUE;
			int u =  v;
			//从v-s中取相对s的最短路径顶点j
			for(int j=1;j<=n;j++)
				if((!s[j])&&(dist[j])<temp)
				{
					u =j;
					temp = dist[j];
				}
			//将u点加入s集合中
			s[u] = true;
			
			for(int j=1;j<=n;j++)
				if((!s[j])&&(a[u][j])<Float.MAX_VALUE)
				{
					//瑞国比当前值小，更新距离，将u添加到前置节点
					float newdist = dist[u]+a[u][j];
					if(newdist<dist[j])
					{
						dist[j] = newdist;
						prev[j] = u;
					}
				}
		}
		for(int i=2;i<6;i++)
			System.out.println("源点到"+i+"的最短路径为"+dist[i]);
	}
}
