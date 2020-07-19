import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class StudySearch13 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int[] answers = new int[] { 1, 2, 3, 4, 5 };
		int[] answers = new int[] { 1, 3, 3, 4, 2 };
		int[] ans = new int[] {};
		Solution13 Sol = new Solution13();
		ans = Sol.solution(answers);
		for (int i : ans)
			System.out.println(i);
	}
}

class Solution13 {
	public int[] solution(int[] answers) {
		int[] answer = new int[] {};
		int[] st1Answer = new int[] { 1, 2, 3, 4, 5 };
		int[] st2Answer = new int[] { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] st3Answer = new int[] { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
		List<MyStudent> myStu = new LinkedList<MyStudent>();
		myStu.add(new MyStudent(1, 0));
		myStu.add(new MyStudent(2, 0));
		myStu.add(new MyStudent(3, 0));

		for (int i = 0; i < answers.length; i++) {
			// System.out.println(i%10);
			if (st1Answer[i % 5] == answers[i])
				myStu.get(0).setScore(myStu.get(0).getScore() + 1);
			if (st2Answer[i % 8] == answers[i])
				myStu.get(1).setScore(myStu.get(1).getScore() + 1);
			if (st3Answer[i % 10] == answers[i])
				myStu.get(2).setScore(myStu.get(2).getScore() + 1);
		}

		int idx = 0;
		int tmpScore = 0;
		Collections.sort(myStu, new SortByScore());
		for (MyStudent ms : myStu) {
			if(idx == 0)
			{
				if (ms.getScore() > 0) {
					tmpScore = ms.getScore();
					//System.out.println(ms.getStuNum() + "  " + ms.getScore());
					idx++;
				} else {
					break;
				}
			} else {
				if(tmpScore == ms.getScore())
				{
					idx++;
				} else {
					break;
				}
			}
		}
		answer = new int[idx];
		for(int i=0; i < idx; i++)
		{
			answer[i] = myStu.get(i).getStuNum();
		}
		return answer;
	}
}

class MyStudent {
	private int stuNum;
	private int score;

	public MyStudent(int stuNum, int score) {
		super();
		this.stuNum = stuNum;
		this.score = score;
	}

	public int getStuNum() {
		return stuNum;
	}

	public void setStuNum(int stuNum) {
		this.stuNum = stuNum;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}

class SortByScore implements Comparator<MyStudent> {

	@Override
	public int compare(MyStudent arg0, MyStudent arg1) {
		// TODO Auto-generated method stub
		if (arg1.getScore() == arg0.getScore()) {
			return arg0.getStuNum() - arg1.getStuNum();
		} else {
			return arg1.getScore() - arg0.getScore();
		}
	}
}