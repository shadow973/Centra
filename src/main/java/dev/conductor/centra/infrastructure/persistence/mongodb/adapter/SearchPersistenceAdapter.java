package dev.conductor.centra.infrastructure.persistence.mongodb.adapter;

import dev.conductor.centra.domain.issue.entity.Issue;
import dev.conductor.centra.domain.search.cql.conditions.Condition;
import dev.conductor.centra.domain.search.spi.SearchPersistencePort;
import dev.conductor.centra.infrastructure.persistence.mongodb.entity.IssueEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class SearchPersistenceAdapter implements SearchPersistencePort {

    private final MongoOperations mongoOperations;
    private final ModelMapper modelMapper;

    @Autowired
    public SearchPersistenceAdapter(MongoOperations mongoOperations, ModelMapper modelMapper) {
        this.mongoOperations = mongoOperations;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<Issue> find(List<Condition> conditions) {

        Query query = new Query();

        for (Condition condition: conditions) {
            switch (condition.searchType()){
                case CRITERIA:
                    buildQueryForCriteriaField(query, condition);
                    break;

                case TEXT:
                    buildQueryForTextField(query, condition);
                    break;
            }
        }

        return mongoOperations.find(query, IssueEntity.class).stream().map(
                issueEntity -> modelMapper.map(issueEntity, Issue.class)
        ).collect(Collectors.toList());
    }

    private void buildQueryForCriteriaField(Query query, Condition condition) {

        if (condition.getValue().isEmpty()){
            return;
        }

        switch (condition.getOperator()) {
            case EQUALS :
                query.addCriteria(Criteria.where(condition.entityProperty()).is(condition.getValue().get(0)));
                break;

            case NOT_EQUALS:
                query.addCriteria(Criteria.where(condition.entityProperty()).ne(condition.getValue().get(0)));
                break;

            case GREATER_THAN:
                query.addCriteria(Criteria.where(condition.entityProperty()).gt(condition.getValue().get(0)));
                break;

            case LESS_THAN:
                query.addCriteria(Criteria.where(condition.entityProperty()).lt(condition.getValue().get(0)));
                break;

            case LIKE:
                query.addCriteria(Criteria.where(condition.entityProperty()).regex(((String)condition.getValue().get(0)), "i"));
                break;

            case IN:
                query.addCriteria(Criteria.where(condition.entityProperty()).in(condition.getValue()));
                break;

        }
    }

    private void buildQueryForTextField(Query query, Condition condition) {
        query.addCriteria(TextCriteria.forDefaultLanguage().matchingAny(String.valueOf(condition.getValue())));
    }
}
