package product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import DB.DBconn;

public class ProductDel {
	
	public void deleteProduct(String proName) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		DBconn dbconn = new DBconn();
		
		try {
			conn = dbconn.getConnection();
			StringBuilder sql = new StringBuilder();

			sql.append(" delete from mydb.pro2_snack ");
			sql.append(" where product_name= ?     ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, proName);
			
			int result = pstmt.executeUpdate();
			if(result>0)
			{
				System.out.println("���� �Ϸ�");
				JOptionPane.showMessageDialog(null, "���� �Ϸ�");
			}
			else
			{
				System.out.println("���� ����");
				JOptionPane.showMessageDialog(null, "���� ����");
			}
			
		}catch(SQLException e){
			System.out.println(e);
		}
	}
}
