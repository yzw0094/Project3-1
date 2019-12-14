package Project3;

public interface INetworkAdapter {
    public String exchange(String msg, String host, int port) throws Exception;

    public MessageModel exchange(MessageModel msg, String host, int port) throws Exception;
}
