package ClientInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dbconn.DBconn;

public class SignUp{
	
	public SignUp() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		DBconn dbconn = new DBconn();
		
		try {
			conn = dbconn.getConnection();
			StringBuilder sql = new StringBuilder();

			sql.append(" insert into mydb.pro2_member ");
			sql.append("           (member_id         ");
			sql.append("          , member_pw         ");
			sql.append("	      , phone_number	  ");
			sql.append("          , member_name)      ");
			sql.append("    values (?, ?, ?, ?);      ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, "id");
			pstmt.setString(2, "pw");
			pstmt.setString(3, "phone_number");
			pstmt.setString(4, "name");
			
			int result = pstmt.executeUpdate();
			if(result==1)
				System.out.println("���� ����");
			else
				System.out.println("���� ����");
			
			
		}catch(SQLException e){
			System.out.println(e);
		}
		
	}

}
