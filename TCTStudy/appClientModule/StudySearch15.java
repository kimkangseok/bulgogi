import java.util.LinkedList;
import java.util.Queue;

public class StudySearch15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] baseball = new int[][] { { 123, 1, 1 }, { 356, 1, 0 }, { 327, 2, 0 }, { 489, 0, 1 } };
		Solution15 Sol = new Solution15();
		System.out.println(Sol.solution(baseball));
	}
}

class Solution15 {
	public int solution(int[][] baseball) {
		int answer = 0;
		int eleNum = 0;
		String pollNum = "";
		boolean isFind = false;
		int strikeCnt = 0;
		int ballCnt = 0;
		Queue<String> allNumQ = new LinkedList<String>();
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				for (int k = 1; k < 10; k++) {
					eleNum = 0;
					eleNum = (i * 100) + (j * 10) + k;
					allNumQ.offer(eleNum + "");
				}
			}
		}

		while (allNumQ.size() > 0) {
			pollNum = "";
			pollNum = allNumQ.poll();
			isFind = true;
			for (int i = 0; i < baseball.length; i++) {
				// System.out.println(pollNum);
				strikeCnt = FindStrike(pollNum, baseball[i]);
				ballCnt = FindBall(pollNum, baseball[i]) - strikeCnt;
				
				if((strikeCnt != baseball[i][1]) || (ballCnt != baseball[i][2])) {
					isFind = false;
					break;
				}
			}

			if (isFind) {
				answer++;
			}
		}

		return answer;
	}

	public int FindStrike(String pollNum, int[] s_baseball) {
		int sFindCnt = 0;
		int pFstNum = 0;
		int pSndNum = 0;
		int pTrdNum = 0;
		
		int bFstNum = 0;
		int bSndNum = 0;
		int bTrdNum = 0;

		char[] charArray = pollNum.toCharArray();
		pFstNum = Integer.parseInt(charArray[0]+"");
		pSndNum = Integer.parseInt(charArray[1]+"");
		pTrdNum = Integer.parseInt(charArray[2]+"");
		String strTmp = s_baseball[0]+"";
		//System.out.println(strTmp);
		bFstNum = Integer.parseInt(strTmp.substring(0,1));
		bSndNum = Integer.parseInt(strTmp.substring(1,2));
		bTrdNum = Integer.parseInt(strTmp.substring(2,3));
		
		//System.out.println(pFstNum + " " + bFstNum);
		//System.out.println(pSndNum + " " + bSndNum);
		//System.out.println(pTrdNum + " " + bTrdNum);
		if(pFstNum == bFstNum)
			sFindCnt++;
		
		if(pSndNum == bSndNum)
			sFindCnt++;
		
		if(pTrdNum == bTrdNum)
			sFindCnt++;
		
		return sFindCnt;
	}
	
	public int FindBall(String pollNum, int[] b_baseball) {
		int bFindCnt = 0;
		int pFstNum = 0;
		int pSndNum = 0;
		int pTrdNum = 0;
		
		int bFstNum = 0;
		int bSndNum = 0;
		int bTrdNum = 0;

		char[] charArray = pollNum.toCharArray();
		pFstNum = Integer.parseInt(charArray[0]+"");
		pSndNum = Integer.parseInt(charArray[1]+"");
		pTrdNum = Integer.parseInt(charArray[2]+"");
		String strTmp = b_baseball[0]+"";
		//System.out.println(strTmp);
		bFstNum = Integer.parseInt(strTmp.substring(0,1));
		bSndNum = Integer.parseInt(strTmp.substring(1,2));
		bTrdNum = Integer.parseInt(strTmp.substring(2,3));
		
		//System.out.println(pFstNum + " " + bFstNum);
		//System.out.println(pSndNum + " " + bSndNum);
		//System.out.println(pTrdNum + " " + bTrdNum);
		if((pFstNum == bFstNum) || (pFstNum == bSndNum) || (pFstNum == bTrdNum))
			bFindCnt++;
		
		if((pSndNum == bFstNum) || (pSndNum == bSndNum) || (pSndNum == bTrdNum))
			bFindCnt++;
		
		if((pTrdNum == bFstNum) || (pTrdNum == bSndNum) || (pTrdNum == bTrdNum))
			bFindCnt++;
		
		return bFindCnt;
	}
}
