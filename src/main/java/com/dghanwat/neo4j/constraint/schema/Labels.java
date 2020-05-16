package com.dghanwat.neo4j.constraint.schema;

import org.neo4j.graphdb.Label;

public enum Labels implements Label {
    State,
    InitialState,
    FinalState,
    InvalidState
}
