package bread_kiosk;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class makejlabel {
	public makejlabel(ArrayList<JLabel> a, String[] b, JPanel c) {
		// TODO Auto-generated constructor stub
		int max = 3;
		for(int i = 0; i<max; i++) {
			a.add(new JLabel(b[i]));
			a.get(i).setBounds(75+(i*100),5,85,30);
			c.add(a.get(i));
			
		}
	}

}
