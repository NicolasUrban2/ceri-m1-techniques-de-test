package fr.univavignon.pokedex.api;

public class PokemonTrainerFactory implements IPokemonTrainerFactory{
    private IPokemonMetadataProvider metadataProvider;
    private IPokemonFactory pokemonFactory;

    public void setMetadataProvider(IPokemonMetadataProvider metadataProvider) {
        this.metadataProvider = metadataProvider;
    }

    public void setPokemonFactory(IPokemonFactory pokemonFactory) {
        this.pokemonFactory = pokemonFactory;
    }

    @Override
    public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory) {
        return new PokemonTrainer(name, team, pokedexFactory.createPokedex(this.metadataProvider, this.pokemonFactory));
    }
}
