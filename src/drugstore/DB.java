package drugstore;
import java.sql.*;
 
public class DB
{
	public static void main(String[] args)
	{
		PreparedStatement ps = null;
	    Connection ct = null;
	    ResultSet rs = null;
	    
	    String url = "jdbc:sqlserver://localhost:1433;databaseName = Student_info_20160748"; 
	    //"jdbc:sqlserver://localhost:1433;databaseName = SPJ_TEST"是microsoft提供的java-sqlserver数据库连接驱动来访问sqlserver时的url
	    //localhost是指你的数据库服务器地址，1433为你的sqlserver端口号！
	    //“SPJ_TEST”是所要连接的数据库的名称
	    String user = "sa";
	    String password = "amd7749123";
			try {
		        //1.加载驱动
		        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		        System.out.println("加载驱动成功！");
		    }catch(Exception e) {
		        e.printStackTrace();
		        System.out.println("加载驱动失败！");
		    }
		    try {  
		        //2.连接
		        ct = DriverManager.getConnection(url,user,password);
		        System.out.println("连接数据库成功！");
		    }catch(Exception e) {
		        e.printStackTrace();
		        System.out.println("连接数据库失败！");
		    }
	}
	
 
}
