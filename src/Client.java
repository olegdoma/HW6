
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private static final String ip_address = "localhost";
    private static final int port = 8189;
    private Socket socket;
    public Client() {
        try {
        socket = new Socket(ip_address, port);
        System.out.println("Клиент стартовал");
        Scanner input_msg = new Scanner(socket.getInputStream());
        Scanner in = new Scanner(System.in);
        PrintWriter output_msg = new PrintWriter(socket.getOutputStream(), true);
        while (true){
            String client_msg = in.nextLine();
            if (client_msg.equals("/end")){
                break;
            }
            output_msg.println(client_msg);
            String server_msg = input_msg.nextLine();
            System.out.println(server_msg);
        }

    } catch (IOException e) {
        e.printStackTrace();
    }finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }




//       try {
//           socket = new Socket(ip_address, port);
//
//           System.out.println("Клиент стартовал");
//           new Thread(new Runnable() {
//               @Override
//               public void run() {
//
//
//                   try {
//                   Scanner in_msg = new Scanner(socket.getInputStream());
//                   Scanner in = new Scanner(System.in);
//                   PrintWriter out_msg = new PrintWriter(socket.getOutputStream(), true);
//                   while (true){
//                       String str = in.nextLine();
//                                if (str.equals("/end")){
//                                    break;
//                                     }
//                       out_msg.printf(str);
//
//                   }
//               } catch (IOException e) {
//                   e.printStackTrace();
//               }finally {
//                       try {
//                           socket.close();
//                       } catch (IOException e) {
//                           e.printStackTrace();
//                       }
//                   }
//               }
//
//           }){
//
//           }.start();
//
//    } catch (IOException e) {
//        e.printStackTrace();
//    }finally {
//            try {
//                assert socket != null;
//                socket.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//        }

    }
}
