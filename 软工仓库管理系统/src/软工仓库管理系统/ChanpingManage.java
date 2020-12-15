package 软工仓库管理系统;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.*;


public class ChanpingManage extends JPanel implements ActionListener{
	JTable bgTable;
	ProductInfo  proinfo1;

	public ChanpingManage() {
		/**
		 * 产品管理页面
		 */
		//添加表格
		proinfo1=new ProductInfo();
		bgTable=new JTable(proinfo1);

		JScrollPane gdScrollPane=new JScrollPane(bgTable);
		//产品管理弹出菜单
		final JPopupMenu popupMenu=new JPopupMenu();
		JMenu jMenu=new JMenu("菜单");
		JMenuItem  jMenuItem[]={new JMenuItem("查看详情"),new JMenuItem("刷新"),new JMenuItem("添加商品"),
				new JMenuItem("产品进货"),new JMenuItem("产品出货"),new JMenuItem("退出")};
		for (int i = 0; i <2; i++) {
			popupMenu.add(jMenuItem[i]);
		}
		popupMenu.addSeparator();
		for (int i = 2; i <5 ; i++) {
			popupMenu.add(jMenuItem[i]);	
		}
		popupMenu.addSeparator();
		popupMenu.add(jMenuItem[5]);
		jMenuItem[0].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				//查看详情
				int xz=bgTable.getSelectedRow();
				if (xz==-1) {
					JOptionPane.showMessageDialog(null, "请选中你想要查看的商品");
				}else {
					new Detail(proinfo1, xz);

				}
			}
		});
		jMenuItem[1].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				//刷新
				proinfo1=new ProductInfo();
				bgTable.setModel(proinfo1);
			}
		});
		jMenuItem[2].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				//添加商品
				new TianJia(); 

			}
		});
		jMenuItem[3].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				//产品进货
				final int xz3=bgTable.getSelectedRow();
				if (xz3==-1) {
					JOptionPane.showMessageDialog(null, "你选中你要进货的商品");
					return;
				}
				new AddCargob(proinfo1, xz3);
				proinfo1=new ProductInfo();
				bgTable.setModel(proinfo1);
			}
		});
		jMenuItem[4].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// 产品出货
				int xz3=bgTable.getSelectedRow();
				if (xz3==-1) {
					JOptionPane.showMessageDialog(null, "请选中你要出货的商品");
					return;
				}else {
					new GoCargob(proinfo1,xz3);
				}

			}
		});
		//退出产品管理菜单
		jMenuItem[5].addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				popupMenu.show(false);
			}
		});
		bgTable.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					popupMenu.show(true);
					popupMenu.show(e.getComponent(),e.getX(),e.getY());
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				mousePressed(e);
			}
		});
		//按钮组件
		JButton addButton=new JButton("添加产品");
		addButton.addActionListener(this);
		addButton.setActionCommand("tianjia");
		JButton deletButton=new JButton("删除产品");
		deletButton.addActionListener(this);
		deletButton.setActionCommand("shanchu");
		JButton addcargobButton=new JButton("产品进货");
		addcargobButton.addActionListener(this);
		addcargobButton.setActionCommand("jinhuo");
		JButton gocargoButton=new JButton("产品出货");
		gocargoButton.addActionListener(this);
		gocargoButton.setActionCommand("chuhuo");
		//将表格和按钮组合一起
		JPanel mb2=new JPanel();
		JPanel mb1=new JPanel();
		mb1.add(gdScrollPane);
		mb2.add(addButton);mb2.add(deletButton);mb2.add(addcargobButton);mb2.add(gocargoButton);
		//设置此选项卡的布局
		this.setLayout(new FlowLayout());
		this.add(mb1);this.add(mb2);
		//this.setSize(450,500);
	}
	
	
	/**
	 * 执行删除产品
	 * @param xz现行选中行
	 */
	public void deleteproduct (int xz) {
		java.sql.Connection connection=null;
		java.sql.Statement statement=null;
		PreparedStatement preparedStatement=null;
		String st=(String)proinfo1.getValueAt(xz,0);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://106.13.180.138/IWMS?serverTimezone=UTC&useSSL=false&useUnicode=true&characterEncoding=utf8";
			String userString="july";
			String passwString="july";
			connection=DriverManager.getConnection(url,userString,passwString);
			statement=connection.createStatement();
			//动态删除选中项
			preparedStatement=connection.prepareStatement("delete from productinfo where id=?");
			preparedStatement.setString(1,st);
			preparedStatement.executeUpdate();		
			JOptionPane.showMessageDialog(null, "删除成功");
			proinfo1=new ProductInfo();
			bgTable.setModel(proinfo1);
			connection.close();
			statement.close();
		}catch (Exception e) {
			e.printStackTrace();
		}

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		int xz1=this.bgTable.getSelectedRow();
		//添加产品
		if(e.getActionCommand().equals("tianjia")){
			TianJia tianJia=new TianJia();
			proinfo1=new ProductInfo();
			bgTable.setModel(proinfo1);
		}
		//删除产品
		else if (e.getActionCommand().equals("shanchu")) {
			xz1=this.bgTable.getSelectedRow();
			//判断是否选中
			if(xz1==-1){
				JOptionPane.showMessageDialog(null, "请选中你要删除的产品");
				return;
			}else {
				//开始删除产品
				if (JOptionPane.showConfirmDialog(null, "确认删除此产品？")==JOptionPane.YES_OPTION) {
					deleteproduct(xz1);
				}else {
					return;
				}					
			}

			//产品进货
		}else if (e.getActionCommand().equals("jinhuo")) {
			int xz3=this.bgTable.getSelectedRow();
			if (xz3==-1) {
				JOptionPane.showMessageDialog(null, "你选中你要进货的商品");
			}
			new AddCargob(proinfo1, xz3);
			proinfo1=new ProductInfo();
			bgTable.setModel(proinfo1);

		}else if (e.getActionCommand().equals("chuhuo")) {
			int xz3=this.bgTable.getSelectedRow();
			if (xz3==-1) {
				JOptionPane.showMessageDialog(null, "请选中你要出货的商品");
				return;
			}else {
				new GoCargob(proinfo1,xz3);
			}
		}

	}
	
}
