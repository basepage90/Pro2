package snackChoose;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.JTextField;

import views.Client;

public class buysnack implements ActionListener{
	Client ci;
	JTable table;
	JTextField tf_lefttime;
	
	int lh=0;
	int lm=0;
	int ls=0;
	int have_m=0;
	public buysnack(Client c, JTable table,JTextField tf_lefttime){
		this.ci=c;
		this.table=table;
		this.tf_lefttime = tf_lefttime;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		System.out.println("��" + tf_lefttime.getText().toString());
		String[] str=tf_lefttime.getText().split(":");
		
		//Ŭ���̾�Ʈ�� �����ð�JtextField ���� ������ ':'���� split�� �ð��� ���� ���Ѵ�. ���°��� ���� ��� �ð��� ������ ȯ���Ѵ�.
		lh=Integer.parseInt(str[0].trim());
		lm=Integer.parseInt(str[1].trim());
		have_m=(lh*60)+lm;
		
		int row = table.getRowCount();
		int total=0;
		for(int i = 0; i < row; i++) {
			int m= Integer.parseInt(table.getValueAt(i, 1).toString().substring(3, 5));
			int cnt= Integer.parseInt(table.getValueAt(i, 2).toString());
			total+=m*cnt;
		}
		
		//����� Ŭ���̾�Ʈ�� �ð��� ������ ȯ���ѰͰ� ������ �׸��� �Ѿ��� ���ؼ� Ŭ���̾�Ʈ�� �ð��� ������ ����.
		if(have_m>total) {
			have_m-=total;
			int h=have_m/60;
			int m=have_m%60;
			
			ci.setLh(h);
			ci.setLm(m);
		}
	}


}
