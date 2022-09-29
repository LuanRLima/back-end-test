package br.com.oscarcalcados.testedev;

import br.com.oscarcalcados.testedev.domain.Calcado;
import br.com.oscarcalcados.testedev.repository.CalcadoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static br.com.oscarcalcados.testedev.domain.Categoria.TENIS;

@SpringBootApplication
public class TesteDevApplication {

    public static void main(String[] args) {
        SpringApplication.run(TesteDevApplication.class, args);
    }

    @Bean
    CommandLineRunner initDatabase(CalcadoRepository calcadoRepository) {
        return args -> {
            calcadoRepository.save(new Calcado("Tênis", "Nike", "Preto", "40", 100.00, 1, TENIS, "tenis nike preto"));
            calcadoRepository.save(new Calcado("Tênis", "Adidas", "Branco", "41", 130.00, 1, TENIS, "tenis adidas branco"));
            calcadoRepository.save(new Calcado("Tênis", "Nike", "Branco", "42", 113.00, 1, TENIS, "tenis nike branco"));
            calcadoRepository.save(new Calcado("Tênis", "Adidas", "Preto", "42", 130.00, 1, TENIS, "tenis adidas preto"));
        };
    }
}
