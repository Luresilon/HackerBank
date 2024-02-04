import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class TexttokClient {
    private Socket socket;
    private DataInputStream inputStream;
    private DataOutputStream outputStream;

    public TexttokClient(String serverAddress, int serverPort) {
        try {
            socket = new Socket(serverAddress, serverPort);
            inputStream = new DataInputStream(socket.getInputStream());
            outputStream = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendRequest(byte messageType, byte[] data) {
        try {
            // Construct and send the request
            if (data != null) {
                outputStream.writeByte(messageType);
                outputStream.write(data);
            } else {
                outputStream.writeByte(messageType);
            }

            // Receive and handle the response
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getRecentId() {
        sendRequest((byte) 1, null);

        try {
            // Receive and handle the response
            byte responseType = inputStream.readByte();
            if (responseType == 64) {
                return inputStream.readInt();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return -1;
    }

    public String getTox(int toxId) {
        try {
            // Construct and send the request
            outputStream.writeByte(2);
            outputStream.writeInt(toxId);
            outputStream.flush();

            // Receive and handle the response
            byte responseType = inputStream.readByte();
            if (responseType == 65) {
                int toxSize = inputStream.readInt();
                byte[] toxDataBytes = new byte[toxSize];
                inputStream.readFully(toxDataBytes);
                return new String(toxDataBytes, StandardCharsets.UTF_8);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public int rateTox(int toxId, int rating) {
        try {
            // Construct and send the request
            outputStream.writeByte(3);
            outputStream.writeInt(toxId);
            outputStream.writeByte(rating);
            outputStream.flush();

            // Receive and handle the response
            byte responseType = inputStream.readByte();
            if (responseType == 66) {
                return inputStream.readInt();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return -1;
    }

    public void close() {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Read server address and port from file
        try (BufferedReader reader = new BufferedReader(new FileReader("server-address.txt"))) {
            String[] addressAndPort = reader.readLine().split(":");
            String serverAddress = addressAndPort[0];
            int serverPort = Integer.parseInt(addressAndPort[1]);

            TexttokClient client = new TexttokClient(serverAddress, serverPort);

            // Example usage:
            int recentId = client.getRecentId();
            System.out.println("Recent Tox ID: " + recentId);

            String toxData = client.getTox(recentId);
            System.out.println("Tox Data: " + toxData);

            int newRating = client.rateTox(recentId, 1);
            System.out.println("New Tox Rating: " + newRating);

            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
