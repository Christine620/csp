package 路径解析;

import java.util.LinkedList;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner inScanner = new Scanner(System.in);
		int num = inScanner.nextInt();
		inScanner.nextLine();
		String pathString = inScanner.nextLine();
		for (int i = 0; i < num; i++) {
			String str = inScanner.nextLine();
			if (str.equals("")) {
				str = pathString;
			}
			if(str.charAt(0)!='/') {
				str = pathString+"/"+str;
			}
			str = str.replaceAll("/+", "/");
//			if ( str.equals("") ) str = pathString;//空字符串
//			if ( str.charAt(0) != '/' ) str = pathString + '/' + str;//不是绝对路径
//			str = str.replaceAll("/+", "/");//去除连续的“/”

			String[] path = str.split("/");
			LinkedList<String> res = new LinkedList<String>();
			for (int j = 1; j < path.length; j++) {
				if(path[j].equals(".")) {
					continue;
				}else if (path[j].equals("..")&&res.size()>0) {
					res.remove(res.size()-1);
				}else if (!path[j].equals("..")) {
					//System.out.println(path[i]);
					res.add(path[j]);
				}
			}
			System.out.print("/");
			for (int j = 0; j < res.size(); j++) {
				if(j!=0) {
					System.out.print("/");
				}
				System.out.print(res.get(j));
			}
			System.out.println();
		}
	}
}
