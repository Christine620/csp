package 化学方程式;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main{
	public static void getElement(String[] params, HashMap<String, Integer> elements) {

		Pattern xiShuPattern = Pattern.compile("(\\d*)(.*)");
		for (int i = 0; i < params.length; i++) {
			ArrayList<Element> list = new ArrayList<>();
			Matcher m = xiShuPattern.matcher(params[i]);

			int factor = 1;
			// 获取化学式之前的系数
			System.out.println(m.group(0));
			if (m.find() && !m.group(1).equals("")) {
				factor = Integer.valueOf(m.group(1));
			}
			// 获取化学式
			String chars = m.group(2);

			for (int j = 0; j < chars.length(); j++) {
				String element = "";
				if (Character.isUpperCase(chars.charAt(j))) {
					if (j + 1 < chars.length() && Character.isLowerCase(chars.charAt(j + 1))) { // 如果后一个字母为小写字母
						element = String.valueOf(chars.charAt(j)) + String.valueOf(chars.charAt(j + 1));
						j++;
					} else {
						element = String.valueOf(chars.charAt(j));
					}
					list.add(new Element(element, 1));
				} else if (chars.charAt(j) == '(') {
					list.add(new Element("(", 0));

				} else if (chars.charAt(j) == ')') {
					list.add(new Element(")", 0));
					// 项之后没有系数需要在后面插入1
					if (j + 1 >= chars.length() || !Character.isDigit(chars.charAt(j + 1))) {
						StringBuffer sb = new StringBuffer(chars);
						String temp = sb.insert(j + 1, "1").toString();
						chars = temp;
					}

				} else if (Character.isDigit(chars.charAt(j))) {

					String strDigit = "" + chars.charAt(j);
					// 系数由1-n个数组组成
					while (j + 1 < chars.length() && Character.isDigit(chars.charAt(j + 1))) {
						strDigit += chars.charAt(j + 1);
						j++;
					}
					int digit = Integer.valueOf(strDigit);
					int k = list.size() - 1;
					Element item = list.get(k);
					// 数字之前是否为右括号 是则将直到匹配到左括号内的所有元素都 *num
					if (item.element == ")") {
						// 忽视该右括号
						list.get(k).element = "*";
						while (item.element != "(") {
							k--;
							item = list.get(k);
							list.get(k).num *= Integer.valueOf(digit);

						}
						list.get(k).element = "*";
					} else {
						list.get(k).num *= digit;
					}

				}
			} // 化学式for处理完毕

			for (int j = 0; j < list.size(); j++) {

				Element item = list.get(j);
				if (item.element.equals("*") || item.num == 0)
					continue;
				int num = item.num;
				int oldNum = 0;
				if (elements.containsKey(item.element)) {
					oldNum = elements.get(item.element);
				}
				elements.put(item.element, oldNum + num * factor);
			}
		}

	}

    //比较输出
	public static void Judge(HashMap<String, Integer> rightElement, HashMap<String, Integer> leftElement) {
		boolean flag = true;
		HashSet<String> elements = new HashSet<>();
		// 存放左右两侧元素的并集
		elements.addAll(leftElement.keySet());
		elements.addAll(rightElement.keySet());

		for (String key : elements) {
			// 先比较是否有元素
			if (!rightElement.containsKey(key) || !leftElement.containsKey(key)) {
				System.out.println("N");
				flag = false;
				break;
			}
			int rightCount = rightElement.get(key);
			int leftCount = leftElement.get(key);
			if (rightCount != leftCount) {
				System.out.println("N");
				flag = false;
				break;
			}
		}
		if (flag)
			System.out.println("Y");

	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		String[] equations = new String[n];
		for (int i = 0; i < n; i++) {
			equations[i] = br.readLine();
		}
		for (int i = 0; i < equations.length; i++) {
			HashMap<String, Integer> leftElement = new HashMap<>();
			HashMap<String, Integer> rightElement = new HashMap<>();
			String[] params = equations[i].split("=");
			String left = params[0], right = params[1];
			params = left.split("\\+");
			getElement(params, leftElement);
			params = right.split("\\+");
			getElement(params, rightElement);
			
			Judge(rightElement, leftElement);

		}

	}

}

class Element {
	String element;
	int num;

	public Element(String element, int num) {
		super();
		this.element = element;
		this.num = num;
	}

	@Override
	public String toString() {
		return "Element [element=" + element + ", num=" + num + "]";
	}

}

