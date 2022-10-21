package dev.conductor.centra.domain.search.api;

import dev.conductor.centra.domain.issue.entity.Issue;
import dev.conductor.centra.domain.search.cql.conditions.Condition;

import java.util.List;

public interface SearchService {

    List<Issue> search(List<Condition> conditions);
}
