package org.csu.AUG.model;

import org.csu.AUG.visitor.EdgeVisitor;

import java.io.Serializable;

public interface Edge extends Cloneable, Serializable {
    enum Type {
        RECEIVER("recv"),
        PARAMETER("para"),
        DEFINITION("def"),
        THROW("throw"),
        SYNCHRONIZE("syn"),
        CONDITION("cond"),
        ORDER("order"),
        CONTAINS("contains"),
        FINALLY("finally"),
        QUALIFIER("qual"),
        EXCEPTION_HANDLING("hdl");

        private final String label;

        Type(String label) {
            this.label = label;
        }

        public String getLabel() {
            return label;
        }
    }

    Node getSource();

    Node getTarget();


    @Deprecated
    Type getType();

    default boolean isDirect() {
        return true;
    }

    Edge clone();

    Edge clone(Node newSourceNode, Node newTargetNode);

    <R> R apply(EdgeVisitor<R> visitor);
}
