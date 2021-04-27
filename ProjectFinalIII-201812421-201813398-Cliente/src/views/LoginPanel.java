package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import controller.Event;

public class LoginPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField passwordField, userField;
	private JPanel info, login;
	private boolean isHidePassword, isCreateAccount, isConfirmAccount;
	private JLabel infoData, msjLogin, userConfirm, passwordConfirm;
	private JButton changeAccount, accept, acceptAccount, cancelAccount, showPass;

	public LoginPanel(ActionListener actionListener) {
		setLayout(new BorderLayout(0, Constants.HEIGHT / 10));
		setBackground(Color.WHITE);
		setBorder(BorderFactory.createEmptyBorder(0, Constants.WIDTH / 5, 0, Constants.WIDTH / 5));
		initComponents(actionListener);
	}

	private void initComponents(ActionListener actionListener) {
		createInfoPanel();
		createLoginPanel(actionListener);
		initBooleans();
	}

	private void createInfoPanel() {
		info = new JPanel(new BorderLayout(0, 0));
		info.setBackground(Constants.DARK_BLUE);
		info.setPreferredSize(new Dimension(Constants.WIDTH, Constants.HEIGHT / 5));

		initInfo();

		add(info, BorderLayout.NORTH);
	}

	private void initInfo() {
		JLabel iconApp = new JLabel();
		ImageIcon img = new ImageIcon(new ImageIcon(getClass().getResource(Constants.PATH_APP_ICON)).getImage()
				.getScaledInstance(Constants.WIDTH / 10, Constants.WIDTH / 10, Image.SCALE_SMOOTH));
		iconApp.setIcon(img);
		info.add(iconApp, BorderLayout.WEST);

		JLabel nameApp = new JLabel(Constants.NAME_APP);
		nameApp.setFont(new Font("Segoe UI", Font.PLAIN, 50));
		nameApp.setForeground(Color.WHITE);
		nameApp.setAlignmentX(LEFT_ALIGNMENT);
		info.add(nameApp, BorderLayout.CENTER);
	}

	private void createLoginPanel(ActionListener actionListener) {
		login = new JPanel(new BorderLayout(Constants.WIDTH / 10, 0));
		login.setBackground(Color.WHITE);
		login.setBorder(
				BorderFactory.createEmptyBorder(0, Constants.WIDTH / 10, Constants.HEIGHT / 10, Constants.WIDTH / 10));

		initLogin(actionListener);

		add(login, BorderLayout.CENTER);
	}

	private void initLogin(ActionListener actionListener) {
		infoData = new JLabel(Constants.INFO_LOGIN);
		infoData.setFont(Constants.DEFAULT_FONT_ITALIC_MAX);
		infoData.setForeground(Color.GRAY);
		infoData.setAlignmentX(CENTER_ALIGNMENT);
		login.add(infoData, BorderLayout.NORTH);

		JPanel containerLogin = new JPanel(new GridBagLayout());
		containerLogin.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
		containerLogin.setBackground(Color.WHITE);
		GridBagConstraints constraints = new GridBagConstraints();

		userField = new JTextField();
		userField.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Constants.DARK_BLUE),
				"Usuario", TitledBorder.LEFT, TitledBorder.TOP, Constants.DEFAULT_FONT_MIN, Constants.DARK_BLUE));
		userField.setPreferredSize(new Dimension(Constants.WIDTH / 4, Constants.HEIGHT / 10));
		userField.setFont(Constants.DEFAULT_FONT);
		userField.setForeground(Color.BLACK);
		GridBagConstrainsForm.gridBagConstrainsForm(constraints, 0, 0, 1, 1);
		containerLogin.add(userField, constraints);

		passwordField = new JTextField();
		passwordField.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Constants.DARK_BLUE),
				"Contraseña", TitledBorder.LEFT, TitledBorder.TOP, Constants.DEFAULT_FONT_MIN, Constants.DARK_BLUE));
		passwordField.setPreferredSize(new Dimension(Constants.WIDTH / 4, Constants.HEIGHT / 10));
		passwordField.setFont(Constants.DEFAULT_FONT);
		passwordField.setForeground(Color.BLACK);
		passwordField.setSelectionColor(Constants.DARK_BLUE);
		GridBagConstrainsForm.gridBagConstrainsForm(constraints, 0, 1, 1, 1);
		containerLogin.add(passwordField, constraints);

		showPass = new JButton();
		showPass.setPreferredSize(new Dimension(Constants.WIDTH / 40, Constants.WIDTH / 40));
		showPass.setBackground(Color.WHITE);
		showPass.addActionListener(actionListener);
		showPass.setActionCommand(Event.HIDE_PASSWORD.toString());
		ImageIcon img = new ImageIcon(new ImageIcon(getClass().getResource(Constants.PATH_EYE_ICON)).getImage()
				.getScaledInstance(Constants.WIDTH / 40, Constants.WIDTH / 40, Image.SCALE_SMOOTH));
		showPass.setIcon(img);
		GridBagConstrainsForm.gridBagConstrainsForm(constraints, 2, 1, 1, 1);
		containerLogin.add(showPass, constraints);

		accept = new JButton("Aceptar");
		accept.setFont(Constants.DEFAULT_FONT);
		accept.setForeground(Color.WHITE);
		accept.setBackground(Constants.DARK_BLUE);
		accept.setFocusable(false);
		accept.addActionListener(actionListener);
		accept.setActionCommand(Event.GET_LOGIN_DATA.toString());
		GridBagConstrainsForm.gridBagConstrainsForm(constraints, 0, 2, 1, 1);
		containerLogin.add(accept, constraints);

		msjLogin = new JLabel(Constants.MSJ_LOGIN_ACCOUNT);
		msjLogin.setFont(Constants.DEFAULT_FONT);
		msjLogin.setForeground(Color.GRAY);
		GridBagConstrainsForm.gridBagConstrainsForm(constraints, 0, 3, 2, 1);
		containerLogin.add(msjLogin, constraints);

		changeAccount = new JButton(Constants.BT_CREATE_ACCOUNT);
		changeAccount.setFont(Constants.DEFAULT_FONT);
		changeAccount.setForeground(Constants.DARK_BLUE);
		changeAccount.setBackground(Color.WHITE);
		changeAccount.setFocusable(false);
		changeAccount.setActionCommand(Event.LOGIN_ACCOUNT.toString());
		changeAccount.addActionListener(actionListener);
		GridBagConstrainsForm.gridBagConstrainsForm(constraints, 0, 4, 1, 1);
		containerLogin.add(changeAccount, constraints);

		userConfirm = new JLabel();
		userConfirm.setFont(Constants.DEFAULT_FONT);
		userConfirm.setForeground(Color.GRAY);
		userConfirm.setVisible(false);
		GridBagConstrainsForm.gridBagConstrainsForm(constraints, 0, 5, 1, 1);
		containerLogin.add(userConfirm, constraints);

		passwordConfirm = new JLabel();
		passwordConfirm.setFont(Constants.DEFAULT_FONT);
		passwordConfirm.setForeground(Color.GRAY);
		passwordConfirm.setVisible(false);
		GridBagConstrainsForm.gridBagConstrainsForm(constraints, 0, 6, 1, 1);
		containerLogin.add(passwordConfirm, constraints);

		acceptAccount = new JButton("Aceptar");
		acceptAccount.setFont(Constants.DEFAULT_FONT);
		acceptAccount.setForeground(Color.WHITE);
		acceptAccount.setBackground(Constants.DARK_BLUE);
		acceptAccount.setFocusable(false);
		acceptAccount.setVisible(false);
		acceptAccount.addActionListener(actionListener);
		acceptAccount.setActionCommand(Event.GET_LOGIN_DATA.toString());
		GridBagConstrainsForm.gridBagConstrainsForm(constraints, 0, 2, 1, 1);
		containerLogin.add(acceptAccount, constraints);

		cancelAccount = new JButton("Cancelar");
		cancelAccount.setFont(Constants.DEFAULT_FONT);
		cancelAccount.setForeground(Color.WHITE);
		cancelAccount.setBackground(Constants.DARK_BLUE);
		cancelAccount.setFocusable(false);
		cancelAccount.setVisible(false);
		cancelAccount.addActionListener(actionListener);
		cancelAccount.setActionCommand(Event.CANCEL_NEW_ACCOUNT.toString());
		GridBagConstrainsForm.gridBagConstrainsForm(constraints, 1, 2, 1, 1);
		containerLogin.add(cancelAccount, constraints);

		login.add(containerLogin, BorderLayout.CENTER);
	}

	private void initBooleans() {
		isHidePassword = false;
		isCreateAccount = false;
		isConfirmAccount = false;
	}

	public void hidePassword() {
		if (!isHidePassword) {
			isHidePassword = true;
			passwordField.setForeground(Color.WHITE);
			passwordField.setSelectedTextColor(Constants.DARK_BLUE);
			passwordField.setSelectionColor(Constants.DARK_BLUE);
		} else {
			isHidePassword = false;
			passwordField.setForeground(Color.BLACK);
			passwordField.setSelectedTextColor(Color.WHITE);
			passwordField.setSelectionColor(Constants.DARK_BLUE);
		}
	}

	public void loginAccount() {
		if (!isCreateAccount) {
			isCreateAccount = true;
			showPass.setVisible(false);
			passwordField.setForeground(Color.BLACK);
			passwordField.setText("");
			infoData.setText(Constants.INFO_CREATE);
			msjLogin.setText(Constants.MSJ_LOGIN_ACCOUNT);
			changeAccount.setText(Constants.BT_LOGIN_ACCOUNT);
		} else {
			isCreateAccount = false;
			showPass.setVisible(true);
			infoData.setText(Constants.INFO_LOGIN);
			msjLogin.setText(Constants.MSJ_CREATE_ACCOUNT);
			changeAccount.setText(Constants.BT_CREATE_ACCOUNT);
		}
	}

	public String getLoginData() {
		if (!isCreateAccount) {
			return userField.getText() + "," + passwordField.getText();
		} else {
			msjLogin.setText("�Estas seguro?");
			passwordField.setEditable(false);
			userField.setEditable(false);
			infoData.setText(Constants.CONFIRM_DATA);
			changeAccount.setVisible(false);
			userConfirm.setText("Usuario:" + userField.getText());
			userConfirm.setVisible(true);
			passwordConfirm.setText("Contrasena: " + passwordField.getText());
			accept.setVisible(false);
			passwordConfirm.setVisible(true);
			acceptAccount.setVisible(true);
			cancelAccount.setVisible(true);
			if (isConfirmAccount) {
				return userField.getText() + "," + passwordField.getText();
			} else {
				isConfirmAccount = true;
				return "confirmAccount";
			}
		}
	}

	public void resetLogin() {
		showPass.setVisible(true);
		msjLogin.setText(Constants.MSJ_LOGIN_ACCOUNT);
		accept.setActionCommand(Event.GET_LOGIN_DATA.toString());
		isCreateAccount = false;
		userField.setEditable(true);
		passwordField.setEditable(true);
		infoData.setText(Constants.INFO_LOGIN);
		changeAccount.setVisible(true);
		userConfirm.setText("");
		userConfirm.setVisible(false);
		passwordConfirm.setText("");
		accept.setVisible(true);
		passwordConfirm.setVisible(false);
		acceptAccount.setVisible(false);
		cancelAccount.setVisible(false);
		isConfirmAccount = false;
		changeAccount.setText(Constants.BT_LOGIN_ACCOUNT);
	}

	public boolean isLogin() {
		return isCreateAccount;
	}
}