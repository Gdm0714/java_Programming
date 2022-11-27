package home05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Dijkstra {

    public static class Vertex implements Comparable<Vertex> {
        int v, weight;

        public Vertex(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }

        @Override
        public int compareTo(Vertex o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("정점 개수: ");
        int v = Integer.parseInt(br.readLine());
        int end = v - 1;
        int adj[][] = new int[v][v];
        int dist[] = new int[v];
        int count = 0;
        for (int i = 0; i < v; i++) {
            System.out.print("정점" + (i + 1) + "에서 각 정점까지의 거리: ");
            String input2[] = br.readLine().split(" ");
            for (int j = 0; j < v; j++) {
                adj[i][j] = Integer.parseInt(input2[j]);
            }
        }
        boolean selected[] = new boolean[v];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        int min = 0;
        int cur = 0;
        for (int i = 0; i < v; i++) {
            min = Integer.MAX_VALUE;
            for (int j = 0; j < v; j++) {
                if (!selected[j] && dist[j] < min) {
                    min = dist[j];
                    cur = j;
                }
            }
            if (selected[cur]) continue;
            selected[cur] = true;
            if (cur == end) break;

            for (int j = 0; j < v; j++) {
                if (!selected[j] && adj[cur][j] != 0 && min + adj[cur][j] < dist[j]) {
                    dist[j] = min + adj[cur][j];
                }
            }
            System.out.println("시작 지점에서 정점" + (count + 1) + "까지의 최소 거리" + dist[count]);
            count++;
        }
        System.out.println("시작 지점에서 정점" + (end + 1) + "까지의 최소 거리" + dist[end]);
    }
}
/*      7
        정점1에서 각 정점까지의 거리: 0 7 100 100 3 10 100
        정점2에서 각 정점까지의 거리: 7 0 4 10 2 6 100
        정점3에서 각 정점까지의 거리: 100 4 0 2 100 100 100
        정점4에서 각 정점까지의 거리: 100 10 2 0 11 9 4
        정점5에서 각 정점까지의 거리: 100 10 2 0 11 9 4
        정점6에서 각 정점까지의 거리: 10 6 100 9 100 0 100
        정점7에서 각 정점까지의 거리: 100 100 100 4 5 100 0*/
