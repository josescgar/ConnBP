// $ANTLR : "peopleFiller.g" -> "PeopleFiller.java"$

	package connbp.grammar;
	import connbp.helper.Person;
	import java.util.HashMap;
	import connbp.exceptions.ConnBPSemanticException;
	import java.util.LinkedList;
	import java.util.Map.Entry;

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


public class PeopleFiller extends antlr.TreeParser       implements PeopleFillerTokenTypes
 {

	HashMap<String,String> aux = new HashMap<String,String>();
public PeopleFiller() {
	tokenNames = _tokenNames;
}

	public final void entrada(AST _t,
		HashMap<String,Person> people, HashMap<String,Boolean> attr
	) throws RecognitionException, ConnBPSemanticException {
		
		AST entrada_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		
		try {      // for error handling
			AST __t109 = _t;
			AST tmp1_AST_in = (AST)_t;
			match(_t,PROGRAMA);
			_t = _t.getFirstChild();
			decl_personas(_t,people,attr);
			_t = _retTree;
			_t = __t109;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	public final void decl_personas(AST _t,
		HashMap<String,Person> people, HashMap<String,Boolean> attr
	) throws RecognitionException, ConnBPSemanticException {
		
		AST decl_personas_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		
		try {      // for error handling
			AST __t111 = _t;
			AST tmp2_AST_in = (AST)_t;
			match(_t,PEOPLE);
			_t = _t.getFirstChild();
			{
			int _cnt113=0;
			_loop113:
			do {
				if (_t==null) _t=ASTNULL;
				if ((_t.getType()==PERSON)) {
					persona(_t,people,attr);
					_t = _retTree;
				}
				else {
					if ( _cnt113>=1 ) { break _loop113; } else {throw new NoViableAltException(_t);}
				}
				
				_cnt113++;
			} while (true);
			}
			_t = __t111;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	public final void persona(AST _t,
		HashMap<String,Person> people, HashMap<String,Boolean> attr
	) throws RecognitionException, ConnBPSemanticException {
		
		AST persona_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		AST p = null;
		
		try {      // for error handling
			AST __t115 = _t;
			p = _t==ASTNULL ? null :(AST)_t;
			match(_t,PERSON);
			_t = _t.getFirstChild();
			{
			int _cnt117=0;
			_loop117:
			do {
				if (_t==null) _t=ASTNULL;
				if ((_t.getType()==ATR_IDENT)) {
					atributo(_t,people,attr);
					_t = _retTree;
				}
				else {
					if ( _cnt117>=1 ) { break _loop117; } else {throw new NoViableAltException(_t);}
				}
				
				_cnt117++;
			} while (true);
			}
			_t = __t115;
			_t = _t.getNextSibling();
			
							for(Entry<String, Boolean> e : attr.entrySet()){
								if(e.getValue() && !aux.containsKey(e.getKey()))
									throw new ConnBPSemanticException("Required attribute not included in line "+p.getLine()+": "+e.getKey());
							}
							if(people.containsKey(aux.get("ID")))
								throw new ConnBPSemanticException("Duplicated Person ID: "+aux.get("ID"));
							people.put(aux.get("ID"),new Person(aux));
							aux.clear();
					
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	public final void atributo(AST _t,
		HashMap<String,Person> people, HashMap<String,Boolean> attr
	) throws RecognitionException, ConnBPSemanticException {
		
		AST atributo_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		AST i = null;
		AST v = null;
		
		try {      // for error handling
			AST __t119 = _t;
			i = _t==ASTNULL ? null :(AST)_t;
			match(_t,ATR_IDENT);
			_t = _t.getFirstChild();
			v = (AST)_t;
			match(_t,ATR_VALOR);
			_t = _t.getNextSibling();
			_t = __t119;
			_t = _t.getNextSibling();
			
						if(!attr.containsKey(i.getText())) 
							throw new ConnBPSemanticException("Invalid attribute in line "+i.getLine()+": "+i.getText());
						else {
							if(aux.containsKey(i.getText()))
								throw new ConnBPSemanticException("Duplicated attribute in line "+i.getLine()+": "+i.getText()+"="+v.getText());
							else
								aux.put(i.getText(),v.getText());
						}	
					
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
	
