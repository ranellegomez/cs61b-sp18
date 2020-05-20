public class Planet {
    /** My current x position. */
    public double xxPos;

    /** My current y position. */
    public double yyPos;

    /** My current velocity in the x-direction. */
    public double xxVel;

    /** My current velocity in the y-direction. */
    public double yyVel;

    /** My mass */
    public double mass;

    /** The name of the file that corresponds to my image. */
    public String imgFileName;

    /** The constant G used to calculate gravitational force. */
    public static double G = 6.67e-11;

    /** My constructor. */
    public Planet(double xP, double yP, double xV, double yV, double m,
                  String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    /** A copy constructor that sets my instance variables to Planet p's. */
    public Planet(Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    /** Calculates the distance between two planets, given a Planet P */
    public double calcDistance(Planet p) {
        return Math.sqrt(Math.pow(p.xxPos - xxPos, 2)
                                 + Math.pow(p.yyPos - yyPos, 2));
    }

    /** Calculates the force exerted by me on Planet P. */
    public double calcForceExertedBy(Planet p) {
        return (G * mass * p.mass) / Math.pow(calcDistance(p), 2);
    }

}
