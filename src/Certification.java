class Certification {

	
	
		private long val;
		public Certification(long v)
		{
		val=v;
		}
		public static void main(String args[])
		{
			Certification x=new Certification(10L);
			Certification y=new Certification(10L);
			Certification z=y;
			long a=10L;
			int b=10;
			System.out.println(x);
			System.out.println(y);
			System.out.println(z);
	}
}
