package OS;

import java.util.Scanner;

class Process {
    int pid;            // Process ID
    int arrivalTime;     // Arrival Time
    int burstTime;       // Burst Time
    int waitingTime;     // Waiting Time
    int turnAroundTime;  // Turnaround Time

    public Process(int pid, int arrivalTime, int burstTime) {
        this.pid = pid;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
    }
}
public class FCFS {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the number of process: ");
        int n = scan.nextInt();

        Process[] processes = new Process[n];

        for (int i = 0; i<n; i++){
            System.out.print("Please Enter the Arrival Time & Burst Time of Process "+(i+1)+": ");
            int arrivalTime = scan.nextInt();
            int burstTime = scan.nextInt();
            processes[i] = new Process(i+1, arrivalTime, burstTime);
        }

        findAverageTime(processes);
        scan.close();
    }

    private static void findAverageTime(Process[] processes) {
        calculateWaitingTime(processes);
        calculateTurnAroundTime(processes);

        int totalWaitingTime = 0, totalTurnAroundTime = 0;

        System.out.println("Processes | Arrival Time | Burst Time | Waiting Time | Turnaround Time");

        for (Process process : processes) {
            totalWaitingTime += process.waitingTime;
            totalTurnAroundTime += process.turnAroundTime;

            System.out.println("   " + process.pid + "\t\t\t" + process.arrivalTime
                    + "\t\t\t\t" + process.burstTime + "\t\t\t\t" + process.waitingTime
                    + "\t\t\t" + process.turnAroundTime);
        }

        System.out.println("\nAverage Waiting Time: " + (double) totalWaitingTime / processes.length + " Nano Seconds");
        System.out.println("Average Turnaround Time: " + (double) totalTurnAroundTime / processes.length + " Nano Seconds");

    }

    private static void calculateTurnAroundTime(Process[] processes) {
        // Turnaround time = Burst time + Waiting time
        for (Process process : processes) {
            process.turnAroundTime = process.burstTime + process.waitingTime;
        }
    }

    private static void calculateWaitingTime(Process[] processes) {

        int n = processes.length;
        int[] serviceTime = new int[n];

        serviceTime[0] = processes[0].arrivalTime;
        processes[0].waitingTime = 0;

        // Calculating the waiting time for each process
        for (int i = 1; i < n; i++) {
            serviceTime[i] = serviceTime[i - 1] + processes[i - 1].burstTime;

            processes[i].waitingTime = serviceTime[i] - processes[i].arrivalTime;

            // If waiting time for a process is negative, reset it to zero
            if (processes[i].waitingTime < 0) {
                processes[i].waitingTime = 0;
            }
        }
    }
}

