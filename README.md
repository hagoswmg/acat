# Getting Started

Clone this project, then import to your favourite IDE. Edit `application.properties` file and modify configuration parameters as needed. At the very least, you will need to provide database connection parameters.

You can deploy the application to a web container (tomcat) and access the end pointes described below


### API Endpoints

1. Actuator/Health Endpoint (__GET__ request)
    - URI: http://localhost:8090/actuator/health
    - response
        ```json
        {
          "status": "UP"
        }
        ```
2. Actual Config and Actual Trucks report  (__GET__ request)
    - URI: http://localhost:8090/acat or http://localhost:8090/acat?limit=false
    by default this call returns 20 rows. Run with __`limit=false`__ flag to retrieve all possible data.
    - Sample Response
        ```json
        [
          {
            "gpid": "884463830394",
            "artist": "Levan",
            "title": "Right On",
            "genre": "Dance",
            "explicit_rating": "No Advice Available",
            "type": "Single",
            "sub_type": "Single",
            "street_date": "2020-05-15T07:00:00.000+0000",
            "major_label": "Zebralution",
            "marketing_label": "Zebralution",
            "presentation_label": "Atlantic Records",
            "coverart_path": "placeholder for coverart path",
            "tracks": [
              {
                "track_number": 1,
                "track_title": "Right On",
                "isrc": "DEBA61600001",
                "audio_file": "placeholder for mp3 file",
                "audio_clip": "placeholder for mp3 clip"
              },
              {
                "track_number": 2,
                "track_title": "Right On (Central Avenue Vocal Mix)",
                "isrc": "DEBA61000080",
                "audio_file": "placeholder for mp3 file",
                "audio_clip": "placeholder for mp3 clip"
              },
              {
                "track_number": 3,
                "track_title": "Right On (Kuningas Remix)",
                "isrc": "DEBA61600002",
                "audio_file": "placeholder for mp3 file",
                "audio_clip": "placeholder for mp3 clip"
              },
              {
                "track_number": 4,
                "track_title": "Right On (Levan's Seaside Rework)",
                "isrc": "DEBA61600003",
                "audio_file": "placeholder for mp3 file",
                "audio_clip": "placeholder for mp3 clip"
              },
              {
                "track_number": 5,
                "track_title": "Right On (Central Avenue Dub)",
                "isrc": "DEBA61000084",
                "audio_file": "placeholder for mp3 file",
                "audio_clip": "placeholder for mp3 clip"
              }
            ]
          },
          {
            "gpid": "190295525248",
            "artist": "WEDNESDAY CAMPANELLA & yahyel",
            "title": "Survive Tokyo.",
            "genre": "J-Pop",
            "explicit_rating": "No Advice Available",
            "type": "Single",
            "sub_type": "Single",
            "street_date": "2020-05-15T07:00:00.000+0000",
            "major_label": "ADA US",
            "marketing_label": "WM Japan",
            "presentation_label": "143/Atlantic Entertainment",
            "coverart_path": "placeholder for coverart path",
            "tracks": [
              {
                "track_number": 1,
                "track_title": "Survive Tokyo.",
                "isrc": "JPWP01801429",
                "audio_file": "placeholder for mp3 file",
                "audio_clip": "placeholder for mp3 clip"
              }
            ]
          }
        ]
        ```
      
### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.2.7.RELEASE/maven-plugin/)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.3.0.RELEASE/reference/htmlsingle/#boot-features-developing-web-applications)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.3.0.RELEASE/reference/htmlsingle/#boot-features-jpa-and-spring-data)
* [Spring Boot Actuator](https://docs.spring.io/spring-boot/docs/2.3.0.RELEASE/reference/htmlsingle/#production-ready)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Building a RESTful Web Service with Spring Boot Actuator](https://spring.io/guides/gs/actuator-service/)