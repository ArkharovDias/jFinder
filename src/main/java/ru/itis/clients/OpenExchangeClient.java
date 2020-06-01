package ru.itis.clients;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import ru.itis.entries.OpenExchangeApiResponse;
import ru.itis.entries.ExchangeRatesStatistics;

//@Component
public class OpenExchangeClient implements ExchangeRatesClient{

    private WebClient client;

    public OpenExchangeClient(@Value("${openexchange.api.url}") String url) {
        client = WebClient.builder()
                .exchangeStrategies(ExchangeStrategies.builder()
                        .codecs(clientCodecConfigurer -> clientCodecConfigurer.defaultCodecs().maxInMemorySize(100 * 1024 * 1024))
                        .build())
                .baseUrl(url)
                .build();
    }

    @Override
    public Flux<ExchangeRatesStatistics> getAll() {

        return client.get()
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .flatMap(clientResponse -> clientResponse.bodyToMono(OpenExchangeApiResponse.class))
                .flatMapIterable(OpenExchangeApiResponse::getData)
                .map(record ->
                        ExchangeRatesStatistics.builder()
                                .code(record.getCode())
                                .rate(record.getValue())
                                .build());
    }
}
