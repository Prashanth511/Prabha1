

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/SaveTeam")
public class SaveTeam extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		String captain=request.getParameter("captain");
		String rank=request.getParameter("rank");
		
		Team e=new Team();
		
		e.setId(id);
		e.setTeamname(name);
		e.setCaptain(captain);
		e.setRank(rank);
		
		int status=TeamDao.save(e);
		if(status>0)
		{
			out.print("<p>Record saved successfully!</p>");
			request.getRequestDispatcher("Index.html").include(request, response);
		}
		else{
			out.println("Sorry! unable to save record");
		}
		
		out.close();
	}

}
