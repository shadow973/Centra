package dev.conductor.centra.domain.search.cql.conditions;

public class Description extends AbstractCondition {
    @Override
    public String entityProperty() {
        return "description";
    }

    @Override
    public SearchType searchType() {
        return SearchType.TEXT;
    }
}
