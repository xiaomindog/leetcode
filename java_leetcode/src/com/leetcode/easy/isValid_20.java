package com.leetcode.easy;

import java.util.Stack;


/*����һ��ֻ���� '('��')'��'{'��'}'��'['��']' ���ַ������ж��ַ����Ƿ���Ч��*/
public class isValid_20 {
	
	public static boolean is_valid1(String strs) {
		
		while(strs.contains("[]")||strs.contains("{}")||strs.contains("()")) {
			if(strs.contains("[]")) {
				strs = strs.replace("[]", "");
			}
			if(strs.contains("{}")) {
				strs = strs.replace("{}", "");
			}
			if(strs.contains("()")) {
				strs = strs.replace("()", "");
			}
		}
		
		return strs.isEmpty();
	}
	
	public static boolean is_valid2(String s) {
		
		Stack<String> stack = new Stack<>();
		
		for (int i = 0;i<s.length();i++) {
			switch (s.charAt(i)) {
				case '(':
					stack.push("(");
					break;
				case ')':
					if (stack.empty()) {
						return false;
					}
					if (!stack.pop().equals("(")) {
						return false;
					}
					break;
				case '[':
					stack.push("[");
					break;
				case ']':
					if (stack.empty()) {
						return false;
					}
					if (!stack.pop().equals("[")) {
						return false;
					}
					break;
				case '{':
					stack.push("{");
					break;
				case '}':
					if (stack.empty()) {
						return false;
					}
					if (!stack.pop().equals("{")) {
						return false;
					}
					break;
			}
		}
		return stack.empty();

	}

	public static boolean is_valid3(String s) {
		
		Stack<Character> stack = new Stack<Character>();
		char[] ch = s.toCharArray();//��stringתΪchar����
		for(char i :ch) {
			//���ջ�գ����߲�ƥ�䣬���Ž�ջ   .peek ȡջ��Ԫ�ص�������
			if(stack.isEmpty() || !isCompare(stack.peek(),i)) {
				stack.push(i);
			}
			else if(isCompare(stack.peek(), i)){
				stack.pop();
			}
		}
		
		return stack.isEmpty();
	}
	
	
	//����ƥ�亯��
	private static boolean isCompare(char a,char b) {
		if(a=='['&&b==']')
			return true;
		else if (a=='{'&&b=='}'){
			return true;
		}
		else {
			return a=='('&&b==')';
		}
	}
	
	public static void main(String[] args) {
		
		String str1 = new String("[]()") ;
		String str2 = new String("{}}{[]");
		String str3 = new String();
		System.out.println(is_valid3(str1));
		System.out.println(is_valid3(str2));
		System.out.println(is_valid3(str3));
	}
}
