package server.product;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DB.DAO.ProductDAO;

public class DelProduct implements ActionListener{

	private JTable table;
	public DelProduct(JTable table) {
		super();
		this.table = table;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		DefaultTableModel tm = (DefaultTableModel) table.getModel(); //���̺�ҷ�����

		int row = table.getSelectedRow(); //�� ����
		if(row<0) {
			JOptionPane.showMessageDialog(null, "���õ� ���� �����ϴ�.");
		}else {
			String proName =  (String)table.getValueAt(row, 0);

			tm.removeRow(row);

			ProductDAO del = new ProductDAO();
			del.deleteProduct(proName);
		}

	}

}
