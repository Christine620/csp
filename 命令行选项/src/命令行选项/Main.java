package 命令行选项;

import java.util.HashMap;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		//存储命令
		HashMap<String, Boolean> map1 = new HashMap<String, Boolean>();
		//存储结果
		HashMap<String, String> map2 = new HashMap<String, String>();
		String tempString = in.nextLine();
		
		for (int i = 0; i < tempString.length(); i++) {
			if(i+1 < tempString.length() && tempString.charAt(i+1)==':') {
				map1.put("-"+ tempString.charAt(i), true);
				i++;
			}else {
				map1.put("-"+ tempString.charAt(i), false);
			}
		}
		
		int orderNum = in.nextInt();
		in.nextLine();
		
		for (int i = 0; i < orderNum; i++) {
			String[] order = in.nextLine().split(" ");
			for (int j = 1; j < order.length; j++) {
				if(map1.containsKey(order[j])) {
					if(map1.get(order[j]) && j+1 < order.length && order[j+1].matches("[a-z0-9-]+")) {
						map2.put(order[j], order[j+1]);
						j++;
					}else if(!map1.get(order[j])){
						map2.put(order[j], "");
					}else {
						break;
					}
					
				}else {
					break;
				}
			}

			System.out.print("Case "+(i+1)+": ");
			for(char c = 'a'; c<='z'; c++) {
				if (map2.containsKey("-"+c)) {
					System.out.print("-"+c+" ");
					if(!map2.get("-"+c).equals(" ")) {
						System.out.print(map2.get("-"+c));
					}
				}
			}
			System.out.println();
			map2.clear();
		}
		
		
	}
}




