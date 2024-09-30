package serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

     // necesitamos la lista de perros
        List <Dog> dogs = new ArrayList<>();
        dogs.add(new Dog(4, "Tarzan"));
        dogs.add(new Dog(7, "Toto"));
        dogs.add(new Dog(10, "Alfonso"));
        dogs.add(new Dog(2, "Mailot"));

     // necesitamos guardar la lista en el disco
        FileOutputStream fos = null; // manda informacion a un archivo
        try {

            fos = new FileOutputStream("Salida.txt");

            ObjectOutputStream oos = new ObjectOutputStream(fos); //escritura de los objetos
            oos.writeObject(dogs); // este metodo guarda la lista
            oos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


        // necesitamos recuperar la lista y mostrarla por pantalla
        List<Dog> dogList = null;
        FileInputStream fis = null; // para recuperar la lista necesitamos un flujo de entrada

        try {

            fis = new FileInputStream("Salida.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            dogList = (ArrayList)ois.readObject();
            ois.close();

        } catch (Exception e){
            e.printStackTrace();
        }

        for (Dog dogArraylist : dogList ) {
            System.out.println(dogArraylist);
        }

    }
}
