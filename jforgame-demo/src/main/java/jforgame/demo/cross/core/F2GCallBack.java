package jforgame.demo.cross.core;

import jforgame.demo.game.Modules;
import jforgame.demo.utils.JsonUtils;
import jforgame.socket.client.Traceable;
import jforgame.socket.share.annotation.MessageMeta;
import jforgame.socket.share.message.Message;

/**
 * 跨服回调响应方
 */
@MessageMeta(module = Modules.CROSS, cmd = CrossCommands.F2G_CALL_BACK)
public class F2GCallBack implements Message, Traceable {

    private int index;

    private String data;

    private String msgClass;

    public static F2GCallBack valueOf(Message message) {
        F2GCallBack response = new F2GCallBack();
        response.data = JsonUtils.object2String(message);
        response.msgClass = message.getClass().getName();

        return response;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMsgClass() {
        return msgClass;
    }

    public void setMsgClass(String msgClass) {
        this.msgClass = msgClass;
    }

    public Message getMessage() {
        try {
            return (Message) JsonUtils.string2Object(data, Class.forName(msgClass));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}