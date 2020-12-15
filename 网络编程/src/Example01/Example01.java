package Example01;

import java.net.InetAddress;

/*
 * InetAddress类的常用方法
 */
public class Example01 {
	public static void main(String[] args) throws Exception {
		//获取ip地址对象
		InetAddress localAddress = InetAddress.getLocalHost();//返回当前主机的ip地址对象
		InetAddress remoteAddress = InetAddress.getByName("www.itchat.cn");//返回指定名称的IP地址对象
		System.out.println("本机的ip地址为："+localAddress.getHostAddress());
		System.out.println("itcast的IP地址："+remoteAddress.getHostAddress());
		System.out.println("3秒是否可达："+remoteAddress.isReachable(3000));
		System.out.println("获取本机的主机名："+localAddress.getHostName());
		InetAddress dreamspyAddress = InetAddress.getByName("106.13.180.138");
		System.out.println("云服务器的ip地址的主机名为："+dreamspyAddress.getHostName());
		System.out.println("云服务器的ip地址为："+dreamspyAddress.getAddress());
		InetAddress baiduAddress = InetAddress.getByName("180.76.76.76");
		System.out.println("百度的主机名为："+baiduAddress.getHostName());
		System.out.println("baidu的ip地址为："+baiduAddress.getHostAddress());
	}
}
