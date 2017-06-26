# SpringCloudConsulDiscoveryClient
This application will call person service with load balancing.please read readMe file for more details
First follow https://github.com/AnkushNakaskar/SpringCloudConsulClient
Then up this application with java -jar application as below

java -Dserver.port=9090 -Xms256m -Xmx1024m -jar build/libs/springCloudClient-1.0.0.jar --spring.config.location=build/app-classpath/spring-cloudClient.yml --logging.config=build/app-classpath/log4j2-spring.yml

Above code for first application.
I had run first register service with two different port number has seen on consul UI(http://localhost:8500/ui/#/dc1/services)
Then ran the current application which consume the first application. which is called service discovery.
If i make any one port down it will not hamper the UI response because it will fetch the available instance of first application.

Thanks,
Ankush
