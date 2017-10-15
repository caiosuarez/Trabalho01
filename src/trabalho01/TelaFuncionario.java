/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho01;


import java.util.Date;
import java.util.Scanner;
/**
 *
 * @author Guilherme
 */
public class TelaFuncionario {

    private Scanner sc;
    private ControladorFuncionario ctrlFunc;
    
    
    public TelaFuncionario(){
        this.sc = new Scanner(System.in);
        this.ctrlFunc = new ControladorFuncionario();
    }
    
    public void exibeTela() {
        int opcao = 0;        
        do{
            System.out.println("\nMenu dos Funcionarios!");;
            System.out.println("-----------------------------------");
            System.out.println("1 - Cadastrar um novo funcionario");
            System.out.println("2 - Alterar o cargo de um funcionario pela sua matricula");
            System.out.println("3 - Deletar funcionario pela matricula");
            System.out.println("4 - Lista de todos os funcionarios");            
            System.out.println("0 - Encerrar");
            System.out.println("Selecione uma opção:");
            opcao = sc.nextInt();
            trataOpcao(opcao);
        } while(opcao != 0);     
        System.exit(0);
        
    }
    
    public void trataOpcao(int opcao){
        switch(opcao){
        case 1:
            System.out.println("Digite o nome do Funcionario");
            String nome = sc.nextLine();
            
            System.out.println("Digite a data de nascimento do Funcionario");
            String dataNascimento = sc.nextLine();
            
            System.out.println("Digite o telefone do Funcionario");
            int telefone = sc.nextInt();
            
            System.out.println("Digite o salario do Funcionario");
            double salario = sc.nextDouble();
            
            System.out.println("Digite o cargo do Funcionario");
            Cargo cargo = null;
            
            System.out.println("Digite o cpf do Funcionario");
            int cpf = sc.nextInt();
            
            ctrlFunc.cadastrarFuncionario(nome, dataNascimento, telefone, salario, cargo, cpf);
            break;
        
        case 2:
            System.out.println("Digite a matricula do Funcionario que deseja alterar o Cargo");
            int matricula = sc.nextInt();
            
            ctrlFunc.alterarCargoFuncionarioPelaMatricula(matricula, cargo);
            break;
        case 3:
            ControladorPrincipal.getInstance().exibeTelaAcesso();
            break;
        case 4:
            ControladorPrincipal.getInstance().exibeTelaRelatório();
            break;
        default:
            break;
        }
    }
}
    

