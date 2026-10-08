package padroescomportamentais.state.lua;

public class FaseCrescente extends FaseLua {

    private FaseCrescente() {};
    private static FaseCrescente instance = new FaseCrescente();
    public static FaseCrescente getInstance() {
        return instance;
    }

    public String getNome() {
        return "Crescente";
    }

    public int getIluminacao() {
        return 25;
    }

    public void avancar(Lua lua) {
        lua.setFase(FaseQuartoCrescente.getInstance());
    }

}
