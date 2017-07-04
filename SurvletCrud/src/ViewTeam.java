

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ViewTeam")
public class ViewTeam extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<a href='Index.html'>Add New Team</a>");
		out.println("<h1>Teams List</h1>");
		
		List<Team> list=TeamDao.getAllTeams();
		
		out.print("<table border='1' width='100%'");
		out.print("<tr><th>Id</th><th>TeamName</th><th>Captain</th><th>Rank</th><th>Edit</th><th>Delete</th></tr>");
		for(Team e:list){
			out.print("<tr><td>"+e.getId()+"</td><td>"+e.getTeamname()+"</td><td>"+e.getCaptain()+"</td><td>"+e.getRank()+"</td><td><a href='EditTeam?id="+e.getId()+"'>edit</a></td><td><a href='DeleteTeam?id="+e.getId()+"'>delete</a></td></tr>");
		}
		out.print("</table>");
		
		out.close();
	}
}
