package product;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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

		String pronum =  (String)table.getValueAt(row,0 );
		
		tm.removeRow(row);
		
		ProductDel del = new ProductDel();
		del.deleteProduct(pronum);
		
		
	}

}
