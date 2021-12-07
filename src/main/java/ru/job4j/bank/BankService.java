package ru.job4j.bank;

import java.util.*;

/**
 * Класс описывает работу банка
 *
 * @author Rustam Yumagujin
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение личной информации клиентов осуществляется
     * в коллекции HashMap
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет нового пользователя и создаёт новый
     * ArrayList с аккаунтами
     *
     * @param user - информация о пользователе
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод добавляет новый аккаунт к существующему пользователю,
     * на вход принимает номер паспорта и новый аккаунт
     *
     * @param passport - номер паспорта
     * @param account  - название аккаунта
     */
    public void addAccount(String passport, Account account) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> accounts = users.get(user.get());
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод ищет пользователя по номеру паспорта
     *
     * @param passport - номер паспорта
     * @return возвращает пользователя, если не находит
     * то null
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(s -> s.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Метод ищет аккаунт по номеру паспорта и реквизитам
     *
     * @param passport  - номер паспорта
     * @param requisite - номер реквизита
     * @return возвращает аккаунт, если не находит то null
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        return user.flatMap(value -> users.get(value)
                .stream()
                .filter(s -> s.getRequisite().equals(requisite))
                .findFirst());
    }

    /**
     * Метод осуществляет денежный перевод между двумя счетами
     *
     * @param srcPassport   номер паспорта отправителя
     * @param srcRequisite  номер реквизита отправителя
     * @param destPassport  номер паспорта получателя
     * @param destRequisite номер реквизита получателя
     * @param amount        - сумма перевода
     * @return true - если перевод успешен, иначе false
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Optional<Account> srcAcc = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAcc = findByRequisite(destPassport, destRequisite);
        if (srcAcc.isPresent() && destAcc.isPresent() && srcAcc.get().getBalance() >= amount) {
            srcAcc.get().setBalance(srcAcc.get().getBalance() - amount);
            destAcc.get().setBalance(destAcc.get().getBalance() + amount);
            return true;
        }
        return false;
    }
}
