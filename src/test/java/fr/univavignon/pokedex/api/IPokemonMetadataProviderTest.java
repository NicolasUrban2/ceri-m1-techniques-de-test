package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IPokemonMetadataProviderTest {

    IPokemonMetadataProvider pokemonMetadataProvider;

    @BeforeEach
    public void setUp() {
    pokemonMetadataProvider = new PokemonMetadataProvider();
    }

    @Test
    public void testRaisePokedexExceptionWhenNoRelatedPokemon() throws PokedexException {
        assertThrows(PokedexException.class, () -> {
            this.pokemonMetadataProvider.getPokemonMetadata(-1);
        });
    }

    @Test
    public void testCorrectDescriptionGivenForIndex0() throws PokedexException {
        PokemonMetadata pokemonMetadata = this.pokemonMetadataProvider.getPokemonMetadata(0);
        assertNotNull(pokemonMetadata);
        assertEquals(126, pokemonMetadata.getAttack());
        assertEquals(126, pokemonMetadata.getDefense());
        assertEquals(90, pokemonMetadata.getStamina());
        assertEquals("Bulbizarre", pokemonMetadata.getName());
    }

    @Test
    public void testCorrectDescriptionGivenForIndex133() throws PokedexException {
        PokemonMetadata pokemonMetadata = this.pokemonMetadataProvider.getPokemonMetadata(133);
        assertNotNull(pokemonMetadata);
        assertEquals(186, pokemonMetadata.getAttack());
        assertEquals(168, pokemonMetadata.getDefense());
        assertEquals(260, pokemonMetadata.getStamina());
        assertEquals("Aquali", pokemonMetadata.getName());
    }
}