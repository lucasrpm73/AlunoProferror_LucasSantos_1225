/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg19_02_lp2_alunoprofessor;

import java.sql.SQLException;

import javax.swing.JOptionPane;
import modelo.Aluno;
import modelo.Professor;

public class EntradaDeDados {

    DAO dao = new DAO();

    public void entradaPessoa(String opcao) throws SQLException {
        String nome = JOptionPane.showInputDialog("Nome: ");
        String sexo = JOptionPane.showInputDialog("Sexo: ");
        long cpf = Long.parseLong(JOptionPane.showInputDialog("CPF: "));
        int idade = Integer.parseInt(JOptionPane.showInputDialog("Idade: "));
        if (opcao.equals("1")) {
            Aluno aluno = new Aluno(nome, sexo, cpf, idade);
            aluno.setRa(Integer.parseInt(JOptionPane.showInputDialog("RA: ")));
           //dao.salvar(aluno);//vai na lista
            dao.salvarAluno(aluno);// vai no banco
        } else {
            Professor professor = new Professor(nome, sexo, cpf, idade);
            professor.setSiape(Long.parseLong(JOptionPane.showInputDialog("SIAPE: ")));
           //dao.salvar(professor); //vai na lista
            dao.salvarProfessor(professor);//vai no Banco
        }
    }
    
    public void exibirTodos(String opcao) throws SQLException{
        dao.exibirTodos(opcao);
    }
    
    public void removerAluno(String opcao) throws NumberFormatException, SQLException{
        String cpf = JOptionPane.showInputDialog("Entre com o cpf de quem deseja remover: ");
        dao.removerAluno(Long.parseLong(cpf), opcao);
    }
    public void removerProfessor(String opcao) throws NumberFormatException, SQLException{
        String cpf = JOptionPane.showInputDialog("Entre com o cpf de quem deseja remover: ");
        dao.removerProfessor(Long.parseLong(cpf), opcao);
    }
    
}
