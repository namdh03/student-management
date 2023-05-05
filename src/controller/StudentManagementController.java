package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;

import model.Province;
import model.Student;
import view.StudentManagementView;

public class StudentManagementController implements ActionListener {
	private StudentManagementView view;

	public StudentManagementController(StudentManagementView view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String aC = e.getActionCommand();
//		JOptionPane.showMessageDialog(view, "You just clicked: " + aC);

		if (aC.equals("Insert")) {
			this.view.clearForm();
			this.view.model.setChoice("Insert");
		} else if (aC.equals("OK")) {
			try {
				this.view.addStudent();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} else if (aC.equals("Update")) {
			this.view.showStudentInfoSelected();
		} else if (aC.equals("Delete")) {
			this.view.deleteStudent();
		} else if (aC.equals("Clear")) {
			this.view.clearForm();
		} else if (aC.equals("Cancel")) {
			this.view.loadData();
		} else if (aC.equals("Search")) {
			this.view.search();
		} else if (aC.equals("About Me")) {
			JOptionPane.showMessageDialog(view, "I guess I should take it as a sign\n"
					+ "(Oh why, oh why, oh why, oh why?)\n"
					+ "I'm feelin' lonely (Lonely)\n"
					+ "Oh, I wish I'd find a lover that could hold me (Hold me)\n" 
					+ "Now I'm crying in my room\n"
					+ "So skeptical of love (Say what you say, but I want it more)\n"
					+ "But still, I want it more, more, more\n");
		} else if (aC.equals("Exit")) {
			this.view.exitProgram();
		} else if (aC.equals("Save")) {
			this.view.saveFile();
		} else if (aC.equals("Open")) {
			this.view.openFile();
		}
	}

}
