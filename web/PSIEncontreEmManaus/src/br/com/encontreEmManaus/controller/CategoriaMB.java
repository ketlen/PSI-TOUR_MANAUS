package br.com.encontreEmManaus.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.encontreEmManaus.dao.CategoriaDao;
import br.com.encontreEmManaus.dao.UsuarioDao;
import br.com.encontreEmManaus.entity.Categoria;
import br.com.encontreEmManaus.entity.Usuario;

@ManagedBean
@ViewScoped
public class CategoriaMB {

	private static final long serialVersionUID = 1L;
	private List<Categoria> categorias;
	private Categoria categoria;
	
	public CategoriaMB() {
		categorias = new ArrayList<Categoria>();
		categoria = new Categoria();
		listar();
	}
	
	public List<Categoria> getCategorias() {
		return categorias;
	}
	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public void salvar() {
		try {
			CategoriaDao dao = new CategoriaDao();
			if(categoria.getId() == null) {
				dao.salvar(categoria);
				this.categoria = new Categoria();
			} else {
				dao.editar(categoria);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		listar();
		
}

	public void deletar() {
		// ct = categoria;
		try{
		CategoriaDao dao = new CategoriaDao();
		dao.excluir(categoria);
		this.categoria = new Categoria();
		listar();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void listar() {
		try{
		CategoriaDao dao = new CategoriaDao();
		categorias = dao.listar();
		}catch(Exception e){
			e.printStackTrace();
		}

	}

}
