package pl.javastart.streamsexercise;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.List;
import java.util.Set;

class PaymentService {

    private PaymentRepository paymentRepository;
    private DateTimeProvider dateTimeProvider;

    PaymentService(PaymentRepository paymentRepository, DateTimeProvider dateTimeProvider) {
        this.paymentRepository = paymentRepository;
        this.dateTimeProvider = dateTimeProvider;
    }

    /*
    Znajdź i zwróć płatności posortowane po dacie malejąco
     */
    List<Payment> findPaymentsSortedByDateDesc() {
        throw new RuntimeException("Not implemented");
    }

    /*
    Znajdź i zwróć płatności dla aktualnego miesiąca
     */
    List<Payment> findPaymentsForCurrentMonth() {
        throw new RuntimeException("Not implemented");
    }

    /*
    Znajdź i zwróć płatności dla wskazanego miesiąca
     */
    List<Payment> findPaymentsForGivenMonth(YearMonth yearMonth) {
        throw new RuntimeException("Not implemented");
    }

    /*
    Znajdź i zwróć płatności dla ostatnich X dzni
     */
    List<Payment> findPaymentsForGivenLastDays(int days) {
        throw new RuntimeException("Not implemented");
    }

    /*
    Znajdź i zwróć płatności z jednym elementem
     */
    Set<Payment> findPaymentsWithOnePaymentItem() {
        throw new RuntimeException("Not implemented");
    }

    /*
    Znajdź i zwróć nazwy produktów sprzedanych w aktualnym miesiącu
     */
    Set<String> findProductsSoldInCurrentMonth() {
        throw new RuntimeException("Not implemented");
    }

    /*
    Policz i zwróć sumę sprzedaży dla wskazanego miesiąca
     */
    BigDecimal sumTotalForGivenMonth(YearMonth yearMonth) {
        throw new RuntimeException("Not implemented");
    }

    /*
    Policz i zwróć sumę przeyznanaych rabatów dla wskazanego miesiąca
     */
    BigDecimal sumDiscountForGivenMonth(YearMonth yearMonth) {
        throw new RuntimeException("Not implemented");
    }

    /*
    Znajdź i zwróć płatności dla użytkownika z podanym mailem
     */
    List<PaymentItem> getPaymentsForUserWithEmail(String userEmail) {
        throw new RuntimeException("Not implemented");
    }

    /*
    Znajdź i zwróć płatności, których wartość przekracza wskazaną granicę
     */
    Set<Payment> findPaymentsWithValueOver(int value) {
        throw new RuntimeException("Not implemented");
    }

}
