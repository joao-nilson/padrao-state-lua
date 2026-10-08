package padroescomportamentais.state.lua;

public class FaseNova extends FaseLua {

    private FaseNova() {};
    private static FaseNova instance = new FaseNova();
    public static FaseNova getInstance() {
        return instance;
    }

    public String getNome() {
        return "Nova";
    }

    public int getIluminacao() {
        return 0;
    }

    public void avancar(Lua lua) {
        lua.setFase(FaseCrescente.getInstance());
    }

}
