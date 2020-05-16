package com.dghanwat.neo4j.constraint.expander;

import org.neo4j.graphdb.*;
import org.neo4j.graphdb.traversal.BranchState;
import org.neo4j.logging.Log;

public class ValidPathExpander implements PathExpander {
    // This gives us a log instance that outputs messages to the
    // standard log, normally found under `data/log/neo4j.log`
    private final Log log;

    public ValidPathExpander(Log log) {
        this.log = log;
    }

    @Override
    public Iterable<Relationship> expand(Path path, BranchState branchState) {
        Node last = path.endNode();

        // By Default expand
        return last.getRelationships(Direction.OUTGOING);
    }

    @Override
    public PathExpander reverse() {
        return null;
    }
}
