package padroescomportamentais.state.lua;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LuaTest {

    Lua lua;

    @BeforeEach
    public void setUp() {
        lua = new Lua();
    }

    @Test
    public void deveIniciarNaFaseNova() {
        assertEquals(FaseNova.getInstance(), lua.getFase());
        assertEquals("Nova", lua.getNomeFase());
        assertEquals(0, lua.getIluminacao());
    }

    // Transicoes

    @Test
    public void deveAvancarDeNovaParaCrescente() {
        lua.setFase(FaseNova.getInstance());
        lua.avancar();
        assertEquals(FaseCrescente.getInstance(), lua.getFase());
    }

    @Test
    public void deveAvancarDeCrescenteParaQuartoCrescente() {
        lua.setFase(FaseCrescente.getInstance());
        lua.avancar();
        assertEquals(FaseQuartoCrescente.getInstance(), lua.getFase());
    }

    @Test
    public void deveAvancarDeQuartoCrescenteParaGibosaCrescente() {
        lua.setFase(FaseQuartoCrescente.getInstance());
        lua.avancar();
        assertEquals(FaseGibosaCrescente.getInstance(), lua.getFase());
    }

    @Test
    public void deveAvancarDeGibosaCrescenteParaCheia() {
        lua.setFase(FaseGibosaCrescente.getInstance());
        lua.avancar();
        assertEquals(FaseCheia.getInstance(), lua.getFase());
    }

    @Test
    public void deveAvancarDeCheiaParaGibosaMinguante() {
        lua.setFase(FaseCheia.getInstance());
        lua.avancar();
        assertEquals(FaseGibosaMinguante.getInstance(), lua.getFase());
    }

    @Test
    public void deveAvancarDeGibosaMinguanteParaQuartoMinguante() {
        lua.setFase(FaseGibosaMinguante.getInstance());
        lua.avancar();
        assertEquals(FaseQuartoMinguante.getInstance(), lua.getFase());
    }

    @Test
    public void deveAvancarDeQuartoMinguanteParaMinguante() {
        lua.setFase(FaseQuartoMinguante.getInstance());
        lua.avancar();
        assertEquals(FaseMinguante.getInstance(), lua.getFase());
    }

    @Test
    public void deveAvancarDeMinguanteParaNova() {
        lua.setFase(FaseMinguante.getInstance());
        lua.avancar();
        assertEquals(FaseNova.getInstance(), lua.getFase());
    }

    // Ciclo completo

    @Test
    public void deveVoltarParaNovaAposOitoAvancos() {
        for (int i = 0; i < 8; i++) {
            lua.avancar();
        }
        assertEquals(FaseNova.getInstance(), lua.getFase());
    }

    @Test
    public void deveRepetirOCicloVariasVezes() {
        for (int i = 0; i < 8 * 3 + 4; i++) {
            lua.avancar();
        }
        assertEquals(FaseCheia.getInstance(), lua.getFase());
    }

    // Comportamento de cada fase

    @Test
    public void deveRetornarNomeEIluminacaoDeCadaFase() {
        String[] nomes = {"Nova", "Crescente", "Quarto Crescente", "Gibosa Crescente",
                "Cheia", "Gibosa Minguante", "Quarto Minguante", "Minguante"};
        int[] iluminacao = {0, 25, 50, 75, 100, 75, 50, 25};

        for (int i = 0; i < nomes.length; i++) {
            assertEquals(nomes[i], lua.getNomeFase());
            assertEquals(iluminacao[i], lua.getIluminacao());
            lua.avancar();
        }
    }

    @Test
    public void iluminacaoDeveSubirAteACheiaEDepoisDescer() {
        int anterior = lua.getIluminacao();
        for (int i = 0; i < 4; i++) {
            lua.avancar();
            assertTrue(lua.getIluminacao() > anterior);
            anterior = lua.getIluminacao();
        }
        for (int i = 0; i < 4; i++) {
            lua.avancar();
            assertTrue(lua.getIluminacao() < anterior);
            anterior = lua.getIluminacao();
        }
    }

    @Test
    public void estadosDevemSerSingletons() {
        assertSame(FaseCheia.getInstance(), FaseCheia.getInstance());
        assertNotSame(FaseCheia.getInstance(), FaseNova.getInstance());
    }

}
