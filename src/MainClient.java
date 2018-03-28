import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class MainClient {
	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		RowLayout layout = new RowLayout();
		layout.wrap = true;
		layout.spacing = 10;
		layout.marginLeft = 20;
		layout.marginTop = 20;
		layout.marginBottom = 20;
		layout.marginRight = 20;
		shell.setText("Collab Login");
		shell.setLayout(layout);
		
		Label usernameLabel = new Label(shell, SWT.BORDER);
		usernameLabel.setText("Username:");
		Text username = new Text(shell, SWT.NONE);
		
		Label passwordLabel = new Label(shell, SWT.BORDER);
		passwordLabel.setText("Password:");
		Text password = new Text(shell, SWT.NONE);
		password.setEchoChar('*');
		
		Button login = new Button(shell, SWT.NONE);
		login.setText("Login");
		login.addListener(SWT.Selection, new Listener() {
			@Override
			public void handleEvent(Event event) {
				Home homeShell = new Home(username.getText());
				shell.setVisible(false);
				homeShell.open();
			}
		});
		
		shell.pack();
		shell.open();
		
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		
		display.dispose();
	}
}
