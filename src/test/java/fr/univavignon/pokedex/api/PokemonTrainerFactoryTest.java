package fr.univavignon.pokedex.api;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class PokemonTrainerFactoryTest {
    PokemonTrainerFactory pokemonTrainerFactory = new PokemonTrainerFactory();

    @BeforeEach
    public void setUp() {
        pokemonTrainerFactory = new PokemonTrainerFactory();
    }

    @Test
    public void testCreateTrainer() {
        IPokemonMetadataProvider metadataProvider = mock(IPokemonMetadataProvider.class);
        IPokemonFactory pokemonFactory = mock(IPokemonFactory.class);
        pokemonTrainerFactory.setPokemonFactory(pokemonFactory);
        pokemonTrainerFactory.setMetadataProvider(metadataProvider);

        IPokedexFactory pokedexFactory = mock(IPokedexFactory.class);
        IPokedex pokedex = mock(IPokedex.class);
        when(pokedexFactory.createPokedex(metadataProvider, pokemonFactory)).thenReturn(pokedex);
        PokemonTrainer trainer = pokemonTrainerFactory.createTrainer("Michel", Team.INSTINCT, pokedexFactory);
        assertNotNull(trainer);
        assertEquals("Michel", trainer.getName());
        assertEquals(Team.INSTINCT, trainer.getTeam());
        assertEquals(pokedex, trainer.getPokedex());
    }
}