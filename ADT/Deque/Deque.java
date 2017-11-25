//array circolare ridimensionabile

public interface Deque extends Container
{
	void addFirst(Object obj);  // inserimento ai due capi
	void addLast(Object obj);
	
	Object removeFirst();
	Object removeLast();
	
	Object getFirst();
	Object getLast();
	
	int size();
}

// rimozione ai due capi
// ispezione ai due capi
// dimensione della deque
// solite eccezioni per contenitore pieno/vuoto
class EmptyDequeException extends RuntimeException { }
class FullDequeException extends RuntimeException { }