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

import java.util.Optional;

import static br.com.oscarcalcados.testedev.domain.Categoria.TENIS;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@SpringBootTest
class CalcadoServiceTest {

    public static final Long ID = 1L;
    public static final String NOME = "Tênis";
    public static final String MARCA = "Nike";
    public static final String COR = "Azul";
    public static final String TAMANHO = "40";
    public static final double PRECO = 200.00;
    public static final int QUANTIDADE_EM_ESTOQUE = 10;
    public static final Categoria CATEGORIA = TENIS;
    public static final String DESCRICAO = "Tênis Nike";
    @InjectMocks
    private CalcadoService calcadoService;

    @Mock
    private CalcadoRepository calcadoRepository;

    private Calcado calcado;
    private Optional<Calcado> optionalCalcado;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startCalcado();
    }

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

    @Test
    void whenFindByIdWhenReturnAnObejctNotFoundExcption(){
        when(calcadoRepository.findById(anyLong())).thenThrow( new ObjectNotFoundException("Calcado não encontrado"));

        try {
            calcadoService.findById(ID);
        } catch (ObjectNotFoundException e) {
            assertEquals(ObjectNotFoundException.class, e.getClass());
            System.out.println(e.getMessage());
            assertEquals("Calcado não encontrado", e.getMessage());
        }
    }


//    @Test
//    void whenFindAllWhenReturnAnCalcado() {
//        when(calcadoRepository.findAll()).thenReturn(calcadoService.findAll());
//        assertNotNull(response);
//        assertEquals(Calcado.class, response.getClass());
//        assertEquals(ID, response.getId());
//        assertEquals(NOME, response.getNome());
//        assertEquals(MARCA, response.getMarca());
//        assertEquals(COR, response.getCor());
//        assertEquals(TAMANHO, response.getTamanho());
//        assertEquals(PRECO, response.getPreco());
//        assertEquals(QUANTIDADE_EM_ESTOQUE, response.getQuantidadeEmEstoque());
//        assertEquals(CATEGORIA, response.getCategoria());
//        assertEquals(DESCRICAO, response.getDescricao());
//    }



    @Test
    void findAllWithFilter() {
    }

    @Test
    void save() {
    }

    @Test
    void update() {
    }

    @Test
    void deleteById() {
    }

    private void startCalcado() {
        calcado = new Calcado(ID ,NOME, MARCA, COR, TAMANHO, PRECO, QUANTIDADE_EM_ESTOQUE, CATEGORIA, DESCRICAO);
        optionalCalcado = Optional.of(calcado);

    }
}