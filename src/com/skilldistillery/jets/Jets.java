package com.skilldistillery.jets;


public abstract class Jets {
	// this is an abstract class that will require private fields and a no-arg
	// constructor
	// keep in mind autoboxing/wrapper classes of ints
	//private String type;
	private String model;
	private Double speed;
	private Long price;
	private Integer range;

	// constructors
	public Jets() {

	}

	// overloaded constructor
	public Jets(String _model, double _speed, long _price, int _range) {
		super();
	
		model = _model;
		speed = _speed;
		price = _price;
		range = _range;

	}

	// toString method
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[ Model = ").append(model).append(", Speed = ").append(speed).append(", Price = ")
				.append(price).append(", Range = ").append(range).append(" ] ");
		return builder.toString();
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

	// get and set methods
	

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Double getSpeed() {
		return speed;
	}

	public void setSpeed(Double speed) {
		this.speed = speed;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Integer getRange() {
		return range;
	}

	public void setRange(Integer range) {
		this.range = range;
	}

	// methods are the last to compile make sure it is abstract public void method()
	public void fly() {
		
		double distanceToRefuel = ((double) range) / speed;
		int hrsOfFlight = (int)((distanceToRefuel * 60) / 60);
		int minsOfFlight = (int)((distanceToRefuel * 60) % 60);
		toString();
		System.out.println("Currently Flying Jet Fuel Status:\n [ " + model + " flight time with remaining fuel of " + distanceToRefuel+" : Remaining "+hrsOfFlight +" hrs: "+minsOfFlight+ " mins ]");
		System.out.println("-----------------------------------------------------------------------------------");
	}

	public double getSpeedOfJetInMach() {
		double convertToMach = speed / 767.269;
		return Math.round(convertToMach * 100.0) / 100;
	}

}
