//2）第二个类是圆形类（Circle）继承自图形类，含有一个成员变量半径r，
//有一个有两个参数的构造方法，来初始化颜色和半径，一个方法getArea，返回值为double，获取圆的面积值。
package 实验五;

public class Circle extends Shape {
	double r;
	Circle(String color,double r){
		super(color);
		this.r=r;
	}
	public double getArea() {
		return 3.14*r*r;
	}
}
