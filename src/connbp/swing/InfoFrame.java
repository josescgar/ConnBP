package connbp.swing;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import connbp.helper.Inicializador;
import connbp.helper.Person;

public class InfoFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	public InfoFrame(Person p, int x, int y) {
		super(p.getName()+" ["+p.getID()+"]");
		this.setLocation(x, y);
		this.setResizable(false);
		JPanel panel = new JPanel(new SpringLayout());
		Set<String> atributos = Inicializador.getInstance().getValidAttrPeople().keySet();
		for(String attr:atributos){
			panel.add(new JLabel(attr+":"));
			JTextField t = null;
			try {
				Method method = p.getClass().getDeclaredMethod("get"+attr);
				t = new JTextField((String)method.invoke(p), 15);
				t.setEditable(false);
			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				e.printStackTrace();
				return;
			}
			panel.add(t);
		}

		SpringUtilities.makeCompactGrid(panel, atributos.size(), 2, 6, 6, 6, 6);
		this.add(panel);
		this.pack();
	}
	
	public void showInfo(){
		this.setVisible(true);
	}
}
