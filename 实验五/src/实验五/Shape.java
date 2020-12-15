//1）第一个类是图形类（Shape），含有一个成员变量color（字符串类型），一个没有参数的构造方法，
//以及一个有一个字符串类型参数的构造方法来初始化颜色变量，还有一个返回颜色变量值的成员方法show，以及一个抽象方法getArea获取面积，
//返回值为double类型；
package 实验五;

public abstract class Shape {
	String color;
	Shape(){};
	Shape(String color){
		this.color=color;
	}
	public String show() {
		return color;
	}
	public abstract double getArea();
}
