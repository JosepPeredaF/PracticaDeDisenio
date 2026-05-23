package service;

import Observer.OrderObserver;
import Observer.Subject;
import adapter.PaymentProcessor;
import model.Cart;
import strategy.DiscountStrategy;

import java.util.ArrayList;
import java.util.List;

public class OrderService implements Subject {
    private List<OrderObserver> observers = new ArrayList<>();
    private DiscountStrategy discountStrategy;

    @Override
    public void addObserver(OrderObserver o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(OrderObserver o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (OrderObserver observer : observers) {
            observer.update("");
        }
    }
    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public void confirmarCompra(Cart cart, PaymentProcessor paymentProcessor) {
        double totalBruto = cart.calcularTotal();
        double totalConDescuento = discountStrategy.applyDiscount(totalBruto);

        System.out.println("Compra confirmada por S/ " + String.format("%.2f", totalConDescuento));

        paymentProcessor.pay(totalConDescuento);

        notifyObservers();
    }
}
