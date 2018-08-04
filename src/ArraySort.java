import java.io.BufferedReader;


import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class ArraySort {
	
	public void Swap(int A[],int i,int j)
	{
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
		int array[] = new int[10];
		int[] ar = new int[10];
	}
	/*
	 * 冒泡排序
	 */
	void BubbleSort(int A[],int n)
	{
		for(int j=0;j<n-1;j++)
		{
			for(int i=0;i<n-1-j;i++)
			{
				if(A[i]>A[i+1])
					Swap(A,i,i+1);
			}
		}
		
	}
	public static void main(String[] args)
	{
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		
		try {
			File file = new File("IntegerArray.txt");
			BufferedReader br = new BufferedReader(new FileReader(file));
			String s = null;
			while((s=br.readLine())!=null)
			{
				int num = Integer.parseInt(s);
				list.add(num);
			}
			
			int len = list.size();
			int A[] = new int[len];
			int B[] = new int[len];
			int C[] = new int[len];
			int D[] = new int[len];
			for(int i=0;i<len;i++)
			{
				A[i] = list.get(i);
				B[i] = list.get(i);
				C[i] = list.get(i);
				D[i] = list.get(i);
			}
			
//			int A[] = {3,5,6,43,2,4,6,7};
//			int len = A.length;
			ArraySort bubblesort = new ArraySort();
			long startTime1 = System.currentTimeMillis();
			bubblesort.BubbleSort(A, len);
			long endTime1=System.currentTimeMillis();
			System.out.println("冒泡排序运行时间："+(endTime1-startTime1)+"ms");
		
			
			QuickSort quicksort = new QuickSort();
			long startTime2 = System.currentTimeMillis();
			quicksort.QuickSort(B,0,len-1);
			long endTime2=System.currentTimeMillis();
			System.out.println("快排运行时间："+(endTime2-startTime2)+"ms");
			
//			
			SelectSort selectsort = new SelectSort();
			long startTime3 = System.currentTimeMillis();
			selectsort.SelectSort(C, len);
			long endTime3=System.currentTimeMillis();
			System.out.println("选择排序运行时间："+(endTime3-startTime3)+"ms");
//			
//
			Mergesort mergesort = new Mergesort();
			long startTime4 = System.currentTimeMillis();
			mergesort.sort(D);
			long endTime4=System.currentTimeMillis();
			System.out.println("归并排序运行时间："+(endTime4-startTime4)+"ms");
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
	}
}

/**
 * 快排
 * @author liuhongyang
 *
 */
class QuickSort
{
		public void Swap(int A[],int i,int j)
		{
			int temp = A[i];
			A[i] = A[j];
			A[j] = temp;
		}
		//快排序运用分治思想
		public int Partition(int A[],int left,int right)
		{
			int pivot  = A[right];//将数组最后一个元素作为指定基准元素pivot
			int head = left-1;//作为整个数组的最前面一个元素位置
			for(int i= left;i<right;i++ )
			{
				if(A[i]<pivot)
				{
					
					Swap(A,++head,i);
					//调用函数交换位置
				}
			}
			//执行到最后时，交换基准元素
			
			Swap(A,head+1,right);
			
			return head+1;//返回基准的索引
		}
		
		void QuickSort(int A[],int left,int right)
		{
			if(left>right)
				return;
			int pivot_index =Partition(A,left,right);//基准索引
			QuickSort(A,left,pivot_index-1);
			QuickSort(A,pivot_index+1,right);
			
		}		
}
/**
 * 选择排序
 * @author liuhongyang
 *
 */
class SelectSort
{
	public void Swap(int A[],int i,int j)
	{
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
	void SelectSort(int A[],int n)
	{
		for(int i=0;i<n-1;i++)
		{
			int min = i;//让第一值为最小值
			for(int j=i+1;j<n;j++)
			{
				if(A[j]<A[min])
				{
					min = j;
				}
			}
			if(min != i)
			{
				Swap(A,min,i);
			}
		}
		
	}
	
}
/**
 * 归并排序
 * @author liuhongyang
 *
 */
class Mergesort
{
		//创建一个数组，用于存储最后的结果
		void sort(int A[])
		{
			int temp[]  = new int[A.length];
			Sort(A,0,A.length-1,temp);
			
			
		}
		void Sort(int A[],int left,int right,int temp[])
		{
			if(left<right)
			{
				int mid = (left+right)/2;
				Sort(A,left,mid,temp); //左边归并排序，使得左子序列有序
				Sort(A,mid+1,right,temp);//右边归并排序，使得右子序列有序
				merge(A,left,mid,right,temp);
			}
		}
		void merge(int A[],int left,int mid,int right,int temp[])
		{
			//1在未抵达终点时
			//	如果左边比右边小，则将左边添加进去，否则将右边添加进去;
			//2在抵达终点时
			//	谁先抵达将剩余的拷贝回去
			int i = left;
			int j = mid+1;
			int t=0;
			while(i<=mid&&j<=right)
			{
				if(A[i]<=A[j])
				{
					temp[t++]=A[i++];
				}else
				{
					temp[t++]=A[j++];
				}
			}
			while(i<=mid)
			{
				temp[t++] = A[i++];
			}
			while(j<=right)
			{
				temp[t++] = A[j++];
			}
			t = 0;
			//将数组拷回原数组中
			while(left<=right)
			{
				A[left++] = temp[t++];
			}
			
		}
}