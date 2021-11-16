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
     * @param user - информация о пользователе
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод добавляет новый аккаунт к существующему пользователю,
     * на вход принимает номер паспорта и новый аккаунт
     * @param passport - номер паспорта
     * @param account - название аккаунта
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод ищет пользователя по номеру паспорта
     * @param passport - номер паспорта
     * @return возвращает пользователя, если не находит
     * то null
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Метод ищет аккаунт по номеру паспорта и реквизитам
     * @param passport - номер паспорта
     * @param requisite - номер реквизита
     * @return возвращает аккаунт, если не находит то null
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            for (Account account : users.get(user)) {
                if (requisite.equals(account.getRequisite())) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Метод осуществляет денежный перевод между двумя счетами
     * @param srcPassport номер паспорта отправителя
     * @param srcRequisite номер реквизита отправителя
     * @param destPassport номер паспорта получателя
     * @param destRequisite номер реквизита получателя
     * @param amount - сумма перевода
     * @return true - если перевод успешен, иначе false
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Account srcAcc = findByRequisite(srcPassport, srcRequisite);
        Account destAcc = findByRequisite(destPassport, destRequisite);
        if (srcAcc != null && destAcc != null && srcAcc.getBalance() >= amount) {
            srcAcc.setBalance(srcAcc.getBalance() - amount);
            destAcc.setBalance(destAcc.getBalance() + amount);
            return true;
        }
        return false;
    }
}
