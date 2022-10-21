package dev.conductor.centra.domain.search.cql.conditions;

import java.util.List;

public interface Condition {
    void setOperator(Operator operator);
    Operator getOperator();
    String entityProperty();
    List<String> getValue();
    void setValue(List<String> value);
    void addValue(String value);
    SearchType searchType();

}
