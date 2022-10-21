package dev.conductor.centra.domain.search.cql;

import dev.conductor.centra.domain.search.cql.conditions.*;
import org.antlr.v4.runtime.RuleContext;

import java.util.ArrayList;
import java.util.List;

public class CqlListenerImpl extends CqlBaseListener {

    private final List<Condition> conditions = new ArrayList<>();

    private Condition currentCondition;

    public List<Condition> getConditions() {
        return conditions;
    }

    @Override
    public void enterExpr(CqlParser.ExprContext ctx) {
        switch(stripQuotesFromString(ctx.getStart().getText())) {
            case "projectKey":
                this.currentCondition = new ProjectKeys();
                this.currentCondition.addValue(stripQuotesFromString(ctx.getStop().getText()));
                break;

            case "status":
                this.currentCondition = new IssueStatus();
                this.currentCondition.addValue(stripQuotesFromString(ctx.getStop().getText()));
                break;

            case "assignee":
                this.currentCondition = new Assignee();
                this.currentCondition.addValue(stripQuotesFromString(ctx.getStop().getText()));
                break;

            case "text":
            case "description":
            case "summary":
            case "title":
                this.currentCondition = new Description();
                this.currentCondition.addValue(stripQuotesFromString(ctx.getStop().getText()));
                break;

            case "label":
            case "labels":
                this.currentCondition = new Labels();
                this.currentCondition.addValue(stripQuotesFromString(ctx.getStop().getText()));
                break;

            case "createdByUserId":
            case "reporter":
                this.currentCondition = new Reporter();
                this.currentCondition.addValue(stripQuotesFromString(ctx.getStop().getText()));
                break;

            default:
                throw new IllegalArgumentException("Unknown parameter " + stripQuotesFromString(ctx.getStart().getText()));
        }
    }

    @Override
    public void exitExpr(CqlParser.ExprContext ctx) {
        this.conditions.add(this.currentCondition);
    }

    @Override
    public void enterOperator(CqlParser.OperatorContext ctx) {
        Operator operator = switch (ctx.getStop().getText()) {
            case "=" -> Operator.EQUALS;
            case "~" -> Operator.LIKE;
            case "IN" -> Operator.IN;
            default -> throw new IllegalStateException("Unexpected value: " + ctx.getStop().getText());
        };

        this.currentCondition.setOperator(operator);
    }

    @Override public void enterLiteral_list(CqlParser.Literal_listContext ctx) {
        this.currentCondition.setValue(ctx.literal_value().stream().map(RuleContext::getText).map(this::stripQuotesFromString).toList());
    }

    protected String stripQuotesFromString(String input) {
        return input
                .replace("\"", "")
                .replace("'", "");
    }
}
