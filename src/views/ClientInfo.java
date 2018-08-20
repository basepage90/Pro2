package views;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import server.Seat;


//�ּ� : ������
public class ClientInfo extends JFrame implements ActionListener {
	private JPanel contentPane;
	private JTextField textField;//id
	private JTextField textField_1;//�̸�
	private JTextField textField_2;//�����ð�
	private JTextField textField_3;//���ð�
	
	//���κ信�� �¼�ĭ�� ������ ����ȴ�. Main_GUI_Event���� �����ڸ� ȣ���� ��������� ���� �����Ѵ�.
	//lh	:�����ð� �� �ð�	/ lb_cur_time	:�����ð� ��� JLabel
	//lm	:�����ð� �� ��	/ lb_time		:���ð� ��� JLabel
	//ls	:�����ð� �� ��
	//seat	:���κ信�� �α��ε� PC�� �¼�ĭ
	//timer	:���κ信�� �����ð��� ���ð��� �ҷ��������� Ÿ�̸�
	private int lh=0;
	private int lm=0;
	private int ls=0;
	private Seat seat;
	private JLabel lb_cur_time;
	private JLabel lb_time;
	private javax.swing.Timer timer;
	
	//Addtime���� ������ �ð��� ���κ��� �¼����� �����Ű������ �޼���.
	public void AddT(int h) {
		seat.Setlh(seat.Getlh()+h);
	}
	
	//â�� ������ timer����.
	@Override
	public void dispose() {
		timer.stop();
		super.dispose();
	}
	
	//Main_GUI_Event���� �̸��� �����ϱ� ���� �޼���.
	public void SetName(String text) {
		textField_1.setText(text);
	}
	
	//�ʱⰪ ����ֱ�����.
	public void SetTime(int hour, int minute, int second) {
		lh=hour;
		lm=minute;
		ls=second;
		textField_2.setText(lh+ ":" + lm + ":"+ ls);
	}

	//timer 1�ʸ��� ����� ����. ���κ� �¼��� �����ð��� ���ð��� �ҷ��´�.
	@Override
	public void actionPerformed(ActionEvent e) {
		textField_2.setText(lb_time.getText());
		textField_3.setText(lb_cur_time.getText());	
	}
	
	//���κ信�� �¼�ĭ�� ������ ����ȴ�. Main_GUI_Event���� �����ڸ� ȣ���� ��������� ���� �����Ѵ�.
	//i			 :�α��ε� PC��ȣ 	/ seat 	: ���κ信�� �α��ε� PC�� �¼�ĭ
	//cur_id	 : 				/ cur_id: ���κ信�� �α��ε� PC�� ID��
	//lb_cur_time:���κ信�� �α��ε� PC�� �����ð� JLabel
	//lb_time	 :���κ信�� �α��ε� PC�� ���ð� JLabel
	public ClientInfo(int i,Seat seat, String cur_id, JLabel lb_cur_time, JLabel lb_time) {
		this.lb_cur_time=lb_cur_time;
		this.lb_time=lb_time;
		this.seat=seat;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500,800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//PC ��ȣ ��� ��
		JLabel lblPcnumber = new JLabel((i+1) + " \uBC88 PC");
		lblPcnumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblPcnumber.setFont(new Font("Gulim", Font.PLAIN, 27));
		lblPcnumber.setBounds(145, 39, 200, 32);
		contentPane.add(lblPcnumber);

		//�α��ε� ���̵� ��� ��
		JLabel lblClientid = new JLabel("\uD68C\uC6D0 I.D.");
		lblClientid.setFont(new Font("Gulim", Font.PLAIN, 27));
		lblClientid.setBounds(40, 155, 121, 32);
		contentPane.add(lblClientid);
	
		//�α��ε� ���̵��� �̸� ��� ��
		JLabel lblClientname = new JLabel("\uD68C\uC6D0 \uC774\uB984");
		lblClientname.setFont(new Font("Gulim", Font.PLAIN, 27));
		lblClientname.setBounds(40, 225, 121, 32);
		contentPane.add(lblClientname);
		
		//�α��ε� ���̵��� �����ð� ��� ��
		JLabel lblResttime = new JLabel("\uB0A8\uC740 \uC2DC\uAC04");
		lblResttime.setFont(new Font("Gulim", Font.PLAIN, 27));
		lblResttime.setBounds(40, 285, 121, 32);
		contentPane.add(lblResttime);
		
		//�α��ε� ���̵��� ���ð� ��� ��
		JLabel lblSpendtime = new JLabel("\uC0AC\uC6A9 \uC2DC\uAC04");
		lblSpendtime.setFont(new Font("Gulim", Font.PLAIN, 27));
		lblSpendtime.setBounds(40, 345, 121, 32);
		contentPane.add(lblSpendtime);
		// �� : ȸ�� id, ȸ�� �̸�, ���� �ð�, ��� �ð� 
		
		//�ؽ�Ʈ�ʵ�� Enable�� flase�� ������ ������ �� ��������.
		//ID ��� �ʵ�
		textField = new JTextField(cur_id);
		textField.setFont(new Font("Gulim", Font.PLAIN, 27));
		textField.setBounds(200, 150, 236, 38);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setEnabled(false);
		
		//�̸� ��� �ʵ�
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Gulim", Font.PLAIN, 27));
		textField_1.setBounds(200, 220, 236, 38);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setEnabled(false);
		
		//�����ð� ����ʵ�
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Gulim", Font.PLAIN, 27));
		textField_2.setBounds(200, 280, 236, 38);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		textField_2.setEnabled(false);
		
		//���ð� ��� �ʵ�
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Gulim", Font.PLAIN, 27));
		textField_3.setBounds(200, 340, 236, 38);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		textField_3.setEnabled(false);
		// ��� �ʵ� : ȸ�� ID, ȸ�� �̸�, ���� �ð�, ��� �ð�
		
		//������ư
		JButton btnAddtime = new JButton("\uCDA9 \uC804");
		btnAddtime.setFont(new Font("Gulim", Font.PLAIN, 27));
		btnAddtime.setBounds(155, 449, 175, 40);
		contentPane.add(btnAddtime);
		
		//������� ��ư.
		JButton btnLogout = new JButton("\uC0AC\uC6A9 \uC885\uB8CC");
		btnLogout.setFont(new Font("Gulim", Font.PLAIN, 27));
		btnLogout.setBounds(40, 616, 175, 40);
		contentPane.add(btnLogout);
		
		JButton btnclose = new JButton("\uB2EB\uAE30");
		btnclose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		btnclose.setFont(new Font("Gulim", Font.PLAIN, 27));
		btnclose.setBounds(250, 616, 175, 40);
		contentPane.add(btnclose);
		// ��ư : �� ��, ��� ���� , �ݱ�
		
		this.setVisible(true);
		
		//������ư�� ������ ��� View�� �����.
		//���⼱ ����� Textfield������ ����View���� JLabel�����̶� JLabel�� ID���� �����ϰ� ���θ��� �Ѱ���
		AddtimeView atv=new AddtimeView(new JLabel(textField.getText()));
		//���������� ���κ信�� �����Ű������ ���� Ŭ���̾�Ʈ ����â�� �Ѱ��ش�.
		atv.setClientInfo(this);
		//Ŭ���̾�Ʈ�� ������ �Ѱ��ص� �׼Ǹ����ʸ� �����ϱ� ���� �޼���.
		atv.SetBtn();
		btnAddtime.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				atv.setVisible(true);
			}
		});
		
		//Ÿ�̸� ����.
		//���κ��� ���ð��� 1�ʸ��� �ҷ����� ���. ���üҽ��� actionPerformed�޼ҵ忡 ����.
		timer = new javax.swing.Timer(1000, this); 
		timer.setInitialDelay(0); 
		timer.start(); 
	}
}
