import java.util.Arrays;
import java.util.Comparator;

public class StudySort11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = new int[] { 3, 30, 34, 5, 9 };
		Solution11 Sol = new Solution11();
		System.out.println(Sol.solution(numbers));
	}

}

class Solution11 {
	public String solution(int[] numbers) {
		String answer = "";
		String[] myNum = new String[numbers.length];

		for (int i = 0; i < numbers.length; i++) {
			myNum[i] = numbers[i] + "";
		}

		Arrays.sort(myNum, new SortMyNum());
		for (String s : myNum)
			answer += s;

		if(myNum[0].equals("0")) return "0";
		return answer;
	}
}

class SortMyNum implements Comparator<String> {

	@Override
	public int compare(String arg0, String arg1) {
		// TODO Auto-generated method stub
		if (arg0.length() == arg1.length()) {
			return arg1.compareTo(arg0);
		} else {
			int iarg0 = Integer.parseInt(arg0 + arg1);
			int iarg1 = Integer.parseInt(arg1 + arg0);
			if (iarg0 == iarg1)
				return 0;
			else if (iarg0 > iarg1)
				return -1;
			else
				return 1;
		}
	}
}