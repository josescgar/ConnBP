package connbp.processor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import javax.swing.JFrame;
import connbp.exceptions.*;
import connbp.grammar.*;
import connbp.helper.*;
import connbp.query.*;
import antlr.RecognitionException;
import antlr.TokenStreamException;
import antlr.collections.AST;
import antlr.debug.misc.ASTFrame;


public class Principal {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if(args.length == 0){
			System.err.println("You must specify an input file");
			return;
		}
		try {
			FileInputStream f = new FileInputStream(args[0]);
			Analex analex = new Analex(f);
			Anasint anasint = new Anasint(analex);
			anasint.setASTNodeClass("connbp.tree.PositionedAST");
			anasint.entrada();
			AST arbol = anasint.getAST();
			ASTFrame ventana = new ASTFrame("ConnBP - Tree",arbol);
			ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			ventana.setVisible(true);
			Inicializador ini=Inicializador.getInstance();
			
			PeopleFiller pf = new PeopleFiller();
			pf.entrada(arbol);
				
			ConnectionMaker cm = new ConnectionMaker();
			cm.entrada(arbol);
			
			QueryParser qp = new QueryParser();
			qp.entrada(arbol);
			
			processQueries(ini.getQueries());
			
			System.out.println();
			
		} catch (FileNotFoundException e) {
			System.err.println("File \""+args[0]+"\" not found");
		} catch (RecognitionException e) {
			e.printStackTrace();
		} catch (TokenStreamException e) {
			e.printStackTrace();
		} catch (ConnBPPeopleException e){
			e.printException();
		} catch (ConnBPConnectionException e) {
			e.printException();
		} catch (ConnBPQuerySemanticException e) {
			e.printException();
		}

	}
	
	private static void processQueries(LinkedList<LinkedList<Object>> queries){		
		for(LinkedList<Object> e:queries){
			System.out.println("QUERY"+"\n"+"=====");
			if(((String)e.get(0)).equals("ConnectionsFor")){
				ConnectionsFor cf = new ConnectionsFor();
				cf.setType((String)e.get(1));
				cf.setPerson((Person)e.get(2));
				cf.getConnectionsFor();
			} else if (((String)e.get(0)).equals("LevelConnectionsFor")){
				LevelConnectionsFor lcf = new LevelConnectionsFor();
				lcf.setLevel((Integer)e.get(1));
				lcf.setPerson((Person)e.get(2));
				lcf.getLevelConnectionsFor();
			} else if (((String)e.get(0)).equals("RelatedTo")){
				RelatedTo rt = new RelatedTo();
				rt.setPerson1((Person)e.get(1));
				rt.setPerson2((Person)e.get(2));
				rt.isRelatedTo();
			} else if (((String)e.get(0)).equals("Graph")){
				Graph g = new Graph();
				g.drawGraph();
			}
			System.out.println();
		}
	}
}
