package ru.itis.clients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import ru.itis.entries.ExchangeRatesStatistics;
import ru.itis.models.RateValue;
import ru.itis.repositories.RateRepository;

import java.util.List;

@Component
public class DbClient implements ExchangeRatesClient {

    @Autowired
    private RateRepository rateRepository;

    @Override
    public Flux<ExchangeRatesStatistics> getAll() {

        List<RateValue> rateValueList = rateRepository.findAll();
        Flux<ExchangeRatesStatistics> result = Flux.fromIterable(rateValueList)
                .map(record ->
                        ExchangeRatesStatistics.builder()
                                .code(record.getName())
                                .rate(record.getRate())
                                .build());

        return result;
    }
}
