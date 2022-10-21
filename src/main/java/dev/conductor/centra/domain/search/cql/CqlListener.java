package dev.conductor.centra.domain.search.cql;// Generated from /Users/shamil/Documents/Projects/conductor.dev/data-services/src/main/antlr4/dev/conductor/cql/cql.g4 by ANTLR 4.8
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CqlParser}.
 */
public interface CqlListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CqlParser#parse}.
	 * @param ctx the parse tree
	 */
	void enterParse(CqlParser.ParseContext ctx);
	/**
	 * Exit a parse tree produced by {@link CqlParser#parse}.
	 * @param ctx the parse tree
	 */
	void exitParse(CqlParser.ParseContext ctx);
	/**
	 * Enter a parse tree produced by {@link CqlParser#cql_stmt_list}.
	 * @param ctx the parse tree
	 */
	void enterCql_stmt_list(CqlParser.Cql_stmt_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link CqlParser#cql_stmt_list}.
	 * @param ctx the parse tree
	 */
	void exitCql_stmt_list(CqlParser.Cql_stmt_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link CqlParser#cql_stmt}.
	 * @param ctx the parse tree
	 */
	void enterCql_stmt(CqlParser.Cql_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link CqlParser#cql_stmt}.
	 * @param ctx the parse tree
	 */
	void exitCql_stmt(CqlParser.Cql_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link CqlParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(CqlParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link CqlParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(CqlParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link CqlParser#ordering_term}.
	 * @param ctx the parse tree
	 */
	void enterOrdering_term(CqlParser.Ordering_termContext ctx);
	/**
	 * Exit a parse tree produced by {@link CqlParser#ordering_term}.
	 * @param ctx the parse tree
	 */
	void exitOrdering_term(CqlParser.Ordering_termContext ctx);
	/**
	 * Enter a parse tree produced by {@link CqlParser#operator}.
	 * @param ctx the parse tree
	 */
	void enterOperator(CqlParser.OperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CqlParser#operator}.
	 * @param ctx the parse tree
	 */
	void exitOperator(CqlParser.OperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CqlParser#literal_value}.
	 * @param ctx the parse tree
	 */
	void enterLiteral_value(CqlParser.Literal_valueContext ctx);
	/**
	 * Exit a parse tree produced by {@link CqlParser#literal_value}.
	 * @param ctx the parse tree
	 */
	void exitLiteral_value(CqlParser.Literal_valueContext ctx);
	/**
	 * Enter a parse tree produced by {@link CqlParser#literal_list}.
	 * @param ctx the parse tree
	 */
	void enterLiteral_list(CqlParser.Literal_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link CqlParser#literal_list}.
	 * @param ctx the parse tree
	 */
	void exitLiteral_list(CqlParser.Literal_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link CqlParser#keyword}.
	 * @param ctx the parse tree
	 */
	void enterKeyword(CqlParser.KeywordContext ctx);
	/**
	 * Exit a parse tree produced by {@link CqlParser#keyword}.
	 * @param ctx the parse tree
	 */
	void exitKeyword(CqlParser.KeywordContext ctx);
	/**
	 * Enter a parse tree produced by {@link CqlParser#state_name}.
	 * @param ctx the parse tree
	 */
	void enterState_name(CqlParser.State_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link CqlParser#state_name}.
	 * @param ctx the parse tree
	 */
	void exitState_name(CqlParser.State_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link CqlParser#field}.
	 * @param ctx the parse tree
	 */
	void enterField(CqlParser.FieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link CqlParser#field}.
	 * @param ctx the parse tree
	 */
	void exitField(CqlParser.FieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link CqlParser#compare_dates}.
	 * @param ctx the parse tree
	 */
	void enterCompare_dates(CqlParser.Compare_datesContext ctx);
	/**
	 * Exit a parse tree produced by {@link CqlParser#compare_dates}.
	 * @param ctx the parse tree
	 */
	void exitCompare_dates(CqlParser.Compare_datesContext ctx);
	/**
	 * Enter a parse tree produced by {@link CqlParser#dates}.
	 * @param ctx the parse tree
	 */
	void enterDates(CqlParser.DatesContext ctx);
	/**
	 * Exit a parse tree produced by {@link CqlParser#dates}.
	 * @param ctx the parse tree
	 */
	void exitDates(CqlParser.DatesContext ctx);
}