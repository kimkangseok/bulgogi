import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SutdySearch14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String numbers = "17";
		Solution14 Sol = new Solution14();
		System.out.println(Sol.solution(numbers));
	}

}

class Solution14 {
	public int solution(String numbers) {
		int answer = 0;
		Integer[] myNum = new Integer[numbers.length()];
		char[] charArray = new char[numbers.length()];
		String strMaxNum = "";
		int intMaxNum = 0;

		charArray = numbers.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			myNum[i] = Integer.parseInt(charArray[i] + "");
		}
		Arrays.sort(myNum, Collections.reverseOrder());

		for (int i = 0; i < myNum.length; i++) {
			strMaxNum += myNum[i] + "";
		}
		intMaxNum = Integer.parseInt(strMaxNum);
		boolean isPrime = true;
		int primeCnt = 0;
		for (int j = 2; j <= intMaxNum; j++) {
			if (isContain(numbers, j)) {
				// System.out.println(numbers + " " + j + " " + j%2);
				isPrime = true;
				for (int k = 2; k < (j/2) +1; k++) {
					if ((j % k) == 0) {
						isPrime = false;
						break;
					}
				}
				if (isPrime)
					primeCnt++;
			}
		}

		return answer = primeCnt;
	}

	boolean isContain(String numbers, int checkNum) {
		String strCheckNum = checkNum + "";
		char[] chrArray = strCheckNum.toCharArray();
		int existCnt = 0;
		List<String> numQ = new LinkedList<String>();
		for (int i = 0; i < numbers.length(); i++) {
			numQ.add(numbers.substring(i, i + 1));
		}
		Collections.sort(numQ);

		//System.out.println(numbers + " " + checkNum);
		for (int i = 0; i < chrArray.length; i++) {
			for (int j = 0; j < numQ.size(); j++) {
				// System.out.println(chrArray[i] + " " + numQ.get(j));
				if (numQ.get(j).equals(chrArray[i] + "")) {
					// System.out.println("Match");
					existCnt++;
					numQ.remove(j);
					break;
				}
			}
		}
		// System.out.println(existCnt);

		if (existCnt == 0) {
			return false;
		}

		if (existCnt == chrArray.length) {
			//System.out.println("Match");
			return true;
		} else {
			//System.out.println("UnMatch");
			return false;
		}
	}
}