package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Pokedex implements IPokedex{
    private final IPokemonMetadataProvider pokemonMetadataProvider;
    private final IPokemonFactory pokemonFactory;
    private final List<Pokemon> pokemons = new ArrayList<>();

    /**
     * Constructor
     *
     * @param pokemonMetadataProvider
     * @param pokemonFactory
     */
    public Pokedex(IPokemonMetadataProvider pokemonMetadataProvider, IPokemonFactory pokemonFactory) {
        this.pokemonMetadataProvider = pokemonMetadataProvider;
        this.pokemonFactory = pokemonFactory;
    }

    /**
     * Get the number of pokemons in the pokedex
     * @return the number of pokemons in the pokedex
     */
    @Override
    public int size() {
        return this.pokemons.size();
    }

    /**
     * Add a pokemon to the pokedex
     * @param pokemon Pokemon to add to this pokedex.
     * @return the index of the added pokemon
     */
    @Override
    public int addPokemon(Pokemon pokemon) {
        this.pokemons.add(pokemon);
        return this.pokemons.indexOf(pokemon);
    }

    /**
     * Get a pokemon from the pokedex
     * @param id Unique pokedex relative identifier.
     * @return the pokemon with the given id
     * @throws PokedexException
     */
    @Override
    public Pokemon getPokemon(int id) throws PokedexException {
        try {
            return this.pokemons.get(id);
        } catch(IndexOutOfBoundsException e) {
            throw new PokedexException(e.getMessage());
        }

    }

    /**
     * Get all the pokemons from the pokedex
     * @return the list of all pokemons in the pokedex
     */
    @Override
    public List<Pokemon> getPokemons() {
        return this.pokemons;
    }

    /**
     * Get all the pokemons from the pokedex, sorted by the given order
     * @param order Comparator instance used for sorting the created view.
     * @return the list of all pokemons in the pokedex, sorted by the given order
     */
    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        List<Pokemon> sortedList = new ArrayList<>(this.pokemons);
        sortedList.sort(order);
        return sortedList;
    }

    /**
     * Create a pokemon
     * @param index Pokemon index.
     * @param cp Pokemon CP.
     * @param hp Pokemon HP.
     * @param dust Required dust for upgrading pokemon.
     * @param candy Required candy for upgrading pokemon.
     * @return the created pokemon
     */
    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        try {
            PokemonMetadata pokemonMetadata = this.getPokemonMetadata(index);
            Pokemon incompletePokemon = this.pokemonFactory.createPokemon(index, cp, hp, dust, candy);
            if(incompletePokemon == null) {
                return null;
            }
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
                    56
            );
        } catch (PokedexException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    /**
     * Get the metadata of a pokemon
     * @param index Index of the pokemon to retrieve metadata for.
     * @return the metadata of the pokemon with the given index
     * @throws PokedexException
     */
    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        return this.pokemonMetadataProvider.getPokemonMetadata(index);
    }
}
