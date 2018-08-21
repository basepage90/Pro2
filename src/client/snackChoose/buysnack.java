
package client.snackChoose;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import DB.dto.ProductDTO;
import client.clientInfo.UpdateTimeDAO;
import views.client.ChooseSnackView;
import views.server.Client;

public class buysnack implements ActionListener{
	Client ci;
	ChooseSnackView csv;
	JTable table;
	JTextField tf_lefttime;
	JTextField tf_id;
	DefaultTableModel tm;
	JTextField textShowPrice;
	Vector<ProductDTO> buy_arr;
	boolean possible=false;
	
	int lh=0;
	int lm=0;
	int ls=0;
	int have_m=0;
	public buysnack(Vector<ProductDTO> buy_arr,Client c, ChooseSnackView csv, JTable table,JTextField tf_id,JTextField tf_lefttime,JTextField textShowPrice){
		this.ci=c;
		this.csv=csv;
		this.table=table;
		this.tf_id = tf_id;
		this.buy_arr=buy_arr;
		this.tf_lefttime = tf_lefttime;
		this.textShowPrice = textShowPrice;
		tm = (DefaultTableModel) table.getModel();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String[] str=tf_lefttime.getText().split(":");
		//Ŭ���̾�Ʈ�� �����ð�JtextField ���� ������ ':'���� split�� �ð��� ���� ���Ѵ�. ���°��� ���� ��� �ð��� ������ ȯ���Ѵ�.
		lh=Integer.parseInt(str[0].trim());
		lm=Integer.parseInt(str[1].trim());
		have_m=(lh*60)+lm;


		int total = Integer.parseInt(textShowPrice.getText().substring(0, textShowPrice.getText().length()-1).trim());
		//����� Ŭ���̾�Ʈ�� �ð��� ������ ȯ���ѰͰ� ������ �׸��� �Ѿ��� ���ؼ� Ŭ���̾�Ʈ�� �ð��� ������ ����.
		if(have_m>total) {
			have_m-=total;
			int h=have_m/60;
			int m=have_m%60;

			ci.setLh(h);
			ci.setLm(m);
			
			String time= ci.getLh()+ ":" + ci.getLm() + ":" + ci.getLs();
			UpdateTimeDAO dao=new UpdateTimeDAO();
			dao.UpdateTime(tf_id.getText(), time);
			
			
			Iterator<ProductDTO> it = buy_arr.iterator();
			while(it.hasNext())
			{
				possible=false;
				ProductDTO pd = it.next();
				snackChooseUpdateService sus = new snackChooseUpdateService(pd.getProName(), pd.getProPrice(), pd.getAmount());
				possible = sus.stockchange();
			}
			
			
			if(possible)
			{
				int row = tm.getRowCount();
				for(int i=0;i<row;i++)
					tm.removeRow(0);
				JOptionPane.showMessageDialog(null, total+"�� "+" ���� �Ϸ�");
				csv.dispose();
			}
			else {
				JOptionPane.showMessageDialog(null, "�˼��մϴ٤Ф� ��������մϴ�.");
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "�����Ͻ� �ð��� �����մϴ�.");
		}
		
	}

}


