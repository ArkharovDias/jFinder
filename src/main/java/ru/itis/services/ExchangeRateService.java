package ru.itis.services;

import reactor.core.publisher.Flux;
import ru.itis.entries.ExchangeRatesStatistics;

public interface ExchangeRateService {
    Flux<ExchangeRatesStatistics> getAll();
}
