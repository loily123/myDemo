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
	private JLabel oldpwdLable = new JLabel("ԭ �� ��");
	private JLabel newpwdLable = new JLabel("�� �� ��");
	private JLabel confirmpwdLable = new JLabel("ȷ������");
	private JButton confirm = new JButton("ȷ��");
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
					JOptionPane.showMessageDialog(null, "����д����", "������ʾ", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (!oldPwd.equals(password)) {
					JOptionPane.showMessageDialog(null, "ԭ���벻��ȷ", "������ʾ", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (!newPwd.equals(confirmPwd)) {
					JOptionPane.showMessageDialog(null, "�������벻һ��", "������ʾ", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (oldPwd.equals(newPwd)) {
					JOptionPane.showMessageDialog(null, "�¾����벻����ͬ", "������ʾ", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (adminService.updateAdmin(username, newPwd)) {
					dispose();
					JOptionPane.showMessageDialog(null, "�޸�����ɹ�,�����µ�¼");
					AdminLogin adminLogin = new AdminLogin("����Ա��¼");
					return;
				}
				JOptionPane.showMessageDialog(null, "��������ʧ��", "������ʾ", JOptionPane.ERROR_MESSAGE);
				return;
			}
		});
	}

}
