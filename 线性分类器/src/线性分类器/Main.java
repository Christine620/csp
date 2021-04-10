package 线性分类器;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner inScanner = new Scanner(System.in);
		int num = inScanner.nextInt(), test = inScanner.nextInt();
		ArrayList<Node> A = new ArrayList<>();
		ArrayList<Node> B = new ArrayList<Node>();
		
		for (int i = 0; i < num; i++) {
			int x = inScanner.nextInt();
			int y = inScanner.nextInt();
			String classString = inScanner.next();
			if(classString.equals("A")) {
				A.add(new Node(x, y));
			}else {
				B.add(new Node(x, y));
			}
		}
		
		for (int i = 0; i < test; i++) {
			int theta0 = inScanner.nextInt();
			int theta1 = inScanner.nextInt();
			int theta2 = inScanner.nextInt();
			int examplex = A.get(0).x;
			int exampley = A.get(0).y;
			
			OUT:
			if(theta0+theta1*examplex+theta2*exampley>0) {				
				for(Node node:A) {
					if(theta0+theta1*node.x+theta2*node.y<=0) {
						System.out.println("No");
						break OUT;
					}
				}
				for(Node node:B) {
					if(theta0+theta1*node.x+theta2*node.y>=0) {
						System.out.println("No");
						break OUT;
					}
				}
				System.out.println("Yes");
				
			}else {
				for(Node node:A) {
					if(theta0+theta1*node.x+theta2*node.y>=0) {
						System.out.println("No");
						break OUT;
					}
				}
				for(Node node:B) {
					if(theta0+theta1*node.x+theta2*node.y<=0) {
						System.out.println("No");
						break OUT;
					}
				}
				System.out.println("Yes");
			}
		}
	}
}

class Node{
	int x,y;
	public Node(int x, int y) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
	}
}
