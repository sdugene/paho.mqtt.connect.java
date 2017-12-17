package com.sdugene.paho.mqtt.connector;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

class Connection {

    private MemoryPersistence persistence = new MemoryPersistence();

    MqttClient connect(String broker, String clientId) throws MqttException
    {
        MqttClient client = new MqttClient(broker, clientId, persistence);

        MqttConnectOptions connOpts = new MqttConnectOptions();
        connOpts.setCleanSession(true);
        System.out.println("Connecting to broker: " + broker);
        client.connect(connOpts);

        return client;
    }
}
