package study;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * ���ظ����ַ�����������ظ����ִ��Ĵ�С
 *
 * @author Administrator
 *
 */
public class Solution3 {

	public static void main(String[] args) {
		String s = "pwwkew";
		String s1 = "pwpkew";
		int max = lengthOfLongestSubstring(s);
		System.out.print("max = " + max);

		// ��������⣬����ú�����
		// System.out.print("��Ӵ���" + longestSubstring(s));
	}

	// ���ظ����ַ�����������ظ����Ӵ��Ĵ�С
	public static int lengthOfLongestSubstring(String s) {
		int i = 0, j = 0, max = 0;
		Set<Character> set = new HashSet<>();
		// �����ַ���s
		while (j < s.length()) {
			if (!set.contains(s.charAt(j))) {
				// ���set�в����ڸ��ַ����ͼ���
				set.add(s.charAt(j++));
				max = Math.max(max, set.size());
			} else {
				// ��������ĵ�ǰ�ַ��Ѿ�����set�����У���ɾ���ַ����ĵ�һ���ַ�
				// ����Ҫɾ��set�����кͱ����ĵ�ǰ�ַ���ͬ���ַ�����Ϊ��Ҫ���ص�ֻ���������ظ����Ӵ��Ĵ�С
				set.remove(s.charAt(i++)); // ���ִ�������䣬��ʱj��û�м�1��Ҳ����˵�����set�����д��ں͵�ǰ�������ַ�һ�����ַ�����һ����һ��һ����ɾ����ֱ�������ظ��ַ�ɾ����

			}
		}
		return max;
	}

	// �ڸ���Ļ����ϣ����ꡣ���ظ����ַ�����������ظ����ִ������ж������ȫ������
	// �ҵ�˼·��ʹ��HashMap���Ӵ�-max������max-�Ӵ�����Ϊ����ظ����Ӵ������ж������ôһ��keyֵmax����ӳ����value�����ǲ�����ġ�
	// ��������е����⣬һ����key��Character���͵ģ����Ӵ�������String���͡�
	public static String longestSubstring(String s) {
		Map<Character, Integer> map = new HashMap<>();
		int i = 0, j = 0, max = 0;
		while (j < s.length()) {
			if (!map.containsKey(s.charAt(j++))) {
				map.put(s.charAt(j), max);
				max = Math.max(max, map.size());
				map.put(s.charAt(j), max);
				j++;
			} else {
				map.remove(s.charAt(i++));
			}
		}
		// ����valueֵ(max)��ȡ��keyֵ(�Ӵ�)
		return "max = " + max + " , ����ظ��ִ�:" + map.get(max);
	}

}
