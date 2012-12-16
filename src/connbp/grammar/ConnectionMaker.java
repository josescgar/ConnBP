// $ANTLR : "connectionMaker.g" -> "ConnectionMaker.java"$

	package connbp.grammar;
	import connbp.exceptions.ConnBPSemanticException;
	import java.util.HashMap;
	import connbp.helper.*;
	import java.util.LinkedList;

import antlr.TreeParser;
import antlr.Token;
import antlr.collections.AST;
import antlr.RecognitionException;
import antlr.ANTLRException;
import antlr.NoViableAltException;
import antlr.MismatchedTokenException;
import antlr.SemanticException;
import antlr.collections.impl.BitSet;
import antlr.ASTPair;
import antlr.collections.impl.ASTArray;


public class ConnectionMaker extends antlr.TreeParser       implements ConnectionMakerTokenTypes
 {

	HashMap<String,String> aux = new HashMap<String,String>();
public ConnectionMaker() {
	tokenNames = _tokenNames;
}

	public final void entrada(AST _t) throws RecognitionException, ConnBPSemanticException {
		
		AST entrada_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		
		try {      // for error handling
			AST __t502 = _t;
			AST tmp1_AST_in = (AST)_t;
			match(_t,PROGRAMA);
			_t = _t.getFirstChild();
			AST tmp2_AST_in = (AST)_t;
			if ( _t==null ) throw new MismatchedTokenException();
			_t = _t.getNextSibling();
			decl_conexiones(_t);
			_t = _retTree;
			_t = __t502;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	public final void decl_conexiones(AST _t) throws RecognitionException, ConnBPSemanticException {
		
		AST decl_conexiones_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		
		try {      // for error handling
			AST __t504 = _t;
			AST tmp3_AST_in = (AST)_t;
			match(_t,CONNECTIONS);
			_t = _t.getFirstChild();
			{
			_loop506:
			do {
				if (_t==null) _t=ASTNULL;
				if ((_t.getType()==NEXUS)) {
					conexion(_t);
					_t = _retTree;
				}
				else {
					break _loop506;
				}
				
			} while (true);
			}
			_t = __t504;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	public final void conexion(AST _t) throws RecognitionException, ConnBPSemanticException {
		
		AST conexion_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		AST n = null;
		
		try {      // for error handling
			AST __t508 = _t;
			n = _t==ASTNULL ? null :(AST)_t;
			match(_t,NEXUS);
			_t = _t.getFirstChild();
			{
			int _cnt510=0;
			_loop510:
			do {
				if (_t==null) _t=ASTNULL;
				if ((_t.getType()==ATR_IDENT)) {
					atributo(_t);
					_t = _retTree;
				}
				else {
					if ( _cnt510>=1 ) { break _loop510; } else {throw new NoViableAltException(_t);}
				}
				
				_cnt510++;
			} while (true);
			}
			_t = __t508;
			_t = _t.getNextSibling();
			
					if(!aux.keySet().containsAll(Inicializador.getInstance().getValidAttrConnections()))
						throw new ConnBPSemanticException("Required connection attribute not included in line "+n.getLine());
					Inicializador.getInstance().getConnections().add(new Connection(Inicializador.getInstance().getPeople().get(aux.get("ID1")),Inicializador.getInstance().getPeople().get(aux.get("ID2")),aux.get("Type")));
					aux.clear();
				
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	public final void atributo(AST _t) throws RecognitionException, ConnBPSemanticException {
		
		AST atributo_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		AST i = null;
		AST a = null;
		
		try {      // for error handling
			AST __t512 = _t;
			i = _t==ASTNULL ? null :(AST)_t;
			match(_t,ATR_IDENT);
			_t = _t.getFirstChild();
			a = (AST)_t;
			match(_t,ATR_VALOR);
			_t = _t.getNextSibling();
			_t = __t512;
			_t = _t.getNextSibling();
			
					if(!Inicializador.getInstance().getValidAttrConnections().contains(i.getText()))
						throw new ConnBPSemanticException("Invalid connection attribute in line "+i.getLine()+": "+i.getText());
					if(i.getText().equals("Type") && !Inicializador.getInstance().getValidConnectionTypes().contains(a.getText()))
						throw new ConnBPSemanticException("Invalid connection type in line "+i.getLine()+": "+a.getText());
					if((i.getText().equals("ID1") | i.getText().equals("ID2")) && !Inicializador.getInstance().getPeople().containsKey(a.getText()))
						throw new ConnBPSemanticException("The person with ID "+a.getText()+" in line "+i.getLine()+" doesn't exists");
					aux.put(i.getText(),a.getText());
				
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	
	public static final String[] _tokenNames = {
		"<0>",
		"EOF",
		"<2>",
		"NULL_TREE_LOOKAHEAD",
		"PROGRAMA",
		"PEOPLE",
		"\"{\"",
		"\"}\"",
		"PERSON",
		"\",\"",
		"ATR_IDENT",
		"\"[\"",
		"ATR_VALOR",
		"\"]\"",
		"CONNECTIONS",
		"NEXUS",
		"QUERIES",
		"\"?\"",
		"RELATEDTO",
		"CONNECTIONSFOR",
		"LEVELCONNECTIONSFOR",
		"GRAPH"
	};
	
	}
	
