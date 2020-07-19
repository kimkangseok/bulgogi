import java.util.Arrays;

public class SutdySort12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] citations = new int[] { 3, 0, 6, 1, 5 };
		//int[] citations = new int[] { 1, 1, 1, 1, 1 };
		Solution12 Sol = new Solution12();
		System.out.println(Sol.solution(citations));
	}

}

class Solution12 {
	public int solution(int[] citations) {
		int answer = 0;
		Integer[] myArray = new Integer[citations.length];

		for(int i =0; i < citations.length;i++)
		{
			myArray[i] = citations[i];
		}
		
		Arrays.sort(myArray, (p1, p2) -> p2 - p1);
		
		for (int i =0; i < myArray.length; i++) {
			if(myArray[i] < i+1)
				return i;
		}
		return citations.length;
	}
}