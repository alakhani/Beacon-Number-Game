

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProcessActorInputs
 */
@WebServlet("/ProcessActorInputs")
public class ProcessActorInputs extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProcessActorInputs() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String actor1= request.getParameter("actor1").toLowerCase();
		String actor2= request.getParameter("actor2").toLowerCase();

		PrintWriter out = response.getWriter();

		if(actor1.equals(actor2))
		{
			out.println ("Source and destination nodes same.");
			request.setAttribute("sample", "Both actors selected are the same");
			request.setAttribute("actor1",actor1);
			request.setAttribute("actor2",actor2);
	        request.getRequestDispatcher("/LoadData").forward(request, response);
			
		}
		else
		{
			//create the string of the form <http://prfoessionalRelation/adam>
			String prefix="<http://prfoessionalRelation/";

			String modActor1=prefix+actor1+">";
			String modActor2=prefix+actor2+">";
			out.println (modActor1);
			out.println (modActor2);

			CalculateBeaconNumber cbn=new CalculateBeaconNumber(modActor1, modActor2);
			int beaconNumber=cbn.calculate();
			if(beaconNumber!=-1)
			{
				out.println(actor1.toUpperCase()+" and "+actor2.toUpperCase()+" are connected with beacon number "+beaconNumber);
				request.setAttribute("sample", actor1.toUpperCase()+" and "+actor2.toUpperCase()+" are connected with beacon number "+beaconNumber);
				request.setAttribute("actor1",actor1);
				request.setAttribute("actor2",actor2);
		        request.getRequestDispatcher("/LoadData").forward(request, response);
			}
			else
			{
				out.println(actor1+" and "+ actor2+ " not connected");
				request.setAttribute("sample", actor1.toUpperCase()+" and "+ actor2.toUpperCase()+ " not connected");
				request.setAttribute("actor1",actor1);
				request.setAttribute("actor2",actor2);
		        request.getRequestDispatcher("/LoadData").forward(request, response);
			}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
