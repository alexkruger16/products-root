Tener en cuenta lo siguiente:
El proyecto está pensado para desplegar como un war en un servidor externo apache tomcat
Por lo que al construir con **gradle init build** se generará un war

¿Que hacer para desplegar en un servidor externo como war?
Para desplegar en un servidor externo, por ejemplo JBoss se debe realizar los siguientes cambios
1. En el archivo adj-services/build.gradle cambiar las dependencias relacionas al tomcat a **providedRuntime** para evitar que 
estas dependencias se empaqueten en el war y entren en contradicción con el servidor externo
2. En el archivo adj-services/build.gradle cambiar _apply plugin: 'java'_ por _apply plugin: 'war_' para poder general un war
3. Adicional a los puntos anteriores si se desea que en el war no se incluyan las librerias de la base de datos de prueba h2, 
poner **providedRuntime** la libreria h2 en el archivo adj-services/build.gradle
4. Hay que tener en cuenta que si se despliega el proyecto como war en un servidor externo si no se especifica el profile spring boot tomará el por defecto.
Para especificar el profile en el servidor jboss, por ejemplo, se debe crear en el archivo: jboss-eap-7.1\standalone\configuration\standalone.xml
la propiedad del sistema (dentro de los tags: `<system-properties>...</system-properties>`) de la siguiente forma:
`<property name="spring.profiles.active" value="NOMBRE_PROFILE"/>`
