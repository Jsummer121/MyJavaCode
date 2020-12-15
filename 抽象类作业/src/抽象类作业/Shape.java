//定义抽象类Shape，包含名称、x,y坐标属性，拥有构造方法，set方法，output方法和一个求面积的抽象方法。
package 抽象类作业;

public abstract class Shape{
	//定义形状的名称与坐标
	String name;
	int x,y;
	Shape(){
		x=0;
		y=0;
	}
	Shape(String name,int x,int y){
		this.name=name;
		this.x=x;
		this.y=y;
	}
	Shape(int x,int y){
		this.x=x;
		this.y=y;
	}
	public void set(String name,int x,int y){
		this.name=name;
		this.x=x;
		this.y=y;
	}
	public void output() {
		System.out.println("图形的名称为："+name);
		System.out.println("图像的坐标为："+"("+x+","+y+")");
	}
	public abstract double getArea();
}