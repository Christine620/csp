package 命令行选项;
import java.util.HashMap;
import java.util.Scanner;
 
public class Others {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		HashMap<String, Boolean> map = new HashMap<String, Boolean>();//字典
		HashMap<String, String> ans = new HashMap<String, String>();//结果
		String temp = in.nextLine();
		
		//输入字典
		for ( int i = 0; i < temp.length(); i++ ) {
			if ( i+1 < temp.length() && temp.charAt(i+1) == ':' ) {
				map.put("-"+temp.charAt(i), true);
				i++;
			} else map.put("-"+temp.charAt(i), false);
		}
		int n = in.nextInt();
		in.nextLine();
		
		//开始判断
		for ( int i = 0; i < n; i++ ) {
			String[] arrs = in.nextLine().split(" ");
			for ( int j = 1; j < arrs.length; j++ ) {
				if ( map.containsKey(arrs[j]) ) {//合法选项
					//有参数且参数合法
					if ( map.get(arrs[j]) && j+1 < arrs.length && arrs[j+1].matches("[a-z0-9-]+")) {
						ans.put(arrs[j], arrs[j+1]);
						j++;
					} else if ( !map.get(arrs[j]) ) ans.put(arrs[j], "");//不需要参数
					else break;//需要参数，但没给参数，或参数不合法
				} else break;
			}
			//输出
			System.out.print("Case "+(i+1)+": ");
			for ( char c = 'a'; c <= 'z'; c++ ) {//从小到大遍历
				if ( ans.containsKey("-"+c) ) {
					System.out.print("-"+c+" ");
					//如果有参数
					if ( !ans.get("-"+c).equals("") ) System.out.print(ans.get("-"+c)+" ");
				}
			}
			System.out.println();
			ans.clear();//情况结果集
		}
	}
	
}