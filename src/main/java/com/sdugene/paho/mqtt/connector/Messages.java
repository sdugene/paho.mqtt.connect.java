package com.sdugene.paho.mqtt.connector;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

class Messages {
    private static final int DEFAULTQOS = 2;


    void publish(String topic, String message, MqttClient client) throws MqttException
    {
        MqttMessage mqttMessage = new MqttMessage(message.getBytes());
        mqttMessage.setQos(DEFAULTQOS);

        client.publish(topic, mqttMessage);
    }
}
