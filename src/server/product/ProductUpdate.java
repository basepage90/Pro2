package server.product;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import views.server.UpdateProductView;

public class ProductUpdate implements ActionListener{
	JTable table;
	
	public ProductUpdate(JTable table) {
		super();
		this.table=table;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		DefaultTableModel tm = (DefaultTableModel) table.getModel(); //���̺�ҷ�����
		int row = table.getSelectedRow(); //�� ����

		String proName = (String)table.getValueAt(row, 0);
		String proPrice = (String)table.getValueAt(row, 1);
		int proStock = (int)table.getValueAt(row, 2);
		
		UpdateProductView upv = new UpdateProductView(table, proName, proPrice, proStock);
		upv.setVisible(true);
		
	}
	
	

}
