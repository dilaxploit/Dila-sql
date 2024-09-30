import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class DILAXPLOIT {
    
    // Fungsi untuk menampilkan menu utama
    public static void showMenu() {
        System.out.println("======================================");
        System.out.println("               DILAXPLOIT             ");
        System.out.println("======================================");
        System.out.println("1. Single Dork SQL Injection");
        System.out.println("2. Mass Dork SQL Injection");
        System.out.println("3. Custom Dork SQL Injection");
        System.out.println("======================================");
        System.out.print("Pilih opsi (1, 2, atau 3): ");
    }
    
    // Fungsi untuk melakukan scanning berdasarkan Dork dan domain
    public static void scanDork(String dork, String domain) {
        System.out.println("\nMemindai web yang rentan menggunakan: " + dork);
        System.out.println("Domain target: " + domain);
        System.out.println("--------------------------------------");
        
        // Simulasi hasil pencarian
        List<String> results = simulateSearch(domain);
        
        System.out.println("| No | URL                           | Status     |");
        System.out.println("|----|-------------------------------|------------|");
        for (int i = 0; i < results.size(); i++) {
            System.out.println("| " + (i+1) + "  | " + results.get(i));
        }
        System.out.println("--------------------------------------");
    }

    // Fungsi untuk mensimulasikan pencarian
    private static List<String> simulateSearch(String domain) {
        List<String> results = new ArrayList<>();
        results.add("http://" + domain + "/page1       | VULNERABLE |");
        results.add("http://" + domain + "/page2       | SAFE       |");
        results.add("http://" + domain + "/admin       | VULNERABLE |");
        results.add("http://" + domain + "/login       | SAFE       |");
        return results;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String choice;
        String domain;
        
        // Menampilkan menu utama
        showMenu();
        
        choice = scanner.nextLine();
        
        System.out.print("Masukkan nama domain target (contoh: go.id): ");
        domain = scanner.nextLine();
        
        // Pilihan Dork berdasarkan nomor
        switch (choice) {
            case "1":
                scanDork("Single Dork SQL Injection", domain);
                break;
            case "2":
                scanDork("Mass Dork SQL Injection", domain);
                break;
            case "3":
                scanDork("Custom Dork SQL Injection", domain);
                break;
            default:
                System.out.println("Pilihan tidak valid.");
                break;
        }
        
        scanner.close();
    }
}