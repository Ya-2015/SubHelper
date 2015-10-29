

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class StudentNameSearch
 */
@WebServlet("/StudentNameSearch")
public class StudentNameSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DatabaseCollection db;  
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentNameSearch() {
        super();
        
        db = new DatabaseCollection();
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");

		// Actual logic goes here.
	    PrintWriter out = response.getWriter();
	    
	    //get data from form
	    String studentName = request.getParameter("studentName");
	        
	    
	    //save data to database
		
	    
	    //get data from database
		ArrayList<Student> gd = db.getAssignmentByStudentName(studentName);
		
		printHtml(out, gd);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		// TODO Auto-generated method stub
	}
	private void printHtml(PrintWriter out, ArrayList<Student> gd){
		out.println("<!DOCTYPE html>");
		out.println("<html lang='en'>");
		out.println("<head>");
		out.println("<title>Sub Helper</title>");
		out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css\" integrity=\"sha512-dTfge/zgoMYpP7QbHy4gWMEGsbsdZeCXz7irItjcC3sPUFtf0kuFbDz/ixG7ArTxmDjLXDmezHubeNikyKGVyQ==\" crossorigin=\"anonymous\">");
		out.println("</head>");
		out.println("<body>");
		
		//display content in body
		out.println("<div class=\"container\">");
		out.println("<h2>All assignments by a Student</h2><br>");
		out.println("<table class=\"table table-striped\">");
		out.println("<thead>");
		out.println("<tr>");
		out.println("<th>Assignment Name</th>");
		out.println("<th>Assignment Type</th>");
		out.println("<th>Grade</th>");
		out.println("<th>Assignment Date</th>");
		out.println("</tr>");
		out.println("</thead>");
		out.println("<tbody>");
		//display customized data 
		for (Student g : gd){
			out.println("<tr>");
			out.println("<td>"+g.getAssignment()+"</td>");
			out.println("<td>"+g.getAssignmentType()+"</td>");
			out.println("<td>"+g.getGrade()+"</td>");
			out.println("<td>"+g.getAssignmentDate()+"</td>");
			out.println("</tr>");
		}
		//continue to complete body content
		out.println("</tbody>");
		out.println("</table>");
		out.println("<form action=\"SubGradeBook.html\">");
		out.println("<button type=\"submit\" class=\"btn btn-default\">Go Back</button>");
		out.println("</form>");
		out.println("</div>");
		
		
		//library links
		out.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js\"></script>");
		out.println("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js\" integrity=\"sha512-K1qjQ+NcF2TYO/eI3M6v8EiNYZfA95pQumfvcVrTHtwQVDG+aHRqLi/ETn2uB+1JqwYqVG3LIvdm9lj6imS/pQ==\" crossorigin=\"anonymous\"></script>");
		out.println("</body>");
		out.println("</html>");
	    
	}

}
