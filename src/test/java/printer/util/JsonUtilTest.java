/**
 * 
 */
package printer.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Properties;

import org.junit.Test;

/**
 * @author Administrator
 *
 */
public class JsonUtilTest {

	@Test
	public void test() {
		
	}
	
	@Test
	public void testLoadJsonFile(){
		
		List<String> goods =  ResourceUtil.getInstance().loadJsonFile("goods.json");
		
		assertNotNull("couldn't load resurce", goods);
		assertEquals(goods.size(), 9);
		
		
		
	}
	
	@Test
	public void testLoadPropFromFile(){
		
		ResourceUtil util = ResourceUtil.getInstance();
		Properties promotions =util.loadPropFile("promotionHandler.properties");
		assertNotNull("couldn't load resurce", promotions);
	}

}
