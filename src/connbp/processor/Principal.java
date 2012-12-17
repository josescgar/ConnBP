package connbp.processor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Map.Entry;

import connbp.exceptions.ConnBPSemanticException;
import connbp.grammar.Analex;
import connbp.grammar.Anasint;
import connbp.grammar.ConnectionMaker;
import connbp.grammar.PeopleFiller;
import connbp.grammar.QueryParser;
import connbp.helper.Inicializador;
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
		} catch (ConnBPSemanticException e){
			e.printException();
		}

	}
	

}
