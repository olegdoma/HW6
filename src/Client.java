import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    Scanner inputStream;
    PrintWriter outputStream;
    Scanner inputMsg;
    public Client(Socket socket){
        try {
            Scanner inputStream = new Scanner(socket.getInputStream());
            PrintWriter outputStream = new PrintWriter(socket.getOutputStream());
            Scanner inputMsg = new Scanner(System.in);
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true){
                        String msg = inputMsg.nextLine();
                        outputStream.println(msg);
                        if (msg.equals("/end")){
                            break;
                        }
                    }
                }
            }).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true){
                        String msg = inputStream.nextLine();
                        System.out.println(msg);
                        if (msg.equals("/end")){
                            break;
                        }
                    }
                }
            }).start();

        }
    }
}
