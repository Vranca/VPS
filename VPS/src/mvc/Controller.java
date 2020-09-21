package mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Controller<Component extends java.awt.Component, Model> implements ActionListener, MouseMotionListener, MouseListener
{
	protected Model model = null;
	protected View<Component, Model> view = null;
	private ActionListener actionListener = null;
	private MouseMotionListener mouseMotionListener = null;
	private MouseListener mouseListener = null;

	public Controller(Model model, View<Component, Model> view)
	{
		this.model = model;
		this.view = view;
	}

	public final void setActionListener(ActionListener actionListener)
	{
		this.actionListener = actionListener;
	}

	public final void setMouseMotionListener(MouseMotionListener mouseMotionListener)
	{
		this.mouseMotionListener = mouseMotionListener;
	}

	public final void setMouseListener(MouseListener mouseListener)
	{
		this.mouseListener = mouseListener;
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		if (mouseListener != null)
			mouseListener.mouseClicked(e);
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		if (mouseListener != null)
			mouseListener.mousePressed(e);

	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		if (mouseListener != null)
			mouseListener.mouseReleased(e);
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		if (mouseListener != null)
			mouseListener.mouseEntered(e);
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		if (mouseListener != null)
			mouseListener.mouseExited(e);
	}

	@Override
	public void mouseDragged(MouseEvent e)
	{
		if (mouseMotionListener != null)
			mouseMotionListener.mouseDragged(e);
	}

	@Override
	public void mouseMoved(MouseEvent e)
	{
		if (mouseMotionListener != null)
			mouseMotionListener.mouseMoved(e);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (actionListener != null)
			actionListener.actionPerformed(e);
	}
}
