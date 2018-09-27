package co.tanay.demo.sri.bookstore;

import static org.mockito.Mockito.mock;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import co.tanay.demo.sri.bookstore.data.api.DataStore;

@Configuration
@ComponentScan(basePackages = {
		"co.tanay.demo.sri.bookstore.business.impl"
})
public class TestBookStoreContext {
	
}
