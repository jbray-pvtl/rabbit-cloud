# rabbit-cloud
This is an example application which demonstrates how to build a queue provider using Spring Cloud Stream APIs.
## Application Components
- Source Interface:  The provider components consist of "Source" interface, which has at least on method signature that returns a MessageChannel.
- Component Class: The helper component class gets an instance of an implementation of the source interface, gets the MessageChannel instance using the method in the implementation, and calls the send method on that channel.
- Service Class:  The service class calls the helper component and can pass in a Message object, which is instantiates.  The service exposes a public send method.
- Message Class:  The message class implements the Message interface and provides the scaffolding for the message that will be sent to the queue.
- A RestController object is used to expose operations to invoke the send method on each service.

## Configuration
The application includes a `application.yml` file which is used to configure the channels and queues.  A snippet of this configuration file is shown below:

```$xslt
spring:
  cloud:
    stream:
      bindings:
        basicoutputchannel:
          destination: BasicQueue
          contentType: text/plain
          producer:
            requiredGroups: basic-group
        useroutputchannel:
          destination: UserQueue
          contentType: text/plain
          producer:
            requiredGroups: basic-group
```

## Source or provider interfaces
Each source interface includes at least one method which returns a `MessageChannel` object.  The methods which return the `MessageChannel` have an `@Output` annotation.  Each interface is bound using the `@EnableBinding`

## Pivotal Cloud Foundry Deployment
Build the project and deploy it.  This project includes a `manifest.yml` file so, `cf push` is all that is needed to deploy this application in a cloud foundry environment.

Here is a sample YAML manifest configuration:

```$xslt

applications:
- name: basic-queue
  memory: 1024M
  instances: 1
  path: target/rabbit-cloud-0.0.1-SNAPSHOT.jar
  buildpack: https://github.com/cloudfoundry/java-buildpack
  services:
  - rabbitmq-service-name
```

Here are the commands to build and push the application to cloud foundry.

```$xslt
mvn clean install

cf login

cf push
```