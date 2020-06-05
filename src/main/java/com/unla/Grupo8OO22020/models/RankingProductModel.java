package com.unla.Grupo8OO22020.models;

public class RankingProductModel {
    private long idProduct;
    private String description;
    private long quantitySold;

    public RankingProductModel() {
    	
    }
    
    public RankingProductModel(String description,long quantitySold) {
        this.description = description;
        this.quantitySold=quantitySold;
    }

	public long getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(long idProduct) {
		this.idProduct = idProduct;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getQuantitySold() {
		return quantitySold;
	}

	public void setQuantitySold(long quantitySold) {
		this.quantitySold = quantitySold;
	}
    
    

  
  


}