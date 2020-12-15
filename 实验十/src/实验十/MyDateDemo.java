package 实验十;

class MyDateDemo
{
    int year, month, day;
    void set(int y, int m, int d)
    {
     try{
		 if (m<1|| m>12)  throw new Exception("月份错误！");
		 year = y;
         month = m;
         day = d;
	      }
	    catch (Exception e) {
			this.year=2000;
			this.month=1; 
			this.day=1;
			System.out.println(e.getMessage());//输出异常信息
           System.out.println("\n日期错误"); }
     }
    public  String  toString()
      {  return year+"年"+month+"月"+day+"日";  }
    
    
    public static void main(String args[])
    {
	      MyDateDemo d1 = new MyDateDemo();
	      d1.set(2013,17,16);
	      System.out.println("经设置后日期为："+d1);
    }
}
