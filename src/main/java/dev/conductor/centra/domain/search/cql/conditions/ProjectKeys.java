package dev.conductor.centra.domain.search.cql.conditions;


public class ProjectKeys extends AbstractCondition {

    @Override
    public String entityProperty() {
        return "projectId";
    }

    @Override
    public SearchType searchType() {
        return SearchType.CRITERIA;
    }
}
