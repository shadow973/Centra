package dev.conductor.centra.domain.issue.api.impl;

import dev.conductor.centra.domain.applicationUser.entity.ApplicationUser;
import dev.conductor.centra.domain.issue.api.IssueCommentService;
import dev.conductor.centra.domain.issue.entity.Issue;
import dev.conductor.centra.domain.issue.entity.IssueComment;
import dev.conductor.centra.infrastructure.persistence.mongodb.adapter.IssueCommentPersistenceAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class IssueCommentServiceAdapter implements IssueCommentService {

    @Autowired
    private IssueCommentPersistenceAdapter persistenceAdapter;

    @Override
    public List<IssueComment> findByIssueId(String issueId) {
        return persistenceAdapter.findByIssueIdOrderByCreatedDateAsc(issueId);
    }

    @Override
    public IssueComment create(Issue issue, ApplicationUser user, String text) {
        IssueComment comment = new IssueComment();
        comment.setIssueId(issue.getId());
        comment.setText(text);
        comment.setCreatedDate(new Date());
        comment.setCreatedByUserId(user.getId());

        return persistenceAdapter.save(comment);
    }
}
