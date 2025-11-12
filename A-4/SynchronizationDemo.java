class BankAccount {
    private int balance = 1000;

    // Synchronized deposit method
    public synchronized void deposit(int amount) {
        System.out.println(Thread.currentThread().getName() + " depositing " + amount + "...");
        int newBalance = balance + amount;

        try {
            Thread.sleep(200); // simulate delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        balance = newBalance;
        System.out.println(Thread.currentThread().getName() + " completed deposit. New balance: " + balance);
    }

    // Synchronized withdraw method
    public synchronized void withdraw(int amount) {
        System.out.println(Thread.currentThread().getName() + " withdrawing " + amount + "...");

        if (balance >= amount) {
            int newBalance = balance - amount;

            try {
                Thread.sleep(200); // simulate delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            balance = newBalance;
            System.out.println(Thread.currentThread().getName() + " completed withdrawal. New balance: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " - Insufficient funds! Current balance: " + balance);
        }
    }

    public int getBalance() {
        return balance;
    }
}

public class SynchronizationDemo {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        // Thread for depositing money
        Thread depositThread = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                account.deposit(500);
            }
        }, "Depositor");

        // Thread for withdrawing money
        Thread withdrawThread = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                account.withdraw(300);
            }
        }, "Withdrawer");

        // Start both threads
        depositThread.start();
        withdrawThread.start();

        // Wait for threads to finish
        try {
            depositThread.join();
            withdrawThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nFinal Balance: " + account.getBalance());
        System.out.println("Expected Balance (if synchronized): 1600");
    }
}
