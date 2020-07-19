
public class StudyStack01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] heights = new int[] { 6, 9, 5, 7, 4 };
		int[] ans = new int[] {};

		Solution05 Sol = new Solution05();
		ans = Sol.solution(heights);
		for (int i : ans)
			System.out.println(i);
	}
}

class Solution05 {
	public int[] solution(int[] heights) {
		int[] answer = new int[heights.length];
		int[] tmpHeights = heights;
		boolean isFind = false;
		int idx = 0;

		for (int i = heights.length-1; i >= 0; i--) {
			isFind = false;
			idx++;
			for (int j = tmpHeights.length - idx; j >= 0; j--) {
				System.out.println("----------------");
				System.out.println(heights[i] + " " + i);
				System.out.println(tmpHeights[j] + " " + j);
				System.out.println("----------------");
				if (heights[i] < tmpHeights[j]) {
					answer[i] = j + 1;
					isFind = true;
					break;
				}
			}
			if (!isFind)
				answer[i] = 0;
		}
		return answer;
	}
}