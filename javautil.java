package commonUtils;

import java.util.Random;

public class javautil {
	
	public int getRandomNumber() {
		
		Random r = new Random();
		int ran = r.nextInt(30);
		return ran;
	}

}
