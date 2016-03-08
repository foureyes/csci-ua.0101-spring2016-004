class Circle {

  // a data field or instance variable, the radius
  // (it has a default value...)
  double radius = 1;

  // constructor - how to create a Circle object
  Circle() { }

  // another Constructor 
  Circle(double newRadius) {
    radius = newRadius;
  }

  // method to calculate the area based on the
  // instance variable, radius
  double getArea() {
    return radius * radius * Math.PI; 
  }
  
  // method to calculate the perimeter...
  double getPerimeter() {
    return 2 * radius * Math.PI; 
  }

  // set new radius for this circle 
  void setRadius(double newRadius) {
    radius = newRadius;
  }
}
