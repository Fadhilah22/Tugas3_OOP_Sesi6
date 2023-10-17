public class Car {
  public String car_name;
  public int car_speed;
  public int car_capacity;

  public Car (String arg_name, int arg_speed, int arg_capacity){
    this.car_name = arg_name;
    this.car_speed = arg_speed;
    this.car_capacity = arg_capacity;
  }

  public void printSpec(){
      System.out.println("Car name     : " + this.car_name);
      System.out.println("Car Speed    : " + this.car_speed);
      System.out.println("Car Capacity : " + this.car_capacity);
  }

  public static void main(String[] args) {
      System.out.println("Car class ready");
  }
}
