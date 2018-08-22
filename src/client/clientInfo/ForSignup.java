package client.clientInfo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import DB.DAO.MemberDAO;
import DB.DTO.MemberDTO;
import views.client.SignUpView;


public class ForSignup implements ActionListener {

	private JTextField textField_phone;
	private JTextField textField_pwd;
	private JTextField textField_id;
	private JTextField textField_name;
	private SignUpView suv ;



	public ForSignup(SignUpView suv , JTextField textField_name,JTextField textField_id, JTextField textField_pwd, JTextField textField_phone
			) {

		this.suv=suv;
		this.textField_phone = textField_phone;
		this.textField_pwd = textField_pwd;
		this.textField_id = textField_id;
		this.textField_name = textField_name;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if(textField_name.getText().trim().equals("") || textField_name.getText().trim()==null) {JOptionPane.showMessageDialog(null, "��Ȯ�� �̸��� �Է����ּ���.");}
		else if(textField_pwd.getText().trim().equals("") || textField_pwd.getText().trim()==null) {JOptionPane.showMessageDialog(null, "�ѱ����̻��Է����ּ���.");}
		else if(!textField_phone.getText().trim().matches("(01[0179])-(\\d{4})-(\\d{4})")) {JOptionPane.showMessageDialog(null, "010-1234-1234�������� �Է����ּ���.");}
		else {
			MemberDTO dto = new MemberDTO(textField_name.getText().trim(), textField_id.getText().trim(), textField_pwd.getText().trim(), textField_phone.getText().trim());
			MemberDAO dao = new MemberDAO();
			boolean result = dao.insertAccount(dto);
			if(result)
			{
				JOptionPane.showMessageDialog(null, "ȸ�������̿Ϸ�Ǿ����ϴ�.");
				suv.dispose();
			}
		}
	}

}
