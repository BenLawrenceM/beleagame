package com.benlawrencem.game.beleagame.net;

import com.benlawrencem.game.beleagame.net.messages.Message;
import com.benlawrencem.net.nightingale.ClientConnection;
import com.benlawrencem.net.nightingale.Packet.CouldNotSendPacketException;

public class PlayerMovementClient extends ClientConnection {
	public PlayerMovementClient() {}

	public void connect() {
		System.out.println("Attempting to connect to server...");
		try {
			connect("1.1.1.1", 9876);
		} catch (CouldNotConnectException e) {
			System.out.println("Could not connect: " + e.getMessage());
		}
	}

	public void disconnect() {
		disconnect();
	}

	public long getLatency() {
		return getLatency();
	}

	public void send(Message msg) {
		System.out.println("Sneding message: \"" + msg.encode() + "\"");
		try {
			send(msg.encode());
		} catch (CouldNotSendPacketException e) {
			System.out.println("Could not send message: " + e.getMessage());
		}
	}

	@Override
	protected void onConnected() {
		System.out.println("Connected!");
		send(Message.createIdRequestMessage());
	}

	@Override
	protected void onCouldNotConnect(String reason) {
		System.out.println("Could not connect: " +reason);
	}

	@Override
	protected void onDisconnected(String reason) {
		System.out.println("Disconnected: " +reason);
	}

	@Override
	protected void onReceive(String message) {
		System.out.println("Received message: \"" + message + "\"");
		Message msg = Message.parse(message);
		switch(msg.getType()) {
			case ID_RESPONSE:
				//TODO handle id
				break;
			case SPAWN:
				//TODO spawn entity
				break;
			case DESPAWN:
				//TODO despawn entity
				break;
			case MOVE:
				//TODO move entity
				break;
			case BUMP:
				//TODO bump entity back
				break;
			case SYNC:
				//TODO sync entity
				break;
		}
	}

	@Override
	protected void onMessageNotDelivered(int messageId, int resendMessageId, String message) {
		System.out.println("Message not delivered: \"" + message + "\" Resending...");
		try {
			resend(resendMessageId, message);
		} catch (CouldNotSendPacketException e) {
			System.out.println("Message could not be resent: " + e.getMessage());
		}
	}
}