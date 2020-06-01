/** 
	* трёхмерный класс точки. 
**/ 
public class Point3d extends Point2d { 
	
	/**  координата Z **/ 
	private double zCrd; 
	/** Конструктор**/ 
	public Point3d ( double x,  double y, double z) { 
		super(x, y);
		zCrd = z; 
	} 
	/** Конструктор по умолчанию. **/ 
	public Point3d () { 
		//Вызовите конструктор с двумя параметрами и определите источник. 
		this(0, 0, 0); 
	} 
	
	/** Возвр координаты Z **/ 
	public double getZ () { 
		return zCoord; 
	} 
	
	/**  Присвоение значения координаты Z. **/ 
	public void  setZ ( double val) { 
		zCrd = val; 
	} 
	
	/**  Вычисление расстояния до другой точки **/ 
	public boolean  isEqual ( Point3d otherPoint) { 
		boolean compat;
		if (this.getX()==otherPoint.getX() && this.getY()==otherPoint.getY() && this.getZ()==otherPoint.getZ())
		compat=true;
		else compat=false;
		
		return compat; 
	}
	
	/**  Вычисление расстояния до другой точки **/ 
	public double  distanceTo ( Point3d otherPoint) { 
		
		double distance = Math.sqrt(Math.pow((this.getX() - otherPoint.getX()), 2) + Math.pow((this.getY() - otherPoint.getY()), 2) + Math.pow((this.getZ() - otherPoint.getZ()), 2));
		
		return distance; 
	} 
	
}