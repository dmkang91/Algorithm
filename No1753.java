import java.util.Scanner;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class No1753{
	public static void main(String args[]) throws Exception{
		//Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new FileInputStream("input.txt"));
		
		int vertexNum, pathNum, startVertex, result;
		int data[][];
		List<Integer> list;
		
		vertexNum = sc.nextInt();
		pathNum = sc.nextInt();
		startVertex = sc.nextInt();
		
		data = new int[pathNum][3];
		for(int i = 0; i < pathNum; i++){ 
			data[i][0] = sc.nextInt();
			data[i][1] = sc.nextInt();
			data[i][2] = sc.nextInt();
		}
		Dijkstra dijk = new Dijkstra();
		result = dijk.proc(data, startVertex, vertexNum, pathNum);
		System.out.println(result);
		list = dijk.getPreviousVertex();
		for(int i = 0; i < list.size(); i++){
			System.out.print(list.get(i));
		}
	}
}
class Dijkstra{
	int INF = 100000000;
	List<Integer> route;
	
		
	Dijkstra(){	
		route = new ArrayList<Integer>();
	}
	
	int proc(int data[][], int startVertex, int vertexNum, int pathNum){
		int distance[];	// ���� �˰� �ִ� �ش� �������� ���� �ִܰŸ� ����
		int vertexQ[], vertexS[];	// Q�� ���� ���� ��� ����, S�� �Ŀ� ä�� ���� ����
		int nextVertex, minRouteVal;	// ���� ������ ������ ������ �ּ� �Ÿ�
		int preVertex;
		int []previous;	// ���� ���� ����
		
		distance = new int[vertexNum+1];
		previous = new int[vertexNum+1];
		vertexQ = new int[vertexNum+1]; vertexS = new int[vertexNum+1];
		
		for(int i = 1; i <= vertexNum; i++){
			distance[i] = INF;
			previous[i] = -1;	// undefined
			vertexQ[i] = i;	// ���� ��ȣ 1 ~ vertexNum
			vertexS[i] = 0;	// ���� ������� ǥ��
		}
		distance[startVertex] = 0; 	// ���� �������� ���� ���� ���� ������ �Ÿ��� 0
		
		while(!isEmpty(vertexQ)){
			nextVertex = Extract_min(distance, vertexQ);
			if(nextVertex == INF){
				return INF;
			}
			vertexS[nextVertex] = nextVertex;
			
			for(int k = 1; k <= vertexNum; k++){
				if(vertexS[k] != 0) continue;
				if(distance[k] > distance[nextVertex] + find_distance(nextVertex, k, data, pathNum)){
					distance[k] = distance[nextVertex] + find_distance(nextVertex, k, data, pathNum);
					previous[k] = nextVertex;
				}
			}
			vertexQ[nextVertex] = 0;	// Q���� ã�� ������ ����ش�
		}
		minRouteVal = distance[vertexNum];
		
		preVertex = previous[vertexNum];
		route.add(vertexNum);
		while(true){
			if(previous[preVertex] == -1){
				route.add(startVertex);
				break;
			}
			route.add(preVertex);
			preVertex = previous[preVertex];
		}
		Collections.reverse(route);
		for( int i = 0; i < vertexNum; i++){
			System.out.println(distance[i]);
		}
		
		return minRouteVal;
	}
	
	int Extract_min(int []distance, int []vertexQ){
		int min = INF;
		for(int i = 1; i <= distance.length - 1; i++){
			if(min > distance[i] && vertexQ[i] != 0){
				min = i;
			}
		}
		return min;
	}
	
	boolean isEmpty(int []list){
		for(int i = 0; i < list.length; i++){
			if(list[i] != 0){ return false; }
		}
		return true;
	}
	
	int find_distance(int u, int v, int data[][], int pathNum){
		for(int i = 0; i < pathNum; i++){
			if(data[i][0] == u && data[i][1] == v){
				return data[i][2];
			} 
			/*else if(data[i][1] == u && data[i][0] == v){
				return data[i][2];
			}*/
		}
		return INF;
	}
	List<Integer> getPreviousVertex(){
		return this.route;
	}
}