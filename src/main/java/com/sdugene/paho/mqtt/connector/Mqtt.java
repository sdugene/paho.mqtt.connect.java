package com.sdugene.paho.mqtt.connector;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;

public class Mqtt {

    private MqttClient mqttClient = null;
    private Connection connection = new Connection();
    private Messages messages = new Messages();

    public Mqtt connect() throws MqttException
    {
        mqttClient = connection.connect();
        return this;
    }

    public Mqtt publishMessage (String topic, String message) throws MqttException
    {
        if (mqttClient != null) {
            messages.publish(topic, message, mqttClient);
            return this;
        } else  {
            throw new MqttException(32102);
        }
    }

    public Mqtt disconnect () throws MqttException
    {
        mqttClient.disconnect();
        mqttClient = null;
        return this;
    }
}
