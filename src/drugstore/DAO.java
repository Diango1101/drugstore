package drugstore;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;

public class DAO {
	String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=drugstore";
	String userName="sa";
	String userPwd="amd7749123";
	
	public String user					//ƥ���û�������
	(String t1,String t2){
		
	try{
	Class.forName(driverName);
	Connection dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
	Statement cmd=dbConn.createStatement();
	String sql="select  uidentity from users   where id='"+t1+"' and password='"+t2+"'";
	ResultSet rs=cmd.executeQuery(sql);
	String temp=new String();
	
	if(rs.next()){
		
			temp=rs.getString(1);
			
	}
	
	return temp;
	}catch(Exception e){
		e.printStackTrace();
		javax.swing.JOptionPane.showMessageDialog(
				null, "����ʧ��");
		return null;
	}

}
	public String[][] Rdrug(){		//ҩƷ��Ϣ
		try{
		String[][] temp=new String[20][3];
		Class.forName(driverName);
		Connection dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
		Statement cmd=dbConn.createStatement();
		String sql="select dno,dcate,dname from �ֿ����  group BY dno,dcate,dname";
		ResultSet rs=cmd.executeQuery(sql);
		int j=0;
		while(rs.next()){
			for(int i=0;i<3;i++){
				temp[j][i]=rs.getString(i+1);
			}
			j++;
		}
		return temp;
		}catch(Exception e){
			e.printStackTrace();
			System.out.print("����ʧ��");
			return null;
		}
	}
	public String[] changes(String text) {
		try{
			String[] temp=new String[4];
			Class.forName(driverName);
			Connection dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
			Statement cmd=dbConn.createStatement();
			String sql="select  *  from commodity  where dname='"+text+"'";
			ResultSet rs=cmd.executeQuery(sql);
			int j=0;
			while(rs.next()){
				for(int i=0;i<4;i++){
					temp[i]=rs.getString(i+1);
				}
			}
			return temp;
			}catch(Exception e){
				e.printStackTrace();
				System.out.print("����ʧ��");
				return null;
			}
	}
	public void upd(int parseInt, String text,String text2,String text3) {
		try{
			
			Class.forName(driverName);
			Connection dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
			Statement cmd=dbConn.createStatement();
			String sql="update commodity set dname='"+text+"' ,dcate='"+text2+"' ,place='"+text3+"' where dno='"+parseInt+"'";
			cmd.execute(sql);
			
		}
			catch(Exception e1){
				e1.printStackTrace();
				System.out.print("����ʧ��");
			}
	}	
		
	public String[][] RAll(){		//ȫ���ֿ����
		try{
		String[][] temp=new String[20][7];
		Class.forName(driverName);
		Connection dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
		Statement cmd=dbConn.createStatement();
		String sql="select rno,dno,sid,dname,stime,vtime,ramount  from �ֿ����  ";
		ResultSet rs=cmd.executeQuery(sql);
		int j=0;
		while(rs.next()){
			for(int i=0;i<7;i++){
				temp[j][i]=rs.getString(i+1);
			}
			j++;
		}
		return temp;
		}catch(Exception e){
			e.printStackTrace();
			System.out.print("����ʧ��");
			return null;
		}
	}
	public void InsertR					//����
		(String t1,String t2,String t3,String t4,String t5,int t6,String t7){
		try{
		String[][] temp=new String[20][7];
		Class.forName(driverName);
		Connection dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
		Statement cmd=dbConn.createStatement();
		String sql="insert into Stock(Sid, Dno, Ptime, Stime, Vtime, Samount, Sprice)  values('"+t1+"','"+t2+"','"+t3+"','"+t4+"','"+t5+"','"+t6+"','"+t7+"')";
		ResultSet rs=cmd.executeQuery(sql);
		}catch(Exception e){
			e.printStackTrace();
			javax.swing.JOptionPane.showMessageDialog(
					null, "�޷��������ݿ�");
		}
	}
	public void OutR(int t1,int t2)		//����
	{
		try{
		Class.forName(driverName);
		Connection dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
		CallableStatement cmd=dbConn.prepareCall("{call Out(?,?)}");
		cmd.setInt(1, t1);
		cmd.setInt(2, t2);
		cmd.execute();
		cmd.close();
		}catch(Exception e){
			e.printStackTrace();
			javax.swing.JOptionPane.showMessageDialog(
					null, "�޷��������ݿ�");
		}
	}
	public String[][] InputAll()		//������¼
	{
		try{
		String[][] temp=new String[20][7];
		Class.forName(driverName);
		Connection dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
		Statement cmd=dbConn.createStatement();
		String sql="select Sid, Dno, Ptime, Stime, Vtime, Samount, Sprice  from Stock";
		ResultSet rs=cmd.executeQuery(sql);
		int j=0;
		while(rs.next()){
			for(int i=0;i<7;i++){
				temp[j][i]=rs.getString(i+1);
			}
			j++;
		}
		return temp;
		}catch(Exception e){
			e.printStackTrace();
			System.out.print("����ʧ��");
			return null;
		}
	}
	public	String[][]	SearchM1(String s){		//������
		try{
			String[][] temp=new String[20][6];
			Class.forName(driverName);
			Connection dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
			Statement cmd=dbConn.createStatement();
			String sql="select sid,dno,dname,dcate,place,stime  from �ֿ����  where dname='"+s+"'";
			ResultSet rs=cmd.executeQuery(sql);
			int j=0;
			while(rs.next()){
				for(int i=0;i<6;i++){
					temp[j][i]=rs.getString(i+1);
				}
				j++;
			}
			return temp;
			}catch(Exception e){
				e.printStackTrace();
				System.out.print("����ʧ��");
				return null;
			}
	}
	public	String[][]	SearchM2(String s,String s1){		//������+���
		try{
			String[][] temp=new String[20][6];
			Class.forName(driverName);
			Connection dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
			Statement cmd=dbConn.createStatement();
			String sql="select sid,dno,dname,dcate,place,stime  from �ֿ����  where dname='"+s+"' and dcate='"+s1+"'";
			ResultSet rs=cmd.executeQuery(sql);
			int j=0;
			while(rs.next()){
				for(int i=0;i<6;i++){
					temp[j][i]=rs.getString(i+1);
				}
				j++;
			}
			return temp;
			}catch(Exception e){
				e.printStackTrace();
				System.out.print("����ʧ��");
				return null;
			}
	}
	public	String[][]	SearchM3(String s,String s1,String s3){		//������+���
		try{
			String[][] temp=new String[20][6];
			Class.forName(driverName);
			Connection dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
			Statement cmd=dbConn.createStatement();
			String sql="select sid,dno,dname,dcate,place,stime  where dname='"+s+"' and dcate='"+s1+"' and  place='"+s3+"'";
			ResultSet rs=cmd.executeQuery(sql);
			int j=0;
			while(rs.next()){
				for(int i=0;i<6;i++){
					temp[j][i]=rs.getString(i+1);
				}
				j++;
			}
			return temp;
			}catch(Exception e){
				e.printStackTrace();
				System.out.print("����ʧ��");
				return null;
			}
	}
	public	String[][]	SearchR1(String s,String s1){		//������+���
		try{
			String[][] temp=new String[20][7];
			Class.forName(driverName);
			Connection dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
			Statement cmd=dbConn.createStatement();
			String sql="select rno,dno,sid,dname,stime,vtime,ramount  from �ֿ����  where dname='"+s+"' and dcate='"+s1+"'";
			ResultSet rs=cmd.executeQuery(sql);
			int j=0;
			while(rs.next()){
				for(int i=0;i<7;i++){
					temp[j][i]=rs.getString(i+1);
				}
				j++;
			}
			return temp;
			}catch(Exception e){
				e.printStackTrace();
				System.out.print("����ʧ��");
				return null;
			}
	}
	public	String[][]	SearchR2(String s){		//������
		try{
			String[][] temp=new String[20][7];
			Class.forName(driverName);
			Connection dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
			Statement cmd=dbConn.createStatement();
			String sql="select rno,dno,sid,dname,stime,vtime,ramount from �ֿ����  where dname='"+s+"' ";
			ResultSet rs=cmd.executeQuery(sql);
			int j=0;
			while(rs.next()){
				for(int i=0;i<7;i++){
					temp[j][i]=rs.getString(i+1);
				}
				j++;
			}
			return temp;
			}catch(Exception e){
				e.printStackTrace();
				System.out.print("����ʧ��");
				return null;
			}
	}
	public	String[][]	SearchR3(String s){		//�����
		try{
			String[][] temp=new String[20][7];
			Class.forName(driverName);
			Connection dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
			Statement cmd=dbConn.createStatement();
			String sql="select dno,dno,sid,dname,stime,vtime,ramount  from �ֿ����  where dcate='"+s+"' ";
			ResultSet rs=cmd.executeQuery(sql);
			int j=0;
			while(rs.next()){
				for(int i=0;i<7;i++){
					temp[j][i]=rs.getString(i+1);
				}
				j++;
			}
			return temp;
			}catch(Exception e){
				e.printStackTrace();
				System.out.print("����ʧ��");
				return null;
			}
	}
	public  String[][]	SaleAll(){
		try{
			String[][] temp=new String[20][7];
			Class.forName(driverName);
			Connection dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
			Statement cmd=dbConn.createStatement();
			String sql="select oid,rno,oprice,oamount,cno,ono,otime  from out_stock ";
			ResultSet rs=cmd.executeQuery(sql);
			int j=0;
			while(rs.next()){
				for(int i=0;i<7;i++){
					temp[j][i]=rs.getString(i+1);
				}
				j++;
			}
			return temp;
			}catch(Exception e){
				e.printStackTrace();
				System.out.print("����ʧ��");
				return null;
			}
	}
	
	public	void AddS1(String t1,String t2,String t3,String t4,String t5,String t6,String t7,String t8){
		try{
			
			Class.forName(driverName);
			Connection dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
			Statement cmd=dbConn.createStatement();
			String sql="insert into out_stock values('"+t1+"','"+t2+"','"+t3+"','"+t4+"','"+t5+"','"+t6+"','"+t7+"','"+t8+"')";
			cmd.execute(sql);
			}catch(Exception e){
				e.printStackTrace();
				javax.swing.JOptionPane.showMessageDialog(
						null, "�޷��������ݿ�");
			}
		
	}
	public  String[] 	Name(){
		try{
			
			Class.forName(driverName);
			Connection dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
			Statement cmd=dbConn.createStatement();
			String sql="select dname  from ѡ� 	Group by dname";
			ResultSet rs=cmd.executeQuery(sql);
			String[] temp=new String[20];
			int i=0;
			while(rs.next()){
					temp[i]=rs.getString(1);
					i++;
				
			}
			return temp;
			}catch(Exception e){
				e.printStackTrace();
				System.out.print("����ʧ��");
				return null;
			}
	}
	public  String[] 	Kinds(){
		try{
			
			Class.forName(driverName);
			Connection dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
			Statement cmd=dbConn.createStatement();
			String sql="select dcate  from ѡ�	Group by dcate";
			ResultSet rs=cmd.executeQuery(sql);
			String[] temp=new String[20];
			int i=0;
			while(rs.next()){
				
					temp[i]=rs.getString(1);
					i++;
			}
			return temp;
			}catch(Exception e){
				e.printStackTrace();
				System.out.print("����ʧ��");
				return null;
			}
	}
	public String[]		Where(){
		try{
			
			Class.forName(driverName);
			Connection dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
			Statement cmd=dbConn.createStatement();
			String sql="select place  from ѡ�	Group by place";
			ResultSet rs=cmd.executeQuery(sql);
			String[] temp=new String[20];
			int i=0;
			while(rs.next()){
				
					temp[i]=rs.getString(1);
					i++;
			}
			return temp;
			}catch(Exception e){
				e.printStackTrace();
				System.out.print("����ʧ��");
				return null;
			}
		}
	public	String[][]	F1(String t1,String t2,String t3)		//��ѯ������¼
	{
		try{
			String[][] temp=new String[20][8];
			Class.forName(driverName);
			Connection dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
			CallableStatement cmd=dbConn.prepareCall("{call SearchStock(?,?,?)}");
			cmd.setString(1, t1);
			cmd.setString(2, t2);
			cmd.setString(3, t3);
			ResultSet rs=cmd.executeQuery();
			
			int j=0;
			while(rs.next()){
				for(int i=0;i<8;i++){
					temp[j][i]=rs.getString(i+1);
				}
				j++;
			}
			cmd.close();
			return temp;
			
			}catch(Exception e){
				e.printStackTrace();
				System.out.print("����ʧ��");
				return null;
			}
	}
	public	String[][]	F2(String t1,String t2)					//��ѯ���ۼ�¼
	{
		try{
			String[][] temp=new String[20][9];
			Class.forName(driverName);
			Connection dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
			CallableStatement cmd=dbConn.prepareCall("{call SearchOut_Stock(?,?)}");
			cmd.setString(1, t1);
			cmd.setString(2, t2);
			ResultSet rs=cmd.executeQuery();
			int j=0;
			while(rs.next()){
				for(int i=0;i<9;i++){
					temp[j][i]=rs.getString(i+1);
				}
				j++;
			}
			cmd.close();
			return temp;
			
			}catch(Exception e){
				e.printStackTrace();
				System.out.print("����ʧ��");
				return null;
			}
	}
	public	String[][]	F3(String t1,String t2)					//��ѯ����¼
	{
		try{
			String[][] temp=new String[20][6];
			Class.forName(driverName);
			Connection dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
			CallableStatement cmd=dbConn.prepareCall("{call SearchRV(?,?)}");
			cmd.setString(1, t1);
			cmd.setString(2, t2);
			ResultSet rs=cmd.executeQuery();
			int j=0;
			while(rs.next()){
				for(int i=0;i<6;i++){
					temp[j][i]=rs.getString(i+1);
				}
				j++;
			}
			cmd.close();
			return temp;
			
			}catch(Exception e){
				e.printStackTrace();
				System.out.print("����ʧ��");
				return null;
			}
	}
	public  String[][]  timefi(String t1,String t2)				//��ѯʱ�����
	{				
		try{
			String[][] temp=new String[20][7];
			Class.forName(driverName);
			Connection dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
			Statement cmd=dbConn.createStatement();
			String sql="select rno,sid,dno,dname,stime,vtime,samount from �������    where  stime >'"+t1+"' and stime <'"+t2+"' ";
			ResultSet rs=cmd.executeQuery(sql);
			int j=0;
			while(rs.next()){
				for(int i=0;i<7;i++){
					temp[j][i]=rs.getString(i+1);
				}
				j++;
			}
			return temp;
			}catch(Exception e){
				e.printStackTrace();
				System.out.print("����ʧ��");
				return null;
			}
	}
	public  String[][]  timefo(String t1,String t2)				//��ѯʱ������
	{				
		try{
			String[][] temp=new String[20][8];
			Class.forName(driverName);
			Connection dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
			Statement cmd=dbConn.createStatement();
			String sql="select oid,dname,cno,ono,oprice,oamount,otime,ramount   from �������    where  otime >'"+t1+"' and otime <'"+t2+"' ";
			ResultSet rs=cmd.executeQuery(sql);
			int j=0;
			while(rs.next()){
				for(int i=0;i<8;i++){
					temp[j][i]=rs.getString(i+1);
				}
				j++;
			}
			return temp;
			}catch(Exception e){
				e.printStackTrace();
				System.out.print("����ʧ��");
				return null;
			}
	}
	public  String[][]	Dat()									//��ѯ���ڻ���
	{
		try{
			String[][] temp=new String[20][6];
			Class.forName(driverName);
			Connection dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
			Statement cmd=dbConn.createStatement();
			String sql="select *  from �Ʋ����  where dateadd(month,6,getdate())> vtime";
			ResultSet rs=cmd.executeQuery(sql);
			int j=0;
			while(rs.next()){
				for(int i=0;i<6;i++){
					temp[j][i]=rs.getString(i+1);
				}
				j++;
			}
			return temp;
			}catch(Exception e){
				e.printStackTrace();
				System.out.print("����ʧ��");
				return null;
			}
	}
	public  String[][]	Min()									//��ѯ���ٻ���
	{
		try{
			String[][] temp=new String[20][6];
			Class.forName(driverName);
			Connection dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
			Statement cmd=dbConn.createStatement();
			String sql="select  *  from �Ʋ����  where ramount < 200";
			ResultSet rs=cmd.executeQuery(sql);
			int j=0;
			while(rs.next()){
				for(int i=0;i<6;i++){
					temp[j][i]=rs.getString(i+1);
				}
				j++;
			}
			return temp;
			}catch(Exception e){
				e.printStackTrace();
				System.out.print("����ʧ��");
				return null;
			}
	}
	
			

}

