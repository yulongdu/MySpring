package org.spring.test.v3;

import org.junit.Assert;
import org.junit.Test;
import org.spring.beans.BeanDefinition;
import org.spring.beans.factory.support.ConstructorResolver;
import org.spring.beans.factory.support.DefaultBeanFactory;
import org.spring.beans.factory.xml.XmlBeanDefinitionReader;
import org.spring.core.io.ClassPathResource;
import org.spring.core.io.Resource;
import org.spring.service.v3.PetStoreService;

public class ConstructorResolverTest {

	@Test
	public void testAutowireConstructor() {
		
		DefaultBeanFactory factory = new DefaultBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		Resource resource = new ClassPathResource("petstore-v3.xml");
		reader.loadBeanDefinitions(resource);

		BeanDefinition bd = factory.getBeanDefinition("petStore");
		
		ConstructorResolver resolver = new ConstructorResolver(factory);
		
		PetStoreService petStore = (PetStoreService)resolver.autowireConstructor(bd);
		
		// 验证参数version 正确地通过此构造函数做了初始化
		// PetStoreService(AccountDao accountDao, ItemDao itemDao,int version)
		Assert.assertEquals(1, petStore.getVersion());
		
		Assert.assertNotNull(petStore.getAccountDao());
		Assert.assertNotNull(petStore.getItemDao());
		
		
	}
}
