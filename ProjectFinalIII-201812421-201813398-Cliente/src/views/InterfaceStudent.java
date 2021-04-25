package views;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

import controller.Controller;

public class InterfaceStudent extends JPanel{

	private static final long serialVersionUID = 1L;
	private MenuStudent menu;
	private PanelInfoStudent info;
	
	public InterfaceStudent(Controller controller) {
		setBackground(Color.WHITE);
		setLayout(new BorderLayout());
		initComponents(controller);
	}

	private void initComponents(Controller controller) {
		menu = new MenuStudent(controller);
		add(menu, BorderLayout.WEST);
		
		info = new PanelInfoStudent(controller);
		add(info, BorderLayout.CENTER);
	}

	public void showSchedule() {
		info.showSchedule();
		
	}

}
