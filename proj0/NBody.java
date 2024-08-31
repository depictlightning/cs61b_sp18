/**
 * the simulator of this project
 */

public class NBody{

	public static double readRadius(String filename){
		In in = new In(filename);
		int num = in.readInt();
		double radius = in.readDouble();
		return radius;
	}

    /**
     * read the planets info from a txt 
    */
	public static Planet[] readPlanets(String filename){
		In in = new In(filename);
		int num = in.readInt();
		double radius = in.readDouble();
		Planet[] planets = new Planet[num];
		for (int i = 0; i < num; i++) {
			double xp = in.readDouble();
			double yp = in.readDouble();
			double vx = in.readDouble();
			double vy = in.readDouble();
			double m = in.readDouble();
			String img = in.readString();
			planets[i] = new Planet(xp, yp, vx, vy, m, img);	
		}
		return planets;
	}

    public static void main(String[] args){
        // input parameter
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double r = readRadius(filename);
        Planet[] planets = readPlanets(filename);
        // 
    }
}