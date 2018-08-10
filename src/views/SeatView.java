package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class SeatView {

	public static void main(String[] args) {
				seat s=new seat();
				s.init();
		
		
		

	}

}


class seat{
	JFrame jf_main;// ����������
	JPanel pan_main_seat; //��ü �¼� �г�
	JPanel[] pan_seat; //�¼�1ĭ�� ������ �г�
	JLabel[] lb_time; //�����ð��� �˷��� ��
	JLabel[] lb_cur_time; //���ð��� �˷��� ��
	JLabel[] lb_id; //���� �α����� ���̵� �˷��� ��
	
	static final int MAX=20;
	public void init(){
		jf_main=new JFrame("�¼��׽�Ʈ");
		jf_main.setLayout(new BorderLayout(10,20));
		pan_main_seat=new JPanel();
		pan_main_seat.setLayout(new GridLayout(4, 5, 30, 50));
		pan_seat=new JPanel[MAX];
		lb_time=new JLabel[MAX];
		lb_cur_time=new JLabel[MAX];
		lb_id=new JLabel[MAX];
		for(int i=0;i<MAX;i++) {
			//���� ������Ʈ�� ���� �¼�1ĭ�� �߰��ϱ����� �г�.
			pan_seat[i]=new JPanel();
			pan_seat[i].setLayout(new BoxLayout(pan_seat[i],BoxLayout.Y_AXIS));
			pan_seat[i].setBackground(Color.GRAY);
			pan_seat[i].setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
			pan_seat[i].setBorder(new TitledBorder(new LineBorder(Color.white,4), i+" PC"));
			
			lb_time[i]=new JLabel("�����ð�: 00:00:00");
			lb_time[i].setForeground(Color.white);
			lb_cur_time[i]=new JLabel("���ð�: 00:01:01");
			lb_id[i] = new JLabel("���̵�:");
			
			pan_seat[i].add(lb_time[i]);
			pan_seat[i].add(lb_cur_time[i]);
			pan_seat[i].add(lb_id[i]);
			
			pan_seat[i].addMouseListener(new MouseListener() {
	            public void mouseClicked(MouseEvent e) {
	                System.out.println(":MOUSE_CLICK_EVENT:");
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
	        });
			
			pan_main_seat.add(pan_seat[i]);
		}
		jf_main.add(pan_main_seat,BorderLayout.CENTER);//�¼��г� �߰�
		
		JPanel pan_btn = new JPanel();
		pan_btn.setLayout(new GridLayout(7, 1));
		JButton btn1 =new JButton("������Ȳ");
		JButton btn2 =new JButton("������");
		JButton btn3 =new JButton("����");
		JButton btn4 =new JButton("ȸ������");
		
		pan_btn.add(btn1);
		pan_btn.add(new JLabel(""));
		pan_btn.add(btn2);
		pan_btn.add(new JLabel(""));
		pan_btn.add(btn3);
		pan_btn.add(new JLabel(""));
		pan_btn.add(btn4);
		jf_main.add(pan_btn,BorderLayout.EAST);
		
		jf_main.setSize(1000, 900);
		jf_main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf_main.setVisible(true);
	}
}