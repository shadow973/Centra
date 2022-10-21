package dev.conductor.centra.domain.search.cql;// Generated from /Users/shamil/Documents/Projects/conductor.dev/data-services/src/main/antlr4/dev/conductor/cql/cql.g4 by ANTLR 4.8
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CqlParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CqlVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CqlParser#parse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParse(CqlParser.ParseContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#cql_stmt_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCql_stmt_list(CqlParser.Cql_stmt_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#cql_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCql_stmt(CqlParser.Cql_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(CqlParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#ordering_term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrdering_term(CqlParser.Ordering_termContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperator(CqlParser.OperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#literal_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral_value(CqlParser.Literal_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#literal_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral_list(CqlParser.Literal_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#keyword}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeyword(CqlParser.KeywordContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#state_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitState_name(CqlParser.State_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#field}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitField(CqlParser.FieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#compare_dates}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompare_dates(CqlParser.Compare_datesContext ctx);
	/**
	 * Visit a parse tree produced by {@link CqlParser#dates}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDates(CqlParser.DatesContext ctx);
}