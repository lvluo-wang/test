package test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.core.io.support.ResourcePropertySource;

public class PropertySourceTest {

	
	@Test
	public void test() throws IOException {  
	    Map<String, Object> map = new HashMap<>();  
	    map.put("encoding", "gbk");  
	    PropertySource propertySource1 = new MapPropertySource("map", map);  
	    System.out.println(propertySource1.getProperty("encoding"));  
	  
	    ResourcePropertySource propertySource2 = new ResourcePropertySource("resource", "classpath:core.properties"); //name, location  
	    System.out.println(propertySource2.getProperty("resource"));
	    
	  //省略propertySource1/propertySource2  
//	    CompositePropertySource compositePropertySource = new CompositePropertySource("composite");  
//	    compositePropertySource.addPropertySource(propertySource1);  
//	    compositePropertySource.addPropertySource(propertySource2);  
//	    System.out.println(compositePropertySource.getProperty("encoding"));
	    
//	    MutablePropertySources propertySources = new MutablePropertySources();  
//	    propertySources.addFirst(propertySource1);  
//	    propertySources.addLast(propertySource2);  
//	    System.out.println(propertySources.get("resource").getProperty("lvjinsuo.host.mgt.auction.vehicle.image.upload.maxsize"));  
//	  
//	    for(PropertySource propertySource : propertySources) {  
//	        System.out.println(propertySource.getProperty("encoding"));  
//	    }  
	    
	  //会自动注册 System.getProperties() 和 System.getenv()  
	    Environment environment = new StandardEnvironment();  
	    System.out.println(environment.getProperty("file.encoding")); 
	}  
}
