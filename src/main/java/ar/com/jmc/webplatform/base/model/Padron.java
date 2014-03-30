package ar.com.jmc.webplatform.base.model;

public class Padron {
	
	private String cuit;
	private Double alicuota;
	
	
	public String getCuit() {
		return cuit;
	}
	public void setCuit(String cuit) {
		this.cuit = cuit;
	}
	
	
	public Double getAlicuota() {
		return alicuota;
	}
	public void setAlicuota(Double alicuota) {
		this.alicuota = alicuota;
	}
	public String toString() {
		return "Cuit: " + this.getCuit() + " Alicuota: " + this.getAlicuota();
	}
	
	

}
