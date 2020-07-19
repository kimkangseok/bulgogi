import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class StudyHash04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution04 Sol = new Solution04();
		String[] genres = new String[] { "classic", "pop", "classic", "classic", "pop" };
		int[] plays = new int[] { 500, 600, 150, 800, 2500 };

		for (int res : Sol.solution(genres, plays)) {
			System.out.println(res);
		}

	}
}

class Solution04 {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        Map<String, Integer> playNumByAlbum = new HashMap<String, Integer>();
        List<MyAlbum> myAlbum = new LinkedList<MyAlbum>();
        
        for(int i=0; i < genres.length;i++)
        {
        	if(playNumByAlbum.get(genres[i]) != null) {
        		playNumByAlbum.put(genres[i], playNumByAlbum.get(genres[i]) + plays[i]);
        	} else {
        		playNumByAlbum.put(genres[i], + plays[i]);
        	}
        	
        	myAlbum.add(new MyAlbum(genres[i], plays[i], i));
        }
        
        List<String> keySetList = new ArrayList<>(playNumByAlbum.keySet());
        Collections.sort(keySetList, (o1,o2) -> (playNumByAlbum.get(o2) - playNumByAlbum.get(o1)));
        Collections.sort(myAlbum, (o1, o2) -> (o2.getPlayCount() - o1.getPlayCount()));
     // keySetList.get(0)
        
        answer = new int[playNumByAlbum.size()*2];
        int idx = 0;
        int aIdx = 0;
        for(String key : keySetList)
        {
        	idx = 0;
        	//System.out.println("Key[" + key + "]  PlayCount[" + playNumByAlbum.get(key) + "]");
        	for(MyAlbum album : myAlbum) 
        	{
        		if(key.equals(album.getGenre()))
        		{
        			// System.out.println(album.getAlbumSeq());
        			answer[aIdx] = album.getAlbumSeq();
        			aIdx++;
        			idx++;
        		}
        		if(idx == 2)
        			break;
        	}
        }
        return answer;
    }
}

class MyAlbum {
	private String genre;
	private int playCount;
	private int albumSeq;
	
	public MyAlbum(String genre, int playCount, int albumSeq) {
		super();
		this.genre = genre;
		this.playCount = playCount;
		this.albumSeq = albumSeq;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getPlayCount() {
		return playCount;
	}

	public void setPlayCount(int playCount) {
		this.playCount = playCount;
	}

	public int getAlbumSeq() {
		return albumSeq;
	}

	public void setAlbumSeq(int albumSeq) {
		this.albumSeq = albumSeq;
	}
}
