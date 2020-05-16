package com.dghanwat.neo4j.constraint.schema;

import org.neo4j.graphdb.RelationshipType;

public enum RelationshipTypes implements RelationshipType {
    takes_wolf,
    takes_goat,
    takes_carrots,
    returns_goat,
    returns_wolf,
}
