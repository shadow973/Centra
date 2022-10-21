package dev.conductor.centra.domain.search.cql.conditions;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractCondition implements Condition {

    protected Operator operator;
    protected List<String> value = new ArrayList<>();

    @Override
    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    @Override
    public Operator getOperator() {
        return this.operator;
    }

    @Override
    public List<String> getValue() {
        return this.value;
    }

    @Override
    public void setValue(List<String> value) {
        this.value = value;
    }

    @Override
    public void addValue(String value) {
        this.value.add(value);
    }
}
