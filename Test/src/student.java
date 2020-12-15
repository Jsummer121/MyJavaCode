//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.beans.Statement;
//import java.sql.Connection;
//
//import javax.swing.JOptionPane;
//
//public class student extends javax.swing.JFrame implements ActionListener{
//
//	public student() {
//		initComponents();
//	}
//
//	void setmyLayout(){
//		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
//		getContentPane().setLayout(layout);
//		layout.setHorizontalGroup(layout.createParallelGroup(
//								javax.swing.GroupLayout.Alignment.LEADING)
//						.addGroup(
//								layout
//										.createSequentialGroup()
//										.addGroup(
//												layout
//														.createParallelGroup(
//																javax.swing.GroupLayout.Alignment.LEADING)
//														.addGroup(
//																layout
//																		.createSequentialGroup()
//																		.addContainerGap()
//																		.addComponent(
//																				jLabel1)
//																		.addGap(
//																				18,
//																				18,
//																				18)
//																		.addComponent(
//																				inputid,
//																				javax.swing.GroupLayout.PREFERRED_SIZE,
//																				175,
//																				javax.swing.GroupLayout.PREFERRED_SIZE)
//																		.addGap(
//																				18,
//																				18,
//																				18)
//																		.addComponent(
//																				bquery))
//														.addComponent(
//																jSeparator1,
//																javax.swing.GroupLayout.DEFAULT_SIZE,
//																454,
//																Short.MAX_VALUE)
//														.addGroup(
//																layout
//																		.createSequentialGroup()
//																		.addContainerGap()
//																		.addGroup(
//																				layout
//																						.createParallelGroup(
//																								javax.swing.GroupLayout.Alignment.LEADING)
//																						.addComponent(
//																								jLabel2)
//																						.addComponent(
//																								jLabel3)
//																						.addComponent(
//																								jLabel4)
//																						.addComponent(
//																								jLabel5)
//																						.addComponent(
//																								jLabel6))
//																		.addGap(
//																				41,
//																				41,
//																				41)
//																		.addGroup(
//																				layout
//																						.createParallelGroup(
//																								javax.swing.GroupLayout.Alignment.LEADING)
//																						.addGroup(
//																								layout
//																										.createSequentialGroup()
//																										.addComponent(
//																												jComboBox2,
//																												javax.swing.GroupLayout.PREFERRED_SIZE,
//																												javax.swing.GroupLayout.DEFAULT_SIZE,
//																												javax.swing.GroupLayout.PREFERRED_SIZE)
//																										.addGap(
//																												18,
//																												18,
//																												18)
//																										.addComponent(
//																												jLabel7)
//																										.addPreferredGap(
//																												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
//																										.addComponent(
//																												jComboBox3,
//																												javax.swing.GroupLayout.PREFERRED_SIZE,
//																												javax.swing.GroupLayout.DEFAULT_SIZE,
//																												javax.swing.GroupLayout.PREFERRED_SIZE))
//																						.addComponent(
//																								jComboBox1,
//																								javax.swing.GroupLayout.PREFERRED_SIZE,
//																								javax.swing.GroupLayout.DEFAULT_SIZE,
//																								javax.swing.GroupLayout.PREFERRED_SIZE)
//																						.addGroup(
//																								layout
//																										.createSequentialGroup()
//																										.addComponent(
//																												jRadioButton1)
//																										.addGap(
//																												18,
//																												18,
//																												18)
//																										.addComponent(
//																												jRadioButton2))
//																						.addGroup(
//																								layout
//																										.createParallelGroup(
//																												javax.swing.GroupLayout.Alignment.LEADING,
//																												false)
//																										.addComponent(
//																												textname)
//																										.addComponent(
//																												textno,
//																												javax.swing.GroupLayout.DEFAULT_SIZE,
//																												174,
//																												Short.MAX_VALUE))))
//														.addComponent(
//																jSeparator2,
//																javax.swing.GroupLayout.DEFAULT_SIZE,
//																454,
//																Short.MAX_VALUE)
//														.addGroup(
//																layout
//																		.createSequentialGroup()
//																		.addContainerGap()
//																		.addComponent(
//																				badd)
//																		.addGap(
//																				40,
//																				40,
//																				40)
//																		.addComponent(
//																				bedit)
//																		.addGap(
//																				49,
//																				49,
//																				49)
//																		.addComponent(
//																				bdelete)))
//										.addContainerGap()));
//		layout
//				.setVerticalGroup(layout
//						.createParallelGroup(
//								javax.swing.GroupLayout.Alignment.LEADING)
//						.addGroup(
//								layout
//										.createSequentialGroup()
//										.addGap(24, 24, 24)
//										.addGroup(
//												layout
//														.createParallelGroup(
//																javax.swing.GroupLayout.Alignment.BASELINE)
//														.addComponent(jLabel1)
//														.addComponent(
//																inputid,
//																javax.swing.GroupLayout.PREFERRED_SIZE,
//																javax.swing.GroupLayout.DEFAULT_SIZE,
//																javax.swing.GroupLayout.PREFERRED_SIZE)
//														.addComponent(bquery))
//										.addPreferredGap(
//												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//										.addComponent(
//												jSeparator1,
//												javax.swing.GroupLayout.PREFERRED_SIZE,
//												10,
//												javax.swing.GroupLayout.PREFERRED_SIZE)
//										.addPreferredGap(
//												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//										.addGroup(
//												layout
//														.createParallelGroup(
//																javax.swing.GroupLayout.Alignment.BASELINE)
//														.addComponent(jLabel2)
//														.addComponent(
//																textno,
//																javax.swing.GroupLayout.PREFERRED_SIZE,
//																javax.swing.GroupLayout.DEFAULT_SIZE,
//																javax.swing.GroupLayout.PREFERRED_SIZE))
//										.addPreferredGap(
//												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//										.addGroup(
//												layout
//														.createParallelGroup(
//																javax.swing.GroupLayout.Alignment.LEADING)
//														.addComponent(jLabel3)
//														.addComponent(
//																textname,
//																javax.swing.GroupLayout.PREFERRED_SIZE,
//																javax.swing.GroupLayout.DEFAULT_SIZE,
//																javax.swing.GroupLayout.PREFERRED_SIZE))
//										.addPreferredGap(
//												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//										.addGroup(
//												layout
//														.createParallelGroup(
//																javax.swing.GroupLayout.Alignment.LEADING)
//														.addComponent(jLabel4)
//														.addGroup(
//																layout
//																		.createParallelGroup(
//																				javax.swing.GroupLayout.Alignment.BASELINE)
//																		.addComponent(
//																				jRadioButton1)
//																		.addComponent(
//																				jRadioButton2)))
//										.addPreferredGap(
//												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//										.addGroup(
//												layout
//														.createParallelGroup(
//																javax.swing.GroupLayout.Alignment.LEADING)
//														.addComponent(jLabel5)
//														.addComponent(
//																jComboBox1,
//																javax.swing.GroupLayout.PREFERRED_SIZE,
//																javax.swing.GroupLayout.DEFAULT_SIZE,
//																javax.swing.GroupLayout.PREFERRED_SIZE))
//										.addPreferredGap(
//												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
//										.addGroup(
//												layout
//														.createParallelGroup(
//																javax.swing.GroupLayout.Alignment.LEADING)
//														.addComponent(jLabel6)
//														.addGroup(
//																layout
//																		.createParallelGroup(
//																				javax.swing.GroupLayout.Alignment.BASELINE)
//																		.addComponent(
//																				jComboBox2,
//																				javax.swing.GroupLayout.PREFERRED_SIZE,
//																				javax.swing.GroupLayout.DEFAULT_SIZE,
//																				javax.swing.GroupLayout.PREFERRED_SIZE)
//																		.addComponent(
//																				jLabel7)
//																		.addComponent(
//																				jComboBox3,
//																				javax.swing.GroupLayout.PREFERRED_SIZE,
//																				javax.swing.GroupLayout.DEFAULT_SIZE,
//																				javax.swing.GroupLayout.PREFERRED_SIZE)))
//										.addGap(18, 18, 18)
//										.addComponent(
//												jSeparator2,
//												javax.swing.GroupLayout.PREFERRED_SIZE,
//												10,
//												javax.swing.GroupLayout.PREFERRED_SIZE)
//										.addPreferredGap(
//												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
//										.addGroup(
//												layout
//														.createParallelGroup(
//																javax.swing.GroupLayout.Alignment.BASELINE)
//														.addComponent(badd)
//														.addComponent(bedit)
//														.addComponent(bdelete))
//										.addContainerGap(43, Short.MAX_VALUE)));
//
//	}
//	private void initComponents() {
//
//		jLabel1 = new javax.swing.JLabel();
//		inputid = new javax.swing.JTextField();
//		bquery = new javax.swing.JButton();
//		jSeparator1 = new javax.swing.JSeparator();
//		textno = new javax.swing.JTextField();
//		jLabel2 = new javax.swing.JLabel();
//		jLabel3 = new javax.swing.JLabel();
//		textname = new javax.swing.JTextField();
//		jLabel4 = new javax.swing.JLabel();
//		jRadioButton1 = new javax.swing.JRadioButton();
//		jRadioButton2 = new javax.swing.JRadioButton();
//		jLabel5 = new javax.swing.JLabel();
//		jComboBox1 = new javax.swing.JComboBox();
//		jLabel6 = new javax.swing.JLabel();
//		jComboBox2 = new javax.swing.JComboBox();
//		jLabel7 = new javax.swing.JLabel();
//		jComboBox3 = new javax.swing.JComboBox();
//		jSeparator2 = new javax.swing.JSeparator();
//		badd = new javax.swing.JButton();
//		bedit = new javax.swing.JButton();
//		bdelete = new javax.swing.JButton();
//
//		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
//		setTitle("\u5b66\u751f\u6ce8\u518c\u4fe1\u606f");
//
//		jLabel1.setText("\u8f93\u5165\u5b66\u53f7");
//
//		inputid.addActionListener(new java.awt.event.ActionListener() {
//			public void actionPerformed(java.awt.event.ActionEvent evt) {
//				inputidActionPerformed(evt);
//			}
//		});
//
//		bquery.setText("\u67e5\u8be2");
//
//		textno.addActionListener(new java.awt.event.ActionListener() {
//			public void actionPerformed(java.awt.event.ActionEvent evt) {
//				textnoActionPerformed(evt);
//			}
//		});
//
//		jLabel2.setText("\u5b66\u53f7");
//
//		jLabel3.setText("\u59d3\u540d");
//
//		jLabel4.setText("\u6027\u522b");
//
//		jRadioButton1.setText("\u7537");
//
//		jRadioButton2.setText("\u5973");
//
//		jLabel5.setText("\u5e74\u9f84");
//
//		jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
//				"18", "19", "20", "21" }));
//
//		jLabel6.setText("\u7c4d\u8d2f");
//
//		jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
//				"山东", "河北", "河南" }));
//
//		jLabel7.setText("\u7701");
//
//		jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
//				"济南市", "潍坊市", "郑州市", "沧州市" }));
//
//		badd.setText("\u6ce8\u518c");
//
//		bedit.setText("\u4fee\u6539");
//
//		bdelete.setText("\u5220\u9664");
//		bquery.addActionListener(this);
//		badd.addActionListener(this);
//		bedit.addActionListener(this);
//		setmyLayout();
//		pack();
//	}
//	private void textnoActionPerformed(java.awt.event.ActionEvent evt) {
//	
//	}
//
//	void inputidActionPerformed(java.awt.event.ActionEvent evt) {
//		
//	}
//
//	public static void main(String args[]) {
//		java.awt.EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				new student().setVisible(true);
//			}
//		});
//	}
//
//	private javax.swing.JButton badd;
//	private javax.swing.JButton bdelete;
//	private javax.swing.JButton bedit;
//	private javax.swing.JButton bquery;
//	private javax.swing.JTextField inputid;
//	private javax.swing.JComboBox jComboBox1;
//	private javax.swing.JComboBox jComboBox2;
//	private javax.swing.JComboBox jComboBox3;
//	private javax.swing.JLabel jLabel1;
//	private javax.swing.JLabel jLabel2;
//	private javax.swing.JLabel jLabel3;
//	private javax.swing.JLabel jLabel4;
//	private javax.swing.JLabel jLabel5;
//	private javax.swing.JLabel jLabel6;
//	private javax.swing.JLabel jLabel7;
//	private javax.swing.JRadioButton jRadioButton1;
//	private javax.swing.JRadioButton jRadioButton2;
//	private javax.swing.JSeparator jSeparator1;
//	private javax.swing.JSeparator jSeparator2;
//	private javax.swing.JTextField textname;
//	private javax.swing.JTextField textno;
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		// TODO Auto-generated method stub
//		//查询
//		if(e.getSource()==bquery){
//			String str1=inputid.getText();
//			try{
//				DBConnection dbc=new DBConnection();
//				Connection con=dbc.getConnection();
//				Statement sm=con.createStatement();
//			}
//				ResultSet rs=sm.executeQuery("select * from student where id='"+str1+"'");
//				if(rs.next()){
//					textid.setText(rs.getsString(1));
//					textname.setText(rs.getsString(2));
//					textcollege.setText(rs.getsString(3));
//					textclass.setText(rs.getsString(4));
//				}
//				else
//					jTextArea1.sett("查询的记录不存在！");
//				sm.close();
//				con.close();
//		}catch(SQLException ex){
//		System.out.println(ex);	
//			}
//			
//		}
//	//添加badd
//	if(e.getSource()==badd){
//		String sid,sname,sex,sage,sheng,scity;
//		sid=textid.getText();
//		sname=textname.getText();
//		sex=textsex.getText();
//		sage=textage.getText();
//		sheng=textsheng.getText();
//		scity=textcity.getText();
//		if(sid.equals("")){
//			JOptionpane.showMessageDialog(this,"请输入完整的学号");
//			textid.requestFocus();
//		}
//		else{
//			//把新记录插入到数据表中
//			DBConnection dbc=new DBConnectin();
//			Connection con=dbc.getConnection();
//			try{
//				Statement sm=con.createStatement();
//				String sql="insert into student values('+"sid"+','+"sname"+','+"sex"+','+"sage"+','+"sheng"+','+"scity"+')";
//				System.out.println(sql);
//				sm.excuteUpdate(sql);
//				JOptionPane.showMessageDialog(this, "数据添加成功！");
//				sm.close();
//				con.close();
//			}catch(SQLException ex){System.out.println(ex);}
//		}
//		//修改
//		if(e.getSource()==bedit){
//			local String ste0,str1,str2,ste3,str4,str5;
//			str0=textid.getText();
//			str1=textname.getText();
//			str2=textsex.getText();
//			str3=textage.getText();
//			str4=textsheng.getText();
//			str5=textcity.getText();
//			try{
//				DBConnection dbc=new DBConnction();
//			Connection con=dbc.getConnectin();
//			Statement sm=con,createStatement();
//			if(!str1.equals("")){
//				sql="update student set sname='"+str1+"' where id='"+str0+"'";
//				System.out.print(sql);
//				sm.executeUpdate(sql);
//			//	jTextAreal.setText("修改成功！");
//				JOptionPane.showMessageDialog(this, "修改成功！");
//				}
//			}
//			catch(SQLException ex){
//				
//			}S
//			
//		}
//	}
//	}
//
//}