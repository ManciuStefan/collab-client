import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class EditDoc {
	private Shell shell;
	private Shell parentShell;
	private String filename;
	
	public EditDoc(String filename, Shell parentShell) {
		this.shell = new Shell(Display.getCurrent());
		this.filename = filename;
		this.parentShell = parentShell;
	}
	
	public void open() {
		GridLayout layout = new GridLayout();
		layout.numColumns = 1;
		layout.marginLeft = 20;
		layout.marginTop = 20; 
		layout.marginBottom = 20;
		layout.marginRight = 20;
		shell.setText("Edit file " + this.filename);
		shell.setLayout(layout);
		
		Label fileLabel = new Label(shell, SWT.BORDER);
		fileLabel.setText("Editing file " + this.filename);
		GridData labelData = new GridData();
		
		Text text = new Text(shell, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.WRAP);
	    text.setLayoutData(new GridData(GridData.FILL_HORIZONTAL | GridData.FILL_VERTICAL));
		
	    Button done = new Button(shell, SWT.NONE);
		done.setText("Done");
		done.addListener(SWT.Selection, new Listener() {
			@Override
			public void handleEvent(Event event) {
				shell.setVisible(false);
				parentShell.setVisible(true);
				shell.dispose();
			}
		});
		
	    shell.setSize(600, 600);
		shell.open();
	}
}
