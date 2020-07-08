import java.util.Arrays;

public class StudyHash01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String participant[] = new String[] {"leo", "kiki", "eden"};
		String completion[] = new String[] {"eden", "kiki"};
		
		Solution01 Sol = new Solution01();
		System.out.println(Sol.solution(participant, completion));
	}

}

class Solution01 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        try {
        	Arrays.sort(participant);
        	Arrays.sort(completion);
        	
        	for(int i=0; i < participant.length; i++)
        	{
        		if(i== participant.length-1)
        			return participant[i];
        		
        		if(participant[i].compareTo(completion[i]) != 0)
        			return participant[i];
        	}
        } 
        catch (Exception ex)
        {
        	return answer;
        }
        return answer;
    }
}