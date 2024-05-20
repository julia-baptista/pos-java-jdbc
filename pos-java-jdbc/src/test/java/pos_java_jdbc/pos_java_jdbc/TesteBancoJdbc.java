package pos_java_jdbc.pos_java_jdbc;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import dao.UserPosDAO;
import model.BeanUserFone;
import model.Telefone;
import model.Userposjava;

public class TesteBancoJdbc {
	
	@Test
	public void initBanco() throws SQLException {
		UserPosDAO userPosDAO = new UserPosDAO();
		Userposjava userposjava = new Userposjava();
		
		// userposjava.setId(3L);
		userposjava.setNome("Matheus teste");
		userposjava.setEmail("matheus@gmail.com");	
		
		userPosDAO.salvar(userposjava);
	}
	
	@Test
	public void initListart() {
		UserPosDAO dao = new UserPosDAO();
		List<Userposjava> list;
		try {
			list = dao.listar();
			for (Userposjava userposjava : list) {
				System.out.println(userposjava);
				System.out.println("---------------------------");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void initBuscar() {
		UserPosDAO dao = new UserPosDAO();
		try {
			Userposjava userposjava = dao.buscar(1L);
			System.out.println(userposjava);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void initAtualizar() {
		try {
			UserPosDAO dao = new UserPosDAO();
			Userposjava objetoBanco = dao.buscar(1L);
			System.out.println(objetoBanco);
			objetoBanco.setNome("Nome mudado com metodo atualizar");
			dao.atualizar(objetoBanco);
			System.out.println("--------------");
			System.out.println(objetoBanco);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void initDeletar() {
		
		try {
			
			UserPosDAO dao = new UserPosDAO();
			dao.deletar(4L);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testeInsertTelefone() {
		
		Telefone telefone = new Telefone();
		telefone.setNumero("(87) 4445-4545");
		telefone.setTipo("Casa");
		telefone.setUsuario(2L);
		
		UserPosDAO userPosDAO = new UserPosDAO();
		userPosDAO.salvarTelefone(telefone);
		
	}
	
	@Test
	public void testeCarregaFoneUser() {
		
		UserPosDAO dao = new UserPosDAO();
		
		List<BeanUserFone> beanUserFones = dao.listaUserFone(1L);
		
		for (BeanUserFone beanUserFone : beanUserFones) {
			System.out.println(beanUserFone);
			System.out.println("------------------");
		}
		
	}
	
	@Test
	public void testeDeleteUserFone() {
		
		UserPosDAO dao = new UserPosDAO();
		dao.deleteFonesPorUser(1L);
		
	}
	
}
