import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class KruskalPath {

    HashMap<Integer, Integer> parent = new HashMap<>();
    HashMap<Integer, Integer> rank = new HashMap<>();

    public int kruskalFunc(ArrayList<Integer> computers, ArrayList<Edge> edges) throws IOException {

        int minCost = 0;

        for (Integer computer : computers) {
            makeSet(computer);
        }
        Collections.sort(edges);
//        System.out.println("computers = " + computers);
//        System.out.println("edges = " + edges);
//        System.out.println("parent = " + parent);
//        System.out.println("rank = " + rank);

        for (Edge edge : edges) {
            if (find(edge.nodeV) != find(edge.nodeU)) {
                union(edge.nodeV, edge.nodeU);
                minCost += edge.weight;
            }
        }
        return minCost;
    }

    public void union(int nodeV, int nodeU) {
        int root1 = find(nodeV);
        int root2 = find(nodeU);

        if (rank.get(root1) > rank.get(root2)) {
            parent.put(root2, root1);
        } else {
            parent.put(root1, root2);
            if (rank.get(root1).equals(rank.get(root2))) {
                rank.put(root2, rank.get(root2) + 1);
            }
        }
    }

    public int find(int node) {
        if (parent.get(node) != node) {
            parent.put(node, find(parent.get(node)));
        }
        return parent.get(node);
    }

    public void makeSet(int node) {
        parent.put(node, node);
        rank.put(node, 0);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8));
        int computerNum = Integer.parseInt(br.readLine()); // 컴퓨터 수
        int lineNum = Integer.parseInt(br.readLine()); // 라인 수
        ArrayList<Edge> edges = new ArrayList<>();
        ArrayList<Integer> computers = new ArrayList<>();

        for (int i = 1; i <= computerNum; i++) {
            computers.add(i);
        }

        for (int i = 0; i < lineNum; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            edges.add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }


        KruskalPath kObject = new KruskalPath();
        int result = kObject.kruskalFunc(computers, edges);

        bw.write(result + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

}

class Edge implements Comparable<Edge> {

    public int nodeV;
    public int nodeU;
    public int weight;

    public Edge(int nodeV, int nodeU, int weight) {
        this.nodeV = nodeV;
        this.nodeU = nodeU;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "weight=" + weight +
                ", nodeV=" + nodeV +
                ", nodeU=" + nodeU +
                '}';
    }

    @Override
    public int compareTo(Edge edge) {
        return this.weight - edge.weight;
    }
}