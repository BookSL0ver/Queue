//Assignment Name: Implement and Test ADT
//Name: Jaclyn Windorff
//Email: jwindorff@wisc.edu
//Due Date: 2/5/2018
//Bugs: None

//This class uses an array based maximum priority queue to sort various data types
public class MaxPQ<E extends Comparable<E>> implements PriorityQueueADT<E>
{
    private E[] items;								//This is the list that holds the priority queue
    private static final int INITIAL_SIZE = 10;		//This is the initial size of the items list

    //Constructor: initializes the items array 
    public MaxPQ()
    {
        this.items = (E[]) new Comparable[INITIAL_SIZE];
    }

    //Checks to see if there is anything in the priority queue
    //@return boolean - true if there is nothing in the priority queue
	@Override
	public boolean isEmpty() 
	{
		if(size() == 0)
			return true;
		else
			return false;
	}

	//puts the item given into the priority queue in the right location
	//@param E - the item that you want to insert
	@Override
	public void insert(E item) 
	{
		if(item == null)
			throw new IllegalArgumentException();
		if(isEmpty())
		{
			items[1] = item;
		}
		else
		{
			int size = size();
			if(size == items.length - 1)
			{
				E[] temp = (E[])new Comparable[items.length];
				for(int i = 1; i < size + 1; i++)
					temp[i] = items[i];
				items = (E[]) new Comparable[items.length * 2];
				for(int j = 1; j < size + 1; j++)
					items[j] = temp[j];
			}
			items[size() + 1] = item;
			insertHelper(item);
		}
	}
	
	//Helps the insert method by making sure the organization of the list is correct
	//and fixing it if its not
	//@param E item - the item that needs to be sorted into the list
	private void insertHelper(E item)
	{
		E parent = getParent(item);
		if(parent == null)
			return;
		if(parent.compareTo(item) > 0)
		{
			int parInd = getIndex(parent);
			int chilInd = getIndex(item);
			items[parInd] = item;
			items[chilInd] = parent;
			insertHelper(item);
		}
	}
	
	//Gets the parent of the given item
	//@param E item - the item we want the parent of
	//@return E - the parent of the item given
	private E getParent(E item)
	{
		int place = getIndex(item);
		if(place == 1 || place == -1)
			return null;
		else
			return items[place/2];
	}
	
	//finds the index of any given item in the list, -1 if not found
	//@param E item - the item we want the index of
	//@return int - the index of the given item
	private int getIndex(E item)
	{
		int index = -1;
		for(int i = 1; i < size() + 1; i++)
		{
			if(items[i].equals(item))
			{
				index = i;
				break;
			}
			else if(items[i].equals(item))
				index = i;
		}
		return index;
	}

	//returns, but does not remove, the maximum value in the queue 
	//@return E - the maximum value in the queue
	//@throws EmptyQueueException - when there is nothing in the queue that can be returned
	@Override
	public E getMax() throws EmptyQueueException 
	{
		if(isEmpty())
			throw new EmptyQueueException();
		return items[1];
	}

	//removes and returns the highest priority value
	//@return E - the maximum item in the queue
	//@throws EmptyQueueException - when there is nothing in the queue to be removed
	@Override
	public E removeMax() throws EmptyQueueException {
		if(isEmpty())
			throw new EmptyQueueException();
		E max = getMax();
		//put last node at front and sort downwards
		if(size() == 1)
			items[1] = null;
		else
		{
			E temp = items[size()];
			items[size()] = null;
			items[1] = temp;
			removeHelper(temp);
		}
		return max;
	}
	
	//helps the remove method by checking the children of a given item and switching things
	//so that the item with the highest value is at the top
	//@param E item - the item to be sorted in the queue
	private void removeHelper(E item)
	{
		E right = getRChild(item);
		E left = getLChild(item);
		if(right == null)
		{
			if(left == null)
			{
				return;
			}
			else
			{
				if(item.compareTo(left) > 0)
				{
					int lInd = getIndex(left);
					int parInd = getIndex(item);
					items[lInd] = item;
					items[parInd] = left;
					removeHelper(item);
				}
			}
		}
		else if(item.compareTo(right) < 0 && item.compareTo(left) < 0)
			return;
		else if(right.compareTo(left) < 0)
		{
			//right bigger than left
			if(item.equals(right))
				return;
			int rInd = getIndex(right);
			int parInd = getIndex(item);
			items[rInd] = item;
			items[parInd] = right;
			removeHelper(item);
		}
		else
		{
			//left bigger than right
			if(item.equals(left))
				return;
			int lInd = getIndex(left);
			int parInd = getIndex(item);
			items[lInd] = item;
			items[parInd] = left;
			removeHelper(item);
		}
	}
	
	//gives the right child of the given item
	//@param E item - the item we want the right child for
	//@return E - the right child of the given item
	private E getRChild(E item)
	{
		int parInd = getIndex(item);
		return items[parInd * 2 + 1];
	}
	
	//gives the left child of the given item 
	//@param E item - the item we want the left child for
	//@return E - the left child of the given item
	private E getLChild(E item)
	{
		int parInd = getIndex(item);
		return items[parInd * 2];
	}

	//calculates and returns the current size of the priority queue
	//@return int - the size of the priority queue
	@Override
	public int size() {
		int size = 0;
		for(int i = 0; i < items.length; i++)
		{
			if(!(items[i] == null))
				size++;
		}
		return size;
	}

}