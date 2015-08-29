

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.RDFWriter;
import com.hp.hpl.jena.util.FileManager;

/**
 * Servlet implementation class DownloadXMLFile
 */
@WebServlet("/DownloadXMLFile")
public class DownloadXMLFile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DownloadXMLFile() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//load the data from the model
		Model rawData = FileManager.get().loadModel("C://Users//aamin//Documents//JenaWorkspace//BeaconNumberProject//project.nt");

		rawData.write(System.out, "RDF/XML-ABBREV");

		try{
			File file=new File("Actors.rdf");
			FileOutputStream f1=new FileOutputStream(file);
			RDFWriter d = rawData.getWriter("RDF/XML-ABBREV");
			d.write(rawData,f1,null);
		}catch(Exception e) {}
		
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition",
		"attachment;filename=ActorsRDF.rdf");
		
		File file = new File("Actors.rdf");
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
