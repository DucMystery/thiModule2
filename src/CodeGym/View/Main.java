package CodeGym.View;

import CodeGym.Client.Client;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Client client = new Client();
        client.menu();
        }
    }
