/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho01;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Guilherme
 */
public class TelaCargo {
    
    private ControladorCargo owner;
    private Scanner sc;
    private static TelaCargo instance;
    

    public TelaCargo() {
    }
        
    public void exibeTela() {
        int opcao = 0;        
        do{
            System.out.println("\nMenu dos Cargos!");;
            System.out.println("-----------------------------------");
            System.out.println("1 - Cadastrar um novo cargo");
            System.out.println("2 - Alterar o nome do cargo pelo codigo");
            System.out.println("3 - Deletar cargo pelo codigo");
            System.out.println("4 - Lista de todos os cargos"); 
            System.out.println("5 - Buscar cargo pelo codigo"); 
            System.out.println("0 - Voltar");
            System.out.println("Selecione uma opção:");
            opcao = sc.nextInt();
            try {
                trataOpcao(opcao);
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        } while(opcao != -1);
    }
    public void trataOpcao(int opcao) throws CadastroIncorretoException {
        switch(opcao){
        case 1:
            telaCadastraCargo();
        case 2:
            telaAlterarNomeCargo();
            break;
        case 3:
            telaAlterarNomeCargo();
            break;
        case 4:
            ControladorCargo.getInstance().exibeCargos();
            break;
        case 5:
            telaExibeCargoPeloCodigo();
            break;
        case 0:
            ControladorPrincipal.getInstance().exibeTelaPrincipal();
        default:
            break;
        }
    }
    public void telaExibeCargoPeloCodigo(){
        System.out.println("\nBem vindo a tela de buscar cargo");
        System.out.println("\nDigite o código do cargo desejado");
        int codigo = this.sc.nextInt();
        Cargo cargoASerExibido = this.owner.buscarCargoPeloCodigo(codigo);
        if (cargoASerExibido == null){
            System.out.println("\nCargo inexistente");
        } else {
            exibeCargo(cargoASerExibido);
        }
    }
           
    public void telaAlterarNomeCargo() {
        try {
            System.out.println("\nBem vindo a tela de alterar nome do cargo");
            System.out.println("\nInsira o codigo do cargo que deseja mudar o nome");
            int codigo = this.sc.nextInt();
            Cargo cargoAAlterarNome = this.owner.buscarCargoPeloCodigo(codigo);
            if (cargoAAlterarNome == null) {
                System.out.println("Cargo inexistente");
            } else{
                System.out.println("\nDigite o novo nome do cargo");
                String novoNomeCargo = this.sc.nextLine();
                this.owner.alterarNomeCargoPeloCodigo(novoNomeCargo, codigo);
            }
            
        } catch (Exception e) {
            System.out.println("\nFormato incorreto de preenchimento");
        }
        
    }
    
    public void telaDeletaCargo() {
	try {
            if (!this.owner.haCargos()) {
		return;
            }
            System.out.println("\nBem vindo a tela de remocao de cargos");
            System.out.println("\nInsira o codigo do cargo a ser deletado");
            int codigo = this.sc.nextInt();
            Cargo cargoARemover = this.owner.buscarCargoPeloCodigo(codigo);
            if (cargoARemover == null) {
                System.out.println("\nCargo inexistente");
            } else {
                this.owner.deletarCargoPeloCodigo(codigo);
            }
        } catch (Exception e) {
            System.out.println("\nFormato incorreto de preenchimento");
            this.sc.nextLine();
            return;
        }

    }
    
    public void mensagemNaoHaCargos() {
		System.out.println("Nao ha cargos cadastrados\n");
	}
    
    
    public void telaCadastraCargo() throws CadastroIncorretoException {
		try {

                    ArrayList<Cargo> cargo = new ArrayList<>();
                    System.out.println("\nBem vindo a tela de cadastro de cargo");
                    System.out.println("\nInsira o nome do cargo");
                    String nomeCargo = this.sc.next();
                        
                    System.out.println("\nInsira o nível do cargo");
                    System.out.println("0. Livre:" + NivelAcesso.LIVRE.getNivelAcesso());
                    System.out.println("1. Especial" + NivelAcesso.ESPECIAL.getNivelAcesso());
                    System.out.println("2. Comum" + NivelAcesso.COMUM.getNivelAcesso());
                    System.out.println("3. Nulo" + NivelAcesso.NULO.getNivelAcesso());

                    int selecaoNivel = this.sc.nextInt();
                    NivelAcesso NIVELACESSO = NivelAcesso.COMUM;
                    if (selecaoNivel != 2) {
                        if (selecaoNivel == 1) {
                            NIVELACESSO = NivelAcesso.ESPECIAL;
                        } else if (selecaoNivel == 0) {
                            NIVELACESSO = NivelAcesso.LIVRE;
                        } else if (selecaoNivel == 3) {
                            NIVELACESSO = NivelAcesso.NULO;
                        }
                        selecaoNivel = this.sc.nextInt();

                    }
			
                    String opt = "";

                    if (selecaoNivel == 1 || selecaoNivel == 2) {
				
				
                    }

                    this.owner.cadastraCargo(nomeCargo, NIVELACESSO);
                        
		} catch (Exception e) {
			System.out.println("Formato Incorreto de Preenchimento");
			this.sc.nextLine();
			return;
		}
    }
    public void exibeCargo(Cargo cargo) {
		System.out.println("-----------------------------");
		System.out.println("Nome do cargo: " + cargo.getNomeCargo() + " \nNumero do codigo: " + cargo.getCodigo());
    }
    
    public void horariosEspeciais(){
        String horarioInicial = "";
        System.out.println("Digite a hora inicial: (Horas:Minutos)");
        hora = this.sc.next();
        String horarioFinal = "";
        System.out.println("Digite a hora final: (Horas:Minutos)");
        opt = this.sc.next();
    }
    
    public static TelaCargo getInstance() {
        if(instance == null) {
            instance = new TelaCargo();
        }
        
        return instance;
    }
}
