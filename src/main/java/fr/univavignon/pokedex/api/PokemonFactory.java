package fr.univavignon.pokedex.api;

public class PokemonFactory implements IPokemonFactory{

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        if(index > 150 || index < 0 || cp < 0 || hp < 0 || dust < 0 || candy < 0) {
            return null;
        }
        return new Pokemon(index, "", 0, 0, 0, cp, hp, dust, candy, 0);
    }
}
