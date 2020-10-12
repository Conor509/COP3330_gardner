//Conor Gardner

public abstract class Shape {

    public abstract String getName();
    public abstract double getArea();
}//end class Shape

abstract class Shape2D extends Shape {

}//end class 2D

abstract class Shape3D extends Shape2D {
    public abstract double getVolume();

}//end class 3D

class Square extends Shape2D {
    public double len;
    public Square(double a) {
        len = a;
    }//end constructor

    public String getName() {
        return("square");
    }//end get name

    public double getArea() {
        return(len * len);
    }//end get area

}//end square

class Triangle extends Shape2D {
    public double base, height;
    public Triangle(double a, double b) {
        base = a;
        height = b;
    }//end constructor

    public String getName() {
        return("triangle");
    }//end get name

    public double getArea() {
        return(base * height * .5);
    }//end get area
}//end triangle

class Circle extends Shape2D {
    public double rad;
    public Circle(double a) {
        rad = a;
    }//end constructor

    public String getName() {
        return("circle");
    }//end get name

    public double getArea() {
        return(Math.PI * rad * rad);
    }//end get Area
}//end circle

//-------------------------------------------------

class Cube extends Shape3D {
    public double len;
    public Cube(double a) {
        len = a;
    }//end constructor

    public String getName() {
        return("cube");
    }//end get name

    public double getArea() {
        return(len * len * 6);
    }//end get area

    public double getVolume() {
        return(len * len * len);
    }//end get volume
}//end cube

class Pyramid extends Shape3D {
    double len, width, height;
    public Pyramid(double a, double b, double c) {
        len = a;
        width = b;
        height = c;
    }//end constructor

    public String getName() {
        return("pyramid");
    }//end get name

    public double getArea() {
        double temp1 = (len * width);
        double temp2 = len * (Math.sqrt(width/2.0 * width/2.0 + height * height));
        double temp3 = width * (Math.sqrt(len/2.0 * len/2.0 + height * height));
        return(temp1 + temp2 + temp3);
    }//end get area

    public double getVolume() {

        return((len * width * height)/3);
    }//end get volume
} //end pyramid

class Sphere extends Shape3D {
    double rad; // IM ASSUMING THAT THE RAD IS VALUE GIVEN
    public Sphere(double a) {
        rad = a;
    }//end constructor

    public String getName() {
        return("sphere");
    }//end get name

    public double getArea() {
        return(((4.0)* Math.PI)*rad * rad);
    }//end get area

    public double getVolume() {
        double temp = (4.0/3.0) * Math.PI;
        double radCubed = rad * rad * rad;
        return(temp * radCubed);
    }//end get volume
}//end sphere