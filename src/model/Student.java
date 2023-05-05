package model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Student implements Serializable {
	private int studentId;
	private String studentName;
	private Province province;
	private Date birthday;
	private boolean sex;
	private float subjectScore1, subjectScore2, subjectScore3;

	public Student() {
	}

	public Student(int studentId, String studentName, Province province, Date birthday, boolean sex,
			float subjectScore1, float subjectScore2, float subjectScore3) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.province = province;
		this.birthday = birthday;
		this.sex = sex;
		this.subjectScore1 = subjectScore1;
		this.subjectScore2 = subjectScore2;
		this.subjectScore3 = subjectScore3;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Province getProvince() {
		return province;
	}

	public void setProvince(Province province) {
		this.province = province;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public float getSubjectScore1() {
		return subjectScore1;
	}

	public void setSubjectScore1(float subjectScore1) {
		this.subjectScore1 = subjectScore1;
	}

	public float getSubjectScore2() {
		return subjectScore2;
	}

	public void setSubjectScore2(float subjectScore2) {
		this.subjectScore2 = subjectScore2;
	}

	public float getSubjectScore3() {
		return subjectScore3;
	}

	public void setSubjectScore3(float subjectScore3) {
		this.subjectScore3 = subjectScore3;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", province=" + province
				+ ", birthday=" + birthday + ", sex=" + sex + ", subjectScore1=" + subjectScore1 + ", subjectScore2="
				+ subjectScore2 + ", subjectScore3=" + subjectScore3 + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(birthday, province, sex, studentId, studentName, subjectScore1, subjectScore2,
				subjectScore3);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(birthday, other.birthday) && Objects.equals(province, other.province) && sex == other.sex
				&& studentId == other.studentId && Objects.equals(studentName, other.studentName)
				&& Float.floatToIntBits(subjectScore1) == Float.floatToIntBits(other.subjectScore1)
				&& Float.floatToIntBits(subjectScore2) == Float.floatToIntBits(other.subjectScore2)
				&& Float.floatToIntBits(subjectScore3) == Float.floatToIntBits(other.subjectScore3);
	}

}
