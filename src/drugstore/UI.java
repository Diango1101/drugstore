package drugstore;

import java.awt.BorderLayout;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
public class UI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	{
		// Set Look & Feel
		try {
			javax.swing.UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static UI inst;	
	String[][] rows;			DAO DW=new DAO();
	ComboBoxModel Year = new DefaultComboBoxModel(new String[] { "2015","2016","2017","2018","2019" });
	ComboBoxModel Month = new DefaultComboBoxModel(new String[] { "1","2","3","4","5","6","7","8","9","10","11","12" });
	ComboBoxModel Year1 = new DefaultComboBoxModel(new String[] { "2015","2016","2017","2018","2019" });
	ComboBoxModel Month1 = new DefaultComboBoxModel(new String[] { "1","2","3","4","5","6","7","8","9","10","11","12" });
	ComboBoxModel Year2 = new DefaultComboBoxModel(new String[] { "2015","2016","2017","2018","2019" });
	ComboBoxModel Month2 = new DefaultComboBoxModel(new String[] { "1","2","3","4","5","6","7","8","9","10","11","12" });
	ComboBoxModel Year3 = new DefaultComboBoxModel(new String[] { "2015","2016","2017","2018","2019" });
	ComboBoxModel Month3 = new DefaultComboBoxModel(new String[] { "1","2","3","4","5","6","7","8","9","10","11","12" });
	private JFrame Login;			//登录面板
	private JFrame tempf;			//临时面板
	private JPanel tempjp;
	private JLabel lbl0;  private JLabel lbl1;		private JLabel lbl2;	private JLabel lbl3;	private JLabel lbl8;	private JLabel lbl9;
	private JLabel lbl4;		private JLabel lbl5;	private JLabel lbl6;	private JLabel lbl7;	private JLabel lbl10;
	private JLabel lbl11;
	private	TextField txt0;
	private	TextField txt1;		private	TextField txt2;	private	TextField txt3;	
	private	TextField txt4;		private	TextField txt5;	private	TextField txt6;	private	TextField txt7;
	private	TextField txt8;
	private JButton   btn;
	private JLabel L1;private JLabel L2;
	private JLabel Username;	private JTextField User;
	private JLabel Key;			private JTextField Keys;
	private JPanel JP1;			private	JButton    Sure;
	private JButton	Clear;
	private JTabbedPane jTabbedPane1;// 主面板
	private JPanel jPanel1; 		//仓库管理界面
	private JFrame f1;			private JLabel ch1;		private JLabel ch2;		private JLabel ch3;		private JLabel ch4;
	private JButton btnc;		private JLabel chan;	private TextField tc1;	private TextField tc2;	private TextField tc3;
	private TextArea Welcome;	private JTable wtable;	private JScrollPane wtable1;		private JPanel jjp;
	private TitledBorder Ware1 ;private TitledBorder Ware2 ;
	private JPanel T1;			private JPanel T2;
	private TitledBorder Ware3 ;private TitledBorder Ware4 ;
	private JPanel T3;			private JPanel T4;
	private JButton MedicineMs;	private JButton Search1;
	private JButton AllMs;		private JButton Search2;
	private JButton Insert;		private JButton Out;
	private JButton WareMs;		
	private JPanel jPanel2;			//销售管理界面
	private TextArea Welcome1;	private EtchedBorder  Sale ;	private JPanel S1;
	private JButton SaleMs;		private JButton AddSale;		private JTable stable;	private JScrollPane stable1;
	private JPanel jPanel3;			//信息查询界面
	private String[] s1;			private	String[] s2;				private String[] s3;
	private TitledBorder InF;	private TitledBorder SaleF;		private TitledBorder WareF;
	private TextArea Welcome2;	private TextArea Welcome3;		private TextArea Welcome4;
	private JPanel F1;			private JPanel F2;				private JPanel F3;
	private	JLabel k1;private	JLabel k2;private	JLabel k3;
	private	JLabel c1;private	JLabel c2;private	JLabel c3;
	private JLabel w1;
	private	JComboBox Kinds;	private JComboBox Class;		private	JComboBox Where;
	private	JButton Find1;		
	private	JComboBox Kinds1; 	private JComboBox Class1;		
	private	TextField low;		private TextField high;
	private	JButton Find2;
	private	JComboBox Kinds2;	private JComboBox Class2;
	private	JButton Find3;
	private JTable sctable;	private JScrollPane sctable1;private JTable sctable2;	private JScrollPane sctable3;private JTable sctable4;	private JScrollPane sctable5;
	private JPanel jPanel4;			//统计管理界面
	private	TitledBorder In;	private	TitledBorder Sa;
	private JPanel InCheck;		private JPanel SaleCheck;		private JButton	Fin1;
	private	JComboBox year;		private JComboBox month;		private JButton	Fin2;
	private	TextArea  Welcome5;	private	TextArea  Welcome6;
	private	JComboBox year1;		private JComboBox month1;
	private JTable yitable;	private JScrollPane yitable1;
	private JTable ystable;	private JScrollPane ystable1;
	private JLabel	y1;private JLabel	y2;private JLabel	m1;private JLabel	m2;
	private JLabel	y3;private JLabel	y4;private JLabel	m3;private JLabel	m4;
	private JLabel  temp;		private JLabel  temp1;
	private	JComboBox year2;		private JComboBox month2;
	private	JComboBox year3;		private JComboBox month3;
	private JPanel jPanel5;			//逼仓巡视界面
	private JPanel min;			private JPanel Min;
	private	TitledBorder m;		private	TitledBorder M;
	private TextArea Welcome7;	private TextArea Welcome8;
	private JButton min1;		private JButton Min1;
	private JTable datable;	private JScrollPane datable1;
	private JTable mitable;	private JScrollPane mitable1;
	String Userno, Upassword, identity;
	PreparedStatement pre;
	ResultSet rs;
    Connection con;
	
	
	
	public static void main(String[] args) 
	{
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				inst = new UI();
				inst.setLocationRelativeTo(null);
				inst.setVisible(false);
			}
		});
	}
	public  UI() {				//登陆界面
		super();
		try {
			BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.generalNoTranslucencyShadow;
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
			UIManager.put("RootPane.setupButtonVisible", false);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		Login=new JFrame();
		Login.setVisible(true);
		Login.setTitle("药店销售系统登录");
		Login.setBounds(750, 350, 450, 430);
		// 加载LOGO
		JPanel logopanel = new JPanel();
		JLabel logolabel = new JLabel();
		ImageIcon logo = new ImageIcon("F:\\数据库大作业\\logo.JPG");
		logolabel.setIcon(logo);
		logopanel.add(logolabel);
		logopanel.setBounds(0, 0, logo.getIconWidth(), logo.getIconHeight());
		Login.add(logopanel, BorderLayout.NORTH);
		{
			JP1 = new JPanel();
			JP1.setLayout(null);
			Login.add(JP1, BorderLayout.CENTER);
			{
				L1 = new JLabel();
				JP1.add(L1);
				L1.setText("欢迎使用");
				L1.setBounds(120, 20, 100, 30);
				L2 = new JLabel();
				JP1.add(L2);
				L2.setText("连锁药店销售管理系统");
				L2.setBounds(95, 50, 150, 30);
			}
			{
				Username = new JLabel();
				JP1.add(Username);
				Username.setText("ID:");
				Username.setBounds(70, 120, 50, 20);
				User = new JTextField();
				JP1.add(User);
				User.setBounds(150, 120, 70, 20);
			}
			{
				Key = new JLabel();
				JP1.add(Key);
				Key.setText("KEY:");
				Key.setBounds(70, 200, 50, 20);
				Keys = new JTextField();
				JP1.add(Keys);
				Keys.setBounds(150, 200, 70, 20);
			}
			{
				Sure = new JButton();
				JP1.add(Sure);
				Sure.setText("登陆");
				Sure.setBounds(70, 280, 60, 30);
				Clear = new JButton();
				JP1.add(Clear);
				Clear.setText("清空");
				Clear.setBounds(170, 280, 60, 30);
			}
			{
				Sure.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						     String i=new String();
						    i=DW.user( User.getText(),Keys.getText());
							
							if(i.equals("超级用户") )
								{
									Login.setVisible(false);
									inst.setVisible(true);
									javax.swing.JOptionPane.showMessageDialog(
											null, "你好超级用户");
									SuperUser();
									
								}
							else if(i.equals("管理员") )
								{
									Login.setVisible(false);
									inst.setVisible(true);	
									javax.swing.JOptionPane.showMessageDialog(
											null, "你好，管理员");
									Manager();
								}
							else if(i.equals("销售员") )
								{
									Login.setVisible(false);
									inst.setVisible(true);	
									javax.swing.JOptionPane.showMessageDialog(
											null, "你好，销售员");
									Saler();
								}
							else
							{
								User.setText("");
								Keys.setText("");
								javax.swing.JOptionPane.showMessageDialog(
										null, "密码或用户名有误，请重新输入");
							}
					}
				});
				Clear.addActionListener(new ActionListener() {

					
					public void actionPerformed(ActionEvent e) {

						User.setText("");
						Keys.setText("");

					}
				});
				
			}
			Login.setResizable(false);
			Login.setSize(300, 400);
		}
			
	}

	private void SuperUser() {	//超级用户界面
		try {
			BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.generalNoTranslucencyShadow;
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
			UIManager.put("RootPane.setupButtonVisible", false);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		try {
			
				this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
				this.setTitle("超级用户管理系统");
				jTabbedPane1 = new JTabbedPane();
				getContentPane().add(jTabbedPane1, BorderLayout.CENTER);
				
				
				
					/*仓库管理界面*/
					Ware1 =new TitledBorder("药物信息");T1= new JPanel();T1.setBorder(Ware1);
					Ware2 =new TitledBorder("仓储信息");T2= new JPanel();T2.setBorder(Ware2);
					Ware3 =new TitledBorder("进货/出货");T3= new JPanel();T3.setBorder(Ware3);
					Ware4 =new TitledBorder("进货信息");T4= new JPanel();T4.setBorder(Ware4);
					jPanel1 = new JPanel();
					jTabbedPane1.addTab("仓库管理", null, jPanel1, null);
					jPanel1.setLayout(null);			
					Welcome=new TextArea();				wtable=new JTable();
					Welcome.setBounds(20,20,460,380);	
					wtable1=new JScrollPane(wtable);wtable1.setBounds(20,20,460,380);wtable1.setVisible(false);
					Welcome.setText(
							"***********欢迎使用Diango的药店销售系统*************\n"
							+ "1、在库药物信息键可显示所有在库药物，查找键可查找相关药物详细信息\n"
							+ "2、所有记录可查看所有药物仓储数量\n"
							+ "3、进/出货只可添加单条信息，或出库单独信息\n"
							+ "4、更新仓库信息内容请先点击仓库记录显示所有仓库记录.\n"
						);
					jPanel1.add(Welcome);jPanel1.add(wtable1);
					T1.setLayout(null);T2.setLayout(null);T3.setLayout(null);T4.setLayout(null);
					T1.setBounds(515,20,270,80);T2.setBounds(515,120,270,80);
					T3.setBounds(515,220,270,80);T4.setBounds(515,320,270,80);
					jPanel1.add(T1);jPanel1.add(T2);jPanel1.add(T3);jPanel1.add(T4);
					MedicineMs=new JButton("在库药物信息");Search1=new JButton("更改");
					MedicineMs.setBounds(10,30,120,30);Search1.setBounds(160,30,100,30);
					AllMs=new JButton("仓储记录");Search2=new JButton("查找");
					AllMs.setBounds(10,30,120,30);Search2.setBounds(160,30,100,30);
					Insert=new JButton("进货");Out=new JButton("出货");
					Insert.setBounds(10,30,120,30);Out.setBounds(160,30,100,30);
					WareMs=new JButton("进货记录");
					WareMs.setBounds(10,30,120,30);
					T1.add(MedicineMs);T1.add(Search1);T2.add(AllMs);T2.add(Search2);
					T3.add(Insert);T3.add(Out);T4.add(WareMs);
					
					
					
					{
						MedicineMs.addActionListener(new ActionListener() /*在库药物信息*/
						{

							
							public void actionPerformed(ActionEvent e) {
								try {
									Welcome.setVisible(false);
									String[] cols={"药品编号","药品类别","药品名称"};
									rows=DW.Rdrug();
									DefaultTableModel dtm = new DefaultTableModel(rows,cols);
									wtable.setModel(dtm);
									wtable1.setVisible(true);
								} catch (Exception e1) {
									e1.printStackTrace();
									System.out.println("输入错误");
									
									javax.swing.JOptionPane.showMessageDialog(
											null, "输入有误，请重新输入");
								}

							}
						});
					}
					Search1.addActionListener(new ActionListener() /*修改在库药物信息*/
						{

						
							public void actionPerformed(ActionEvent e) {
								try {
									tempf = new JFrame(); tempjp=new JPanel();
									tempf.add(tempjp, BorderLayout.CENTER);
									tempf.setSize(250,300);
									tempjp.setLayout(null);
									tempf.setVisible(true);
									lbl1=new JLabel("药品名称：");
									txt1=new TextField();txt2=new TextField();txt3=new TextField();
									btn=new JButton("确定");
									lbl1.setBounds(20,20,80,20);txt1.setBounds(120,20,70,20);
									btn.setBounds(85,150,80,30);
									tempjp.add(lbl1);
									tempjp.add(txt1);tempjp.add(btn);
									btn.addActionListener(new ActionListener() /*查找在库药物信息*/
									{

										public void actionPerformed(ActionEvent e) {
											try {
													String[] s=new String[4];
													s=DW.changes(txt1.getText());
													
													f1=new JFrame();f1.setSize(300,200);f1.setVisible(true);
													ch1=new JLabel("药品编号");ch2=new JLabel("药品名称");
													ch3=new JLabel("药品类别");ch4=new JLabel("产地");
													chan=new JLabel(s[0]);	tc1=new TextField(s[1]);tc2=new TextField(s[2]);tc3=new TextField(s[3]);btnc=new JButton("保存");
													jjp=new JPanel();f1.add(jjp, BorderLayout.CENTER);jjp.setLayout(null);
												
													ch1.setBounds(10,10,50,25);ch2.setBounds(80,10,50,25);ch3.setBounds(150,10,50,25);ch4.setBounds(220,10,50,25);
													chan.setBounds(10,50,50,25);tc1.setBounds(80,50,50,25);tc2.setBounds(150,50,50,25);tc3.setBounds(220,50,50,25);
													
													btnc.setBounds(120,100,60,25);jjp.add(btnc);
													jjp.add(ch1);jjp.add(ch2);jjp.add(ch3);jjp.add(ch4);jjp.add(tc1);jjp.add(tc2);jjp.add(tc3);jjp.add(chan);
													btnc.addActionListener(new ActionListener() /*保存*/
													{
														public void actionPerformed(ActionEvent e) {
															try {
																DW.upd(Integer.parseInt(chan.getText()),tc1.getText(),tc2.getText(),tc3.getText());
																javax.swing.JOptionPane.showMessageDialog(
																		null, "成功保存");
															}catch(Exception e1){
																javax.swing.JOptionPane.showMessageDialog(
																		null, "输入有误，请重新输入");
															}	
														}
													});
											}catch(Exception e1){
												javax.swing.JOptionPane.showMessageDialog(
														null, "输入有误，请重新输入");
											}	
										}
									});
									} catch (Exception e1) {
										e1.printStackTrace();
										System.out.println("输入错误");
									
										javax.swing.JOptionPane.showMessageDialog(
											null, "输入有误，请重新输入");
									}

							}
						});
				
					AllMs.addActionListener(new ActionListener() /*仓储记录*/
						{

						
							public void actionPerformed(ActionEvent e) {
								try {
									Welcome.setVisible(false);
									String[] cols={"仓位号","药品编号","进货编号","药品名称","进货日期","有效期","库存数量"};
									rows=DW.RAll();
									DefaultTableModel dtm = new DefaultTableModel(rows,cols);
									wtable.setModel(dtm);
									wtable1.setVisible(true);
								} catch (Exception e1) {
									e1.printStackTrace();
									System.out.println("输入错误");
									
									javax.swing.JOptionPane.showMessageDialog(
											null, "输入有误，请重新输入");
								}

							}
						});
					
					Search2.addActionListener(new ActionListener() /*查找药物存储信息*/
						{

						
							public void actionPerformed(ActionEvent e) {
								try {
									tempf = new JFrame(); tempjp=new JPanel();
									tempf.add(tempjp, BorderLayout.CENTER);
									tempf.setSize(250,300);
									tempjp.setLayout(null);
									tempf.setVisible(true);
									lbl1=new JLabel("药品名称：");lbl2=new JLabel("药品类别：");
									txt1=new TextField();txt2=new TextField();
									btn=new JButton("确定");
									lbl1.setBounds(20,20,80,20);txt1.setBounds(120,20,70,20);
									lbl2.setBounds(20,60,80,20);txt2.setBounds(120,60,70,20);
									btn.setBounds(85,150,80,30);
									tempjp.add(lbl1);tempjp.add(lbl2);
									tempjp.add(txt1);tempjp.add(txt2);tempjp.add(btn);
									btn.addActionListener(new ActionListener()      /*查找在库药物信息*/
									{

										public void actionPerformed(ActionEvent e) {
											try {
													if(!(txt1.getText().equals("")) && !(txt2.getText().equals("")) ){
															Welcome.setVisible(false);
															String[] cols={"仓位号","药品编号","进货编号","药品名称","进货日期","有效期","库存数量"};
															rows=DW.SearchR1(txt1.getText(),txt2.getText());
															DefaultTableModel dtm = new DefaultTableModel(rows,cols);
															wtable.setModel(dtm);
															wtable1.setVisible(true);
															tempf.dispose();
													}else if(!(txt1.getText().equals(""))){
															Welcome.setVisible(false);
															String[] cols={"仓位号","药品编号","进货编号","药品名称","进货日期","有效期","库存数量"};
															rows=DW.SearchR2(txt1.getText());
															DefaultTableModel dtm = new DefaultTableModel(rows,cols);
															wtable.setModel(dtm);
															wtable1.setVisible(true);
															tempf.dispose();
													}else if(!(txt2.getText().equals("")) ){
															Welcome.setVisible(false);
															String[] cols={"仓位号","药品编号","进货编号","药品名称","进货日期","有效期","库存数量"};
															rows=DW.SearchR3(txt2.getText());
															DefaultTableModel dtm = new DefaultTableModel(rows,cols);
															wtable.setModel(dtm);
															wtable1.setVisible(true);
															tempf.dispose();
													}else{
														javax.swing.JOptionPane.showMessageDialog(
																null, "请输入数据");
													}
											}catch(Exception e1){
												javax.swing.JOptionPane.showMessageDialog(
														null, "输入有误，请重新输入");
											}	
										}
									});
								} catch (Exception e1) {
									e1.printStackTrace();
									System.out.println("输入错误");
									
									javax.swing.JOptionPane.showMessageDialog(
											null, "输入有误，请重新输入");
								}

							}
						});
					
					Insert.addActionListener(new ActionListener() /*进货*/
						{

						
							public void actionPerformed(ActionEvent e) {
								try {
									
									tempf = new JFrame(); tempjp=new JPanel();
									tempf.add(tempjp, BorderLayout.CENTER);
									tempf.setSize(250,700);
									tempjp.setLayout(null);
									tempf.setVisible(true);
									
									lbl1=new JLabel("进货编号");lbl2=new JLabel("药品编号");lbl3=new JLabel("生产日期");
									lbl4=new JLabel("进货日期");lbl5=new JLabel("有效期");lbl6=new JLabel("进货数量");
									lbl7=new JLabel("进货单价");
									lbl8=new JLabel("PS：");                              
									lbl9=new JLabel("填写时间时请按照：");lbl11=new JLabel("年-月-日格式填写！");
									lbl10=new JLabel("使用愉快~");
									txt1=new TextField();txt2=new TextField();txt3=new TextField();
									txt4=new TextField();txt5=new TextField();txt6=new TextField();txt7=new TextField();
									btn=new JButton("确定");
									lbl1.setBounds(30,30,60,20);txt1.setBounds(130,30,70,20);tempjp.add(lbl1);tempjp.add(txt1);
									lbl2.setBounds(30,60,60,20);txt2.setBounds(130,60,70,20);tempjp.add(lbl2);tempjp.add(txt2);
									lbl3.setBounds(30,90,60,20);txt3.setBounds(130,90,70,20);tempjp.add(lbl3);tempjp.add(txt3);
									lbl4.setBounds(30,120,60,20);txt4.setBounds(130,120,70,20);tempjp.add(lbl4);tempjp.add(txt4);
									lbl5.setBounds(30,150,60,20);txt5.setBounds(130,150,70,20);tempjp.add(lbl5);tempjp.add(txt5);
									lbl6.setBounds(30,180,60,20);txt6.setBounds(130,180,70,20);tempjp.add(lbl6);tempjp.add(txt6);
									lbl7.setBounds(30,200,60,20);txt7.setBounds(130,200,70,20);tempjp.add(lbl7);tempjp.add(txt7);
									btn.setBounds(75,250,80,30);tempjp.add(btn);
									lbl8.setBounds(30,290,50,20);tempjp.add(lbl8);
									lbl9.setBounds(40,315,150,20);tempjp.add(lbl9);
									lbl10.setBounds(40,375,150,20);tempjp.add(lbl10);
									lbl11.setBounds(75,345,150,20);tempjp.add(lbl11);
									btn.addActionListener(new ActionListener() /*进货*/
									{

									
										public void actionPerformed(ActionEvent e) {
											try {
												 DW.InsertR(txt1.getText(), txt2.getText(), 
															txt3.getText(), txt4.getText(), txt5.getText(),
															Integer.parseInt(txt6.getText()),txt7.getText());
													javax.swing.JOptionPane.showMessageDialog(
															null, "插入成功");
													Welcome.setVisible(false);
													String[] cols={"进货编号","药品编号","生产日期","进货日期","有效期","进货数量","进货单价"};
													rows=DW.InputAll();
													DefaultTableModel dtm = new DefaultTableModel(rows,cols);
													wtable.setModel(dtm);
													wtable1.setVisible(true);
											}catch(Exception e1){
												javax.swing.JOptionPane.showMessageDialog(
														null, "输入有误，请重新输入");
											}
										}
									});
									} catch (Exception e1) {
										e1.printStackTrace();
									
									}

							}
						});
					
					WareMs.addActionListener(new ActionListener() /*进货记录*/
						{

							public void actionPerformed(ActionEvent e) {
								try {
									Welcome.setVisible(false);
									String[] cols={"进货编号","药品编号","生产日期","进货日期","有效期","进货数量","进货单价"};
									rows=DW.InputAll();
									DefaultTableModel dtm = new DefaultTableModel(rows,cols);
									wtable.setModel(dtm);
									wtable1.setVisible(true);
								} catch (Exception e1) {
									e1.printStackTrace();
									System.out.println("输入错误");
									
									javax.swing.JOptionPane.showMessageDialog(
											null, "输入有误，请重新输入");
								}

							}
						});
					
					Out.addActionListener(new ActionListener() /*出货*/
						{

							public void actionPerformed(ActionEvent e) {
								try {
									tempf = new JFrame(); tempjp=new JPanel();
									tempf.add(tempjp, BorderLayout.CENTER);
									tempf.setSize(150,200);
									tempjp.setLayout(null);
									tempf.setVisible(true);
									lbl1=new JLabel("仓位号：");txt1=new TextField();
									lbl2=new JLabel("数量：");txt2=new TextField();
									btn=new JButton("确定");
									lbl1.setBounds(10,20,50,20);lbl2.setBounds(10,60,50,20);
									txt1.setBounds(80,20,50,20);txt2.setBounds(80,60,50,20);
									btn.setBounds(45,100,60,20);
									tempjp.add(lbl1);tempjp.add(lbl2);tempjp.add(txt1);tempjp.add(txt2);tempjp.add(btn);
									btn.addActionListener(new ActionListener() /*出货*/
									{

										public void actionPerformed(ActionEvent e) {
											try {
													DW.OutR(Integer.parseInt(txt1.getText()),Integer.parseInt(txt2.getText()));
													Welcome.setVisible(false);
													String[] cols={"仓位号","药品编号","进货编号","药品名称","进货日期","有效期","库存数量"};
													rows=DW.RAll();
													DefaultTableModel dtm = new DefaultTableModel(rows,cols);
													wtable.setModel(dtm);
													wtable1.setVisible(true);
											}catch(Exception e1){
												
											}
										}
									});
									} catch (Exception e1) {
										e1.printStackTrace();
										System.out.println("输入错误");
										javax.swing.JOptionPane.showMessageDialog(
												null, "输入有误，请重新输入");
									}

								}
							});
					
					
				
				
					/*销售管理界面*/
					Sale=new EtchedBorder();
					Welcome1=new TextArea(); Welcome1.setBounds(20,20,460,380);stable=new JTable();stable1=new JScrollPane(stable);
					Welcome1.setText("************************************************************************************\n"
							+    "   本选项卡可查看所有的销售记录，并添加新的销售记录。\n"
							+ 	 "   添加新记录的同时，本程序将自动更新库存数量。\n"
							
								);
					stable1.setBounds(20,20,460,380);stable1.setVisible(false);
					S1=new JPanel();S1.setSize(200,300);
					jPanel2 = new JPanel();
					jTabbedPane1.addTab("销售管理", null, jPanel2, null);
					jPanel2.setLayout(null);
					jPanel2.setAutoscrolls(true);
					S1.setLayout(null);S1.setBounds(515,20,270,380);
					jPanel2.add(S1);jPanel2.add(Welcome1);S1.setBorder(Sale);jPanel2.add(stable1);
					SaleMs=new JButton("查看销售记录");AddSale=new JButton("增加销售记录");
					SaleMs.setBounds(80,100,120,30);AddSale.setBounds(80,300,120,30);
					S1.add(SaleMs);S1.add(AddSale);
					
					SaleMs.addActionListener(new ActionListener() 		//销售记录
					{

							public void actionPerformed(ActionEvent e) {
								try {
									Welcome1.setVisible(false);
									String[] cols={"销售编号","仓位号","销售单价","销售数量","柜台号","销售人工号","销售日期"};
									rows=DW.SaleAll();
									DefaultTableModel dtm = new DefaultTableModel(rows,cols);
									stable.setModel(dtm);
									stable1.setVisible(true);
								} catch (Exception e2) {
									e2.printStackTrace();
									javax.swing.JOptionPane.showMessageDialog(
											null, "Error");
								}
								
							}
						});
					
					
					AddSale.addActionListener(new ActionListener() 		/*售货*/
					{

						public void actionPerformed(ActionEvent e) {
							try {
								
								tempf = new JFrame(); tempjp=new JPanel();
								tempf.add(tempjp, BorderLayout.CENTER);
								tempf.setSize(250,500);
								tempjp.setLayout(null);
								tempf.setVisible(true);
								lbl0=new JLabel("销售编号");
								lbl1=new JLabel("进货编号");lbl2=new JLabel("仓位号");lbl3=new JLabel("销售单价");
								lbl4=new JLabel("销售数量");lbl5=new JLabel("柜台号");lbl6=new JLabel("售员工号");
								lbl7=new JLabel("销售日期");
								lbl8=new JLabel("注：");
								lbl9=new JLabel("填写时间时请按照：");lbl11=new JLabel("年-月-日格式填写！");
								lbl10=new JLabel("使用愉快~");
								txt0=new TextField();txt1=new TextField();txt2=new TextField();txt3=new TextField();
								txt4=new TextField();txt5=new TextField();txt6=new TextField();txt7=new TextField();
								txt8=new TextField();
								btn=new JButton("确定");
								lbl0.setBounds(30,0,60,20);txt0.setBounds(130,0,70,20);tempjp.add(lbl0);tempjp.add(txt0);
								lbl1.setBounds(30,30,60,20);txt1.setBounds(130,30,70,20);tempjp.add(lbl1);tempjp.add(txt1);
								lbl2.setBounds(30,60,60,20);txt2.setBounds(130,60,70,20);tempjp.add(lbl2);tempjp.add(txt2);
								lbl3.setBounds(30,90,60,20);txt3.setBounds(130,90,70,20);tempjp.add(lbl3);tempjp.add(txt3);
								lbl4.setBounds(30,120,60,20);txt4.setBounds(130,120,70,20);tempjp.add(lbl4);tempjp.add(txt4);
								lbl5.setBounds(30,150,60,20);txt5.setBounds(130,150,70,20);tempjp.add(lbl5);tempjp.add(txt5);
								lbl6.setBounds(30,180,70,20);txt6.setBounds(130,180,70,20);tempjp.add(lbl6);tempjp.add(txt6);
								lbl7.setBounds(30,210,60,20);txt7.setBounds(130,210,70,20);tempjp.add(lbl7);tempjp.add(txt7);
								btn.setBounds(75,250,80,30);tempjp.add(btn);
								lbl8.setBounds(30,290,50,20);tempjp.add(lbl8);
								lbl9.setBounds(40,315,150,20);tempjp.add(lbl9);
								lbl10.setBounds(40,375,150,20);tempjp.add(lbl10);
								lbl11.setBounds(75,345,150,20);tempjp.add(lbl11);
								btn.addActionListener(new ActionListener() /*进货*/
								{

									public void actionPerformed(ActionEvent e) {
										try {
											 DW.AddS1(txt0.getText(),txt1.getText(), txt2.getText(),  
													 txt3.getText(), txt4.getText(), txt5.getText(),
														txt6.getText(),txt7.getText());
												javax.swing.JOptionPane.showMessageDialog(
														null, "出库成功");
												Welcome1.setVisible(false);
												String[] cols={"销售编号","仓位号","销售单价","销售数量","柜台号","销售人工号","销售日期"};
												rows=DW.SaleAll();
												DefaultTableModel dtm = new DefaultTableModel(rows,cols);
												stable.setModel(dtm);
												stable1.setVisible(true);
												String[][] rows1=DW.RAll();
												String[] cols1={"仓位号","药品编号","进货编号","药品名称","进货日期","有效期","库存数量"};
												DefaultTableModel dtm1 = new DefaultTableModel(rows1,cols1);
												wtable.setModel(dtm1);
												wtable1.setVisible(true);
										}catch(Exception e1){
											javax.swing.JOptionPane.showMessageDialog(
													null, "输入有误，请重新输入");
										}
									}
								});
								} catch (Exception e1) {
									e1.printStackTrace();
								
								}

						}
					});	
					
				
				
				
					/*信息查询界面*/
					InF =new TitledBorder("进货信息");F1= new JPanel();F1.setBorder(InF);F1.setLayout(null);
					SaleF =new TitledBorder("销售信息");F2= new JPanel();F2.setBorder(SaleF);F2.setLayout(null);
					WareF =new TitledBorder("库存信息");F3= new JPanel();F3.setBorder(WareF);F3.setLayout(null);
					ComboBoxModel KindsM = new DefaultComboBoxModel(new String[] { "" });
					ComboBoxModel Classes = new DefaultComboBoxModel(new String[] { "" });
					ComboBoxModel Wheres = new DefaultComboBoxModel(new String[] { "" });
					Welcome2=new TextArea();Welcome3=new TextArea();Welcome4=new TextArea();
					sctable=new JTable();	sctable2=new JTable();	sctable4=new JTable();
					sctable1=new JScrollPane(sctable);	sctable3=new JScrollPane(sctable2);	sctable5=new JScrollPane(sctable4);
					jPanel3 = new JPanel();
					jTabbedPane1.addTab("信息查询", null, jPanel3, null);
					jPanel3.setLayout(null);
					k1=new JLabel("药品名称");k2=new JLabel("药品名称");k3=new JLabel("药品名称");
					c1=new JLabel("药品类别");c2=new JLabel("药品类别");c3=new JLabel("药品类别");
					w1=new JLabel("产地");
					Kinds=new JComboBox(KindsM);Kinds1=new JComboBox(KindsM);Kinds2=new JComboBox(KindsM);
					Class=new JComboBox(Classes);Class1=new JComboBox(KindsM);Class2=new JComboBox(KindsM);
					Where=new JComboBox(Wheres); low=new TextField();		high=new TextField();
					JCup();
					Find1=new JButton("查找");
					Find2=new JButton("查找");
					Find3=new JButton("查找");
					F1.setBounds(25,10,750,140);F2.setBounds(25,160,750,140);F3.setBounds(25,310,750,140);
					jPanel3.add(F1);jPanel3.add(F2);jPanel3.add(F3);
					k1.setBounds(20,13,50,25);Kinds.setBounds(80,13,70,25);
					c1.setBounds(170,13,50,25);Class.setBounds(240,13,70,25);
					w1.setBounds(340,13,50,25);Where.setBounds(400,13,70,25);Find1.setBounds(500,13,70,25);
					Welcome2.setBounds(20,40,710,90);sctable1.setBounds(20,40,710,90);sctable1.setVisible(false);
					F1.add(k1);F1.add(c1);F1.add(w1);F1.add(Welcome2);F1.add(sctable1);
					F1.add(Kinds);F1.add(Class);F1.add(Where);F1.add(Find1);
					k2.setBounds(20,13,50,25);Kinds1.setBounds(80,13,70,25);
					c2.setBounds(170,13,50,25);Class1.setBounds(240,13,70,25);Find2.setBounds(500,13,70,25);
					Welcome3.setBounds(20,40,710,90);sctable3.setBounds(20,40,710,90);sctable3.setVisible(false);
					F2.add(k2);F2.add(c2);F2.add(Welcome3);
					F2.add(Kinds1);F2.add(Class1);F2.add(Find2);F2.add(sctable3);
					k3.setBounds(20,13,50,25);Kinds2.setBounds(80,13,70,25);
					c3.setBounds(170,13,50,25);Class2.setBounds(240,13,70,25);Find3.setBounds(500,13,70,25);
					Welcome4.setBounds(20,40,710,90);sctable5.setBounds(20,40,710,90);sctable5.setVisible(false);
					F3.add(k3);F3.add(c3);F3.add(Welcome4);
					F3.add(Kinds2);F3.add(Class2);F3.add(Find3);F3.add(sctable5);
					
					Find1.addActionListener(new ActionListener() /*进货记录*/
					{

						public void actionPerformed(ActionEvent e) {
							try {
								String te1=Kinds.getSelectedItem().toString(),te2=Class.getSelectedItem().toString(),te3=Where.getSelectedItem().toString();
								if(te1.equals(""))
									te1=null;
								if(te2.equals(""))
									te2=null;
								if(te3.equals(""))
										te3=null;
								Welcome2.setVisible(false);
								String[] cols={"进货编号","药品名称","药品类别","产地","进货日期","有效期","进货单价","进货数量"};
								rows=DW.F1(te1,te2,te3 );
								DefaultTableModel dtm = new DefaultTableModel(rows,cols);
								sctable.setModel(dtm);
								sctable1.setVisible(true);
							} catch (Exception e1) {
								e1.printStackTrace();
								System.out.println("输入错误");
								
								javax.swing.JOptionPane.showMessageDialog(
										null, "输入有误，请重新输入");
							}

						}
					});
					Find2.addActionListener(new ActionListener() /*销售记录*/
					{

						public void actionPerformed(ActionEvent e) {
							try {
								String te1=Kinds1.getSelectedItem().toString(),te2=Class1.getSelectedItem().toString();
								if(te1.equals(""))
									te1=null;
								if(te2.equals(""))
									te2=null;
								Welcome3.setVisible(false);
								String[] cols={"销售编号","仓位号","药品名称","药品类别","销售单价","销售数量","柜台号","销售人工号","销售日期"};
								rows=DW.F2(te1,te2 );
								DefaultTableModel dtm = new DefaultTableModel(rows,cols);
								sctable2.setModel(dtm);
								sctable3.setVisible(true);
							} catch (Exception e1) {
								e1.printStackTrace();
								System.out.println("输入错误");
								
								javax.swing.JOptionPane.showMessageDialog(
										null, "输入有误，请重新输入");
							}

						}
					});
					Find3.addActionListener(new ActionListener() /*库存记录*/
					{

						public void actionPerformed(ActionEvent e) {
							try {
								String te1=Kinds2.getSelectedItem().toString(),te2=Class2.getSelectedItem().toString();
								if(te1.equals(""))
									te1=null;
								if(te2.equals(""))
									te2=null;
								Welcome4.setVisible(false);
								String[] cols={"仓位号","药品名称","药品类别","进货日期","有效期","库存数量"};
								rows=DW.F3(te1,te2 );
								DefaultTableModel dtm = new DefaultTableModel(rows,cols);
								sctable4.setModel(dtm);
								sctable5.setVisible(true);
							} catch (Exception e1) {
								e1.printStackTrace();
								System.out.println("输入错误");
								
								javax.swing.JOptionPane.showMessageDialog(
										null, "输入有误，请重新输入");
							}

						}
					});
					
					
				
					/*统计管理界面**/
					
					In=new TitledBorder("进货统计");	Sa=new TitledBorder("销售统计");
					InCheck=new JPanel();		SaleCheck=new JPanel();				Fin1=new JButton("确定");
					year=new JComboBox(Year);		month=new JComboBox(Month);		Fin2=new JButton("确定");
					Welcome5=new TextArea();	Welcome6=new TextArea();
					Welcome5.setText("************************************************************************************\n"
								+    "   请在上方选项卡选择您所想要查询的日期区间。默认由所选择月份的第一天开始查找！  \n"
									+"   如由疑问请联系20160748\n");
					Welcome6.setText("************************************************************************************\n"
							+        "   请在上方选项卡选择您所想要查询的日期区间。默认由所选择月份的第一天开始查找！  \n"
							+        "   您可以同时查看进货记录和销售记录\n"
							+        "   如由疑问请联系20160748\n");
					year1=new JComboBox(Year1);		month1=new JComboBox(Month1);
					year3=new JComboBox(Year2);		month3=new JComboBox(Month2);
					year2=new JComboBox(Year3);		month2=new JComboBox(Month3);
					yitable=new JTable();			yitable1=new JScrollPane(yitable);
					ystable=new JTable();			ystable1=new JScrollPane(ystable);
					InCheck.setLayout(null);	SaleCheck.setLayout(null);
					y1=new JLabel("年份");y2=new JLabel("年份");m1=new JLabel("月份");m2=new JLabel("月份");
					y3=new JLabel("年份");y4=new JLabel("年份");m3=new JLabel("月份");m4=new JLabel("月份");
					temp1=new JLabel("至");temp=new JLabel("至");
					jPanel4 = new JPanel();
					jTabbedPane1.addTab("统计管理", null, jPanel4, null);
					jPanel4.setLayout(null);
					InCheck.setBorder(In);SaleCheck.setBorder(Sa);
					InCheck.setBounds(20,10,750,220);SaleCheck.setBounds(20,230,750,220);
					jPanel4.add(InCheck);jPanel4.add(SaleCheck);
					year1.setBounds(25,15,50,25);year.setBounds(25,15,50,25);month1.setBounds(140,15,50,25);month.setBounds(140,15,50,25);
					y1.setBounds(80,15,60,25);y2.setBounds(80,15,60,25);
					m1.setBounds(200,15,60,25);m2.setBounds(200,15,60,25);
					temp1.setBounds(250,15,20,25);temp.setBounds(250,15,20,25);
					year2.setBounds(300,15,50,25);year3.setBounds(300,15,50,25);month2.setBounds(415,15,50,25);month3.setBounds(415,15,50,25);
					y3.setBounds(355,15,60,25);y4.setBounds(355,15,60,25);
					m3.setBounds(475,15,60,25);m4.setBounds(475,15,60,25);
					Fin1.setBounds(550,15,70,25);Fin2.setBounds(550,15,70,25);
					Welcome5.setBounds(10,50,700,150);Welcome6.setBounds(10,50,700,150);
					yitable1.setBounds(10,50,700,150);ystable1.setBounds(10,50,700,150);yitable1.setVisible(false);ystable1.setVisible(false);
					InCheck.add(y1);InCheck.add(m1);InCheck.add(year);InCheck.add(month);
					InCheck.add(Fin1);InCheck.add(Welcome5);InCheck.add(temp1);
					InCheck.add(year2);InCheck.add(month2);InCheck.add(y3);InCheck.add(m3);InCheck.add(yitable1);
					SaleCheck.add(y2);SaleCheck.add(m2);SaleCheck.add(year1);SaleCheck.add(month1);
					SaleCheck.add(Fin2);SaleCheck.add(Welcome6);SaleCheck.add(temp);
					SaleCheck.add(year3);SaleCheck.add(month3);SaleCheck.add(y4);SaleCheck.add(m4);SaleCheck.add(ystable1);
					Fin1.addActionListener(new ActionListener() /*进货记录*/
					{

						public void actionPerformed(ActionEvent e) {
							try {
								String te1=year.getSelectedItem().toString(),te2=month.getSelectedItem().toString();
								String te3=year2.getSelectedItem().toString(),te4=month2.getSelectedItem().toString();
								te1=te1+"-"+te2+"-1";
								te2=te3+"-"+te4+"-1";
								Welcome5.setVisible(false);
								String[] cols={"仓位号","进货编号","药品编号","药品名称","进货日期","有效期","进货数量"};
								rows=DW.timefi(te1,te2 );
								DefaultTableModel dtm = new DefaultTableModel(rows,cols);
								yitable.setModel(dtm);
								yitable1.setVisible(true);
							} catch (Exception e1) {
								e1.printStackTrace();
								System.out.println("输入错误");
								
								javax.swing.JOptionPane.showMessageDialog(
										null, "输入有误，请重新输入");
							}

						}
					});
					Fin2.addActionListener(new ActionListener() /*销售记录*/
					{

						public void actionPerformed(ActionEvent e) {
							try {
								String te1=year1.getSelectedItem().toString(),te2=month1.getSelectedItem().toString();
								String te3=year3.getSelectedItem().toString(),te4=month3.getSelectedItem().toString();
								te1=te1+"-"+te2+"-1";
								te2=te3+"-"+te4+"-1";
								Welcome6.setVisible(false);
								String[] cols={"销售编号","药品名称","柜台号","销售人工号","销售单价","销售数量","销售日期","剩余库存"};
								rows=DW.timefo(te1,te2 );
								DefaultTableModel dtm = new DefaultTableModel(rows,cols);
								ystable.setModel(dtm);
								ystable1.setVisible(true);
							} catch (Exception e1) {
								e1.printStackTrace();
								System.out.println("输入错误");
								
								javax.swing.JOptionPane.showMessageDialog(
										null, "输入有误，请重新输入");
							}

						}
					});
					
					/*逼仓巡视界面*/
					m=new TitledBorder("逼期货物");	M=new TitledBorder("量少货物");
					min=new JPanel();Min=new JPanel();min.setBorder(m);Min.setBorder(M);
					min1=new JButton("查看");			Min1=new JButton("查看");
					Welcome7=new TextArea();		Welcome8=new TextArea();
					Welcome7.setText("这里可以看到仓库中所有即将过期的药物，判定标准为6个月即将过期。\n"
							+ "如由疑问请联系开发者20160748。谢谢！");
					Welcome8.setText("这里可以看到仓库中所有库存不足的药物，判定标准为库存数量少于200。\n"
							+ "如由疑问请联系开发者20160748。谢谢！");
					datable=new JTable();			datable1=new JScrollPane(datable);
					mitable=new JTable();			mitable1=new JScrollPane(mitable);
					jPanel5 = new JPanel();
					jTabbedPane1.addTab("逼仓巡视", null, jPanel5, null);
					jPanel5.setLayout(null);
					min.setLayout(null);Min.setLayout(null);
					min.setBounds(20,10,750,220);Min.setBounds(20,230,750,220);
					jPanel5.add(min);jPanel5.add(Min);
					Welcome7.setBounds(10,50,700,150);Welcome8.setBounds(10,50,700,150);
					datable1.setBounds(10,50,700,150);mitable1.setBounds(10,50,700,150);
					datable1.setVisible(false);mitable1.setVisible(false);
					min1.setBounds(300,20,70,25);Min1.setBounds(300,20,70,25);
					min.add(Welcome7);min.add(min1);min.add(datable1);
					Min.add(mitable1);Min.add(Welcome8);Min.add(Min1);
					min1.addActionListener(new ActionListener() /*逼期货物*/
					{

						public void actionPerformed(ActionEvent e) {
							try {
								Welcome7.setVisible(false);
								String[] cols={"进货编号","药品名称","进货单价","进货数量","有效期","剩余库存"};
								rows=DW.Dat();
								DefaultTableModel dtm = new DefaultTableModel(rows,cols);
								datable.setModel(dtm);
								datable1.setVisible(true);
							} catch (Exception e1) {
								e1.printStackTrace();
								System.out.println("输入错误");
								
								javax.swing.JOptionPane.showMessageDialog(
										null, "输入有误，请重新输入");
							}

						}
					});
					Min1.addActionListener(new ActionListener() /*量少货物*/
					{

						public void actionPerformed(ActionEvent e) {
							try {
								Welcome8.setVisible(false);
								String[] cols={"进货编号","药品名称","进货单价","进货数量","有效期","剩余库存"};
								rows=DW.Min();
								DefaultTableModel dtm = new DefaultTableModel(rows,cols);
								mitable.setModel(dtm);
								mitable1.setVisible(true);
							} catch (Exception e1) {
								e1.printStackTrace();
								System.out.println("输入错误");
								
								javax.swing.JOptionPane.showMessageDialog(
										null, "输入有误，请重新输入");
							}

						}
					});
					
			
					
			pack();
			this.setResizable(false);
			this.setSize(800, 520);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}	
	
	private void Saler() {	//销售人员界面
		try {
			BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.generalNoTranslucencyShadow;
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
			UIManager.put("RootPane.setupButtonVisible", false);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		try {
				this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
				this.setTitle("销售用户管理系统");
				jTabbedPane1 = new JTabbedPane();
				getContentPane().add(jTabbedPane1, BorderLayout.CENTER);
			
				
					
					
				
				
				/*销售管理界面*/
				Sale=new EtchedBorder();
				Welcome1=new TextArea(); Welcome1.setBounds(20,20,460,380);stable=new JTable();stable1=new JScrollPane(stable);
				Welcome1.setText("************************************************************************************\n"
						+    "   本选项卡可查看所有的销售记录，并添加新的销售记录。\n"
						+ 	 "   添加新记录的同时，本程序将自动更新库存数量。\n"
						+    "   若库存不足，将无法添加新纪录\n"
							+"   如由疑问请联系20160748。谢谢！\n");
				stable1.setBounds(20,20,460,380);stable1.setVisible(false);
				S1=new JPanel();S1.setSize(200,300);
				jPanel2 = new JPanel();
				jTabbedPane1.addTab("销售管理", null, jPanel2, null);
				jPanel2.setLayout(null);
				jPanel2.setAutoscrolls(true);
				S1.setLayout(null);S1.setBounds(515,20,270,380);
				jPanel2.add(S1);jPanel2.add(Welcome1);S1.setBorder(Sale);jPanel2.add(stable1);
				SaleMs=new JButton("查看销售记录");AddSale=new JButton("增加销售记录");
				SaleMs.setBounds(80,100,120,30);AddSale.setBounds(80,300,120,30);
				S1.add(SaleMs);S1.add(AddSale);
				
				SaleMs.addActionListener(new ActionListener() 		//销售记录
				{

						public void actionPerformed(ActionEvent e) {
							try {
								Welcome1.setVisible(false);
								String[] cols={"销售编号","仓位号","销售单价","销售数量","柜台号","销售人工号","销售日期"};
								rows=DW.SaleAll();
								DefaultTableModel dtm = new DefaultTableModel(rows,cols);
								stable.setModel(dtm);
								stable1.setVisible(true);
							} catch (Exception e2) {
								e2.printStackTrace();
								javax.swing.JOptionPane.showMessageDialog(
										null, "Error");
							}
							
						}
					});
				
				
				AddSale.addActionListener(new ActionListener() 		/*售货*/
						{

							public void actionPerformed(ActionEvent e) {
								try {
									
									tempf = new JFrame(); tempjp=new JPanel();
									tempf.add(tempjp, BorderLayout.CENTER);
									tempf.setSize(250,500);
									tempjp.setLayout(null);
									tempf.setVisible(true);
									lbl0=new JLabel("销售编号");
									lbl1=new JLabel("进货编号");lbl2=new JLabel("仓位号");lbl3=new JLabel("销售单价");
									lbl4=new JLabel("销售数量");lbl5=new JLabel("柜台号");lbl6=new JLabel("售员工号");
									lbl7=new JLabel("销售日期");
									lbl8=new JLabel("注：");
									lbl9=new JLabel("填写时间时请按照：");lbl11=new JLabel("年-月-日格式填写！");
									lbl10=new JLabel("使用愉快~");
									txt0=new TextField();txt1=new TextField();txt2=new TextField();txt3=new TextField();
									txt4=new TextField();txt5=new TextField();txt6=new TextField();txt7=new TextField();
									txt8=new TextField();
									btn=new JButton("确定");
									lbl0.setBounds(30,0,60,20);txt0.setBounds(130,0,70,20);tempjp.add(lbl0);tempjp.add(txt0);
									lbl1.setBounds(30,30,60,20);txt1.setBounds(130,30,70,20);tempjp.add(lbl1);tempjp.add(txt1);
									lbl2.setBounds(30,60,60,20);txt2.setBounds(130,60,70,20);tempjp.add(lbl2);tempjp.add(txt2);
									lbl3.setBounds(30,90,60,20);txt3.setBounds(130,90,70,20);tempjp.add(lbl3);tempjp.add(txt3);
									lbl4.setBounds(30,120,60,20);txt4.setBounds(130,120,70,20);tempjp.add(lbl4);tempjp.add(txt4);
									lbl5.setBounds(30,150,60,20);txt5.setBounds(130,150,70,20);tempjp.add(lbl5);tempjp.add(txt5);
									lbl6.setBounds(30,180,70,20);txt6.setBounds(130,180,70,20);tempjp.add(lbl6);tempjp.add(txt6);
									lbl7.setBounds(30,210,60,20);txt7.setBounds(130,210,70,20);tempjp.add(lbl7);tempjp.add(txt7);
									btn.setBounds(75,250,80,30);tempjp.add(btn);
									lbl8.setBounds(30,290,50,20);tempjp.add(lbl8);
									lbl9.setBounds(40,315,150,20);tempjp.add(lbl9);
									lbl10.setBounds(40,375,150,20);tempjp.add(lbl10);
									lbl11.setBounds(75,345,150,20);tempjp.add(lbl11);
									btn.addActionListener(new ActionListener() /*进货*/
									{

										public void actionPerformed(ActionEvent e) {
											try {
												 DW.AddS1(txt0.getText(),txt1.getText(), txt2.getText(),  
														 txt3.getText(), txt4.getText(), txt5.getText(),
															txt6.getText(),txt7.getText());
													javax.swing.JOptionPane.showMessageDialog(
															null, "出库成功");
													Welcome1.setVisible(false);
													String[] cols={"销售编号","仓位号","销售单价","销售数量","柜台号","销售人工号","销售日期"};
													rows=DW.SaleAll();
													DefaultTableModel dtm = new DefaultTableModel(rows,cols);
													stable.setModel(dtm);
													stable1.setVisible(true);
													String[][] rows1=DW.RAll();
													String[] cols1={"仓位号","药品编号","进货编号","药品名称","进货日期","有效期","库存数量"};
													DefaultTableModel dtm1 = new DefaultTableModel(rows1,cols1);
													wtable.setModel(dtm1);
													wtable1.setVisible(true);
											}catch(Exception e1){
												javax.swing.JOptionPane.showMessageDialog(
														null, "输入有误，请重新输入");
											}
										}
									});
									} catch (Exception e1) {
										e1.printStackTrace();
									
									}

							}
						});	
			
				
				
				
				/*信息查询界面*/
				InF =new TitledBorder("进货信息");F1= new JPanel();F1.setBorder(InF);F1.setLayout(null);
				SaleF =new TitledBorder("销售信息");F2= new JPanel();F2.setBorder(SaleF);F2.setLayout(null);
				WareF =new TitledBorder("库存信息");F3= new JPanel();F3.setBorder(WareF);F3.setLayout(null);
				ComboBoxModel KindsM = new DefaultComboBoxModel(new String[] { "" });
				ComboBoxModel Classes = new DefaultComboBoxModel(new String[] { "" });
				ComboBoxModel Wheres = new DefaultComboBoxModel(new String[] { "" });
				Welcome2=new TextArea();Welcome3=new TextArea();Welcome4=new TextArea();
				sctable=new JTable();	sctable2=new JTable();	sctable4=new JTable();
				sctable1=new JScrollPane(sctable);	sctable3=new JScrollPane(sctable2);	sctable5=new JScrollPane(sctable4);
				jPanel3 = new JPanel();
				jTabbedPane1.addTab("信息查询", null, jPanel3, null);
				jPanel3.setLayout(null);
				k1=new JLabel("药品名称");k2=new JLabel("药品名称");k3=new JLabel("药品名称");
				c1=new JLabel("药品类别");c2=new JLabel("药品类别");c3=new JLabel("药品类别");
				w1=new JLabel("产地");
				Kinds=new JComboBox(KindsM);Kinds1=new JComboBox(KindsM);Kinds2=new JComboBox(KindsM);
				Class=new JComboBox(Classes);Class1=new JComboBox(KindsM);Class2=new JComboBox(KindsM);
				Where=new JComboBox(Wheres); low=new TextField();		high=new TextField();
				JCup();
				Find1=new JButton("查找");
				Find2=new JButton("查找");
				Find3=new JButton("查找");
				F1.setBounds(25,10,750,140);F2.setBounds(25,160,750,140);F3.setBounds(25,310,750,140);
				jPanel3.add(F1);jPanel3.add(F2);jPanel3.add(F3);
				k1.setBounds(20,13,50,25);Kinds.setBounds(80,13,70,25);
				c1.setBounds(170,13,50,25);Class.setBounds(240,13,70,25);
				w1.setBounds(340,13,50,25);Where.setBounds(400,13,70,25);Find1.setBounds(500,13,70,25);
				Welcome2.setBounds(20,40,710,90);sctable1.setBounds(20,40,710,90);sctable1.setVisible(false);
				F1.add(k1);F1.add(c1);F1.add(w1);F1.add(Welcome2);F1.add(sctable1);
				F1.add(Kinds);F1.add(Class);F1.add(Where);F1.add(Find1);
				k2.setBounds(20,13,50,25);Kinds1.setBounds(80,13,70,25);
				c2.setBounds(170,13,50,25);Class1.setBounds(240,13,70,25);Find2.setBounds(500,13,70,25);
				Welcome3.setBounds(20,40,710,90);sctable3.setBounds(20,40,710,90);sctable3.setVisible(false);
				F2.add(k2);F2.add(c2);F2.add(Welcome3);
				F2.add(Kinds1);F2.add(Class1);F2.add(Find2);F2.add(sctable3);
				k3.setBounds(20,13,50,25);Kinds2.setBounds(80,13,70,25);
				c3.setBounds(170,13,50,25);Class2.setBounds(240,13,70,25);Find3.setBounds(500,13,70,25);
				Welcome4.setBounds(20,40,710,90);sctable5.setBounds(20,40,710,90);sctable5.setVisible(false);
				F3.add(k3);F3.add(c3);F3.add(Welcome4);
				F3.add(Kinds2);F3.add(Class2);F3.add(Find3);F3.add(sctable5);
				
				Find1.addActionListener(new ActionListener() /*进货记录*/
				{

					public void actionPerformed(ActionEvent e) {
						try {
							String te1=Kinds.getSelectedItem().toString(),te2=Class.getSelectedItem().toString(),te3=Where.getSelectedItem().toString();
							if(te1.equals(""))
								te1=null;
							if(te2.equals(""))
								te2=null;
							if(te3.equals(""))
									te3=null;
							Welcome2.setVisible(false);
							String[] cols={"进货编号","药品名称","药品类别","产地","进货日期","有效期","进货单价","进货数量"};
							rows=DW.F1(te1,te2,te3 );
							DefaultTableModel dtm = new DefaultTableModel(rows,cols);
							sctable.setModel(dtm);
							sctable1.setVisible(true);
						} catch (Exception e1) {
							e1.printStackTrace();
							System.out.println("输入错误");
							
							javax.swing.JOptionPane.showMessageDialog(
									null, "输入有误，请重新输入");
						}

					}
				});
				Find2.addActionListener(new ActionListener() /*销售记录*/
				{

					public void actionPerformed(ActionEvent e) {
						try {
							String te1=Kinds1.getSelectedItem().toString(),te2=Class1.getSelectedItem().toString();
							if(te1.equals(""))
								te1=null;
							if(te2.equals(""))
								te2=null;
							Welcome3.setVisible(false);
							String[] cols={"销售编号","仓位号","药品名称","药品类别","销售单价","销售数量","柜台号","销售人工号","销售日期"};
							rows=DW.F2(te1,te2 );
							DefaultTableModel dtm = new DefaultTableModel(rows,cols);
							sctable2.setModel(dtm);
							sctable3.setVisible(true);
						} catch (Exception e1) {
							e1.printStackTrace();
							System.out.println("输入错误");
							
							javax.swing.JOptionPane.showMessageDialog(
									null, "输入有误，请重新输入");
						}

					}
				});
				Find3.addActionListener(new ActionListener() /*库存记录*/
				{

					public void actionPerformed(ActionEvent e) {
						try {
							String te1=Kinds2.getSelectedItem().toString(),te2=Class2.getSelectedItem().toString();
							if(te1.equals(""))
								te1=null;
							if(te2.equals(""))
								te2=null;
							Welcome4.setVisible(false);
							String[] cols={"仓位号","药品名称","药品类别","进货日期","有效期","库存数量"};
							rows=DW.F3(te1,te2 );
							DefaultTableModel dtm = new DefaultTableModel(rows,cols);
							sctable4.setModel(dtm);
							sctable5.setVisible(true);
						} catch (Exception e1) {
							e1.printStackTrace();
							System.out.println("输入错误");
							
							javax.swing.JOptionPane.showMessageDialog(
									null, "输入有误，请重新输入");
						}

					}
				});
				
					
					/*逼仓巡视界面*/
					m=new TitledBorder("逼期货物");	M=new TitledBorder("量少货物");
					min=new JPanel();Min=new JPanel();min.setBorder(m);Min.setBorder(M);
					min1=new JButton("查看");			Min1=new JButton("查看");
					Welcome7=new TextArea();		Welcome8=new TextArea();
					Welcome7.setText("这里可以看到仓库中所有即将过期的药物，判定标准为6个月即将过期。\n"
							+ "如由疑问请联系20160748。谢谢！");
					Welcome8.setText("这里可以看到仓库中所有库存不足的药物，判定标准为库存数量少于200。\n"
							+ "如由疑问请联系20160748。谢谢！");
					datable=new JTable();			datable1=new JScrollPane(datable);
					mitable=new JTable();			mitable1=new JScrollPane(mitable);
					jPanel5 = new JPanel();
					jTabbedPane1.addTab("逼仓巡视", null, jPanel5, null);
					jPanel5.setLayout(null);
					min.setLayout(null);Min.setLayout(null);
					min.setBounds(20,10,750,220);Min.setBounds(20,230,750,220);
					jPanel5.add(min);jPanel5.add(Min);
					Welcome7.setBounds(10,50,700,150);Welcome8.setBounds(10,50,700,150);
					datable1.setBounds(10,50,700,150);mitable1.setBounds(10,50,700,150);
					datable1.setVisible(false);mitable1.setVisible(false);
					min1.setBounds(300,20,70,25);Min1.setBounds(300,20,70,25);
					min.add(Welcome7);min.add(min1);min.add(datable1);
					Min.add(mitable1);Min.add(Welcome8);Min.add(Min1);
					min1.addActionListener(new ActionListener() /*逼期货物*/
					{

						public void actionPerformed(ActionEvent e) {
							try {
								Welcome7.setVisible(false);
								String[] cols={"进货编号","药品名称","进货单价","进货数量","有效期","剩余库存"};
								rows=DW.Dat();
								DefaultTableModel dtm = new DefaultTableModel(rows,cols);
								datable.setModel(dtm);
								datable1.setVisible(true);
							} catch (Exception e1) {
								e1.printStackTrace();
								System.out.println("输入错误");
								
								javax.swing.JOptionPane.showMessageDialog(
										null, "输入有误，请重新输入");
							}

						}
					});
					Min1.addActionListener(new ActionListener() /*量少货物*/
					{

						public void actionPerformed(ActionEvent e) {
							try {
								Welcome8.setVisible(false);
								String[] cols={"进货编号","药品名称","进货单价","进货数量","有效期","剩余库存"};
								rows=DW.Min();
								DefaultTableModel dtm = new DefaultTableModel(rows,cols);
								mitable.setModel(dtm);
								mitable1.setVisible(true);
							} catch (Exception e1) {
								e1.printStackTrace();
								System.out.println("输入错误");
								
								javax.swing.JOptionPane.showMessageDialog(
										null, "输入有误，请重新输入");
							}

						}
					});
					
			pack();
			this.setResizable(false);
			this.setSize(800, 500);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	private void Manager() {	//管理员界面
		try {
			BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.generalNoTranslucencyShadow;
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
			UIManager.put("RootPane.setupButtonVisible", false);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		try {
			this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			this.setTitle("管理员用户管理系统");
			jTabbedPane1 = new JTabbedPane();
			getContentPane().add(jTabbedPane1, BorderLayout.CENTER);
		
			
			/*仓库管理界面*/
			Ware1 =new TitledBorder("药物信息");T1= new JPanel();T1.setBorder(Ware1);
			Ware2 =new TitledBorder("仓储信息");T2= new JPanel();T2.setBorder(Ware2);
			Ware3 =new TitledBorder("进货/出货");T3= new JPanel();T3.setBorder(Ware3);
			Ware4 =new TitledBorder("进货信息");T4= new JPanel();T4.setBorder(Ware4);
			jPanel1 = new JPanel();
			jTabbedPane1.addTab("仓库管理", null, jPanel1, null);
			jPanel1.setLayout(null);			
			Welcome=new TextArea();				wtable=new JTable();
			Welcome.setBounds(20,20,460,380);	
			wtable1=new JScrollPane(wtable);wtable1.setBounds(20,20,460,380);wtable1.setVisible(false);
			Welcome.setText(
					"***********欢迎使用Diango的药店销售管理系统*************\n"
					+ "1、在库药物信息键可显示所有在库药物，查找键可查找相关药物详细信息\n"
					+ "2、所有记录可查看所有药物仓储数量\n"
					+ "3、进/出货只可添加单条信息"
					);
			jPanel1.add(Welcome);jPanel1.add(wtable1);
			T1.setLayout(null);T2.setLayout(null);T3.setLayout(null);T4.setLayout(null);
			T1.setBounds(515,20,270,80);T2.setBounds(515,120,270,80);
			T3.setBounds(515,220,270,80);T4.setBounds(515,320,270,80);
			jPanel1.add(T1);jPanel1.add(T2);jPanel1.add(T3);jPanel1.add(T4);
			MedicineMs=new JButton("在库药物信息");Search1=new JButton("查找");
			MedicineMs.setBounds(10,30,120,30);Search1.setBounds(160,30,100,30);
			AllMs=new JButton("仓储记录");Search2=new JButton("查找");
			AllMs.setBounds(10,30,120,30);Search2.setBounds(160,30,100,30);
			Insert=new JButton("进货");Out=new JButton("出货");
			Insert.setBounds(10,30,120,30);Out.setBounds(160,30,100,30);
			WareMs=new JButton("进货记录");
			WareMs.setBounds(10,30,120,30);
			T1.add(MedicineMs);T1.add(Search1);T2.add(AllMs);T2.add(Search2);
			T3.add(Insert);T3.add(Out);T4.add(WareMs);
			
			
			
			{
				MedicineMs.addActionListener(new ActionListener() /*在库药物信息*/
				{

					public void actionPerformed(ActionEvent e) {
						try {
							Welcome.setVisible(false);
							String[] cols={"药品编号","药品类别","药品名称"};
							rows=DW.Rdrug();
							DefaultTableModel dtm = new DefaultTableModel(rows,cols);
							wtable.setModel(dtm);
							wtable1.setVisible(true);
						} catch (Exception e1) {
							e1.printStackTrace();
							System.out.println("输入错误");
							
							javax.swing.JOptionPane.showMessageDialog(
									null, "输入有误，请重新输入");
						}

					}
				});
			}
			Search1.addActionListener(new ActionListener() /*查找在库药物信息*/
				{

					public void actionPerformed(ActionEvent e) {
						try {
							tempf = new JFrame(); tempjp=new JPanel();
							tempf.add(tempjp, BorderLayout.CENTER);
							tempf.setSize(250,300);
							tempjp.setLayout(null);
							tempf.setVisible(true);
							lbl1=new JLabel("药品名称：");lbl2=new JLabel("药品类别：");lbl3=new JLabel("药品产地：");
							txt1=new TextField();txt2=new TextField();txt3=new TextField();
							btn=new JButton("确定");
							lbl1.setBounds(20,20,80,20);txt1.setBounds(120,20,70,20);
							lbl2.setBounds(20,60,80,20);txt2.setBounds(120,60,70,20);
							lbl3.setBounds(20,100,80,20);txt3.setBounds(120,100,70,20);
							btn.setBounds(85,150,80,30);
							tempjp.add(lbl1);tempjp.add(lbl2);tempjp.add(lbl3);
							tempjp.add(txt1);tempjp.add(txt2);tempjp.add(txt3);tempjp.add(btn);
							btn.addActionListener(new ActionListener() /*查找在库药物信息*/
							{

								public void actionPerformed(ActionEvent e) {
									try {
											if(!(txt1.getText().equals("")) && !(txt2.getText().equals("")) &&!(txt3.getText().equals(""))){
													Welcome.setVisible(false);
													String[] cols={"进货编号","药品编号","药品名称","药品类别","产地","进货日期"};
													rows=DW.SearchM3(txt1.getText(),txt2.getText(),txt3.getText());
													DefaultTableModel dtm = new DefaultTableModel(rows,cols);
													wtable.setModel(dtm);
													wtable1.setVisible(true);
													tempf.dispose();
											}else if(!(txt1.getText().equals("")) && !(txt2.getText().equals("")) ){
													Welcome.setVisible(false);
													String[] cols={"进货编号","药品编号","药品名称","药品类别","产地","进货日期"};
													rows=DW.SearchM2(txt1.getText(),txt2.getText());
													DefaultTableModel dtm = new DefaultTableModel(rows,cols);
													wtable.setModel(dtm);
													wtable1.setVisible(true);
													tempf.dispose();
											}else if(!(txt1.getText().equals("")) ){
													Welcome.setVisible(false);
													String[] cols={"进货编号","药品编号","药品名称","药品类别","产地","进货日期"};
													rows=DW.SearchM1(txt1.getText());
													DefaultTableModel dtm = new DefaultTableModel(rows,cols);
													wtable.setModel(dtm);
													wtable1.setVisible(true);
													tempf.dispose();
											}else{
												javax.swing.JOptionPane.showMessageDialog(
														null, "请输入数据");
											}
									}catch(Exception e1){
										javax.swing.JOptionPane.showMessageDialog(
												null, "输入有误，请重新输入");
									}	
								}
							});
							} catch (Exception e1) {
								e1.printStackTrace();
								System.out.println("输入错误");
							
								javax.swing.JOptionPane.showMessageDialog(
									null, "输入有误，请重新输入");
							}

					}
				});
		
			AllMs.addActionListener(new ActionListener() /*仓储记录*/
				{

					public void actionPerformed(ActionEvent e) {
						try {
							Welcome.setVisible(false);
							String[] cols={"仓位号","药品编号","进货编号","药品名称","进货日期","有效期","库存数量"};
							rows=DW.RAll();
							DefaultTableModel dtm = new DefaultTableModel(rows,cols);
							wtable.setModel(dtm);
							wtable1.setVisible(true);
						} catch (Exception e1) {
							e1.printStackTrace();
							System.out.println("输入错误");
							
							javax.swing.JOptionPane.showMessageDialog(
									null, "输入有误，请重新输入");
						}

					}
				});
			
			Search2.addActionListener(new ActionListener() /*查找药物存储信息*/
				{

					public void actionPerformed(ActionEvent e) {
						try {
							tempf = new JFrame(); tempjp=new JPanel();
							tempf.add(tempjp, BorderLayout.CENTER);
							tempf.setSize(250,300);
							tempjp.setLayout(null);
							tempf.setVisible(true);
							lbl1=new JLabel("药品名称：");lbl2=new JLabel("药品类别：");
							txt1=new TextField();txt2=new TextField();
							btn=new JButton("确定");
							lbl1.setBounds(20,20,80,20);txt1.setBounds(120,20,70,20);
							lbl2.setBounds(20,60,80,20);txt2.setBounds(120,60,70,20);
							btn.setBounds(85,150,80,30);
							tempjp.add(lbl1);tempjp.add(lbl2);
							tempjp.add(txt1);tempjp.add(txt2);tempjp.add(btn);
							btn.addActionListener(new ActionListener()      /*查找在库药物信息*/
							{

								public void actionPerformed(ActionEvent e) {
									try {
											if(!(txt1.getText().equals("")) && !(txt2.getText().equals("")) ){
													Welcome.setVisible(false);
													String[] cols={"仓位号","药品编号","进货编号","药品名称","进货日期","有效期","库存数量"};
													rows=DW.SearchR1(txt1.getText(),txt2.getText());
													DefaultTableModel dtm = new DefaultTableModel(rows,cols);
													wtable.setModel(dtm);
													wtable1.setVisible(true);
													tempf.dispose();
											}else if(!(txt1.getText().equals(""))){
													Welcome.setVisible(false);
													String[] cols={"仓位号","药品编号","进货编号","药品名称","进货日期","有效期","库存数量"};
													rows=DW.SearchR2(txt1.getText());
													DefaultTableModel dtm = new DefaultTableModel(rows,cols);
													wtable.setModel(dtm);
													wtable1.setVisible(true);
													tempf.dispose();
											}else if(!(txt2.getText().equals("")) ){
													Welcome.setVisible(false);
													String[] cols={"仓位号","药品编号","进货编号","药品名称","进货日期","有效期","库存数量"};
													rows=DW.SearchR3(txt2.getText());
													DefaultTableModel dtm = new DefaultTableModel(rows,cols);
													wtable.setModel(dtm);
													wtable1.setVisible(true);
													tempf.dispose();
											}else{
												javax.swing.JOptionPane.showMessageDialog(
														null, "请输入数据");
											}
									}catch(Exception e1){
										javax.swing.JOptionPane.showMessageDialog(
												null, "输入有误，请重新输入");
									}	
								}
							});
						} catch (Exception e1) {
							e1.printStackTrace();
							System.out.println("输入错误");
							
							javax.swing.JOptionPane.showMessageDialog(
									null, "输入有误，请重新输入");
						}

					}
				});
			
			Insert.addActionListener(new ActionListener() /*进货*/
				{

					public void actionPerformed(ActionEvent e) {
						try {
							
							tempf = new JFrame(); tempjp=new JPanel();
							tempf.add(tempjp, BorderLayout.CENTER);
							tempf.setSize(250,500);
							tempjp.setLayout(null);
							tempf.setVisible(true);
							lbl1=new JLabel("进货编号");lbl2=new JLabel("药品编号");lbl3=new JLabel("生产日期");
							lbl4=new JLabel("进货日期");lbl5=new JLabel("有效期");lbl6=new JLabel("进货数量");
							lbl7=new JLabel("进货单价");
							lbl8=new JLabel("注：");
							lbl9=new JLabel("填写时间时请按照：");lbl11=new JLabel("年-月-日格式填写！");
							lbl10=new JLabel("使用愉快~");
							txt1=new TextField();txt2=new TextField();txt3=new TextField();
							txt4=new TextField();txt5=new TextField();txt6=new TextField();txt7=new TextField();
							btn=new JButton("确定");
							lbl1.setBounds(30,20,50,20);txt1.setBounds(130,20,70,20);tempjp.add(lbl1);tempjp.add(txt1);
							lbl2.setBounds(30,50,50,20);txt2.setBounds(130,50,70,20);tempjp.add(lbl2);tempjp.add(txt2);
							lbl3.setBounds(30,80,50,20);txt3.setBounds(130,80,70,20);tempjp.add(lbl3);tempjp.add(txt3);
							lbl4.setBounds(30,110,50,20);txt4.setBounds(130,110,70,20);tempjp.add(lbl4);tempjp.add(txt4);
							lbl5.setBounds(30,140,50,20);txt5.setBounds(130,140,70,20);tempjp.add(lbl5);tempjp.add(txt5);
							lbl6.setBounds(30,170,50,20);txt6.setBounds(130,170,70,20);tempjp.add(lbl6);tempjp.add(txt6);
							lbl7.setBounds(30,200,50,20);txt7.setBounds(130,200,70,20);tempjp.add(lbl7);tempjp.add(txt7);
							btn.setBounds(75,250,80,30);tempjp.add(btn);
							lbl8.setBounds(30,290,50,20);tempjp.add(lbl8);
							lbl9.setBounds(40,315,150,20);tempjp.add(lbl9);
							lbl10.setBounds(40,375,150,20);tempjp.add(lbl10);
							lbl11.setBounds(75,345,150,20);tempjp.add(lbl11);
							btn.addActionListener(new ActionListener() /*进货*/
							{

								public void actionPerformed(ActionEvent e) {
									try {
										 DW.InsertR(txt1.getText(),txt2.getText(), 
													txt3.getText(), txt4.getText(), txt5.getText(),
													Integer.parseInt(txt6.getText()),txt7.getText());
											javax.swing.JOptionPane.showMessageDialog(
													null, "插入成功");
											Welcome.setVisible(false);
											String[] cols={"进货编号","药品编号","生产日期","进货日期","有效期","进货数量","进货单价"};
											rows=DW.InputAll();
											DefaultTableModel dtm = new DefaultTableModel(rows,cols);
											wtable.setModel(dtm);
											wtable1.setVisible(true);
									}catch(Exception e1){
										javax.swing.JOptionPane.showMessageDialog(
												null, "输入有误，请重新输入");
									}
								}
							});
							} catch (Exception e1) {
								e1.printStackTrace();
							
							}

					}
				});
			
			WareMs.addActionListener(new ActionListener() /*进货记录*/
				{

					public void actionPerformed(ActionEvent e) {
						try {
							Welcome.setVisible(false);
							String[] cols={"进货编号","药品编号","生产日期","进货日期","有效期","进货数量","进货单价"};
							rows=DW.InputAll();
							DefaultTableModel dtm = new DefaultTableModel(rows,cols);
							wtable.setModel(dtm);
							wtable1.setVisible(true);
						} catch (Exception e1) {
							e1.printStackTrace();
							System.out.println("输入错误");
							
							javax.swing.JOptionPane.showMessageDialog(
									null, "输入有误，请重新输入");
						}

					}
				});
			
			Out.addActionListener(new ActionListener() /*出货*/
				{

					public void actionPerformed(ActionEvent e) {
						try {
							tempf = new JFrame(); tempjp=new JPanel();
							tempf.add(tempjp, BorderLayout.CENTER);
							tempf.setSize(150,200);
							tempjp.setLayout(null);
							tempf.setVisible(true);
							lbl1=new JLabel("仓位号：");txt1=new TextField();
							lbl2=new JLabel("数量：");txt2=new TextField();
							btn=new JButton("确定");
							lbl1.setBounds(10,20,50,20);lbl2.setBounds(10,60,50,20);
							txt1.setBounds(80,20,50,20);txt2.setBounds(80,60,50,20);
							btn.setBounds(45,100,60,20);
							tempjp.add(lbl1);tempjp.add(lbl2);tempjp.add(txt1);tempjp.add(txt2);tempjp.add(btn);
							btn.addActionListener(new ActionListener() /*出货*/
							{

								public void actionPerformed(ActionEvent e) {
									try {
											DW.OutR(Integer.parseInt(txt1.getText()),Integer.parseInt(txt2.getText()));
											Welcome.setVisible(false);
											String[] cols={"仓位号","药品编号","进货编号","药品名称","进货日期","有效期","库存数量"};
											rows=DW.RAll();
											DefaultTableModel dtm = new DefaultTableModel(rows,cols);
											wtable.setModel(dtm);
											wtable1.setVisible(true);
									}catch(Exception e1){
										
									}
								}
							});
							} catch (Exception e1) {
								e1.printStackTrace();
								System.out.println("输入错误");
								javax.swing.JOptionPane.showMessageDialog(
										null, "输入有误，请重新输入");
							}

						}
					});
			
			
		
		
			/*销售管理界面*/
			Sale=new EtchedBorder();
			Welcome1=new TextArea(); Welcome1.setBounds(20,20,460,380);stable=new JTable();stable1=new JScrollPane(stable);
			Welcome1.setText("************************************************************************************\n"
					+    "   本选项卡可查看所有的销售记录，并添加新的销售记录。\n"
					+ 	 "   添加新记录的同时，本程序将自动更新库存数量。\n"
					+    "   若库存不足，将无法添加新纪录\n"
						+"   如由疑问请联系20160748。谢谢！\n");
			stable1.setBounds(20,20,460,380);stable1.setVisible(false);
			S1=new JPanel();S1.setSize(200,300);
			jPanel2 = new JPanel();
			jTabbedPane1.addTab("销售管理", null, jPanel2, null);
			jPanel2.setLayout(null);
			jPanel2.setAutoscrolls(true);
			S1.setLayout(null);S1.setBounds(515,20,270,380);
			jPanel2.add(S1);jPanel2.add(Welcome1);S1.setBorder(Sale);jPanel2.add(stable1);
			SaleMs=new JButton("查看销售记录");AddSale=new JButton("增加销售记录");
			SaleMs.setBounds(80,100,120,30);AddSale.setBounds(80,300,120,30);
			S1.add(SaleMs);S1.add(AddSale);
			
			SaleMs.addActionListener(new ActionListener() 		//销售记录
			{

					public void actionPerformed(ActionEvent e) {
						try {
							Welcome1.setVisible(false);
							String[] cols={"销售编号","仓位号","销售单价","销售数量","柜台号","销售人工号","销售日期"};
							rows=DW.SaleAll();
							DefaultTableModel dtm = new DefaultTableModel(rows,cols);
							stable.setModel(dtm);
							stable1.setVisible(true);
						} catch (Exception e2) {
							e2.printStackTrace();
							javax.swing.JOptionPane.showMessageDialog(
									null, "Error");
						}
						
					}
				});
			
			
			AddSale.addActionListener(new ActionListener() 		/*售货*/
					{

						public void actionPerformed(ActionEvent e) {
							try {
								
								tempf = new JFrame(); tempjp=new JPanel();
								tempf.add(tempjp, BorderLayout.CENTER);
								tempf.setSize(250,500);
								tempjp.setLayout(null);
								tempf.setVisible(true);
								lbl0=new JLabel("销售编号");
								lbl1=new JLabel("进货编号");lbl2=new JLabel("仓位号");lbl3=new JLabel("销售单价");
								lbl4=new JLabel("销售数量");lbl5=new JLabel("柜台号");lbl6=new JLabel("售员工号");
								lbl7=new JLabel("销售日期");
								lbl8=new JLabel("注：");
								lbl9=new JLabel("填写时间时请按照：");lbl11=new JLabel("年-月-日格式填写！");
								lbl10=new JLabel("使用愉快~");
								txt0=new TextField();txt1=new TextField();txt2=new TextField();txt3=new TextField();
								txt4=new TextField();txt5=new TextField();txt6=new TextField();txt7=new TextField();
								txt8=new TextField();
								btn=new JButton("确定");
								lbl0.setBounds(30,0,60,20);txt0.setBounds(130,0,70,20);tempjp.add(lbl0);tempjp.add(txt0);
								lbl1.setBounds(30,30,60,20);txt1.setBounds(130,30,70,20);tempjp.add(lbl1);tempjp.add(txt1);
								lbl2.setBounds(30,60,60,20);txt2.setBounds(130,60,70,20);tempjp.add(lbl2);tempjp.add(txt2);
								lbl3.setBounds(30,90,60,20);txt3.setBounds(130,90,70,20);tempjp.add(lbl3);tempjp.add(txt3);
								lbl4.setBounds(30,120,60,20);txt4.setBounds(130,120,70,20);tempjp.add(lbl4);tempjp.add(txt4);
								lbl5.setBounds(30,150,60,20);txt5.setBounds(130,150,70,20);tempjp.add(lbl5);tempjp.add(txt5);
								lbl6.setBounds(30,180,70,20);txt6.setBounds(130,180,70,20);tempjp.add(lbl6);tempjp.add(txt6);
								lbl7.setBounds(30,210,60,20);txt7.setBounds(130,210,70,20);tempjp.add(lbl7);tempjp.add(txt7);
								btn.setBounds(75,250,80,30);tempjp.add(btn);
								lbl8.setBounds(30,290,50,20);tempjp.add(lbl8);
								lbl9.setBounds(40,315,150,20);tempjp.add(lbl9);
								lbl10.setBounds(40,375,150,20);tempjp.add(lbl10);
								lbl11.setBounds(75,345,150,20);tempjp.add(lbl11);
								btn.addActionListener(new ActionListener() /*进货*/
								{

									public void actionPerformed(ActionEvent e) {
										try {
											 DW.AddS1(txt0.getText(),txt1.getText(), txt2.getText(),  
													 txt3.getText(), txt4.getText(), txt5.getText(),
														txt6.getText(),txt7.getText());
												javax.swing.JOptionPane.showMessageDialog(
														null, "出库成功");
												Welcome1.setVisible(false);
												String[] cols={"销售编号","仓位号","销售单价","销售数量","柜台号","销售人工号","销售日期"};
												rows=DW.SaleAll();
												DefaultTableModel dtm = new DefaultTableModel(rows,cols);
												stable.setModel(dtm);
												stable1.setVisible(true);
												String[][] rows1=DW.RAll();
												String[] cols1={"仓位号","药品编号","进货编号","药品名称","进货日期","有效期","库存数量"};
												DefaultTableModel dtm1 = new DefaultTableModel(rows1,cols1);
												wtable.setModel(dtm1);
												wtable1.setVisible(true);
										}catch(Exception e1){
											javax.swing.JOptionPane.showMessageDialog(
													null, "输入有误，请重新输入");
										}
									}
								});
								} catch (Exception e1) {
									e1.printStackTrace();
								
								}

						}
					});	
			
		
			
			
			
				/*信息查询界面*/
				InF =new TitledBorder("进货信息");F1= new JPanel();F1.setBorder(InF);F1.setLayout(null);
				SaleF =new TitledBorder("销售信息");F2= new JPanel();F2.setBorder(SaleF);F2.setLayout(null);
				WareF =new TitledBorder("库存信息");F3= new JPanel();F3.setBorder(WareF);F3.setLayout(null);
				ComboBoxModel KindsM = new DefaultComboBoxModel(new String[] { "" });
				ComboBoxModel Classes = new DefaultComboBoxModel(new String[] { "" });
				ComboBoxModel Wheres = new DefaultComboBoxModel(new String[] { "" });
				Welcome2=new TextArea();Welcome3=new TextArea();Welcome4=new TextArea();
				sctable=new JTable();	sctable2=new JTable();	sctable4=new JTable();
				sctable1=new JScrollPane(sctable);	sctable3=new JScrollPane(sctable2);	sctable5=new JScrollPane(sctable4);
				jPanel3 = new JPanel();
				jTabbedPane1.addTab("信息查询", null, jPanel3, null);
				jPanel3.setLayout(null);
				k1=new JLabel("药品名称");k2=new JLabel("药品名称");k3=new JLabel("药品名称");
				c1=new JLabel("药品类别");c2=new JLabel("药品类别");c3=new JLabel("药品类别");
				w1=new JLabel("产地");
				Kinds=new JComboBox(KindsM);Kinds1=new JComboBox(KindsM);Kinds2=new JComboBox(KindsM);
				Class=new JComboBox(Classes);Class1=new JComboBox(KindsM);Class2=new JComboBox(KindsM);
				Where=new JComboBox(Wheres); low=new TextField();		high=new TextField();
				JCup();
				Find1=new JButton("查找");
				Find2=new JButton("查找");
				Find3=new JButton("查找");
				F1.setBounds(25,10,750,140);F2.setBounds(25,160,750,140);F3.setBounds(25,310,750,140);
				jPanel3.add(F1);jPanel3.add(F2);jPanel3.add(F3);
				k1.setBounds(20,13,50,25);Kinds.setBounds(80,13,70,25);
				c1.setBounds(170,13,50,25);Class.setBounds(240,13,70,25);
				w1.setBounds(340,13,50,25);Where.setBounds(400,13,70,25);Find1.setBounds(500,13,70,25);
				Welcome2.setBounds(20,40,710,90);sctable1.setBounds(20,40,710,90);sctable1.setVisible(false);
				F1.add(k1);F1.add(c1);F1.add(w1);F1.add(Welcome2);F1.add(sctable1);
				F1.add(Kinds);F1.add(Class);F1.add(Where);F1.add(Find1);
				k2.setBounds(20,13,50,25);Kinds1.setBounds(80,13,70,25);
				c2.setBounds(170,13,50,25);Class1.setBounds(240,13,70,25);Find2.setBounds(500,13,70,25);
				Welcome3.setBounds(20,40,710,90);sctable3.setBounds(20,40,710,90);sctable3.setVisible(false);
				F2.add(k2);F2.add(c2);F2.add(Welcome3);
				F2.add(Kinds1);F2.add(Class1);F2.add(Find2);F2.add(sctable3);
				k3.setBounds(20,13,50,25);Kinds2.setBounds(80,13,70,25);
				c3.setBounds(170,13,50,25);Class2.setBounds(240,13,70,25);Find3.setBounds(500,13,70,25);
				Welcome4.setBounds(20,40,710,90);sctable5.setBounds(20,40,710,90);sctable5.setVisible(false);
				F3.add(k3);F3.add(c3);F3.add(Welcome4);
				F3.add(Kinds2);F3.add(Class2);F3.add(Find3);F3.add(sctable5);
				
				Find1.addActionListener(new ActionListener() /*进货记录*/
				{

					public void actionPerformed(ActionEvent e) {
						try {
							String te1=Kinds.getSelectedItem().toString(),te2=Class.getSelectedItem().toString(),te3=Where.getSelectedItem().toString();
							if(te1.equals(""))
								te1=null;
							if(te2.equals(""))
								te2=null;
							if(te3.equals(""))
									te3=null;
							Welcome2.setVisible(false);
							String[] cols={"进货编号","药品名称","药品类别","产地","进货日期","有效期","进货单价","进货数量"};
							rows=DW.F1(te1,te2,te3 );
							DefaultTableModel dtm = new DefaultTableModel(rows,cols);
							sctable.setModel(dtm);
							sctable1.setVisible(true);
						} catch (Exception e1) {
							e1.printStackTrace();
							System.out.println("输入错误");
							
							javax.swing.JOptionPane.showMessageDialog(
									null, "输入有误，请重新输入");
						}

					}
				});
				Find2.addActionListener(new ActionListener() /*销售记录*/
				{

					public void actionPerformed(ActionEvent e) {
						try {
							String te1=Kinds1.getSelectedItem().toString(),te2=Class1.getSelectedItem().toString();
							if(te1.equals(""))
								te1=null;
							if(te2.equals(""))
								te2=null;
							Welcome3.setVisible(false);
							String[] cols={"销售编号","仓位号","药品名称","药品类别","销售单价","销售数量","柜台号","销售人工号","销售日期"};
							rows=DW.F2(te1,te2 );
							DefaultTableModel dtm = new DefaultTableModel(rows,cols);
							sctable2.setModel(dtm);
							sctable3.setVisible(true);
						} catch (Exception e1) {
							e1.printStackTrace();
							System.out.println("输入错误");
							
							javax.swing.JOptionPane.showMessageDialog(
									null, "输入有误，请重新输入");
						}

					}
				});
				Find3.addActionListener(new ActionListener() /*库存记录*/
				{

					public void actionPerformed(ActionEvent e) {
						try {
							String te1=Kinds2.getSelectedItem().toString(),te2=Class2.getSelectedItem().toString();
							if(te1.equals(""))
								te1=null;
							if(te2.equals(""))
								te2=null;
							Welcome4.setVisible(false);
							String[] cols={"仓位号","药品名称","药品类别","进货日期","有效期","库存数量"};
							rows=DW.F3(te1,te2 );
							DefaultTableModel dtm = new DefaultTableModel(rows,cols);
							sctable4.setModel(dtm);
							sctable5.setVisible(true);
						} catch (Exception e1) {
							e1.printStackTrace();
							System.out.println("输入错误");
							
							javax.swing.JOptionPane.showMessageDialog(
									null, "输入有误，请重新输入");
						}

					}
				});
				
				
				/*逼仓巡视界面*/
				m=new TitledBorder("逼期货物");	M=new TitledBorder("量少货物");
				min=new JPanel();Min=new JPanel();min.setBorder(m);Min.setBorder(M);
				min1=new JButton("查看");			Min1=new JButton("查看");
				Welcome7=new TextArea();		Welcome8=new TextArea();
				Welcome7.setText("这里可以看到仓库中所有即将过期的药物，判定标准为6个月即将过期。\n"
						+ "如由疑问请联系20160748。谢谢！");
				Welcome8.setText("这里可以看到仓库中所有库存不足的药物，判定标准为库存数量少于200。\n"
						+ "如由疑问请联系20160748。谢谢！");
				datable=new JTable();			datable1=new JScrollPane(datable);
				mitable=new JTable();			mitable1=new JScrollPane(mitable);
				jPanel5 = new JPanel();
				jTabbedPane1.addTab("逼仓巡视", null, jPanel5, null);
				jPanel5.setLayout(null);
				min.setLayout(null);Min.setLayout(null);
				min.setBounds(20,10,750,220);Min.setBounds(20,230,750,220);
				jPanel5.add(min);jPanel5.add(Min);
				Welcome7.setBounds(10,50,700,150);Welcome8.setBounds(10,50,700,150);
				datable1.setBounds(10,50,700,150);mitable1.setBounds(10,50,700,150);
				datable1.setVisible(false);mitable1.setVisible(false);
				min1.setBounds(300,20,70,25);Min1.setBounds(300,20,70,25);
				min.add(Welcome7);min.add(min1);min.add(datable1);
				Min.add(mitable1);Min.add(Welcome8);Min.add(Min1);
				min1.addActionListener(new ActionListener() /*逼期货物*/
				{

					public void actionPerformed(ActionEvent e) {
						try {
							Welcome7.setVisible(false);
							String[] cols={"进货编号","药品名称","进货单价","进货数量","有效期","剩余库存"};
							rows=DW.Dat();
							DefaultTableModel dtm = new DefaultTableModel(rows,cols);
							datable.setModel(dtm);
							datable1.setVisible(true);
						} catch (Exception e1) {
							e1.printStackTrace();
							System.out.println("输入错误");
							
							javax.swing.JOptionPane.showMessageDialog(
									null, "输入有误，请重新输入");
						}

					}
				});
				Min1.addActionListener(new ActionListener() /*量少货物*/
				{
					
					public void actionPerformed(ActionEvent e) {
						try {
							Welcome8.setVisible(false);
							String[] cols={"进货编号","药品名称","进货单价","进货数量","有效期","剩余库存"};
							rows=DW.Min();
							DefaultTableModel dtm = new DefaultTableModel(rows,cols);
							mitable.setModel(dtm);
							mitable1.setVisible(true);
						} catch (Exception e1) {
							e1.printStackTrace();
							System.out.println("输入错误");
							
							javax.swing.JOptionPane.showMessageDialog(
									null, "输入有误，请重新输入");
						}

					}
				});
				
		
		pack();
		this.setResizable(false);
		this.setSize(800, 500);
	} catch (Exception e) {
		e.printStackTrace();
	}

	}
	public void JCup()		//JComboBox更新
	{
		s1=DW.Name();s2=DW.Kinds();s3=DW.Where();
		ComboBoxModel KindsM = new DefaultComboBoxModel(new String[] { "" });ComboBoxModel KindsM1 = new DefaultComboBoxModel(new String[] { "" });ComboBoxModel KindsM2 = new DefaultComboBoxModel(new String[] { "" });
		ComboBoxModel Classes = new DefaultComboBoxModel(new String[] {"" });ComboBoxModel Classes1 = new DefaultComboBoxModel(new String[] { "" });ComboBoxModel Classes2 = new DefaultComboBoxModel(new String[] { "" });
		ComboBoxModel Wheres = new DefaultComboBoxModel(new String[] { "" });
		Kinds=new JComboBox(KindsM);Kinds1=new JComboBox(KindsM1);Kinds2=new JComboBox(KindsM2);
		Class=new JComboBox(Classes);Class1=new JComboBox(Classes1);Class2=new JComboBox(Classes2);Where=new JComboBox(Wheres);
		for(int i=0;s1[i]!=null;i++){
			Kinds.addItem(s1[i]);
		}
		for(int i=0;s2[i]!=null;i++){
			Class.addItem(s2[i]);
		}
		for(int i=0;s1[i]!=null;i++){
			Kinds1.addItem(s1[i]);
		}
		for(int i=0;s2[i]!=null;i++){
			Class1.addItem(s2[i]);
		}
		for(int i=0;s1[i]!=null;i++){
			Kinds2.addItem(s1[i]);
		}
		for(int i=0;s2[i]!=null;i++){
			Class2.addItem(s2[i]);
		}
		for(int i=0;s3[i]!=null;i++){
			Where.addItem(s3[i]);
		}
	}
}
	

