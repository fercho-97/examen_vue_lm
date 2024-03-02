package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IEstudianteRepository;
import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.to.EstudianteTo;

@Service
public class EstudianteServiceImpl implements IEstudianteService {

	@Autowired 
	private IEstudianteRepository estudianteRepository;

	@Override
	public void guardar(EstudianteTo estudianteTo) {
		// TODO Auto-generated method stub
		this.estudianteRepository.insertar(this.convertirAEntidad(estudianteTo));
	}

	@Override
	public EstudianteTo buscar(Integer id) {
		// TODO Auto-generated method stub
		EstudianteTo estuTo = this.convertirATo(this.estudianteRepository.seleccionar(id));
		return estuTo;
	}

	@Override
	public List<EstudianteTo> buscarTodos() {
		// TODO Auto-generated method stub
		
		List<Estudiante> estudiantes = this.estudianteRepository.seleccionarTodos();
		
		List<EstudianteTo> estudiantesTo = new ArrayList<>();
		
		for (Estudiante est : estudiantes) {
			estudiantesTo.add(this.convertirATo(est));
		}
		
		
		return estudiantesTo;
	}

	private Estudiante convertirAEntidad(EstudianteTo estudianteTo) {

		Estudiante estu = new Estudiante();

		estu.setId(estudianteTo.getId());
		estu.setNombre(estudianteTo.getNombre());
		estu.setApellido(estudianteTo.getApellido());
		estu.setCedula(estudianteTo.getCedula());

		return estu;
	}

	private EstudianteTo convertirATo(Estudiante estudiante) {

		EstudianteTo estuTo = new EstudianteTo();

		estuTo.setId(estudiante.getId());
		estuTo.setNombre(estudiante.getNombre());
		estuTo.setApellido(estudiante.getApellido());
		estuTo.setCedula(estudiante.getCedula());

		return estuTo;
	}
}