

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/EditTeam")
public class EditTeam extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<h1>Update Team</h1>");
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		
		Team e=TeamDao.getTeamById(id);
		
		out.print("<form action='EditTeam2' method='post'>");
		out.print("<table>");
		out.print("<tr><td></td><td><input type='hidden' name='id' value="+e.getId()+"></td></tr>");
		out.print("<tr><td>Team Name:</td><td><input type='text' name='name' value='"+e.getTeamname()+"'/></td></tr>");
		out.print("<tr><td>Captain:</td><td><input type='text' name='captain' value='"+e.getCaptain()+"'/></td></tr>");
		out.print("<tr><td>Rank:</td><td><input type='text' name='rank' value='"+e.getRank()+"'/></td></tr>");
		out.print("</td></tr>");
		out.print("<tr><td colspan='2'><input type='submit' value='Edit &amp; Save '/></td></tr>");
		out.print("</table>");
		out.print("</form>");
		
		out.close();
	}
}
