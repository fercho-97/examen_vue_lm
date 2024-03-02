package com.example.demo.service;

import java.util.List;

import com.example.demo.service.to.EstudianteTo;

public interface IEstudianteService {

public void guardar(EstudianteTo estudianteTO);
	
	public EstudianteTo buscar (Integer id);
	
	public List<EstudianteTo> buscarTodos();

}
