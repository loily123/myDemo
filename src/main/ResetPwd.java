package main;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ResetPwd extends JFrame {
	private JButton resetPassword = new JButton("重设密码");
	private JButton addBrother = new JButton("添加小弟");

	public ResetPwd(String title) {
		super(title);
		init();
		addComponent();
		addListen();
		setVisible(false);
	}

	public void init() {
		this.getContentPane().setBackground(Color.PINK);
		setSize(500, 400);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void addComponent() {
		resetPassword.setBounds(200, 100, 100, 50);
		add(resetPassword);
		addBrother.setBounds(200, 200, 100, 50);
		add(addBrother);
	}

	public void addListen() {

	}

}
