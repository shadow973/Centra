package dev.conductor.centra.domain.search.cql.conditions;


public class IssueStatus extends AbstractCondition {

    @Override
    public String entityProperty() {
        return "workflowState.label";
    }

    @Override
    public SearchType searchType() {
        return SearchType.CRITERIA;
    }
}
