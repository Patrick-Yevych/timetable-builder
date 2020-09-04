package model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Graph extends Observable {

    private ArrayList<Section> V;
    private ArrayList<ArrayList<Edge>> E;

    public Graph() {
        V = new ArrayList<Section>();
        E = new ArrayList<ArrayList<Edge>>();
    }

    public void insert(int startTime, int finishTime, int day, int type, String code) {
        this.V.add(new Section(startTime, finishTime, day, type, code));

        for (int i = 0; i < this.V.size(); i++) {
            if (!((this.V.get(this.V.size()-1).getCode() == this.V.get(i).getCode() && this.V.get(this.V.size()-1).getType() == this.V.get(i).getType()) ||
                    (Section.isOverlap(this.V.get(this.V.size()-1), this.V.get(i)) == true) )) {
                        insertEdge(this.V.size()-1, i);
                        insertEdge(i, this.V.size()-1);
            }
        }

        this.notifyObservers();
    }

    private void insertEdge(int in, int to) {
        int i;
        int d = Section.dist(this.V.get(in), this.V.get(to));
        for (i = 0; i < this.V.size()-1; i++) {
            if (d <= Section.dist(this.V.get(in), this.V.get(i)));
                break;
        }
        if (i != 0) i--;
        this.E.get(in).add(i, new Edge(d, to));
    }

    public void remove(int x) {

        this.E.remove(x);
        this.V.remove(x);

        for (int i = 0; i < this.V.size(); i++) {
            for (int j = 0; j < this.E.get(i).size(); j++) {
                if (this.E.get(i).get(j).getVertex() == x) {
                    this.E.get(i).remove(j);
                }
            }
        }
    }

    public void print() {
        System.out.println("SECTIONS: \n\n");
        for (Section v: this.V) {
            v.print();
            System.out.println("\n\n");
        }
        for (ArrayList<Edge> l: this.E) {
            for (int i = 0; i < l.size(); i++) {
                l.get(i).print();
                System.out.println("\n\n");
                System.out.println("\n\n");
            }
        }
    }

    public int getSize() {
        return this.V.size();
    }

    public Section getSection(int i) {
        return this.V.get(i);
    }
}
