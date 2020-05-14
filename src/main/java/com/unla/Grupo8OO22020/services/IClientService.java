package com.unla.Grupo8OO22020.services;

import com.unla.Grupo8OO22020.entities.Client;
import com.unla.Grupo8OO22020.models.ClientModel;

import java.util.*;

public interface IClientService {
public List<Client> getAll();


	public ClientModel findById(int id);
	
	public ClientModel findByName(String name);
	
	public ClientModel insertOrUpdate(ClientModel clientModel);
	
	public boolean remove(int id);
	
	
}