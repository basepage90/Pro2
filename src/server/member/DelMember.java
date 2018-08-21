package server.member;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DB.dao.MemberDAO;

public class DelMember implements ActionListener{

	private JTable memlist;
	public DelMember(JTable memlist) {
		super();
		this.memlist = memlist;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		DefaultTableModel tm = (DefaultTableModel) memlist.getModel(); //���̺�ҷ�����
		int row = memlist.getSelectedRow(); //�� ����

		String id =  (String)memlist.getValueAt(row,0 );
		
		tm.removeRow(row);
		
		MemberDAO del = new MemberDAO();
		del.deleteAccount(id);
		
		
	}

}
