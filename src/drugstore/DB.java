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
	    //"jdbc:sqlserver://localhost:1433;databaseName = SPJ_TEST"��microsoft�ṩ��java-sqlserver���ݿ���������������sqlserverʱ��url
	    //localhost��ָ������ݿ��������ַ��1433Ϊ���sqlserver�˿ںţ�
	    //��SPJ_TEST������Ҫ���ӵ����ݿ������
	    String user = "sa";
	    String password = "amd7749123";
			try {
		        //1.��������
		        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		        System.out.println("���������ɹ���");
		    }catch(Exception e) {
		        e.printStackTrace();
		        System.out.println("��������ʧ�ܣ�");
		    }
		    try {  
		        //2.����
		        ct = DriverManager.getConnection(url,user,password);
		        System.out.println("�������ݿ�ɹ���");
		    }catch(Exception e) {
		        e.printStackTrace();
		        System.out.println("�������ݿ�ʧ�ܣ�");
		    }
	}
	
 
}
