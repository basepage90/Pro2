package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JLabel;

import views.SeatView;

public class SeatThread implements Runnable{
	private Socket socket;
	private int num;
	private String id;
	private Seat[] seat;
	private JLabel[] lb_time;
	private JLabel[] lb_cur_time;
	private int check_num=0;
	private int check_id=0;
	
	public  SeatThread(Socket socket, Seat[] seat, JLabel[] lb_time, JLabel[] lb_cur_time) {// String id, int num){
		this.socket=socket;
		this.seat=seat;
		this.lb_time=lb_time;
		this.lb_cur_time=lb_cur_time;
		
		BufferedReader in=null;
		PrintWriter pw=null;
		try {
			pw=new PrintWriter(socket.getOutputStream());   
			System.out.println("PC ���� �����...");
			in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			num=Integer.parseInt(in.readLine());
			if(seat[num].GetId().equals("�����") || seat[num].GetId().equals("�α׾ƿ�")) {
				check_num=0;
			}else {
				check_num=1;
			}
			if(check_num==0) {
				System.out.println((num+1) + "��PC ����.");
			
				pw.println("1");
				pw.flush();
				id=in.readLine();
				for(int i=0; i<20; i++) {
					if(seat[i].GetId().equals(id)&& num!=i)
						check_id=1;
				}
				if(check_id==0) {
					System.out.println(id + "����� �α���");
					pw.println("1");
					pw.flush();
					seat[num].SetStart(id);
					System.out.println((num+1)+"��PC ����� "+ id);	
				}else {
					System.out.println("�̹� �α����� ���̵��Դϴ�.");
					pw.println("0");
					pw.flush();
				}//end check_id
			}else{
				System.out.println("������� PC�Դϴ�.");
				pw.println("0");
				pw.flush();
			}//end check_num
		} catch(IOException e){
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void run() {
		PrintWriter pw=null;
		BufferedReader in=null;
		try {
			pw= new PrintWriter(socket.getOutputStream());
			in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String str=null;
			while((str=in.readLine())!=null){
				
			}//while
		}catch(IOException e){
			System.out.println(e);
		}
		finally{
			seat[num].SetEnd();
			System.out.println((num+1) + "PC ����.");	
			if(socket != null)
				try{ socket.close(); } catch(IOException e){}
		}		
	}
}
