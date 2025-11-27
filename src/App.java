import java.sql.Time;
import java.sql.Date;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);

    new java.io.File("Participante.txt").createNewFile();
    new java.io.File("Leilao.txt").createNewFile();
    new java.io.File("ItemLeilao.txt").createNewFile();
    new java.io.File("Lance.txt").createNewFile();
    
    System.out.println("\n--- 1. Cadastro de Participante ---");
    System.out.print("ID do Participante: ");
    int idParticipante = Integer.parseInt(sc.nextLine());
    System.out.print("Nome: ");
    String nome = sc.nextLine();
    System.out.print("Login: ");
    String login = sc.nextLine();
    System.out.print("Senha: ");
    String senha = sc.nextLine();
    System.out.print("Email: ");
    String email = sc.nextLine();
    System.out.print("Endereço: ");
    String endereco = sc.nextLine();
    System.out.print("Telefone: ");
    String telefone = sc.nextLine();

    Participante p = new Participante(idParticipante, nome, login, senha, email, endereco, telefone);
    p.registrarParticipantes(p);

    
    System.out.println("\n--- 2. Login Participante ---");
    System.out.print("Digite login: ");
    String loginInput = sc.nextLine();
    System.out.print("Digite senha: ");
    String senhaInput = sc.nextLine();
    try {
        Participante pLogin = new Participante(0, "", loginInput, senhaInput, "", "", "");
        Participante participanteLogado = pLogin.loginParticipante();
        if (participanteLogado != null) {
            System.out.println("Login realizado com sucesso!");
            p = participanteLogado; // usa o participante autenticado nas próximas operações
        } else {
            System.out.println("Login ou senha incorretos.");
        }
    } catch (Exception e) {
        System.out.println("Erro ao autenticar: " + e.getMessage());
    }

    System.out.println("\n--- 3. Cadastro de Leilão ---");
    System.out.print("ID do Leilão: ");
    int idLeilao = Integer.parseInt(sc.nextLine());
    System.out.print("Data de Início (YYYY-MM-DD): ");
    Date dataInicio = Date.valueOf(sc.nextLine());
    System.out.print("Hora de Início (HH:MM:SS): ");
    Time horaInicio = Time.valueOf(sc.nextLine());
    System.out.print("Data de Fim (YYYY-MM-DD): ");
    Date dataFim = Date.valueOf(sc.nextLine());
    System.out.print("Hora de Fim (HH:MM:SS): ");
    Time horaFim = Time.valueOf(sc.nextLine());

    Leilao l = new Leilao(idLeilao, dataInicio, horaInicio, dataFim, horaFim, false);
    l.registrarLeilao(l);

    
    System.out.println("\n--- 4. Consultar Leilão ---");
    l.consultarLeilao(idLeilao);


    System.out.println("\n--- 5. Iniciar Leilão ---");
    l.iniciarLeilao(l);

    System.out.println("\n--- 6. Finalizar Leilão ---");
    l.finalizarLeilao(l);

    System.out.println("\n--- 7. Cadastro de Item ---");
    System.out.print("ID do Item: ");
    int idItem = Integer.parseInt(sc.nextLine());
    System.out.print("Descrição do Item: ");
    String descItem = sc.nextLine();
    System.out.print("Lance mínimo: ");
    Double lanceMin = Double.parseDouble(sc.nextLine());

    ItemLeilao item = new ItemLeilao(idItem, l, descItem, lanceMin, false, null);
    item.registrarItem(item);

    System.out.println("\n--- 8. Listar Itens ---");
    item.listarItens();

    
    System.out.println("\n--- 9. Consultar Item ---");
    item.consultarItemLeilao(idItem);

    
    System.out.println("\n--- 10. Arrematar Item ---");
    System.out.print("Deseja arrematar o item? (S/N): ");
    String arrematar = sc.nextLine();
    if (arrematar.equalsIgnoreCase("S")) {
        // cria um lance mínimo para arrematar o item pelo participante atual
        Lance lanceArremate = new Lance(0, p, item, lanceMin, new Date(System.currentTimeMillis()), new Time(System.currentTimeMillis()));
        if (item.arrematarItem(lanceArremate)) {
            System.out.println("Item arrematado com sucesso por " + p.getNome());
        }
    }

    
    System.out.println("\n--- 11. Registro de Lance ---");
    System.out.print("ID do Lance: ");
    int idLance = Integer.parseInt(sc.nextLine());
    System.out.print("Valor do Lance: ");
    Double valorLance = Double.parseDouble(sc.nextLine());
    System.out.print("Data do Lance (YYYY-MM-DD): ");
    Date dataLance = Date.valueOf(sc.nextLine());
    System.out.print("Hora do Lance (HH:MM:SS): ");
    Time horaLance = Time.valueOf(sc.nextLine());

    Lance lance = new Lance(idLance, p, item, valorLance, dataLance, horaLance);
    lance.registrarLance();

    
    System.out.println("\n--- 12. Listar Lances ---");
    lance.listarLances();

    sc.close();
    System.out.println("Fim da Demonstração.");
        
    }
}