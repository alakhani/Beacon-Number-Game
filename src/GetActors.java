import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import com.hp.hpl.jena.util.FileManager;


public class GetActors 
{

	private ArrayList<String> actorNames=new ArrayList<String>();

	public ArrayList<String> getActors()
	{
		String fileNameOrUri = "C://Users//aamin//Documents//JenaWorkspace//BeaconNumberProject//project.nt";
		Model model = FileManager.get().loadModel(fileNameOrUri);;

		// list the statements in the Model
		StmtIterator iter = model.listStatements();

		Set<String> setA = new HashSet<String>();

		// print out the predicate, subject and object of each statement
		while (iter.hasNext()) 
		{
			Statement stmt      = iter.nextStatement();  // get next statement
			Resource  subject   = stmt.getSubject();     // get the subject
			Property  predicate = stmt.getPredicate();   // get the predicate
			RDFNode   object    = stmt.getObject();      // get the object

			System.out.print(subject.toString());
			setA.add(subject.toString());
			System.out.print(" " + predicate.toString() + " ");
			if (object instanceof Resource) 
			{
				System.out.print(object.toString());
				setA.add(object.toString());
			} 
			else 
			{
				// object is a literal
				System.out.print(" \"" + object.toString() + "\"");
				setA.add(object.toString());
			}

			System.out.println(" .");

		}

		//actorNames = new ArrayList<String>(setA);
		//ArrayList<String> newList=new ArrayList<String>();
		Iterator<String> iterr = setA.iterator();
		while (iterr.hasNext()) 
		{
			String x=iterr.next();
			System.out.println(x);
			String temp[]=x.split("/");
			System.out.println(temp.length);
			actorNames.add(temp[temp.length-1].toUpperCase());

		}

		return actorNames;

	}
}
