// $ANTLR : "anasint.g" -> "Anasint.java"$

	package connbp.grammar;

import antlr.TokenBuffer;
import antlr.TokenStreamException;
import antlr.TokenStreamIOException;
import antlr.ANTLRException;
import antlr.LLkParser;
import antlr.Token;
import antlr.TokenStream;
import antlr.RecognitionException;
import antlr.NoViableAltException;
import antlr.MismatchedTokenException;
import antlr.SemanticException;
import antlr.ParserSharedInputState;
import antlr.collections.impl.BitSet;
import antlr.collections.AST;
import java.util.Hashtable;
import antlr.ASTFactory;
import antlr.ASTPair;
import antlr.collections.impl.ASTArray;

public class Anasint extends antlr.LLkParser       implements AnasintTokenTypes
 {

protected Anasint(TokenBuffer tokenBuf, int k) {
  super(tokenBuf,k);
  tokenNames = _tokenNames;
  buildTokenTypeASTClassMap();
  astFactory = new ASTFactory(getTokenTypeToASTClassMap());
}

public Anasint(TokenBuffer tokenBuf) {
  this(tokenBuf,4);
}

protected Anasint(TokenStream lexer, int k) {
  super(lexer,k);
  tokenNames = _tokenNames;
  buildTokenTypeASTClassMap();
  astFactory = new ASTFactory(getTokenTypeToASTClassMap());
}

public Anasint(TokenStream lexer) {
  this(lexer,4);
}

public Anasint(ParserSharedInputState state) {
  super(state,4);
  tokenNames = _tokenNames;
  buildTokenTypeASTClassMap();
  astFactory = new ASTFactory(getTokenTypeToASTClassMap());
}

	public final void entrada() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST entrada_AST = null;
		
		try {      // for error handling
			programa();
			astFactory.addASTChild(currentAST, returnAST);
			match(Token.EOF_TYPE);
			entrada_AST = (AST)currentAST.root;
			entrada_AST=(AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(PROGRAMA,"PROGRAMA")).add(entrada_AST));
			currentAST.root = entrada_AST;
			currentAST.child = entrada_AST!=null &&entrada_AST.getFirstChild()!=null ?
				entrada_AST.getFirstChild() : entrada_AST;
			currentAST.advanceChildToEnd();
			entrada_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_0);
		}
		returnAST = entrada_AST;
	}
	
	public final void programa() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST programa_AST = null;
		
		try {      // for error handling
			decl_personas();
			astFactory.addASTChild(currentAST, returnAST);
			decl_conexiones();
			astFactory.addASTChild(currentAST, returnAST);
			decl_consultas();
			astFactory.addASTChild(currentAST, returnAST);
			programa_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_0);
		}
		returnAST = programa_AST;
	}
	
	public final void decl_personas() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST decl_personas_AST = null;
		
		try {      // for error handling
			AST tmp2_AST = null;
			tmp2_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp2_AST);
			match(PEOPLE);
			match(6);
			{
			int _cnt124=0;
			_loop124:
			do {
				if ((LA(1)==PERSON)) {
					persona();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					if ( _cnt124>=1 ) { break _loop124; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				
				_cnt124++;
			} while (true);
			}
			match(7);
			decl_personas_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_1);
		}
		returnAST = decl_personas_AST;
	}
	
	public final void decl_conexiones() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST decl_conexiones_AST = null;
		
		try {      // for error handling
			AST tmp5_AST = null;
			tmp5_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp5_AST);
			match(CONNECTIONS);
			match(6);
			{
			_loop131:
			do {
				if ((LA(1)==NEXUS)) {
					conexion();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					break _loop131;
				}
				
			} while (true);
			}
			match(7);
			decl_conexiones_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_2);
		}
		returnAST = decl_conexiones_AST;
	}
	
	public final void decl_consultas() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST decl_consultas_AST = null;
		
		try {      // for error handling
			AST tmp8_AST = null;
			tmp8_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp8_AST);
			match(QUERIES);
			match(6);
			{
			_loop137:
			do {
				if ((LA(1)==11||LA(1)==GRAPH)) {
					consulta();
					astFactory.addASTChild(currentAST, returnAST);
					match(17);
				}
				else {
					break _loop137;
				}
				
			} while (true);
			}
			match(7);
			decl_consultas_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_0);
		}
		returnAST = decl_consultas_AST;
	}
	
	public final void persona() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST persona_AST = null;
		
		try {      // for error handling
			AST tmp12_AST = null;
			tmp12_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp12_AST);
			match(PERSON);
			match(6);
			atributo();
			astFactory.addASTChild(currentAST, returnAST);
			{
			_loop127:
			do {
				if ((LA(1)==9)) {
					match(9);
					atributo();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					break _loop127;
				}
				
			} while (true);
			}
			match(7);
			persona_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_3);
		}
		returnAST = persona_AST;
	}
	
	public final void atributo() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST atributo_AST = null;
		
		try {      // for error handling
			AST tmp16_AST = null;
			tmp16_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp16_AST);
			match(ATR_IDENT);
			match(11);
			AST tmp18_AST = null;
			tmp18_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp18_AST);
			match(ATR_VALOR);
			match(13);
			atributo_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_4);
		}
		returnAST = atributo_AST;
	}
	
	public final void conexion() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST conexion_AST = null;
		
		try {      // for error handling
			AST tmp20_AST = null;
			tmp20_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp20_AST);
			match(NEXUS);
			match(6);
			atributo();
			astFactory.addASTChild(currentAST, returnAST);
			{
			_loop134:
			do {
				if ((LA(1)==9)) {
					match(9);
					atributo();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					break _loop134;
				}
				
			} while (true);
			}
			match(7);
			conexion_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_5);
		}
		returnAST = conexion_AST;
	}
	
	public final void consulta() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST consulta_AST = null;
		
		try {      // for error handling
			if ((LA(1)==11) && (LA(2)==ATR_VALOR) && (LA(3)==13) && (LA(4)==RELATEDTO)) {
				match(11);
				AST tmp25_AST = null;
				tmp25_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp25_AST);
				match(ATR_VALOR);
				match(13);
				AST tmp27_AST = null;
				tmp27_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp27_AST);
				match(RELATEDTO);
				match(11);
				AST tmp29_AST = null;
				tmp29_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp29_AST);
				match(ATR_VALOR);
				match(13);
				consulta_AST = (AST)currentAST.root;
			}
			else if ((LA(1)==11) && (LA(2)==ATR_VALOR) && (LA(3)==13) && (LA(4)==CONNECTIONSFOR)) {
				match(11);
				AST tmp32_AST = null;
				tmp32_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp32_AST);
				match(ATR_VALOR);
				match(13);
				AST tmp34_AST = null;
				tmp34_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp34_AST);
				match(CONNECTIONSFOR);
				match(11);
				AST tmp36_AST = null;
				tmp36_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp36_AST);
				match(ATR_VALOR);
				match(13);
				consulta_AST = (AST)currentAST.root;
			}
			else if ((LA(1)==11) && (LA(2)==ATR_VALOR) && (LA(3)==13) && (LA(4)==LEVELCONNECTIONSFOR)) {
				match(11);
				AST tmp39_AST = null;
				tmp39_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp39_AST);
				match(ATR_VALOR);
				match(13);
				AST tmp41_AST = null;
				tmp41_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp41_AST);
				match(LEVELCONNECTIONSFOR);
				match(11);
				AST tmp43_AST = null;
				tmp43_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp43_AST);
				match(ATR_VALOR);
				match(13);
				consulta_AST = (AST)currentAST.root;
			}
			else if ((LA(1)==GRAPH)) {
				AST tmp45_AST = null;
				tmp45_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp45_AST);
				match(GRAPH);
				consulta_AST = (AST)currentAST.root;
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_6);
		}
		returnAST = consulta_AST;
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
	
	protected void buildTokenTypeASTClassMap() {
		tokenTypeToASTClassMap=null;
	};
	
	private static final long[] mk_tokenSet_0() {
		long[] data = { 2L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());
	private static final long[] mk_tokenSet_1() {
		long[] data = { 16384L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_1 = new BitSet(mk_tokenSet_1());
	private static final long[] mk_tokenSet_2() {
		long[] data = { 65536L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_2 = new BitSet(mk_tokenSet_2());
	private static final long[] mk_tokenSet_3() {
		long[] data = { 384L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_3 = new BitSet(mk_tokenSet_3());
	private static final long[] mk_tokenSet_4() {
		long[] data = { 640L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_4 = new BitSet(mk_tokenSet_4());
	private static final long[] mk_tokenSet_5() {
		long[] data = { 32896L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_5 = new BitSet(mk_tokenSet_5());
	private static final long[] mk_tokenSet_6() {
		long[] data = { 131072L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_6 = new BitSet(mk_tokenSet_6());
	
	}
