import java.sql.Date;
import java.sql.Time;

public class Lance {
    private int idLance;
    private Participante participante;
    private ItemLeilao itemLeilao;
    private Double valorLance;
    private Date dataLance;
    private Time horaLance;

    public Lance(int id,Participante participante,ItemLeilao item,Double valor,Date data,Time hora){
        this.idLance = id;
        this.participante = participante;
        this.itemLeilao = item;
        this.valorLance = valor;
        this.dataLance = data;
        this.horaLance = hora;
    }

    public int getId(){return idLance;}
    public void setId(int id){this.idLance = id;}

    public Participante getParticipante(){return participante;}
    public void setParticipante(Participante participante){this.participante = participante;}

    public ItemLeilao getItemLeilao(){return itemLeilao;}
    public void setItemLeilao(ItemLeilao itemLeilao){this.ItemLeilao = itemLeilao;}

    public Double getValor(){return valorLance;}
    public void setValor(Double valor){this.valorLance = valor;}

    public Date getData(){return dataLance;}
    public void setData(Date data){this.dataLance = data;}

    public Time getHora(){return horaLance;}
    public void setHora(Time hora){this.horaLance = hora;}

}
