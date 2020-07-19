
public class StudySearch16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int brown = 10;
		int yellow = 2;
		int[] ans = new int[] {};
		Solution16 Sol = new Solution16();
		ans = Sol.solution(brown, yellow);
		for (int i : ans)
			System.out.println(i);
	}

}

class Solution16 {
	public int[] solution(int brown, int yellow) {
		int[] answer = new int[2];
		int sumVal = brown + yellow;
		int tmpVal = 0;
		boolean isFind = false;
		int b = 0;
		int y = 0;

		for (int i = 3; i < brown; i++) {
			isFind = false;
			for (int j = 3; j < brown; j++) {
				tmpVal = i * j;
				if (tmpVal == sumVal) {
					if (i >= j) {
						b = (i * 2) + (j * 2) - 4;
						y = (i - 2) * (j - 2);
						if ((b == brown) && (y == yellow)) {
							answer[0] = i;
							answer[1] = j;
							isFind = true;
							break;
						}
					}
				}
			}
			if (isFind)
				break;
		}
		return answer;
	}
}
