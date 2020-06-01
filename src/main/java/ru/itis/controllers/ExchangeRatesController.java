package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import ru.itis.entries.ExchangeRatesStatistics;
import ru.itis.services.ExchangeRateService;

@RestController
public class ExchangeRatesController {

    @Autowired
    private ExchangeRateService exchangeRateService;

    @GetMapping(value = "/rates", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ExchangeRatesStatistics> getAll(){
        return exchangeRateService.getAll();
    }
}
