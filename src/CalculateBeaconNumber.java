import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.InfModel;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.reasoner.Reasoner;
import com.hp.hpl.jena.reasoner.rulesys.GenericRuleReasoner;
import com.hp.hpl.jena.reasoner.rulesys.Rule;
import com.hp.hpl.jena.util.FileManager;


public class CalculateBeaconNumber 
{

	private String source;
	private String destination;

	//the file that contains the triples
	private String fname = "C://Users//aamin//Documents//JenaWorkspace//BeaconNumberProject//project.nt";

	public Queue<BeacaonNode> queue = new LinkedList<BeacaonNode>();

	public HashMap<String, Boolean> checkDups=new HashMap<String, Boolean>();


	public CalculateBeaconNumber(String source,String destination) {
		this.source=source;
		this.destination=destination;
	}

	public boolean isConnected(InfModel inf, String source,String destination)
	{
		boolean connected=false;
		/*query String for getting the connection*/
		String queryString = "SELECT  ?x " +
				"WHERE { "+source+ " <http://purl.org/vocab/relationship/acquaintanceOf> "+ destination +". } ";

		System.out.println(queryString);


		Query query = QueryFactory.create(queryString);

		QueryExecution qe = QueryExecutionFactory.create(query, inf);
		ResultSet results = qe.execSelect();

		if(results.hasNext())
		{
			//System.out.println("Given node is connected");
			connected=true;
		}

		return connected;

	}

	public void getAdjacentNodes(InfModel inf,String source,int bNum)
	{
		System.out.println("*********************************************");
		String queryString = "SELECT  ?x " +
				"WHERE { "+ source+ "<http://purl.org/vocab/relationship/worksWith> ?x . } ";

		System.out.println(queryString);


		Query query = QueryFactory.create(queryString);

		QueryExecution qe = QueryExecutionFactory.create(query, inf);
		ResultSet results = qe.execSelect();

		while (results.hasNext()) {
			QuerySolution row= (QuerySolution)results.next();
			RDFNode thing= row.get("x");

			//check for duplicates
			if(!checkDups.containsKey(thing.toString()))
			{
				BeacaonNode bn=new BeacaonNode();
				bn.setLabel("<"+thing.toString()+">");
				bn.setBaconNum(bNum+1);
				queue.add(bn);
				checkDups.put(thing.toString(), true);
			}
			//System.out.println(thing.toString());
		}
	}

	public int getBeaconNumber(InfModel inf, String source,String destination)
	{
		int beaconNumber=0;
		//add the first one to the queue
		BeacaonNode bn=new BeacaonNode();
		bn.setLabel(source);
		bn.setBaconNum(0);
		queue.add(bn);

		while(!queue.isEmpty())
		{
			BeacaonNode b=queue.remove();
			if(b.getLabel().equals(destination))
			{
				System.out.println("Found with BeaconNumber "+b.getBaconNum());
				beaconNumber=b.getBaconNum();
				break;
			}
			else
			{
				getAdjacentNodes(inf, b.getLabel(),b.getBaconNum());
			}

		}

		return beaconNumber;
	}

	public int calculate()
	{
		//load the data from the model
		Model rawData = FileManager.get().loadModel("C://Users//aamin//Documents//JenaWorkspace//BeaconNumberProject//project.nt");

		//setting up rules
		String rules ="[r1: (?x http://purl.org/vocab/relationship/worksWith ?y)" +
				"->(?y http://purl.org/vocab/relationship/worksWith ?x)]"
				+"[r2: (?x http://purl.org/vocab/relationship/worksWith ?y)" +
				"->(?x http://purl.org/vocab/relationship/acquaintanceOf ?y)]" 
				+"[r3: (?x http://purl.org/vocab/relationship/worksWith ?y), (?y http://purl.org/vocab/relationship/worksWith ?z)" + 
				"-> (?x http://purl.org/vocab/relationship/acquaintanceOf ?z)]"+
				"[r4: (?x http://purl.org/vocab/relationship/acquaintanceOf ?y)"+ "(?y http://purl.org/vocab/relationship/worksWith ?z)"+
				"->(?x http://purl.org/vocab/relationship/acquaintanceOf ?z)]"
				;

		Reasoner reasoner = new GenericRuleReasoner(Rule.parseRules(rules));
		InfModel inf = ModelFactory.createInfModel(reasoner, rawData); 

		boolean connected=isConnected(inf,source,destination);
		int beaconNumber=-1;
		if(connected)
		{
			System.out.println("source and destination are connected");
			beaconNumber=getBeaconNumber(inf,source,destination);
		}
		else
		{
			System.out.println("source and destination not connected");
		}

		return beaconNumber;

	}
}
