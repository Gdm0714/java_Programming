package home05;
import java.io.*;
import java.util.Arrays;

public class Prim {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("정점 개수:");
        int v = Integer.parseInt(br.readLine());
        System.out.print("간선 개수:");
        int e = Integer.parseInt(br.readLine());

        int adj[][] = new int[v][v];
        int result = 0;

        for(int i = 0; i < e; i++) {
            System.out.print("첫번째 정점:");
            int a = Integer.parseInt(br.readLine()) - 1;
            System.out.print("두번째 정점:");
            int b = Integer.parseInt(br.readLine()) - 1;
            System.out.print("정점간의 거리");
            int c = Integer.parseInt(br.readLine());
            adj[a][b] = c;
            adj[b][a] = c;
        }

        boolean visited[] = new boolean[v];
        int distance[] = new int[v];

        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[0] = 0;
        int cnt = 0;

        while(true) {
            int min = Integer.MAX_VALUE;
            int idx = 0;
            for(int i = 0; i < v; i++) {
                if(!visited[i] && distance[i] < min) {
                    idx = i;
                    min = distance[i];
                }
            }

            visited[idx] = true;
            System.out.println("정점" + idx + " 추가");
            result += min;
            cnt++;
            if(cnt == v) break;
            for(int i = 0; i < v; i++) {
                if(!visited[i] && adj[idx][i] > 0 && distance[i] > adj[idx][i]) {
                    distance[i] = adj[idx][i];
                }
            }
        }

        System.out.println("최소 비용 신장 트리 거리의 합: " + result);
    }
}