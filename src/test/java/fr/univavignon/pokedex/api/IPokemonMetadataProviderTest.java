package fr.univavignon.pokedex.api;

import junit.framework.TestCase;
import org.junit.Test;

public class IPokemonMetadataProviderTest extends TestCase {

    IPokemonMetadataProvider pokemonMetadataProvider;
    public void setUp() throws Exception {
        super.setUp();

    }

    @Test(expected = PokedexException.class)
    public void testRaisePokedexExceptionWhenNoRelatedPokemon() throws PokedexException {
        this.pokemonMetadataProvider.getPokemonMetadata(-1);
    }

    public void testCorrectDescriptionGivenForIndex0() throws PokedexException {
        PokemonMetadata pokemonMetadata = this.pokemonMetadataProvider.getPokemonMetadata(0);
        assertNotNull(pokemonMetadata);
        assertEquals(126, pokemonMetadata.getAttack());
        assertEquals(126, pokemonMetadata.getDefense());
        assertEquals(90, pokemonMetadata.getStamina());
        assertEquals("Bulbizarre", pokemonMetadata.getName());
    }

    public void testCorrectDescriptionGivenForIndex133() throws PokedexException {
        PokemonMetadata pokemonMetadata = this.pokemonMetadataProvider.getPokemonMetadata(0);
        assertNotNull(pokemonMetadata);
        assertEquals(186, pokemonMetadata.getAttack());
        assertEquals(168, pokemonMetadata.getDefense());
        assertEquals(260, pokemonMetadata.getStamina());
        assertEquals("Aquali", pokemonMetadata.getName());
    }
}