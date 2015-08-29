

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddResourceServlet
 */
@WebServlet("/AddResourceServlet")
public class AddResourceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddResourceServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		String actor1= request.getParameter("actor1");
		String actor2= request.getParameter("actor2");

		PrintWriter out = response.getWriter();

		out.println (actor1);
		out.println (actor2);
		
		LinkActors la=new LinkActors(actor1.toLowerCase(), actor2.toLowerCase());
		boolean success=la.addResource();
		if(success)
		{
			out.write(actor1+ "linked with "+actor2);
			request.setAttribute("sample", actor1.toUpperCase()+ " linked with "+actor2.toUpperCase());
	        request.getRequestDispatcher("/AddResource.jsp").forward(request, response);
			
		}
		else
		{
			out.write("The linkage between "+actor1+" and "+actor2+" already exists.");
			request.setAttribute("sample", "The linkage between "+actor1.toUpperCase()+" and "+actor2.toUpperCase()+" already exists.");
	        request.getRequestDispatcher("/AddResource.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
