# Prueba Tecnica
### Descripcion
El presente repositorio contiene el desarrollo de una API-REST desarrollada en spring-boot con persistencia de informacion en una BD de postgresql. Los dos servicios, tanto el aplicativo en spring-boot y la BD, estan dockerizados por medio de docker-compose para una despliegue y ejecucion mas rapido.

Los endpoints/servicios expuestos en la API son los siguientes (Se anexan los cURL para que puedan ser ejecutados en POSTMAN):
- Obtener usuarios (GET): permite obtener todos los usuarios persistidos en el sistema.


    curl --location --request GET 'http://localhost:8080/user'
	


- Guardar usuario (POST): permite guardar un usuario nuevo en el sistema.


    curl --location --request POST 'http://localhost:8080/user' \
    --header 'Content-Type: application/json' \
    --data-raw '{
        "userId": "1",
        "name": "usuario1",
        "reviewCount": 1,
        "useful": 1,
        "funny": 1,
        "cool": 1,
        "fans": 1,
        "averageStarts": 1.1,
        "complimentHot": 1,
        "complimentMore": 1,
        "complimentProfile": 1,
        "complimentCute": 1,
        "complimentList": 1,
        "complimentNote": 1,
        "complimentPlain": 1,
        "complimentCool": 1,
        "complimentFunny": 1,
        "complimentWriter": 1,
        "complimentPhotos": 1,
        "friends": null,
        "yelpingSince": "2022-06-21"
    }'
	
	
Tener en cuenta que la aplicacion de spring-boot corre por el localhost:8080 y la BD por localhost:5432

### Intalacion
Para la instalacion o ejecucion del proyecto, es necesario tener descargado e instalado docker y docker-compose. En caso tal de requerir la instalacion se anexa [link para descargar e installar docker y docker compose](https://www.youtube.com/watch?v=--nuchgP6B4).

Una vez se tenga instalado todo lo necesario, simplemente es decargar/clonar el proyecto en una carpeta que se desee.

Por ultimo, abrir la terminal en el path de la carpeta donde se descargo el proyecto, y se debe ejecutar el siguiente comando:


    docker-compose up
	
	
Este comando se encarga de descargar lo necesario para la construccion y levantamiento de los dockers para ejecutar correctamente el proyecto.

### DEMO/Explicacion
[Se anexa link que contiene un video explicativo sobre el proyecto](https://drive.google.com/file/d/1j8zRkp8oCFiquiEhpznqFUo6DWOFJ6Tw/view?usp=sharing)
