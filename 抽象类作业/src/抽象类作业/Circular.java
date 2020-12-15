package 抽象类作业;

public class Circular extends Shape{
	double r;
	public Circular(String name,int x,int y,double r) {
		super(name,x,y);
		this.r=r;
	}
	public double getR() {
		return r;
	}
	public void setR(double r) {
		this.r = r;
	}
	public void set(String name,int x,int y,double r){
		super.set(name,x,y);
		this.r=r;
	}
	public double getArea(){
		return 3.14*r*r;
	}
	public void output() {
		System.out.println("圆的面积为："+getArea());
	}
}
