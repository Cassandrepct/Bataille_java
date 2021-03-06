package Client;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

public class ChatClient {

    public static void main(String [] args) {
        System.out.println("Connexion avec le serveur ...\n");
        try {
            new ChatClient("localhost", 8000).run();
        } catch (Exception e) {
            System.out.println("Echec de la connexion.\n");
            System.exit(84);
        }
    }

    private final String host;
    private final int port;

    public ChatClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void run() throws Exception {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap()
                    .group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ChatClientInitializer());
            Channel channel = bootstrap.connect(host, port).sync().channel();
            System.out.println("Connexion établie.");
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                channel.write(in.readLine() + "\r\n");
            }
        }
        finally {
            group.shutdownGracefully();
        }
    }
}
