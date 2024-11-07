package it.unibo.encapsulation.interfaces;

public class TestSimpleBankAccount {

    private TestSimpleBankAccount() {
        /*
         * Prevents object creation from the outside.
         */
    }

    public static void main(final String[] args) {
        // 1) Creare l' AccountHolder relativo a Andrea Rossi con id 1
        AccountHolder rossi = new AccountHolder("Andrea", "Rossi",  1);

        // 2) Creare l' AccountHolder relativo a Alex Bianchi con id 2
        AccountHolder bianchi = new AccountHolder("Alex", "Bianchi",  2);

        // 3) Creare i due SimpleBankAccount corrispondenti
        BankAccount rossiAccount = new SimpleBankAccount(rossi.getUserID(), 0);
        BankAccount bianchiAccount = new SimpleBankAccount(bianchi.getUserID(), 0);
        
        // 4) Effettuare una serie di depositi e prelievi
        rossiAccount.deposit(rossi.getUserID(), 500);  // Deposito di €500 nel conto di Rossi
        rossiAccount.withdraw(rossi.getUserID(), 200); // Prelievo di €200 nel conto di Rossi
        rossiAccount.depositFromATM(rossi.getUserID(), 300); // Deposito di €300 tramite ATM (con costo di €1)
        
        bianchiAccount.deposit(bianchi.getUserID(), 1000); // Deposito di €1000 nel conto di Bianchi
        bianchiAccount.withdraw(bianchi.getUserID(), 300);  // Prelievo di €300 nel conto di Bianchi
        bianchiAccount.withdrawFromATM(bianchi.getUserID(), 100); // Prelievo di €100 tramite ATM (con costo di €1)

        /*
         * 5) Stampare a video l'ammontare dei due conti e verificare la
         * correttezza del risultato
         */
        System.out.println("Saldo conto Rossi: " + rossiAccount.getBalance()); // Dovrebbe essere 599 (500 - 200 + 300 - 1)
        System.out.println("Saldo conto Bianchi: " + bianchiAccount.getBalance()); // Dovrebbe essere 599 (1000 - 300 - 100 - 1)


        // 6) Provare a prelevare fornendo un id utente sbagliato
        rossiAccount.withdraw(2, 100); // Tentativo di prelievo di €100 con ID sbagliato


        // 7) Controllare nuovamente l'ammontare
        System.out.println("Saldo conto Rossi dopo tentativo prelievo con ID sbagliato: " + rossiAccount.getBalance());
        // Dovrebbe rimanere invariato (599) perché l'ID fornito era sbagliato
    }
}
