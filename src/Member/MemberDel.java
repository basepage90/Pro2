package Member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import DB.DBconn;

public class MemberDel {
	
	public boolean deleteAccount(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		DBconn dbconn = new DBconn();
		boolean ok = false;
		
		try {
			conn = dbconn.getConnection();
			StringBuilder sql = new StringBuilder();

			sql.append(" delete from mydb.pro2_member ");
			sql.append(" where member_id= ?           ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			
			int result = pstmt.executeUpdate();
			if(result>1)
			{
				System.out.println("���� ����");
				ok=true;
			}
			else
				System.out.println("���� ����");
			
			
		}catch(SQLException e){
			System.out.println(e);
		}
		return ok;
	}
}
