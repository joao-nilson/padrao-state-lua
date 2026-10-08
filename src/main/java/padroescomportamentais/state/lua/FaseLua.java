package padroescomportamentais.state.lua;

public abstract class FaseLua {

    public abstract String getNome();

    public abstract int getIluminacao();
    public abstract void avancar(Lua lua);
}
