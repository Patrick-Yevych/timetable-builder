package model;

public class Edge {
    private int weight;
    private int vertex;
    private boolean visited;

    public Edge(int weight, int vertex) {
        this.weight = 0;
        this.vertex = 0;
        this.visited = false;

        this.setVertex(vertex);
        this.setWeight(weight);
    }

    public int getWeight() { return this.weight; }
    public void setWeight(int dist) { this.weight = dist; }
    public int getVertex() { return this.vertex; }
    public void setVertex(int vertex) { this.vertex = vertex; }
    public void setVisited(boolean val) { this.visited = val; }
    public boolean getVisited() { return this.visited; }
}
