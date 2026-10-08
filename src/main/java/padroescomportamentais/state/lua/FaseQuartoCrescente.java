package padroescomportamentais.state.lua;

public class FaseQuartoCrescente extends FaseLua {

    private FaseQuartoCrescente() {};
    private static FaseQuartoCrescente instance = new FaseQuartoCrescente();
    public static FaseQuartoCrescente getInstance() {
        return instance;
    }

    public String getNome() {
        return "Quarto Crescente";
    }

    public int getIluminacao() {
        return 50;
    }

    public void avancar(Lua lua) {
        lua.setFase(FaseGibosaCrescente.getInstance());
    }

}
