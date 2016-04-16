package base.Algorithm;

import java.util.Queue;
import java.util.LinkedList;

public class BFS {
	int map[][];	//	맵
	int visit[];	//	방문배열
	int n;	 			
	
	Queue<Integer> bfsQue = new LinkedList<Integer>();
	
	public BFS(int map[][], int visitSize){
		this.map = map;
		visit = new int[visitSize+1];
		this.n = visitSize;
	}
	
	public void doAl(int v){
		visit[v] = 1;	// 정점 v 방문
		System.out.println(v + "에서 시작");
		bfsQue.add(v);
		
		while(!bfsQue.isEmpty()){
			v = bfsQue.poll();	// 큐에서 하나 꺼내서 v에 저장
			
			for(int i = 1; i <= n; i++){
				// 정점 v 와 i 가 만나고 i를 방문하지 않았을 때
				if(map[v][i] == 1 && visit[i] == 0){
					visit[i] = 1; // i방문
					System.out.println(v + "에서" + i + "로 이동");
					bfsQue.add(i);
				}
			}
		}
	}
}
