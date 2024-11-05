package it.unibo.encapsulation.interfaces;

public class TestBankAccount {

    private TestBankAccount() {
    }

    public static void main(final String[] args) {
        /*
         * 1) Creare l' AccountHolder relativo a Andrea Rossi con id 1
         */
        AccountHolder rossi = new AccountHolder("Andrea", "Rossi",  1);
        /*
         * 2) Creare l' AccountHolder relativo a Alex Bianchi con id 2
         */
        AccountHolder bianchi = new AccountHolder("Alex", "Bianchi",  2);
        /*
         * 3) Dichiarare due variabili di tipo BankAccount ed inizializzarle,
         * rispettivamente, con oggetti di tipo SimpleBankAccount per il conto di
         * Rossi (ammontare iniziale = 0), e di tipo StrictBankAccount per il conto di
         * Bianchi (ammontare iniziale = 0)
         */
        BankAccount rossiAccount = new SimpleBankAccount(rossi.getUserID(), 0);
        BankAccount bianchiAccount = new StrictBankAccount(bianchi.getUserID(), 0);
        /*
         * 4) Prima riflessione: perché è stato possibile fare la new di due classi
         * diverse in variabili dello stesso tipo?
         *  È possibile perché entrambe le classi implementano l'interfaccia comune BankAccount.
         */
        /*
         * 5) Depositare €10000 in entrambi i conti
         */
        rossiAccount.deposit(rossi.getUserID(), 10000);
        bianchiAccount.deposit(bianchi.getUserID(), 10000);
        /*
         * 6) Prelevare €15000$ da entrambi i conti
         */
        rossiAccount.withdraw(rossi.getUserID(), 15000);
        bianchiAccount.withdraw(bianchi.getUserID(), 15000);
        /*
         * 7) Stampare in stdout l'ammontare corrente
         */
        System.out.println("Saldo conto Rossi: " + rossiAccount.getBalance());
        System.out.println("Saldo conto Bianchi: " + bianchiAccount.getBalance());
        /*
         * 8) Qual è il risultato e perché?
         * Il conto di Rossi va in negativo, mentre il conto di Bianchi rimane invariato
        // perché StrictBankAccount non permette prelievi superiori al saldo.
         */

        /*
         * 9) Depositare nuovamente €10000 in entrambi i conti
         */
        rossiAccount.deposit(rossi.getUserID(), 10000);
        bianchiAccount.deposit(bianchi.getUserID(), 10000);
        /*
         * 10) Invocare il metodo computeManagementFees su entrambi i conti
         */
        rossiAccount.chargeManagementFees(rossi.getUserID());
        bianchiAccount.chargeManagementFees(bianchi.getUserID());
        /*
         * 11) Stampare a video l'ammontare corrente
         */
        System.out.println("Saldo conto Rossi dopo spese gestione: " + rossiAccount.getBalance());
        System.out.println("Saldo conto Bianchi dopo spese gestione: " + bianchiAccount.getBalance());
        /*
         * 12) Qual è il risultato e perché?
         * SimpleBankAccount non applica spese di gestione, quindi il saldo non cambia.
        // In StrictBankAccount, invece, viene sottratto un importo di gestione in base al numero di transazioni.
         */
    }
}
