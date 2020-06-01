package ru.itis.clients;

import reactor.core.publisher.Flux;
import ru.itis.entries.ExchangeRatesStatistics;

public interface ExchangeRatesClient {
    Flux<ExchangeRatesStatistics> getAll();
}
