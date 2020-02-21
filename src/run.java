import java.sql.Connection;

import br.com.raulivan.conexaodb.JConnectionfactory;
import br.com.raulivan.conexaodb.TipoSGBD;

public class run {

	public static void main(String[] args) {
		
		try {
			Connection conn = JConnectionfactory.getConnection(TipoSGBD.MSSQL);
			System.out.println("Conectou com sucesso!");
			conn.close();
		}catch (Exception ex) {
			System.out.println("Falha ao conectar.\nErro:");
			System.out.println(ex.getMessage());
		}
		

	}

}
