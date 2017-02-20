package study;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 返回给定字符串的最长的无重复的字串的大小
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

		// 这个有问题，这个好好想想
		// System.out.print("最长子串：" + longestSubstring(s));
	}

	// 返回给定字符串的最长的无重复的子串的大小
	public static int lengthOfLongestSubstring(String s) {
		int i = 0, j = 0, max = 0;
		Set<Character> set = new HashSet<>();
		// 遍历字符串s
		while (j < s.length()) {
			if (!set.contains(s.charAt(j))) {
				// 如果set中不存在该字符，就加入
				set.add(s.charAt(j++));
				max = Math.max(max, set.size());
			} else {
				// 如果遍历的当前字符已经存在set集合中，则删除字符串的第一个字符
				// 不需要删除set集合中和遍历的当前字符相同的字符，因为需要返回的只是最大的无重复的子串的大小
				set.remove(s.charAt(i++)); // 如果执行这个语句，此时j并没有加1，也就是说，如果set集合中存在和当前遍历的字符一样的字符，则一定会一个一个的删除，直至将该重复字符删除。

			}
		}
		return max;
	}

	// 在该题的基础上，引申。返回给定字符串的最长的无重复的字串，若有多个，则全部返回
	// 我的思路：使用HashMap，子串-max。不能max-子串，因为最长无重复的子串可能有多个，那么一个key值max将会映射多个value，这是不合理的。
	// 这个还是有点问题，一方面key是Character类型的，而子串可能是String类型。
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
		// 根据value值(max)，取出key值(子串)
		return "max = " + max + " , 最长无重复字串:" + map.get(max);
	}

}
