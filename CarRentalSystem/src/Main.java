import javax.imageio.IIOException;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        CarRentalSystem rentalSystem=new CarRentalSystem();

        Car car1=new Car("C001","Toyota","camry",2000.00);
        Car car2=new Car("C002","honda","Accord",3000.00);
        Car car3=new Car("C003","Mahindra","Thar",50000.00);

        rentalSystem.addCar(car1);
        rentalSystem.addCar(car2);
        rentalSystem.addCar(car3);
        rentalSystem.menu();

try {
    ObjectOutputStream output=new ObjectOutputStream(new FileOutputStream("carlist.dat"));
    output.writeObject(car1);
    output.writeObject(car2);
    output.writeObject(car3);
    output.close();
}
      catch (IOException ioe){
    System.err.println("Error saving to file");
      }
        CarRentalSystem carRentalSystem=null;
try {

    ObjectInputStream input=new ObjectInputStream(new FileInputStream("carList.dat"));
    carRentalSystem=(CarRentalSystem) input.readObject();
    input.close();
}
catch (IOException ioe){
    System.err.println("error opening file");
}

 catch (ClassNotFoundException cnfe) {
   System.err.println("object read is not car");
}

        System.out.println("--------------");
        System.out.println(carRentalSystem);
    }
}
