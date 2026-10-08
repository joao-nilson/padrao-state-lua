package padroescomportamentais.state.lua;

public class FaseGibosaMinguante extends FaseLua {

    private FaseGibosaMinguante() {};
    private static FaseGibosaMinguante instance = new FaseGibosaMinguante();
    public static FaseGibosaMinguante getInstance() {
        return instance;
    }

    public String getNome() {
        return "Gibosa Minguante";
    }

    public int getIluminacao() {
        return 75;
    }

    public void avancar(Lua lua) {
        lua.setFase(FaseQuartoMinguante.getInstance());
    }

}
