import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

public class ItemLeilao {
    private int idItem;
    private Leilao leilao;
    private String descricaoItem;
    private Double lanceMinimo;
    private Boolean itemArrematado;
    private Lance lanceArrematante;

    public ItemLeilao(int id,Leilao leilao,String desc,Double lanceMinimo,Boolean itemArrematado,Lance lanceArrematante){
        this.idItem = id;
        this.leilao = leilao;
        this.descricaoItem = desc;
        this.lanceMinimo = lanceMinimo;
        this.itemArrematado = itemArrematado;
        this.lanceArrematante = lanceArrematante;
    }


    public int getId(){return idItem;}
    public void setId(int id){this.idItem = id;}

    public Leilao getLeilao(){return leilao;}
    public void setLeilao(Leilao leilao){this.leilao = leilao;}

    public String getDesc(){return descricaoItem;}
    public void setDesc(String desc){this.descricaoItem = desc;}

    public Double getLanceMin(){return lanceMinimo;}
    public void setLanceMin(Double lanceMin){this.lanceMinimo = lanceMin;}

    public Boolean getItemArrematado(){return itemArrematado;}
    public void setItemArrematado(Boolean itemArrematado){this.itemArrematado = itemArrematado;}

    public Lance getLanceArrematante(){return lanceArrematante;}
    public void setLanceArrematante(Lance lanceArrematante){this.lanceArrematante = lanceArrematante;}

    public void mostrar(){
        System.out.println("Leilão: " + leilao);
        System.out.println("Item: " + descricaoItem + ";" + idItem);
        System.out.println("Lance mínimo: " + lanceMinimo);
        System.out.println("Item Arrematado: " + itemArrematado);
        System.out.println("Lance Arrematante: " + lanceArrematante);
        System.out.println("--------------------------");
    }

      public ItemLeilao consultarItemLeilao(int id)throws Exception{

        FileReader fr = new FileReader("ItemLeilao.txt");
        BufferedReader br = new BufferedReader(fr);
        String linha = "";

        while((linha = br.readLine()) != null){
            String[] dados = linha.split(";");
            if(Integer.parseInt(dados[0]) == id){
                System.out.println("Item encontrado!");

                int idLeilao = Integer.parseInt(dados[1]);
                int idLance = Integer.parseInt(dados[5]);

                Leilao objLeilao = new Leilao();
                objLeilao = objLeilao.consultarLeilao(idLeilao);
                
                Lance objLance = null;
                

                ItemLeilao item = new ItemLeilao(id,objLeilao,dados[2],Double.valueOf(dados[3]),Boolean.valueOf(dados[4]),objLance);

                br.close();
                return item; 
            }
        }
        br.close();
        System.out.println("Item não encontrado!");
        return null;
    }
    public Boolean registrarItem(ItemLeilao i)throws Exception{
        ItemLeilao resultado =consultarItemLeilao(i.getId());

        if(resultado != null){
            System.out.println("Erro: item já existente!");
            return false;
        }else{
            FileWriter fw = new FileWriter("ItemLeilao.txt",true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(idItem +";"+ leilao +";"+ descricaoItem +";"+ lanceMinimo +";"+ itemArrematado +";"+ lanceArrematante);
            bw.newLine();
            bw.close();

            System.out.println("Participante registrado com sucesso!");
            return true;
        }
    }

    public void arrematarItem(Lance l){
        Double lanceAtual = lanceMinimo;
        if(l.getValor() > lanceAtual){
            lanceAtual += l.getValor();
        }
    }

    public ArrayList<ItemLeilao> listarItens()throws Exception{

        ArrayList<ItemLeilao> itens = new ArrayList<>();

        FileReader fr = new FileReader("ItemLeilao.txt");
        BufferedReader br = new BufferedReader(fr);
        String linha = "";

        while((linha = br.readLine()) != null){
            String[] dados = linha.split(";");
            
            int idItem = Integer.parseInt(dados[0]);
            int idLeilao = Integer.parseInt(dados[1]);
            String descricao = dados[2];
            Double lanceMinimo = Double.valueOf(dados[3]);
            Boolean arrematado = Boolean.valueOf(dados[4]);

            Leilao objLeilao = new Leilao().consultarLeilao(idLeilao);

        
            Lance objLance = null;
            ItemLeilao i = new ItemLeilao(idItem,objLeilao,descricao,lanceMinimo,arrematado,objLance);
            itens.add(i);
        }
        br.close();

        for( ItemLeilao i :itens){
            i.mostrar();
     }
     return itens;
    }
}
