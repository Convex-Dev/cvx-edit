package world.convex.cvxedit;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;

import java.util.ArrayList;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.MultiLineRule;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.SingleLineRule;
import org.eclipse.jface.text.rules.Token;

public class CvxPresentationReconciler extends PresentationReconciler {

    private final TextAttribute commentAttribute = new TextAttribute(new Color(Display.getCurrent(), new RGB(0,128,32)));
    private final TextAttribute parensAttribute = new TextAttribute(new Color(Display.getCurrent(), new RGB(128,0,0)));

    public CvxPresentationReconciler() {
        // TODO logic for syntax colouring
        RuleBasedScanner scanner= new RuleBasedScanner();
        
        ArrayList<IRule> arr=new ArrayList<>();
        arr.add(new SingleLineRule(";", "", new Token(commentAttribute)));
        arr.add(new MultiLineRule("(", ")", new Token(parensAttribute)));
        
        IRule[] rules=arr.toArray(new IRule[0]);
        scanner.setRules(rules);
        DefaultDamagerRepairer dr= new DefaultDamagerRepairer(scanner);
        this.setDamager(dr, IDocument.DEFAULT_CONTENT_TYPE);
        this.setRepairer(dr, IDocument.DEFAULT_CONTENT_TYPE);
    }
}