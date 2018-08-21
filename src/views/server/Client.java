package views.server;

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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import DB.DAO.MemberDAO;
import client.clientInfo.ClientThread;
import client.clientInfo.infoDAO;
import client.clientInfo.infoDTO;
import views.client.ChooseSnackView;
import views.client.LoginView;

//�ּ�: ������
public class Client extends JFrame implements ActionListener {
	//Test��. �׽�Ʈ �Ϸ� �� main�� �����ؾ���  ====================================================================================
	public static void main(String[] args) {
		infoDAO dao= new infoDAO();
		infoDTO dto= new infoDTO();
		dto = dao.GetInfo("test");
		
		Client c= new Client(3,"test");
		c.SetName(dto.getName());
		c.SetTime(dto.getHour(), dto.getMinute(), dto.getSecond());
	}
	int swit=0;
	private JPanel contentPane;
	private JTextField textField;//id
	private JTextField textField_1;//�̸�
	private JTextField textField_2;//�����ð�
	private JTextField textField_3;//���ð�
	
	private PrintWriter pw=null;
	private BufferedReader in=null;
	private int num=0;
	
	//���κ信�� �¼�ĭ�� ������ ����ȴ�. Main_GUI_Event���� �����ڸ� ȣ���� ��������� ���� �����Ѵ�.
	//lh	:�����ð� �� ��	/ hour	:���ð� �� ��
	//lm	:�����ð� �� ��	/ minute:���ð� �� ��
	//ls	:�����ð� �� ��	/ second:���ð� �� ��
	//timer	:�����ð��� ���ð� ���������� Ÿ�̸�
	//csv	:�԰Ÿ� ���� View
	int lh=0;
	int lm=0;
	int ls=0;
	int hour = 0; 
	int minute = 0;
	int second = 0;
	javax.swing.Timer timer; 
	ChooseSnackView csv;
	
	//getter�� setter
	public int getLh() {
		return lh;
	}
	public void setLh(int lh) {
		this.lh = lh;
	}
	public int getLm() {
		return lm;
	}
	public void setLm(int lm) {
		this.lm = lm;
	}
	public int getLs() {
		return ls;
	}
	public void setLs(int ls) {
		this.ls = ls;
	}
	
	//Login���� �̸��� �����ϱ� ���� �޼���.
	public void SetName(String text) {
		textField_1.setText(text);
	}
	
	//Login���� �����ð��� �����ϱ� ���� �޼���.
	public void SetTime(int hour, int minute, int second) {
		lh=hour;
		lm=minute;
		ls=second;
		textField_2.setText(lh+ ":" + lm + ":"+ ls);
	}
	
	//dipose�� ȣ��� �� ȣ��� �޼���.
	//DAO�� ���� ���� ���� �ð��� DB�� �����Ű�� �ý����� �����Ų��.
	public void closeview() {
		// TODO Auto-generated method stub
		MemberDAO dao= new MemberDAO();
		dao.UpdateTime(textField.getText(), textField_2.getText());
		timer.stop();
		System.exit(0);
	}

	////////////////////////////////////
	//i		:�α��ε� PC��ȣ		/ cur_id	: Login���� �α��ε� ID
	public Client(int i, String cur_id) {
		this.num=i;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500,800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//PC��ȣ��
		JLabel lblPcnumber = new JLabel((i+1) + " \uBC88 PC");
		lblPcnumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblPcnumber.setFont(new Font("Gulim", Font.PLAIN, 27));
		lblPcnumber.setBounds(145, 39, 200, 32);
		contentPane.add(lblPcnumber);
		
		//���̵��
		JLabel lblClientid = new JLabel("\uD68C\uC6D0 I.D.");
		lblClientid.setFont(new Font("Gulim", Font.PLAIN, 27));
		lblClientid.setBounds(40, 155, 121, 32);
		contentPane.add(lblClientid);
	
		//�̸���
		JLabel lblClientname = new JLabel("\uD68C\uC6D0 \uC774\uB984");
		lblClientname.setFont(new Font("Gulim", Font.PLAIN, 27));
		lblClientname.setBounds(40, 225, 121, 32);
		contentPane.add(lblClientname);
		
		//�����ð���
		JLabel lblResttime = new JLabel("\uB0A8\uC740 \uC2DC\uAC04");
		lblResttime.setFont(new Font("Gulim", Font.PLAIN, 27));
		lblResttime.setBounds(40, 285, 121, 32);
		contentPane.add(lblResttime);
		
		//���ð���
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
		
		//�԰Ÿ����ù�ư
		JButton btnFood = new JButton("�԰Ÿ�����");
		btnFood.setFont(new Font("Gulim", Font.PLAIN, 27));
		btnFood.setBounds(155, 449, 175, 40);
		//ChooseSnackView�� ���⼭ �����ϸ� �԰Ÿ������Ҷ� �α׾ƿ��� �����𸣰���. �׷��� ������ �����ص�.
		csv= new ChooseSnackView(this,textField,textField_2);
		btnFood.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				csv.setVisible(true);
			}
		});
		contentPane.add(btnFood);

		//��������ư
		JButton btnLogout = new JButton("\uC0AC\uC6A9 \uC885\uB8CC");
		btnLogout.setFont(new Font("Gulim", Font.PLAIN, 27));
		btnLogout.setBounds(40, 616, 175, 40);
		btnLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//DB�� ������ dipose�ϴ� Ŭ�����޼ҵ�
				closeview();
			}
		});
		contentPane.add(btnLogout);
		
		//��ư : ����, �������
		
		this.setVisible(true);
		
//		192.168.0.84
		String host="localhost";
		int port=7777;
		Socket socket=null;
		ClientThread ct=null;
		Thread job=null;
		try {
			socket=new Socket(host, port);
			pw=new PrintWriter(socket.getOutputStream());
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//�α����� PC��ȣ�� socket�� OutputStream�� �̿��� SeatThread�� �Ѱ��ش�.
			pw.println(i);
			pw.flush();
			
			//rs1	:PC�� ��������� üũ �� ��ȯ���� ����( 1:��밡��, else:����� )
			//rs1	:�̹� �α����� ���̵����� üũ �� ��ȯ���� ����( 1:��밡��, else:����� )
			String rs1=null;
			String rs2=null;
			//SeatThread�κ��� ������� PC���� üũ�ϴ� ��ȯ���� ���������� ����Ѵ�.
			rs1=in.readLine();
			if(rs1.equals("1")) {
				//�α����� ���̵� SeatThread�� �Ѱ��ش�.
				pw.println(cur_id);
				pw.flush();
				//SeatThread�κ��� ������� ���̵����� üũ�ϴ� ��ȯ���� ���������� ����Ѵ�.
				rs2=in.readLine();
				if(rs2.equals("1")) {
					JOptionPane.showMessageDialog(null, cur_id + " �α��� �Ϸ�.");
					timer = new javax.swing.Timer(500, this); 
					timer.setInitialDelay(0); 
					timer.start();
				}else {
					JOptionPane.showMessageDialog(null, "�̹� �������� ���̵��Դϴ�.");
				}
			}else {
				JOptionPane.showMessageDialog(null, "������� PC�Դϴ�.");	
			}
			//���� �ϳ��� ���Ұ����� ��� �α���â�� �ٽ� ���� Ŭ���̾�Ʈ�� �ݴ´�
			if(!rs1.equals("1") || !rs2.equals("1")) {
				LoginView lv= new LoginView();
				lv.setVisible(true);
				dispose();
			}
			ct=new ClientThread(socket,textField_2,textField_3);
			job=new Thread(ct);
			job.start();
		}catch(IOException ex){
			System.out.println(ex);
		}finally {
			//���⼭ �ݾƵ��Ǵ��� �𸣰ھ �ϴ� ���ܵ� ====================================================================================
//			if(pw!=null) try { pw.close();} catch(Exception ex) {}
//			if(socket!=null) try { socket.close();} catch(IOException ex) {}
		}
		
	}
	//timer�� �ҽ� �����ð��� ���ð��� ����ϰ� ������ش�.
	@Override
	public void actionPerformed(ActionEvent e) {
		if(swit==0) {
		pw.println("left@"+num);
		pw.flush();
		swit=1;
		}else {
		pw.println("cur@"+num);
		pw.flush();
		swit=0;
		}
	}
}