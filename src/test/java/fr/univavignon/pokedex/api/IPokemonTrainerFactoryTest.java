package fr.univavignon.pokedex.api;

import junit.framework.TestCase;
import static org.mockito.Mockito.mock;

public class IPokemonTrainerFactoryTest extends TestCase {
    IPokemonTrainerFactory pokemonTrainerFactory;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        pokemonTrainerFactory = new PokemonTrainerFactory();
    }

    public void testCreateTrainer() {
        PokemonTrainer trainer = pokemonTrainerFactory.createTrainer("Michel", Team.INSTINCT, mock(IPokedexFactory.class));
        assertNotNull(trainer);
        assertEquals("Michel", trainer.getName());
        assertEquals(Team.INSTINCT, trainer.getTeam());
    }
}