package padroescomportamentais.state.lua;

public class FaseGibosaCrescente extends FaseLua {

    private FaseGibosaCrescente() {};
    private static FaseGibosaCrescente instance = new FaseGibosaCrescente();
    public static FaseGibosaCrescente getInstance() {
        return instance;
    }

    public String getNome() {
        return "Gibosa Crescente";
    }

    public int getIluminacao() {
        return 75;
    }

    public void avancar(Lua lua) {
        lua.setFase(FaseCheia.getInstance());
    }

}
