package world.convex.cvxedit;

import java.util.*;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.text.*;
import org.eclipse.jface.text.reconciler.*;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.projection.ProjectionAnnotation;
import org.eclipse.jface.text.source.projection.ProjectionViewer;

public class CvxReconcilerStrategy implements IReconcilingStrategy, IReconcilingStrategyExtension {
    // TODO this is logic for .project file to fold tags. Replace with your language logic!
	private IDocument document;
	private String oldDocument;
	private ProjectionViewer projectionViewer;
	private List<Annotation> oldAnnotations = new ArrayList<>();
	private List<Position> oldPositions = new ArrayList<>();

    @Override
    public void setDocument(IDocument document) {
        this.document = document;
    }

    public void setProjectionViewer(ProjectionViewer projectionViewer) {
        this.projectionViewer = projectionViewer;
    }

    @Override
    public void reconcile(DirtyRegion dirtyRegion, IRegion subRegion) {
        initialReconcile();
    }

    @Override
    public void reconcile(IRegion partition) {
        initialReconcile();
    }

    @Override
    public void initialReconcile() {
		if(document.get().equals(oldDocument)) return;
		oldDocument = document.get();

		List<Position> positions = getNewPositionsOfAnnotations();

		List<Position> positionsToRemove = new ArrayList<>();
		List<Annotation> annotationToRemove = new ArrayList<>();

		for (Position position : oldPositions) {
			if(!positions.contains(position)) {
				projectionViewer.getProjectionAnnotationModel().removeAnnotation(oldAnnotations.get(oldPositions.indexOf(position)));
				positionsToRemove.add(position);
				annotationToRemove.add(oldAnnotations.get(oldPositions.indexOf(position)));
			}else {
				positions.remove(position);
			}
		}
		oldPositions.removeAll(positionsToRemove);
		oldAnnotations.removeAll(annotationToRemove);

		for (Position position : positions) {
			Annotation annotation = new ProjectionAnnotation();
			projectionViewer.getProjectionAnnotationModel().addAnnotation(annotation, position);
			oldPositions.add(position);
			oldAnnotations.add(annotation);
		}
    }

    private List<Position> getNewPositionsOfAnnotations(){
        List<Position> positions = new ArrayList<>();
  
        return positions;
    }

    @Override
    public void setProgressMonitor(IProgressMonitor monitor) {
        // no progress monitor used
    }

}