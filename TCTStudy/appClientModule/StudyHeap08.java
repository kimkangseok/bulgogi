import java.util.Collections;
import java.util.PriorityQueue;

public class StudyHeap08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] scoville = new int[] { 1, 2, 3, 9, 10, 12 };
		int[] scoville = new int[] { 3, 2, 1, 9, 12, 10 };
		int K = 7;

		Solution08 Sol = new Solution08();
		System.out.println(Sol.solution(scoville, K));
	}

}

class Solution08 {
	public int solution(int[] scoville, int K) {
		int answer = 0;
		int fstScoville = 0;
		int sndScoville = 0;
		int newScoville = 0;

		PriorityQueue<MyScoville> myQueue = new PriorityQueue<MyScoville>();

		for (int i = 0; i < scoville.length; i++) {
			myQueue.offer(new MyScoville(scoville[i]));
		}
		
		while (true) {
			if (myQueue.peek().getScoville() >= K) {
				break;
			} else {
				if (myQueue.size() < 2) {
					if (myQueue.peek().getScoville() < K)
						answer = -1;
					break;
				}
				fstScoville = 0;
				sndScoville = 0;
				newScoville = 0;
				
				// System.out.println(myQueue.peek().getScoville());
				fstScoville = myQueue.poll().getScoville();
				sndScoville = myQueue.poll().getScoville();
				newScoville = fstScoville + (sndScoville * 2);
				
				// System.out.println(fstScoville + "  " + sndScoville + "  " + newScoville);
				answer++;
				if ((fstScoville == 0) &&(sndScoville == 0))  {
					answer = -1;
					break;
				}
				myQueue.offer(new MyScoville(newScoville));
			}
		}

		if (answer != 0)
			return answer;
		else
			return -1;
	}
}

class MyScoville implements Comparable<MyScoville> {
	private int scoville;

	public MyScoville(int scoville) {
		super();
		this.scoville = scoville;
	}

	public int getScoville() {
		return scoville;
	}

	public void setScoville(int scoville) {
		this.scoville = scoville;
	}

	@Override
	public int compareTo(MyScoville o) {
		// return this.scoville - this.scoville;
		return o.scoville <= this.scoville ? 1 : -1;
	}
}