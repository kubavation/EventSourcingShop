package io.duryskuba.EventSourcingShop;

import io.duryskuba.EventSourcingShop.aggregate.AccountAggregate;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.axonframework.modelling.command.Repository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EventSourcingShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventSourcingShopApplication.class, args);
	}

//	@Bean
//	public Repository<AccountAggregate> accountRepository(EventStore eventStore) {
//		return EventSourcingRepository
//					.builder(AccountAggregate.class)
//					.eventStore(eventStore).build();
//	}

}
