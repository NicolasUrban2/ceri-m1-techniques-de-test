package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Pokedex implements IPokedex{
    private IPokemonMetadataProvider pokemonMetadataProvider;
    private IPokemonFactory pokemonFactory;
    private List<Pokemon> pokemons = new ArrayList<>();

    public Pokedex(IPokemonMetadataProvider pokemonMetadataProvider, IPokemonFactory pokemonFactory) {
        this.pokemonMetadataProvider = pokemonMetadataProvider;
        this.pokemonFactory = pokemonFactory;
    }

    @Override
    public int size() {
        return this.pokemons.size();
    }

    @Override
    public int addPokemon(Pokemon pokemon) {
        this.pokemons.add(pokemon);
        return this.pokemons.indexOf(pokemon);
    }

    @Override
    public Pokemon getPokemon(int id) throws PokedexException {
        try {
            return this.pokemons.get(id);
        } catch(IndexOutOfBoundsException e) {
            throw new PokedexException(e.getMessage());
        }

    }

    @Override
    public List<Pokemon> getPokemons() {
        return this.pokemons;
    }

    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        List<Pokemon> sortedList = new ArrayList<>(this.pokemons);
        sortedList.sort(order);
        return sortedList;
    }

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        try {
            PokemonMetadata pokemonMetadata = this.getPokemonMetadata(index);
            Pokemon incompletePokemon = this.pokemonFactory.createPokemon(index, cp, hp, dust, candy);
            return new Pokemon(
                    incompletePokemon.getIndex(),
                    pokemonMetadata.getName(),
                    pokemonMetadata.getAttack(),
                    pokemonMetadata.getDefense(),
                    pokemonMetadata.getStamina(),
                    incompletePokemon.getCp(),
                    incompletePokemon.getHp(),
                    incompletePokemon.getDust(),
                    incompletePokemon.getCandy(),
                    0
            );
        } catch (PokedexException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        return this.pokemonMetadataProvider.getPokemonMetadata(index);
    }
}
