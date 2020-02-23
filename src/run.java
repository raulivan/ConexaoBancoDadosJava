import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import br.com.raulivan.conexaodb.JConnectionfactory;
import br.com.raulivan.conexaodb.TipoSGBD;

public class run {

	public static void main(String[] args) {
		
		try {
			//Conecta no banco de dados
			Connection conn = JConnectionfactory.getConnection(TipoSGBD.MSSQL);
			System.out.println("Conectou com sucesso!");
			
			//Variavel usado para armazenar as consultas sql
			String sql;
			
			//Incluindo no banco de dados
			sql = "INSERT INTO CONTATO values (?,?)";
			//Permite passar parâmetros para sql
			PreparedStatement pstm = conn.prepareStatement(sql);
			
			//Define os valores de cada parâmetro
			pstm.setString(1, "Raulivan Rodrigo");
			pstm.setString(2, "37999999999");
			
			//Executa a sql
			pstm.execute();
			System.out.println("Inclui o registro com sucesso!");
			//Fecha o PreparedStatement
			pstm.close();
			pstm = null;
			
			//Recuperar registros do banco de dados
			int id = 0; //armazenar o id para aletração
			sql = "SELECT * FROM CONTATO ORDER BY Nome";
			
			//Cria o Statement
			Statement stm = conn.createStatement();
			
			//Arameza o resultado em um ResultSet, para percorrer cada registro
			ResultSet rs = stm.executeQuery(sql);
			
			//Enquando houver proximo, vai percorrendo
			while(rs.next()) {
				id = rs.getInt(1);
				System.out.printf("Id = %s - Nome: %s - Telefone: %s \n",
						rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3));
			}
			rs.close();
			stm.close();
			stm = null;
			
			//Atualizar registro no banco de dados
			sql = "UPDATE CONTATO SET Nome = ? WHERE Id = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, "ALTERADO");
			pstm.setInt(2, id);
			pstm.execute();
			System.out.println("Registro alterado");
			pstm.close();
			pstm = null;
			
			//Excluindo registros
			sql = "DELETE FROM CONTATO";
			stm = conn.createStatement();
			stm.execute(sql);
			System.out.println("Apagou todos os registros do banco de dados");
			stm.close();
			stm = null;
			
			//Fecha a conexão
			conn.close();
		}catch (Exception ex) {
			System.out.println("Falha ao conectar.\nErro:");
			System.out.println(ex.getMessage());
		}
		

	}
}
