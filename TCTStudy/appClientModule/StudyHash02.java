import java.lang.reflect.Array;
import java.util.Arrays;

public class StudyHash02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] phone_book = new String[] { "119", "97674223", "1195524421" };
		Solution02 Sol = new Solution02();
		System.out.println(Sol.solution(phone_book));

	}

}

class Solution02 {
	public boolean solution(String[] phone_book) {
		boolean answer = true;
		String _strTmp = "";
		String[] _strArrayClone = phone_book;

		int iLen = 0;
		int jLen = 0;
		for (int i = 0; i < phone_book.length; i++) {
			_strTmp = "";
			_strTmp = phone_book[i];
			for (int j = i + 1; j < _strArrayClone.length; j++) {
				iLen = _strTmp.length();
				jLen = _strArrayClone[j].length();

//				System.out.println(_strTmp);
//				System.out.println(_strArrayClone[j]);
				
				if (iLen > jLen) {
					System.out.println(_strTmp.substring(0, _strArrayClone[j].length()));
					System.out.println(_strArrayClone[j]);
					if (_strArrayClone[j].compareTo(_strTmp.substring(0, _strArrayClone[j].length())) == 0) {
						answer = false;
						break;
					}
				} else {
					System.out.println(_strArrayClone[j].substring(0, _strTmp.length()));
					System.out.println(_strTmp);
					if (_strTmp.compareTo(_strArrayClone[j].substring(0, _strTmp.length())) == 0) {
						answer = false;
						break;
					}
				}
			}
			if (!answer)
				break;
		}
		return answer;
	}
}