package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import service.AdminService;
import service.impl.AdminServiceImpl;

public class AdminLogin extends JFrame {
	private AdminService adminService = new AdminServiceImpl();
	private JPanel topPanel = new JPanel();
	private JPanel mainPanel = new JPanel();
	private JLabel title = new JLabel("欢迎进入我的Demo系统");
	private JLabel usernameLable = new JLabel("用户名");
	private JLabel passwordLable = new JLabel("密  码");
	private JTextField usernameText = new JTextField();
	private JTextField passwordText = new JTextField();
	private JButton adminButton = new JButton("登录");
	private JLabel bottomText = new JLabel("Demo系统为您服务  2810637851@qq.com");

	public AdminLogin(String title) {
		super(title);
		init();
		addComponent();
		addListen();
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
		Font font = new Font("宋体", Font.BOLD, 50);
		title.setFont(font);
		title.setForeground(Color.WHITE);
		topPanel.add(title);
		add(topPanel);
		mainPanel.setBounds(10, 115, 980, 500);
		mainPanel.setBackground(Color.WHITE);
		add(mainPanel);
		font = new Font("宋体", Font.PLAIN, 40);
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
		font = new Font("宋体", Font.BOLD, 20);
		adminButton.setFont(font);
		adminButton.setBounds(400, 350, 150, 50);
		adminButton.setBackground(new Color(187, 255, 255));
		mainPanel.add(adminButton);
		font = new Font("宋体", Font.BOLD, 20);
		bottomText.setFont(font);
		bottomText.setForeground(new Color(132, 112, 255));
		bottomText.setBounds(300, 600, 600, 100);
		add(bottomText);
	}

	public void addListen() {
		adminButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String username = usernameText.getText();
				String password = passwordText.getText();
				if (adminService.queryByUserName(username, password)) {
					dispose();
					AdminMenu adminMenu = new AdminMenu("管理员界面");
					adminMenu.username = username;
					adminMenu.password = password;
					adminMenu.setVisible(true);
				}
			}
		});
	}

	public static void main(String[] args) {
		AdminLogin adminLogin = new AdminLogin("管理员登陆");
	}
}
