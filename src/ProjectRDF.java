import java.io.File;
import java.io.FileOutputStream;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.RDFWriter;
import com.hp.hpl.jena.rdf.model.Resource;


public class ProjectRDF 
{
	// Namespace declarations
		static final String professionalUri = "http://prfoessionalRelation/";
		static final String relationshipUri = "http://purl.org/vocab/relationship/";

		public static void main(String args[])
		{
			// Create an empty Model
			Model model = ModelFactory.createDefaultModel();

			//set namespace
			Resource NAMESPACE = model.createResource( relationshipUri );
			model.setNsPrefix( "rela", relationshipUri);

			// Create the types of Property we need to describe relationships in the model
			//Property wouldLikeToKnow = model.createProperty(relationshipUri,"wouldLikeToKnow");
			Property mentorOf = model.createProperty(relationshipUri,"mentorOf");
			Property worksWith = model.createProperty(relationshipUri,"worksWith");

			// Create resources representing the people in our model
			Resource adam = model.createResource(professionalUri+"adam");
			Resource beth = model.createResource(professionalUri+"beth");
			Resource chuck = model.createResource(professionalUri+"chuck");
			Resource dotty = model.createResource(professionalUri+"dotty");
			Resource edward = model.createResource(professionalUri+"edward");
			Resource frank = model.createResource(professionalUri+"frank");

			// Add properties to describing the relationships between them
			adam.addProperty(worksWith,beth);
			adam.addProperty(worksWith,edward);
			
			beth.addProperty(worksWith,chuck);
			beth.addProperty(worksWith,dotty);
			
			chuck.addProperty(worksWith,dotty);
			
			dotty.addProperty(worksWith,edward);
			
			frank.addProperty(worksWith,dotty);
			
			model.write(System.out, "N-TRIPLE");

			try{
				File file=new File("C:\\Jena\\Tutorial\\familytree\\project.nt");
				FileOutputStream f1=new FileOutputStream(file);
				RDFWriter d = model.getWriter("N-TRIPLE");
				d.write(model,f1,null);
			}catch(Exception e) {}

		}
}
