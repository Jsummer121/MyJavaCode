//����Circular��̳�Shape������Բ�İ뾶r���ԣ����幹�췽����public void setR()������public doublegetR(double r)������
//���ظ���set���������Ǹ���output������ʵ�ָ���������ĳ��󷽷���
//������Demo������main��������main�����ж���Բ�Ķ��󣬵�����ط������Բ����Ϣ�������
package 抽象类作业;
public class Demo {
	public static void main(String[] agrs) {
		Circular circle=new Circular("Բ��",1,2,4);
		circle.output();
		circle.set("Բ��",2,4,7);
		circle.output();
		circle.setR(6);
		circle.output();
	}
}
