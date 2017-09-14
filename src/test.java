

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.util.FileManager;

public class test {
	
	public static void testExpert() {
		  String ruleFile = "file:./expert/Expert.rules";
		  String ontoFile = "file:./expert/Expert.owl";
		
		IReasoner famRea = ReasonerFactory.createFamilyReasoner();
		
		Model m = FileManager.get().loadModel("file:./expert/Expert.owl");
		String NS = "http://www.owl-ontologies.com/Expert.owl#";
		Resource Jim = m.getResource(NS + "ZhaoHongJie");
		Resource John = m.getResource(NS + "Computer_Applied_Technology");
		
		famRea.getInfModel(ruleFile, ontoFile);
		famRea.printInferResult(Jim, John);
	}
	
//	public static void testFamily() {
//		String ruleFile = "file:./family/family.rules";
//		String ontoFile = "file:./family/family.owl";
//		
//		IReasoner famRea = ReasonerFactory.createFamilyReasoner();
//		
//		Model m = FileManager.get().loadModel("file:./family/family.owl");
//		String NS = "http://www.semanticweb.org/ontologies/2010/0/family.owl#";
//		Resource Jim = m.getResource(NS + "Jim");
//		Resource John = m.getResource(NS + "John");
//		
//		/*
//		Resource Lucy = m.getResource(NS + "Lucy");
//		Resource Kate = m.getResource(NS + "Kate");
//		Resource Sam = m.getResource(NS + "Sam");
//		Resource James = m.createResource(NS + "James");
//		Resource Anna = m.getResource(NS + "Anna");
//		Resource Holly = m.createResource(NS + "Holly");
//		*/
//		
//		famRea.getInfModel(ruleFile, ontoFile);
//		famRea.printInferResult(Jim, John);
//	}
	
	public static void testQuery() {
        String ruleFile = "file:./expert/Expert.rules";  
        String ontoFile = "file:./expert/Expert.owl"; 
		//  String ruleFile = "file:./E:/研究生课程作业/本体语义论文/Jena本体推理/expert/Expert.rules";
	//	  String ontoFile = "file:./E:/研究生课程作业/本体语义论文/Jena本体推理/expert/Expert.owl";
	//	String ruleFile = "file:\\"+"E://研究生课程作业//本体语义论文//Jena本体推理//expert//Expert.rules";
		//String ontoFile = "file:\\"+"E://研究生课程作业//本体语义论文//Jena本体推理//expert//Expert.owl";
        String queryString = "PREFIX Expert:<http://www.owl-ontologies.com/Expert.owl#> " +
    	    	"SELECT ?expert ?subject " +
    	    	"WHERE {?expert Expert:familiar_with ?subject} ";
		
		IReasoner famRea = ReasonerFactory.createFamilyReasoner();
		famRea.getInfModel(ruleFile, ontoFile);
		famRea.searchOnto(queryString);
	}

	public static void main(String[] args) {
		//testQuery();
		testExpert();
		testQuery();
		//testFamily();
	}
	
}
