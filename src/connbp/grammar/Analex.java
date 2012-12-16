// $ANTLR : "analex.g" -> "Analex.java"$

	package connbp.grammar;

import java.io.InputStream;
import antlr.TokenStreamException;
import antlr.TokenStreamIOException;
import antlr.TokenStreamRecognitionException;
import antlr.CharStreamException;
import antlr.CharStreamIOException;
import antlr.ANTLRException;
import java.io.Reader;
import java.util.Hashtable;
import antlr.CharScanner;
import antlr.InputBuffer;
import antlr.ByteBuffer;
import antlr.CharBuffer;
import antlr.Token;
import antlr.CommonToken;
import antlr.RecognitionException;
import antlr.NoViableAltForCharException;
import antlr.MismatchedCharException;
import antlr.TokenStream;
import antlr.ANTLRHashString;
import antlr.LexerSharedInputState;
import antlr.collections.impl.BitSet;
import antlr.SemanticException;

public class Analex extends antlr.CharScanner implements AnalexTokenTypes, TokenStream
 {

	boolean valor=false;
public Analex(InputStream in) {
	this(new ByteBuffer(in));
}
public Analex(Reader in) {
	this(new CharBuffer(in));
}
public Analex(InputBuffer ib) {
	this(new LexerSharedInputState(ib));
}
public Analex(LexerSharedInputState state) {
	super(state);
	caseSensitiveLiterals = false;
	setCaseSensitive(true);
	literals = new Hashtable();
	literals.put(new ANTLRHashString("PEOPLE", this), new Integer(5));
	literals.put(new ANTLRHashString("[", this), new Integer(11));
	literals.put(new ANTLRHashString("Graph", this), new Integer(21));
	literals.put(new ANTLRHashString("PERSON", this), new Integer(8));
	literals.put(new ANTLRHashString("?", this), new Integer(17));
	literals.put(new ANTLRHashString("LevelConnectionsFor", this), new Integer(20));
	literals.put(new ANTLRHashString("ConnectionsFor", this), new Integer(19));
	literals.put(new ANTLRHashString("NEXUS", this), new Integer(15));
	literals.put(new ANTLRHashString(",", this), new Integer(9));
	literals.put(new ANTLRHashString("]", this), new Integer(13));
	literals.put(new ANTLRHashString("{", this), new Integer(6));
	literals.put(new ANTLRHashString("RelatedTo", this), new Integer(18));
	literals.put(new ANTLRHashString("QUERIES", this), new Integer(16));
	literals.put(new ANTLRHashString("CONNECTIONS", this), new Integer(14));
	literals.put(new ANTLRHashString("}", this), new Integer(7));
}

public Token nextToken() throws TokenStreamException {
	Token theRetToken=null;
tryAgain:
	for (;;) {
		Token _token = null;
		int _ttype = Token.INVALID_TYPE;
		resetText();
		try {   // for char stream error handling
			try {   // for lexical error handling
				switch ( LA(1)) {
				case '\t':  case '\r':  case ' ':
				{
					mBLANCO(true);
					theRetToken=_returnToken;
					break;
				}
				case '{':
				{
					mINI_BLOQUE(true);
					theRetToken=_returnToken;
					break;
				}
				case '}':
				{
					mFIN_BLOQUE(true);
					theRetToken=_returnToken;
					break;
				}
				case ',':
				{
					mSEPARADOR(true);
					theRetToken=_returnToken;
					break;
				}
				case '?':
				{
					mFIN_QUERY(true);
					theRetToken=_returnToken;
					break;
				}
				default:
					if ((LA(1)=='/') && (LA(2)=='/')) {
						mCOML(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='/') && (LA(2)=='*')) {
						mCOMB(true);
						theRetToken=_returnToken;
					}
					else if (((_tokenSet_0.member(LA(1))) && (true))&&(!valor)) {
						mATR_IDENT(true);
						theRetToken=_returnToken;
					}
					else if (((_tokenSet_1.member(LA(1))) && (true))&&(valor)) {
						mATR_VALOR(true);
						theRetToken=_returnToken;
					}
					else if (((LA(1)=='['))&&(!valor)) {
						mINI_VALOR(true);
						theRetToken=_returnToken;
					}
					else if (((LA(1)==']'))&&(valor)) {
						mFIN_VALOR(true);
						theRetToken=_returnToken;
					}
				else {
					if (LA(1)==EOF_CHAR) {uponEOF(); _returnToken = makeToken(Token.EOF_TYPE);}
				else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
				}
				}
				if ( _returnToken==null ) continue tryAgain; // found SKIP token
				_ttype = _returnToken.getType();
				_ttype = testLiteralsTable(_ttype);
				_returnToken.setType(_ttype);
				return _returnToken;
			}
			catch (RecognitionException e) {
				throw new TokenStreamRecognitionException(e);
			}
		}
		catch (CharStreamException cse) {
			if ( cse instanceof CharStreamIOException ) {
				throw new TokenStreamIOException(((CharStreamIOException)cse).io);
			}
			else {
				throw new TokenStreamException(cse.getMessage());
			}
		}
	}
}

	protected final void mNUEVA_LINEA(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = NUEVA_LINEA;
		int _saveIndex;
		
		match("\r\n");
		newline();
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mBLANCO(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = BLANCO;
		int _saveIndex;
		
		{
		switch ( LA(1)) {
		case ' ':
		{
			match(' ');
			break;
		}
		case '\t':
		{
			match('\t');
			break;
		}
		case '\r':
		{
			mNUEVA_LINEA(false);
			break;
		}
		default:
		{
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
		}
		}
		}
		_ttype = Token.SKIP;
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mCOML(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = COML;
		int _saveIndex;
		
		match("//");
		{
		_loop383:
		do {
			if ((_tokenSet_2.member(LA(1)))) {
				matchNot('\r');
			}
			else {
				break _loop383;
			}
			
		} while (true);
		}
		_ttype = Token.SKIP;
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mCOMB(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = COMB;
		int _saveIndex;
		
		match("/*");
		{
		_loop387:
		do {
			// nongreedy exit test
			if ((LA(1)=='*') && (LA(2)=='/')) break _loop387;
			if (((LA(1) >= '\u0003' && LA(1) <= '\u00ff')) && ((LA(2) >= '\u0003' && LA(2) <= '\u00ff'))) {
				{
				if ((LA(1)=='\r') && (LA(2)=='\n')) {
					mNUEVA_LINEA(false);
				}
				else if (((LA(1) >= '\u0003' && LA(1) <= '\u00ff')) && ((LA(2) >= '\u0003' && LA(2) <= '\u00ff'))) {
					matchNot(EOF_CHAR);
				}
				else {
					throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
				}
				
				}
			}
			else {
				break _loop387;
			}
			
		} while (true);
		}
		match("*/");
		_ttype = Token.SKIP;
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mLETRA(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = LETRA;
		int _saveIndex;
		
		{
		switch ( LA(1)) {
		case 'a':  case 'b':  case 'c':  case 'd':
		case 'e':  case 'f':  case 'g':  case 'h':
		case 'i':  case 'j':  case 'k':  case 'l':
		case 'm':  case 'n':  case 'o':  case 'p':
		case 'q':  case 'r':  case 's':  case 't':
		case 'u':  case 'v':  case 'w':  case 'x':
		case 'y':  case 'z':
		{
			matchRange('a','z');
			break;
		}
		case 'A':  case 'B':  case 'C':  case 'D':
		case 'E':  case 'F':  case 'G':  case 'H':
		case 'I':  case 'J':  case 'K':  case 'L':
		case 'M':  case 'N':  case 'O':  case 'P':
		case 'Q':  case 'R':  case 'S':  case 'T':
		case 'U':  case 'V':  case 'W':  case 'X':
		case 'Y':  case 'Z':
		{
			matchRange('A','Z');
			break;
		}
		case '_':
		{
			match('_');
			break;
		}
		case '\u00e1':  case '\u00e2':  case '\u00e3':  case '\u00e4':
		case '\u00e5':  case '\u00e6':  case '\u00e7':  case '\u00e8':
		case '\u00e9':  case '\u00ea':  case '\u00eb':  case '\u00ec':
		case '\u00ed':  case '\u00ee':  case '\u00ef':  case '\u00f0':
		case '\u00f1':  case '\u00f2':  case '\u00f3':  case '\u00f4':
		case '\u00f5':  case '\u00f6':  case '\u00f7':  case '\u00f8':
		case '\u00f9':  case '\u00fa':
		{
			matchRange('á','ú');
			break;
		}
		default:
		{
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
		}
		}
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mDIGITO(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = DIGITO;
		int _saveIndex;
		
		matchRange('0','9');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mTEXTO(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = TEXTO;
		int _saveIndex;
		
		{
		int _cnt393=0;
		_loop393:
		do {
			switch ( LA(1)) {
			case 'A':  case 'B':  case 'C':  case 'D':
			case 'E':  case 'F':  case 'G':  case 'H':
			case 'I':  case 'J':  case 'K':  case 'L':
			case 'M':  case 'N':  case 'O':  case 'P':
			case 'Q':  case 'R':  case 'S':  case 'T':
			case 'U':  case 'V':  case 'W':  case 'X':
			case 'Y':  case 'Z':  case '_':  case 'a':
			case 'b':  case 'c':  case 'd':  case 'e':
			case 'f':  case 'g':  case 'h':  case 'i':
			case 'j':  case 'k':  case 'l':  case 'm':
			case 'n':  case 'o':  case 'p':  case 'q':
			case 'r':  case 's':  case 't':  case 'u':
			case 'v':  case 'w':  case 'x':  case 'y':
			case 'z':  case '\u00e1':  case '\u00e2':  case '\u00e3':
			case '\u00e4':  case '\u00e5':  case '\u00e6':  case '\u00e7':
			case '\u00e8':  case '\u00e9':  case '\u00ea':  case '\u00eb':
			case '\u00ec':  case '\u00ed':  case '\u00ee':  case '\u00ef':
			case '\u00f0':  case '\u00f1':  case '\u00f2':  case '\u00f3':
			case '\u00f4':  case '\u00f5':  case '\u00f6':  case '\u00f7':
			case '\u00f8':  case '\u00f9':  case '\u00fa':
			{
				mLETRA(false);
				break;
			}
			case '0':  case '1':  case '2':  case '3':
			case '4':  case '5':  case '6':  case '7':
			case '8':  case '9':
			{
				mDIGITO(false);
				break;
			}
			case '@':
			{
				match('@');
				break;
			}
			case '.':
			{
				match('.');
				break;
			}
			case '-':
			{
				match('-');
				break;
			}
			default:
			{
				if ( _cnt393>=1 ) { break _loop393; } else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
			}
			}
			_cnt393++;
		} while (true);
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mATR_IDENT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = ATR_IDENT;
		int _saveIndex;
		
		if (!(!valor))
		  throw new SemanticException("!valor");
		{
		int _cnt396=0;
		_loop396:
		do {
			switch ( LA(1)) {
			case 'A':  case 'B':  case 'C':  case 'D':
			case 'E':  case 'F':  case 'G':  case 'H':
			case 'I':  case 'J':  case 'K':  case 'L':
			case 'M':  case 'N':  case 'O':  case 'P':
			case 'Q':  case 'R':  case 'S':  case 'T':
			case 'U':  case 'V':  case 'W':  case 'X':
			case 'Y':  case 'Z':  case '_':  case 'a':
			case 'b':  case 'c':  case 'd':  case 'e':
			case 'f':  case 'g':  case 'h':  case 'i':
			case 'j':  case 'k':  case 'l':  case 'm':
			case 'n':  case 'o':  case 'p':  case 'q':
			case 'r':  case 's':  case 't':  case 'u':
			case 'v':  case 'w':  case 'x':  case 'y':
			case 'z':  case '\u00e1':  case '\u00e2':  case '\u00e3':
			case '\u00e4':  case '\u00e5':  case '\u00e6':  case '\u00e7':
			case '\u00e8':  case '\u00e9':  case '\u00ea':  case '\u00eb':
			case '\u00ec':  case '\u00ed':  case '\u00ee':  case '\u00ef':
			case '\u00f0':  case '\u00f1':  case '\u00f2':  case '\u00f3':
			case '\u00f4':  case '\u00f5':  case '\u00f6':  case '\u00f7':
			case '\u00f8':  case '\u00f9':  case '\u00fa':
			{
				mLETRA(false);
				break;
			}
			case '0':  case '1':  case '2':  case '3':
			case '4':  case '5':  case '6':  case '7':
			case '8':  case '9':
			{
				mDIGITO(false);
				break;
			}
			default:
			{
				if ( _cnt396>=1 ) { break _loop396; } else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
			}
			}
			_cnt396++;
		} while (true);
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mATR_VALOR(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = ATR_VALOR;
		int _saveIndex;
		
		if (!(valor))
		  throw new SemanticException("valor");
		mTEXTO(false);
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mINI_VALOR(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = INI_VALOR;
		int _saveIndex;
		
		if (!(!valor))
		  throw new SemanticException("!valor");
		match('[');
		valor=true;
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mFIN_VALOR(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = FIN_VALOR;
		int _saveIndex;
		
		if (!(valor))
		  throw new SemanticException("valor");
		match(']');
		valor=false;
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mINI_BLOQUE(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = INI_BLOQUE;
		int _saveIndex;
		
		match('{');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mFIN_BLOQUE(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = FIN_BLOQUE;
		int _saveIndex;
		
		match('}');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mSEPARADOR(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = SEPARADOR;
		int _saveIndex;
		
		match(',');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mFIN_QUERY(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = FIN_QUERY;
		int _saveIndex;
		
		match('?');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	
	private static final long[] mk_tokenSet_0() {
		long[] data = new long[8];
		data[0]=287948901175001088L;
		data[1]=576460745995190270L;
		data[3]=576460743713488896L;
		return data;
	}
	public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());
	private static final long[] mk_tokenSet_1() {
		long[] data = new long[8];
		data[0]=288054454291267584L;
		data[1]=576460745995190271L;
		data[3]=576460743713488896L;
		return data;
	}
	public static final BitSet _tokenSet_1 = new BitSet(mk_tokenSet_1());
	private static final long[] mk_tokenSet_2() {
		long[] data = new long[8];
		data[0]=-8200L;
		for (int i = 1; i<=3; i++) { data[i]=-1L; }
		return data;
	}
	public static final BitSet _tokenSet_2 = new BitSet(mk_tokenSet_2());
	
	}
