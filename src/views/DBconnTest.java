package views;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DBconnTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement stmt = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://my5509.gabiadb.com:3306/mydb";  
			String id = "bit504";  		//mysql ���̵�
			String pass = "bitcamp504*";//��й�ȣ
			
			con = DriverManager.getConnection(url,id,pass);
			
			System.out.println("�����ͺ��̽� ���ῡ �����Ͽ����ϴ�.");
			
			Statement st=con.createStatement();
			String sql="insert into Pro2_member(member_id,member_pw,member_name,phone_number) " + 
					"values('id-d','pw-b','name-b','010-0000-1111')";
			int n=st.executeUpdate(sql);
			System.out.println(n);
		}catch(SQLException e){
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			 if(stmt != null)try {stmt.close();} catch(SQLException e) {}
	         if(con != null) try{con.close();} catch(SQLException e) {}
		}
	}

}
