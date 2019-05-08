package main;

import java.awt.*;

import javax.swing.*;

public class Login extends JFrame {
	private JPanel topPanel = new JPanel();
	private JPanel mainPanel = new JPanel();
	private JLabel title = new JLabel("��ӭ����С�ܿͻ���");
	private JLabel usernameLable = new JLabel("�û���");
	private JLabel passwordLable = new JLabel("��  ��");
	private JTextField usernameText = new JTextField();
	private JTextField passwordText = new JTextField();
	private JButton inhabButton = new JButton("��¼");
	private JLabel bottomText=new JLabel("С��ϵͳΪ������  xiaodi@qq.com");

	public Login(String title) {
		super(title);
		init();
		addComponent();
		setVisible(true);
	}

	public void init() {
		this.getContentPane().setBackground(Color.PINK);
		setSize(1000, 720);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void addComponent() {
		topPanel.setBackground(Color.gray);
		topPanel.setBounds(10, 10, 980, 100);
		Font font = new Font("����", Font.BOLD, 50);
		title.setFont(font);
		title.setForeground(Color.WHITE);
		topPanel.add(title);
		add(topPanel);
		mainPanel.setBounds(10, 115, 980, 500);
		mainPanel.setBackground(Color.WHITE);
		add(mainPanel);
		font = new Font("����", Font.PLAIN, 40);
		usernameLable.setFont(font);
		mainPanel.setLayout(null);
		usernameLable.setBounds(200, 30, 200, 100);
		mainPanel.add(usernameLable);
		passwordLable.setFont(font);
		passwordLable.setBounds(200, 150, 200, 100);
		mainPanel.add(passwordLable);
		usernameText.setBounds(400, 50, 300, 50);
		mainPanel.add(usernameText);
		passwordText.setBounds(400, 180, 300, 50);
		mainPanel.add(passwordText);
		font=new Font("����", Font.BOLD, 20);
		inhabButton.setFont(font);
		inhabButton.setBackground(new Color(187,255,255));
		inhabButton.setBounds(500, 350, 150, 50);
		mainPanel.add(inhabButton);
		font=new Font("����", Font.BOLD, 20);
		bottomText.setFont(font);
		bottomText.setForeground(new Color(132,112,255));
		bottomText.setBounds(300, 600, 600, 100);
		add(bottomText);
	}

	public static void main(String[] args) {
		Login login = new Login("С�ܵ�¼");
	}
}
