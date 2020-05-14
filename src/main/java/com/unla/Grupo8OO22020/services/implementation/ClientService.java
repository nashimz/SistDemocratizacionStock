package com.unla.Grupo8OO22020.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.Grupo8OO22020.models.ClientModel;
import com.unla.Grupo8OO22020.converters.ClientConverter;
import com.unla.Grupo8OO22020.repositories.IClientRepository;
import com.unla.Grupo8OO22020.services.IClientService;
import com.unla.Grupo8OO22020.entities.*;
import java.util.*;


	@Service("clientService")
	public class ClientService implements IClientService {

		@Autowired
		@Qualifier("clientRepository")
		private IClientRepository clientRepository;
		
		@Autowired
		@Qualifier("clientConverter")
		private ClientConverter clientConverter;
		
		@Override
		public List<Client> getAll() {
			return clientRepository.findAll();
		}

		@Override
		public ClientModel insertOrUpdate(ClientModel clientModel) {
			Client client = clientRepository.save(clientConverter.modelToEntity(clientModel));
			return clientConverter.entityToModel(client);
		}

		@Override
		public boolean remove(long id) {
			try {
				clientRepository.deleteById(id);
				return true;
			}catch (Exception e) {
				return false;
			}
		}

		@Override
		public ClientModel findById(long id) {
			return clientConverter.entityToModel(clientRepository.findById(id));
		}

		@Override
		public ClientModel findByName(String name) {
			// TODO Auto-generated method stub
			return null;
		}

		
}