package io.duryskuba.EventSourcingShop.service.account;

import io.duryskuba.EventSourcingShop.aggregate.AccountAggregate;
import io.duryskuba.EventSourcingShop.model.Account;
import io.duryskuba.EventSourcingShop.projection.AccountProjection;
import io.duryskuba.EventSourcingShop.repository.AccountRepository;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.axonframework.messaging.Message;
import org.axonframework.messaging.unitofwork.UnitOfWork;
import org.axonframework.modelling.command.Aggregate;
import org.axonframework.modelling.command.Repository;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AccountQueryService {

    private final EventStore eventStore;
    private final AccountRepository accountRepository;

    public AccountQueryService(EventStore eventStore,
                               AccountRepository accountRepository) {
        this.eventStore = eventStore;
        this.accountRepository = accountRepository;
    }

    public List<Object> eventsOfAccount(String id) {
        return eventStore.readEvents(id)
                    .asStream()
                    .map(Message::getPayload)
                    .collect(Collectors.toList());
    }


    @QueryHandler(queryName = "findAll")
    public Iterable<Account> findAll() {
        return accountRepository.findAll();
    }

    @QueryHandler(queryName = "findAccountById")
    public Optional<Account> findById(String id) {
        return accountRepository.findById(id);
    }
}
