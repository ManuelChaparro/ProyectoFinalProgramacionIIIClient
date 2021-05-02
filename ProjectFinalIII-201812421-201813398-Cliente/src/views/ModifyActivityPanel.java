package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JSpinner.DefaultEditor;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import controller.Controller;
import controller.Event;

public class ModifyActivityPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JComboBox<String> activity;
	private JComboBox<String> days;
	private JSpinner init, end;
	private JTextArea annotation, name;
	private ButtonObj modifyHomework, acceptModify;
	private JPanel containerModify, containerSchedule, schedule;

	public ModifyActivityPanel(Controller controller) {
		setLayout(new GridLayout(3, 1, 50, 10));
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension((int) (Constants.WIDTH / 1.4), (int) (Constants.HEIGHT / 1.2)));
		initComponents(controller);
	}

	private void initComponents(Controller controller) {
		initSearchActivity(controller);
		addComponentsSearch();
		JPanel containerButton = initCompModify(controller);
		addComponensThis(containerButton);
	}

	private void addComponensThis(JPanel containerButton) {
		containerModify.add(name);
		containerModify.add(annotation);

		schedule = new JPanel(new GridLayout(1, 2));
		schedule.setBackground(Color.WHITE);

		schedule.add(containerSchedule);
		schedule.add(containerButton);

		add(containerModify);
		add(schedule);
	}

	private void initSearchActivity(Controller controller) {
		activity = new JComboBox<String>();
		activity.addActionListener(controller);
		activity.setActionCommand(Event.RESET_MODIFY_ACTIVITY.toString());
		activity.setBackground(Color.WHITE);
		activity.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Constants.DARK_BLUE, 1),
				"ACTIVIDADES", TitledBorder.LEFT, TitledBorder.TOP, Constants.DEFAULT_FONT_BOLD, Constants.DARK_BLUE));
		activity.setFont(Constants.DEFAULT_FONT_BOLD);
		activity.setForeground(Color.BLACK);
		activity.setPreferredSize(new Dimension(Constants.WIDTH / 2, Constants.HEIGHT / 12));

		modifyHomework = new ButtonObj("Confirmar", controller, Event.MODIFY_ACTIVITY.toString(), Constants.DARK_BLUE);
	}

	private void addComponentsSearch() {
		JPanel containerBox = new JPanel(new GridLayout(2, 1));
		containerBox.setBackground(Color.WHITE);
		containerBox.add(activity);
		JPanel containerButton = new JPanel();
		containerButton.add(modifyHomework);
		containerButton.setBackground(Color.WHITE);
		containerBox.add(containerButton);
		add(containerBox);
	}

	private JPanel initCompModify(Controller controller) {
		containerModify = new JPanel(new GridLayout(2, 2, 20, 20));
		containerModify.setBackground(Color.WHITE);

		name = new JTextArea();
		name.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Constants.DARK_BLUE, 1),
				"NOMBRE DE LA ACTIVIDAD", TitledBorder.LEFT, TitledBorder.TOP, Constants.DEFAULT_FONT_BOLD,
				Constants.DARK_BLUE));
		name.setFont(Constants.DEFAULT_FONT_ITALIC_MAX);
		name.setForeground(Constants.DARK_BLUE);
		name.setBackground(Color.WHITE);
		name.setLineWrap(true);

		annotation = new JTextArea();
		annotation.setLineWrap(true);
		annotation.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Constants.DARK_BLUE, 1),
				"ANOTACIONES", TitledBorder.LEFT, TitledBorder.TOP, Constants.DEFAULT_FONT_BOLD, Constants.DARK_BLUE));
		annotation.setFont(Constants.DEFAULT_FONT);
		annotation.setForeground(Color.BLACK);

		containerSchedule = new JPanel(new GridLayout(2, 1, 20, 0));
		containerSchedule.setBackground(Color.WHITE);
		containerSchedule.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createLineBorder(Constants.DARK_BLUE, 1), "HORARIO DE LA ACTIVIDAD", TitledBorder.LEFT,
				TitledBorder.TOP, Constants.DEFAULT_FONT_BOLD, Constants.DARK_BLUE));

		days = new JComboBox<String>();
		days.setFont(Constants.DEFAULT_FONT_BOLD);
		days.setBackground(Color.WHITE);
		days.setForeground(Color.BLACK);
		days.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Constants.DARK_BLUE, 1), "DIA",
				TitledBorder.LEFT, TitledBorder.TOP, Constants.DEFAULT_FONT_BOLD, Constants.DARK_BLUE));
		for (int i = 1; i < Constants.DAYS.length; i++) {
			days.addItem(Constants.DAYS[i]);
		}

		JPanel containerHours = new JPanel(new GridLayout(1, 2));
		containerHours.setBackground(Color.WHITE);
		SpinnerModel modelInit = new SpinnerNumberModel(10, 6, 20, 1);
		init = new JSpinner(modelInit);
		init.setBackground(Color.WHITE);
		((DefaultEditor) init.getEditor()).getTextField().setEditable(false);
		((DefaultEditor) init.getEditor()).getTextField().setBackground(Color.WHITE);
		init.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Constants.DARK_BLUE, 1),
				"HORA INICIO", TitledBorder.LEFT, TitledBorder.TOP, Constants.DEFAULT_FONT_BOLD, Constants.DARK_BLUE));
		init.setFont(Constants.DEFAULT_FONT_BOLD);
		init.setForeground(Color.GRAY);

		SpinnerModel modelEnd = new SpinnerNumberModel(11, 7, 21, 1);
		end = new JSpinner(modelEnd);
		end.setBackground(Color.WHITE);
		((DefaultEditor) end.getEditor()).getTextField().setEditable(false);
		((DefaultEditor) end.getEditor()).getTextField().setBackground(Color.WHITE);
		end.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Constants.DARK_BLUE, 1),
				"HORA FIN", TitledBorder.LEFT, TitledBorder.TOP, Constants.DEFAULT_FONT_BOLD, Constants.DARK_BLUE));
		end.setFont(Constants.DEFAULT_FONT_BOLD);
		end.setForeground(Color.GRAY);

		init.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				end.setValue((int) init.getValue() + 1);
			}
		});

		containerHours.add(init);
		containerHours.add(end);

		containerSchedule.add(days);
		containerSchedule.add(containerHours);

		JPanel containerButton = new JPanel();
		containerButton.setBackground(Color.WHITE);
		containerButton.setBorder(
				BorderFactory.createEmptyBorder(Constants.HEIGHT / 20, Constants.WIDTH / 20, 0, Constants.WIDTH / 20));
		acceptModify = new ButtonObj("Aceptar", controller, Event.SEND_ACTIVITY.toString(), Constants.DARK_YELLOW);
		containerButton.add(acceptModify);
		return containerButton;
	}

	public void setVisibleModifyActivity(boolean b) {
		containerModify.setVisible(b);
		schedule.setVisible(b);
	}

	public void resetModifyPanel() {
		activity.removeAllItems();
		activity.addItem("AÑADIR ACTIVIDAD");
		annotation.setText("");
		name.setText("");
		setVisibleModifyActivity(false);
	}

	public void setEditableNameActivity(boolean b) {
		name.setEditable(b);
	}

	public String getModActString() {
		if (!name.getText().equalsIgnoreCase("") && (int) end.getValue() > (int) init.getValue()) {
			return name.getText() + ";;;" + annotation.getText() + ";;;" + days.getSelectedItem().toString() + "#"
					+ init.getValue() + "#" + end.getValue();
		} else if((int) end.getValue() <= (int) init.getValue()){
			return "errorEnd";
		}else {
			return "emptyData";
		}

	}

	public void setComboBoxActivities(String activities) {
		String[] activitiesVector = activities.split(";;;");
		for (String activityVector : activitiesVector) {
			if (!activityVector.equalsIgnoreCase("")) {
				activity.addItem(activityVector);
			}
		}
	}

	public String getComboBoxActivity() {
		return activity.getSelectedItem().toString();
	}

	public void setEnableModifyActivity(boolean b) {
		if (b) {
			name.setEditable(b);
			name.setText("");
			annotation.setText("");
		} else {
			name.setEditable(b);
		}
	}

	public boolean getEnableModifyActivity() {
		return name.isEditable();
	}

	public void setComboBoxActivity(String infoActivity) {
		String[] activityVector = infoActivity.split("&");
		name.setText(activityVector[0]);
		annotation.setText(activityVector[1]);
		String[] schedule = activityVector[2].split("#");
		for (int i = 0; i < days.getItemCount(); i++) {
			if (schedule[0].equalsIgnoreCase(days.getItemAt(i).toString())) {
				days.setSelectedIndex(i);
			}
		}
	}
}