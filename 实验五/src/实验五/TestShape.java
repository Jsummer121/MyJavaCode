package 实验五;

public class TestShape {

	public static void main(String[] args) {
		Circle circle=new Circle("圆形",5);
		Rectangle rectangle=new Rectangle("矩形",3,4);
		circle.show();
		rectangle.show();
		double area1 = circle.getArea();
		double area2 = rectangle.getArea();
		System.out.println("圆形的面积为："+area1);
		System.out.println("矩形的面积为："+area2);
	}

}
