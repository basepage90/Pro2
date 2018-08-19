﻿package Addtime;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import views.ClientInfo;

public  class Addtime implements ActionListener  {
	ClientInfo clientinfo;
	JTextField textSearchid;
	JTextArea textShowaddtime;
	String hours;


	public Addtime(ClientInfo clientinfo, JTextField textSearchid,JTextArea textShowaddtime) {
		this.clientinfo=clientinfo;
		this.textSearchid=textSearchid;
		this.textShowaddtime=textShowaddtime;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		AddtimeDAO dao= new AddtimeDAO();
		if(e.getActionCommand()=="1 \uC2DC\uAC04") {
			clientinfo.AddT(1);
			
			hours="01:00:00";
			
			dao.GetAddtime(hours ,textSearchid.getText());
			textShowaddtime.setText( "["+textSearchid.getText()+ "] 님의  PC 이용시간이\n[1 시간] 추가 되었습니다."); 

			dao.GetChargetime(hours, textSearchid.getText());
		}
		else if(e.getActionCommand()=="2 \uC2DC\uAC04") {
			clientinfo.AddT(2);
			hours="02:00:00";

			dao.GetAddtime(hours,textSearchid.getText());
			textShowaddtime.setText("["+ textSearchid.getText()+ "] 님의  PC 이용시간이\n[2 시간] 추가 되었습니다."); 

			dao.GetChargetime(hours, textSearchid.getText());

		}
		else if(e.getActionCommand()=="3 \uC2DC\uAC04") {
			clientinfo.AddT(3);
			hours="03:00:00";

			dao.GetAddtime(hours, textSearchid.getText());
			textShowaddtime.setText("["+ textSearchid.getText()+ "] 님의  PC 이용시간이\n[3 시간] 추가 되었습니다."); 

			dao.GetChargetime(hours, textSearchid.getText());
		}
		else if(e.getActionCommand()=="5 \uC2DC\uAC04") {
			clientinfo.AddT(5);
			hours="05:00:00";

			dao.GetAddtime(hours,textSearchid.getText());
			textShowaddtime.setText("["+ textSearchid.getText()+ "] 님의  PC 이용시간이 [5 시간] 추가 되었습니다."); 

			dao.GetChargetime(hours, textSearchid.getText());
		}
		else if(e.getActionCommand()=="10 \uC2DC\uAC04") {
			clientinfo.AddT(10);
			hours="10:00:00";

			dao.GetAddtime(hours,textSearchid.getText());
			textShowaddtime.setText("["+ textSearchid.getText()+ "] 님의  PC 이용시간이\n[10 시간] 추가 되었습니다."); 

			dao.GetChargetime(hours, textSearchid.getText());
		}
		else if(e.getActionCommand()=="24 \uC2DC\uAC04") {
			clientinfo.AddT(24);
			hours="24:00:00";

			dao.GetAddtime(hours,textSearchid.getText());
			textShowaddtime.setText("["+ textSearchid.getText()+ "] 님의  PC 이용시간이\n[24 시간] 추가 되었습니다."); 

			dao.GetChargetime(hours, textSearchid.getText());
		}

	}

}

