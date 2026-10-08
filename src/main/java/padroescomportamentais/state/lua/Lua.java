package padroescomportamentais.state.lua;

public class Lua {

    private FaseLua fase;

    public Lua() {
        this.fase = FaseNova.getInstance();
    }

    public void setFase(FaseLua fase) {
        this.fase = fase;
    }

    public FaseLua getFase() {
        return fase;
    }

    public void avancar() {
        fase.avancar(this);
    }

    public String getNomeFase() {
        return fase.getNome();
    }

    public int getIluminacao() {
        return fase.getIluminacao();
    }
}
