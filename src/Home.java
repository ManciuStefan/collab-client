import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class Home {
	private Shell shell;
	private String username;
	
	public Home(String username) {
		this.username = username;
		this.shell = new Shell(Display.getCurrent());
	}
	
	public void open() {
		Label usernameLabel = new Label(shell, SWT.BORDER);
		usernameLabel.setText("Salut " + this.username);
		
		RowLayout layout = new RowLayout();
		layout.wrap = true;
		layout.spacing = 10;
		layout.marginLeft = 20;
		layout.marginTop = 20;
		layout.marginBottom = 20;
		layout.marginRight = 20;
		shell.setText("Collab Home");
		shell.setLayout(layout);
		
		shell.pack();
		shell.open();
	}
}
