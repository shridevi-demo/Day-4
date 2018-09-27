package co.tanay.demo.sri.springtest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import co.tanay.demo.sri.springtest.parser.EmailAdapter;
import co.tanay.demo.sri.springtest.parser.EventParam;
import co.tanay.demo.sri.springtest.parser.PaymentInitWrapper;
import co.tanay.demo.sri.springtest.parser.REST_APIAdapter;
import co.tanay.demo.sri.springtest.parser.RouterTransFormerFactoryImpl;

@Configuration
@ComponentScan(basePackages = {
		"co.tanay.demo.sri.springtest.parser"
})
class TestContext {
	
}

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestContext.class)
public class RouterTransFormTest {
	
	@MockBean
	REST_APIAdapter apiRouterTransform;
	
	@MockBean
	EmailAdapter emailRouterTransform;
	
	@Autowired
	RouterTransFormerFactoryImpl routerTransFrom;
	
	PaymentInitWrapper paymentInitWrapper;
	EventParam eventParam;
	
	@Before
	public void setup() {
		paymentInitWrapper = mock(PaymentInitWrapper.class);
		eventParam = mock(EventParam.class);
	}
	
	@Test
	public void assertSuccessREST() {
		
		when(eventParam.getClientAPI()).thenReturn("SOME_VALUE");
		
		routerTransFrom.publishToAChannel(paymentInitWrapper, eventParam);
		
		verify(apiRouterTransform).processForChannel(paymentInitWrapper, eventParam);
	}
	
	@Test
	public void assertSuccessNullClient() {
		
		when(eventParam.getClientAPI()).thenReturn(null);
		
		routerTransFrom.publishToAChannel(paymentInitWrapper, eventParam);
		
		verify(emailRouterTransform).processForChannel(paymentInitWrapper, eventParam);
	}
	
	@Test
	public void assertSuccessEmptyClient() {
		
		when(eventParam.getClientAPI()).thenReturn("");
		
		routerTransFrom.publishToAChannel(paymentInitWrapper, eventParam);
		
		verify(emailRouterTransform).processForChannel(paymentInitWrapper, eventParam);
	}
	
//	@Test
//	public void assertSuccessREST() {
//		
//		//when(eventParam.getClientAPI()).thenReturn("SOME_VALUE");
//		when(eventParam.getClientAPI()).thenReturn("client");
//		
//		routerTransFrom.publishToAChannel(paymentInitWrapper, eventParam);
//		
//		verify(apiRouterTransform).processForChannel(paymentInitWrapper, eventParam);
//	}
//	
//	@Test
//	public void assertSuccessEmail() {
//		
//		//when(eventParam.getClientAPI()).thenReturn("SOME_VALUE");
//		when(eventParam.getClientAPI()).thenReturn("email");
//		
//		routerTransFrom.publishToAChannel(paymentInitWrapper, eventParam);
//		
//		verify(emailRouterTransform).processForChannel(paymentInitWrapper, eventParam);
//	}
//	
//	
//	@Test
//	public void assertSuccessEmptyClientAPI() {
//		
//		//when(eventParam.getClientAPI()).thenReturn("SOME_VALUE");
//		when(eventParam.getClientAPI()).thenReturn("kbchewsfckw");
//		
//		routerTransFrom.publishToAChannel(paymentInitWrapper, eventParam);
//		
//		verify(apiRouterTransform, times(0)).processForChannel(paymentInitWrapper, eventParam);
//		verify(emailRouterTransform, times(0)).processForChannel(paymentInitWrapper, eventParam);
//	}
}
