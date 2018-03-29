import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class Home {
	private Shell shell;
	private Shell loginShell;
	private String username;
	
	public Home(String username, Shell loginShell) {
		this.username = username;
		this.shell = new Shell(Display.getCurrent());
		this.loginShell = loginShell;
	}
	
	public void open() {		
		GridLayout layout = new GridLayout();
		layout.numColumns = 4;
		layout.marginLeft = 20;
		layout.marginTop = 20; 
		layout.marginBottom = 20;
		layout.marginRight = 20;
//		layout.makeColumnsEqualWidth = true;
		shell.setText("Collab Home");
		shell.setLayout(layout);
		
		shell.addListener(SWT.Close, new Listener() 
        { 
           @Override 
           public void handleEvent(Event event) 
           { 
              loginShell.dispose();
              shell.dispose();
           } 
        }); 
		
		Label usernameLabel = new Label(shell, SWT.BORDER);
		usernameLabel.setText("Salut " + this.username);
		
		List fileList = new List(shell, SWT.BORDER);
		GridData listData = new GridData();
		listData.horizontalSpan = 3;
		
		fileList.setToolTipText("Lista fisiere");
		fileList.add("Fisier 1");
		fileList.add("Fisier 2---------");
		fileList.add("Fisier 1");
		fileList.add("Fisier 2");
		fileList.setLayoutData(listData);
		
		Button edit = new Button(shell, SWT.NONE);
		GridData editData = new GridData(SWT.FILL, SWT.FILL, true, true);
		edit.setLayoutData(editData);
		edit.setText("Edit");
		
		edit.addListener(SWT.Selection, new Listener() {
			@Override
			public void handleEvent(Event event) {
				EditDoc editShell = new EditDoc(fileList.getSelection()[0], shell);
				shell.setVisible(false);
				editShell.open();
			}
		});
		
		Button add = new Button(shell, SWT.NONE);
		add.setText("Adauga Fisier");
		Button delete = new Button(shell, SWT.NONE);
		delete.setText("Sterge fisier");
		Button share = new Button(shell, SWT.NONE);
		share.setLayoutData(editData);
		share.setText("Share");
		
		shell.pack();
		shell.open();
	}
}
