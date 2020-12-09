package com.alisha;

import com.alisha.wddily.tx.TransactionConfiguration;
import com.alisha.wddily.tx.XAOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import javax.annotation.PostConstruct;

@SpringBootApplication
@Import(TransactionConfiguration.class)
public class TxDemoApplication {

	private final XAOrdersService orderService;

	@Autowired
	public TxDemoApplication(XAOrdersService orderService) {
		this.orderService = orderService;
	}

	public static void main(final String[] args) {
		SpringApplication.run(TxDemoApplication.class, args);
	}

	@PostConstruct
	public void executeOrdersService() {
		orderService.init();
		orderService.selectAll();
		orderService.insert(10);
		orderService.selectAll();
		orderService.cleanup();
	}
}
