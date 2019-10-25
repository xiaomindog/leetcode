package com.leetcode.easy;

/*
 * ����: ["flower","flow","flight"]
	���: "fl"
*/
public class longestCommonPrefix_14 {
	
	public static String lcp01(String[] strs) {
		
		
		StringBuffer str = new StringBuffer();
		//�ҵ�����ַ���
		int minlen = strs[0].length();
		for(int i =0;i<strs.length;i++) {
			if(minlen>strs[i].length()) {
				minlen = strs[i].length();
			}
		}
		
		int flag;
		for(int i=0;i<minlen;i++) {
			flag =1;
			for(int j =0;j<strs.length-1;j++) {
				if(strs[j].charAt(i)!=strs[j+1].charAt(i)) {
					flag=0;break;
				}
			}
			
			if(i==0 && flag==0) {
				break;
			}
			
			if(flag==1) {
				str.append(strs[0].charAt(i));
			}
		}
		
		//System.out.println(str);
		String s  = str.toString();
		return s;
	}
	
	
	/*��ǩ������
	���ַ������鳤��Ϊ 0 ʱ�򹫹�ǰ׺Ϊ�գ�ֱ�ӷ���
	�������ǰ׺ ans ��ֵΪ��һ���ַ��������г�ʼ��
	����������ַ��������ν����� ans ���бȽϣ������ҳ�����ǰ׺�����ս����Ϊ�����ǰ׺
	������ҹ����г����� ans Ϊ�յ�������򹫹�ǰ׺������ֱ�ӷ���
	ʱ�临�Ӷȣ�O(s)��s Ϊ�����ַ����ĳ���֮��
	 */
	public static String lcp02(String[] strs) {
		if(strs.length==0){
            return "";
		}
		String ans = strs[0];
		
		for(int i=1;i<strs.length;i++) {
			int j;
			for(j=0;j<strs[i].length()&&j<ans.length();j++) {
				if(strs[i].charAt(j)!=ans.charAt(j)) {
					break;
				}
			}
			ans = ans.substring(0,j);
			if(ans.equals("")) {
				return "";
			}
		}
		
		
		
		return ans;
	}
	
	public static void main(String[] args) {
		String[] str1 = {"flower","flow","flight"};
		String[] str2 = {"dog","racecar","car"};
		System.out.println(lcp02(str1));
		System.out.println(lcp02(str2));
	}
}
