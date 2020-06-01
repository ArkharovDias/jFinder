package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;
import ru.itis.clients.ExchangeRatesClient;
import ru.itis.entries.ExchangeRatesStatistics;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExchangeRateServiceImpl implements ExchangeRateService {

    @Autowired
    private List<ExchangeRatesClient> clients;

    @Override
    public Flux<ExchangeRatesStatistics> getAll() {
        List<Flux<ExchangeRatesStatistics>> fluxes = clients.stream().map(this::getAll).collect(Collectors.toList());
        return Flux.merge(fluxes);
    }

    private Flux<ExchangeRatesStatistics> getAll(ExchangeRatesClient client){
        return client.getAll().subscribeOn(Schedulers.elastic());
    }
}
