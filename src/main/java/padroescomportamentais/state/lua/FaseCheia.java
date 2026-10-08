package padroescomportamentais.state.lua;

public class FaseCheia extends FaseLua {

    private FaseCheia() {};
    private static FaseCheia instance = new FaseCheia();
    public static FaseCheia getInstance() {
        return instance;
    }

    public String getNome() {
        return "Cheia";
    }

    public int getIluminacao() {
        return 100;
    }

    public void avancar(Lua lua) {
        lua.setFase(FaseGibosaMinguante.getInstance());
    }

}
