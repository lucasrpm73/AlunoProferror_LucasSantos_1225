/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg19_02_lp2_alunoprofessor;

import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) throws SQLException {
        EntradaDeDados entrada = new EntradaDeDados();

        String menu = "0- Sair\n1 - Salvar Aluno\n2 - Exibir Alunos"
                + "\n3 - Remover Aluno\n4- Salvar Professor\n"
                + "5 - Exibir Professores\n6 - Remover Professor";

        String opt = "";
        do {
            opt = JOptionPane.showInputDialog(menu);
            switch (opt) {
                case "0":
                    break;
                case "1":
                   entrada.entradaPessoa(opt);
                case "2":
                    entrada.exibirTodos(opt);
                    break;
                case "3":
                    entrada.removerAluno(opt);
                    break;
                case "4":
                    entrada.entradaPessoa(opt);
                    break;
                case "5":
                    entrada.exibirTodos(opt);
                    break;
                case "6":
                    entrada.removerProfessor(opt);
                    break;
                case "7":
                    entrada.dao.atualizarAluno(null);
                    break;
                case "8":
                        entrada.dao.atualizarProfessor(null);
                        break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida");
            }
        } while (!opt.equals("0"));
    }

}
