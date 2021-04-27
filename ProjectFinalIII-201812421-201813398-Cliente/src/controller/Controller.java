package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import models.Course;
import models.User;
import net.Conection;
import persistence.GSONFileManager;
import views.Constants;
import views.JWindow;

public class Controller implements ActionListener {

	private JWindow window;
	private Conection conection;

	public Controller() {
		conection = new Conection();
		window = new JWindow(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Event.valueOf(e.getActionCommand())) {
		case HIDE_PASSWORD:
			window.hidePassword();
			break;
		case LOGIN_ACCOUNT:
			window.loginAccount();
			break;
		case GET_LOGIN_DATA:
			System.out.println(window.isLogin());
			conection.sendBoolean(window.isLogin());
			String data = window.getLoginData();
			String[] dataUser = data.split(",");
			if (!data.equalsIgnoreCase("confirmAccount")) {
				window.changeCard("Student");
				String stringUser = new Gson().toJson(new User("", dataUser[0], dataUser[1])).toString();
				try {
					conection.sendUTF(stringUser);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			break;
		case CANCEL_NEW_ACCOUNT:
			window.resetLogin();
			break;
		case SHOW_SCHEDULE:
			window.changeCardStudent("Schedule");
			break;
		case ADD_COURSE_ST:	
			window.changeCardStudent("AddCourse");
			break;
		case ADD_S_COURSE:

			break;
		default:
			break;
		}
	}
}