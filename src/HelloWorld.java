

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorld
 */
@WebServlet("/HelloWorld")
public class HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloWorld() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// reading the user input
	    //String color= request.getParameter("color");    
	    //PrintWriter out = response.getWriter();
	    //out.println (color);
		
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition",
		"attachment;filename=projet.nt");
		
		File file = new File("C://Users//aamin//Documents//JenaWorkspace//BeaconNumberProject//project.nt");
		FileInputStream fileIn = new FileInputStream(file);
		ServletOutputStream out = response.getOutputStream();
		 
		byte[] outputByte = new byte[(int)file.length()];
		//copy binary contect to output stream
		while(fileIn.read(outputByte, 0, outputByte.length) != -1)
		{
			out.write(outputByte, 0, outputByte.length);
		}
		fileIn.close();
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
