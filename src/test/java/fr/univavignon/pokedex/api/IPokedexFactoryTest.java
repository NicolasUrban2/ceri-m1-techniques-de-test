package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokedexFactoryTest {

    IPokedexFactory pokedexFactory;
    
    @BeforeEach
    public void setUp() throws Exception {
        pokedexFactory = mock(IPokedexFactory.class);
    }

    @Test
    public void testCreatePokedex() {
        IPokemonMetadataProvider metadataProvider = mock(IPokemonMetadataProvider.class);
        IPokemonFactory pokemonFactory = mock(IPokemonFactory.class);
        IPokedexFactory pokedexFactory = mock(IPokedexFactory.class);
        when(pokedexFactory.createPokedex(metadataProvider, pokemonFactory)).thenReturn(mock(IPokedex.class));
        IPokedex pokedex = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);
        assertNotNull(pokedex);
    }
}