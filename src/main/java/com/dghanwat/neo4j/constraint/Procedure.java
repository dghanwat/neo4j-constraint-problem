package com.dghanwat.neo4j.constraint;

import com.dghanwat.neo4j.constraint.evaluator.ValidPathEvaluator;
import com.dghanwat.neo4j.constraint.expander.ValidPathExpander;
import com.dghanwat.neo4j.constraint.response.Response;
import com.dghanwat.neo4j.constraint.schema.Labels;
import com.dghanwat.neo4j.constraint.schema.Properties;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Path;
import org.neo4j.graphdb.traversal.TraversalDescription;
import org.neo4j.graphdb.traversal.Traverser;
import org.neo4j.graphdb.traversal.Uniqueness;
import org.neo4j.logging.Log;
import org.neo4j.procedure.Context;
import org.neo4j.procedure.Description;
import org.neo4j.procedure.Mode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Procedure {

    // This field declares that we need a GraphDatabaseService
    // as context when any procedure in this class is invoked
    @Context
    public GraphDatabaseService db;

    // This gives us a log instance that outputs messages to the
    // standard log, normally found under `logs/neo4j.log`
    @Context
    public Log log;

    @org.neo4j.procedure.Procedure(name = "com.dghanwat.neo4j.constraint.findValidPaths", mode = Mode.WRITE)
    @Description("CALL com.dghanwat.neo4j.constraint.findValidPaths()")
    public Stream<Response> findValidPaths() {
        List<Response> responseList = new ArrayList<>();
        Node initialState = db.findNode(Labels.InitialState, Properties.ATTRIBUTE, "FWGC_");
        Node finalState = db.findNode(Labels.FinalState, Properties.ATTRIBUTE, "_FWGC");
        ValidPathEvaluator validPathEvaluator = new ValidPathEvaluator(log);
        ValidPathExpander validPathExpander = new ValidPathExpander(log);
        TraversalDescription traversal = this.db.traversalDescription()
                .depthFirst()
                .expand(validPathExpander)
                .uniqueness(Uniqueness.NODE_PATH)
                .evaluator(validPathEvaluator);
        Traverser paths = traversal.traverse(initialState);
        for (Path path : paths) {
            if (path.endNode().getId() == finalState.getId()) {
                Response response = new Response();
                response.setPath(path);
                responseList.add(response);
            }
        }
        return responseList.stream();
    }
}
