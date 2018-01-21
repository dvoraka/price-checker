package dvoraka.pricechecker;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }

    @Bean
    public CommandLineRunner commandLineRunner(RestTemplate restTemplate) {
        return args -> {
            ResponseEntity<String> result = restTemplate
                    .getForEntity("https://m.alza.cz/intel-core-i7-7820x-d4977502.htm", String.class);
//            System.out.println(result.getHeaders());
//            System.out.println(result.getBody());

            Document doc = Jsoup.parse(result.getBody());
            System.out.println(doc.select("div.price").first().select("div.normal").first().text());
        };
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder.build();
    }
}
