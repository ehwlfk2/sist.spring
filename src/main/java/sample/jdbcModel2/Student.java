package sample.jdbcModel2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Student {
	private int StudentNum;
	private String name;
	private String email;

	public Student(int StudentNum, String name, String email) {
		this.StudentNum = StudentNum;
		this.name = name;
		this.email = email;
	}

	public Student getSingleStudent(int studentNum) throws SQLException {
		Student student;

		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "C##APPLE", "1234");
				PreparedStatement pstmt = conn.prepareStatement("Select * from Student where name = ?")) {
			conn.setAutoCommit(false);
			pstmt.setInt(1, studentNum);
			
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) { // data가 있을 때.
				student = new Student(rs.getInt("studentNum"), rs.getString("name"), rs.getString("email"));
				conn.commit();
				return student;
			} else
				return null; // data가 없을 때.
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public String toString() {
		return "Student [StudentNum=" + StudentNum + ", name=" + name + ", email=" + email + "]";
	}
}
