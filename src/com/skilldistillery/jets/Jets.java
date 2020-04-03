package com.skilldistillery.jets;

public abstract class Jets {
	//this is an abstract class that will require private fields and a no-arg constructor
	//keep in mind autoboxing/wrapper classes of ints
	
	private String model;
	private Double speed;
	private Long price;
	private Integer range;
	
	//constructors 
	public Jets() {
		
	}
	//overloaded constructor 
	public Jets(String _model, double _speed, long _price, int _range) {
		super();
		model = _model;
		speed = _speed;
		price = _price;
		range = _range;
		
	}
	
	//toString method
	@Override
	public String toString() {
		return "Jets [model=" + model + ", speed=" + speed + ", price=" + price + ", range=" + range + "]";
	}
	
	// equals() and hashCode()
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((range == null) ? 0 : range.hashCode());
		result = prime * result + ((speed == null) ? 0 : speed.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jets other = (Jets) obj;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (range == null) {
			if (other.range != null)
				return false;
		} else if (!range.equals(other.range))
			return false;
		if (speed == null) {
			if (other.speed != null)
				return false;
		} else if (!speed.equals(other.speed))
			return false;
		return true;
	}
	
	
	//get and set methods
	public String getModel() {
		return model;
	}
	public void setModel(String _model) {
		model = _model;
	}
	public Double getSpeed() {
		return speed;
	}
	public void setSpeed(Double _speed) {
		speed = _speed;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long _price) {
		price = _price;
	}
	public Integer getRange() {
		return range;
	}
	public void setRange(Integer _range) {
		range = _range;
	}
	
	//methods are the last to compile make sure it is abstract public void method()
	abstract public void fly();
	
	abstract public void getSpeedOfJet(); 
	
}
