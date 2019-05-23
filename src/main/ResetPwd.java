package main;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import objectFactory.ObjectFactory;
import service.AdminService;

public class ResetPwd extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AdminService adminService = (AdminService) ObjectFactory.getoObject("AdminService");
	public static String username, password;
	private JLabel oldpwdLable = new JLabel("原 密 码");
	private JLabel newpwdLable = new JLabel("新 密 码");
	private JLabel confirmpwdLable = new JLabel("确认密码");
	private JButton confirm = new JButton("确认");
	private JTextField oldpwdText = new JTextField();
	private JTextField newpwdText = new JTextField();
	private JTextField confirmpwdText = new JTextField();

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
		oldpwdLable.setBounds(100, 50, 100, 50);
		add(oldpwdLable);
		newpwdLable.setBounds(100, 120, 100, 50);
		add(newpwdLable);
		confirmpwdLable.setBounds(100, 190, 100, 50);
		add(confirmpwdLable);
		confirm.setBounds(200, 280, 80, 40);
		add(confirm);
		oldpwdText.setBounds(180, 60, 200, 30);
		add(oldpwdText);
		newpwdText.setBounds(180, 130, 200, 30);
		add(newpwdText);
		confirmpwdText.setBounds(180, 200, 200, 30);
		add(confirmpwdText);
	}

	public void addListen() {
		confirm.addActionListener(new ActionListener() {

			@Override
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String oldPwd = oldpwdText.getText();
				String newPwd = newpwdText.getText();
				String confirmPwd = confirmpwdText.getText();
				if (oldPwd.equals("") || newPwd.equals("") || confirmPwd.equals("")) {
					JOptionPane.showMessageDialog(null, "请填写完整", "错误提示", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (!oldPwd.equals(password)) {
					JOptionPane.showMessageDialog(null, "原密码不正确", "错误提示", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (!newPwd.equals(confirmPwd)) {
					JOptionPane.showMessageDialog(null, "两次密码不一致", "错误提示", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (oldPwd.equals(newPwd)) {
					JOptionPane.showMessageDialog(null, "新旧密码不能相同", "错误提示", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (adminService.updateAdmin(username, newPwd)) {
					dispose();
					JOptionPane.showMessageDialog(null, "修改密码成功,请重新登录");
					AdminLogin adminLogin = new AdminLogin("管理员登录");
					return;
				}
				JOptionPane.showMessageDialog(null, "重设密码失败", "错误提示", JOptionPane.ERROR_MESSAGE);
				return;
			}
		});
	}

}
