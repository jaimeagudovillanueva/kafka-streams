package es.jaime.kafkastreams.config;

import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;
import java.util.stream.Collectors;

@Configuration
public class KafkaProcessor {

    /*
     *   process the numbers received via kafka topic
     *   Function<T, R> makes this as kafka stream processor
     *   T is input type
     *   R is output type
     *
     * */
    @Bean
    public Function<KStream<String, String>, KStream<String, String>> coolUsersProcessor(){
        return kStream ->  kStream.filter((k, v) -> v.contains("COOL"))
                .peek((k, v) -> System.out.println("Cool user found : " + v));
    };

}
