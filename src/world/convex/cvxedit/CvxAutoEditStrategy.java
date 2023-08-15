package world.convex.cvxedit;

import org.eclipse.jface.text.DocumentCommand;
import org.eclipse.jface.text.IAutoEditStrategy;
import org.eclipse.jface.text.IDocument;

public class CvxAutoEditStrategy implements IAutoEditStrategy {

	@Override
	public void customizeDocumentCommand(IDocument document, DocumentCommand command) {
		if ("(".equals(command.text)) { 
			command.text += ")" ;	
		} 
		if ("[".equals(command.text)) { 
			command.text += "]" ;
		}
		if ("{".equals(command.text)) { 
			command.text += "}" ;
		}
	}

}
