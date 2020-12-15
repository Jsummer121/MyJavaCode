//3）第三个类是矩形类（Rectangle）继承自图形类，含有两个double类型的成员变量长a和宽b,
//有一个有三个参数的构造方法，来初始化颜色、长和宽，一个方法getArea，返回值为double，获取矩形的面积值。
package 实验五;

public class Rectangle extends Shape{
	double a,b;
	Rectangle(String color,double a,double b){
		super(color);
		this.a=a;
		this.b=b;
	}
	public double getArea() {
		return a*b;
	}

}
