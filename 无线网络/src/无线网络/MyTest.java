package 无线网络;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;




public class MyTest {
	public static void main(String[] args) throws IOException {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		String[] lineStrings = bReader.readLine().split(" ");
		int n = Integer.parseInt(lineStrings[0]),
			m = Integer.parseInt(lineStrings[1]),
			k = Integer.parseInt(lineStrings[2]);
		long r = Long.parseLong(lineStrings[3]);
		ArrayList<MyNode> dic = new ArrayList<MyNode>();//所有点
		LinkedList<MyNode> q = new LinkedList<MyNode>(); // 开端点
		boolean[] visited = new boolean[n+m+1];
		
		//原始路由器
		for (int i = 0; i < n; i++) {
			lineStrings = bReader.readLine().split(" ");
			long x = Long.parseLong(lineStrings[0]);
			long y = Long.parseLong(lineStrings[1]);
			dic.add(new MyNode(x, y));
		}
		//新增路由器
		for (int i = 0; i < m; i++) {
			lineStrings = bReader.readLine().split(" ");
			long x = Long.parseLong(lineStrings[0]);
			long y = Long.parseLong(lineStrings[1]);
			
			dic.add(new MyNode(x, y,true));
		}
		
		//取出起始点
		MyNode temp = dic.get(0);
		temp.cnt = 0;
		temp.k = k; //1
		
		q.add(temp);
		visited[0] = true;
		
		out:
		while(!q.isEmpty()) {
			MyNode node = q.get(0);
			q.remove(0);
			
			for(int i=1; i<dic.size(); i++) {
				if(!visited[i] && isUnion(node, dic.get(i), r)) {//可以连通
					if(dic.get(i).flag && node.k>0) {//需要使用k，且该dic的node也正好是新增的路由器
						q.add(new MyNode(dic.get(i).x, dic.get(i).y,k-1,node.cnt+1));
					}else if (!dic.get(i).flag) {
						q.add(new MyNode(dic.get(i).x, dic.get(i).y,k,node.cnt+1));
					}else {
						continue;
					}
					
					visited[i] = true;
					if(i==1) {//终点路由器
						System.out.println(node.cnt);
						break out;
					}
				}
			}
		}
		
		
	}
	
	//判断两个节点是否可以连接
	public static boolean isUnion(MyNode node, MyNode myNode,long r) {
		if((node.x-myNode.x)*(node.x-myNode.x)+(node.y-myNode.y)*(node.y-myNode.y)<=r*r) {
			return true;
		}else {
			return false;
		}
	}
	
}

class MyNode{
	long x;
	long y;
	long k;
	long cnt;
	boolean flag; //是否需要使用新增路由器
	
	public MyNode(long x, long y) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
	}
	
	public MyNode(long x, long y,boolean flag) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
		this.flag = flag;
	}
	public MyNode(long x, long y, long k, long cnt) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
		this.k = k;
		this.cnt = cnt;
	}
	
}
