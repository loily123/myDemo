package main;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class AdminMenu extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton resetPassword = new JButton("重设密码");
	public static String username, password;

	public AdminMenu(String title) {
		super(title);
		init();
		addComponent();
		addListen();
		setVisible(false);
	}

	public void init() {
		this.getContentPane().setBackground(Color.PINK);
		setSize(300, 200);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void addComponent() {
		resetPassword.setBounds(100, 50, 100, 50);
		add(resetPassword);
	}

	public void addListen() {
		resetPassword.addActionListener(new ActionListener() {

			@SuppressWarnings("static-access")
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				ResetPwd resetPwd = new ResetPwd("重设密码");
				resetPwd.username = username;
				resetPwd.password = password;
				resetPwd.setVisible(true);
			}
		});
	}
}
