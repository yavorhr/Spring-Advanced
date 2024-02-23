/*
1. Application.yml settings -
    - Connection to DB
    - Multipart maximum size of files
    - mvc.hiddenmethod.filter.enabled: true - to be able to delete pictures from the DB
    - h2.console.enabled: true - virtual DB
    - cloudinary:
        api-key: 685653818151379
        api-secret: ${CLOUDINARY_API_SECRET}
        cloud-name: luchob

API-SECRET and all other password in GitHub must be hidden. This is so called "environment variable". When we are setting Spring projects,
we need to set such passwords as "environment variable".
Path : Edit configuration -> Environment -> Environment variable -> +

2. Create layers - PictureEntity and PictureRepository.

  Each picture should have :

  private Long id;
  private String title;
  private String url;
  private String publicId; The publicId is given from Cloudinary, when we upload a picture.

3. Create add and all.html files. Add.html will submit form with the uploaded file. All.html will return all pictures;

   In add.html :
      th:action="@{/pictures/add}"
      th:method="post"
      enctype="multipart/form-data">
   * enctype="multipart/form-data" is essential. It means that the form will not submit as usual with "post" method, but it's body will include a file as well.

4. PictureBindingModel

  private String title;
  private MultipartFile picture; MultipartFile is part of Spring frameWork; It will contain our picture;

5. Cloudinary library : implementation 'com.cloudinary:cloudinary:1.0.14'

6. CloudinaryService :

  CloudinaryImage upload(MultipartFile file) throws IOException;
  boolean delete(String publicId);

7. CloudinaryImage

  private String url;
  private String publicId;

8. Config - AppConfig and CloudinaryConfig.
AppConfig - expose the bean Cloudinary, which comes from com.cloudinary:cloudinary library. We need it to set our cloudinary options.
Cloudinary return Map. The keys and values should come from the application.yml file, which are the user cloud credentials.

  @Bean
  public Cloudinary cloudinary() {
    return new Cloudinary(
        Map.of(
            "cloud_name", config.getCloudName(),
            "api_key", config.getApiKey(),
            "api_secret", config.getApiSecret()
        )
    );


9. CloudinaryConfig

Uses import org.springframework.context.annotation.Configuration;
dependency - annotationProcessor "org.springframework.boot:spring-boot-configuration-processor"








* */