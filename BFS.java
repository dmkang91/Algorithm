package base.Algorithm;

import java.util.Queue;
import java.util.LinkedList;

public class BFS {
	int map[][];	//	��
	int visit[];	//	�湮�迭
	int n;	 			
	
	Queue<Integer> bfsQue = new LinkedList<Integer>();
	
	public BFS(int map[][], int visitSize){
		this.map = map;
		visit = new int[visitSize+1];
		this.n = visitSize;
	}
	
	public void doAl(int v){
		visit[v] = 1;	// ���� v �湮
		System.out.println(v + "���� ����");
		bfsQue.add(v);
		
		while(!bfsQue.isEmpty()){
			v = bfsQue.poll();	// ť���� �ϳ� ������ v�� ����
			
			for(int i = 1; i <= n; i++){
				// ���� v �� i �� ������ i�� �湮���� �ʾ��� ��
				if(map[v][i] == 1 && visit[i] == 0){
					visit[i] = 1; // i�湮
					System.out.println(v + "����" + i + "�� �̵�");
					bfsQue.add(i);
				}
			}
		}
	}
}
