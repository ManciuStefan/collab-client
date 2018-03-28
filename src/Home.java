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
		RowLayout layout = new RowLayout();
		layout.wrap = true;
		layout.spacing = 10;
		layout.marginLeft = 20;
		layout.marginTop = 20;
		layout.marginBottom = 20;
		layout.marginRight = 20;
		shell.setText("Collab Home");
		shell.setLayout(layout);
		
		Label usernameLabel = new Label(shell, SWT.BORDER);
		usernameLabel.setText("Salut " + this.username);
		
		List fileList = new List(shell, SWT.BORDER);
		fileList.setToolTipText("Lista fisiere");
		fileList.add("Fisier 1");
		fileList.add("Fisier 2");
		
		Button edit = new Button(shell, SWT.NONE);
		edit.setText("Edit");
		Button add = new Button(shell, SWT.NONE);
		add.setText("Adauga Fisier");
		Button delete = new Button(shell, SWT.NONE);
		delete.setText("Sterge fisier");
		Button share = new Button(shell, SWT.NONE);
		share.setText("Share");
		
		shell.pack();
		shell.open();
	}
}
