package com.klef.jfsd.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ClientDemo {
    public static void main(String[] args) {
        Configuration config = new Configuration().configure();
        config.addAnnotatedClass(Vehicle.class);
        config.addAnnotatedClass(Car.class);
        config.addAnnotatedClass(Truck.class);

        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        // Create Car object
        Car car = new Car();
        car.setName("Sedan");
        car.setType("Car");
        car.setMaxSpeed(220);
        car.setColor("Red");
        car.setNumberOfDoors(4);

        // Create Truck object
        Truck truck = new Truck();
        truck.setName("Lorry");
        truck.setType("Truck");
        truck.setMaxSpeed(120);
        truck.setColor("Blue");
        truck.setLoadCapacity(15000);

        // Save objects
        session.save(car);
        session.save(truck);

        transaction.commit();
        session.close();

        System.out.println("Records inserted successfully!");
    }
}
