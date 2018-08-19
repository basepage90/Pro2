package DB;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

import ClientInfo.infoDAO;
import ClientInfo.infoDTO;
import views.AddtimeView;
import views.Client;
import views.ClientInfo;
import views.MemberMgr;
import views.SalesManagerView;
import views.StockManagementView;

public class Main_GUI_Event extends JFrame implements MouseListener, ActionListener{
	private int cur_num;
	private JLabel cur_id_label;
	private JLabel cur_time_label;
	private JLabel time_label;
	
	//0814 cmd�� seatview �����Ϸ��� �ּ�ó�� �ؿ� �׼Ǹ����ʵ� �ּ�ó��
	SalesManagerView smv= new SalesManagerView();
	MemberMgr mm= new MemberMgr();
	AddtimeView atv = new AddtimeView(new JLabel(""));
	StockManagementView sm = new StockManagementView();
	public Main_GUI_Event() {
	}
	public Main_GUI_Event(int i, JLabel cur_id_label, JLabel cur_time_label, JLabel time_label) {
		this.cur_num=i;
		this.cur_id_label=cur_id_label;
		this.cur_time_label=cur_time_label;
		this.time_label=time_label;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println(cur_num+"�� PC Ŭ����");
		infoDAO dao= new infoDAO();
		infoDTO dto= new infoDTO();
		dto = dao.GetInfo(cur_id_label.getText());
		
//		Client ci= new Client(cur_num, cur_id_label.getText());
		ClientInfo ci= new ClientInfo(cur_num, cur_id_label.getText(),cur_time_label,time_label);
		ci.SetName(dto.getName());
		ci.SetTime(dto.getHour(), dto.getMinute(), dto.getSecond());
		ci.setVisible(true);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand()=="������Ȳ") {
			smv.setVisible(true);
		}
		if(e.getActionCommand()=="ȸ������") {
			mm.setVisible(true);
		}
		if(e.getActionCommand()=="������") {
			sm.setVisible(true);
		}
		if(e.getActionCommand()=="����") {
			atv.setVisible(true);
		}
		
	}

	
}
