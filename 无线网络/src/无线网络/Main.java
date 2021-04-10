package 无线网络;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
 
class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		int n = Integer.parseInt(line[0]), m = Integer.parseInt(line[1]), k = Integer.parseInt(line[2]);
		long r = Long.parseLong(line[3]);
		ArrayList<Node> dic = new ArrayList<Node>();//所有点
		LinkedList<Node> q = new LinkedList<Node>();//开始端
		boolean[] flag = new boolean[n+m+1];
		
		//不需要使用k
		for ( int i = 0; i < n; i++ ) {
			line = br.readLine().split(" ");
			long x = Long.parseLong(line[0]), y = Long.parseLong(line[1]);
			dic.add(new Node(x, y));//收入除起点外的所有点
		}
		
		//需要使用k
		for ( int i = 0; i < m; i++ ) {
			line = br.readLine().split(" ");
			long x = Long.parseLong(line[0]), y = Long.parseLong(line[1]);
			dic.add(new Node(x, y, true));
		}
		
		Node temp = dic.get(0);//取出起始点
		temp.cnt = 0;
		temp.k = k;
		
		q.add(temp);
		flag[0] = true;
		
		out:
		while ( !q.isEmpty() ) {//BFS
			Node node = q.get(0);
			q.remove(0);
			
			for ( int i = 1; i < dic.size(); i++ ) {
				if ( !flag[i] && isUnicon(node, dic.get(i), r) ) {//如果能联通
					
					if ( dic.get(i).flag && node.k > 0 ) {//如果需要k
						q.add(new Node(dic.get(i).x, dic.get(i).y, k-1, node.cnt+1));
					} else if ( !dic.get(i).flag ) {//如果不需要k
						q.add(new Node(dic.get(i).x, dic.get(i).y, k, node.cnt+1));
					} else continue;
					
					flag[i] = true;
					if ( i == 1 ) {//到达终点
						System.out.println(node.cnt);
						break out;
					}
					
				}
			}
		}
	}
	
	//判断是否能连接
	public static boolean isUnicon( Node node1, Node node2 , long r ) {
		return (node1.x-node2.x)*(node1.x-node2.x) + (node1.y-node2.y)*(node1.y-node2.y) <= r*r;
	}
}
class Node {
	long x,y,k,cnt;//x,y,k,次数
	boolean flag;//是否需要k
	
	public Node(long x, long y) {
		this.x = x;
		this.y = y;
	}
	public Node(long x, long y, boolean flag) {
		this.x = x;
		this.y = y;
		this.flag = flag;
	}
	public Node(long x, long y, long k, long cnt) {
		this.x = x;
		this.y = y;
		this.k = k;
		this.cnt = cnt;
	}
	@Override
	public String toString() {
		return "x=" + x + ", y=" + y + ", k=" + k + ", cnt=" + cnt + ", flag=" + flag;
	}
	
}  
