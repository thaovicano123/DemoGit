/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ClientHandler implements Runnable {
    private Socket clientSocket;
    private DataInputStream input;
    private DataOutputStream output;
    private String clientName;
    private List<ClientHandler> clientList;  // Danh sách tất cả các client

    public ClientHandler(Socket socket, List<ClientHandler> clientList) {
        this.clientSocket = socket;
        this.clientList = clientList;
        try {
            input = new DataInputStream(clientSocket.getInputStream());
            output = new DataOutputStream(clientSocket.getOutputStream());

            // Nhận tên của client khi mới kết nối
            this.clientName = input.readUTF();
            broadcastMessage("Server: " + clientName + " đã tham gia.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        String message;
        try {
            while (true) {
                // Đọc tin nhắn từ client
                message = input.readUTF();
                broadcastMessage(clientName + ": " + message);  // Phát tin nhắn tới các client khác
            }
        } catch (IOException e) {
            System.out.println("Client " + clientName + " đã ngắt kết nối.");
        } finally {
            try {
                clientSocket.close();
                clientList.remove(this);
                broadcastMessage("Server: " + clientName + " đã rời đi.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Gửi tin nhắn tới tất cả các client
    private void broadcastMessage(String message) {
        for (ClientHandler client : clientList) {
            try {
                client.output.writeUTF(message);
                client.output.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}