package henu.util;

import java.io.Closeable;
import java.io.IOException;

/**
 * ¹Ø±ÕÁ÷
 * @author <oaksharks@163.com>
 * @see Closeable
 */
public class CloseUtils {

	public static void CloseIO(Closeable ...streams)
	{
		for(Closeable io:streams)
		{
			if(io!=null)
			{
				try {
					io.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
