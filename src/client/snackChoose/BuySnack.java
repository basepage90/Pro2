
package client.snackChoose;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import DB.DAO.MemberDAO;
import DB.DTO.ProductDTO;
import views.client.ChooseSnackView;
import views.client.Client;

public class BuySnack implements ActionListener{
	Client ci;
	ChooseSnackView csv;
	JTable table;
	JTextField tf_lefttime;
	JTextField tf_id;
	DefaultTableModel tm;
	JTextField textShowPrice;
	Vector<ProductDTO> buy_arr;
	boolean possible=false;
	PrintWriter pw=null;

	int lh=0;
	int lm=0;
	int ls=0;
	int have_m=0;
	public BuySnack(Vector<ProductDTO> buy_arr,Client c, ChooseSnackView csv, JTable table,JTextField tf_id,JTextField tf_lefttime,JTextField textShowPrice){
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

		if(textShowPrice.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "���õ� ��ǰ�� �����ϴ�.");
		}else {
			int total = Integer.parseInt(textShowPrice.getText().substring(0, textShowPrice.getText().length()-1).trim());
			//����� Ŭ���̾�Ʈ�� �ð��� ������ ȯ���ѰͰ� ������ �׸��� �Ѿ��� ���ؼ� Ŭ���̾�Ʈ�� �ð��� ������ ����.
			if(have_m>total) {
				//���⿡�� ������ ��������.


				String product="";
				Iterator<ProductDTO> it = buy_arr.iterator();
				while(it.hasNext())
				{
					possible=false;
					ProductDTO pd = it.next();
					SnackChooseUpdateService sus = new SnackChooseUpdateService(pd.getProName(), pd.getProPrice(), pd.getAmount());
					product +=pd.getProName() + " " + pd.getAmount() + "��, " ;
					possible = sus.stockchange();
				}

				if(possible)
				{
					pw=ci.getPw();
					pw.println("snack@"+ci.getNum()+"@"+total+"@[" + tf_id.getText() + " ����� ]" + product);
					pw.flush();

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
}


