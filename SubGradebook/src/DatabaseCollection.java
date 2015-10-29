

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

public class DatabaseCollection {
	
	String url = "jdbc:oracle:thin:system/password@localhost"; 
	Properties props = new Properties();
	
	//make sure to have the following steps done
	//1 copy ojdbc6.jar to webcontent/web-inf/lib
	//2 add ojdbc6.jar to build path - libraries / add external jar
	//3 Class.forName ("oracle.jdbc.driver.OracleDriver")
	static{
	    try {
	        Class.forName ("oracle.jdbc.driver.OracleDriver");
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    }
	}
	
	public DatabaseCollection() {
		props.setProperty("user", "testuserdb");
        props.setProperty("password", "password");
	}
	
	public ArrayList<Student> getAssignmentByStudentName(String name){
		ArrayList<Student> student = new ArrayList<Student>(); 
		
		try{
			Connection conn = DriverManager.getConnection(url,props);
			
			String sql ="select s.ASSIGNMENT_NAME,s.ASSIGNMENT_DATE,s.GRADE,s.STUDENT_NAME,st.DESCRIPTION "+
			"from student s,assignment_type st "+
					"where s.assignment_type = st.assignment_type AND s.student_name= ?";
	
	        //creating PreparedStatement object to execute query
	        PreparedStatement preStatement = conn.prepareStatement(sql);
	        preStatement.setString(1, name);
	    
	        ResultSet result = preStatement.executeQuery();
	      
	        while(result.next()){
	        	Student grd = new Student();
	        	grd.setAssignment(result.getString("assignment_name"));
	        	grd.setAssignmentDate(result.getDate("assignment_date"));
	        	grd.setAssignmentType(result.getString("description"));
	        	grd.setGrade(result.getInt("grade"));
	        	grd.setStudentName(result.getString("student_name"));
	        	
	        	
	        	
	        	student.add(grd);
	        }
	        
	        conn.close();
		}catch(Exception e){
			student = null;
			e.printStackTrace();
		}
		
		return student;
		
	}
	public ArrayList<Student> getAssignmentByType(String type){
		ArrayList<Student> student = new ArrayList<Student>(); 
		
		try{
			Connection conn = DriverManager.getConnection(url,props);
			
			String sql ="select st.DESCRIPTION,s.ASSIGNMENT_NAME,s.ASSIGNMENT_DATE,s.GRADE,s.STUDENT_NAME "+
			"from student s,assignment_type st "+
					"where s.assignment_type = st.assignment_type AND st.description= ?";
	
	        //creating PreparedStatement object to execute query
	        PreparedStatement preStatement = conn.prepareStatement(sql);
	        preStatement.setString(1, type);
	    
	        ResultSet result = preStatement.executeQuery();
	      
	        while(result.next()){
	        	Student grd = new Student();
	        	grd.setAssignment(result.getString("assignment_name"));
	        	grd.setAssignmentDate(result.getDate("assignment_date"));
	        	grd.setAssignmentType(result.getString("description"));
	        	grd.setGrade(result.getInt("grade"));
	        	grd.setStudentName(result.getString("student_name"));
	        	
	        	
	        	
	        	student.add(grd);
	        }
	        
	        conn.close();
		}catch(Exception e){
			student = null;
			e.printStackTrace();
		}
		
		return student;
		
	}
		public ArrayList<Student> getTypeStudent(String type,String st){
			ArrayList<Student> student = new ArrayList<Student>(); 
			
			try{
				Connection conn = DriverManager.getConnection(url,props);
				
				String sql ="select s.ASSIGNMENT_NAME,s.ASSIGNMENT_DATE,s.GRADE,s.STUDENT_NAME,st.DESCRIPTION "+
				"from student s,assignment_type st "+
						"where s.assignment_type = st.assignment_type AND s.student_name= ? AND "
						+ "st.description=?";
		//System.out.println(sql);
		        //creating PreparedStatement object to execute query
		        PreparedStatement preStatement = conn.prepareStatement(sql);
		        preStatement.setString(1,st);
		        preStatement.setString(2,type);
		        
		    
		        ResultSet result = preStatement.executeQuery();
		      
		        while(result.next()){
		        	Student grd = new Student();
		        	grd.setAssignment(result.getString("assignment_name"));
		        	grd.setAssignmentDate(result.getDate("assignment_date"));
		        	grd.setAssignmentType(result.getString("description"));
		        	grd.setGrade(result.getInt("grade"));
		        	grd.setStudentName(result.getString("student_name"));
		        	
		        	
		        	
		        	student.add(grd);
		        }
		        
		        conn.close();
			}catch(Exception e){
				student = null;
				e.printStackTrace();
			}
			
			return student;
			
		}
	
/*	public double getAverage(){
		double average = 0;
		
		try{
			Connection conn = DriverManager.getConnection(url,props);
			
			String sql ="select avg(grade) from gradebook";
	
	        //creating PreparedStatement object to execute query
	        PreparedStatement preStatement = conn.prepareStatement(sql);
	    
	        ResultSet result = preStatement.executeQuery();
	      
	        while(result.next()){
	        	average = result.getDouble(1);
	        	break;
	        }
	        
	        conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return average;
		
	}
	
*/	

	
}

