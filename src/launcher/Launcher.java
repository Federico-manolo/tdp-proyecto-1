package launcher;
import gui.*;
import entities.*;


public class Launcher { 

	public static void main(String [] args) {
		
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
		Student alumno = new Student(131208, "Arias", "Federico", "ariasfede596@gmail.com","https://github.com/Federico-manolo","/images/imagen-perfil.png");
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {	
            	SimplePresentationScreen screen  = new SimplePresentationScreen(alumno);
            	screen.setVisible(true);
            }
        });
    }
	
	
}