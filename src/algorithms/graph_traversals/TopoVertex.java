package algorithms.graph_traversals;

import java.util.ArrayList;
import java.util.List;

public class TopoVertex {
    public String label;
    public List<TopoVertex> edges = new ArrayList<>();
    public int maxDistance = 0;

    public TopoVertex(String label) {
        this.label = label;
    }
}