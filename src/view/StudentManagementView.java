package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Province;
import model.Student;
import model.StudentManagement;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.StudentManagementController;

import javax.swing.JRadioButtonMenuItem;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;
import java.awt.event.ActionEvent;

public class StudentManagementView extends JFrame {

	private JPanel contentPane;
	public StudentManagement model;
	private JTextField textFieldStudentId;
	private JTable table;
	public JTextField textFieldID;
	public JTextField textFieldName;
	public JTextField textFieldBirthday;
	public JTextField textFieldS1;
	public JTextField textFieldS2;
	public JTextField textFieldS3;
	public JComboBox comboBoxBP;
	public ButtonGroup btnSex;
	public JRadioButton rdbtnMale;
	public JRadioButton rdbtnFemale;
	private JComboBox comboBoxBirthplace;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentManagementView frame = new StudentManagementView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StudentManagementView() {
		this.model = new StudentManagement();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 750);

		ActionListener action = new StudentManagementController(this);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu menuFile = new JMenu("File");
		menuFile.setFont(new Font("Open Sans", Font.PLAIN, 18));
		menuBar.add(menuFile);

		JMenuItem menuOpen = new JMenuItem("Open");
		menuOpen.addActionListener(action);
		menuOpen.setFont(new Font("Open Sans", Font.PLAIN, 18));
		menuFile.add(menuOpen);

		JMenuItem menuSave = new JMenuItem("Save");
		menuSave.addActionListener(action);
		menuSave.setFont(new Font("Open Sans", Font.PLAIN, 18));
		menuFile.add(menuSave);

		JSeparator separator = new JSeparator();
		menuFile.add(separator);

		JMenuItem menuExit = new JMenuItem("Exit");
		menuExit.addActionListener(action);
		menuExit.setFont(new Font("Open Sans", Font.PLAIN, 18));
		menuFile.add(menuExit);

		JMenu menuAbout = new JMenu("About");
		menuAbout.setFont(new Font("Open Sans", Font.PLAIN, 18));
		menuBar.add(menuAbout);

		JMenuItem menuAboutMe = new JMenuItem("About Me");
		menuAboutMe.addActionListener(action);
		menuAboutMe.setFont(new Font("Open Sans", Font.PLAIN, 18));
		menuAbout.add(menuAboutMe);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel labelBirthplace = new JLabel("Birthplace");
		labelBirthplace.setFont(new Font("Tahoma", Font.PLAIN, 18));
		labelBirthplace.setHorizontalAlignment(SwingConstants.CENTER);
		labelBirthplace.setBounds(20, 10, 150, 50);
		contentPane.add(labelBirthplace);

		JLabel lblStudentId = new JLabel("Student ID");
		lblStudentId.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudentId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblStudentId.setBounds(416, 10, 124, 50);
		contentPane.add(lblStudentId);

		textFieldStudentId = new JTextField();
		textFieldStudentId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldStudentId.setColumns(10);
		textFieldStudentId.setBounds(550, 10, 200, 50);
		contentPane.add(textFieldStudentId);

		JButton btnCancelSearch = new JButton("Cancel");
		btnCancelSearch.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCancelSearch.setBounds(1110, 10, 150, 50);
		contentPane.add(btnCancelSearch);

		comboBoxBirthplace = new JComboBox();
		ArrayList<Province> provinceList = Province.getProvinceList();
		comboBoxBirthplace.addItem("");
		for (Province province : provinceList) {
			comboBoxBirthplace.addItem(province.getProvinceName());
		}
		comboBoxBirthplace.setBounds(180, 10, 200, 50);
		contentPane.add(comboBoxBirthplace);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 80, 1250, 2);
		contentPane.add(separator_1);

		JLabel lblStudentlist = new JLabel("Student List");
		lblStudentlist.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudentlist.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblStudentlist.setBounds(39, 92, 97, 22);
		contentPane.add(lblStudentlist);

		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Student ID", "Full Name", "Birthplace",
				"Birthday", "Sex", "Score 1", "Score 2", "Score 3" }));
		table.setRowHeight(25);
		
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 124, 1250, 195);
		contentPane.add(scrollPane);

		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(10, 329, 1250, 2);
		contentPane.add(separator_1_1);

		JLabel lblStudentIn = new JLabel("Student Information");
		lblStudentIn.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudentIn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblStudentIn.setBounds(10, 329, 200, 50);
		contentPane.add(lblStudentIn);

		JLabel labelID = new JLabel("Student ID");
		labelID.setHorizontalAlignment(SwingConstants.CENTER);
		labelID.setFont(new Font("Tahoma", Font.PLAIN, 18));
		labelID.setBounds(20, 389, 90, 22);
		contentPane.add(labelID);

		textFieldID = new JTextField();
		textFieldID.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldID.setColumns(10);
		textFieldID.setBounds(146, 389, 156, 28);
		contentPane.add(textFieldID);

		JLabel labelName = new JLabel("Student Name");
		labelName.setHorizontalAlignment(SwingConstants.CENTER);
		labelName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		labelName.setBounds(20, 427, 116, 22);
		contentPane.add(labelName);

		textFieldName = new JTextField();
		textFieldName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldName.setColumns(10);
		textFieldName.setBounds(146, 427, 156, 28);
		contentPane.add(textFieldName);

		JLabel labelBP = new JLabel("Birthplace");
		labelBP.setHorizontalAlignment(SwingConstants.CENTER);
		labelBP.setFont(new Font("Tahoma", Font.PLAIN, 18));
		labelBP.setBounds(20, 465, 81, 22);
		contentPane.add(labelBP);

		comboBoxBP = new JComboBox();
		comboBoxBP.addItem("");
		for (Province province : provinceList) {
			comboBoxBP.addItem(province.getProvinceName());
		}
		comboBoxBP.setBounds(146, 465, 156, 28);
		contentPane.add(comboBoxBP);

		JLabel labelBirthday = new JLabel("Birthday");
		labelBirthday.setHorizontalAlignment(SwingConstants.CENTER);
		labelBirthday.setFont(new Font("Tahoma", Font.PLAIN, 18));
		labelBirthday.setBounds(20, 503, 67, 22);
		contentPane.add(labelBirthday);

		textFieldBirthday = new JTextField();
		textFieldBirthday.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldBirthday.setColumns(10);
		textFieldBirthday.setBounds(146, 503, 156, 28);
		contentPane.add(textFieldBirthday);

		JLabel lblSex = new JLabel("Sex");
		lblSex.setHorizontalAlignment(SwingConstants.CENTER);
		lblSex.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSex.setBounds(363, 389, 29, 22);
		contentPane.add(lblSex);

		rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnMale.setBounds(467, 385, 63, 31);
		contentPane.add(rdbtnMale);

		rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnFemale.setBounds(540, 385, 83, 31);
		contentPane.add(rdbtnFemale);

		btnSex = new ButtonGroup();
		btnSex.add(rdbtnMale);
		btnSex.add(rdbtnFemale);

		textFieldS1 = new JTextField();
		textFieldS1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldS1.setColumns(10);
		textFieldS1.setBounds(467, 427, 156, 28);
		contentPane.add(textFieldS1);

		JLabel lblSubject = new JLabel("Subject 1");
		lblSubject.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubject.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSubject.setBounds(363, 427, 77, 22);
		contentPane.add(lblSubject);

		textFieldS2 = new JTextField();
		textFieldS2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldS2.setColumns(10);
		textFieldS2.setBounds(467, 465, 156, 28);
		contentPane.add(textFieldS2);

		JLabel lblSubject_1 = new JLabel("Subject 2");
		lblSubject_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubject_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSubject_1.setBounds(363, 465, 77, 22);
		contentPane.add(lblSubject_1);

		textFieldS3 = new JTextField();
		textFieldS3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldS3.setColumns(10);
		textFieldS3.setBounds(467, 503, 156, 28);
		contentPane.add(textFieldS3);

		JLabel lblSubject_2 = new JLabel("Subject 3");
		lblSubject_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubject_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSubject_2.setBounds(363, 503, 77, 22);
		contentPane.add(lblSubject_2);

		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setBounds(10, 557, 1250, 2);
		contentPane.add(separator_1_1_1);

		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(action);
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnInsert.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnInsert.setBounds(10, 569, 150, 50);
		contentPane.add(btnInsert);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(action);
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDelete.setBounds(180, 569, 150, 50);
		contentPane.add(btnDelete);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(action);
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnUpdate.setBounds(350, 569, 150, 50);
		contentPane.add(btnUpdate);

		JButton btnOK = new JButton("OK");
		btnOK.addActionListener(action);
		btnOK.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnOK.setBounds(520, 569, 150, 50);
		contentPane.add(btnOK);

		JButton btnCancel = new JButton("Clear");
		btnCancel.addActionListener(action);
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCancel.setBounds(690, 569, 150, 50);
		contentPane.add(btnCancel);

		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(action);
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSearch.setBounds(936, 10, 150, 50);
		contentPane.add(btnSearch);

		this.setVisible(true);
	}

	public void clearForm() {
		this.textFieldID.setText("");
		this.textFieldName.setText("");
		this.textFieldBirthday.setText("");
		this.textFieldID.setText("");
		this.textFieldS1.setText("");
		this.textFieldS2.setText("");
		this.textFieldS3.setText("");
		this.comboBoxBP.setSelectedIndex(-1);
		this.btnSex.clearSelection();
	}

	public void addStudentOnTable(Student student) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		model_table.addRow(new Object[] { student.getStudentId() + "", student.getStudentName(),
				student.getProvince().getProvinceName(),
				student.getBirthday().getDate() + "/" + (student.getBirthday().getMonth() + 1) + "/"
						+ (student.getBirthday().getYear() + 1900),
				(student.isSex() ? "Nam" : "Nữ"), student.getSubjectScore1() + "", student.getSubjectScore2() + "",
				student.getSubjectScore3() + "", });
	}

	public void addStudentOrUpdateStudent(Student student) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		if (!this.model.isExit(student)) {
			this.model.addStudent(student);
			this.addStudentOnTable(student);
		} else {
			this.model.updateStudent(student);
			int rowAmount = model_table.getRowCount();

			for (int i = 0; i < rowAmount; i++) {
				String id = model_table.getValueAt(i, 0) + "";

				if (id.equals(student.getStudentId() + "")) {
					model_table.setValueAt(student.getStudentId() + "", i, 0);
					model_table.setValueAt(student.getStudentName() + "", i, 1);
					model_table.setValueAt(student.getProvince().getProvinceName() + "", i, 2);
					model_table
							.setValueAt(student.getBirthday().getDate() + "/" + (student.getBirthday().getMonth() + 1)
									+ "/" + (student.getBirthday().getYear() + 1900) + "", i, 3);
					model_table.setValueAt(student.isSex() ? "Nam" : "Nữ" + "", i, 4);
					model_table.setValueAt(student.getSubjectScore1() + "", i, 5);
					model_table.setValueAt(student.getSubjectScore2() + "", i, 6);
					model_table.setValueAt(student.getSubjectScore3() + "", i, 7);
				}
			}
		}

	}

	public Student getStudent() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int iRow = table.getSelectedRow();

		// Get data
		int studentId = Integer.valueOf(model_table.getValueAt(iRow, 0) + "");
		String studentName = model_table.getValueAt(iRow, 1) + "";
		Province province = Province.getProvinceByName(model_table.getValueAt(iRow, 2) + "");
		String sBirthday = model_table.getValueAt(iRow, 3) + "";
		Date birthday = new Date(sBirthday);
		String sexText = model_table.getValueAt(iRow, 4) + "";

		boolean sex = sexText.equals("Nam");

		float subjectScore1 = Float.valueOf(model_table.getValueAt(iRow, 5) + "");
		float subjectScore2 = Float.valueOf(model_table.getValueAt(iRow, 6) + "");
		float subjectScore3 = Float.valueOf(model_table.getValueAt(iRow, 7) + "");

		Student student = new Student(studentId, studentName, province, birthday, sex, subjectScore1, subjectScore2,
				subjectScore3);
		return student;
	}

	public void showStudentInfoSelected() {
		Student student = getStudent();

		this.textFieldID.setText(student.getStudentId() + "");
		this.textFieldName.setText(student.getStudentName() + "");
		this.comboBoxBP.setSelectedItem(student.getProvince().getProvinceName());

		String sBirthday = student.getBirthday().getDate() + "/" + (student.getBirthday().getMonth() + 1) + "/"
				+ (student.getBirthday().getYear() + 1900);
		this.textFieldBirthday.setText(sBirthday + "");

		if (student.isSex()) {
			rdbtnMale.setSelected(true);
		} else {
			rdbtnFemale.setSelected(true);
		}

		this.textFieldS1.setText(student.getSubjectScore1() + "");
		this.textFieldS2.setText(student.getSubjectScore2() + "");
		this.textFieldS3.setText(student.getSubjectScore3() + "");
	}

	public void deleteStudent() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int iRow = table.getSelectedRow();
		int choice = JOptionPane.showConfirmDialog(this, "Are you sure delete the selected line");

		if (choice == JOptionPane.YES_OPTION) {
			Student student = getStudent();
			this.model.removeStudent(student);
			model_table.removeRow(iRow);
		}
	}

	public void addStudent() {
		// Get data
		int studentId = Integer.valueOf(this.textFieldID.getText());
		String studentName = this.textFieldName.getText();
		int birthplace = this.comboBoxBP.getSelectedIndex() - 1;
		Province province = Province.getProvinceById(birthplace);
		Date birthday = new Date(this.textFieldBirthday.getText());
		boolean sex = true;

		if (this.rdbtnMale.isSelected()) {
			sex = true;
		} else if (this.rdbtnFemale.isSelected()) {
			sex = false;
		}

		float subjectScore1 = Float.valueOf(this.textFieldS1.getText());
		float subjectScore2 = Float.valueOf(this.textFieldS2.getText());
		float subjectScore3 = Float.valueOf(this.textFieldS3.getText());

		Student student = new Student(studentId, studentName, province, birthday, sex, subjectScore1, subjectScore2,
				subjectScore3);

		this.addStudentOrUpdateStudent(student);
	}

	public void search() {
		// Goi ham huy tim kiem
		this.loadData();

		// Thuc hien tim kiem
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();

		String studentIdSearch = this.textFieldStudentId.getText();
		int birthplace = this.comboBoxBirthplace.getSelectedIndex() - 1;

		int iRow = table.getSelectedRow();

		int rowAmount = model_table.getRowCount();
		Set<Integer> studentIdDelete = new TreeSet<Integer>();

		if (birthplace >= 0) {
			Province province = Province.getProvinceById(birthplace);
			for (int i = 0; i < rowAmount; i++) {
				String provinceName = model_table.getValueAt(i, 2) + "";
				String id = model_table.getValueAt(i, 0) + "";
				if (!provinceName.equals(province.getProvinceName())) {
					studentIdDelete.add(Integer.valueOf(id));
				}
			}
		}

		if (studentIdSearch.length() > 0) {
			for (int i = 0; i < rowAmount; i++) {
				String id = model_table.getValueAt(i, 0) + "";
				if (!id.equals(studentIdSearch)) {
					studentIdDelete.add(Integer.valueOf(id));
				}
			}
		}

		for (Integer idDelete : studentIdDelete) {
			iRow = table.getSelectedRow();
			for (int i = 0; i < rowAmount; i++) {
				String idInTable = model_table.getValueAt(i, 0) + "";
				if (idInTable.equals(idDelete.toString())) {
					try {
						model_table.removeRow(i);
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				}
			}
		}
	}

	public void loadData() {
		while (true) {
			DefaultTableModel model_table = (DefaultTableModel) table.getModel();
			int iRow = model_table.getRowCount();
			if (iRow == 0) {
				break;
			} else {
				try {
					model_table.removeRow(0);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		for (Student student : this.model.getStudentList()) {
			this.addStudentOnTable(student);
		}
	}

	public void exitProgram() {
		int choice = JOptionPane.showConfirmDialog(this, "Do you want to exit the program?", "Exit",
				JOptionPane.YES_NO_OPTION);
		if (choice == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	private void save(String path) {
		try {
			this.model.setFileName(path);
			FileOutputStream fos = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for (Student ts : this.model.getStudentList()) {
				oos.writeObject(ts);
			}
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void saveFile() {
		if (this.model.getFileName().length() > 0) {
			save(this.model.getFileName());
		} else {
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showSaveDialog(this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				save(file.getAbsolutePath());
			}
		}
	}

	private void open(File file) {
		ArrayList<Student> ds = new ArrayList<Student>();
		try {
			this.model.setFileName(file.getAbsolutePath());
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Student ts = null;
			while ((ts = (Student) ois.readObject()) != null) {
				ds.add(ts);
			}
			ois.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		this.model.setStudentList(ds);
	}

	public void openFile() {
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			open(file);
			loadData();
		}
	}
}
