package com.unla.Grupo8OO22020.converters;

import org.springframework.stereotype.Component;
import com.unla.Grupo8OO22020.entities.Local;
import com.unla.Grupo8OO22020.models.LocalModel;

@Component("localConverter")
public class LocalConverter {
	
	public LocalModel entityToModel(Local local) {
		return new LocalModel(local.getId(), local.getTelefono(), local.getUbicacion(), local.getGerente());
	}

	public Local modelToEntity(LocalModel localModel) {
		return new Local(localModel.getId(), localModel.getTelefono(), localModel.getUbicacion(), localModel.getGerente());
	}
}
