package ch.hslu.prg2.dotsandboxes.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import ch.hslu.prg2.dotsandboxes.Player;

public class GameModelPersister {

	public GameModelPersister() {
		
	}

	public static Player load(File file){
		
		try(FileInputStream inputStream = new FileInputStream(file+".data");
				ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);) 
		{
			return (Player) objectInputStream.readObject();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static void save(File file){
		try(FileOutputStream outputStream = new FileOutputStream(file+".data");
		ObjectOutputStream objectOutputStream = new ObjectOutputStream (outputStream);) 
		{
			//Change new Object to GameBoard
			objectOutputStream.writeObject (new Object());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
