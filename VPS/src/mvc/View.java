package mvc;

import java.util.HashSet;

import observer.Observer;

public class View<Component extends java.awt.Component, Model> implements Observer
{
	private Model model = null;
	private Component component = null;
	private ViewUpdateFunction<Component, Model> updateFunction = null;
	private HashSet<View<?, ?>> subViews = null;

	public View(Model model, Component component)
	{
		this.model = model;
		this.component = component;
	}

	public final void setModel(Model model)
	{
		this.model = model;
	}

	public final Model getModel()
	{
		return model;
	}

	public final Component getComponent()
	{
		return component;
	}

	public void addSubView(View<?, ?> subView)
	{
		if (subViews == null)
			subViews = new HashSet<>();

		subViews.add(subView);
	}

	public HashSet<View<?, ?>> getSubViews()
	{
		return subViews;
	}

	public final ViewUpdateFunction<Component, Model> getUpdateFunction()
	{
		return (ViewUpdateFunction<Component, Model>) updateFunction;
	}

	public final void setUpdateFunction(ViewUpdateFunction<Component, Model> updateFunction)
	{
		this.updateFunction = updateFunction;
	}

	@Override
	public void update(Object... args)
	{
		updateFunction.execute(model, this, args);
	}

	public interface ViewUpdateFunction<Component extends java.awt.Component, Model>
	{
		void execute(Model model, View<Component, Model> view, Object... args);
	}

}
