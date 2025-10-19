package docker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class DockerCpuLimit {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Prompt user for Docker image name
            String imageName = "";
            while (true) {
                System.out.print("Enter Docker image name: ");
                imageName = scanner.nextLine();
                if (imageName != null) {
                    imageName = imageName.trim();
                }
                if (imageName != null && !imageName.isEmpty()) {
                    break;
                }
                System.out.println("Image name cannot be empty. Please try again.");
            }

            // Prompt user for CPU limit
            String cpuLimit = "";
            while (true) {
                System.out.print("Enter CPU limit (e.g., 1.5): ");
                cpuLimit = scanner.nextLine();
                if (cpuLimit != null) {
                    cpuLimit = cpuLimit.trim();
                }
                try {
                    double cpu = Double.parseDouble(cpuLimit);
                    if (cpu > 0) {
                        break;
                    } else {
                        System.out.println("CPU limit must be a positive number. Please try again.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid CPU limit. Please enter a valid number.");
                }
            }

            // Check if Docker is installed
            try {
                Process checkDocker = new ProcessBuilder("docker", "--version").start();
                int exitCode = checkDocker.waitFor();
                if (exitCode != 0) {
                    System.err.println("Docker does not seem to be installed or is not in your PATH.");
                    try (BufferedReader error = new BufferedReader(new InputStreamReader(checkDocker.getErrorStream()))) {
                        String line;
                        while ((line = error.readLine()) != null) {
                            System.err.println(line);
                        }
                    }
                    return;
                }
            } catch (IOException | InterruptedException e) {
                System.err.println("Error checking Docker installation: " + e.getMessage());
                return;
            }

            // Construct Docker command
            String dockerCommand = "docker run --cpus=" + cpuLimit + " " + imageName;

            // Print the command
            System.out.println("Constructed Docker Command: " + dockerCommand);

            // Execute the command
            ProcessBuilder processBuilder = new ProcessBuilder();
            processBuilder.command("bash", "-c", dockerCommand);

            Process process = null;
            try {
                process = processBuilder.start();
            } catch (IOException e) {
                System.err.println("Failed to start Docker process: " + e.getMessage());
                return;
            }

            try (
                BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
                BufferedReader error = new BufferedReader(new InputStreamReader(process.getErrorStream()));
                PrintWriter out = new PrintWriter(process.getOutputStream())
            ) {
                String line;
                while ((line = in.readLine()) != null) {
                    System.out.println(line);
                }
                while ((line = error.readLine()) != null) {
                    System.err.println(line);
                }
                int exitCode = process.waitFor();
                if (exitCode != 0) {
                    System.err.println("Docker command exited with code: " + exitCode);
                }
            } catch (IOException e) {
                System.err.println("Error during Docker command execution: " + e.getMessage());
            } catch (InterruptedException e) {
                System.err.println("Process was interrupted: " + e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
    }
}
