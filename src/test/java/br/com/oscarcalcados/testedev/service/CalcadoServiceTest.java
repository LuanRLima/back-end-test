package br.com.oscarcalcados.testedev.service;

import br.com.oscarcalcados.testedev.domain.Calcado;
import br.com.oscarcalcados.testedev.domain.Categoria;
import br.com.oscarcalcados.testedev.repository.CalcadoRepository;
import br.com.oscarcalcados.testedev.service.execeptions.ObjectNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static br.com.oscarcalcados.testedev.domain.Categoria.TENIS;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

/**
 * Classe responsável por testar os métodos da classe CalcadoService
 *
 * @author Luan Rodrigues
 * @version 1.0
 * @since 2021-05-10
 */
@SpringBootTest
class CalcadoServiceTest {

    /**
     * Objeto statico responsável por simular o objeto CalcadoRepository
     */
    public static final Long ID = 1L;
    public static final String NOME = "Tênis";
    public static final String MARCA = "Nike";
    public static final String COR = "Azul";
    public static final String TAMANHO = "40";
    public static final double PRECO = 200.00;
    public static final int QUANTIDADE_EM_ESTOQUE = 10;
    public static final Categoria CATEGORIA = TENIS;
    public static final String DESCRICAO = "Tênis Nike";

    /**
     * service responsável por testar os métodos da classe CalcadoService
     */
    @InjectMocks
    private CalcadoService calcadoService;

    /**
     * Repositório responsável por testar os métodos da classe CalcadoService
     */
    @Mock
    private CalcadoRepository calcadoRepository;

    /**
     * Modelo responsável por testar os métodos da classe CalcadoService
     */
    private Calcado calcado;

    /**
     * Optional Calcado responsável por testar os métodos da classe CalcadoService
     */
    private Optional<Calcado> optionalCalcado;

    /**
     * Método responsável por inicializar os objetos
     */
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startCalcado();
    }

    /**
     * Teste responsável por testar o método de buscar por id e retornar um objeto Calcado
     */
    @Test
    void whenFindByIdWhenReturnAnCalcado() {
        when(calcadoRepository.findById(anyLong())).thenReturn(optionalCalcado);
        Calcado response = calcadoService.findById(ID);
        assertNotNull(response);
        assertEquals(Calcado.class, response.getClass());
        assertEquals(ID, response.getId());
        assertEquals(NOME, response.getNome());
        assertEquals(MARCA, response.getMarca());
        assertEquals(COR, response.getCor());
        assertEquals(TAMANHO, response.getTamanho());
        assertEquals(PRECO, response.getPreco());
        assertEquals(QUANTIDADE_EM_ESTOQUE, response.getQuantidadeEmEstoque());
        assertEquals(CATEGORIA, response.getCategoria());
        assertEquals(DESCRICAO, response.getDescricao());
    }

    /**
     * Teste responsável por testar o método de buscar por id e retornar um exception
     */
    @Test
    void whenFindByIdWhenReturnAnObejctNotFoundExcption() {
        when(calcadoRepository.findById(anyLong())).thenThrow(new ObjectNotFoundException("Calcado não encontrado"));

        try {
            calcadoService.findById(ID);
        } catch (ObjectNotFoundException e) {
            assertEquals(ObjectNotFoundException.class, e.getClass());
            assertEquals("Calcado não encontrado", e.getMessage());
        }
    }

    /**
     * Teste responsável por testar o método de buscar todos os objetos Calcado
     */
    @Test
    void whenFindAllWhenReturnAnListCalcados() {

        when(calcadoRepository.findAll()).thenReturn(List.of(calcado));

        List<Calcado> response = calcadoService.findAll();
        assertNotNull(response);

    }
    /**
     * Teste responsável por testar o método de salvar um objeto Calcado
     */
    @Test
    void whenCreateThenResturnSuccess() {
        when(calcadoRepository.save(any())).thenReturn(calcado);

        Calcado response = calcadoService.save(calcado);
        assertNotNull(response);
        assertEquals(Calcado.class, response.getClass());
        assertEquals(ID, response.getId());
        assertEquals(NOME, response.getNome());
        assertEquals(MARCA, response.getMarca());
        assertEquals(COR, response.getCor());
        assertEquals(TAMANHO, response.getTamanho());
        assertEquals(PRECO, response.getPreco());
        assertEquals(QUANTIDADE_EM_ESTOQUE, response.getQuantidadeEmEstoque());
        assertEquals(CATEGORIA, response.getCategoria());
        assertEquals(DESCRICAO, response.getDescricao());
    }

    /**
     * Teste responsável por testar o método de deletar um objeto Calcado
     */
    @Test
    void whenDeleteThenResturnSuccess() {
        when(calcadoRepository.findById(anyLong())).thenReturn(optionalCalcado);
        doNothing().when(calcadoRepository).deleteById(anyLong());
        calcadoService.deleteById(ID);
        verify(calcadoRepository, times(1)).deleteById(anyLong());

    }
    /**
     * Teste responsável por testar o método de deletar um objeto Calcado e retornar um exception
     */

    @Test
    void whenDeleteThenResturnObjectNotFoundException() {
        when(calcadoRepository.findById(anyLong())).thenThrow(new ObjectNotFoundException("Calcado não encontrado"));
    try {
            calcadoService.deleteById(ID);
        } catch (ObjectNotFoundException e) {
            assertEquals(ObjectNotFoundException.class, e.getClass());
            assertEquals("Calcado não encontrado", e.getMessage());
        }
    }

    /**
     * Método responsável por inicializar o objeto Calcado
     */
        private void startCalcado () {
            calcado = new Calcado(ID, NOME, MARCA, COR, TAMANHO, PRECO, QUANTIDADE_EM_ESTOQUE, CATEGORIA, DESCRICAO);
            optionalCalcado = Optional.of(calcado);

    }
}