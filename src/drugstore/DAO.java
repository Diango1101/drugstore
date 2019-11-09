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
	
	public String user					//匹配用户名密码
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
				null, "连接失败");
		return null;
	}

}
	public String[][] Rdrug(){		//药品信息
		try{
		String[][] temp=new String[20][3];
		Class.forName(driverName);
		Connection dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
		Statement cmd=dbConn.createStatement();
		String sql="select dno,dcate,dname from 仓库情况  group BY dno,dcate,dname";
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
			System.out.print("连接失败");
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
				System.out.print("连接失败");
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
				System.out.print("连接失败");
			}
	}	
		
	public String[][] RAll(){		//全部仓库情况
		try{
		String[][] temp=new String[20][7];
		Class.forName(driverName);
		Connection dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
		Statement cmd=dbConn.createStatement();
		String sql="select rno,dno,sid,dname,stime,vtime,ramount  from 仓库情况  ";
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
			System.out.print("连接失败");
			return null;
		}
	}
	public void InsertR					//进货
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
					null, "无法插入数据库");
		}
	}
	public void OutR(int t1,int t2)		//出货
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
					null, "无法链接数据库");
		}
	}
	public String[][] InputAll()		//进货记录
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
			System.out.print("连接失败");
			return null;
		}
	}
	public	String[][]	SearchM1(String s){		//查名称
		try{
			String[][] temp=new String[20][6];
			Class.forName(driverName);
			Connection dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
			Statement cmd=dbConn.createStatement();
			String sql="select sid,dno,dname,dcate,place,stime  from 仓库情况  where dname='"+s+"'";
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
				System.out.print("连接失败");
				return null;
			}
	}
	public	String[][]	SearchM2(String s,String s1){		//查名称+类别
		try{
			String[][] temp=new String[20][6];
			Class.forName(driverName);
			Connection dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
			Statement cmd=dbConn.createStatement();
			String sql="select sid,dno,dname,dcate,place,stime  from 仓库情况  where dname='"+s+"' and dcate='"+s1+"'";
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
				System.out.print("连接失败");
				return null;
			}
	}
	public	String[][]	SearchM3(String s,String s1,String s3){		//查名称+类别
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
				System.out.print("连接失败");
				return null;
			}
	}
	public	String[][]	SearchR1(String s,String s1){		//查名称+类别
		try{
			String[][] temp=new String[20][7];
			Class.forName(driverName);
			Connection dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
			Statement cmd=dbConn.createStatement();
			String sql="select rno,dno,sid,dname,stime,vtime,ramount  from 仓库情况  where dname='"+s+"' and dcate='"+s1+"'";
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
				System.out.print("连接失败");
				return null;
			}
	}
	public	String[][]	SearchR2(String s){		//查名称
		try{
			String[][] temp=new String[20][7];
			Class.forName(driverName);
			Connection dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
			Statement cmd=dbConn.createStatement();
			String sql="select rno,dno,sid,dname,stime,vtime,ramount from 仓库情况  where dname='"+s+"' ";
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
				System.out.print("连接失败");
				return null;
			}
	}
	public	String[][]	SearchR3(String s){		//查类别
		try{
			String[][] temp=new String[20][7];
			Class.forName(driverName);
			Connection dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
			Statement cmd=dbConn.createStatement();
			String sql="select dno,dno,sid,dname,stime,vtime,ramount  from 仓库情况  where dcate='"+s+"' ";
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
				System.out.print("连接失败");
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
				System.out.print("连接失败");
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
						null, "无法插入数据库");
			}
		
	}
	public  String[] 	Name(){
		try{
			
			Class.forName(driverName);
			Connection dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
			Statement cmd=dbConn.createStatement();
			String sql="select dname  from 选项卡 	Group by dname";
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
				System.out.print("连接失败");
				return null;
			}
	}
	public  String[] 	Kinds(){
		try{
			
			Class.forName(driverName);
			Connection dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
			Statement cmd=dbConn.createStatement();
			String sql="select dcate  from 选项卡	Group by dcate";
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
				System.out.print("连接失败");
				return null;
			}
	}
	public String[]		Where(){
		try{
			
			Class.forName(driverName);
			Connection dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
			Statement cmd=dbConn.createStatement();
			String sql="select place  from 选项卡	Group by place";
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
				System.out.print("连接失败");
				return null;
			}
		}
	public	String[][]	F1(String t1,String t2,String t3)		//查询进货记录
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
				System.out.print("连接失败");
				return null;
			}
	}
	public	String[][]	F2(String t1,String t2)					//查询销售记录
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
				System.out.print("连接失败");
				return null;
			}
	}
	public	String[][]	F3(String t1,String t2)					//查询库存记录
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
				System.out.print("连接失败");
				return null;
			}
	}
	public  String[][]  timefi(String t1,String t2)				//查询时间进货
	{				
		try{
			String[][] temp=new String[20][7];
			Class.forName(driverName);
			Connection dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
			Statement cmd=dbConn.createStatement();
			String sql="select rno,sid,dno,dname,stime,vtime,samount from 进货情况    where  stime >'"+t1+"' and stime <'"+t2+"' ";
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
				System.out.print("连接失败");
				return null;
			}
	}
	public  String[][]  timefo(String t1,String t2)				//查询时间销售
	{				
		try{
			String[][] temp=new String[20][8];
			Class.forName(driverName);
			Connection dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
			Statement cmd=dbConn.createStatement();
			String sql="select oid,dname,cno,ono,oprice,oamount,otime,ramount   from 销售情况    where  otime >'"+t1+"' and otime <'"+t2+"' ";
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
				System.out.print("连接失败");
				return null;
			}
	}
	public  String[][]	Dat()									//查询逼期货物
	{
		try{
			String[][] temp=new String[20][6];
			Class.forName(driverName);
			Connection dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
			Statement cmd=dbConn.createStatement();
			String sql="select *  from 逼仓情况  where dateadd(month,6,getdate())> vtime";
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
				System.out.print("连接失败");
				return null;
			}
	}
	public  String[][]	Min()									//查询量少货物
	{
		try{
			String[][] temp=new String[20][6];
			Class.forName(driverName);
			Connection dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
			Statement cmd=dbConn.createStatement();
			String sql="select  *  from 逼仓情况  where ramount < 200";
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
				System.out.print("连接失败");
				return null;
			}
	}
	
			

}

