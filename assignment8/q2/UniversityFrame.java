package assignment8.q2;

import assignment8.q2.controller.RegisterController;
import assignment8.q2.controller.StudentsManagerFileImpl;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class UniversityFrame extends BaseFrame {

	private JLabel rollLabel, nameLabel;
	private JTextField rollText;

	private JTextField nameText;
	private JButton add, modify, delete, find;

	private JTextArea notice;

	private JTable studentsTable;

	private StudentsModel model;

	private RegisterController registerController;

	public UniversityFrame(RegisterController registerController) {
		this.registerController = registerController;
	}

	@Override
	public void create() {
		rollLabel = new JLabel("Enter Roll Number : ");
		nameLabel = new JLabel("Enter Student Name : ");
		rollText = new JTextField(10);
		nameText = new JTextField(10);
		notice = new JTextArea();
		notice.setEditable(false);


		add = new JButton("Add");
		modify = new JButton("Modify");
		delete = new JButton("Delete");
		find = new JButton("Find");

		DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(new String[]{"Roll Number", "Name"});
		studentsTable = new JTable(tableModel);

		try {
			model = new StudentsModel(new StudentsManagerFileImpl(), tableModel);
		} catch (Exception e) {
			throw new RuntimeException("Error creating student table.", e);
		}

	}

	@Override
	public void add(Container con) {
		BorderLayout b = new BorderLayout();
		con.setLayout(b);
		addInputFields(con);
		addOptions(con);
		addNotice(con);
		con.add(new JScrollPane(studentsTable), "South");

	}

	@Override
	public void addListeners() {
		add.addActionListener(e -> registerController.addAction(e, this));
		modify.addActionListener(e -> registerController.addAction(e, this));
		delete.addActionListener(e -> registerController.addAction(e, this));
		find.addActionListener(e -> registerController.addAction(e, this));
	}

	public void warn(String message) {
		notice.setText(message);
	}

	public StudentsModel getStudentsModel() {
		return model;
	}

	public JTextField getRollText() {
		return rollText;
	}

	public JTextField getNameText() {
		return nameText;
	}

	private void addInputFields(Container con) {
		JPanel rollNumberPanel = new JPanel();
		rollNumberPanel.add(rollLabel);
		rollNumberPanel.add(rollText);
		JPanel namePanel = new JPanel();
		namePanel.add(nameLabel);
		namePanel.add(nameText);
		JPanel inputPanel = new JPanel();
		inputPanel.add(rollNumberPanel, 0);
		inputPanel.add(namePanel, 1);

		con.add(inputPanel, "North");
	}

	private void addOptions(Container con) {
		JPanel optionsPanel = new JPanel();
		optionsPanel.add(add, 0);
		optionsPanel.add(delete, 1);
		optionsPanel.add(modify, 2);
		optionsPanel.add(find, 3);
		con.add(optionsPanel, "Center");
	}

	private void addNotice(Container con) {
		con.add(notice, "After");
	}

	public static void main(String[] args) {
		new UniversityFrame(new RegisterController());

	}

}
