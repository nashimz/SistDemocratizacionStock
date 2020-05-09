package com.unla.Grupo8OO22020.services;

import com.unla.Grupo8OO22020.entities.Local;
import com.unla.Grupo8OO22020.models.LocalModel;

import java.util.List;


public interface ILocalService {
	public List<Local> getAll();
	
	public LocalModel findById(int id);
	
	LocalModel insertOrUpdate(LocalModel localModel);
	
	public boolean remove(int id);

}
