package padroescomportamentais.state.lua;

public class FaseMinguante extends FaseLua {

    private FaseMinguante() {};
    private static FaseMinguante instance = new FaseMinguante();
    public static FaseMinguante getInstance() {
        return instance;
    }

    public String getNome() {
        return "Minguante";
    }

    public int getIluminacao() {
        return 25;
    }

    public void avancar(Lua lua) {
        lua.setFase(FaseNova.getInstance());
    }

}
