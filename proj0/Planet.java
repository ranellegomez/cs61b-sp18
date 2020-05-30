public class Planet {
    /**
     * My current x position.
     */
    public double xxPos;

    /**
     * My current y position.
     */
    public double yyPos;

    /**
     * My current velocity in the x-direction.
     */
    public double xxVel;

    /**
     * My current velocity in the y-direction.
     */
    public double yyVel;

    /**
     * My mass
     */
    public double mass;

    /**
     * The name of the file that corresponds to my image.
     */
    public String imgFileName;

    /**
     * The constant G used to calculate gravitational force.
     */
    public static double G = 6.67e-11;

    /**
     * My constructor.
     */
    public Planet(double xP, double yP, double xV, double yV, double m,
                  String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    /**
     * A copy constructor that sets my instance variables to Planet p's.
     */
    public Planet(Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }


    /**
     * Calculates the distance between two planets, given a Planet P
     */
    public double calcDistance(Planet p) {
        return Math.sqrt(Math.pow(p.xxPos - xxPos, 2)
                                 + Math.pow(p.yyPos - yyPos, 2));
    }

    /**
     * Calculates the force exerted by me on Planet P.
     */
    public double calcForceExertedBy(Planet p) {
        return (G * mass * p.mass) / Math.pow(calcDistance(p), 2);
    }

    /**
     * Calculates the x-direction force exerted by me on Planet P.
     */
    public double calcForceExertedByX(Planet p) {
        //double angle = Math.atan((p.yyPos - yyPos) / (p.xxPos - xxPos));
        //double angle = Math.atan2(p.yyPos, p.xxPos) - Math.atan2(yyPos,
        // xxPos);
        //System.out.println(Math.cos(angle));
        //return calcForceExertedBy(p) * Math.cos(Math.toDegrees(angle));
        return calcForceExertedBy(p) * (p.xxPos - xxPos) / calcDistance(p);
    }

    /**
     * Calculates the y-direction force exerted by me on Planet P.
     */
    public double calcForceExertedByY(Planet p) {
        double angle = Math.atan((p.yyPos - yyPos) / (p.xxPos - xxPos));
        System.out.println(Math.sin(angle));
        //return calcForceExertedBy(p) * Math.sin(angle) / calcDistance(p);
        return calcForceExertedBy(p) * (p.yyPos - yyPos) / calcDistance(p);
    }

    /**
     * Calculates the x-direction net force exerted by me on Planet[] P.
     */
    public double calcNetForceExertedByX(Planet[] planets) {
        double xNetForce = 0;
        for (Planet p : planets) {
            if (!p.equals(this)) { //!p.equals(this)
                xNetForce += calcForceExertedByX(p);
            }
        }
        return xNetForce;
    }

    /**
     * Calculates the x-direction net force exerted by me on Planet[] P.
     */
    public double calcNetForceExertedByY(Planet[] planets) {
        double yNetForce = 0;
        for (Planet p : planets) {
            if (!p.equals(this)) {
                yNetForce += calcForceExertedByY(p);
            }
        }
        return yNetForce;
    }

    /** Determines how much the forces exerted on the planet will cause that
     * planet to accelerate, and the resulting change in the planet’s velocity
     * and position in a small period of time dt.
     */
    public void update(double time, double xForce, double yForce) {
        double xAcceleration = xForce / mass;
        double yAcceleration = yForce / mass;

        xxVel += time * xAcceleration;
        yyVel += time * yAcceleration;

        xxPos += time * xxVel;
        yyPos += time * yyVel;
    }
}
