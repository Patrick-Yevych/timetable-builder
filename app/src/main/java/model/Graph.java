package model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Graph {

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
    }

    private void insertEdge(int in, int to) {
        int i;
        int d = Section.dist(this.V.get(in), this.V.get(to));
        for (i = 0; i < this.V.size()-1; i++) {
            if (d <= Section.dist(this.V.get(in), this.V.get(i)));
                break;
        }
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

    public ArrayList<Section> minimize(int required) {
        ArrayList<Section> res = new ArrayList<Section>();
        Integer[] curr_tt = new Integer[this.V.size()];
        Integer[] best_tt = new Integer[this.V.size()];
        Integer[] avail = new Integer[this.V.size()];

        Integer best_dt = 9999;
        Integer curr_dt = 0;
        Integer best_size = 0;

        for (int i = 0; i < this.V.size(); i++) {
            avail[i] = this.V.size();
            curr_tt[i] = 0;
            best_tt[i] = 0;
        }

        curr_tt[required] = 1;

        _path(required, avail, curr_tt, best_tt, curr_dt, best_dt, best_size, 1);

        return res;
    }

    private void _path(int curr, Integer[] avail, Integer[] curr_tt, Integer[] best_tt, Integer curr_dt, Integer best_dt, Integer best_size, int depth) {
        for (int i = 0; i < this.E.get(curr).size(); i++) {
            avail[this.E.get(curr).get(i).getVertex()]++;
            if (avail[this.E.get(curr).get(i).getVertex()] > this.V.size()) {
                this.E.get(curr).get(i).setVisited(true);
            }
        }

        
    }
}
