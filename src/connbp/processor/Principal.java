package connbp.processor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;
import connbp.exceptions.*;
import connbp.grammar.Analex;
import connbp.grammar.Anasint;
import connbp.grammar.ConnectionMaker;
import connbp.grammar.PeopleFiller;
import connbp.grammar.QueryParser;
import connbp.helper.Inicializador;
import connbp.helper.Person;
import connbp.query.ConnectionsFor;
import connbp.query.LevelConnectionsFor;
import antlr.RecognitionException;
import antlr.Token;
import antlr.TokenStreamException;
import antlr.collections.AST;
import antlr.debug.misc.ASTFrame;


public class Principal {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			FileInputStream f = new FileInputStream("example.txt");
			Analex analex = new Analex(f);
			Anasint anasint = new Anasint(analex);
			anasint.setASTNodeClass("connbp.tree.PositionedAST");
			anasint.entrada();
			AST arbol = anasint.getAST();
			ASTFrame ventana = new ASTFrame("ConnBP - Tree",arbol);
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
			
//			Token n = analex.nextToken();
//			while(n.getType()!=Token.EOF_TYPE){
//				System.out.println(n);
//				n = analex.nextToken();
//			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
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
		ConnectionsFor cf = new ConnectionsFor();
		LevelConnectionsFor lcf = new LevelConnectionsFor();
		for(LinkedList<Object> e:queries){
			System.out.println("QUERY"+"\n"+"=====");
			if(((String)e.get(0)).equals("ConnectionsFor")){
				cf.setType((String)e.get(1));
				cf.setPerson((Person)e.get(2));
				cf.getConnectionsFor();
			} else if (((String)e.get(0)).equals("LevelConnectionsFor")){
				lcf.setLevel((Integer)e.get(1));
				lcf.setPerson((Person)e.get(2));
				lcf.getLevelConnectionsFor();
			}
			System.out.println();
		}
	}
	

}
