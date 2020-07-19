import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class StudyStack02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] priorities = new int[] { 1, 1, 9, 1, 1, 1};
		int location = 2;

		Solution06 Sol = new Solution06();
		System.out.println(Sol.solution(priorities, location));

	}
}

class Solution06 {
	public int solution(int[] priorities, int location) {
		int answer = 0;
		List<MyDoc> myDocQ = new LinkedList<MyDoc>();
		for(int i=0;i < priorities.length;i++)
		{
			myDocQ.add(new MyDoc(i+1, priorities[i]));
		}
		
		Collections.sort(myDocQ, new SortDocPrint());
		for(MyDoc doc : myDocQ)
			System.out.println(doc.getDocPriority());
		
		for(int i=0; i < priorities.length;i++)
		{
			if(myDocQ.get(i).getDocSeq() == location) {
				answer = i+1;
				break;
			}
		}
		
		return answer;
	}
}

class MyDoc {
	private int docSeq;
	private int docPriority;
	
	public MyDoc(int docSeq, int docPriority) {
		super();
		this.docSeq = docSeq;
		this.docPriority = docPriority;
	}

	public int getDocSeq() {
		return docSeq;
	}

	public void setDocSeq(int docSeq) {
		this.docSeq = docSeq;
	}

	public int getDocPriority() {
		return docPriority;
	}

	public void setDocPriority(int docPriority) {
		this.docPriority = docPriority;
	}
}

class SortDocPrint implements Comparator<MyDoc> {
	@Override
	public int compare(MyDoc o1, MyDoc o2)
	{
		return o2.getDocPriority() - o1.getDocPriority();
	}
}