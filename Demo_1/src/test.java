public class test{
	public static void main(String[] args){
		int[][] arr = new int[3][];//定义一个长度为3的二维数组
		arr[0] = new int[]{11,12};
		arr[1] = new int[]{14,25,15};
		arr[2] = new int[]{51,125,124};
		int sum = 0;//定义变量记录总销售额
		for(int i=0;i<arr.length;i++){
			int groupSum = 0;//记录每小组的销售额
			for(int j=0;j<arr[i].length;j++){
				groupSum+=arr[i][j];
			}
			sum+=groupSum;
		}
		System.out.println("总销售额为："+sum+"万元");
	}
}