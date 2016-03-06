/**
 * 
 */
package printer.util;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Properties;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import printer.model.Goods;
import printer.model.Promotion;

/**
 * @author Administrator
 *
 */
public class ResourceUtil {
	
	private static ResourceUtil JSONUTIL = new ResourceUtil();
	
	private  ResourceUtil(){}
	
	public static ResourceUtil getInstance(){
		
		return JSONUTIL;
	}
	
	public List<String> loadJsonFile(String fileName){
		
		Gson gson = new Gson();
		Reader br = null;
		List<String> bean = null;
		try {
			br = new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream(fileName));
			Type type = new TypeToken<List<String>>(){}.getType();
			bean = gson.fromJson(br, type);
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bean;
		
	}
	
public List<Goods> loadGoodsFile(String fileName){
		
		Gson gson = new Gson();
		Reader br = null;
		List<Goods> bean = null;
		try {
			br = new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream(fileName));
			Type type = new TypeToken<List<Goods>>(){}.getType();
			bean = gson.fromJson(br, type);
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bean;
		
	}

public List<Promotion> loadPromotionFile(String fileName){
	
	Gson gson = new Gson();
	Reader br = null;
	List<Promotion> bean = null;
	try {
		br = new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream(fileName));
		Type type = new TypeToken<List<Promotion>>(){}.getType();
		bean = gson.fromJson(br, type);
		br.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return bean;
	
}
	
    public Properties loadPropFile(String fileName){
		
    	Properties properties = new Properties();
    	try {
			properties.load(this.getClass().getClassLoader().getResourceAsStream(fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return properties;
		
		
	}

}
