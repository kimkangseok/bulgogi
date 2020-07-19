import java.util.LinkedList;
import java.util.Queue;

public class StudyStack07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] progresses = new int[] { 93, 30, 55 };
		int[] speeds = new int[] { 1, 30, 5 };
		int[] ans = new int[] {};

		Solution07 Sol = new Solution07();
		ans = Sol.solution(progresses, speeds);
		for (int i : ans)
			System.out.println(i);

	}

}

class Solution07 {
	public int[] solution(int[] progresses, int[] speeds) {
		int[] answer = {};
		int[] tmpAnswer = new int[progresses.length];
		Queue<MyWork> myWorkList = new LinkedList<MyWork>();
		int deployCnt = 0;
		int deployIdx = 0;

		for (int i = 0; i < progresses.length; i++) {
			myWorkList.offer(new MyWork(progresses[i], speeds[i]));
		}

		deployCnt = 0;
		deployIdx = 0;
		while (myWorkList.size() > 0) {
			for (MyWork work : myWorkList) {
				work.setProgress(work.getProgress() + work.getSpeed());
			}

			while (myWorkList.size() > 0) {
				if (myWorkList.peek().getProgress() >= 100) {
					deployCnt++;
					myWorkList.poll();
				} else {
					break;
				}
			}

			if (deployCnt > 0) {
				tmpAnswer[deployIdx] = deployCnt;
				deployIdx++;
				deployCnt = 0;
			}
		}
		answer = new int[deployIdx];
		for (int i = 0; i < deployIdx; i++) {
			answer[i] = tmpAnswer[i];
		}
		return answer;
	}
}

class MyWork {
	private int progress;
	private int speed;

	public MyWork(int progress, int speed) {
		super();
		this.progress = progress;
		this.speed = speed;
	}

	public int getProgress() {
		return progress;
	}

	public void setProgress(int progress) {
		this.progress = progress;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
}
