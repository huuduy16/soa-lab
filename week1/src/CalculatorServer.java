// Phan Hữu Duy _ 18020015

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class CalculatorServer {

    public static void main(String[] args) {

        if (args.length != 1) {
            System.err.println("Usage: java EchoServer <port number>");
            System.exit(1);
        }

        int portNumber = Integer.parseInt(args[0]);

        try (ServerSocket serverSocket = new ServerSocket(Integer.parseInt(args[0]));
            Socket clientSocket = serverSocket.accept();
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()))) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                out.println(calculator(inputLine));
            }
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }

    private static String calculator(String input) throws IOException {
        String[] tmp = input.split(" ");
        Integer a = Integer.parseInt(tmp[0]);
        Integer b = Integer.parseInt(tmp[1]);
        switch (tmp[2]) {
            case "+": {
                return "" + a + " + " + b + " = " + (a + b);
            }
            case "-": {
                return "" + a + " - " + b + " = " + (a - b);
            }
            case "*": {
                return "" + a + " * " + b + " = " + (a * b);
            }
            case "/": {
                return "" + a + " / " + b + " = " + ((double) a / (double) b);
            }
            case "**": {
                return "" + a + " ** " + b + " = " + (Math.pow(a, b));
            }
        }
        return "not recognize input";
    }
}