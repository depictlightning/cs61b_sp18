/**
 * create a Planet class
 */
public class Planet {
    public double xxPos;
    public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
	private double G = 6.67e-11;
	/**
	 * the constructor of Planet
	 * 
	 * @param xP  the position of x-direction
	 * @param yP  the position of y-direction
	 * @param xV  the velocity of x-direction
	 * @param yV  the velocity of y-direction
	 * @param m   the mass of the planet 
	 * @param img the img_name of planet
	 */
	public Planet(double xP, double yP, double xV,
				  double yV, double m, String img){
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}
	/**
	 * copy another planet 
	 * 
	 * @param p another planet
	 */
	public Planet(Planet p){
	
		xxPos = p.xxPos;
		yyPos = p.yyPos;
		xxVel = p.xxVel;
		yyVel = p.yyVel;
		mass = p.mass;
		imgFileName = p.imgFileName;
	}
	/**
	 * calculate the distance between this planet and another planet
	 * 
	 * @param p another planet
	 * 
	 * @return the distance
	 */
	public double calcDistance(Planet p){
		return Math.sqrt((xxPos - p.xxPos)*(xxPos - p.xxPos)
						+ (yyPos - p.yyPos)*(yyPos - p.yyPos));
	}

	public double calcForceExertedBy(Planet p){
		double r = calcDistance(p);
		return G * mass * p.mass /(r*r);
	}

	public double calcForceExertedByX(Planet p){
		double r = calcDistance(p);
		double dx = p.xxPos - xxPos;
		return calcForceExertedBy(p) * dx / r;
	}

	
	public double calcForceExertedByY(Planet p){
		double r = calcDistance(p);
		double dy = p.yyPos - yyPos;
		return calcForceExertedBy(p) * dy / r;
	}
	
	public double calcNetForceExertedByX(Planet[] allPlanets){
		double totalForce = 0;
		for(Planet planet : allPlanets){
			if (this.equals(planet)){
				continue;
			}
			totalForce += calcForceExertedByX(planet);
		}
		return totalForce;
	}

	public double calcNetForceExertedByY(Planet[] allPlanets){
		double totalForce = 0;
		for(Planet planet : allPlanets){
			if (this.equals(planet)){
				continue;
			}
			totalForce += calcForceExertedByY(planet);
		}
		return totalForce;
	}

	public void update(double dt,double fX,double fY){
		double ax = fX / mass;
		double ay = fY / mass;
		xxVel += dt * ax;
		yyVel += dt * ay;
		xxPos += xxVel * dt;
		yyPos += yyVel * dt;
	}
	/**
	 *  draw the Planet’s image at the Planet’s position
	 */
	public void draw(){
		StdDraw.picture(xxPos,yyPos,imgFileName);
	}

}
