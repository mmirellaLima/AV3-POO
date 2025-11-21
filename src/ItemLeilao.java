public class ItemLeilao {
    private int idItem;
    private Leilao leilao;
    private String descricaoItem;
    private Double lanceMinimo;
    private Boolean itemArrematado;
    private Lance lanceArrematante;

    public ItemLeilao(int id,Leilao leilao,String desc,Double lanceMinimo,Boolean itemArrematado,lance lanceArrematante){
        this.idItem = id;
        this.leilao = leilao;
        this.descricaoItem = desc;
        this.lanceMinimo = lanceMinimo;
        this.itemArrematado = itemArrematado;
        this.lanceArrematante = lanceArrematante;
    }

    public int getId(){return idLeilao;}
    public void setId(int id){this.idLeilao = id;}

    public Leilao getLeilao(){return leilao;}
    public void setLeilao(String leilao){this.leilao = leilao;}

    public String getDesc(){return descricaoItem;}
    public void setDesc(String desc){this.descricaoItem = desc;}

    public Double getLanceMin(){return lanceMinimo;}
    public void setLanceMin(Double lanceMin){this.lanceMinimo = lanceMin;}

    public Boolean getItemArrematado(){return itemArrematado;}
    public void setItemArrematado(Double itemArrematado){this.itemArrematado = itemArrematado;}

    public Lance getLanceArrematante(){return lanceArrematante;}
    public void setLanceArrematante(Double lanceArrematante){this.lanceArrematante = lanceArrematante;}

    public void mostrar(){
        System.out.println("Leilão: " + leilao);
        System.out.println("Item: " + descricaoItem + ";" + idItem);
        System.out.println("Lance mínimo: " + lanceMinimo);
        System.out.println("Item Arrematado: " + itemArrematado);
        System.out.println("Lance Arrematante: " + lanceArrematante);
        System.out.println("--------------------------");
    }
}
