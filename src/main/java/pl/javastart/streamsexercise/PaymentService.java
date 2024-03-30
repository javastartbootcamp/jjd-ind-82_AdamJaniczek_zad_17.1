package pl.javastart.streamsexercise;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class PaymentService {

    private final PaymentRepository paymentRepository;
    private final DateTimeProvider dateTimeProvider;

    PaymentService(PaymentRepository paymentRepository, DateTimeProvider dateTimeProvider) {
        this.paymentRepository = paymentRepository;
        this.dateTimeProvider = dateTimeProvider;
    }

    /*
    Znajdź i zwróć płatności posortowane po dacie rosnąco
     */
    List<Payment> findPaymentsSortedByDateAsc() {
        throw new RuntimeException("Not implemented");
    }

    /*
    Znajdź i zwróć płatności posortowane po dacie malejąco
     */
    List<Payment> findPaymentsSortedByDateDesc() {
        throw new RuntimeException("Not implemented");
    }

    /*
    Znajdź i zwróć płatności posortowane po liczbie elementów rosnąco
     */
    List<Payment> findPaymentsSortedByItemCountAsc() {
        return paymentRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(p -> p.getPaymentItems().size()))
                .collect(Collectors.toList());
    }

    /*
    Znajdź i zwróć płatności posortowane po liczbie elementów malejąco
     */
    List<Payment> findPaymentsSortedByItemCountDesc() {
        throw new RuntimeException("Not implemented");
    }

    /*
    Znajdź i zwróć płatności dla wskazanego miesiąca
     */
    List<Payment> findPaymentsForGivenMonth(YearMonth yearMonth) {
        throw new RuntimeException("Not implemented");
    }

    /*
    Znajdź i zwróć płatności dla aktualnego miesiąca
     */
    List<Payment> findPaymentsForCurrentMonth() {
        throw new RuntimeException("Not implemented");
    }

    /*
    Znajdź i zwróć płatności dla ostatnich X dni
     */
    List<Payment> findPaymentsForGivenLastDays(int days) {
        List<Payment> paymentList = paymentRepository.findAll();
        return paymentList
                .stream()
                .filter(payment -> payment.getPaymentDate()
                                            .isAfter(dateTimeProvider
                                            .zonedDateTimeNow()
                                            .minusDays(days)))
                .toList();}

    /*
    Znajdź i zwróć płatności z jednym elementem
     */
    Set<Payment> findPaymentsWithOnePaymentItem() {
        List<Payment> paymentList = paymentRepository.findAll();
        return paymentList
                .stream()
                .filter(p -> p.getPaymentItems().size() == 1)
                .collect(Collectors.toSet());
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
    Policz i zwróć sumę przyznanych rabatów dla wskazanego miesiąca
     */
    BigDecimal sumDiscountForGivenMonth(YearMonth yearMonth) {
        throw new RuntimeException("Not implemented");
    }

    /*
    Znajdź i zwróć płatności dla użytkownika z podanym mailem
     */
    List<PaymentItem> getPaymentsForUserWithEmail(String userEmail) {
        List<Payment> payments = paymentRepository.findAll();
        return payments.stream()
                .filter(payment -> payment.getUser().getEmail().equalsIgnoreCase(userEmail))
                .map(Payment::getPaymentItems)
                .flatMap(Collection::stream)
                .toList();
    }

    /*
    Znajdź i zwróć płatności, których wartość przekracza wskazaną granicę
     */
    private BigDecimal totalValue(Payment payment) {
        BigDecimal totalValue = new BigDecimal(0);
        //for (PaymentItem paymentItem : payment.getPaymentItems()) {
        //    totalValue = totalValue.add(paymentItem.getFinalPrice());
        //}
        //return totalValue.intValue();
        return payment.getPaymentItems()
                .stream()
                .map(PaymentItem::getFinalPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

    }

    /*
    Znajdź i zwróć płatności, których wartość przekracza wskazaną granicę
     */
    Set<Payment> findPaymentsWithValueOver(int value) {
        List<Payment> payments = paymentRepository.findAll();
        return payments.stream()
                .filter(payment -> payment.getTotalPrice().compareTo(BigDecimal.valueOf(value)) > 0)
                .collect(Collectors.toSet());
    }

}
