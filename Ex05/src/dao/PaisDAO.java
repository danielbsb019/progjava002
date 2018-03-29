package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import factory.ConexaoF;
import model.Pais;

public class PaisDAO {

	public int incluir(Pais pais){
		String sqlInsert = "INSERT INTO pais(Nome_Pais, Populacao_Pais, Area_Pais) VALUES (?, ?, ?)";
		try {	
		Connection conn = ConexaoF.obtemConexao();
			PreparedStatement stm = conn.prepareStatement(sqlInsert);

			stm.setString(1, pais.getNome());
			stm.setLong(2, pais.getPop());
			stm.setDouble(3, pais.getArea());
			stm.execute();
			
			
			String sqlquery = "Select last_insert_id() as Id_Pais";
			stm = conn.prepareStatement(sqlquery);
			ResultSet rs = stm.executeQuery();
			
			
			if(rs.next()) {
				pais.setId(rs.getInt("Id_Pais"));
				//pais.setArea(rs.getDouble("Area_Pais"));
				//pais.setPop(rs.getLong("Populacao_Pais"));
				//pais.setNome(rs.getString("Nome_Pais"));
			}
		}catch(SQLException e) { 
					
					System.out.println(e);
				
				}
		return pais.getId();

	}

	// excluir
	public void excluir(Pais pais) {
		String sqlDelete = "DELETE FROM pais WHERE  Id_Pais= ?";
		try (Connection conn = ConexaoF.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, pais.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	// atualizar Pais
	public void atualizarPais(Pais pais, String NovoPais) {
		String sqlUpdate = "UPDATE pais SET Nome_Pais = ? WHERE Id_Pais = ?";

		try (Connection conn = ConexaoF.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, NovoPais);
			stm.setInt(2, pais.getId());

			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	// carregar
	public Pais carregar(int id) {
		Pais pais = new Pais();
		pais.setId(id);
		String sqlSelect = "SELECT * FROM pais WHERE Id_Pais = ?";

		try (Connection conn = ConexaoF.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, pais.getId());

			try (ResultSet rs = stm.executeQuery();) {

				if (rs.next()) {
					pais.setId(rs.getInt("Id_Pais"));
					pais.setNome(rs.getString("Nome_Pais"));
					pais.setArea(rs.getDouble("Area_Pais"));
					pais.setPop(rs.getLong("Populacao_Pais"));
				} else {
					pais.setId(-1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return pais;
	}

	// listar pais com maior população
	
	public void maiorPopulacao(Pais pais) {
		String sqlSelect = "SELECT * FROM pais where Populacao_Pais = (select max(Populacao_Pais) from pais) ";

		try (Connection conn = ConexaoF.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {

				while (rs.next()) {

					pais.setId(rs.getInt("Id_Pais"));
					pais.setNome(rs.getString("Nome_Pais"));
					pais.setPop(rs.getLong("Populacao_Pais"));
					pais.setArea(rs.getDouble("Area_Pais"));

				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
	}

	public void menorArea(Pais pais) {
		String sqlSelect = "SELECT * FROM pais where Area_Pais = (select min(Area_Pais) from pais) ";

		try (Connection conn = ConexaoF.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {

				while (rs.next()) {

					pais.setId(rs.getInt("Id_Pais"));
					pais.setNome(rs.getString("Nome_Pais"));
					pais.setPop(rs.getLong("Populacao_Pais"));
					pais.setArea(rs.getDouble("Area_Pais"));
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
	}

	public String[] nomes() {
		String sqlSelect = "SELECT Nome_Pais FROM pais order by Nome_Pais ";

		int cont = 0;
		String[] lista = new String[3];
		try (Connection conn = ConexaoF.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {

				while (rs.next() && cont < 3) {

					lista[cont] = rs.getString("Nome_Pais");
					cont++;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}

}
