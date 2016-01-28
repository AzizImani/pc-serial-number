package kernel;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class LaFUtilities {

	public static void installSystemLaF() {
		String sysLandF = UIManager.getSystemLookAndFeelClassName();
		try {
			UIManager.setLookAndFeel(sysLandF);
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
}
