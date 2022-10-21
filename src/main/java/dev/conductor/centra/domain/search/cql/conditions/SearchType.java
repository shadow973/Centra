package dev.conductor.centra.domain.search.cql.conditions;

public enum SearchType {
    CRITERIA("Criteria"),
    TEXT("TextCriteria");

    private final String searchTypeString;

    SearchType(String searchType) {
        this.searchTypeString = searchType;
    }

    @Override
    public String toString() {
        return searchTypeString;
    }
}
