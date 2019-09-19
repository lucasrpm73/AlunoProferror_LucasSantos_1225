package pkg19_02_lp2_alunoprofessor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Aluno;
import modelo.Pessoa;
import modelo.Professor;

public class DAO {

    List<Pessoa> listaDePessoas = new ArrayList<>();

    public void salvar(Pessoa pessoa){
        listaDePessoas.add(pessoa);
    }

    public void exibirTodos(String opcao) throws SQLException {
    		//exibi todos da lista
       /** String msg = "";
        if (opcao.equals("2")) {
            for (int i = 0; i < listaDePessoas.size(); i++) {
                if (listaDePessoas.get(i) instanceof Aluno) {
                    Aluno aluno = (Aluno) listaDePessoas.get(i);
                    msg += aluno.getNome() + " - RA: " + aluno.getRa() + "\n";
                }
            }
        } else {
            for (int i = 0; i < listaDePessoas.size(); i++) {
                if (listaDePessoas.get(i) instanceof Professor) {
                    Professor professor = (Professor) listaDePessoas.get(i);
                    msg = professor.getNome() + " - SIAPE: " + professor.getSiape();
                }
            }
        }
        JOptionPane.showMessageDialog(null, msg);**/
    				//Exibe todos do banco
    	 Connection con = null;
    	 Aluno Aluno = new Aluno();
    	 
    	 if(opcao == "2") {
	         try {
	         	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/LP2", "root", "el15122019");
	         	    	String sql = "select * from Aluno";
	       
	 		} catch (Exception e) {
	 			JOptionPane.showMessageDialog(null, e.getMessage());
	 		} finally {
	 			con.close();
	 		}
    	 }
    	 else {
    		 try {
 	         	con = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "el15122019");
 	         	    	String sql = "select * from Produto";
 	       
 	 		} 
    		 catch (Exception e) {
 	 			JOptionPane.showMessageDialog(null, e.getMessage());
 	 		} 
    		 finally {
 	 			con.close();
 	 		}
     	 }
    		 
}


    public void removerAluno(long cpf, String opcao) throws SQLException {
        		//remove da lista
       /** for (Pessoa pessoa : listaDePessoas) {
            if (pessoa.getCpf() == cpf) {
                if ((opcao.equals("3") && pessoa instanceof Aluno)
                        || (opcao.equals("6") && pessoa instanceof Professor)) {
                    listaDePessoas.remove(pessoa);
                    JOptionPane.showMessageDialog(null, pessoa.getClass().getSimpleName()
                            + " Removido com sucesso!");
                    removido = true;
                }
            }
        }**/
        
        //remove do banco
        	
        Connection con = null;
        
        
        try {
        	boolean removido = true;
        	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/LP2", "root", "el15122019");
        	if (!removido) {
                JOptionPane.showMessageDialog(null, "CPF nÃ£o encontrado");
            } else {
        	    	String sql = "delete from Aluno where cpf = ?";
        	    	
        	JOptionPane.showConfirmDialog(null, "Removido com sucesso!");
            }
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} finally {
			con.close();
			}
        }
    
    public void removerProfessor(long cpf, String opcao) throws SQLException {
        //remove do banco
        	
        Connection con = null;
        
        
        try {
        	boolean removido = true;
        	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/LP2", "root", "el15122019");
        	if (!removido) {
                JOptionPane.showMessageDialog(null, "CPF não encontrado");
            } else {
        	    	String sql = "delete from Professor where cpf = ?";
        	    	
        	JOptionPane.showConfirmDialog(null, "Removido com sucesso!");
            }
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} finally {
			con.close();
		}
    }
    
    
    
    
    
    
    
    
    
    
    
    
    public void salvarAluno(Aluno aluno) throws SQLException{
        Connection conexao = null;
        try {
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/LP2", "root", "el15122019");
            String sql = "insert into aluno (nome, idade,cpf, ra) " +
                    "values(?,?,?,?)";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, aluno.getNome());
            ps.setInt(2, aluno.getIdade());
            ps.setLong(3, aluno.getCpf());
            ps.setInt(4, aluno.getRa());
            int retorno = ps.executeUpdate();
            if (retorno > 0) {
                JOptionPane.showMessageDialog(null, "Salvo com Sucesso !");
            }            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } finally{
            conexao.close();
        	}
        }
        
        public void salvarProfessor(Professor Professor) throws SQLException{
            Connection conexao = null;
            try {
                conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/LP2", "root", "el15122019");
                String sql = "insert into aluno (nome,idade,cpf,siape) " +
                        "values(?,?,?,?)";
                PreparedStatement ps = conexao.prepareStatement(sql);
                ps.setString(1, Professor.getNome());
                ps.setInt(2, Professor.getIdade());
                ps.setLong(3, Professor.getCpf());
                ps.setLong(4, Professor.getSiape());
                int retorno = ps.executeUpdate();
                if (retorno > 0) {
                    JOptionPane.showMessageDialog(null, "Salvo com Sucesso !");
                }
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            		} finally{
		                conexao.close();
		}
    }
        
        
        public void atualizarAluno(Aluno aluno) throws SQLException{
            Connection conexao = null;
            try {
                conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/LP2", "root", "el15122019");
                String sql = "update aluno set nome = ?, idade = ?, sexo = ?, cpf = ?, ra = ?, where cpf = ?";
                PreparedStatement ps = conexao.prepareStatement(sql);
                ps.setString(1, aluno.getNome());
                ps.setInt(2, aluno.getIdade());
                ps.setString(3, aluno.getSexo());
                ps.setLong(4, aluno.getCpf());
                ps.setInt(5, aluno.getRa());
                
                int retorno = ps.executeUpdate();
                if (retorno > 0) {
                    JOptionPane.showMessageDialog(null, "Aluno Atualizado com Sucesso !");
                }            
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            } finally{
                conexao.close();
                }
        }


            public void atualizarProfessor(Professor Professor) throws SQLException{
            Connection conexao = null;
            try {
                conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/LP2", "root", "el15122019");
                String sql = "update professor set nome = ?, idade = ?, sexo = ?, cpf = ?, siape = ? where cpf = ?";
                PreparedStatement ps = conexao.prepareStatement(sql);
                ps.setString(1, Professor.getNome());
                ps.setInt(2, Professor.getIdade());
                ps.setString(3, Professor.getSexo());
                ps.setLong(3, Professor.getCpf());
                ps.setLong(4, Professor.getSiape());
                
                int retorno = ps.executeUpdate();
                if (retorno > 0) {
                    JOptionPane.showMessageDialog(null, "Professor Atualizado com Sucesso !");
                }            
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            } finally{
                conexao.close();
                }
        
            }

   }
