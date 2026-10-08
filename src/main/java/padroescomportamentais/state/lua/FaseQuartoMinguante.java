package padroescomportamentais.state.lua;

public class FaseQuartoMinguante extends FaseLua {

    private FaseQuartoMinguante() {};
    private static FaseQuartoMinguante instance = new FaseQuartoMinguante();
    public static FaseQuartoMinguante getInstance() {
        return instance;
    }

    public String getNome() {
        return "Quarto Minguante";
    }

    public int getIluminacao() {
        return 50;
    }

    public void avancar(Lua lua) {
        lua.setFase(FaseMinguante.getInstance());
    }

}
