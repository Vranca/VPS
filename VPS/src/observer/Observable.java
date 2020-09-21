package observer;

import java.util.HashSet;

public class Observable
{
	private HashSet<Observer> observers = null;

	public Observable()
	{
		observers = new HashSet<>();
	}

	public final void addObservers(Observer... newObservers)
	{
		observers.addAll(observers);
	}

	public final void removeObservers(Observer... observers)
	{
		for (Observer o : observers)
		{
			this.observers.remove(o);
		}
	}

	public final void notifyObservers(Object... args)
	{
		for (Observer o : observers)
		{
			o.update(args);
		}
	}
}
