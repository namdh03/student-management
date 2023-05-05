package model;

import java.util.ArrayList;

public class StudentManagement {
	private ArrayList<Student> studentList;
	private String choice;
	private String fileName;

	public StudentManagement() {
		this.studentList = new ArrayList<Student>();
		this.choice = "";
		this.fileName = "";
	}

	public StudentManagement(ArrayList<Student> studentList) {
		this.studentList = studentList;
	}

	public ArrayList<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(ArrayList<Student> studentList) {
		this.studentList = studentList;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void addStudent(Student student) {
		this.studentList.add(student);
	}

	public Student removeStudent(Student student) {
		this.studentList.remove(student);
		return student;
	}

	public void updateStudent(Student student) {
		this.studentList.remove(student);
		this.studentList.add(student);
	}

	public String getChoice() {
		return choice;
	}

	public void setChoice(String choice) {
		this.choice = choice;
	}

	public boolean isExit(Student s) {
		for (Student student : studentList) {
			if (student.getStudentId() == s.getStudentId()) {
				return true;
			}
		}
		return false;
	}

}
