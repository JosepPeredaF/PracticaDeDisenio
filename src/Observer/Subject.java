package Observer;

public interface Subject {
    void addObserver(OrderObserver o);
    void removeObserver(OrderObserver o);
    void notifyObservers();
}
