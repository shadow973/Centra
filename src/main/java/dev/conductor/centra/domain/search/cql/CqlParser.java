package dev.conductor.centra.domain.search.cql;// Generated from /Users/shamil/Documents/Projects/conductor.dev/data-services/src/main/antlr4/dev/conductor/cql/cql.g4 by ANTLR 4.8
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CqlParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		FUNCTION=1, DATETIME=2, NUMBER=3, WHITESPACE=4, SCOL=5, DOT=6, OPEN_PAR=7, 
		CLOSE_PAR=8, COMMA=9, EQ=10, STAR=11, CONTAINS=12, NOT_CONTAINS=13, LT=14, 
		LT_EQ=15, GT=16, GT_EQ=17, NOT_EQ=18, K_AFTER=19, K_AND=20, K_ASC=21, 
		K_BEFORE=22, K_BY=23, K_CHANGED=24, K_DESC=25, K_EMPTY=26, K_IN=27, K_IS=28, 
		K_NOT=29, K_NULL=30, K_ON=31, K_OR=32, K_ORDER=33, K_TO=34, K_WAS=35, 
		F_AFFECTED_VERSION=36, F_APPROVALS=37, F_ASSIGNEE=38, F_ATTACHMENTS=39, 
		F_CATEGORY=40, F_COMMENT=41, F_COMPONENT=42, F_CREATED=43, F_CREATED_DATE=44, 
		F_CREATOR=45, F_CUSTOM_FIELD=46, F_CUSTOMER_REQUEST_TYPE=47, F_DATE=48, 
		F_DESCRIPTION=49, F_DUE=50, F_DURATION=51, F_ENVIRONMENT=52, F_EPIC_LINK=53, 
		F_FILTER=54, F_FIX_VERSION=55, F_ISSUE=56, F_ISSUE_KEY=57, F_ISSUE_TYPE=58, 
		F_KEY=59, F_LABEL=60, F_LABELS=61, F_LAST_VIEWED=62, F_LEVEL=63, F_NUMBER=64, 
		F_ORGANIZATION=65, F_ORIGINAL_ESTIMATE=66, F_PARENT=67, F_PRIORITY=68, 
		F_PROJECT=69, F_RANK=70, F_REMAINING_ESTIMATE=71, F_REPORTER=72, F_REQUEST_CHANNEL_TYPE=73, 
		F_REQUEST_LAST_ACTIVITY_TIME=74, F_RESOLUTION=75, F_RESOLUTION_DATE=76, 
		F_RESOLVED=77, F_SLA=78, F_SPRINT=79, F_STATUS=80, F_SUMMARY=81, F_TEXT=82, 
		F_TIME_SPENT=83, F_TYPE=84, F_UPDATED=85, F_USER=86, F_VERSION=87, F_VOTER=88, 
		F_VOTES=89, F_WATCHER=90, F_WATCHERS=91, F_WORK_RATIO=92, IDENTIFIER=93, 
		STRING_LITERAL=94, COMMENT=95, LINE_COMMENT=96, SPACES=97;
	public static final int
		RULE_parse = 0, RULE_cql_stmt_list = 1, RULE_cql_stmt = 2, RULE_expr = 3, 
		RULE_ordering_term = 4, RULE_operator = 5, RULE_literal_value = 6, RULE_literal_list = 7, 
		RULE_keyword = 8, RULE_state_name = 9, RULE_field = 10, RULE_compare_dates = 11, 
		RULE_dates = 12;
	private static String[] makeRuleNames() {
		return new String[] {
			"parse", "cql_stmt_list", "cql_stmt", "expr", "ordering_term", "operator", 
			"literal_value", "literal_list", "keyword", "state_name", "field", "compare_dates", 
			"dates"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, "' '", "';'", "'.'", "'('", "')'", "','", "'='", 
			"'*'", "'~'", "'!~'", "'<'", "'<='", "'>'", "'>='", "'!='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "FUNCTION", "DATETIME", "NUMBER", "WHITESPACE", "SCOL", "DOT", 
			"OPEN_PAR", "CLOSE_PAR", "COMMA", "EQ", "STAR", "CONTAINS", "NOT_CONTAINS", 
			"LT", "LT_EQ", "GT", "GT_EQ", "NOT_EQ", "K_AFTER", "K_AND", "K_ASC", 
			"K_BEFORE", "K_BY", "K_CHANGED", "K_DESC", "K_EMPTY", "K_IN", "K_IS", 
			"K_NOT", "K_NULL", "K_ON", "K_OR", "K_ORDER", "K_TO", "K_WAS", "F_AFFECTED_VERSION", 
			"F_APPROVALS", "F_ASSIGNEE", "F_ATTACHMENTS", "F_CATEGORY", "F_COMMENT", 
			"F_COMPONENT", "F_CREATED", "F_CREATED_DATE", "F_CREATOR", "F_CUSTOM_FIELD", 
			"F_CUSTOMER_REQUEST_TYPE", "F_DATE", "F_DESCRIPTION", "F_DUE", "F_DURATION", 
			"F_ENVIRONMENT", "F_EPIC_LINK", "F_FILTER", "F_FIX_VERSION", "F_ISSUE", 
			"F_ISSUE_KEY", "F_ISSUE_TYPE", "F_KEY", "F_LABEL", "F_LABELS", "F_LAST_VIEWED", 
			"F_LEVEL", "F_NUMBER", "F_ORGANIZATION", "F_ORIGINAL_ESTIMATE", "F_PARENT", 
			"F_PRIORITY", "F_PROJECT", "F_RANK", "F_REMAINING_ESTIMATE", "F_REPORTER", 
			"F_REQUEST_CHANNEL_TYPE", "F_REQUEST_LAST_ACTIVITY_TIME", "F_RESOLUTION", 
			"F_RESOLUTION_DATE", "F_RESOLVED", "F_SLA", "F_SPRINT", "F_STATUS", "F_SUMMARY", 
			"F_TEXT", "F_TIME_SPENT", "F_TYPE", "F_UPDATED", "F_USER", "F_VERSION", 
			"F_VOTER", "F_VOTES", "F_WATCHER", "F_WATCHERS", "F_WORK_RATIO", "IDENTIFIER", 
			"STRING_LITERAL", "COMMENT", "LINE_COMMENT", "SPACES"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "cql.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CqlParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ParseContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(CqlParser.EOF, 0); }
		public List<Cql_stmt_listContext> cql_stmt_list() {
			return getRuleContexts(Cql_stmt_listContext.class);
		}
		public Cql_stmt_listContext cql_stmt_list(int i) {
			return getRuleContext(Cql_stmt_listContext.class,i);
		}
		public ParseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parse; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CqlListener ) ((CqlListener)listener).enterParse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CqlListener ) ((CqlListener)listener).exitParse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CqlVisitor) return ((CqlVisitor<? extends T>)visitor).visitParse(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParseContext parse() throws RecognitionException {
		ParseContext _localctx = new ParseContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_parse);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(29);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DATETIME) | (1L << SCOL) | (1L << OPEN_PAR) | (1L << K_EMPTY) | (1L << K_NOT) | (1L << F_AFFECTED_VERSION) | (1L << F_APPROVALS) | (1L << F_ASSIGNEE) | (1L << F_ATTACHMENTS) | (1L << F_CATEGORY) | (1L << F_COMMENT) | (1L << F_COMPONENT) | (1L << F_CREATED) | (1L << F_CREATED_DATE) | (1L << F_CREATOR) | (1L << F_CUSTOM_FIELD) | (1L << F_CUSTOMER_REQUEST_TYPE) | (1L << F_DATE) | (1L << F_DESCRIPTION) | (1L << F_DUE) | (1L << F_DURATION) | (1L << F_ENVIRONMENT) | (1L << F_EPIC_LINK) | (1L << F_FILTER) | (1L << F_FIX_VERSION) | (1L << F_ISSUE) | (1L << F_ISSUE_KEY) | (1L << F_ISSUE_TYPE) | (1L << F_KEY) | (1L << F_LABEL) | (1L << F_LABELS) | (1L << F_LAST_VIEWED) | (1L << F_LEVEL))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (F_NUMBER - 64)) | (1L << (F_ORGANIZATION - 64)) | (1L << (F_ORIGINAL_ESTIMATE - 64)) | (1L << (F_PARENT - 64)) | (1L << (F_PRIORITY - 64)) | (1L << (F_PROJECT - 64)) | (1L << (F_RANK - 64)) | (1L << (F_REMAINING_ESTIMATE - 64)) | (1L << (F_REPORTER - 64)) | (1L << (F_REQUEST_CHANNEL_TYPE - 64)) | (1L << (F_REQUEST_LAST_ACTIVITY_TIME - 64)) | (1L << (F_RESOLUTION - 64)) | (1L << (F_RESOLUTION_DATE - 64)) | (1L << (F_RESOLVED - 64)) | (1L << (F_SLA - 64)) | (1L << (F_SPRINT - 64)) | (1L << (F_STATUS - 64)) | (1L << (F_SUMMARY - 64)) | (1L << (F_TEXT - 64)) | (1L << (F_TIME_SPENT - 64)) | (1L << (F_TYPE - 64)) | (1L << (F_UPDATED - 64)) | (1L << (F_USER - 64)) | (1L << (F_VERSION - 64)) | (1L << (F_VOTER - 64)) | (1L << (F_VOTES - 64)) | (1L << (F_WATCHER - 64)) | (1L << (F_WATCHERS - 64)) | (1L << (F_WORK_RATIO - 64)) | (1L << (IDENTIFIER - 64)) | (1L << (STRING_LITERAL - 64)))) != 0)) {
				{
				{
				setState(26);
				cql_stmt_list();
				}
				}
				setState(31);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(32);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Cql_stmt_listContext extends ParserRuleContext {
		public List<Cql_stmtContext> cql_stmt() {
			return getRuleContexts(Cql_stmtContext.class);
		}
		public Cql_stmtContext cql_stmt(int i) {
			return getRuleContext(Cql_stmtContext.class,i);
		}
		public List<TerminalNode> SCOL() { return getTokens(CqlParser.SCOL); }
		public TerminalNode SCOL(int i) {
			return getToken(CqlParser.SCOL, i);
		}
		public Cql_stmt_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cql_stmt_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CqlListener ) ((CqlListener)listener).enterCql_stmt_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CqlListener ) ((CqlListener)listener).exitCql_stmt_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CqlVisitor) return ((CqlVisitor<? extends T>)visitor).visitCql_stmt_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Cql_stmt_listContext cql_stmt_list() throws RecognitionException {
		Cql_stmt_listContext _localctx = new Cql_stmt_listContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_cql_stmt_list);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SCOL) {
				{
				{
				setState(34);
				match(SCOL);
				}
				}
				setState(39);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(40);
			cql_stmt();
			setState(49);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(42); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(41);
						match(SCOL);
						}
						}
						setState(44); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==SCOL );
					setState(46);
					cql_stmt();
					}
					} 
				}
				setState(51);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			setState(55);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(52);
					match(SCOL);
					}
					} 
				}
				setState(57);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Cql_stmtContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> OPEN_PAR() { return getTokens(CqlParser.OPEN_PAR); }
		public TerminalNode OPEN_PAR(int i) {
			return getToken(CqlParser.OPEN_PAR, i);
		}
		public List<TerminalNode> CLOSE_PAR() { return getTokens(CqlParser.CLOSE_PAR); }
		public TerminalNode CLOSE_PAR(int i) {
			return getToken(CqlParser.CLOSE_PAR, i);
		}
		public Ordering_termContext ordering_term() {
			return getRuleContext(Ordering_termContext.class,0);
		}
		public List<TerminalNode> K_AND() { return getTokens(CqlParser.K_AND); }
		public TerminalNode K_AND(int i) {
			return getToken(CqlParser.K_AND, i);
		}
		public List<TerminalNode> K_OR() { return getTokens(CqlParser.K_OR); }
		public TerminalNode K_OR(int i) {
			return getToken(CqlParser.K_OR, i);
		}
		public Cql_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cql_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CqlListener ) ((CqlListener)listener).enterCql_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CqlListener ) ((CqlListener)listener).exitCql_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CqlVisitor) return ((CqlVisitor<? extends T>)visitor).visitCql_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Cql_stmtContext cql_stmt() throws RecognitionException {
		Cql_stmtContext _localctx = new Cql_stmtContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_cql_stmt);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OPEN_PAR) {
				{
				{
				setState(58);
				match(OPEN_PAR);
				}
				}
				setState(63);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(64);
			expr();
			setState(81);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==K_AND || _la==K_OR) {
				{
				{
				setState(65);
				_la = _input.LA(1);
				if ( !(_la==K_AND || _la==K_OR) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(69);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==OPEN_PAR) {
					{
					{
					setState(66);
					match(OPEN_PAR);
					}
					}
					setState(71);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(72);
				expr();
				setState(76);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
				while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(73);
						match(CLOSE_PAR);
						}
						} 
					}
					setState(78);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
				}
				}
				}
				setState(83);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(87);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CLOSE_PAR) {
				{
				{
				setState(84);
				match(CLOSE_PAR);
				}
				}
				setState(89);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_ORDER) {
				{
				setState(90);
				ordering_term();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public OperatorContext operator() {
			return getRuleContext(OperatorContext.class,0);
		}
		public FieldContext field() {
			return getRuleContext(FieldContext.class,0);
		}
		public List<Literal_valueContext> literal_value() {
			return getRuleContexts(Literal_valueContext.class);
		}
		public Literal_valueContext literal_value(int i) {
			return getRuleContext(Literal_valueContext.class,i);
		}
		public Literal_listContext literal_list() {
			return getRuleContext(Literal_listContext.class,0);
		}
		public TerminalNode FUNCTION() { return getToken(CqlParser.FUNCTION, 0); }
		public DatesContext dates() {
			return getRuleContext(DatesContext.class,0);
		}
		public List<TerminalNode> K_NOT() { return getTokens(CqlParser.K_NOT); }
		public TerminalNode K_NOT(int i) {
			return getToken(CqlParser.K_NOT, i);
		}
		public List<TerminalNode> OPEN_PAR() { return getTokens(CqlParser.OPEN_PAR); }
		public TerminalNode OPEN_PAR(int i) {
			return getToken(CqlParser.OPEN_PAR, i);
		}
		public Compare_datesContext compare_dates() {
			return getRuleContext(Compare_datesContext.class,0);
		}
		public List<TerminalNode> CLOSE_PAR() { return getTokens(CqlParser.CLOSE_PAR); }
		public TerminalNode CLOSE_PAR(int i) {
			return getToken(CqlParser.CLOSE_PAR, i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CqlListener ) ((CqlListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CqlListener ) ((CqlListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CqlVisitor) return ((CqlVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_expr);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==K_NOT) {
				{
				{
				setState(93);
				match(K_NOT);
				}
				}
				setState(98);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(101);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(99);
				field();
				}
				break;
			case 2:
				{
				setState(100);
				literal_value();
				}
				break;
			}
			setState(103);
			operator();
			setState(107);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(104);
					match(OPEN_PAR);
					}
					} 
				}
				setState(109);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}
			setState(114);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(110);
				literal_value();
				}
				break;
			case 2:
				{
				setState(111);
				literal_list();
				}
				break;
			case 3:
				{
				setState(112);
				match(FUNCTION);
				}
				break;
			case 4:
				{
				setState(113);
				dates();
				}
				break;
			}
			setState(117);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(116);
				compare_dates();
				}
				break;
			}
			setState(122);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(119);
					match(CLOSE_PAR);
					}
					} 
				}
				setState(124);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Ordering_termContext extends ParserRuleContext {
		public TerminalNode K_ORDER() { return getToken(CqlParser.K_ORDER, 0); }
		public TerminalNode K_BY() { return getToken(CqlParser.K_BY, 0); }
		public List<Literal_valueContext> literal_value() {
			return getRuleContexts(Literal_valueContext.class);
		}
		public Literal_valueContext literal_value(int i) {
			return getRuleContext(Literal_valueContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(CqlParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CqlParser.COMMA, i);
		}
		public List<TerminalNode> K_ASC() { return getTokens(CqlParser.K_ASC); }
		public TerminalNode K_ASC(int i) {
			return getToken(CqlParser.K_ASC, i);
		}
		public List<TerminalNode> K_DESC() { return getTokens(CqlParser.K_DESC); }
		public TerminalNode K_DESC(int i) {
			return getToken(CqlParser.K_DESC, i);
		}
		public Ordering_termContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ordering_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CqlListener ) ((CqlListener)listener).enterOrdering_term(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CqlListener ) ((CqlListener)listener).exitOrdering_term(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CqlVisitor) return ((CqlVisitor<? extends T>)visitor).visitOrdering_term(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Ordering_termContext ordering_term() throws RecognitionException {
		Ordering_termContext _localctx = new Ordering_termContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_ordering_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			match(K_ORDER);
			setState(126);
			match(K_BY);
			setState(127);
			literal_value();
			setState(129);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_ASC || _la==K_DESC) {
				{
				setState(128);
				_la = _input.LA(1);
				if ( !(_la==K_ASC || _la==K_DESC) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(138);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(131);
				match(COMMA);
				setState(132);
				literal_value();
				setState(134);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==K_ASC || _la==K_DESC) {
					{
					setState(133);
					_la = _input.LA(1);
					if ( !(_la==K_ASC || _la==K_DESC) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				}
				}
				setState(140);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OperatorContext extends ParserRuleContext {
		public TerminalNode EQ() { return getToken(CqlParser.EQ, 0); }
		public TerminalNode NOT_EQ() { return getToken(CqlParser.NOT_EQ, 0); }
		public TerminalNode CONTAINS() { return getToken(CqlParser.CONTAINS, 0); }
		public TerminalNode NOT_CONTAINS() { return getToken(CqlParser.NOT_CONTAINS, 0); }
		public TerminalNode LT_EQ() { return getToken(CqlParser.LT_EQ, 0); }
		public TerminalNode LT() { return getToken(CqlParser.LT, 0); }
		public TerminalNode GT() { return getToken(CqlParser.GT, 0); }
		public TerminalNode GT_EQ() { return getToken(CqlParser.GT_EQ, 0); }
		public TerminalNode K_IN() { return getToken(CqlParser.K_IN, 0); }
		public TerminalNode K_NOT() { return getToken(CqlParser.K_NOT, 0); }
		public TerminalNode K_IS() { return getToken(CqlParser.K_IS, 0); }
		public TerminalNode K_WAS() { return getToken(CqlParser.K_WAS, 0); }
		public TerminalNode K_CHANGED() { return getToken(CqlParser.K_CHANGED, 0); }
		public TerminalNode K_TO() { return getToken(CqlParser.K_TO, 0); }
		public OperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CqlListener ) ((CqlListener)listener).enterOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CqlListener ) ((CqlListener)listener).exitOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CqlVisitor) return ((CqlVisitor<? extends T>)visitor).visitOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperatorContext operator() throws RecognitionException {
		OperatorContext _localctx = new OperatorContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_operator);
		try {
			setState(160);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(141);
				match(EQ);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(142);
				match(NOT_EQ);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(143);
				match(CONTAINS);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(144);
				match(NOT_CONTAINS);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(145);
				match(LT_EQ);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(146);
				match(LT);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(147);
				match(GT);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(148);
				match(GT_EQ);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(149);
				match(K_IN);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(150);
				match(K_NOT);
				setState(151);
				match(K_IN);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(152);
				match(K_IS);
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(153);
				match(K_WAS);
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(154);
				match(K_IS);
				setState(155);
				match(K_NOT);
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(156);
				match(K_WAS);
				setState(157);
				match(K_NOT);
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(158);
				match(K_CHANGED);
				setState(159);
				match(K_TO);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Literal_valueContext extends ParserRuleContext {
		public TerminalNode STRING_LITERAL() { return getToken(CqlParser.STRING_LITERAL, 0); }
		public TerminalNode IDENTIFIER() { return getToken(CqlParser.IDENTIFIER, 0); }
		public State_nameContext state_name() {
			return getRuleContext(State_nameContext.class,0);
		}
		public FieldContext field() {
			return getRuleContext(FieldContext.class,0);
		}
		public DatesContext dates() {
			return getRuleContext(DatesContext.class,0);
		}
		public Literal_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CqlListener ) ((CqlListener)listener).enterLiteral_value(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CqlListener ) ((CqlListener)listener).exitLiteral_value(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CqlVisitor) return ((CqlVisitor<? extends T>)visitor).visitLiteral_value(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Literal_valueContext literal_value() throws RecognitionException {
		Literal_valueContext _localctx = new Literal_valueContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_literal_value);
		try {
			setState(167);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(162);
				match(STRING_LITERAL);
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(163);
				match(IDENTIFIER);
				}
				break;
			case K_EMPTY:
				enterOuterAlt(_localctx, 3);
				{
				setState(164);
				state_name();
				}
				break;
			case F_AFFECTED_VERSION:
			case F_APPROVALS:
			case F_ASSIGNEE:
			case F_ATTACHMENTS:
			case F_CATEGORY:
			case F_COMMENT:
			case F_COMPONENT:
			case F_CREATED:
			case F_CREATED_DATE:
			case F_CREATOR:
			case F_CUSTOM_FIELD:
			case F_CUSTOMER_REQUEST_TYPE:
			case F_DATE:
			case F_DESCRIPTION:
			case F_DUE:
			case F_DURATION:
			case F_ENVIRONMENT:
			case F_EPIC_LINK:
			case F_FILTER:
			case F_FIX_VERSION:
			case F_ISSUE:
			case F_ISSUE_KEY:
			case F_ISSUE_TYPE:
			case F_KEY:
			case F_LABEL:
			case F_LABELS:
			case F_LAST_VIEWED:
			case F_LEVEL:
			case F_NUMBER:
			case F_ORGANIZATION:
			case F_ORIGINAL_ESTIMATE:
			case F_PARENT:
			case F_PRIORITY:
			case F_PROJECT:
			case F_RANK:
			case F_REMAINING_ESTIMATE:
			case F_REPORTER:
			case F_REQUEST_CHANNEL_TYPE:
			case F_REQUEST_LAST_ACTIVITY_TIME:
			case F_RESOLUTION:
			case F_RESOLUTION_DATE:
			case F_RESOLVED:
			case F_SLA:
			case F_SPRINT:
			case F_STATUS:
			case F_SUMMARY:
			case F_TEXT:
			case F_TIME_SPENT:
			case F_TYPE:
			case F_UPDATED:
			case F_USER:
			case F_VERSION:
			case F_VOTER:
			case F_VOTES:
			case F_WATCHER:
			case F_WATCHERS:
			case F_WORK_RATIO:
				enterOuterAlt(_localctx, 4);
				{
				setState(165);
				field();
				}
				break;
			case DATETIME:
				enterOuterAlt(_localctx, 5);
				{
				setState(166);
				dates();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Literal_listContext extends ParserRuleContext {
		public TerminalNode OPEN_PAR() { return getToken(CqlParser.OPEN_PAR, 0); }
		public List<Literal_valueContext> literal_value() {
			return getRuleContexts(Literal_valueContext.class);
		}
		public Literal_valueContext literal_value(int i) {
			return getRuleContext(Literal_valueContext.class,i);
		}
		public TerminalNode CLOSE_PAR() { return getToken(CqlParser.CLOSE_PAR, 0); }
		public List<TerminalNode> COMMA() { return getTokens(CqlParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CqlParser.COMMA, i);
		}
		public Literal_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CqlListener ) ((CqlListener)listener).enterLiteral_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CqlListener ) ((CqlListener)listener).exitLiteral_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CqlVisitor) return ((CqlVisitor<? extends T>)visitor).visitLiteral_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Literal_listContext literal_list() throws RecognitionException {
		Literal_listContext _localctx = new Literal_listContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_literal_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			match(OPEN_PAR);
			setState(170);
			literal_value();
			setState(175);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(171);
				match(COMMA);
				setState(172);
				literal_value();
				}
				}
				setState(177);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(178);
			match(CLOSE_PAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class KeywordContext extends ParserRuleContext {
		public TerminalNode K_AFTER() { return getToken(CqlParser.K_AFTER, 0); }
		public TerminalNode K_AND() { return getToken(CqlParser.K_AND, 0); }
		public TerminalNode K_ASC() { return getToken(CqlParser.K_ASC, 0); }
		public TerminalNode K_BEFORE() { return getToken(CqlParser.K_BEFORE, 0); }
		public TerminalNode K_BY() { return getToken(CqlParser.K_BY, 0); }
		public TerminalNode K_CHANGED() { return getToken(CqlParser.K_CHANGED, 0); }
		public TerminalNode K_DESC() { return getToken(CqlParser.K_DESC, 0); }
		public TerminalNode K_IN() { return getToken(CqlParser.K_IN, 0); }
		public TerminalNode K_IS() { return getToken(CqlParser.K_IS, 0); }
		public TerminalNode K_NOT() { return getToken(CqlParser.K_NOT, 0); }
		public TerminalNode K_NULL() { return getToken(CqlParser.K_NULL, 0); }
		public TerminalNode K_ON() { return getToken(CqlParser.K_ON, 0); }
		public TerminalNode K_OR() { return getToken(CqlParser.K_OR, 0); }
		public TerminalNode K_ORDER() { return getToken(CqlParser.K_ORDER, 0); }
		public TerminalNode K_TO() { return getToken(CqlParser.K_TO, 0); }
		public TerminalNode K_WAS() { return getToken(CqlParser.K_WAS, 0); }
		public KeywordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CqlListener ) ((CqlListener)listener).enterKeyword(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CqlListener ) ((CqlListener)listener).exitKeyword(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CqlVisitor) return ((CqlVisitor<? extends T>)visitor).visitKeyword(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KeywordContext keyword() throws RecognitionException {
		KeywordContext _localctx = new KeywordContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_keyword);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << K_AFTER) | (1L << K_AND) | (1L << K_ASC) | (1L << K_BEFORE) | (1L << K_BY) | (1L << K_CHANGED) | (1L << K_DESC) | (1L << K_IN) | (1L << K_IS) | (1L << K_NOT) | (1L << K_NULL) | (1L << K_ON) | (1L << K_OR) | (1L << K_ORDER) | (1L << K_TO) | (1L << K_WAS))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class State_nameContext extends ParserRuleContext {
		public TerminalNode K_EMPTY() { return getToken(CqlParser.K_EMPTY, 0); }
		public State_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_state_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CqlListener ) ((CqlListener)listener).enterState_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CqlListener ) ((CqlListener)listener).exitState_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CqlVisitor) return ((CqlVisitor<? extends T>)visitor).visitState_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final State_nameContext state_name() throws RecognitionException {
		State_nameContext _localctx = new State_nameContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_state_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			match(K_EMPTY);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldContext extends ParserRuleContext {
		public TerminalNode F_AFFECTED_VERSION() { return getToken(CqlParser.F_AFFECTED_VERSION, 0); }
		public TerminalNode F_APPROVALS() { return getToken(CqlParser.F_APPROVALS, 0); }
		public TerminalNode F_ASSIGNEE() { return getToken(CqlParser.F_ASSIGNEE, 0); }
		public TerminalNode F_ATTACHMENTS() { return getToken(CqlParser.F_ATTACHMENTS, 0); }
		public TerminalNode F_CATEGORY() { return getToken(CqlParser.F_CATEGORY, 0); }
		public TerminalNode F_COMMENT() { return getToken(CqlParser.F_COMMENT, 0); }
		public TerminalNode F_COMPONENT() { return getToken(CqlParser.F_COMPONENT, 0); }
		public TerminalNode F_CREATED() { return getToken(CqlParser.F_CREATED, 0); }
		public TerminalNode F_CREATED_DATE() { return getToken(CqlParser.F_CREATED_DATE, 0); }
		public TerminalNode F_CREATOR() { return getToken(CqlParser.F_CREATOR, 0); }
		public TerminalNode F_CUSTOM_FIELD() { return getToken(CqlParser.F_CUSTOM_FIELD, 0); }
		public TerminalNode F_CUSTOMER_REQUEST_TYPE() { return getToken(CqlParser.F_CUSTOMER_REQUEST_TYPE, 0); }
		public TerminalNode F_DATE() { return getToken(CqlParser.F_DATE, 0); }
		public TerminalNode F_DESCRIPTION() { return getToken(CqlParser.F_DESCRIPTION, 0); }
		public TerminalNode F_DUE() { return getToken(CqlParser.F_DUE, 0); }
		public TerminalNode F_DURATION() { return getToken(CqlParser.F_DURATION, 0); }
		public TerminalNode F_ENVIRONMENT() { return getToken(CqlParser.F_ENVIRONMENT, 0); }
		public TerminalNode F_EPIC_LINK() { return getToken(CqlParser.F_EPIC_LINK, 0); }
		public TerminalNode F_FILTER() { return getToken(CqlParser.F_FILTER, 0); }
		public TerminalNode F_FIX_VERSION() { return getToken(CqlParser.F_FIX_VERSION, 0); }
		public TerminalNode F_ISSUE() { return getToken(CqlParser.F_ISSUE, 0); }
		public TerminalNode F_ISSUE_KEY() { return getToken(CqlParser.F_ISSUE_KEY, 0); }
		public TerminalNode F_ISSUE_TYPE() { return getToken(CqlParser.F_ISSUE_TYPE, 0); }
		public TerminalNode F_KEY() { return getToken(CqlParser.F_KEY, 0); }
		public TerminalNode F_LABEL() { return getToken(CqlParser.F_LABEL, 0); }
		public TerminalNode F_LABELS() { return getToken(CqlParser.F_LABELS, 0); }
		public TerminalNode F_LAST_VIEWED() { return getToken(CqlParser.F_LAST_VIEWED, 0); }
		public TerminalNode F_LEVEL() { return getToken(CqlParser.F_LEVEL, 0); }
		public TerminalNode F_NUMBER() { return getToken(CqlParser.F_NUMBER, 0); }
		public TerminalNode F_ORGANIZATION() { return getToken(CqlParser.F_ORGANIZATION, 0); }
		public TerminalNode F_ORIGINAL_ESTIMATE() { return getToken(CqlParser.F_ORIGINAL_ESTIMATE, 0); }
		public TerminalNode F_PARENT() { return getToken(CqlParser.F_PARENT, 0); }
		public TerminalNode F_PRIORITY() { return getToken(CqlParser.F_PRIORITY, 0); }
		public TerminalNode F_PROJECT() { return getToken(CqlParser.F_PROJECT, 0); }
		public TerminalNode F_RANK() { return getToken(CqlParser.F_RANK, 0); }
		public TerminalNode F_REMAINING_ESTIMATE() { return getToken(CqlParser.F_REMAINING_ESTIMATE, 0); }
		public TerminalNode F_REPORTER() { return getToken(CqlParser.F_REPORTER, 0); }
		public TerminalNode F_REQUEST_CHANNEL_TYPE() { return getToken(CqlParser.F_REQUEST_CHANNEL_TYPE, 0); }
		public TerminalNode F_REQUEST_LAST_ACTIVITY_TIME() { return getToken(CqlParser.F_REQUEST_LAST_ACTIVITY_TIME, 0); }
		public TerminalNode F_RESOLUTION() { return getToken(CqlParser.F_RESOLUTION, 0); }
		public TerminalNode F_RESOLUTION_DATE() { return getToken(CqlParser.F_RESOLUTION_DATE, 0); }
		public TerminalNode F_RESOLVED() { return getToken(CqlParser.F_RESOLVED, 0); }
		public TerminalNode F_SLA() { return getToken(CqlParser.F_SLA, 0); }
		public TerminalNode F_SPRINT() { return getToken(CqlParser.F_SPRINT, 0); }
		public TerminalNode F_STATUS() { return getToken(CqlParser.F_STATUS, 0); }
		public TerminalNode F_SUMMARY() { return getToken(CqlParser.F_SUMMARY, 0); }
		public TerminalNode F_TEXT() { return getToken(CqlParser.F_TEXT, 0); }
		public TerminalNode F_TIME_SPENT() { return getToken(CqlParser.F_TIME_SPENT, 0); }
		public TerminalNode F_TYPE() { return getToken(CqlParser.F_TYPE, 0); }
		public TerminalNode F_UPDATED() { return getToken(CqlParser.F_UPDATED, 0); }
		public TerminalNode F_USER() { return getToken(CqlParser.F_USER, 0); }
		public TerminalNode F_VERSION() { return getToken(CqlParser.F_VERSION, 0); }
		public TerminalNode F_VOTER() { return getToken(CqlParser.F_VOTER, 0); }
		public TerminalNode F_VOTES() { return getToken(CqlParser.F_VOTES, 0); }
		public TerminalNode F_WATCHER() { return getToken(CqlParser.F_WATCHER, 0); }
		public TerminalNode F_WATCHERS() { return getToken(CqlParser.F_WATCHERS, 0); }
		public TerminalNode F_WORK_RATIO() { return getToken(CqlParser.F_WORK_RATIO, 0); }
		public FieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CqlListener ) ((CqlListener)listener).enterField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CqlListener ) ((CqlListener)listener).exitField(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CqlVisitor) return ((CqlVisitor<? extends T>)visitor).visitField(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldContext field() throws RecognitionException {
		FieldContext _localctx = new FieldContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			_la = _input.LA(1);
			if ( !(((((_la - 36)) & ~0x3f) == 0 && ((1L << (_la - 36)) & ((1L << (F_AFFECTED_VERSION - 36)) | (1L << (F_APPROVALS - 36)) | (1L << (F_ASSIGNEE - 36)) | (1L << (F_ATTACHMENTS - 36)) | (1L << (F_CATEGORY - 36)) | (1L << (F_COMMENT - 36)) | (1L << (F_COMPONENT - 36)) | (1L << (F_CREATED - 36)) | (1L << (F_CREATED_DATE - 36)) | (1L << (F_CREATOR - 36)) | (1L << (F_CUSTOM_FIELD - 36)) | (1L << (F_CUSTOMER_REQUEST_TYPE - 36)) | (1L << (F_DATE - 36)) | (1L << (F_DESCRIPTION - 36)) | (1L << (F_DUE - 36)) | (1L << (F_DURATION - 36)) | (1L << (F_ENVIRONMENT - 36)) | (1L << (F_EPIC_LINK - 36)) | (1L << (F_FILTER - 36)) | (1L << (F_FIX_VERSION - 36)) | (1L << (F_ISSUE - 36)) | (1L << (F_ISSUE_KEY - 36)) | (1L << (F_ISSUE_TYPE - 36)) | (1L << (F_KEY - 36)) | (1L << (F_LABEL - 36)) | (1L << (F_LABELS - 36)) | (1L << (F_LAST_VIEWED - 36)) | (1L << (F_LEVEL - 36)) | (1L << (F_NUMBER - 36)) | (1L << (F_ORGANIZATION - 36)) | (1L << (F_ORIGINAL_ESTIMATE - 36)) | (1L << (F_PARENT - 36)) | (1L << (F_PRIORITY - 36)) | (1L << (F_PROJECT - 36)) | (1L << (F_RANK - 36)) | (1L << (F_REMAINING_ESTIMATE - 36)) | (1L << (F_REPORTER - 36)) | (1L << (F_REQUEST_CHANNEL_TYPE - 36)) | (1L << (F_REQUEST_LAST_ACTIVITY_TIME - 36)) | (1L << (F_RESOLUTION - 36)) | (1L << (F_RESOLUTION_DATE - 36)) | (1L << (F_RESOLVED - 36)) | (1L << (F_SLA - 36)) | (1L << (F_SPRINT - 36)) | (1L << (F_STATUS - 36)) | (1L << (F_SUMMARY - 36)) | (1L << (F_TEXT - 36)) | (1L << (F_TIME_SPENT - 36)) | (1L << (F_TYPE - 36)) | (1L << (F_UPDATED - 36)) | (1L << (F_USER - 36)) | (1L << (F_VERSION - 36)) | (1L << (F_VOTER - 36)) | (1L << (F_VOTES - 36)) | (1L << (F_WATCHER - 36)) | (1L << (F_WATCHERS - 36)) | (1L << (F_WORK_RATIO - 36)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Compare_datesContext extends ParserRuleContext {
		public DatesContext dates() {
			return getRuleContext(DatesContext.class,0);
		}
		public TerminalNode K_ON() { return getToken(CqlParser.K_ON, 0); }
		public TerminalNode K_AFTER() { return getToken(CqlParser.K_AFTER, 0); }
		public TerminalNode K_BEFORE() { return getToken(CqlParser.K_BEFORE, 0); }
		public Compare_datesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compare_dates; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CqlListener ) ((CqlListener)listener).enterCompare_dates(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CqlListener ) ((CqlListener)listener).exitCompare_dates(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CqlVisitor) return ((CqlVisitor<? extends T>)visitor).visitCompare_dates(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Compare_datesContext compare_dates() throws RecognitionException {
		Compare_datesContext _localctx = new Compare_datesContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_compare_dates);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << K_AFTER) | (1L << K_BEFORE) | (1L << K_ON))) != 0)) {
				{
				setState(186);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << K_AFTER) | (1L << K_BEFORE) | (1L << K_ON))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(189);
			dates();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DatesContext extends ParserRuleContext {
		public TerminalNode DATETIME() { return getToken(CqlParser.DATETIME, 0); }
		public DatesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dates; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CqlListener ) ((CqlListener)listener).enterDates(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CqlListener ) ((CqlListener)listener).exitDates(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CqlVisitor) return ((CqlVisitor<? extends T>)visitor).visitDates(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DatesContext dates() throws RecognitionException {
		DatesContext _localctx = new DatesContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_dates);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
			match(DATETIME);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3c\u00c4\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\7\2\36\n\2\f\2\16\2!\13\2\3\2\3\2\3"+
		"\3\7\3&\n\3\f\3\16\3)\13\3\3\3\3\3\6\3-\n\3\r\3\16\3.\3\3\7\3\62\n\3\f"+
		"\3\16\3\65\13\3\3\3\7\38\n\3\f\3\16\3;\13\3\3\4\7\4>\n\4\f\4\16\4A\13"+
		"\4\3\4\3\4\3\4\7\4F\n\4\f\4\16\4I\13\4\3\4\3\4\7\4M\n\4\f\4\16\4P\13\4"+
		"\7\4R\n\4\f\4\16\4U\13\4\3\4\7\4X\n\4\f\4\16\4[\13\4\3\4\5\4^\n\4\3\5"+
		"\7\5a\n\5\f\5\16\5d\13\5\3\5\3\5\5\5h\n\5\3\5\3\5\7\5l\n\5\f\5\16\5o\13"+
		"\5\3\5\3\5\3\5\3\5\5\5u\n\5\3\5\5\5x\n\5\3\5\7\5{\n\5\f\5\16\5~\13\5\3"+
		"\6\3\6\3\6\3\6\5\6\u0084\n\6\3\6\3\6\3\6\5\6\u0089\n\6\7\6\u008b\n\6\f"+
		"\6\16\6\u008e\13\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u00a3\n\7\3\b\3\b\3\b\3\b\3\b\5\b\u00aa\n"+
		"\b\3\t\3\t\3\t\3\t\7\t\u00b0\n\t\f\t\16\t\u00b3\13\t\3\t\3\t\3\n\3\n\3"+
		"\13\3\13\3\f\3\f\3\r\5\r\u00be\n\r\3\r\3\r\3\16\3\16\3\16\2\2\17\2\4\6"+
		"\b\n\f\16\20\22\24\26\30\32\2\7\4\2\26\26\"\"\4\2\27\27\33\33\4\2\25\33"+
		"\35%\3\2&^\5\2\25\25\30\30!!\2\u00e0\2\37\3\2\2\2\4\'\3\2\2\2\6?\3\2\2"+
		"\2\bb\3\2\2\2\n\177\3\2\2\2\f\u00a2\3\2\2\2\16\u00a9\3\2\2\2\20\u00ab"+
		"\3\2\2\2\22\u00b6\3\2\2\2\24\u00b8\3\2\2\2\26\u00ba\3\2\2\2\30\u00bd\3"+
		"\2\2\2\32\u00c1\3\2\2\2\34\36\5\4\3\2\35\34\3\2\2\2\36!\3\2\2\2\37\35"+
		"\3\2\2\2\37 \3\2\2\2 \"\3\2\2\2!\37\3\2\2\2\"#\7\2\2\3#\3\3\2\2\2$&\7"+
		"\7\2\2%$\3\2\2\2&)\3\2\2\2\'%\3\2\2\2\'(\3\2\2\2(*\3\2\2\2)\'\3\2\2\2"+
		"*\63\5\6\4\2+-\7\7\2\2,+\3\2\2\2-.\3\2\2\2.,\3\2\2\2./\3\2\2\2/\60\3\2"+
		"\2\2\60\62\5\6\4\2\61,\3\2\2\2\62\65\3\2\2\2\63\61\3\2\2\2\63\64\3\2\2"+
		"\2\649\3\2\2\2\65\63\3\2\2\2\668\7\7\2\2\67\66\3\2\2\28;\3\2\2\29\67\3"+
		"\2\2\29:\3\2\2\2:\5\3\2\2\2;9\3\2\2\2<>\7\t\2\2=<\3\2\2\2>A\3\2\2\2?="+
		"\3\2\2\2?@\3\2\2\2@B\3\2\2\2A?\3\2\2\2BS\5\b\5\2CG\t\2\2\2DF\7\t\2\2E"+
		"D\3\2\2\2FI\3\2\2\2GE\3\2\2\2GH\3\2\2\2HJ\3\2\2\2IG\3\2\2\2JN\5\b\5\2"+
		"KM\7\n\2\2LK\3\2\2\2MP\3\2\2\2NL\3\2\2\2NO\3\2\2\2OR\3\2\2\2PN\3\2\2\2"+
		"QC\3\2\2\2RU\3\2\2\2SQ\3\2\2\2ST\3\2\2\2TY\3\2\2\2US\3\2\2\2VX\7\n\2\2"+
		"WV\3\2\2\2X[\3\2\2\2YW\3\2\2\2YZ\3\2\2\2Z]\3\2\2\2[Y\3\2\2\2\\^\5\n\6"+
		"\2]\\\3\2\2\2]^\3\2\2\2^\7\3\2\2\2_a\7\37\2\2`_\3\2\2\2ad\3\2\2\2b`\3"+
		"\2\2\2bc\3\2\2\2cg\3\2\2\2db\3\2\2\2eh\5\26\f\2fh\5\16\b\2ge\3\2\2\2g"+
		"f\3\2\2\2hi\3\2\2\2im\5\f\7\2jl\7\t\2\2kj\3\2\2\2lo\3\2\2\2mk\3\2\2\2"+
		"mn\3\2\2\2nt\3\2\2\2om\3\2\2\2pu\5\16\b\2qu\5\20\t\2ru\7\3\2\2su\5\32"+
		"\16\2tp\3\2\2\2tq\3\2\2\2tr\3\2\2\2ts\3\2\2\2uw\3\2\2\2vx\5\30\r\2wv\3"+
		"\2\2\2wx\3\2\2\2x|\3\2\2\2y{\7\n\2\2zy\3\2\2\2{~\3\2\2\2|z\3\2\2\2|}\3"+
		"\2\2\2}\t\3\2\2\2~|\3\2\2\2\177\u0080\7#\2\2\u0080\u0081\7\31\2\2\u0081"+
		"\u0083\5\16\b\2\u0082\u0084\t\3\2\2\u0083\u0082\3\2\2\2\u0083\u0084\3"+
		"\2\2\2\u0084\u008c\3\2\2\2\u0085\u0086\7\13\2\2\u0086\u0088\5\16\b\2\u0087"+
		"\u0089\t\3\2\2\u0088\u0087\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u008b\3\2"+
		"\2\2\u008a\u0085\3\2\2\2\u008b\u008e\3\2\2\2\u008c\u008a\3\2\2\2\u008c"+
		"\u008d\3\2\2\2\u008d\13\3\2\2\2\u008e\u008c\3\2\2\2\u008f\u00a3\7\f\2"+
		"\2\u0090\u00a3\7\24\2\2\u0091\u00a3\7\16\2\2\u0092\u00a3\7\17\2\2\u0093"+
		"\u00a3\7\21\2\2\u0094\u00a3\7\20\2\2\u0095\u00a3\7\22\2\2\u0096\u00a3"+
		"\7\23\2\2\u0097\u00a3\7\35\2\2\u0098\u0099\7\37\2\2\u0099\u00a3\7\35\2"+
		"\2\u009a\u00a3\7\36\2\2\u009b\u00a3\7%\2\2\u009c\u009d\7\36\2\2\u009d"+
		"\u00a3\7\37\2\2\u009e\u009f\7%\2\2\u009f\u00a3\7\37\2\2\u00a0\u00a1\7"+
		"\32\2\2\u00a1\u00a3\7$\2\2\u00a2\u008f\3\2\2\2\u00a2\u0090\3\2\2\2\u00a2"+
		"\u0091\3\2\2\2\u00a2\u0092\3\2\2\2\u00a2\u0093\3\2\2\2\u00a2\u0094\3\2"+
		"\2\2\u00a2\u0095\3\2\2\2\u00a2\u0096\3\2\2\2\u00a2\u0097\3\2\2\2\u00a2"+
		"\u0098\3\2\2\2\u00a2\u009a\3\2\2\2\u00a2\u009b\3\2\2\2\u00a2\u009c\3\2"+
		"\2\2\u00a2\u009e\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a3\r\3\2\2\2\u00a4\u00aa"+
		"\7`\2\2\u00a5\u00aa\7_\2\2\u00a6\u00aa\5\24\13\2\u00a7\u00aa\5\26\f\2"+
		"\u00a8\u00aa\5\32\16\2\u00a9\u00a4\3\2\2\2\u00a9\u00a5\3\2\2\2\u00a9\u00a6"+
		"\3\2\2\2\u00a9\u00a7\3\2\2\2\u00a9\u00a8\3\2\2\2\u00aa\17\3\2\2\2\u00ab"+
		"\u00ac\7\t\2\2\u00ac\u00b1\5\16\b\2\u00ad\u00ae\7\13\2\2\u00ae\u00b0\5"+
		"\16\b\2\u00af\u00ad\3\2\2\2\u00b0\u00b3\3\2\2\2\u00b1\u00af\3\2\2\2\u00b1"+
		"\u00b2\3\2\2\2\u00b2\u00b4\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b4\u00b5\7\n"+
		"\2\2\u00b5\21\3\2\2\2\u00b6\u00b7\t\4\2\2\u00b7\23\3\2\2\2\u00b8\u00b9"+
		"\7\34\2\2\u00b9\25\3\2\2\2\u00ba\u00bb\t\5\2\2\u00bb\27\3\2\2\2\u00bc"+
		"\u00be\t\6\2\2\u00bd\u00bc\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\u00bf\3\2"+
		"\2\2\u00bf\u00c0\5\32\16\2\u00c0\31\3\2\2\2\u00c1\u00c2\7\4\2\2\u00c2"+
		"\33\3\2\2\2\32\37\'.\639?GNSY]bgmtw|\u0083\u0088\u008c\u00a2\u00a9\u00b1"+
		"\u00bd";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}