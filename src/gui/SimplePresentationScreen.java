package gui;

import java.awt.Dimension;
import java.awt.Image;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import entities.Student;


@SuppressWarnings("serial")
public class SimplePresentationScreen extends JFrame {
	
	private JPanel contentPane;
	private JPanel tabInformation;
	private JTabbedPane tabbedPane;
	private Student studentData;
	private Calendar fecha;
	
	
	public SimplePresentationScreen(Student studentData) {
		this.studentData = studentData;
		
		contentPane = new JPanel(); 
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		//Creamos un objeto fecha con el que formaremos la fecha y horario actual que se verá por pantalla.
		fecha = new GregorianCalendar(); 
		

		setTitle("TdP-DCIC-UNS 2021 :: Pantalla de presentación");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(640, 272));
		setResizable(false);
		setContentPane(contentPane);
		
		//Imágen del ícono de TDP. 
		Image icon = new ImageIcon (getClass().getResource("/images/tdp.png")).getImage();
		setIconImage(icon);
		
		init();
	}
	
	private void init() {
		contentPane.setLayout(null);
		// Tabbed Pane to student personal data
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 5, 430, 211);
		tabInformation = new JPanel();
		tabInformation.setPreferredSize(new Dimension(425, 275));
		tabbedPane.addTab("Información del alumno", null, tabInformation, "Muestra la información declarada por el alumno");
		contentPane.add(tabbedPane);
		tabInformation.setLayout(null);
		
		
		//Información personal del alumno
		JLabel nombre = new JLabel("Nombre");
		nombre.setBounds(10, 76, 54, 14);
		tabInformation.add(nombre);
		
		JLabel apellido = new JLabel("Apellido");
		apellido.setBounds(10, 44, 46, 14);
		tabInformation.add(apellido);
		
		JLabel lu = new JLabel("LU");
		lu.setBounds(10, 11, 46, 14);
		tabInformation.add(lu);
		
		JLabel email = new JLabel("E-mail");
		email.setBounds(10, 107, 46, 14);
		tabInformation.add(email);
		
		JLabel gitUrl = new JLabel("Github URL");
		gitUrl.setBounds(10, 144, 63, 14);
		tabInformation.add(gitUrl);
		
		JTextField luField = new JTextField();
		luField.setText(Integer.toString(studentData.getId()));
		luField.setBounds(116, 8, 285, 20);
		tabInformation.add(luField);
		
		JTextField apellidoField = new JTextField();
		apellidoField.setText(studentData.getLastName());
		apellidoField.setBounds(116, 41, 285, 20);
		tabInformation.add(apellidoField);
		
		JTextField nombreField = new JTextField();
		nombreField.setText(studentData.getFirstName());
		nombreField.setBounds(116, 73, 285, 20);
		tabInformation.add(nombreField);
		
		JTextField mailField = new JTextField();
		mailField.setText(studentData.getMail());
		mailField.setBounds(116, 104, 285, 20);
		tabInformation.add(mailField);
		
		JTextField gitUrlField = new JTextField();
		gitUrlField.setText(studentData.getGithubURL());
		gitUrlField.setBounds(116, 141, 285, 20);
		tabInformation.add(gitUrlField);
		
		
		//Imagen personal del alumno
		JLabel imagen = new JLabel("");
		imagen.setBounds(440, 21, 172, 198);
		ImageIcon fot = new ImageIcon(SimplePresentationScreen.class.getResource(studentData.getPathPhoto()));
		Icon icono = new ImageIcon(fot.getImage().getScaledInstance(imagen.getWidth(), imagen.getHeight(), Image.SCALE_DEFAULT));
		imagen.setIcon(icono);
		contentPane.add(imagen);
		
		//Fecha y hora en la que la ventana se lanzó a ejecución 
		String fechaCompleta = Integer.toString(fecha.get(Calendar.DATE))+"/"+
				Integer.toString(fecha.get(Calendar.MONTH)+1)+"/"+ //Al empezar el primer mes (enero) del año con 0, entonces sumamos 1 para obtener el mes acorde a nuestro calendario 
				Integer.toString(fecha.get(Calendar.YEAR));
		String horaCompleta = Integer.toString(fecha.get(Calendar.HOUR_OF_DAY))+":"+
				Integer.toString(fecha.get(Calendar.MINUTE))+":"+
				Integer.toString(fecha.get(Calendar.SECOND));
		JLabel tiempo = new JLabel("Esta ventana fue generada el "+fechaCompleta+" a las: "+ horaCompleta);
		tiempo.setBounds(26, 218, 359, 14);
		contentPane.add(tiempo);
	}
}