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
	
	private ArrayList<PrintWriter> arr=null;
	
	public  SeatThread(Socket socket,ArrayList<PrintWriter> arr, Seat[] seat) {// String id, int num){
		this.socket=socket;
		this.seat=seat;
		this.arr=arr;
		PrintWriter pw=null;
		try {
			pw=new PrintWriter(socket.getOutputStream());   
			System.out.println("PC ���� �����...");
			BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			num=Integer.parseInt(in.readLine());
			System.out.println((num+1) + "��PC ����.");
			pw.flush();
			id=in.readLine();
			System.out.println(id + "����� �α���");
			pw.flush();
			seat[num].SetStart(id);
			System.out.println((num+1)+"��PC ����� "+ id);	
		} catch(IOException e){
			System.out.println(e);
		}
	}

	@Override
	public void run() {
		BufferedReader in=null;
		try {
			in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String str=null;
			while((str=in.readLine())!=null){
				if(str.equals("/quit")){
					break;
				}else{
//					broadcast(str);
				}
			}//while
		}catch(IOException e)
		{
			System.out.println(e);
		}
		finally{
			seat[num].SetEnd();
			System.out.println((num+1) + "PC ����.");	
			if(socket != null)
				try{	socket.close(); } catch(IOException e){}
		}		
	}
}
