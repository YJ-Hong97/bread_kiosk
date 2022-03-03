package bread_kiosk;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

public class makeactionlistening {

	public makeactionlistening(ArrayList<JButton> a,int i, JPanel b, JPanel c, JPanel d) {
		// TODO Auto-generated constructor stub
		a.get(i).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				b.setVisible(true);
				c.setVisible(false);
				d.setVisible(false);
				
			}
		});
	}
}
