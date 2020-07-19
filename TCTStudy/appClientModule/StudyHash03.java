import java.util.HashMap;
import java.util.Iterator;

public class StudyHash03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] clothes = new String[][] {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
		Solution03 Sol = new Solution03();
		System.out.println(Sol.solution(clothes));

	}

}

class Solution03 {
	public int solution(String[][] clothes) {
		int answer = 1;
		
		int _singleCase = clothes.length;
		HashMap<String, Integer> clothHash = new HashMap<String, Integer>();
		for(int i=0;i < clothes.length;i++)
		{
			if(clothHash.containsKey(clothes[i][1]))
			{
				clothHash.put(clothes[i][1], clothHash.get(clothes[i][1]) + 1);
			} else {
				clothHash.put(clothes[i][1], 1);
			}
		}
		
		if(clothHash.size() == 1) {
			answer = _singleCase;
		} else {
			Iterator<String> keys = clothHash.keySet().iterator();
			while(keys.hasNext())
			{
				String key = keys.next();
				answer *= (clothHash.get(key)+1);
			}
			answer -=1;
		}
		return answer;
	}
}