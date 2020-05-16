package com.dghanwat.neo4j.constraint.evaluator;

import com.dghanwat.neo4j.constraint.schema.Labels;
import com.dghanwat.neo4j.constraint.schema.Properties;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Path;
import org.neo4j.graphdb.traversal.Evaluation;
import org.neo4j.graphdb.traversal.Evaluator;
import org.neo4j.logging.Log;

import java.util.Arrays;
import java.util.List;

public class ValidPathEvaluator implements Evaluator {

    // This gives us a log instance that outputs messages to the
    // standard log, normally found under `data/log/neo4j.log`
    private final Log log;

    private List<String> INVALID_COMBINATIONS = Arrays.asList("WG","GC");

    public ValidPathEvaluator(Log log) {
        this.log = log;
    }

    public Evaluation evaluate(Path path) {
        Node last = path.endNode();
        String attribute = (String) last.getProperty(Properties.ATTRIBUTE);
        String[] elements = attribute.split("_");
        for (String element : elements) {
            if(INVALID_COMBINATIONS.contains(element)) {
                last.addLabel(Labels.InvalidState);
                return Evaluation.EXCLUDE_AND_PRUNE; // We have found an invalid path, do not progress further
            }
        }

        return Evaluation.INCLUDE_AND_CONTINUE; // Include the current node and continue moving forward
    }
}
