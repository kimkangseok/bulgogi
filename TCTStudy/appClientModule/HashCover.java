import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashCover {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[][] arg1 = { { "yellow_hat", "headgear" }, { "green_turban", "headgear" },
				{ "blue_sunglasses", "eyewear" }, { "red_sunglasses", "eyewear" }, { "red_sunglasses", "eyewear" },
				{ "blck_tie", "tie" } };

		/*
		 * String[][] arg1 = { { "yellow_hat", "headgear" }, { "green_turban",
		 * "headgear" }, { "blue_sunglasses", "eyewear" }};
		 */
		// String[][] arg1 = {{"crow_mask", "face"}, {"blue_sunglasses",
		// "face"}, {"smoky_makeup", "face"}};
		SolutionCover Sol = new SolutionCover();
		System.out.println(Sol.solution(arg1));
	}

}

class SolutionCover {
	int answer = 1;
	String strLine = "";

	public int solution(String[][] clothes) {

		Map<String, Integer> mySpy = new HashMap<String, Integer>();

		for (int i = 0; i < clothes.length; i++) {
			if (mySpy.containsKey(clothes[i][1])) {
				mySpy.put(clothes[i][1], mySpy.get(clothes[i][1]) + 1);
			} else {
				mySpy.put(clothes[i][1], 1);
			}
		}

		Iterator<String> hashKeys = mySpy.keySet().iterator();
		while(hashKeys.hasNext()){
			answer *= (mySpy.get(hashKeys.next()) + 1);
		}
		
		return answer -1;
	}

	public int calc(Map<String, Integer> subSpy, String strKey) {
		int ans = 1;
		boolean isFind = false;
		boolean isNexCall = false;
		int ansSub = 0;
		String tmpStr = "";

		Iterator<String> hashKeys = subSpy.keySet().iterator();
		strLine += "-----";
		// System.out.println(strLine);
		while (hashKeys.hasNext()) {
			String tmpKey = hashKeys.next();
			if ((strKey.compareTo("") == 0) && (!isFind)) {

				// System.out.println("KeySet Null:");
				isFind = true;
				// System.out.println("Call Next:" + tmpKey);
				ansSub = calc(subSpy, tmpKey);
				System.out.println(ansSub);
				return ansSub;
			} else {
				if (tmpKey.compareTo(strKey) == 0) {
					isFind = true;
				}
				if (isFind) {
					// System.out.println("Find: " + tmpKey + ":" +
					// subSpy.get(tmpKey));
					if (subSpy.get(tmpKey) > 1) {
						ans *= subSpy.get(tmpKey);
						tmpStr += subSpy.get(tmpKey) + "-";
						// System.out.println(tmpStr);
					}
				}

				if ((isFind) && (!isNexCall)) {
					if (hashKeys.hasNext()) {

						String tmp2 = hashKeys.next();
						if (subSpy.get(tmp2) > 1) {
							ans *= subSpy.get(tmp2);
						}
						tmpStr += subSpy.get(tmp2) + "-";
						// System.out.println(tmpStr);
						isNexCall = true;
						// System.out.println("Call Next: " + tmp2 + ":" +
						// subSpy.get(tmp2));
						ansSub = calc(subSpy, tmp2);
					} else {
						tmpStr += subSpy.get(tmpKey) + "-";
						// System.out.println(strLine);
						System.out.println("0");
						return 0;
						// return subSpy.get(tmpKey);
					}
				}
			}
		}
		// System.out.println("Return:" + (ans + ansSub));
		// System.out.println(strLine);

		System.out.println(ans + ansSub);
		return ans + ansSub;
	}
}