package jforgame.socket.codec;

import jforgame.socket.codec.protobuf.ProtobufMessageDecoder;
import jforgame.socket.codec.protobuf.ProtobufMessageEncoder;
import jforgame.socket.share.message.MessageCodecFactory;
import jforgame.socket.share.message.MessageFactory;

public class ProtobufPrivateProtocolCodec implements MessageCodecFactory {


    private MessageDecoder decoder;

    private MessageEncoder encoder;

    public ProtobufPrivateProtocolCodec(MessageFactory messageFactory) {
        this.decoder = new ProtobufMessageDecoder();
        this.encoder = new ProtobufMessageEncoder();
    }

    @Override
    public MessageDecoder getDecoder() {
        return decoder;
    }

    @Override
    public MessageEncoder getEncoder() {
        return encoder;
    }

}
