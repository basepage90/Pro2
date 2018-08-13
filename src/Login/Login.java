package Login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import ClientInfo.infoDAO;
import ClientInfo.infoDTO;
import dbconn.DBconn;
import views.ClientInfo;
import views.LoginView;
import views.SeatView;

public class Login implements ActionListener{
	LoginView view;
	JTextField id;
	JTextField pw;
	JTextField num;
	public Login(LoginView view, JTextField id, JTextField pw, JTextField num) {
		this.view=view;
		this.id=id;
		this.pw=pw;
		this.num=num;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand()=="�α���") {
			LoginDAO dao=new LoginDAO();
			String check;
			
			check= dao.CheckMember(id.getText());
			if(check==null) {
				JOptionPane.showMessageDialog(null, "���̵� ����.");
				id.setText("");
			}else{
//				System.out.println(id.getText() + " �α��� �Ϸ�.");
				JOptionPane.showMessageDialog(null, id.getText() + " �α��� �Ϸ�.");
				
				ClientInfo ci= new ClientInfo(Integer.parseInt(num.getText())-1, id.getText());
				infoDAO infodao= new infoDAO();
				infoDTO dto= new infoDTO();
				dto= infodao.GetInfo(id.getText());
				ci.setTextField_1(dto.getName());
				ci.setTextField_2(dto.getLeftTime());
				view.dispose();
			}

		}
	}

}
