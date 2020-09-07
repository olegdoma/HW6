import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server_Chat {
    private static int port = 8189;
    ServerSocket serverSocket = null;
    Socket socket = null;

    public Server_Chat() {

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Сервер запущен");
            socket = serverSocket.accept();
            System.out.println("Клиент подключился");


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        new Client(socket);


    }

    public static void main(String[] args) {
        new Server_Chat();


//        ServerSocket server = null;
//        Socket socket = null;
//
//        try {
//            server = new ServerSocket(port);
//            System.out.println("Сервер запущен");
//
//            socket = server.accept();
//            System.out.println("Клиент подключился");
//
//            Scanner input_msg = new Scanner(socket.getInputStream());
//            Scanner in = new Scanner(System.in);
//            PrintWriter output_msg = new PrintWriter(socket.getOutputStream(), true);
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    while (true){
//                        String server_msg = in.nextLine();
//                        output_msg.println(server_msg);
//
//                        if (server_msg.equals("/end")){
//                            break;
//                        }
//                    }
//
//                }
//            }).start();
//
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    while (true){
//                        String from_client_msg = input_msg.nextLine();
//                        System.out.println(from_client_msg);
//
//                        if (from_client_msg.equals("/end")){
//                            break;
//                        }
//                    }
//                }
//            }).start();
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }finally {
//            try {
//                socket.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            try {
//                server.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
    }
}
