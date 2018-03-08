package model;

/**
 *
 * @author MatheusBento
 */
public class Refeicao {
    private String descricao;
    //private String caracteristica;        
    private Refeicao sim, nao;
    
    public Refeicao(){
        descricao = "";
        //caracteristica = "";
        sim = null;
        nao = null;
    }
    
    public Refeicao(String descricao) {
        this.descricao = descricao;
        //this.caracteristica = caracteristica;
        sim = null;
        nao = null;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /*public String getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(String caracteristica) {
        this.caracteristica = caracteristica;    
    }*/

    public Refeicao getSim() {
        return sim;
    }

    public void setSim(Refeicao sim) {
        this.sim = sim;
    }

    public Refeicao getNao() {
        return nao;
    }

    public void setNao(Refeicao nao) {
        this.nao = nao;
    }
    
}
