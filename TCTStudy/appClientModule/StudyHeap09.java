import java.util.PriorityQueue;

public class StudyHeap09 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int stock = 4;
		int[] dates = new int[] { 4, 10, 15 };
		int[] supplies = new int[] { 20, 5, 10 };
		int k = 30;

		Solution09 Sol = new Solution09();
		System.out.println(Sol.solution(stock, dates, supplies, k));
	}

}

class Solution09 {
	public int solution(int stock, int[] dates, int[] supplies, int k) {
		int answer = 0;
		MySupply tmpSupply;
		PriorityQueue<MySupply> myQueue = new PriorityQueue<MySupply>();
		for (int i = 0; i < dates.length; i++) {
			myQueue.offer(new MySupply(dates[i], supplies[i]));
		}
				
		while (stock < k- 1) {
			tmpSupply = myQueue.poll();
			if(stock >= tmpSupply.getDate()) {
				stock += tmpSupply.getSupplies();
				answer++;	
			}
		}

		return answer;
	}
}

class MySupply implements Comparable<MySupply> {
	private int date;
	private int supplies;

	public MySupply(int date, int supplies) {
		super();
		this.date = date;
		this.supplies = supplies;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public int getSupplies() {
		return supplies;
	}

	public void setSupplies(int supplies) {
		this.supplies = supplies;
	}

	@Override
	public int compareTo(MySupply o) {
		// TODO Auto-generated method stub
		 if (this.supplies > o.supplies) {
	            return -1;
	        } else if (this.supplies == o.supplies) {
	            if (this.date < o.date) return -1;
	            else return 1;
	        } else return 1;
	}

}