import java.io.File;
import java.io.FileOutputStream;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.RDFWriter;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.util.FileManager;


public class LinkActors 
{

	private String actor1;
	private String actor2;

	public LinkActors(String a1,String a2) 
	{
		// TODO Auto-generated constructor stub
		this.actor1=a1;
		this.actor2=a2;
	}

	public boolean addResource()
	{
		boolean success=false;
		String fileNameOrUri = "C://Users//aamin//Documents//JenaWorkspace//BeaconNumberProject//project.nt";
		String relationshipUri = "http://purl.org/vocab/relationship/";
		String professionalUri = "http://prfoessionalRelation/";
		Model model = FileManager.get().loadModel(fileNameOrUri);

		//check if a specific instance is contained in the model

		Property worksWith = model.createProperty(relationshipUri,"worksWith");
		Resource r1 = model.createResource(professionalUri+actor1);
		Resource r2 = model.createResource(professionalUri+actor2);
		Statement statement1 = model.createStatement(r1,worksWith,r2);

		if(model.contains(statement1))
		{
			System.out.println("Already exists");
		}
		else
		{
			model.add(statement1);
			try{
				File file=new File("C://Users//aamin//Documents//JenaWorkspace//BeaconNumberProject//project.nt");
				FileOutputStream f1=new FileOutputStream(file);
				RDFWriter d = model.getWriter("N-TRIPLE");
				d.write(model,f1,null);
			}catch(Exception e) {}
			success=true;
		}
		
		return success;

	}


}
