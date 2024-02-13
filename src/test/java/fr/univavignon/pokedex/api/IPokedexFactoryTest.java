package fr.univavignon.pokedex.api;

import junit.framework.TestCase;
import org.junit.Test;
import static org.mockito.Mockito.mock;

public class IPokedexFactoryTest extends TestCase {

    IPokedexFactory pokedexFactory;
    
    @Override
    public void setUp() throws Exception {
        super.setUp();
        pokedexFactory = new PokedexFactory();
    }

    @Test
    public void testCreatePokedex() {
        IPokemonMetadataProvider metadataProvider = mock(IPokemonMetadataProvider.class);
        IPokemonFactory pokemonFactory = mock(IPokemonFactory.class);
        IPokedexFactory pokedexFactory = new PokedexFactory();
        IPokedex pokedex = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);
        assertNotNull(pokedex);
    }
}