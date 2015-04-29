package br.com.encontreEmManaus.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.encontreEmManaus.dao.AgendaDao;
import br.com.encontreEmManaus.dao.UsuarioDao;
import br.com.encontreEmManaus.entity.Agenda;
import br.com.encontreEmManaus.entity.Usuario;

@ManagedBean
@ViewScoped
public class AgendaMB {

	private List<Agenda> agendas;
	private Agenda agenda;
	
	public AgendaMB() {
		agendas = new ArrayList<Agenda>();
		agenda = new Agenda();
		listar();
	}
	
	public List<Agenda> getAgendas() {
		return agendas;
	}
	public void setAgendas(List<Agenda> agendas) {
		this.agendas = agendas;
	}
	public Agenda getAgenda() {
		return agenda;
	}
	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}
	
	
	public void salvar() {
		try {
			AgendaDao dao = new AgendaDao();
		if(agenda.getId() == null) {
				dao.salvar(agenda);
			} else {
				dao.editar(agenda);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		listar();
}

	public void deletar() {
		// ag = agenda;
		try{
		AgendaDao dao = new AgendaDao();
		dao.excluir(agenda);
		}catch(Exception e){
			e.printStackTrace();
		}
		listar();
	}

	public void listar() {
		try{
		AgendaDao dao = new AgendaDao();
		agendas = dao.listar();
		}catch(Exception e){
			e.printStackTrace();
		}

	}

	
}
