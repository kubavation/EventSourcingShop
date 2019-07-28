package io.duryskuba.EventSourcingShop.service;

import org.axonframework.eventhandling.DomainEventMessage;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.axonframework.messaging.Message;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountQueryService {

    private final EventStore eventStore;

    public AccountQueryService(EventStore eventStore) {
        this.eventStore = eventStore;
    }

    //for testing
    public List<Object> eventsOfAccount(String id) {
        return eventStore.readEvents(id)
                    .asStream()
                    .map(Message::getPayload)
                    .collect(Collectors.toList());
    }
}
