package world.convex.cvxedit;

import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextHover;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Region;

public class CvxHoverProvider implements ITextHover {

    @Override
    public String getHoverInfo(ITextViewer textViewer, IRegion hoverRegion) {
    	// TODO 
        return "";
    }

    @Override
    public IRegion getHoverRegion(ITextViewer textViewer, int offset) {
        return new Region(offset, 0);
    }
}