import java.util.Arrays;

public class StudySort10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = new int[] { 1, 5, 2, 6, 3, 7, 4 };
		int[][] commands = new int[][] { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };
		int[] ans = new int[] {};

		Solution10 Sol = new Solution10();
		ans = Sol.solution(array, commands);
		for (int i : ans)
			System.out.println(i);
	}

}

class Solution10 {
	public int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
		int[] tmpArray = new int[] {};
		int len = 0;
		int strt = 0;

		for (int i = 0; i < commands.length; i++) {
			len = 0;
			strt = 0;
			len = commands[i][1] - commands[i][0] + 1;
			strt = commands[i][0] - 1;

			//System.out.println(i + "  " + len + "  " + strt);

			tmpArray = new int[len];
			for (int j = 0; j < len; j++) {
				tmpArray[j] = array[j + strt];
			}

			Arrays.sort(tmpArray);
			answer[i] = tmpArray[commands[i][2] - 1];
		}

		return answer;
	}
}