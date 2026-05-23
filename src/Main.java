import Observer.AdminNotificationObserver;
import Observer.EmailNotificationObserver;
import Observer.InventoryObserver;
import adapter.ExternalPayPalService;
import adapter.PayPalAdapter;
import adapter.PaymentProcessor;
import model.Cart;
import model.Product;
import service.OrderService;
import strategy.NoDiscountStrategy;

public class Main {
    static void main(String[] args) {
        Product p1 = new Product("mario kart 8 deluxe", 60.00);
        Product p2 = new Product("god of war 2", 60.00);

        Cart cart = new Cart();
        cart.addProduct(p1);
        cart.addProduct(p2);


        OrderService orderService = new OrderService();


        orderService.addObserver(new EmailNotificationObserver());
        orderService.addObserver(new InventoryObserver());
        orderService.addObserver(new AdminNotificationObserver());


        orderService.setDiscountStrategy(new NoDiscountStrategy());


        PaymentProcessor paymentMethod = new PayPalAdapter(new ExternalPayPalService());


        orderService.confirmarCompra(cart, paymentMethod);
    }


}
