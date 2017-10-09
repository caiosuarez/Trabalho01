/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho01;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


import trabalho01.ControladorFuncionario;
/**
 *
 * @author Guilherme
 */
public class ControladorCargo {
    
    private ControladorFuncionario ctrlFuncionario;
    private ArrayList<Cargo> cargos;
    private int ultimoCodigo = 100;
    
    public void inserirCargo(Cargo cargo) {
        try {
            this.verificaCodigo(cargo.getCodigo());
        } catch (CadastroIncorretoException e) {
            System.out.println("Cargo Existente");
            //return;
        }
	this.cargos.add(cargo);
    }
    
    public void cadastraCargo(String nomeCargo, NivelAcesso NIVELACESSO) {
        int codigo = gerarCodigo();
	Cargo novoCargo = new Cargo(nomeCargo, codigo, NIVELACESSO);
        if(NIVELACESSO.equals(NivelAcesso.ESPECIAL)){
            Scanner sc = new Scanner(System.in);
            System.out.print("Digite a hora inicial: (Horas:Minutos)");
            String horarioInicio = sc.nextLine();
            
            System.out.print("Digite a hora final: (Horas:Minutos)");
            String horarioFinal = sc.nextLine();
        }
        for(Cargo cargoRef : cargos){
            if(!(novoCargo.getNomeCargo().equalsIgnoreCase(cargoRef.getNomeCargo())) || novoCargo.getCodigo() != cargoRef.getCodigo()){
                this.cargos.add(novoCargo);
            }
        }
    }
    
    public Cargo buscarCargoPeloCodigo (int codigoCargo){
        for(Cargo cargo : cargos){
            if(cargo.getCodigo() == codigoCargo){
                return cargo;
            }
        }
        return null;
    }
    
    public void deletarCargoPeloCodigo (int codigoCargo) throws FuncionarioComCargoException{
        ArrayList<Funcionario> listaFuncionarios = new ArrayList<>();
        listaFuncionarios = ctrlFuncionario.getFuncionarios();
        for(Funcionario func : listaFuncionarios){
            if(func.getCargo().getCodigo() == codigoCargo){
                throw new FuncionarioComCargoException("Existe Funcionarios com esse cargo");
            }
        }
        
        for(Cargo cargo : cargos){
            if(cargo.getCodigo() == codigoCargo){
                cargos.remove(cargo);
            }
        }        
    }
    
    public ArrayList<Cargo> listarCargos() {
        return this.cargos;
    } 

    private void verificaCodigo(int codigo)throws CadastroIncorretoException {
        for (Cargo cargo : this.cargos) {
            if (cargo.getCodigo() == codigo) {
		throw new CadastroIncorretoException("Codigo existente!");
            }
	}
    }
    
    public int gerarCodigo() {
        int novoCodigo = this.ultimoCodigo++;
        this.ultimoCodigo = novoCodigo;
        return novoCodigo;
    }
    
    public Date converterHora(String time){
        
        return null;
    }
}