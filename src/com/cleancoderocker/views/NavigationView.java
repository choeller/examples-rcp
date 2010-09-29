package com.cleancoderocker.views;

import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

import com.cleancoderocker.model.Question;
import com.cleancoderocker.model.Questionnaire;
import com.cleancoderocker.model.QuestionnaireProvider;

public class NavigationView extends ViewPart {

	private TreeViewer viewer;

	class NaigationViewContentProvider implements ITreeContentProvider {

		@Override
		public void dispose() {
			// TODO Auto-generated method stub

		}

		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			// TODO Auto-generated method stub

		}

		public Object[] getChildren(Object object) {
			if(object instanceof Questionnaire) {
				return ((Questionnaire)object).getQuestions().toArray();
			}
			return null;
		}

		public Object getParent(Object object) {
			if(object instanceof Question) {
				return ((Question)object).getQuestionnaire();
			}
			return null;
		}

		public boolean hasChildren(Object object) {
			Object[] objects = getChildren(object);
			return objects == null ? false : objects.length > 0;
		}

		public Object[] getElements(Object object) {
			return getChildren(object);
		}

	}

	class NavigationViewLabelProvider extends LabelProvider implements
			ILabelProvider {

	}

	@Override
	public void createPartControl(Composite parent) {
		viewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		viewer.setContentProvider(new NaigationViewContentProvider());
		viewer.setLabelProvider(new NavigationViewLabelProvider());
		// Provide the input to the ContentProvider
		viewer.setInput(QuestionnaireProvider.findQuestionnaire("Examples"));
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
