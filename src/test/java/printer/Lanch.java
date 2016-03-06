/**
 * 
 */
package printer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.Reader;

import com.google.gson.Gson;

/**
 * @author Administrator
 *
 */
public class Lanch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Class clazz;
		try {
			clazz = Class.forName("printer.impl.DropCntHandler");
			System.out.println(clazz);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
